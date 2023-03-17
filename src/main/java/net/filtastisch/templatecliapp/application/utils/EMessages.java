package net.filtastisch.templatecliapp.application.utils;

public enum EMessages {
    PREFIX(ANSICodes.CYAN_BRIGHT + "CLIApp" + ANSICodes.RESET + " | ");

    private final String content;

    EMessages(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
