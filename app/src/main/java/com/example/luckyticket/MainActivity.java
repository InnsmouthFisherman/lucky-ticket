package com.example.luckyticket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.random);
        Button result = findViewById(R.id.button);
        btn.setOnClickListener(random_listener);
        result.setOnClickListener(listener);
    }

    private final View.OnClickListener random_listener = view -> {
        double x = (Math.random()*((999999-100000)+1))+100000;
        int a = (int) x;
        EditText text = findViewById(R.id.token);
        text.setText(String.valueOf(a));
    };
    private final View.OnClickListener listener = view -> {
        EditText token = findViewById(R.id.token);
        String text = token.getText().toString();
        if (text.equals("")) {
            ;
        } else{
            int number = Integer.parseInt(text);
            int sum1 = (number / 100000) + (number % 100000 / 10000) + (number % 10000 / 1000);
            int sum2 = (number % 1000 / 100) + (number % 100 / 10) + (number % 10) ;

            if (sum1 == sum2) {
                TextView a = findViewById(R.id.textView);
                a.setText("Ваш билет счастливый");
            }else {
                while(true){
                    number++;
                    if (number == 999999){
                        TextView a = findViewById(R.id.textView);
                        a.setText("Ваш билет не счастливый, последний счастливый билет меньше введенного");
                    }
                    int s = (number / 100000) + (number % 100000 / 10000) + (number % 10000 / 1000);
                    int s_ = (number % 1000 / 100) + (number % 100 / 10) + (number % 10);
                    if(s == s_){
                        TextView a = findViewById(R.id.textView);
                        a.setText("Ваш билет не счастливый, следующий счастливый билет: " + number);
                        break;
                    }
                }
            }
        }
    };
}