package com.rosa.app.SharedVar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rosa.library.SharedVar.Variable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Variable variable = Variable.getInstance(this, "testVar");
        variable.setString("Hello world!");
        setTitle(variable.getString());
    }
}
