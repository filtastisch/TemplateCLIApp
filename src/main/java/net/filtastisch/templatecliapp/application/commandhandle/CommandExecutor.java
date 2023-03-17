package net.filtastisch.templatecliapp.application.commandhandle;

public interface CommandExecutor {

    boolean onCommand(String command, String... args);

}
