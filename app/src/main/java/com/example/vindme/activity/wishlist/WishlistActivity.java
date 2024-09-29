package com.example.vindme.activity.wishlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vindme.activity.cart.CartActivity;
import com.example.vindme.activity.profile.ProfileActivity;
import com.example.vindme.R;
import com.example.vindme.activity.home.HomeActivity;
import com.example.vindme.activity.search.SearchActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class WishlistActivity extends AppCompatActivity {

TextView tvArtist, tvDescription, tvPrice;
Button btBuy;

String artis, deskripsi, harga;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_wishlist);

    tvArtist = findViewById(R.id.tvArtist);
    tvDescription = findViewById(R.id.tvDescription);
    tvPrice = findViewById(R.id.tvPrice);
    btBuy = findViewById(R.id.btBuy);

    artis = getIntent().getStringExtra("artis");
    deskripsi = getIntent().getStringExtra("deskripsi");
    harga = getIntent().getStringExtra("harga");

    tvArtist.setText(artis);
    tvDescription.setText(deskripsi);
    tvPrice.setText("Rp. " + harga);

    btBuy.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), AddWishlistActivity.class);
        intent.putExtra("pesan", "sold");
        startActivity(intent);
      }
    });

    BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
    bottomNav.setSelectedItemId(R.id.wishlist);
    bottomNav.setOnItemSelectedListener(item -> {
      if (item.getItemId() == R.id.home){
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        finish();
      } else if(item.getItemId() == R.id.search){
        startActivity(new Intent(getApplicationContext(), SearchActivity.class));
        finish();
      } else if (item.getItemId() == R.id.cart) {
        startActivity(new Intent(getApplicationContext(), CartActivity.class));
        finish();
      } else if (item.getItemId() == R.id.wishlist) {
        startActivity(new Intent(getApplicationContext(), WishlistActivity.class));
        finish();
      } else if (item.getItemId() == R.id.profile) {
        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        finish();
      }
      return false;
    });
  }
}