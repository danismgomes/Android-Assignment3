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
    private Context context;

    public ListAdapter(ArrayList<Contact> mContactList,  Context context) {
        this.mContactList = mContactList;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @NonNull
    @Override
    public MViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.view_holder, viewGroup, false);
        return new MViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull MViewHolder mViewHolder, int i) {
        Contact contact = mContactList.get(i);
        mViewHolder.bind(contact);
    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }

    public class MViewHolder extends RecyclerView.ViewHolder{
        private TextView textView1;
        private TextView textView2;
        private ListAdapter listAdapter;

        public MViewHolder(@NonNull View itemView, ListAdapter listAdapter) {
            super(itemView);
            this.textView1 = itemView.findViewById(R.id.textView1);
            this.textView2 = itemView.findViewById(R.id.textView2);
            this.listAdapter = listAdapter;

//            itemView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
//                    int position = getLayoutPosition();
//                    Contact contact = mContactList.get(position);
//                    return false;
//                }
//            });
        }

        public void bind(Contact contact){
            textView1.setText(""+contact.getName());
            textView2.setText(""+contact.getCell());
        }
    }
}
