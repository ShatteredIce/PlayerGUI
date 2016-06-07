package com.example.n2.playergui;

        import android.app.Activity;
        import android.os.Bundle;
        import android.view.Gravity;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.LinearLayout;
        import android.widget.RelativeLayout;
        import android.widget.Spinner;
        import android.widget.TextView;

        import java.util.ArrayList;

public class MainActivity extends Activity implements  View.OnClickListener {

    private RelativeLayout mLayout;
    private EditText usernameInput;
    private LinearLayout column;
    private TextView numPlayers;
    Button addPlayer;
    Button start;
    String[] roles = {"Mario","Luigi","MLG","Ghost","Solid Snake"};
    ArrayList<String> players = new ArrayList<String>();
    int maxPlayers = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLayout = (RelativeLayout) findViewById(R.id.MainLayout);
        usernameInput = (EditText) findViewById(R.id.nameInput);
        column = (LinearLayout) findViewById(R.id.column);
        numPlayers = (TextView)this.findViewById(R.id.textView2);
        addPlayer = (Button)this.findViewById(R.id.button1);
        addPlayer.setOnClickListener(this);
        start = (Button)this.findViewById(R.id.button2);
        start.setOnClickListener(this);
    }

    public void onClick(View v){
        if(v.equals(addPlayer)){
            if(!players.contains(usernameInput.getText().toString())&&!usernameInput.getText().toString().trim().equals("") && players.size() < maxPlayers){
                usernameInput.setText(usernameInput.getText().toString().trim());
                addNewPlayer();
                players.add(usernameInput.getText().toString());
                usernameInput.setText("");
                numPlayers.setText(" "+players.size());
            }
        }
    }

    public void addNewPlayer(){

        LinearLayout newline = new LinearLayout(this);
        newline.setOrientation(LinearLayout.HORIZONTAL);
        newline.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        newline.setGravity(Gravity.END);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.gravity = Gravity.START|Gravity.CENTER;
        params.weight = 1;

        LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        TextView playerName = new TextView(this);
        playerName.setText(usernameInput.getText());
        playerName.setTextSize(16);
        playerName.setLayoutParams(params);
        newline.addView(playerName);

        Spinner playerRole = new Spinner(this);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item, roles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        playerRole.setAdapter(adapter);
        playerRole.setLayoutParams(params2);
        newline.addView(playerRole);

        Button deleteLine = new Button(this);
        deleteLine.setLayoutParams(params2);
        deleteLine.setText("Delete");
        deleteLine.setOnClickListener(delete(deleteLine, newline, playerName));
        newline.addView(deleteLine);


        column.addView(newline);

    }

    View.OnClickListener delete(final Button button, final LinearLayout line, final TextView name)  {
        return new View.OnClickListener() {
            public void onClick(View v) {
                players.remove(name.getText().toString());
                column.removeView(line);
                numPlayers.setText(" "+players.size());
            }
        };
    }
}
