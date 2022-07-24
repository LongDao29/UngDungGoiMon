package com.example.ungdunggoimon.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ungdunggoimon.databinding.ItemNotifyBinding;
import com.example.ungdunggoimon.model.Notify;

import java.util.ArrayList;

public class NotifyAdapter extends RecyclerView.Adapter<NotifyAdapter.ItemViewHolder> {

    private ArrayList<Notify> data;

    public void setData(ArrayList<Notify> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public ArrayList<Notify> getData() {
        return data;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNotifyBinding binding = ItemNotifyBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bindData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private ItemNotifyBinding binding;

        public ItemViewHolder(ItemNotifyBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bindData(Notify item) {
            binding.tvMessage.setText(item.getMessage());
            binding.tvTime.setText(item.getDate());
        }
    }
}

