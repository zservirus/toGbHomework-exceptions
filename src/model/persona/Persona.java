package model.persona;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Persona {
    private String name;
    private String lastNames;
    private String patronymic;
    private LocalDate birthday;
    private String phoneNumber;
    private  char gender;

    public Persona(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "persona{" +
                "name='" + name + '\'' +
                ", lastNames='" + lastNames + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                ", phoneNumber=" + phoneNumber +
                ", gender=" + gender +
                '}';
    }
    public String parcingData(Map<String,String> data_person){
        this.name = data_person.get("name");
        this.lastNames = data_person.get("lastNames");
        this.patronymic = data_person.get("patronymic");
        this.birthday = LocalDate.parse(data_person.get("birthday"),  DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        this.phoneNumber = data_person.get("phoneNumber");
        this.gender = data_person.get("gender").charAt(0);
        return "<"+name+"><"+lastNames+"><"+patronymic+"><"+birthday.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))+"><"+phoneNumber+"><"+gender+">\n";

    }
    public String getName() {
        return name;
    }

}
