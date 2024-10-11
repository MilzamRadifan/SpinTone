package com.example.vindme.activity.wishlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vindme.activity.cart.CartActivity;
import com.example.vindme.activity.profile.ProfileActivity;
import com.example.vindme.R;
import com.example.vindme.activity.home.HomeActivity;
import com.example.vindme.activity.search.SearchActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class WishlistActivity extends AppCompatActivity {
//
//TextView tvArtist, tvDescription, tvPrice;
//Button btBuy;
//
//String artis, deskripsi, harga;

  RecyclerView rvWishlist;
  WishlistAdapter wishlistAdapter;
  List<Wishlist> wishlistList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_wishlist);

    //Progres Recycle view
    rvWishlist = findViewById(R.id.rvWishlist);
    wishlistList = new ArrayList<>();

    wishlistList.add(new Wishlist("Taylor Swift", "The Tortured Poets Department Vinyl", "699,000", R.drawable.taylor_swift));
    wishlistList.add(new Wishlist("Ariana Grande", "eternal sunshine (exclusive cover no. 2) lp", "599,000", R.drawable.ariana_grande));
    wishlistList.add(new Wishlist("Billie Eilish", "HIT ME HARD AND SOFT", "585,000", R.drawable.billie_eillish));
    wishlistList.add(new Wishlist("Queen ", "The Works Vinyl", "450,000", R.drawable.queen_theworks));
    wishlistList.add(new Wishlist("ABBA", "Arrival Vinyl", "515.000", R.drawable.abba_arrival));

    wishlistAdapter = new WishlistAdapter(this, wishlistList);
    rvWishlist.setAdapter(wishlistAdapter);
    rvWishlist.setLayoutManager(new GridLayoutManager(this, 1));


//    tvArtist = findViewById(R.id.tvArtist);
//    tvDescription = findViewById(R.id.tvDescription);
//    tvPrice = findViewById(R.id.tvPrice);
//    btBuy = findViewById(R.id.btBuy);
//
//    artis = getIntent().getStringExtra("artis");
//    deskripsi = getIntent().getStringExtra("deskripsi");
//    harga = getIntent().getStringExtra("harga");
//
//    tvArtist.setText(artis);
//    tvDescription.setText(deskripsi);
//    tvPrice.setText("Rp. " + harga);
//
//    btBuy.setOnClickListener(new View.OnClickListener() {
//      @Override
//      public void onClick(View v) {
//        Intent intent = new Intent(getApplicationContext(), AddWishlistActivity.class);
//        intent.putExtra("pesan", "sold");
//        startActivity(intent);
//      }
//    });

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