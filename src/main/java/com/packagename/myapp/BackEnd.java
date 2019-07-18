package com.packagename.myapp;

import java.util.HashMap;
import java.util.Vector;

public class BackEnd {

    private static BackEnd instance = null;
    private Vector<String> logged = new Vector<>();
    private static HashMap<String, String> users = new HashMap<>();

    static {
        users.put("user", "111111");
    }

    private BackEnd() {
    }

    public boolean isExist(String login, String pass){
        if (users.containsKey(login) && users.containsValue(pass)){
            return true;
        }else {
            return false;
        }
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

    public static BackEnd getInstance(){
        if (instance == null){
            instance = new BackEnd();
        }
        return instance;
    }

}
