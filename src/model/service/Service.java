package model.service;

import model.persona.Persona;
import model.persona.TestStringPersona;
import model.persona.jobfiles.FileHandler;
import model.persona.jobfiles.Writable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Service {
    private Persona persona = new Persona("new");
    private TestStringPersona testStringPersona = new TestStringPersona();
    private String pathDir = "src/model/data/";
    private String nameTree = "new";

    public Boolean addPersona(String s) {
        Boolean chekedLastName = false;
        if (testStringPersona.splitString(s) == null ){
            System.out.println("Вы ввели меньше и больше данных, чем требуется.!");
        }
        else{
            if (testStringPersona.run(testStringPersona.splitString(s))){
                System.out.println("Введеные данные прошли проверку: ");
                //System.out.println(testStringPersona.splitString(s));
                System.out.println(persona.parcing(testStringPersona.splitString(s)));
                List<String> listFiles = readListFile();
                for (Iterator<String> i = listFiles.iterator(); i.hasNext();) {
                    String item = i.next();
                    if (item.equals(persona.getName() + ".txt")){
                        chekedLastName = true;
                    }
                }
                save(persona.parcing(testStringPersona.splitString(s)),chekedLastName);
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
