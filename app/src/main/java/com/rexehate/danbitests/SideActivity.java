package com.rexehate.danbitests;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SideActivity extends AppCompatActivity {

    private String[] lock = {"md5", "sha-1", "sha-256"};
    private String cry;
    private String cryptMethod;

    static Intent newIntent(Context context) {
        return new Intent(context, SideActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        savedInstanceState = getIntent().getExtras();
        cry = savedInstanceState.getString("crytext");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, lock);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(), "Position = " + i, Toast.LENGTH_SHORT).show();
                if (i == 0) {
                    cryptMethod = "MD5";
                } else if (i == 1) {
                    cryptMethod = "SHA-1";
                } else if (i == 2) {
                    cryptMethod = "SHA-256";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    public void cryptMyString(View view) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(cryptMethod);
        md.update(cry.getBytes());
        byte[] digest = md.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        String md5 = bigInt.toString(16);
        System.out.println(md5);
        Intent intent = new Intent();
        intent.putExtra("name", md5);
        setResult(RESULT_OK, intent);
        finish();
    }
}
