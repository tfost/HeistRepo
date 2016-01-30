package uw.heist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.firebase.client.*;

import java.util.HashMap;
import java.util.Map;

public class StartupActivity extends AppCompatActivity {
    public static final int gameID = 12345;
    private Map<String, Boolean> persons;
    public Firebase userRef;
    public String name = "";
    public boolean isTheif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        userRef = new Firebase("https://sizzling-heat-2181.firebaseio.com/");

        this.persons = new HashMap<String, Boolean>();
        setContentView(R.layout.activity_startup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_startup, menu);
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

    public void makeGuard(View view) {
        EditText box = (EditText) findViewById(R.id.name);
        String name = box.getText().toString();
        this.persons.put(name, false);
        this.name = name;
        this.userRef.setValue(this.persons);
    }

    public void makeThief(View view) {
        EditText box = (EditText) findViewById(R.id.name);
        String name = box.getText().toString();
        this.persons.put(name, true);
        this.name = name;
        this.userRef.setValue(this.persons);

    }

    public void startGame(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("NAME", name);
        intent.putExtra("ISTHEIF", this.isTheif);

    }
}
