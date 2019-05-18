package com.example.assignment3contacts;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.assignment3contacts.models.Contact;
import com.example.assignment3contacts.models.ContactList;
import com.example.assignment3contacts.network.ContactClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Context context = this;
    private ArrayList<Contact> mContactList;
    private ListAdapter listAdapter;
    private RecyclerView recyclerView;
    public static final String TAG = MainActivity.class.getSimpleName();
    public static final int TEXT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Call<ContactList> request = ContactClient.getContacts(30);

        request.enqueue(new Callback<ContactList>() {
            @Override
            public void onResponse(Call<ContactList> call, Response<ContactList> response) {
                if (response.isSuccessful()){
                    // returns an ArrayList of contacts
                    mContactList = response.body().getContactList();
                    for (Contact contact:
                    mContactList) {
                        Log.d(TAG, "Name: "+contact.getName());
                        Log.d(TAG,"Phone: "+contact.getCell());

                    }
                }
                listAdapter = new ListAdapter(mContactList, context);
                recyclerView = findViewById(R.id.recyclerView);
                recyclerView.setAdapter(listAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            }

            @Override
            public void onFailure(Call<ContactList> call, Throwable t) {
                //Error Handling
            }
        });

    }

    public void addButtonClicked(View view) {
        Intent intent = new Intent(MainActivity.this, AddContact.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                ArrayList<String> reply = data.getStringArrayListExtra(AddContact.EXTRA_REPLY);

                Contact contact = new Contact(reply.get(0), reply.get(1));
                mContactList.add(contact);
            }
        }
    }
}
