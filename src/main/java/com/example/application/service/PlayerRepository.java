package com.example.application.service;

import com.example.application.models.Player;
import org.apache.catalina.User;

import java.util.Collection;

public interface PlayerRepository extends MngoRepository<Player,String>{
    Collection<Object> findByUsername(String jugador1);

    User findAll();

    default void save(User user) {

    }
}
