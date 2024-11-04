package com.example.vindme.activity.home;

import java.io.Serializable;

public class Album implements Serializable {
  private int albumId;
  private String cover, title, artist, detailAlbum, price;

  public Album(int albumId, String cover, String title, String artist, String detailAlbum, String price) {
    this.albumId = albumId;
    this.cover = cover;
    this.title = title;
    this.artist = artist;
    this.detailAlbum = detailAlbum;
    this.price = price;
  }

  public int getAlbumId() {
    return albumId;
  }

  public void setAlbumId(int albumId) {
    this.albumId = albumId;
  }

  public String getCover() {
    return cover;
  }

  public void setCover(String cover) {
    this.cover = cover;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public String getDetailAlbum() {
    return detailAlbum;
  }

  public void setDetailAlbum(String detailAlbum) {
    this.detailAlbum = detailAlbum;
  }

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }
}