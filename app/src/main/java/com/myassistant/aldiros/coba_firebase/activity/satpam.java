package com.myassistant.aldiros.coba_firebase.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.myassistant.aldiros.coba_firebase.R;
import com.myassistant.aldiros.coba_firebase.adapter.DriverAdapter;
import com.myassistant.aldiros.coba_firebase.model.driverUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class satpam extends AppCompatActivity {

    private EditText mSearchField;
    private ImageView mSearchButton;
    private RecyclerView mResultBabysitter;
    private DatabaseReference mUserDatabase;
    private ArrayList<driverUser> satpamUserList;
    private DriverAdapter mAdapter;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_satpam);
        mUserDatabase = FirebaseDatabase.getInstance().getReference("Driver");

        mSearchField = (EditText) findViewById(R.id.searchBabysitter);
        mSearchButton = (ImageView) findViewById(R.id.searchImg);
        mResultBabysitter = (RecyclerView) findViewById(R.id.result_babysitter);

        satpamUserList = new ArrayList<>();

        mResultBabysitter.setHasFixedSize(true);
        mResultBabysitter.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new DriverAdapter(this, satpamUserList);
        mResultBabysitter.setAdapter(mAdapter);

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchText = mSearchField.getText().toString();
                firebaseUserSearch(searchText);
            }
        });

        firebaseUserSearch("");
    }

    private void firebaseUserSearch(final String searchText) {
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait");
        pDialog.show();
        mUserDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                satpamUserList.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    driverUser post = postSnapshot.getValue(driverUser.class);

                    if(post.getAlamat().toLowerCase().contains(searchText)) {
                        satpamUserList.add(post);
                    }
                    mAdapter.notifyDataSetChanged();
                }
                pDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
