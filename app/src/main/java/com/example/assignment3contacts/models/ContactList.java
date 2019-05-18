package com.example.assignment3contacts.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ContactList {
    @SerializedName("results")
    @Expose
    private ArrayList<Contact> contactList = new ArrayList<>();

    public ArrayList<Contact> getContactList() {
        Collections.sort(contactList, new Comparator<Contact>(){
            public int compare(Contact c1, Contact c2) {
                return c1.getName().toString().compareToIgnoreCase(c2.getName().toString());
            }
        });
        return contactList;
    }


}
