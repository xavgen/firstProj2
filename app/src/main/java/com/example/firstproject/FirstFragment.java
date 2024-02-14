package com.example.firstproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.firstproject.databinding.FragmentFirstBinding;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    public String date;
    TextView tvDate;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        Date currentDate = Calendar.getInstance().getTime();
        date = DateFormat.getDateInstance(DateFormat.LONG).format(currentDate);
        View fragmentFirstLayout = inflater.inflate(R.layout.fragment_first, container, false);
        tvDate = fragmentFirstLayout.findViewById(R.id.date);
        tvDate.setText(date);


//        binding = FragmentFirstBinding.inflate(inflater, container, false);
//        return binding.getRoot();
        return fragmentFirstLayout;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.schedule).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        view.findViewById(R.id.toDo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_ThirdFragment);
            }
        });

        view.findViewById(R.id.addEvent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_addEventFragment2);
            }
        });



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}