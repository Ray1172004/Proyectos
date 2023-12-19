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

        H2 title = new H2("Tic Tac Toe");
        title.getStyle().set("margin-bottom", "20px");

        VerticalLayout contentLayout = new VerticalLayout();
        contentLayout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        contentLayout.setSpacing(true);

        Button chooseXButton = new Button("Jugar con X");
        chooseXButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        chooseXButton.addClickListener(e -> startGameWithSymbol("O"));

        Button chooseOButton = new Button("Jugar con O");
        chooseOButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        chooseOButton.addClickListener(e -> startGameWithSymbol("X"));

        contentLayout.add(chooseXButton, chooseOButton);

        // Agrega el texto "Escoger jugador"
        contentLayout.add("Escoger jugador");

        add(title, contentLayout);
    }

    private void startGameWithSymbol(String symbol) {
        // Abre la vista del juego (GameView) con el símbolo seleccionado
        getUI().ifPresent(ui -> ui.navigate(GameView.class, symbol));
    }

}
