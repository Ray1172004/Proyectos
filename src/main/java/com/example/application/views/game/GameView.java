package com.example.application.views.game;

import com.example.application.TicTacToeGame;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Game")
@Route(value = "Game", layout = MainLayout.class)
public class GameView extends VerticalLayout {

    private final TicTacToeGame ticTacToeGame = new TicTacToeGame();
    private Button[][] cellButtons = new Button[3][3];
    private TextField winnerTextField = new TextField("Ganador:");

    public GameView() {
        initializeGrid();
        setupLayout();
    }

    private void initializeGrid() {
        VerticalLayout gridLayout = new VerticalLayout();
        gridLayout.setWidth("min-content");
        gridLayout.setAlignItems(Alignment.CENTER);

        for (int row = 0; row < 3; row++) {
            HorizontalLayout buttonRow = new HorizontalLayout();
            buttonRow.setWidth("min-content");
            for (int col = 0; col < 3; col++) {
                Button cellButton = createCellButton(row, col);
                cellButtons[row][col] = cellButton;
                buttonRow.add(cellButton);
            }
            gridLayout.add(buttonRow);
        }

        add(new Hr());
        add(gridLayout);
        add(winnerTextField);
    }



    private VerticalLayout createGridSection(int start, int end) {
        VerticalLayout section = new VerticalLayout();
        section.setAlignItems(Alignment.CENTER);
        section.setWidth("min-content");

        for (int i = start; i < end; i++) {
            HorizontalLayout buttonRow = new HorizontalLayout();
            for (int j = 0; j < 3; j++) {
                Button cellButton = createCellButton(i, j);
                cellButtons[i][j] = cellButton;
                buttonRow.add(cellButton);
            }
            section.add(buttonRow);
        }

        return section;
    }



    private Button createCellButton(int row, int col) {
        Button button = new Button();
        button.setWidth("min-content");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.addClickListener(e -> handleCellButtonClick(row, col));
        return button;
    }

    private void handleCellButtonClick(int row, int col) {
        Button clickedButton = cellButtons[row][col];

        // Verifica si la celda ya está ocupada
        if (!clickedButton.getText().isEmpty()) {
            // La celda ya está ocupada, puedes mostrar un mensaje o simplemente ignorar el clic.
            return;
        }

        // Realiza la jugada en el modelo del juego
        ticTacToeGame.makeMove(row, col);

        // Obtén el símbolo del jugador actual (X o O)
        String currentPlayerSymbol = ticTacToeGame.getCurrentPlayerSymbol();

        // Establece el símbolo en la celda
        clickedButton.setText(currentPlayerSymbol);

        if (ticTacToeGame.isGameWon()) {
            showWinner(currentPlayerSymbol);
            // Puedes reiniciar el juego o realizar otras acciones después de que alguien gane.
            return;
        }

        // Verifica si el juego está en empate
        if (ticTacToeGame.isGameTie()) {
            showTie();
            // Puedes reiniciar el juego o realizar otras acciones después de un empate.
            return;
        }

        // Cambia al siguiente jugador
        ticTacToeGame.switchPlayer();
    }

    private void showWinner(String winnerSymbol) {
        // Actualiza el TextField con el símbolo del ganador
        winnerTextField.setValue("Ganador: " + winnerSymbol);

        // Deshabilita todos los botones después de que alguien gane
        disableCellButtons();
    }

    private void showTie() {
        winnerTextField.setValue("¡Empate!");

        // Deshabilita todos los botones después de un empate
        disableCellButtons();
    }

    private void disableCellButtons() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                cellButtons[row][col].setEnabled(false);
            }
        }
    }

    private void setupLayout() {
        setWidth("100%");
        setAlignItems(Alignment.CENTER);

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setWidthFull();
        horizontalLayout.setAlignItems(Alignment.CENTER);

        // Crea un componente vacío para hacer crecer flexiblemente el espacio a la izquierda
        VerticalLayout leftSpace = new VerticalLayout();
        leftSpace.setFlexGrow(1, leftSpace);
        horizontalLayout.add(leftSpace);

        // Agrega tu componente principal (formLayout3Col) al centro
        FormLayout formLayout3Col = new FormLayout();
        formLayout3Col.setWidth("100%");
        horizontalLayout.add(formLayout3Col);

        // Crea otro componente vacío para hacer crecer flexiblemente el espacio a la derecha
        VerticalLayout rightSpace = new VerticalLayout();
        rightSpace.setFlexGrow(1, rightSpace);
        horizontalLayout.add(rightSpace);

        // Agrega el botón de reinicio
        Button restartButton = new Button("Reiniciar");
        restartButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        restartButton.addClickListener(e -> restartGame());
        horizontalLayout.add(restartButton);

        add(horizontalLayout);
    }


    private void restartGame() {
        // Restablecer el modelo del juego
        ticTacToeGame.resetGame();

        // Limpiar los textos en los botones
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                cellButtons[row][col].setText("");
                cellButtons[row][col].setEnabled(true);
            }
        }

        // Limpiar el TextField
        winnerTextField.setValue("");
    }

}
