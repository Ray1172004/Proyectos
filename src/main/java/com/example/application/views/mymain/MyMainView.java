package com.example.application.views.mymain;

import com.example.application.views.game.GameView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Tic Tac Toe")
@Route(value = "my-main-view")
public class MyMainView extends VerticalLayout {

    public MyMainView() {
        Button chooseXButton = new Button("Jugar con X");
        chooseXButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        chooseXButton.addClickListener(e -> startGameWithSymbol("O"));

        Button chooseOButton = new Button("Jugar con O");
        chooseOButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        chooseOButton.addClickListener(e -> startGameWithSymbol("X"));

        add(chooseXButton, chooseOButton);
    }

    private void startGameWithSymbol(String symbol) {
        // Abre la vista del juego (GameView) con el símbolo seleccionado
        getUI().ifPresent(ui -> ui.navigate(GameView.class, symbol));
    }
}
