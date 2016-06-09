package com.example.n2.playergui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.LineNumberReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by 301968 on 6/7/2016.
 */
public class SecondActivity extends Activity implements View.OnClickListener {

    Button quit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);

        RelativeLayout screen = (RelativeLayout)findViewById(R.id.secondScreen);
        TextView header = (TextView)findViewById(R.id.textView1);
        quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(this);

        Intent i = getIntent();
        // Receiving the Data
        ArrayList<Player> players = (ArrayList<Player>) i.getSerializableExtra("playerList");

        LinearLayout buttonLine = new LinearLayout(this);
        LinearLayout currentLine = buttonLine;
        buttonLine.setOrientation(LinearLayout.HORIZONTAL);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW, header.getId());
        buttonLine.setLayoutParams(params);
        LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        for(int a=0; a < players.size(); a++){
            Button playerButton = new Button(this);
            playerButton.setLayoutParams(buttonParams);
            playerButton.setText(players.get(a).getName());
            buttonLine.addView(currentLine);
            if(a%2 == 1){

                LinearLayout newLine = new LinearLayout(this);
                newLine.setLayoutParams(params);
                currentLine = newLine;
            }
            screen.addView(currentLine);
        }


    }

    public void onClick(View v) {
        if(v.equals(quit)){
            startActivity(new Intent(SecondActivity.this, MainActivity.class));
        }
    }
}