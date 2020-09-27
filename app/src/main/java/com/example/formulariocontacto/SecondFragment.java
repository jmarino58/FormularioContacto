package com.example.formulariocontacto;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SecondFragment extends Fragment {
    TextView nombre,telefono,mail,descripcion,nacimiento;
    TextView lbl_telefono,lbl_mail,lbl_descripcion,lbl_nacimiento;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View recibida= inflater.inflate(R.layout.fragment_second, container, false);
        nombre=recibida.findViewById(R.id.lbl_nombreSF);
        nombre.setText(getArguments().getString("nombreSaved"));

        telefono=recibida.findViewById(R.id.txt_telefonoFS);
        telefono.setText(getArguments().getString("telefonoSaved"));

        mail=recibida.findViewById(R.id.txt_emailFS);
        mail.setText(getArguments().getString("mailSaved"));

        descripcion=recibida.findViewById(R.id.txt_descripcionFS);
        descripcion.setText(getArguments().getString("descripcionSaved"));

        nacimiento=recibida.findViewById(R.id.tdate_fnacimientoFS);
        nacimiento.setText(getArguments().getString("nacimientoSaved"));

        lbl_telefono=recibida.findViewById(R.id.lbl_telefonoFS);
        lbl_mail=recibida.findViewById(R.id.lbl_emailFS);
        lbl_descripcion=recibida.findViewById(R.id.lbl_descripcionFS);
        lbl_nacimiento=recibida.findViewById(R.id.lbl_fnacimientoFS);

        return recibida;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment,getArguments());
            }
        });
    }
}