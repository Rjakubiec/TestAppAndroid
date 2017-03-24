package testapp.mytestapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.view.KeyEvent.KEYCODE_ENTER;

public class MainActivity extends AppCompatActivity {

    Button clickEvent;
    Button longClickEvent;
    Button onKeyTouch;
    EditText editText;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        clickEvent = (Button) findViewById(R.id.b1);
        clickEvent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                i++;
                Handler handler = new Handler();
                Runnable runn = new Runnable() {
                    @Override
                    public void run() {
                        i = 0;
                    }
                };
                if (i == 1) {
                    Toast.makeText(getBaseContext(), "One Click", Toast.LENGTH_LONG).show();
                    handler.postDelayed(runn,400);
                }
                else if (i == 2){
                    Toast.makeText(getBaseContext(), "Double Click", Toast.LENGTH_LONG).show();
                }
                else if (i == 3){
                    Toast.makeText(getBaseContext(), "Triple Click", Toast.LENGTH_LONG).show();
                    i = 0;
                }

            }
        });

        longClickEvent = (Button) findViewById(R.id.b2);
        longClickEvent.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View view){
                Toast.makeText(getBaseContext(), "Long Click", Toast.LENGTH_LONG).show();
                return true;
            }
        });

        onKeyTouch = (Button) findViewById(R.id.b3);
        onKeyTouch.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()== MotionEvent.ACTION_UP) {
                    Toast.makeText(getBaseContext(), onKeyTouch.getText(), Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

        editText = (EditText) findViewById(R.id.editText);
        editText.setOnKeyListener(new View.OnKeyListener(){

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (KEYCODE_ENTER == keyCode) {
                    Toast.makeText(getBaseContext(), editText.getText(), Toast.LENGTH_SHORT).show();

                    return true;
                }
                return false;
            }

        });

    }
}
