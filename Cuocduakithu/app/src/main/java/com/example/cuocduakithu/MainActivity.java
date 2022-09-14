package com.example.cuocduakithu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnPlay, btnReset;
    CheckBox cb1, cb2, cb3;
    SeekBar sb1, sb2, sb3;
    TextView txtTitle2, txtScore2;
    int diem = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();
        disableSB();
        checkCB();
        checkCB();

        btnPlay.setVisibility(View.INVISIBLE);
        btnReset.setVisibility(View.INVISIBLE);
        // Cho seebar chạy random
        CountDownTimer countDownTimer = new CountDownTimer(60000, 100) {
            @Override
            public void onTick(long l) {
                int number = 5;
                Random random = new Random();
                int s1 = random.nextInt(number);
                int s2 = random.nextInt(number);
                int s3 = random.nextInt(number);
                sb1.setProgress(sb1.getProgress() + s1);
                sb2.setProgress(sb2.getProgress() + s2);
                sb3.setProgress(sb3.getProgress() + s3);
                if(sb1.getProgress() >= sb1.getMax()){
                    this.cancel();
                    btnReset.setVisibility(View.VISIBLE);
                    if(cb1.isChecked()){
                        diem += 10;
                    }else{
                        diem -= 5;
                    }
                    txtScore2.setText(diem + "");
                    Toast.makeText(MainActivity.this, "S1 win", Toast.LENGTH_SHORT).show();
                }

                if(sb2.getProgress() >= sb2.getMax()) {
                    this.cancel();
                    btnReset.setVisibility(View.VISIBLE);
                    if(cb2.isChecked()){
                        diem += 10;
                    }else{
                        diem -= 5;
                    }
                    txtScore2.setText(diem + "");
                    Toast.makeText(MainActivity.this, "S2 win", Toast.LENGTH_SHORT).show();
                }

                if(sb3.getProgress() >= sb3.getMax()){
                    this.cancel();
                    btnReset.setVisibility(View.VISIBLE);
                    if(cb3.isChecked()){
                        diem += 10;
                    }else{
                        diem -= 5;
                    }
                    txtScore2.setText(diem + "");
                    Toast.makeText(MainActivity.this, "S3 win", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFinish() {

            }
        };
        // Ấn play
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                txtTitle2.setVisibility(View.INVISIBLE);
                sb1.setProgress(0);
                sb2.setProgress(0);
                sb3.setProgress(0);
                countDownTimer.start();
                disableCB();
                btnPlay.setVisibility(View.INVISIBLE);
            }
        });
        // Ấn reset
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnPlay.setVisibility(View.INVISIBLE);
                txtTitle2.setVisibility(View.VISIBLE);
                sb1.setProgress(0);
                sb2.setProgress(0);
                sb3.setProgress(0);
                enbleCB();
            }
        });
    }
    // Ánh xạ
    public void anhXa(){
        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);
        sb1 = (SeekBar) findViewById(R.id.see1);
        sb2 = (SeekBar) findViewById(R.id.see2);
        sb3 = (SeekBar) findViewById(R.id.see3);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnReset = (Button) findViewById(R.id.btnReset);
        txtTitle2 = (TextView) findViewById(R.id.txtTile2);
        txtScore2 = findViewById(R.id.txtScore2);

    }
    // Kiểm tra checkbox
    public void checkCB(){
        if(cb1.isChecked() == false && cb2.isChecked() == false && cb3.isChecked() == false){
            btnPlay.setVisibility(View.INVISIBLE);
        }
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    btnPlay.setVisibility(View.VISIBLE);
                    cb2.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){

                    btnPlay.setVisibility(View.VISIBLE);
                    cb1.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){

                    btnPlay.setVisibility(View.VISIBLE);
                    cb1.setChecked(false);
                    cb2.setChecked(false);
                }
            }
        });
    }
    // Cho phép ấn checkBox
    public void enbleCB(){
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
    }
    // Không cho phép ấn checkBox
    public void disableCB(){
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
    }
    // Không cho phép tác động seeBar
    public void disableSB(){
        sb1.setEnabled(false);
        sb2.setEnabled(false);
        sb3.setEnabled(false);
    }
    // Kiểm tra checkBox
    public void CheckCB(){
        if(cb1.isChecked() && cb2.isChecked() == false && cb3.isChecked() == false){
            btnPlay.setVisibility(View.INVISIBLE);
        }else{
            btnPlay.setVisibility(View.VISIBLE);

        }
    }
}