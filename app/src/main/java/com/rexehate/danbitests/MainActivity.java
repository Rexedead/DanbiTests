package com.rexehate.danbitests;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText pOne;
    private EditText pTwo;
    private EditText pNum;
    private TextView pHash;
    private RecyclerView recyclerView;


    private List<Transaction> mTransactions;

    private void initializeData() {
        mTransactions.add(new Transaction(pOne.getText().toString(), pTwo.getText().toString(), pNum.getText().toString(), pHash.getText().toString()));
    }

    private void initializeAdapter() {
        RecyclerAdapter adapter = new RecyclerAdapter(mTransactions);
        recyclerView.setAdapter(adapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pTwo = (EditText) findViewById(R.id.pOne);
        pOne = (EditText) findViewById(R.id.pTwo);
        pNum = (EditText) findViewById(R.id.num);
        pHash = (TextView) findViewById(R.id.hash);
        recyclerView = (RecyclerView) findViewById(R.id.rcv);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mTransactions = new ArrayList<>();

    }


    public void confirm(View view) throws NoSuchAlgorithmException {
        Context context = getApplicationContext();
        CharSequence toastText = "Empty Field";
        int toastDuration = Toast.LENGTH_SHORT;
        Toast toastConfirm = Toast.makeText(context, toastText, toastDuration);


        if (!pOne.getText().toString().equals("") || !pTwo.getText().toString().equals("") || !pNum.getText().toString().equals("")) {
            String strOfHash = pOne.getText().toString() + pTwo.getText().toString() + Integer.parseInt(pNum.getText().toString());
            HashCalc hc = new HashCalc();
            pHash.setText(hc.cryptMyString(strOfHash));
            initializeData();
            initializeAdapter();
            RecyclerAdapter adapter = new RecyclerAdapter(mTransactions);
            recyclerView.setAdapter(adapter);
            clearFields();
        } else toastConfirm.show();


    }

    private void clearFields() {
        pOne.setText("");
        pTwo.setText("");
        pNum.setText("");
    }

}