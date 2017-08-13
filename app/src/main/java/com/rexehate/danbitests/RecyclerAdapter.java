package com.rexehate.danbitests;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PersonViewHolder> {

    static class PersonViewHolder extends RecyclerView.ViewHolder {


        TextView personOne;
        TextView personTwo;
        TextView personNum;
        TextView transHash;



        PersonViewHolder(View itemView) {
            super(itemView);
            personOne = (TextView)itemView.findViewById(R.id.person_one);
            personTwo = (TextView)itemView.findViewById(R.id.person_two);
            personNum = (TextView)itemView.findViewById(R.id.person_num);
            transHash = (TextView)itemView.findViewById(R.id.trans_hash);

        }
    }

    private List<Transaction> mTransactions;

    RecyclerAdapter(List<Transaction> transactions){
        this.mTransactions = transactions;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);
        return new PersonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder personViewHolder, int i) {
        personViewHolder.personOne.setText(mTransactions.get(i).pOneT);
        personViewHolder.personTwo.setText(mTransactions.get(i).pTwoT);
        personViewHolder.personNum.setText(mTransactions.get(i).pTrans);
        personViewHolder.transHash.setText(mTransactions.get(i).pHash);

    }

    @Override
    public int getItemCount() {
        return mTransactions.size();
    }
}