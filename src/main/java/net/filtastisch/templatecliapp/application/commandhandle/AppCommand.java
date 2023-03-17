package net.filtastisch.templatecliapp.application.commandhandle;

import net.filtastisch.templatecliapp.TemplateCLIApp;

public class AppCommand extends Command{

    private CommandExecutor executor;
    private final String command;

    public AppCommand(String command, String[] aliases) {
        super(command, aliases);
        TemplateCLIApp.getInstance().getCommandManager().registerCommands(this);
        this.command = command;
    }

    public void setExecutor(CommandExecutor executor) {
        this.executor = executor;
    }

    public CommandExecutor getExecutor() {
        return executor;
    }

    @Override
    public void execute(String... args) {
        executor.onCommand(this.command, args);
    }

}
