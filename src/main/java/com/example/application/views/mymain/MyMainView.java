package com.example.application.views.mymain;

import com.example.application.views.MainLayout;
import com.example.application.views.game.GameView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Tic Tac Toe")
public class MyMainView extends VerticalLayout {

    public MyMainView() {
        setAlignItems(Alignment.CENTER); // Alinea los elementos verticalmente en el centro
        setJustifyContentMode(JustifyContentMode.CENTER); // Centra los elementos horizontalmente

        H2 titulo = new H2("Tic Tac Toe");
        titulo.getStyle().set("margin-bottom", "20px");

        VerticalLayout contentLayout = new VerticalLayout();
        contentLayout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        contentLayout.setSpacing(true);

        Button escogerX = new Button("Jugar con X");
        escogerX.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        escogerX.addClickListener(e -> empezarJuegoSimbolo("O"));

        Button escogerO = new Button("Jugar con O");
        escogerO.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        escogerO.addClickListener(e -> empezarJuegoSimbolo("X"));

        contentLayout.add(escogerX, escogerO);

        // Agrega el texto "Escoger jugador"
        contentLayout.add("Escoger jugador");

        add(titulo, contentLayout);
    }

    private void empezarJuegoSimbolo(String simbolo) {
        // Abre la vista del juego (GameView) con el símbolo seleccionado
        getUI().ifPresent(ui -> ui.navigate(GameView.class, simbolo));
    }

}
