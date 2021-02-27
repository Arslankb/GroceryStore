package com.example.GroceryStore;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity {

    ImageView img, back, cart1;
    TextView proName, proPrice, proDesc ;

    String name, price, desc ;
    int image;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Intent i = getIntent();

         name = i.getStringExtra("name");
         image = i.getIntExtra("image", R.drawable.b1);
         price = i.getStringExtra("price");
         desc = i.getStringExtra("desc");


        proName = findViewById(R.id.ProductName);
        proDesc = findViewById(R.id.prodDec);
        proPrice = findViewById(R.id.prodPrice);
        img = findViewById(R.id.bg_image);
        back = findViewById(R.id.back2);


        proName.setText(name);
        proPrice.setText(price);
        proDesc.setText(desc);
      

       img.setImageResource(image);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(ProductDetails.this, MainActivity.class);
                startActivity(i);
                finish();

            }
        });

        cart1 = findViewById(R.id.cart1);
        cart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetails.this, ShoppingCart.class);
                startActivity(intent);
            }
        });

    }
}