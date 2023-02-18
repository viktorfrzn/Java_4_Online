package ua.com.alevel;

public class UkrRoulette {

    public static String message;
    public static String newMessage = "";
    String name;

    UkrRoulette(String name, String message){
        this.name = name;
        this.message = message;
    }

    UkrRoulette(String name){
        this.name = name;
    }

    void sendMessage(UkrRoulette UkrRoulette){
        UkrRoulette.message = newMessage;
        System.out.println("Hello little boy!!!");
        System.out.println("1 2 3 4 5 YA IDU ISKAT ! ! !");
        System.out.println("5 4 3 2 1 HAHAHAHA YOU DIE ! ! !");
    }
}