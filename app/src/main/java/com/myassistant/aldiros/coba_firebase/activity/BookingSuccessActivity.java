package com.myassistant.aldiros.coba_firebase.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.myassistant.aldiros.coba_firebase.R;

public class BookingSuccessActivity extends AppCompatActivity {

    private Button btnBack;
    String notelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_success);
        btnBack = (Button) findViewById(R.id.btnBack);


//        Intent i = new Intent(DetailJobActivity, BookingSuccessActivity.class);
//        i.putExtra("image", post.getImage());

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(BookingSuccessActivity.this, home.class);
                startActivity(in);
                finish();
            }
        });

        notelp = getIntent().getStringExtra("notelp");

    }
    }


