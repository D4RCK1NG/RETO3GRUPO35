package com.example.reto3.Vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.reto3.R;

import androidx.fragment.app.Fragment;


public class FragmentSucursales extends Fragment {


    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_sucursales, container, false);
        return v;
    }
}