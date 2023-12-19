package com.example.application.views.game;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("Game")
@Route(value = "Game", layout = MainLayout.class)
@Uses(Icon.class)
public class GameView extends Composite<VerticalLayout> {

    public GameView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        FormLayout formLayout2Col = new FormLayout();
        TextField textField = new TextField();
        TextField textField2 = new TextField();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        FormLayout formLayout3Col = new FormLayout();
        Button buttonPrimary = new Button();
        Button buttonPrimary2 = new Button();
        Button buttonPrimary3 = new Button();
        Button buttonPrimary4 = new Button();
        Button buttonPrimary5 = new Button();
        Button buttonPrimary6 = new Button();
        Button buttonPrimary7 = new Button();
        Button buttonPrimary8 = new Button();
        Button buttonPrimary9 = new Button();
        Hr hr = new Hr();
        TextField textField3 = new TextField();
        Button buttonPrimary10 = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        formLayout2Col.setWidth("100%");
        textField.setLabel("Turno X");
        textField.setWidth("min-content");
        textField2.setLabel("Turno de O");
        textField2.setWidth("min-content");
        layoutRow2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        formLayout3Col.setWidth("100%");
        formLayout3Col.setResponsiveSteps(new ResponsiveStep("0", 1), new ResponsiveStep("250px", 2),
                new ResponsiveStep("500px", 3));
        buttonPrimary.setText("Button");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary2.setText("Button");
        buttonPrimary2.setWidth("min-content");
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary3.setText("Button");
        buttonPrimary3.setWidth("min-content");
        buttonPrimary3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary4.setText("Button");
        buttonPrimary4.setWidth("min-content");
        buttonPrimary4.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary5.setText("Button");
        buttonPrimary5.setWidth("min-content");
        buttonPrimary5.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary6.setText("Button");
        buttonPrimary6.setWidth("min-content");
        buttonPrimary6.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary7.setText("Button");
        buttonPrimary7.setWidth("min-content");
        buttonPrimary7.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary8.setText("Button");
        buttonPrimary8.setWidth("min-content");
        buttonPrimary8.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary9.setText("Button");
        buttonPrimary9.setWidth("min-content");
        buttonPrimary9.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        textField3.setLabel("Ganador:");
        getContent().setAlignSelf(FlexComponent.Alignment.CENTER, textField3);
        textField3.setWidth("100%");
        textField3.setHeight("57px");
        buttonPrimary10.setText("Reiniciar");
        buttonPrimary10.setWidth("min-content");
        buttonPrimary10.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(layoutRow);
        layoutRow.add(formLayout2Col);
        formLayout2Col.add(textField);
        formLayout2Col.add(textField2);
        getContent().add(layoutRow2);
        layoutRow2.add(formLayout3Col);
        formLayout3Col.add(buttonPrimary);
        formLayout3Col.add(buttonPrimary2);
        formLayout3Col.add(buttonPrimary3);
        formLayout3Col.add(buttonPrimary4);
        formLayout3Col.add(buttonPrimary5);
        formLayout3Col.add(buttonPrimary6);
        formLayout3Col.add(buttonPrimary7);
        formLayout3Col.add(buttonPrimary8);
        formLayout3Col.add(buttonPrimary9);
        getContent().add(hr);
        getContent().add(textField3);
        getContent().add(buttonPrimary10);
    }
}
