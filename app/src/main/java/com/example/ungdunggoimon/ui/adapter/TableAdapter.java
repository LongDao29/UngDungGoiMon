package com.example.ungdunggoimon.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ungdunggoimon.databinding.ItemTableBinding;
import com.example.ungdunggoimon.model.Table;

import java.util.ArrayList;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.TableViewHolder>{

    private ArrayList<Table> data;
    private ItemTableClick listener;
    public TableAdapter(ItemTableClick listener) {
        this.listener = listener;
    }

    public void setData(ArrayList<Table> data) {
        this.data = data;
        notifyDataSetChanged();
    }
    public ArrayList<Table> getData() {
        return data;
    }


    @NonNull
    @Override
    public TableAdapter.TableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTableBinding binding = ItemTableBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new TableViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TableViewHolder holder, int position) {
        holder.bindData(data.get(position));
        holder.binding.getRoot().setOnClickListener(v -> {
            listener.onItemTableClicked(data.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }
    class TableViewHolder extends RecyclerView.ViewHolder {
        private ItemTableBinding binding;

        public TableViewHolder(ItemTableBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bindData(Table item) {
            binding.tvName.setText(item.getName());
        }
    }
    public interface ItemTableClick {
        void onItemTableClicked(Table item);
    }
}
