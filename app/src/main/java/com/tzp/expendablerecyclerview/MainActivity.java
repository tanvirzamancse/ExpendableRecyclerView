package com.tzp.expendablerecyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.tzp.expendablerecyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    public List<ParentsDataModel> modelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        modelList = new ArrayList<>();

        List<String> nextList1 = new ArrayList<>();
        nextList1.add("Tanvir");
        nextList1.add("Zaman");
        nextList1.add("Prince");
        nextList1.add("Emon");

        List<String> nextList2 = new ArrayList<>();
        nextList2.add("Zaman");
        nextList2.add("Zaman");
        nextList2.add("Prince");
        nextList2.add("Emon");

        List<String> nextList3 = new ArrayList<>();
        nextList3.add("Emon");
        nextList3.add("Zaman");
        nextList3.add("Prince");
        nextList3.add("Emon");


        modelList.add(new ParentsDataModel(nextList1, "Food"));
        modelList.add(new ParentsDataModel(nextList2, "Rice"));
        modelList.add(new ParentsDataModel(nextList3, "Soup"));

        ParentsAdapter parentsAdapter = new ParentsAdapter(modelList, getApplicationContext());
        binding.parentsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.parentsRecyclerView.setAdapter(parentsAdapter);
    }
}