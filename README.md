
# TemplateCLIApp

The TemplateCLIApp is a sample application that shows how to create a simple command line application in Java. It's a command based system where you can add custom commands.

#### Installation
To install the TemplateCLIApp you need to clone the source code repository from GitHub:


     git clone https://github.com/filtastisch/TemplateCLIApp.git


Make sure you have Git installed on your system before running this command.

### Usage
To create a new Command you have to implement `CommandExecutor`.
For example:

    public class TestCommand implements CommandExecutor {   
    @Override  
      public boolean onCommand(String command, String... args) {
       //do some fancy stuff
         return false;
      }  
    }

Now you have to register the Command in your Main Class, wich is called `TemplateCLIApp` by default, like this:

    this.getCommand("help").setExecutor(new HelpCommand());

