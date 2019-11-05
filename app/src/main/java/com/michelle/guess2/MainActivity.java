package com.michelle.guess2;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView ed_Number;
    private ImageView result;
    int counter;
    int secret = new Random().nextInt(10)+1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ed_Number = findViewById(R.id.num);
        result = findViewById(R.id.result);
        Log.d("MainActivity","secret :"+secret);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               counter++;
               ed_Number.setText(String.valueOf(counter));
               int number = Integer.parseInt(ed_Number.getText().toString());
               if(number == secret){
                   Toast.makeText(MainActivity.this,"Shocked !!!!!!!!",Toast.LENGTH_LONG).show();
                   result.setAlpha(1.0f);
                   result.setVisibility(View.VISIBLE);
                   result.animate().alpha(0.0f).setDuration(2000);
                   new AlertDialog.Builder(MainActivity.this)
                           .setTitle("Wowwwwwwwwww")
                           .setMessage("You're prefect !!!!!!")
                           .setPositiveButton("OK",null)
                           .show();
                   secret = new Random().nextInt(10)+1;
                   Log.d("MainActivity","secret :"+secret);
               }
            }
        });
    }

    public void zero(View view){
        counter = 0;
        ed_Number.setText(String.valueOf(counter));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
