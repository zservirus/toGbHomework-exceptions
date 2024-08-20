package view.menu;

import view.ConsoleUI;
import view.command.Command;
import view.command.startMenu.CommandFinal;
import view.command.startMenu.CommandNewPerson;

import java.util.ArrayList;
import java.util.List;

public class StartMenu {
    private List<Command> commands;
    public StartMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new CommandNewPerson(consoleUI));
        commands.add(new CommandFinal(consoleUI));

        //commands.add());
        //commands.add());

    }
    public String menu(){
        System.out.println("\n");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-=Стартовое меню=-\n");

        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(Integer.parseInt(String.valueOf(i+1)) +":"+commands.get(i).getName()+"\n");
        }
        stringBuilder.append("Выберите варианты действий:");
        return stringBuilder.toString();
    }
    public List<String> printStartCommand(){
        List<String> listCommand = new ArrayList<>();
        for (int i = 0; i < commands.size(); i++){
            listCommand.add(Integer.parseInt(String.valueOf(i+1)) +":"+commands.get(i).getName());
        }
        return listCommand;
    }
    public void run(int choice){
        Command command = commands.get(choice-1);
        command.run();


    }
}
