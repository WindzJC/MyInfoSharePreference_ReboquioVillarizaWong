package com.example.myinfosharepreference;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName,etAddress,etAge,etContact;
    TextView name,contact,age,address;
    SharedPreferences mPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        etAddress = findViewById(R.id.et_address);
        etAge = findViewById(R.id.et_age);
        etContact = findViewById(R.id.et_contact);
        mPrefs = getPreferences(MODE_PRIVATE);
    }


    public void saveInfo(View view) {

        String name = etName.getText().toString();
        String address = etAddress.getText().toString();
        String age = etAge.getText().toString();
        String contact = etContact.getText().toString();


        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        prefsEditor.putString("name", name);
        prefsEditor.putString("address", address);
        prefsEditor.putString("age", age);
        prefsEditor.putString("contact", contact);
        prefsEditor.apply();


        Toast.makeText(this, "Information saved", Toast.LENGTH_SHORT).show();
    }

    public void retrieveInfo(View view) {

        String name = mPrefs.getString("name", "");
        String address = mPrefs.getString("address", "");
        String age = mPrefs.getString("age", "");
        String contact = mPrefs.getString("contact", "");

        etName.setText(name);
        etAddress.setText(address);
        etAge.setText(age);
        etContact.setText(contact);

        Toast.makeText(this, "Information retrieved", Toast.LENGTH_SHORT).show();
    }
    public void clearInfo (View view) {
        name = (TextView) findViewById(R.id.et_name);
        address = (TextView) findViewById(R.id.et_address);
        age = (TextView) findViewById(R.id.et_age);
        contact = (TextView) findViewById(R.id.et_contact);

        etName.setText("");
        etAddress.setText("");
        etAge.setText("");
        etContact.setText("");

        Toast.makeText(this, "Information Cleared", Toast.LENGTH_SHORT).show();
    }
}
