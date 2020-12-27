package com.example.proekt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.proekt.Adapter;
import com.example.proekt.DataBaseHelper;
import com.example.proekt.R;


public class HomeActivity extends AppCompatActivity {



    private DataBaseHelper mDB;
    private RecyclerView recycler;
    private Adapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mDB = new DataBaseHelper(this);

        recycler = findViewById(R.id.cities);


        String user="";
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            user = extras.getString("user");
        }
        setAdapter(user);

    }

    private void setAdapter(String user) {
        //setOnClickListener();
        Adapter adapter = new Adapter(this, mDB, R.layout.row, listener,user );
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recycler.setLayoutManager(layoutManager);
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(adapter);
    }


}