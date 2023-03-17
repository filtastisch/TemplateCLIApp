package net.filtastisch.templatecliapp;

import lombok.Getter;
import lombok.Setter;
import net.filtastisch.templatecliapp.application.CLIApplication;
import net.filtastisch.templatecliapp.application.commandhandle.CommandManager;
import net.filtastisch.templatecliapp.application.utils.*;
import net.filtastisch.templatecliapp.commands.*;

public class TemplateCLIApp extends CLIApplication {

    @Getter
    @Setter
    private ConsoleManager consoleManager;
    @Getter
    @Setter
    private CommandManager commandManager;
    @Getter
    public static TemplateCLIApp instance = new TemplateCLIApp();
    @Getter
    @Setter
    private ECurrentState state = ECurrentState.STARTING;

    public void onEnable() {
        this.registerManager();
        this.registerCommands();
    }

    public void onDisable() {
    }

    public void registerManager() {
        this.consoleManager = new ConsoleManager();
        this.commandManager = new CommandManager();
    }

    public void registerCommands() {
        this.getCommand("help").setExecutor(new HelpCommand());
        this.getCommand("stop").setExecutor(new StopCommand());
    }

}