package com.example.n2.playergui;

import android.widget.TextView;
import android.widget.Spinner;

import java.io.Serializable;

/**
 * Created by 301968 on 6/7/2016.
 */
public class PlayerSetup {

    String name;
    String role;
    Spinner myRole;

    public PlayerSetup(TextView newName, Spinner newSpinner){
        name = newName.getText().toString();
        myRole = newSpinner;
        role = "Villager";
    }

    public String getName(){
        return name;
    }

    public String getRole(){
        return role;
    }

    public void setRole() {
        role = myRole.getSelectedItem().toString();
    }
}
