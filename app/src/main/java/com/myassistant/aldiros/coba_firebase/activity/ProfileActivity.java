package com.myassistant.aldiros.coba_firebase.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.myassistant.aldiros.coba_firebase.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private TextView textViewUserEmail;
    private TextView buttonLogout;
    private Button buttonProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        if(firebaseAuth.getCurrentUser()==null){
            startActivity(new Intent(this, LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        textViewUserEmail.setText("Hallo " + user.getEmail() + " silahkan tap tombol di bawah untuk" +
                " edit profil anda :)");
        buttonProfile = (Button) findViewById(R.id.buttonProfile);

        buttonProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        if(view==buttonLogout){
//            firebaseAuth.signOut();
//            finish();
//            startActivity(new Intent(this, LoginActivity.class));
//        }
        if(view==buttonProfile){
            startActivity(new Intent(this, custom_profile.class));
        }

    }
}
