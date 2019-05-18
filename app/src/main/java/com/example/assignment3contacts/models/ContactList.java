package com.example.assignment3contacts.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ContactList {
    @SerializedName("results")
    @Expose
    private ArrayList<Contact> contactList;

    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    public void addContactList(Contact contact) {
        contactList.add(contact);

    }
}
