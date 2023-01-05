package org.example.logic;

import org.example.data.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PonyClubTest {
    PonyClub ponyClub = new PonyClub();
    User user1 = new User("user1", LocalDate.now());
    User user2 = new User("user2", LocalDate.parse("2022-08-20"));
    Unicorn unicorn = new Unicorn("Uni", 1, new Coordinate(1,1));
    Pegasus highLevelPegasus = new Pegasus("Misty", 10, new Coordinate(2,2));

    @Test
    void getPoniesByPos() {
        user1.addPony(unicorn);
        ponyClub.addUser(user1);
        ponyClub.addUser(user2);
        List<Pony> poniesOnOneOne = ponyClub.getPoniesByPos(new Coordinate(1,1));
        assertEquals(2, poniesOnOneOne.size());
    }

    @Test
    void getUserWithHighestLevelPony() {
        user1.addPony(highLevelPegasus);
        ponyClub.addUser(user1);
        ponyClub.addUser(user2);
        User highestLevelUser = ponyClub.getUserWithHighestLevelPony();
        assertEquals("user1", highestLevelUser.getUserName());
    }

    @Test
    void useMagic() {
        user1.addPony(highLevelPegasus);
        ponyClub.addUser(user1);
        ponyClub.addUser(user2);
        SuperPony gifty = (SuperPony) ponyClub.getUserList().get(1).getPonyList().get(0);
        for (int i = 0; i < 10; i++) {
            gifty.magic();
        }
        User highestLevelUser = ponyClub.getUserWithHighestLevelPony();
        assertEquals("user2", highestLevelUser.getUserName());
    }
}