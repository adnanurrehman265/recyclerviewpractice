package com.example.recyclerviewpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recylerview);

        ArrayList <RecipeModels> list = new ArrayList<>();

        list.add(new RecipeModels(R.drawable.food1 ,"BBQ"));
        list.add(new RecipeModels(R.drawable.food2 ,"BURGER"));
        list.add(new RecipeModels(R.drawable.food3 ,"DESI FOOD"));
        list.add(new RecipeModels(R.drawable.food4 ,"PIZZA"));
        list.add(new RecipeModels(R.drawable.food7,"BBQ"));
        list.add(new RecipeModels(R.drawable.food6 ,"CHICKEN"));
        list.add(new RecipeModels(R.drawable.food7 ,"BROAST"));
        list.add(new RecipeModels(R.drawable.food8 ,"CUPCAKE"));
        list.add(new RecipeModels(R.drawable.food6 ,"CHICKEN"));



        RecipeAdapter adapter = new RecipeAdapter(list, this);
        recyclerView.setAdapter(adapter);

//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);

        GridLayoutManager gridlayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridlayoutManager);

        adapter.setOnItemClickListener(new RecipeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecipeModels recipe) {
                Intent intent = new Intent(MainActivity.this, newpage.class);
                intent.putExtra("recipe_name", recipe.getText());
                intent.putExtra("recipe_image_resource", recipe.getPic());
                startActivity(intent);
            }
        });
    }

}