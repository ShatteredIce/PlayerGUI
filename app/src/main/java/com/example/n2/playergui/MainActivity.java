package com.example.n2.playergui;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.LinearLayout;
        import android.widget.RelativeLayout;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    private RelativeLayout mLayout;
    private EditText usernameInput;
    private LinearLayout column;
    Button addPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLayout = (RelativeLayout) findViewById(R.id.MainLayout);
        usernameInput = (EditText) findViewById(R.id.nameInput);
        column = (LinearLayout) findViewById(R.id.column);
        addPlayer = (Button)this.findViewById(R.id.button1);
        addPlayer.setOnClickListener(this);
    }

    public void onClick(View v){
        if(v.equals(addPlayer)){
            TextView newplayer = new TextView(this);
            newplayer.setText(usernameInput.getText());
            column.addView(newplayer);

        }
    }
}
