package com.example.ungdunggoimon.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ungdunggoimon.App;
import com.example.ungdunggoimon.databinding.FragmentSettingBinding;
import com.example.ungdunggoimon.model.User;
import com.example.ungdunggoimon.ui.LoginActivity;
import com.example.ungdunggoimon.ui.MainActivity;
import com.example.ungdunggoimon.utils.Constance;
import com.google.firebase.database.FirebaseDatabase;

public class SettingFragment extends Fragment {
    private FragmentSettingBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSettingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnLogout.setOnClickListener(v -> {
            User user = ((App) getContext().getApplicationContext()).user;
            user.setToken("");
            FirebaseDatabase.getInstance().getReference("users")
                    .child(user.getId())
                    .setValue(user);
            getContext().getSharedPreferences(Constance.PREFERENCES_NAME, Context.MODE_PRIVATE).edit().clear().commit();
            Intent intent = new Intent(getContext(), LoginActivity.class);
            startActivity(intent);
            getActivity().finish();
        });
        MainActivity act = (MainActivity) getActivity();
        binding.tvInfo.setOnClickListener(v -> {
            act.showFm(act.fmInfo);
        });

        binding.tvChangePassword.setOnClickListener(v -> {
            act.showFm(new ChangePasswordFragment());
        });
    }

}
