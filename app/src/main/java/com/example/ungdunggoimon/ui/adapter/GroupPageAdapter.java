package com.example.ungdunggoimon.ui.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.ungdunggoimon.model.Group;
import com.example.ungdunggoimon.model.Item;
import com.example.ungdunggoimon.ui.fragment.GroupItemFragment;

import java.util.List;

public class GroupPageAdapter extends FragmentStateAdapter {
    private List<Group> groups;
    public GroupPageAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
        notifyDataSetChanged();
    }

    public List<Group> getGroups() {
        return groups;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        GroupItemFragment fm = new GroupItemFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Item.class.getName(), groups.get(position).getItems());
        fm.setArguments(bundle);
        return fm;
    }

    @Override
    public int getItemCount() {
        return groups == null ? 0 : groups.size();
    }


}
