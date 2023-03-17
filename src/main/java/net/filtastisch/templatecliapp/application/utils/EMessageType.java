package net.filtastisch.templatecliapp.application.utils;

public enum EMessageType {

    INFO(ANSICodes.WHITE + "Info: "),
    WARNING(ANSICodes.YELLOW_BRIGHT + "Warning: "),
    ERROR(ANSICodes.RED + "ERROR: "),
    FATAL(ANSICodes.RED_BOLD + "FATAL: "),
    DEBUG(ANSICodes.BLUE + "DEBUG: ");


    private final String content;
    EMessageType(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
