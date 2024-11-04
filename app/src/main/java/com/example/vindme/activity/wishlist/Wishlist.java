package com.example.vindme.activity.wishlist;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Wishlist implements Serializable {

  @SerializedName("idWishlist")
  String idWishlist;

  @SerializedName("artis")
  String namaArtist;

  @SerializedName("judul")
  String judulAlbum;

  @SerializedName("harga")
  String hargaAlbum;

  public Wishlist(String idWishlist, String namaArtist, String judulAlbum, String hargaAlbum) {
    this.idWishlist = idWishlist;
    this.namaArtist = namaArtist;
    this.judulAlbum = judulAlbum;
    this.hargaAlbum = hargaAlbum;
  }

  public String getIdWishlist() {
    return idWishlist;
  }

  public String getNamaArtist() {
    return namaArtist;
  }

  public String getJudulAlbum() {
    return judulAlbum;
  }

  public String getHargaAlbum() {
    return hargaAlbum;
  }
}
