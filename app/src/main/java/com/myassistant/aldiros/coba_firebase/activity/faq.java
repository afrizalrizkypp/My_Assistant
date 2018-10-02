package com.myassistant.aldiros.coba_firebase.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import com.myassistant.aldiros.coba_firebase.R;
import com.myassistant.aldiros.coba_firebase.adapter.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by aldiros on 20/04/2018.
 */

public class faq extends AppCompatActivity{
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHash;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.faq);

        listView = (ExpandableListView)findViewById(R.id.lvExp);
        initData();
        listAdapter = new ExpandableListAdapter(this,listDataHeader,listHash);
        listView.setAdapter(listAdapter);
    }

    private void initData(){
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Bagaimana cara memesan Aplikasi MY Assistant ");
        listDataHeader.add("Bagaimana jika saya ingin mengubah data akun saya?");

        List<String> edmtDev = new ArrayList<>();
        edmtDev.add("This is Expandable List ViewThis is Expandable List ViewThis is Expandable List ViewThis is Expandable List ViewThis is Expandable List ViewThis is Expandable List ViewThis is Expandable List ViewThis is " +
                "Expandable List ViewThis is Expandable List ViewThis is Expandable List ViewThis is Expandable List ViewThis is Expandable List View");


        List<String > androidStudio = new ArrayList<>();
        androidStudio.add("Expandable List ViewExpandable List ViewExpandable List ViewExpandable List ViewExpandable List ViewExpandable List View" +
                "Expandable List ViewExpandable List ViewExpandable List View" +
                "Expandable List ViewExpandable List ViewExpandable List ViewExpandable List View");




        listHash.put(listDataHeader.get(0),edmtDev);
        listHash.put(listDataHeader.get(1),androidStudio);

    }
}
