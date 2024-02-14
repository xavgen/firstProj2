package com.example.firstproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class addEventFragment extends Fragment {

    private com.example.firstproject.databinding.FragmentAddEventBinding binding;
    String title, className, details = "";

    EditText titleInput, classNameInput, detailsInput;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = com.example.firstproject.databinding.FragmentAddEventBinding.inflate(inflater, container, false);
        return binding.getRoot();


    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        titleInput = (EditText) view.findViewById(R.id.titleInput);
        classNameInput = (EditText) view.findViewById(R.id.classNameInput);
        detailsInput = (EditText) view.findViewById(R.id.detailsInput);
        view.findViewById(R.id.saveAddEvent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title = titleInput.getText().toString();
                className = classNameInput.getText().toString();
                details = detailsInput.getText().toString();
                NavHostFragment.findNavController(addEventFragment.this)
                        .popBackStack();

//                Toast.makeText(getActivity(), title, Toast.LENGTH_SHORT).show();
            }
        });
        view.findViewById(R.id.cancelAddEvent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(addEventFragment.this)
                        .popBackStack();

//                Toast.makeText(getActivity(), title, Toast.LENGTH_SHORT).show();
            }
        });


        view.findViewById(R.id.schedule).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(addEventFragment.this)
                        .navigate(R.id.action_addEventFragment_to_SecondFragment2);

            }
        });

        view.findViewById(R.id.toDo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(addEventFragment.this)
                        .navigate(R.id.action_addEventFragment_to_ThirdFragment2);
            }
        });

        view.findViewById(R.id.today).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(addEventFragment.this)
                        .navigate(R.id.action_addEventFragment_to_FirstFragment2);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}