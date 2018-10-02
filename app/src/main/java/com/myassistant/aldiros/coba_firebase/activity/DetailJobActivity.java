package com.myassistant.aldiros.coba_firebase.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.myassistant.aldiros.coba_firebase.R;
import com.myassistant.aldiros.coba_firebase.model.bookingModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class DetailJobActivity extends AppCompatActivity {

    private ImageView imgUser;
    private TextView tvNama;
    private TextView tvUmur;
    private TextView tvGaji;
    private TextView tvLokasi;
    private TextView tvNoTelp;
    private TextView tvDesc;
    private Button btnBooking;
    private ImageView imgPhone, imgSms;


    private String image, nama, umur, gaji, lokasi, notelp, desc, menu, key_menu;
    private DatabaseReference mUserDatabase;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_job);

        mUserDatabase = FirebaseDatabase.getInstance().getReference("Booking");
        mAuth = FirebaseAuth.getInstance();

        imgPhone = (ImageView) findViewById(R.id.phone);
        imgSms = (ImageView) findViewById(R.id.sms);

        imgUser = (ImageView) findViewById(R.id.imgUser);
        tvNama = (TextView) findViewById(R.id.tvNama);
        tvUmur = (TextView) findViewById(R.id.tvUmur);
        tvGaji = (TextView) findViewById(R.id.tvNama);
        tvLokasi = (TextView) findViewById(R.id.tvLokasi);
        tvNoTelp = (TextView) findViewById(R.id.tvNoTelp);
        tvDesc = (TextView) findViewById(R.id.tvDesc);
        btnBooking = (Button) findViewById(R.id.btnBooking);
        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserDatabase.push().setValue(new bookingModel(mAuth.getCurrentUser().getUid(),
                        menu, key_menu, nama, umur, image));

                Intent intent = new Intent(DetailJobActivity.this, BookingSuccessActivity.class);
                startActivity(intent);
                finish();
            }
        });

        getExtrasIntent();

        imgPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + notelp));
                startActivity(intent);
            }
        });

        imgSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("tel:" + notelp));
                startActivity(intent);
            }
        });

    }


    private void getExtrasIntent() {
        image = getIntent().getStringExtra("image");
        nama = getIntent().getStringExtra("nama");
        umur = getIntent().getStringExtra("umur");
        gaji = getIntent().getStringExtra("gaji");
        lokasi = getIntent().getStringExtra("lokasi");
        notelp = getIntent().getStringExtra("notelp");
        desc = getIntent().getStringExtra("desc");
        menu = getIntent().getStringExtra("menu");
        key_menu = getIntent().getStringExtra("key_menu");

        tvNama.setText(nama);
        tvUmur.setText(umur);
        tvGaji.setText(gaji);
        tvLokasi.setText(lokasi);
        tvNoTelp.setText(notelp);
        tvDesc.setText(desc);
        Picasso.get().load(image).into(imgUser);
    }
}
