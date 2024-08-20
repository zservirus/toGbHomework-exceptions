package view;

import presenter.Presenter;
import view.menu.StartMenu;

import java.util.Map;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner ;
    private Presenter presenter;
    private boolean workMenuStart = true, workMenuEditTree = true, workMenuEditItemTree = true;
    private StartMenu startMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        startMenu = new StartMenu(this);
    }

    //private EditMenu editTreeMenu;

    @Override
    public void start() {
        while (workMenuStart) {
            System.out.println(startMenu.menu());
            String choice = scanner.nextLine();
            try {
                if ((Integer.parseInt(choice) >=1 ) && (Integer.parseInt(choice) <=2 )){
                    startMenu.run(Integer.parseInt(choice));
                }
            }catch (Exception e){

            }
            // while (workMenuEdit) {
               // System.out.println(editTreeMenu.menu());
               // String choiceEditTree = scanner.nextLine();
               // editTreeMenu.run(Integer.parseInt(choiceEditTree));
           // }
            //workMenuEditTree = true;
            //workMenuStart = true;
        }
    }

    public void finishMenuStart() {
        workMenuEditTree = false;
        workMenuStart = false;
        workMenuEditItemTree = false;
        System.out.println("--------Программа завершена!--------");

    }

    public void falureListinConsole(Map<String,String> falureList){
        for ( Map.Entry<String, String> entry : falureList.entrySet() ) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }

    @Override
    public void printPersona(String answer) {
        View.super.printPersona(answer);
    }


    public void CommandNewPerson() {
       System.out.print("Введите: \n\tФИО \n\tДату_рождения(формата dd.mm.yyyy)\n\tтелефон(формата 81234567890)\n\tпол(символ латиницей f или m.)\n\tкаждое поле вводить через пробел:");
       presenter.CommandNewPerson(scanner.nextLine());

    }

}
