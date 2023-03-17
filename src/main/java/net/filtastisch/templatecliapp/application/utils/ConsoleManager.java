package net.filtastisch.templatecliapp.application.utils;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.nio.charset.StandardCharsets;

public class ConsoleManager {

    public LineReader createLineReader() {
        try {
            Terminal terminal = TerminalBuilder
                    .builder()
                    .system(true)
                    .streams(System.in, System.out)
                    .encoding(StandardCharsets.UTF_8)
                    .dumb(true).build();


            return LineReaderBuilder.builder().terminal(terminal)
                    .option(LineReader.Option.DISABLE_EVENT_EXPANSION, true)
                    .option(LineReader.Option.AUTO_REMOVE_SLASH, true)
                    .option(LineReader.Option.INSERT_TAB, true).build();
        } catch (Exception ignored) {
        }
        return null;
    }

    public void sendMessage(String message, EMessageType type){
        System.out.println(EMessages.PREFIX.getContent() + type.getContent() + message + ANSICodes.RESET);
    }

}
