package com.example.first;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HorizonActivity extends AppCompatActivity {
    private static int clickedBtn = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button[] btns = new Button[4];
        btns[0] = (Button) findViewById(R.id.btn1);
        btns[1] = (Button) findViewById(R.id.btn2);
        btns[2] = (Button) findViewById(R.id.btn3);
        btns[3] = (Button) findViewById(R.id.btn4);
        for(int i =0;i<btns.length;i++){
            btns[i].setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    for(int i =0;i<btns.length;i++){
                        if(view.getId()==btns[i].getId()){
                            Intent intent = new Intent(getApplicationContext(), ChangeActivity.class);
                            startActivity(intent);
                            clickedBtn = i;
                            break;
                        }
                    }
                    changeView();

                }
            });
        }
    }
    public static int getterClickedBtn(){
        return clickedBtn;
    }
    public void changeView(){
        FrameLayout frame = (FrameLayout) findViewById(R.id.frame);
        frame.removeViewAt(0);
    }
}
