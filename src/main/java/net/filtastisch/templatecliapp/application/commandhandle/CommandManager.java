package net.filtastisch.templatecliapp.application.commandhandle;

import lombok.Getter;
import net.filtastisch.templatecliapp.TemplateCLIApp;
import net.filtastisch.templatecliapp.application.utils.EMessageType;
import net.filtastisch.templatecliapp.application.utils.EMessages;
import org.jline.reader.LineReader;
import org.jline.reader.UserInterruptException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommandManager {

    private final TemplateCLIApp instance = TemplateCLIApp.getInstance();
    public static List<String> args = new ArrayList<>();

    @Getter
    private final HashMap<String, Command> commandHashMap = new HashMap<>();


    public void registerCommands(Command command) {
        commandHashMap.put(command.getCommand().toLowerCase(), command);

        if (command.getAliases() == null) return;
        for (String c : command.getAliases()) {
            commandHashMap.put(c.toLowerCase(), command);
        }

    }

    public Runnable reading() {
        return () -> {
            LineReader lineReader = instance.getConsoleManager().createLineReader();
            while (true) {
                try {
                    String cmd;
                    String[] input;

                    cmd = lineReader.readLine(EMessages.PREFIX.getContent());
                    input = cmd.split(" ");
                    if (commandHashMap.containsKey(input[0].toLowerCase())) {
                        for (String c : input) {
                            if (!c.equalsIgnoreCase(input[0])) {
                                args.add(c);
                            }
                        }
                        commandHashMap.get(input[0].toLowerCase()).execute(args.toArray(new String[0]));

                    } else {
                        instance.getConsoleManager().sendMessage("Command " + input[0] + " could not be found! Please Type 'help' to see all commands!", EMessageType.WARNING);
                    }
                } catch (UserInterruptException ignored) {
                    System.out.println(EMessageType.FATAL.getContent() + "STOPPING WITHOUT SAVING!");
                }
            }
        };
    }

}
