package com.moutamid.postapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moutamid.postapp.ItemAdapter;
import com.moutamid.postapp.ItemModel;
import com.moutamid.postapp.R;

import java.util.ArrayList;

public class ListFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<ItemModel> itemModels;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        itemModels = new ArrayList<>();
        recyclerView = view.findViewById(R.id.recyler);
        recyclerView.setHasFixedSize(false);
        getData();

        return view;
    }

    private void getData() {
        ArrayList<String> images1 = new ArrayList<>();
        images1.add("https://picsum.photos/500/300?random=1");
        images1.add("https://picsum.photos/500/300?random=1");
        images1.add("https://picsum.photos/500/300?random=1");
        images1.add("https://picsum.photos/500/300?random=1");
        ItemModel model1 = new ItemModel(
                R.drawable.profile_icon, "Suleman Ijaz", "2 hours ago", "Sialkot", images1,
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Architecto debitis eaque quam qui! Nemo, quis."
        );

        ArrayList<String> images2 = new ArrayList<>();
        images2.add("https://picsum.photos/500/300?random=1");
        images2.add("https://picsum.photos/500/300?random=1");
        ItemModel model2 = new ItemModel(
                R.drawable.profile_icon, "Moutamid", "7 hours ago", "Dubai", images2,
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Architecto debitis eaque quam qui! Nemo, quis."
        );

        ArrayList<String> images3 = new ArrayList<>();
        images3.add("https://picsum.photos/500/300?random=1");
        images3.add("https://picsum.photos/500/300?random=1");
        images3.add("https://picsum.photos/500/300?random=1");

        ItemModel mode3 = new ItemModel(
                R.drawable.profile_icon, "Emma Brony", "37 mints ago", "Paris", images3,
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Architecto debitis eaque quam qui! Nemo, quis."
        );

        itemModels.add(model1);
        itemModels.add(model2);
        itemModels.add(mode3);

        ItemAdapter adapter = new ItemAdapter(requireContext(), itemModels);
        recyclerView.setAdapter(adapter);

    }

}