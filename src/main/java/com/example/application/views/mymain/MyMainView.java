package com.example.application.views.mymain;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

@PageTitle("My Main")
@Route(value = "my-main", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class MyMainView extends Composite<VerticalLayout> {

    public MyMainView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        H1 h1 = new H1();
        Hr hr = new Hr();
        H6 h6 = new H6();
        H6 h62 = new H6();
        VerticalLayout layoutColumn4 = new VerticalLayout();
        VerticalLayout layoutColumn3 = new VerticalLayout();
        H1 h12 = new H1();
        Hr hr2 = new Hr();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        FormLayout formLayout2Col = new FormLayout();
        FormLayout formLayout2Col2 = new FormLayout();
        Button buttonPrimary = new Button();
        Button buttonPrimary2 = new Button();
        Hr hr3 = new Hr();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        layoutColumn2.getStyle().set("flex-grow", "1");
        h1.setText("Creadores");
        h1.setWidth("max-content");
        h6.setText("Matheo Camacho");
        h6.setWidth("max-content");
        h62.setText("Kenji Morales");
        h62.setWidth("max-content");
        layoutColumn4.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutColumn4);
        layoutColumn4.setWidth("100%");
        layoutColumn4.getStyle().set("flex-grow", "1");
        layoutColumn3.setWidth("100%");
        layoutColumn3.getStyle().set("flex-grow", "1");
        h12.setText("X                       Tic Tac Toe                     O");
        h12.setWidth("740px");
        layoutRow2.setWidthFull();
        layoutColumn3.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        formLayout2Col.setWidth("100%");
        formLayout2Col2.setWidth("100%");
        buttonPrimary.setText("X");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary2.setText("O");
        buttonPrimary2.setWidth("min-content");
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(layoutRow);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(h1);
        layoutColumn2.add(hr);
        layoutColumn2.add(h6);
        layoutColumn2.add(h62);
        layoutColumn2.add(layoutColumn4);
        layoutRow.add(layoutColumn3);
        layoutColumn3.add(h12);
        layoutColumn3.add(hr2);
        layoutColumn3.add(layoutRow2);
        layoutRow2.add(formLayout2Col);
        formLayout2Col.add(formLayout2Col2);
        formLayout2Col2.add(buttonPrimary);
        formLayout2Col.add(buttonPrimary2);
        layoutColumn3.add(hr3);
    }
}
