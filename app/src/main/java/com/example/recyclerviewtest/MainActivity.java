package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RLAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RLAdapter(this, getMyList());
        recyclerView.setAdapter(adapter);
    }

    private ArrayList<Model> getMyList(){
        ArrayList<Model> models = new ArrayList<>();

        Model model = new Model();
        model.setJudul("Judul list");
        model.setDesc("Deskripsi list");
        model.setPict(R.mipmap.ic_launcher_round);
        models.add(model);

        for (int i=0; i<10; i++){
            model = new Model();
            model.setJudul("Judul list"+i);
            model.setDesc("Deskripsi list");
            model.setPict(R.mipmap.ic_launcher_round);
            models.add(model);
        }

        return models;
    }
}
