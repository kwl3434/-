package com.example.baseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
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

    Spinner SpinnerRoutine1, SpinnerRoutine2;
    com.google.android.material.floatingactionbutton.FloatingActionButton ButtonRoutine1;
    View dialogView;

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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mInflater = getMenuInflater();
        if (v == SpinnerRoutine1) {
            menu.setHeaderTitle("루틴 편집/삭제");
            mInflater.inflate(R.menu.menu1, menu);
        } else if (v == SpinnerRoutine2) {
            menu.setHeaderTitle("루틴 편집/삭제");
            mInflater.inflate(R.menu.menu1, menu);
        } else if (v == ButtonRoutine1) {
            menu.setHeaderTitle("루틴 추가");
            mInflater.inflate(R.menu.menu2, menu);
        }

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemdelete:
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("삭제");
                dlg.setMessage("삭제하시겠습니까?");
                dlg.setPositiveButton("예", null);
                dlg.setNegativeButton("아니요", null);
                dlg.show();
                return true;
            case R.id.addRoutine:
                dialogView = (View) View.inflate(MainActivity.this, R.layout.calendar, null);
                AlertDialog.Builder dlg2 = new AlertDialog.Builder(MainActivity.this);
                dlg2.setTitle("루틴 추가");
                dlg2.setView(dialogView);
                dlg2.setNegativeButton("닫기", null);
                dlg2.show();
                return true;
            default:
                return false;
        }
    }
}