package fr.julienguillaume.remeberme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import fr.julienguillaume.remeberme.notes.Note;
import fr.julienguillaume.remeberme.notes.NoteActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MAIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mapButton = (Button) findViewById(R.id.mapNote);
        Button listButton = (Button) findViewById(R.id.listNoteBtn);
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(MainActivity.this, NoteActivity.class);
                MainActivity.this.startActivity(mainIntent);
            }
        });
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(MainActivity.this, Map.class);
                MainActivity.this.startActivity(mainIntent);
            }
        });

    }
}
