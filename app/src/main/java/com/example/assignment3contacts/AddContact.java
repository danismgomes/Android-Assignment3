package com.example.assignment3contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assignment3contacts.models.Contact;
import com.example.assignment3contacts.models.ContactList;

import java.util.ArrayList;

public class AddContact extends AppCompatActivity {
    private EditText nameET;
    private EditText phoneET;
    private Button submitBtn;
    private ArrayList<String> arrayList = new ArrayList<>();
    private ContactList contactList;
    private Contact contact;
    public static final String EXTRA_MESSAGE = "com.example.android.assignment3contacts.extra.MESSAGE";
    public static final String EXTRA_REPLY = "com.example.assignment3contacts.extra.REPLY";
    private static final String LOG_TAG = AddContact.class.getSimpleName();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        nameET = findViewById(R.id.nameET);
        phoneET = findViewById(R.id.phoneET);
    }


    public void submitOnClick(View view) {
        arrayList.add(nameET.getText().toString());
        arrayList.add(phoneET.getText().toString());

        if (isValidName(arrayList.get(0))&&isValidPhoneNumber(arrayList.get(1))){
            Intent intent = new Intent();
            intent.putStringArrayListExtra(EXTRA_REPLY, arrayList);
            setResult(RESULT_OK, intent);
            finish();
        } else {
            arrayList.clear();
            Toast.makeText(this, "Please enter a phone number valid (10 numbers)",Toast.LENGTH_SHORT).show();
        }

    }

    public boolean isValidPhoneNumber(String number){
        String regexStr = "\\d+";
        if (number.length()!=10){
            return false;
        }
        if (!number.matches(regexStr)){
            return false;
        }
        return true;
    }

    public boolean isValidName(String name){
        String regexStr = "^[a-zA-Z]{4,}(?: [a-zA-Z]+){0,2}$";
        if (!name.matches(regexStr)){
            return false;
        }
        return true;
    }
}
