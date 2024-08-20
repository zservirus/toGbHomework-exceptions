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
    public String parcing (Map<String,String> data_person){
        this.name = data_person.get("name");
        this.lastNames = data_person.get("lastNames");
        this.patronymic = data_person.get("patronymic");
        this.birthday = LocalDate.parse(data_person.get("birthday"),  DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        this.phoneNumber = data_person.get("phoneNumber");
        this.gender = data_person.get("gender").charAt(0);
        String string = "<"+name+"><"+lastNames+"><"+patronymic+"><"+birthday.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))+"><"+phoneNumber+"><"+gender+">\n";
        return string;

    }
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private String getLastNames() {
        return lastNames;
    }

    private void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    private String getPatronymic() {
        return patronymic;
    }

    private void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    private LocalDate getBirthday() {
        return birthday;
    }

    private void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    private String getPhoneNumber() {
        return phoneNumber;
    }

    private void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private char getGender() {
        return gender;
    }

    private void setGender(char gender) {
        this.gender = gender;
    }
}
