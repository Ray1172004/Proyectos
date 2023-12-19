package com.example.application.views.estadisticas;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Estadisticas")
@Route(value = "Estadisticas", layout = MainLayout.class)
@Uses(Icon.class)
public class EstadisticasView extends Composite<VerticalLayout> {

    public EstadisticasView() {
        FormLayout formLayout2Col = new FormLayout();
        Icon icon = new Icon();
        Icon icon2 = new Icon();
        H1 h1 = new H1();
        H1 h12 = new H1();
        Hr hr = new Hr();
        FormLayout formLayout2Col2 = new FormLayout();
        NumberField numberField = new NumberField();
        NumberField numberField2 = new NumberField();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        formLayout2Col.setWidth("100%");
        icon.getElement().setAttribute("icon", "lumo:user");
        icon.getStyle().set("flex-grow", "1");
        icon2.getElement().setAttribute("icon", "lumo:user");
        h1.setText("Jugador x");
        h1.setWidth("max-content");
        h12.setText("Jugador O");
        h12.setWidth("max-content");
        formLayout2Col2.setWidth("100%");
        numberField.setLabel("Number field");
        numberField.setWidth("min-content");
        numberField2.setLabel("Number field");
        numberField2.setWidth("min-content");
        getContent().add(formLayout2Col);
        formLayout2Col.add(icon);
        formLayout2Col.add(icon2);
        formLayout2Col.add(h1);
        formLayout2Col.add(h12);
        getContent().add(hr);
        getContent().add(formLayout2Col2);
        formLayout2Col2.add(numberField);
        formLayout2Col2.add(numberField2);
    }
}
