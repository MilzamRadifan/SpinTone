package com.example.vindme.activity.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.vindme.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

  private RecyclerView recyclerView;
  private HomeAdapter homeAdapter;
  private List<Album> albumList;

  // TODO: Rename parameter arguments, choose names that match
  // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
  private static final String ARG_PARAM1 = "param1";
  private static final String ARG_PARAM2 = "param2";

  // TODO: Rename and change types of parameters
  private String mParam1;
  private String mParam2;

  public HomeFragment() {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @param param1 Parameter 1.
   * @param param2 Parameter 2.
   * @return A new instance of fragment HomeFragment.
   */
  // TODO: Rename and change types and number of parameters
  public static HomeFragment newInstance(String param1, String param2) {
    HomeFragment fragment = new HomeFragment();
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

    View view = inflater.inflate(R.layout.fragment_home, container, false);

    recyclerView = view.findViewById(R.id.rvHome);
    albumList = new ArrayList<>();
    homeAdapter = new HomeAdapter(getContext(), albumList);
    recyclerView.setAdapter(homeAdapter);
    recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

    fetchAlbums();

    return view;
    // Inflate the layout for this fragment
  }

  private void fetchAlbums() {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("http://10.0.2.2/ApiVindMe/")
        .build();

    ApiInterface apiInterface = retrofit.create(ApiInterface.class);
    Call<ResponseBody> call = apiInterface.getAlbum();

    call.enqueue(new Callback<ResponseBody>() {
      @Override
      public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        if (response.isSuccessful() && response.body() != null) {
          try {
            String json = response.body().string();
            Gson gson = new Gson();
            Type albumListType = new TypeToken<List<Album>>(){}.getType();
            List<Album> albums = gson.fromJson(json, albumListType);

            albumList.clear();
            albumList.addAll(albums);
            homeAdapter.notifyDataSetChanged();

          } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "Error parsing data", Toast.LENGTH_SHORT).show();
          }
        } else {
          Toast.makeText(getContext(), "Gagal mengambil data", Toast.LENGTH_SHORT).show();
        }
      }

      @Override
      public void onFailure(Call<ResponseBody> call, Throwable t) {
        Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
      }
    });
  }
}