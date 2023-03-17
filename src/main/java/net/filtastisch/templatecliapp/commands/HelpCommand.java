package net.filtastisch.templatecliapp.commands;

import net.filtastisch.templatecliapp.TemplateCLIApp;
import net.filtastisch.templatecliapp.application.commandhandle.CommandExecutor;

public class HelpCommand implements CommandExecutor {

    private final TemplateCLIApp instance = TemplateCLIApp.getInstance();

    @Override
    public boolean onCommand(String command, String... args) {
        if (args.length == 0) {
            instance.getLogger().info("Help command");
        }
        return false;
    }
}
