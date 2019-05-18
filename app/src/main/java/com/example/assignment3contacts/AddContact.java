package com.example.assignment3contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                Intent intent = new Intent();
                intent.putStringArrayListExtra(EXTRA_REPLY, arrayList);
                setResult(RESULT_OK, intent);
                finish();
    }

    public boolean isValidPhoneNumber(String number){
        String regexStr = "^[0-9]$";
        if (number.length()!=10){
            return false;
        }
        if (!number.matches(regexStr)){
            return false;
        }
        return true;
    }

    public boolean isValidName(String number){
        String regexStr = "^[0-9]$";
        if (number.length()!=10){
            return false;
        }
        if (!number.matches(regexStr)){
            return false;
        }
        return true;
    }
}
