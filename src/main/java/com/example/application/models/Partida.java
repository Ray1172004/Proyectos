package com.example.application.models;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Partida {

    @Id
    private String players = "";

    @Indexed(name="Total de partidas",unique = true)
    private String PTotals = "";
    private String jugador1;
    private String jugador2;

    public Partida(){
    }

    public Partida(String players, String PTotals) {
        this.players = players;
        this.PTotals = PTotals;
    }

    public String getPlayers() {
        return players;
    }

    public void setPlayers(String players) {
        this.players = players;
    }

    public String getPTotals() {
        return PTotals;
    }

    public void setPTotals(String PTotals) {
        this.PTotals = PTotals;
    }

    public void setJugador1(String jugador1) {
        this.jugador1 = jugador1;
    }

    public String getJugador1() {
        return jugador1;
    }

    public void setJugador2(String jugador2) {
        this.jugador2 = jugador2;
    }

    public String getJugador2() {
        return jugador2;
    }

    public void setTablero(String[][] strings) {
    }
}

