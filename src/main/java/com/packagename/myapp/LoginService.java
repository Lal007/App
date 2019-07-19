package com.packagename.myapp;

import java.util.HashMap;
import java.util.Vector;

public class LoginService {

    private static LoginService instance = null;
    private Vector<String> logged = new Vector<>();
    private static HashMap<String, String> users = new HashMap<>();

    static {
        users.put("user", "111111");
    }

    private LoginService() {
    }

    public boolean isExist(String login, String pass){
        return users.get(login).equals(pass);
    }

    public boolean isLogged(String user){
        return logged.contains(user);
    }

    public void addLoggedUser(String s){
        logged.add(s);
    }

    public void removeFromLogged(String s){
        logged.remove(s);
    }

    public static LoginService getInstance(){
        if (instance == null){
            instance = new LoginService();
        }
        return instance;
    }

}
