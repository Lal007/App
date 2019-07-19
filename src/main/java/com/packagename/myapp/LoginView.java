package com.packagename.myapp;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class LoginView extends Div  {

    private LoginService back = LoginService.getInstance();
    private VerticalLayout loginLayout = new VerticalLayout();

    public LoginView() {

        TextField login = new TextField("Логин");
        login.getElement().setAttribute("id", "username");
        login.setAutofocus(true);
        PasswordField pass = new PasswordField("Пароль");
        Button enter = new Button("Войти");

        loginLayout.add(login);
        loginLayout.add(pass);
        loginLayout.add(enter);
        loginLayout.setAlignItems(FlexComponent.Alignment.CENTER);

        enter.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {

                if (back.isExist(login.getValue(), pass.getValue())){
                    showNotify("Выполнен вход");
                    back.addLoggedUser(login.getValue());
                    loginLayout.setVisible(false);
                    enter.getUI().ifPresent(ui -> ui.navigate(MainPageView.class));
                }else {
                    showNotify("Неправильный логин или пароль, попробуйте еще раз");
                    login.focus();
                }
            }
        });


        add(loginLayout);
    }

    public void showNotify(String msg){
        Notification notif = new Notification(msg, 1000);
        notif.setPosition(Notification.Position.TOP_STRETCH);
        notif.open();
    }
}
