package com.packagename.myapp;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;

@Route("main")
public class MainPageView extends Div {

    public MainPageView() {
        initView();
    }

    public void initView() {
        VerticalLayout layout = new VerticalLayout();
        layout.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.STRETCH);
        H2 header = new H2("Welcome!");
        Button exit = new Button("Выйти");

        layout.add(header);
        layout.add(exit);

        exit.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {
                VaadinSession.getCurrent().close();
                exit.getUI().ifPresent(ui -> ui.navigate(""));
            }
        });

        add(layout);
    }

}
