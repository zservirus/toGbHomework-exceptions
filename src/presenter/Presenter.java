package presenter;

import model.service.Service;
import view.View;

import java.security.Provider;
import java.util.Map;

public class Presenter {
    private View view;
    private Service service;
    public Presenter(View view){
        this.view = view;
        this.service = new Service();
    }

    public void infoFalure(Map<String,String> falureList){
       view.printFalure(falureList);
    }

    public void CommandNewPerson(String s) {
      if (service.addPersona(s)  == false){
          view.start();
      }

      //this.service.save();
    }

}
