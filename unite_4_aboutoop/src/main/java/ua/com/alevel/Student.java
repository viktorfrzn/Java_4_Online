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
        this.name = name;
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
}
