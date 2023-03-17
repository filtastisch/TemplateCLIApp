package net.filtastisch.templatecliapp.application.logger;

import net.filtastisch.templatecliapp.TemplateCLIApp;

public class Logger {

    TemplateCLIApp instance = TemplateCLIApp.getInstance();

    public void info(String message){
        instance.getConsoleManager().sendMessage(message, LogLevel.INFO.getType());
    }

    public void error(String message){
        instance.getConsoleManager().sendMessage(message, LogLevel.ERROR.getType());
    }

    public void warning(String message){
        instance.getConsoleManager().sendMessage(message, LogLevel.WARNING.getType());
    }

    public void debug(String message){
        instance.getConsoleManager().sendMessage(message, LogLevel.DEBUG.getType());
    }

    public void fatal(String message){
        instance.getConsoleManager().sendMessage(message, LogLevel.FATAL.getType());
    }

    public void log(LogLevel level, String message){
        instance.getConsoleManager().sendMessage(message, level.getType());
    }

}
