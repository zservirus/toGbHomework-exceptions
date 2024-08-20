package view;

import java.util.Map;

public interface View {
    public void start();
    public default void printPersona(String answer){
        System.out.println(answer);
    }
    public default void printFalure(Map<String,String> answer){
        System.out.println(answer);
    }
}
