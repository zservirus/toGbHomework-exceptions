
import model.service.Service;
import view.ConsoleUI;
import view.View;

public class Main {
    public static void main(String[] args) {
        System.out.println("База людей");

    View viewConsole = new ConsoleUI();
    Service service = new Service();
    viewConsole.start();
    }
}