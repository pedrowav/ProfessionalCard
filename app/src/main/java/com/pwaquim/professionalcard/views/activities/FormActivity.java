package com.pwaquim.professionalcard.views.activities;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pwaquim.professionalcard.R;

public class FormActivity extends AppCompatActivity {

    private static final String NAME_KEY = "name";
    private static final String LAST_NAME_KEY = "last name";
    private static final String AGE_KEY = "age";
    private static final String EMAIL_KEY = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        final EditText editTextName = findViewById(R.id.edit_text_name);
        final EditText editTextLastName = findViewById(R.id.edit_text_last_name);
        final EditText editTextAge= findViewById(R.id.edit_text_age);
        final EditText editTextEmail = findViewById(R.id.edit_text_email);

        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DatabaseReference rootReference= database.getReference();
                rootReference.child(NAME_KEY).setValue(editTextName.getText().toString());
                rootReference.child(LAST_NAME_KEY).setValue(editTextLastName.getText().toString());
                rootReference.child(AGE_KEY).setValue(editTextAge.getText().toString());
                rootReference.child(EMAIL_KEY).setValue(editTextEmail.getText().toString());

                Toast.makeText(FormActivity.this, R.string.send, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
