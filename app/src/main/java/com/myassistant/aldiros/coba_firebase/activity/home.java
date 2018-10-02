package com.myassistant.aldiros.coba_firebase.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.myassistant.aldiros.coba_firebase.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private TextView email;
    ImageView imgBabysitter, imgSatpam, imgArt, imgBodyguard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();


        if(firebaseAuth.getCurrentUser()==null){
            startActivity(new Intent(this, LoginActivity.class));
        }

        //INTENT KE CATEGORY
        imgBabysitter = (ImageView) findViewById(R.id.babysitter);
        imgBabysitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent babysitter = new Intent(home.this, babysitter.class);
                startActivity(babysitter);
            }
        });

        imgSatpam = (ImageView) findViewById(R.id.satpam);
        imgSatpam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent satpam = new Intent(home.this, satpam.class);
                startActivity(satpam);
            }
        });

        imgArt = (ImageView) findViewById(R.id.art);
        imgArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent art = new Intent(home.this, art.class);
                startActivity(art);
            }
        });

//        imgBodyguard = (ImageView) findViewById(R.id.bodyguard);
//        imgBodyguard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent bodyguard = new Intent(home.this, bodyguard.class);
//                startActivity(bodyguard);
//            }
//        });

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_logout:
                firebaseAuth.signOut(); //logout firebase
                startActivity(new Intent(home.this, LoginActivity.class)); //panggil login activity
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        try {
            if (id == R.id.home) {
            } else if (id == R.id.home) {
                Intent intent = new Intent(home.this, home.class);
                startActivity(intent);

            } else if (id == R.id.aboutus) {
                Intent intent = new Intent(home.this, aboutus.class);
                startActivity(intent);

            } else if (id == R.id.profile) {
                Intent intent = new Intent(home.this, ProfileActivity.class);
                startActivity(intent);

            } else if (id == R.id.helpcenter) {
                Intent intent = new Intent(home.this, helpcenter.class);
                startActivity(intent);

            } else if (id == R.id.historytransaksi) {
                Intent intent = new Intent(home.this, HistoryActivity.class);
                startActivity(intent);

            } else if (id == R.id.faq) {
                Intent intent = new Intent(home.this, faq.class);
                startActivity(intent);

            } else if (id == R.id.logout) {
                firebaseAuth.signOut();
                Intent intent = new Intent(home.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        } catch (Exception ex) {
            Toast.makeText(this, "Mohon maaf fitur masih dalam pengembangan", Toast.LENGTH_SHORT).show();
        }

//        switch (id) {
//            case R.id.home:
//                Intent home = new Intent(home.this, home.class);
//                startActivity(home);
//                break;
//            case R.id.aboutus:
//                Intent about = new Intent(home.this, aboutus.class);
//                startActivity(about);
//                break;
//            case R.id.profile:
//                Intent profile = new Intent(home.this, ProfileActivity.class);
//                startActivity(profile);
//                break;
//            case R.id.helpcenter:
//                Intent help = new Intent(home.this, helpcenter.class);
//                startActivity(help);
//                break;
//            case R.id.historytransaksi:
//                Intent history = new Intent(home.this, HistoryActivity.class);
//                startActivity(history);
//                break;
//            case R.id.faq:
//                Intent faq = new Intent(home.this, faq.class);
//                startActivity(faq);
//                break;
//            case R.id.logout:
//                firebaseAuth.signOut();
//                Intent intent = new Intent(home.this, LoginActivity.class);
//                startActivity(intent);
//                finish();
//            default:
//                break;
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
