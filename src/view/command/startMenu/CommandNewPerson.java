package view.command.startMenu;

import view.ConsoleUI;
import view.command.Command;

public class CommandNewPerson extends Command {
    public CommandNewPerson(ConsoleUI consoleUI) {
        super("Добавить новую запись", consoleUI);
    }

    @Override
    public void run() {
        getConsoleUI().CommandNewPerson();
    }

}

