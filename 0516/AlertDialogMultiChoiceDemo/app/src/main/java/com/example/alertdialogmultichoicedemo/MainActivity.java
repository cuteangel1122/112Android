package com.example.alertdialogmultichoicedemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.pm.FeatureInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener ,DialogInterface.OnMultiChoiceClickListener{

    private String[] items = {"Samsung","OPPO","Apple","ASUS"};
    private boolean[] itemsChecked = {false,false,false,false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSelect = (Button) findViewById(R.id.btnSelect);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog build = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("請勾選選項?")
                        .setPositiveButton("確定",MainActivity.this)
                        .setNegativeButton("取消",MainActivity.this)
                        .setMultiChoiceItems(items,itemsChecked,MainActivity.this)
                        .show();
            }
        });
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        String msg = "";
        switch (which){
            case DialogInterface.BUTTON_POSITIVE:
                for (int index = 0; index < items.length; index++){
                    if(itemsChecked[index])
                        msg += items[index] + "\n";
                }
                TextView output = (TextView) findViewById(R.id.lblOutput);
                output.setText(msg);
                break;
            case DialogInterface.BUTTON_NEGATIVE:
                Toast.makeText(this,"按下取消鈕!",Toast.LENGTH_SHORT).show();
                break;
        }
    }
    @Override
    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
        Toast.makeText(MainActivity.this,items[which] + (isChecked?"勾選":"取消勾選"),Toast.LENGTH_SHORT).show();

    }
}