package com.example.vindme.activity.wishlist;

public class Wishlist {

  String namaArtist, judulAlbum, hargaAlbum;
  int coverAlbum;

  public Wishlist(String namaArtist, String judulAlbum, String hargaAlbum, int coverAlbum) {
    this.namaArtist = namaArtist;
    this.judulAlbum = judulAlbum;
    this.hargaAlbum = hargaAlbum;
    this.coverAlbum = coverAlbum;
  }

  public String getNamaArtist() {
    return namaArtist;
  }

  public void setNamaArtist(String namaArtist) {
    this.namaArtist = namaArtist;
  }

  public String getJudulAlbum() {
    return judulAlbum;
  }

  public void setJudulAlbum(String judulAlbum) {
    this.judulAlbum = judulAlbum;
  }

  public String getHargaAlbum() {
    return hargaAlbum;
  }

  public void setHargaAlbum(String hargaAlbum) {
    this.hargaAlbum = hargaAlbum;
  }

  public int getCoverAlbum() {
    return coverAlbum;
  }

  public void setCoverAlbum(int coverAlbum) {
    this.coverAlbum = coverAlbum;
  }
}
