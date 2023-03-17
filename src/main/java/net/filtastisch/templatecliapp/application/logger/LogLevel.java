package net.filtastisch.templatecliapp.application.logger;

import lombok.Getter;
import net.filtastisch.templatecliapp.application.utils.EMessageType;

public enum LogLevel {

    INFO(EMessageType.INFO),
    ERROR(EMessageType.ERROR),
    DEBUG(EMessageType.DEBUG),
    WARNING(EMessageType.WARNING),
    FATAL(EMessageType.FATAL);

    @Getter
    private final EMessageType type;

    LogLevel(EMessageType type) {
        this.type = type;
    }
}
