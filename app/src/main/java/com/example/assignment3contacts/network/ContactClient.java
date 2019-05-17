package com.example.assignment3contacts.network;

import com.example.assignment3contacts.models.ContactList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactClient {
    private static final String ROOT_URL = "https://randomuser.me/api/";

    // retrofit object
    private static Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RadomUserService getRandomUserService(){
        return getRetrofitInstance().create(RadomUserService.class);
    }

    public static Call<ContactList> getContacts(int num){
        Call<ContactList> contacts = getRandomUserService().listContacts(num);
        return contacts;
    }
}
