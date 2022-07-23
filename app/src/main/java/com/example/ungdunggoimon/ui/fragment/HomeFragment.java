package com.example.ungdunggoimon.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ungdunggoimon.databinding.FragmentHomeBinding;
import com.example.ungdunggoimon.model.Table;
import com.example.ungdunggoimon.ui.adapter.TableAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements ValueEventListener ,TableAdapter.ItemTableClick {

    private FragmentHomeBinding binding;
    private TableAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new TableAdapter(this);
        binding.rcTable.setAdapter(adapter);

    }
    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        ArrayList<Table> data = new ArrayList<>();
        for (DataSnapshot sn: snapshot.getChildren()) {
            Table table = sn.getValue(Table.class);
            table.setId(sn.getKey());
            data.add(table);
        }
        adapter.setData(data);
    }
//hello
    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }

    @Override
    public void onItemTableClicked(Table item) {

    }
}
