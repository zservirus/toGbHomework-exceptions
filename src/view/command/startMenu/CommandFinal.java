package view.command.startMenu;

import view.ConsoleUI;
import view.command.Command;

public class CommandFinal extends Command {
    public CommandFinal(ConsoleUI consoleUI) {
        super("Выход из программы", consoleUI);
    }
    @Override
    public void run() {
        getConsoleUI().finishMenuStart();
    }

}
