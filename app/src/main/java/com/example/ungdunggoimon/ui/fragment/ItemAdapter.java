package com.example.ungdunggoimon.ui.fragment;


import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ungdunggoimon.databinding.ItemItemBinding;
import com.example.ungdunggoimon.databinding.ItemTableBinding;
import com.example.ungdunggoimon.model.Item;
import com.example.ungdunggoimon.model.Table;
import com.example.ungdunggoimon.utils.Constance;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private ArrayList<Item> data;
    private ItemItemClick listener;

    public ItemAdapter(ItemItemClick listener) {
        this.listener = listener;
    }

    public void setData(ArrayList<Item> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public ArrayList<Item> getData() {
        return data;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemItemBinding binding = ItemItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.bindData(data.get(position));
        holder.binding.getRoot().setOnClickListener(v -> {
            listener.onItemItemClicked(data.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private ItemItemBinding binding;

        public ItemViewHolder(ItemItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bindData(Item item) {
            if (item.isSelected()) {
                binding.getRoot().setBackgroundColor(Color.LTGRAY);
            } else {
                binding.getRoot().setBackgroundColor(Color.WHITE);
            }
            binding.tvName.setText(item.getName());
            binding.tvPrice.setText(new DecimalFormat("#,###").format(Integer.parseInt(item.getPrice())));
            String image = Constance.BASE_URL + item.getImages().get(0);
            Glide.with(binding.imItem).load(image).into(binding.imItem);
        }
    }

    public interface ItemItemClick {
        void onItemItemClicked(Item item);
    }
}
