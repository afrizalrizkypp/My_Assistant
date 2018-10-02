package com.myassistant.aldiros.coba_firebase.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import com.myassistant.aldiros.coba_firebase.R;
import com.myassistant.aldiros.coba_firebase.adapter.BookingAdapter;
import com.myassistant.aldiros.coba_firebase.model.bookingModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView mResultBabysitter;
    private DatabaseReference mUserDatabase;
    private ArrayList<bookingModel> satpamUserList;
    private BookingAdapter mAdapter;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        mUserDatabase = FirebaseDatabase.getInstance().getReference("Booking");

        mResultBabysitter = (RecyclerView) findViewById(R.id.rvData);

        satpamUserList = new ArrayList<>();

        mResultBabysitter.setHasFixedSize(true);
        mResultBabysitter.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new BookingAdapter(this, satpamUserList);
        mResultBabysitter.setAdapter(mAdapter);

        firebaseUserSearch("");

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mResultBabysitter);
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
                    bookingModel post = postSnapshot.getValue(bookingModel.class);

                    satpamUserList.add(post);
                    mAdapter.notifyDataSetChanged();
                }
                pDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
            Toast.makeText(HistoryActivity.this, "History Dihapus", Toast.LENGTH_SHORT).show();
            //Remove swiped item from list and notify the RecyclerView
            int position = viewHolder.getAdapterPosition();
            satpamUserList.remove(position);
            mAdapter.notifyDataSetChanged();

        }

    };
}
