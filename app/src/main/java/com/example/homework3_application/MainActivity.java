package com.example.homework3_application;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String[] responses= {
            "you are amazing",
            "hello you",
            "today is your day",
            "how are you today",
            "get out from here",
            "what are you doing",
            "it is ok",
            "where are you now",
            "keep enjoying",
            "change your name"
    };
    int[]colors = {Color.BLACK, Color.RED, Color.BLUE};
    int counterColor =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText text1 = findViewById(R.id.textView1);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        TextView text2 = findViewById(R.id.textView2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rand = new Random();
                int randomText = rand.nextInt(responses.length);
                String userText = text1.getText().toString();
                text2.setText(responses[randomText]+" - " +userText);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(counterColor == colors.length-1)
                {
                    counterColor=0;
                }
                else {
                    counterColor++;
                }
                text2.setTextColor(colors[counterColor]);
            }
        }
        );
    }
}
    }
}