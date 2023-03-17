package net.filtastisch.templatecliapp.application;

import net.filtastisch.templatecliapp.application.commandhandle.AppCommand;
import net.filtastisch.templatecliapp.application.commandhandle.CommandExecutor;
import net.filtastisch.templatecliapp.application.logger.Logger;

public abstract class CLIApplication implements CommandExecutor {

    public AppCommand getCommand(String name, String... aliases){
        return new AppCommand(name, aliases);
    }

    @Override
    public boolean onCommand(String command, String... args) {
        return false;
    }

    public Logger getLogger(){return new Logger();}

}
