package com.example.recyclerviewpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class newpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpage);
        // Find views in your layout to display the data
        TextView recipeNameTextView = findViewById(R.id.textview);
        ImageView recipeImageView = findViewById(R.id.imageView);
        Button addToCartButton = findViewById(R.id.addtocart);

        // Get the data passed from the MainActivity
        Intent intent = getIntent();
        if (intent != null) {
            String recipeName = intent.getStringExtra("recipe_name");
            int recipeImageResource = intent.getIntExtra("recipe_image_resource", 0);

            // Set the recipe name in the TextView
            recipeNameTextView.setText(recipeName);

            // Set the recipe image in the ImageView
            recipeImageView.setImageResource(recipeImageResource);

            // Set an OnClickListener for the "Add to Cart" button
            addToCartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Handle the "Add to Cart" button click event
                    // Show a Toast message indicating the item was added to the cart
                    Toast.makeText(newpage.this, "Item added to cart", Toast.LENGTH_SHORT).show();

                    // Simulate a successful order placement (you can replace this with actual logic)
                    boolean orderPlacedSuccessfully = placeOrder();

                    if (orderPlacedSuccessfully) {
                        // Show a Toast message indicating the order is successfully placed
                        Toast.makeText(newpage.this, "Order is Successfully Placed", Toast.LENGTH_SHORT).show();
                    }
                }

                private boolean placeOrder() {
                    return true;
                }
            });
        }
    }
}






