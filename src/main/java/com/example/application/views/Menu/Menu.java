package com.example.application.views.Menu;

import com.example.application.models.Partida;
import com.example.application.service.PartidaRepository;
import com.example.application.service.PlayerRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;

import java.util.Iterator;

@SpringComponent
@UIScope
@Route("")
public class Menu extends VerticalLayout {

    private final PlayerRepository userRepository;
    private final PartidaRepository partidaRepository;

    public Menu(PlayerRepository userRepository, PartidaRepository partidaRepository) {
        this.userRepository = userRepository;
        this.partidaRepository = partidaRepository;

        TextField usernameField = new TextField("Nombre de usuario");
        PasswordField passwordField = new PasswordField("Contraseña");
        Button createProfileButton = new Button("Crear perfil", e -> createProfile(usernameField.getValue(), passwordField.getValue()));

        TextField opponentField = new TextField("Nombre del oponente");
        Button startGameButton = new Button("Iniciar partida", e -> startGame(usernameField.getValue(), opponentField.getValue()));

        // Crear un Grid para mostrar información de los usuarios
        Grid<User> userGrid = new Grid<>(User.class);
        userGrid.setColumns("username", "password");
        userGrid.setItems(userRepository.findAll());

        add(usernameField, passwordField, createProfileButton, opponentField, startGameButton, userGrid);
    }

    private void createProfile(String username, String password) {
        if (!userRepository.findByUsername(username).stream()) {
            User user = new User() {
                @Override
                public boolean equals(Object another) {
                    return false;
                }

                @Override
                public String toString() {
                    return null;
                }

                @Override
                public int hashCode() {
                    return 0;
                }

                @Override
                public String getName() {
                    return null;
                }

                @Override
                public String getFullName() {
                    return null;
                }

                @Override
                public void setFullName(String s) {

                }

                @Override
                public Iterator<Group> getGroups() {
                    return null;
                }

                @Override
                public String getPassword() {
                    return null;
                }

                @Override
                public void setPassword(String s) {

                }

                @Override
                public Iterator<Role> getRoles() {
                    return null;
                }

                @Override
                public UserDatabase getUserDatabase() {
                    return null;
                }

                @Override
                public String getUsername() {
                    return null;
                }

                @Override
                public void setUsername(String s) {

                }

                @Override
                public void addGroup(Group group) {

                }

                @Override
                public void addRole(Role role) {

                }

                @Override
                public boolean isInGroup(Group group) {
                    return false;
                }

                @Override
                public boolean isInRole(Role role) {
                    return false;
                }

                @Override
                public void removeGroup(Group group) {

                }

                @Override
                public void removeGroups() {

                }

                @Override
                public void removeRole(Role role) {

                }

                @Override
                public void removeRoles() {

                }
            };
            user.setUsername(username);
            user.setPassword(password);
            userRepository.save(user);
            Notification.show("Perfil creado con éxito", 3000, Notification.Position.MIDDLE);
        } else {
            Notification.show("El nombre de usuario ya está en uso", 3000, Notification.Position.MIDDLE);
        }
    }

    private void startGame(String jugador1, String jugador2) {
        if (userRepository.findByUsername(jugador1).isEmpty() || userRepository.findByUsername(jugador2).isEmpty()) {
            Notification.show("Nombre de usuario no encontrado", 3000, Notification.Position.MIDDLE);
        } else {
            Partida partida = new Partida();
            partida.setJugador1(jugador1);
            partida.setJugador2(jugador2);
            partida.setTablero(new String[3][3]);
            partidaRepository.wait(partida);
            Notification.show("Partida iniciada con éxito", 3000, Notification.Position.MIDDLE);
        }
    }
}
