package ua.com.alevel;

import java.lang.*;

public class Student {
    private String name;
    private String email;
    private String githubAcc;
    private String telegramAcc;

    private Object something;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGithubAcc() {
        return githubAcc;
    }

    public String getTelegramAcc() {
        return telegramAcc;
    }

    public void setName(String name) {
        if (name.matches(".*\\d.*")) {
            System.out.println("you stupid");
        } else {
            this.name = name;
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGithubAcc(String githubAcc) {
        this.githubAcc = githubAcc;
    }

    public void setTelegramAcc(String telegramAcc) {
        this.telegramAcc = telegramAcc;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", githubAcc='" + githubAcc + '\'' +
                ", telegramAcc='" + telegramAcc + '\'' +
                ", something=" + something +
                '}';
    }
}
