package net.filtastisch.templatecliapp.application;

import net.filtastisch.templatecliapp.TemplateCLIApp;
import net.filtastisch.templatecliapp.application.utils.ECurrentState;
import net.filtastisch.templatecliapp.application.utils.EMessageType;

public class Main {
    public Thread commandSystem;
    private final TemplateCLIApp instance = TemplateCLIApp.getInstance();
    private ECurrentState state = instance.getState();

    public static void main(String[] args) {
        new Main().startAll();
    }

    public void startAll() {
        while (state == ECurrentState.STARTING) {
            this.instance.onEnable();
            this.instance.setState(ECurrentState.RUNNING);
            this.state = this.instance.getState();
        }

        this.startCommandSystem();
        this.loadShutDownHook();
    }

    public void startCommandSystem() {
        this.commandSystem = new Thread(instance.getCommandManager().reading(), "COMMAND");
        this.commandSystem.start();
    }

    public void loadShutDownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            this.instance.getConsoleManager().sendMessage("The App is stopping now!", EMessageType.INFO);
            this.commandSystem.interrupt();
            this.instance.onDisable();

            try {
                Thread.sleep(200);
            } catch (InterruptedException ignored) {
                this.instance.getConsoleManager().sendMessage("STOPPING WITHOUT SAVING", EMessageType.FATAL);
            }

        }));
    }

}
