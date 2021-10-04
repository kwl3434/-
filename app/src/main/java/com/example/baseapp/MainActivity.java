package com.example.baseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner SpinnerRoutine1,SpinnerRoutine2;
    com.google.android.material.floatingactionbutton.FloatingActionButton ButtonRoutine1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SpinnerRoutine1 = (Spinner) findViewById(R.id.spinner_routine1);
        registerForContextMenu(SpinnerRoutine1);
        SpinnerRoutine2 = (Spinner) findViewById(R.id.spinner_routine2);
        registerForContextMenu(SpinnerRoutine2);
        ButtonRoutine1 = (com.google.android.material.floatingactionbutton.FloatingActionButton) findViewById(R.id.floatingActionButton4);
        registerForContextMenu(ButtonRoutine1);
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);


        return true;
    }
*/
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mInflater = getMenuInflater();
        if (v == SpinnerRoutine1){
            menu.setHeaderTitle("루틴 편집/삭제");
            mInflater.inflate(R.menu.menu1, menu);
        }
        else if(v == SpinnerRoutine2){
            menu.setHeaderTitle("루틴 편집/삭제");
            mInflater.inflate(R.menu.menu1, menu);
        }
        else if(v == ButtonRoutine1){
            menu.setHeaderTitle("루틴 추가");
            mInflater.inflate(R.menu.menu2, menu);
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            default:
                return true;
        }
    }
}
