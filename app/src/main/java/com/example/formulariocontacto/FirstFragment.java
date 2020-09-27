package com.example.formulariocontacto;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class FirstFragment extends Fragment  {

    EditText nombre,telefono,mail,descripcion;
    String fechanacimiento;
    CalendarView datePicker;
    Bundle extras= new Bundle();


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment

        //Capturamos el View en una variable
        View main = inflater.inflate(R.layout.fragment_first, container, false);
        //Se asigna a cada variable definida arriba cada uno de los EditText
        nombre = main.findViewById(R.id.txt_nombre);
        telefono= main.findViewById(R.id.txt_telefono);
        mail=main.findViewById(R.id.txt_email);
        descripcion=main.findViewById(R.id.txt_descripcion);

        //El tema del Picker de Fechas requiere un poco más de código
        //Primero se captura el CalendarView
        datePicker= (CalendarView) main.findViewById(R.id.calendarView);
        datePicker.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                //Lineas para recuperar dato de calendario
                //y formatearlo a un string
/*
                //capturamos la fecha
                nacimiento= datePicker.getDate();

                //despues se genera una atributo de tipo Calendar para formatear la fecha
                // para poder armar el string a mostrar
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(nacimiento);

                //Se captura en atributos por separado los datos de Año, Mes y Día
                int ano = calendar.get(Calendar.YEAR);
                int mes = calendar.get(Calendar.MONTH);
                int dia = calendar.get(Calendar.DAY_OF_MONTH);
*/
                //Se genera String con fecha en formato dd/mm/aa
                fechanacimiento=dayOfMonth+"/"+(month+1)+"/"+year;


            }
        });

        if (getArguments()!=null)
        {
            nombre.setText(getArguments().getString("nombreSaved"));
            telefono.setText(getArguments().getString("telefonoSaved"));
            mail.setText(getArguments().getString("mailSaved"));
            descripcion.setText(getArguments().getString("descripcionSaved"));
            try {
                datePicker.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(getArguments().getString("nacimientoSaved")).getTime(), true, true);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }




            return main;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btn_siguiente).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //llenamos el bundle con los datos.
                extras.putString("nombreSaved",nombre.getText().toString());
                extras.putString("telefonoSaved",telefono.getText().toString());
                extras.putString("mailSaved",mail.getText().toString());
                extras.putString("descripcionSaved",descripcion.getText().toString());
                extras.putString("nacimientoSaved",fechanacimiento);



                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment,extras);
            }
        });
    }


}