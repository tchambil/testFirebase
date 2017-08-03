package com.example.laptop.tutorialuno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.laptop.tutorialuno.Objetos.Coche;
import com.example.laptop.tutorialuno.Objetos.FirebaseReferences;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button buttonCoche;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonCoche = (Button) findViewById(R.id.botoncoche);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference tutorialRef = database.getReference(FirebaseReferences.TUTORIAL_REFERENCE);
        buttonCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Coche coche = new Coche("Ford", "Teo",5,4);
            tutorialRef.child(FirebaseReferences.COCHE_REFERENCE).push().setValue(coche);
            }
        });

    }
}
