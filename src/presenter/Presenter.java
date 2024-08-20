package presenter;

import model.service.Service;
import view.View;

import javax.imageio.IIOException;
import java.io.IOException;


public class Presenter {
    private View view;
    private Service service;
    public Presenter(View view){
        this.view = view;
        this.service = new Service();
    }


    public void CommandNewPerson(String s)  {
     if (!service.addPersona(s)){
              view.start();
       }
    }

}
