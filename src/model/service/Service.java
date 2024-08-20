package model.service;

import model.persona.Persona;
import model.persona.TestStringPersona;
import model.persona.jobfiles.FileHandler;
import model.persona.jobfiles.Writable;

import java.util.Iterator;
import java.util.List;

public class Service {
    private Persona persona = new Persona("new");
    private final TestStringPersona testStringPersona = new TestStringPersona();



    public Boolean addPersona(String s) {
        boolean chekedLastName = false;
        if (testStringPersona.splitString(s) == null ){
            System.out.println("Вы ввели меньше и больше данных, чем требуется.!");
        }
        else{
            if (testStringPersona.run(testStringPersona.splitString(s))){
                System.out.println("Введеные данные прошли проверку: ");
                //System.out.println(testStringPersona.splitString(s));
                System.out.println(persona.parcingData(testStringPersona.splitString(s)));
                List<String> listFiles = readListFile();
                for (String item : listFiles) {
                    if (item.equals(persona.getName() + ".txt")) {
                        chekedLastName = true;
                    }
                }
                save(persona.parcingData(testStringPersona.splitString(s)),chekedLastName);
                return true;
            }
        }
        return false;
    }

    private void save(String dataStr,Boolean append) {
        //System.out.println(pathDir+nameTree);
        Writable writable = new FileHandler();
        writable.save(dataStr,persona.getName(),append);
    }
    private List<String> readListFile() {
        //System.out.println(pathDir+nameTree);
        Writable writable = new FileHandler();
        return writable.readListFile();
    }
}
