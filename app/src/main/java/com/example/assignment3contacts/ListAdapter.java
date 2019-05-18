package com.example.assignment3contacts;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.assignment3contacts.models.Contact;
import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MViewHolder> {
    private ArrayList<Contact> mContactList;
    private LayoutInflater layoutInflater;

    public ListAdapter(ArrayList<Contact> mContactList,  Context context) {
        this.mContactList = mContactList;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.view_holder, viewGroup, false);
        return new MViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MViewHolder mViewHolder, int i) {
        int controller = 0;
        Contact contact = mContactList.get(i);
        Contact contact2;
        if (i+1<mContactList.size()){
            contact2 = mContactList.get(i+1);
        } else {
            contact2 = mContactList.get(i);
        }

        String string1 = contact.getName()+"";
        String string2 = contact2.getName()+"";
        string1 = (string1.charAt(0)+"").toUpperCase();
        string2 = (string2.charAt(0)+"").toUpperCase();

        if (i == 0){
            controller = 2;
            if(string1.compareTo(string2)==0){
                controller = 3;
            }
        } else if(string1.compareTo(string2)!=0){
            controller = 1;
        }

        mViewHolder.bind(contact, controller, string2, string1);
    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }

    public class MViewHolder extends RecyclerView.ViewHolder{
        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
        private TextView textView4;

        public MViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView1 = itemView.findViewById(R.id.textView1);
            this.textView2 = itemView.findViewById(R.id.textView2);
            this.textView3 = itemView.findViewById(R.id.textView3);
            this.textView4 = itemView.findViewById(R.id.textView4);
        }

        public void bind(Contact contact, int controller, String letter2, String letter1){
            String sTextView1 = ""+contact.getName();
            String sTextView2 = ""+contact.getCell();
            textView2.setText(sTextView1);
            textView3.setText(sTextView2);
            textView1.setVisibility(View.GONE);
            textView4.setVisibility(View.GONE);

            if (controller==1){
                textView4.setText(letter2);
                textView4.setVisibility(View.VISIBLE);
            } else if(controller==2){
                textView1.setText(letter1);
                textView1.setVisibility(View.VISIBLE);
                textView4.setText(letter2);
                textView4.setVisibility(View.VISIBLE);
            } else if (controller == 3){
                textView1.setText(letter1);
                textView1.setVisibility(View.VISIBLE);
            }
        }
    }
}
