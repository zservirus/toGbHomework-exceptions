package view;

import java.util.Map;

public interface View {
    void start();
    default void printPersona(String answer){
        System.out.println(answer);
    }
    default void printFalure(Map<String,String> answer){
        System.out.println(answer);
    }
}
