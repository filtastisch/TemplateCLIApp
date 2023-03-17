package net.filtastisch.templatecliapp.application.commandhandle;

import lombok.Getter;

public abstract class Command {

    @Getter
    private final String command;
    @Getter
    private final String[] aliases;

    protected Command(String command, String[] aliases) {
        this.command = command;
        this.aliases = aliases;
    }

    public boolean hasAliases(){return aliases.length > 0;}

    public abstract void execute(String... args);

}
