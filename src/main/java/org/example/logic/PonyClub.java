package org.example.logic;

import org.example.data.Coordinate;
import org.example.data.Pony;
import org.example.data.SuperPony;
import org.example.data.User;

import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PonyClub {
    public static Month giftMonth = Month.AUGUST;
    private List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    public void addUser(User user) {
        if (user.getRegDate().getMonth().equals(giftMonth)) {
            user.addPony(new SuperPony("Gifty",1, new Coordinate(1,1)));
        }
        userList.add(user);
    }

    public List<Pony> getPoniesByPos(Coordinate coordinate) {
        List<Pony> poniesOnActualPos = new ArrayList<>();
        for (User user : userList) {
            for (Pony pony : user.getPonyList()) {
                if (pony.getPosition().x() == coordinate.x() && pony.getPosition().y() == coordinate.y()) {
                    poniesOnActualPos.add(pony);
                }
            }
        }
        return poniesOnActualPos;
    }

    public User getUserWithHighestLevelPony() {
        return userList.stream().max(Comparator.comparing(User::highestLevelPony)).orElseThrow();
    }
}
