package com.example.n2.playergui;

import android.widget.TextView;
import android.widget.Spinner;

/**
 * Created by 301968 on 6/7/2016.
 */
public class Player {

    String name;
    String role;
    Spinner myRole;

    public Player(TextView newName, Spinner newSpinner){
        name = newName.getText().toString();
        myRole = newSpinner;
        role = "Villager";
    }

    private void setRole(){
        role = myRole.getSelectedItem().toString();
    }
}
