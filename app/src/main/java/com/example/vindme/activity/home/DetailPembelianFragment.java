package com.example.vindme.activity.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.vindme.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailPembelianFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailPembelianFragment extends Fragment {

  private TextView tvArtist, tvTitle, tvPrice, tvDetail;
  private ImageView ivCover;

  // TODO: Rename parameter arguments, choose names that match
  // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  private static final String ARG_PARAM1 = "param1";
  private static final String ARG_PARAM2 = "param2";

  // TODO: Rename and change types of parameters
  private String mParam1;
  private String mParam2;

  public DetailPembelianFragment() {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @param param1 Parameter 1.
   * @param param2 Parameter 2.
   * @return A new instance of fragment DetailPembelianFragment.
   */
  // TODO: Rename and change types and number of parameters
  public static DetailPembelianFragment newInstance(String param1, String param2) {
    DetailPembelianFragment fragment = new DetailPembelianFragment();
    Bundle args = new Bundle();
    args.putString(ARG_PARAM1, param1);
    args.putString(ARG_PARAM2, param2);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      mParam1 = getArguments().getString(ARG_PARAM1);
      mParam2 = getArguments().getString(ARG_PARAM2);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_detail_pembelian, container, false);

    tvArtist = view.findViewById(R.id.tvArtist);
    tvTitle = view.findViewById(R.id.tvTitle);
    tvPrice = view.findViewById(R.id.tvPrice);
    ivCover = view.findViewById(R.id.ivCover);
    tvDetail = view.findViewById(R.id.tvDetail);

    if (getArguments() != null) {
      String cover = getArguments().getString("cover");
      String title = getArguments().getString("title");
      String artist = getArguments().getString("artist");
      String detail = getArguments().getString("detail");
      String price = getArguments().getString("price");
      String pesan = getArguments().getString("pesan");

      Glide.with(requireContext()).load(cover).into(ivCover);
      tvArtist.setText(artist);
      tvTitle.setText(title);
      tvPrice.setText(price);
      tvDetail.setText(detail);

      Toast.makeText(getContext(), pesan, Toast.LENGTH_SHORT).show();
    }

    return view;
  }
}