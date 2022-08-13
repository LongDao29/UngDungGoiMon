package com.example.ungdunggoimon.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ungdunggoimon.App;
import com.example.ungdunggoimon.databinding.FragmentHomeBinding;
import com.example.ungdunggoimon.model.Table;
import com.example.ungdunggoimon.ui.MainActivity;
import com.example.ungdunggoimon.ui.adapter.TableAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements TableAdapter.ItemTableClick {
    private FragmentHomeBinding binding;
    private TableAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        binding.refresh.setOnRefreshListener(() -> {
            loadData();
            binding.refresh.setRefreshing(false);
        });
    }
    private void loadData() {
        adapter = new TableAdapter(this);
        binding.rcTable.setAdapter(adapter);
        ((App) getContext().getApplicationContext()).tables.observe(getViewLifecycleOwner(), tables -> {
            adapter.setData(tables);
        });
    }
    @Override
    public void onItemTableClicked(Table item) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(Table.class.getName(), item);
        OrderFragment orderFragment = new OrderFragment();
        orderFragment.setArguments(bundle);
        ((MainActivity) getActivity()).showFm(orderFragment);

    }


}
