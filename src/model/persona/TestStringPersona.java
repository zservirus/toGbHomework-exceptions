package model.persona;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;



public class TestStringPersona {
    Map<String, String> atributPerson= new HashMap<>();

    public TestStringPersona() {
        Map<String, String> atributPerson = new HashMap<>();
    }

    public Map<String, String> splitString (String str) {
        if (str != null) {
            String[] strWords = str.split(" ");
            if (strWords.length != 6) {
                  return null;
            }
            atributPerson.put("name", strWords[0]);
            atributPerson.put("lastNames", strWords[1]);
            atributPerson.put("patronymic", strWords[2]);
            atributPerson.put("birthday", strWords[3]);
            atributPerson.put("phoneNumber", strWords[4]);
            atributPerson.put("gender", strWords[5]);
            return atributPerson;
        }
        else{
            return null;
        }
    }

    public Boolean run(Map<String, String> atributPerson) {
        Map<String, String> testAtributPerson = testFormat(atributPerson);
        if (testAtributPerson==null) {
            return true;
        }
        else{
        System.out.println("Поля с ошибками: ");
            for (Map.Entry<String, String> entry : testFormat(atributPerson).entrySet()) {
                System.out.println(entry.getKey()+": "+entry.getValue()+" - (Неверный формат)");
                }
            return false;
        }

    }

    public boolean chekedFIO(String fio) {
        if (fio == null){
            return false;
        }
        char[] chars = fio.toCharArray();
        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }

        return true;
    }


    private Map<String,String> testFormat(Map<String,String> testDict){
        Map<String,String> chekedFalse = null;

        if (!chekedFIO(testDict.get("name")) ){
            if (chekedFalse == null) chekedFalse = new HashMap<>();
            chekedFalse.put("name",testDict.get("name"));
        }
        if (!chekedFIO(testDict.get("lastNames")) ){
            if (chekedFalse == null) chekedFalse = new HashMap<>();
            chekedFalse.put("lastNames",testDict.get("lastNames"));
        }
        if (!chekedFIO(testDict.get("patronymic")) ){
            if (chekedFalse == null) chekedFalse = new HashMap<>();
            chekedFalse.put("patronymic",testDict.get("patronymic"));
        }
        try {
            LocalDate date = LocalDate.parse(testDict.get("birthday"), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }catch (Exception e){
            if (chekedFalse == null) chekedFalse = new HashMap<>();
            chekedFalse.put("birthday",testDict.get("birthday"));
        }
        try {
            if (!((testDict.get("phoneNumber").toCharArray().length == 11) && (testDict.get("phoneNumber").toCharArray()[0] == '8') && (Long.parseLong(testDict.get("phoneNumber")) >= 0))) {
                if (chekedFalse == null) chekedFalse = new HashMap<>();
                chekedFalse.put("phoneNumber",testDict.get("phoneNumber"));
            }
        } catch (NumberFormatException e) {
            if (chekedFalse == null) chekedFalse = new HashMap<>();
            chekedFalse.put("phoneNumber",testDict.get("phoneNumber"));
        }

        if (testDict.get("gender").equals("m") || testDict.get("gender").equals("f")) {

        }else{
            if (chekedFalse == null) chekedFalse = new HashMap<>();
            chekedFalse.put("gender",testDict.get("gender"));
        }

        if (chekedFalse != null){
            return chekedFalse;
        }
        else{
            return   null;
        }

    }

}
