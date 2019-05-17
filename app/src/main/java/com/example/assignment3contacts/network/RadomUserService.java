package com.example.assignment3contacts.network;

import com.example.assignment3contacts.models.ContactList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RadomUserService {

    //GET, POST, ... (path to the server)
    @GET("?nat=ca")
    Call<ContactList> listContacts(@Query("results") int num);
}
