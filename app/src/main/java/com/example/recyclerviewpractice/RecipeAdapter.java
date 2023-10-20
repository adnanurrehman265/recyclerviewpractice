package com.example.recyclerviewpractice;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    private ArrayList<RecipeModels> list;
    private Context context;

    public RecipeAdapter(ArrayList<RecipeModels> list, Context context) {
        this.list = list;
        this.context = context;
    }

    // Define an interface to handle item clicks
    public interface OnItemClickListener {
        void onItemClick(RecipeModels recipe);
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_recycleview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecipeModels models = list.get(position);
        holder.imageview.setImageResource(models.getPic());
        holder.textview.setText(models.getText());

        // Set an onClickListener for the image view
        holder.imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onItemClick(models);
                }
            }
        });
    }

    @Override
    public int getItemCount() { return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageview;
        TextView textview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.imageview);
            textview = itemView.findViewById(R.id.textview);
        }
    }
}

