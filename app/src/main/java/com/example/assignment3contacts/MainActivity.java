package com.example.assignment3contacts;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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
}
