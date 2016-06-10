package com.example.n2.playergui;

import java.io.Serializable;

/**
 * Created by 301968 on 6/7/2016.
 */
public class  Player implements Serializable{

    String name;
    String role;

    public Player(String newname, String newrole){
        name = newname;
        role = newrole;
    }

    public String getName(){
        return name;
    }

    public String getRole(){
        return role;
    }

    private void setRole(String newrole) {
        role = newrole;
    }
}
