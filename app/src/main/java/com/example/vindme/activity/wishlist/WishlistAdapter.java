package com.example.vindme.activity.wishlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vindme.R;

import java.util.List;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.WishlistViewHolder> {

  private final Context context;
  private final List<Wishlist> wishlistList;

  public WishlistAdapter(Context context, List<Wishlist> wishlistList) {
    this.context = context;
    this.wishlistList = wishlistList;
  }

  public static class WishlistViewHolder extends RecyclerView.ViewHolder {
    ImageView ivCover;
    TextView tvArtist, tvDescription, tvPrice;

    public WishlistViewHolder(@NonNull View itemView) {
      super(itemView);
      ivCover = itemView.findViewById(R.id.ivCover);
      tvArtist = itemView.findViewById(R.id.tvArtist);
      tvDescription = itemView.findViewById(R.id.tvDescription);
      tvPrice = itemView.findViewById(R.id.tvPrice);
    }
  }

  @NonNull
  @Override
  public WishlistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.row_view_wishlist, parent, false);
    return new WishlistViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull WishlistViewHolder holder, int position) {
    Wishlist wishlist = wishlistList.get(position);
    holder.tvArtist.setText(wishlist.getNamaArtist());
    holder.tvDescription.setText(wishlist.getJudulAlbum());
    holder.tvPrice.setText("Rp. " + wishlist.getHargaAlbum());
    holder.ivCover.setImageResource(wishlist.getCoverAlbum());

    holder.ivCover.setOnClickListener(v -> {
      Toast.makeText(context, wishlist.getJudulAlbum(), Toast.LENGTH_SHORT).show();
    });
  }

  @Override
  public int getItemCount() {
    return wishlistList.size();
  }
}
