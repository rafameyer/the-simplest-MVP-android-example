package com.example.rafaelmeyer.thefirstmvpapp.view;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.rafaelmeyer.thefirstmvpapp.R;
import com.example.rafaelmeyer.thefirstmvpapp.adapter.MyAdapter;
import com.example.rafaelmeyer.thefirstmvpapp.model.Person;
import com.example.rafaelmeyer.thefirstmvpapp.present.IPerson;
import com.example.rafaelmeyer.thefirstmvpapp.present.PresentPerson;
import com.example.rafaelmeyer.thefirstmvpapp.util.MaskHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    IPerson iPerson;
    private List<Person> persons = new ArrayList<>();

    private FloatingActionButton floatingActionButton;

    private MyAdapter myAdapter;
    private RecyclerView myRecyclerView;
    private RecyclerView.LayoutManager myLayoutManager;

    @Override
    protected void onResume() {
        super.onResume();
        initializeRecyclerView();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iPerson = new PresentPerson();

        myRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.buttonSaveName);

        floatingActionButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        saveName();
                    }
                }
        );
    }

    private void initializeRecyclerView() {
        myLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(myLayoutManager);
        persons = iPerson.loadPersons();
        myAdapter = new MyAdapter(persons);
        myRecyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }

    public void saveName() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        View view = inflater.inflate(R.layout.dialog_addnewitem, null);

        final EditText editSaveName = (EditText) view.findViewById(R.id.editSaveNameItem);
        final EditText editTextCPF = (EditText) view.findViewById(R.id.editSaveCPFItem);
        editTextCPF.addTextChangedListener(MaskHelper.insert("###.###.###-##", editTextCPF));

        builder.setView(view);
        builder.setTitle("Add new Person");

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String name = editSaveName.getText().toString();
                String cpf = editTextCPF.getText().toString();
                iPerson.saveNamePerson(name, cpf);
                onResume();
            }
        });

        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_deleteAllObject:
                iPerson.deleteAllObjects();
                onResume();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
