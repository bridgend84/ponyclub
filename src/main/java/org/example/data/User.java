package org.example.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class User {
    private String userName;
    private LocalDate regDate;
    private List<Pony> ponyList = new ArrayList<>();

    public User(String userName, LocalDate regDate) {
        this.userName = userName;
        this.regDate = regDate;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public List<Pony> getPonyList() {
        return ponyList;
    }

    public void addPony(Pony pony) {
        ponyList.add(pony);
    }

    public int highestLevelPony() {
        return ponyList.stream().max(Comparator.comparing(Pony::getXp)).orElseThrow().getXp();
    }
}
