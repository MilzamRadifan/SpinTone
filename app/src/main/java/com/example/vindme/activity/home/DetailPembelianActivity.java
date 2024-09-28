package com.example.vindme.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vindme.R;

public class DetailPembelianActivity extends AppCompatActivity {

  TextView tvArtist;
  TextView tvTitle;
  Button btBuy;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    EdgeToEdge.enable(this);
    setContentView(R.layout.activity_detail_pembelian);

    tvArtist = findViewById(R.id.tvArtist);
    tvTitle = findViewById(R.id.tvTitle);
    btBuy = findViewById(R.id.btBuy);

    Intent intent = getIntent();

    String artist = intent.getStringExtra("artist_name");
    String title = intent.getStringExtra("album_title");


    tvArtist.setText(artist);
    tvTitle.setText(title);

    btBuy.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);

        intent.putExtra("message", "Kamu telah membeli album " + title );

        startActivity(intent);
      }
    });

  }
}