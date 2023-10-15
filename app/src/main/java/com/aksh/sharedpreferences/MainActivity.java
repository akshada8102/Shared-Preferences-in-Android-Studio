package com.aksh.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.aksh.sharedpreferences.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding bind;
    public final  String name="akshada";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        bind= DataBindingUtil.setContentView(this,R.layout.activity_main);
        bind.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message=bind.editTextText.getText().toString().trim();
                SharedPreferences sp=getSharedPreferences(name,MODE_PRIVATE);
                SharedPreferences.Editor se=sp.edit();
                se.putString("msg",message);
                se.apply();


            }
        });
        SharedPreferences sp=getSharedPreferences(name,MODE_PRIVATE);
    String ak=sp.getString("msg","msg");
    bind.textView.setText(ak);

    }
}