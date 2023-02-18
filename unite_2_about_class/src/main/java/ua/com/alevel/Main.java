package ua.com.alevel;

public class Main {

    public static void main(String[] args) {
        UkrRoulette q1 = new UkrRoulette("5");
        UkrRoulette q2 = new UkrRoulette("4");
        UkrRoulette q3 = new UkrRoulette("3");
        UkrRoulette q4 = new UkrRoulette("2");
        UkrRoulette q5 = new UkrRoulette("1");

        {
            q1.sendMessage(q5);
            q2.sendMessage(q4);
            q3.sendMessage(q3);
            q4.sendMessage(q2);
            q5.sendMessage(q1);
        }
    }
}