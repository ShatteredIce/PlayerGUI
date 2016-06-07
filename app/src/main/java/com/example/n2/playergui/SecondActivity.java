package com.example.n2.playergui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by 301968 on 6/7/2016.
 */
public class SecondActivity extends Activity implements View.OnClickListener {

    Button quit;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout2);

        quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(this);

    }

    public void onClick(View v) {
        if(v.equals(quit)){
            startActivity(new Intent(SecondActivity.this, MainActivity.class));
        }
    }
}