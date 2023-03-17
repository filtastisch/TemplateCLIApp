package net.filtastisch.templatecliapp.commands;

import net.filtastisch.templatecliapp.application.commandhandle.CommandExecutor;

public class StopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(String command, String... args) {
        System.exit(69);
        return false;
    }
}
