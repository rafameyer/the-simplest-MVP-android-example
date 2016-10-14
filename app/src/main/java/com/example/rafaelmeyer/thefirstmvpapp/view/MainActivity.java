package com.example.rafaelmeyer.thefirstmvpapp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.rafaelmeyer.thefirstmvpapp.R;
import com.example.rafaelmeyer.thefirstmvpapp.model.Person;
import com.example.rafaelmeyer.thefirstmvpapp.present.IPerson;

public class MainActivity extends AppCompatActivity {

    IPerson iPerson;

    Button buttonSaveName;
    EditText editSaveName;
    TextView textViewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iPerson = new Person();

        buttonSaveName = (Button) findViewById(R.id.buttonSaveName);
        editSaveName = (EditText) findViewById(R.id.editSaveName);
        textViewName = (TextView) findViewById(R.id.textViewName);

        buttonSaveName.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        saveName();
                    }
                }
        );
    }

    public void saveName() {
        String name = editSaveName.getText().toString();
        iPerson.saveNamePerson(name);
        Log.d("Main"," : " + iPerson.getNamePerson());
        textViewName.setText(iPerson.getNamePerson());
    }
}
