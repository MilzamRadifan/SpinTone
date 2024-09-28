package com.example.vindme.activity.home;

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
import com.example.vindme.activity.search.SearchActivity;
import com.example.vindme.activity.wishlist.WishlistActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

  TextView tvArtist;
  TextView tvTitle;
  TextView tvMessage;
  Button btBeli;

  String artist = "Ariana Grendel";
  String title = "The Tortured Poets";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_home);

    tvArtist = findViewById(R.id.tvArtist);
    tvTitle = findViewById(R.id.tvTitle);
    btBeli = findViewById(R.id.btBuy);
    tvMessage = findViewById(R.id.tvMessage);

    tvArtist.setText(artist);
    tvTitle.setText(title);

    btBeli.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), DetailPembelianActivity.class);

        intent.putExtra("artist_name", artist);
        intent.putExtra("album_title", title);

        startActivity(intent);
      }
    });

    Intent intent = getIntent();

    String pesan = intent.getStringExtra("message");
    tvMessage.setText(pesan);

    BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
    bottomNav.setSelectedItemId(R.id.home);
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