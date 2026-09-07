package com.example.moviepass;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edtNombre;
    private EditText edtApellido;
    private EditText edtRut;
    private EditText edtCorreo;

    private RadioGroup rgPelicula;
    private RadioGroup rgHorario;
    private RadioGroup rgCantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNombre = findViewById(R.id.edtNombre);
        edtApellido = findViewById(R.id.edtApellido);
        edtRut = findViewById(R.id.edtRut);
        edtCorreo = findViewById(R.id.edtCorreo);

        rgPelicula = findViewById(R.id.rgPelicula);
        rgHorario = findViewById(R.id.rgHorario);
        rgCantidad = findViewById(R.id.rgCantidad);
    }

    public void enviarDatos(View view) {

        String nombre = edtNombre.getText().toString().trim();
        String apellido = edtApellido.getText().toString().trim();
        String rut = edtRut.getText().toString().trim();
        String correo = edtCorreo.getText().toString().trim();

        // Validar campos personales
        if (nombre.isEmpty() ||
                apellido.isEmpty() ||
                rut.isEmpty() ||
                correo.isEmpty()) {

            Toast.makeText(
                    this,
                    "Completa todos los datos del cliente",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        // Validación básica de correo
        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {

            Toast.makeText(
                    this,
                    "Ingresa un correo válido",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        // Validación básica de longitud del RUT
        if (rut.length() < 9) {

            Toast.makeText(
                    this,
                    "Ingresa un RUT válido",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        int peliculaSeleccionada =
                rgPelicula.getCheckedRadioButtonId();

        int horarioSeleccionado =
                rgHorario.getCheckedRadioButtonId();

        int cantidadSeleccionada =
                rgCantidad.getCheckedRadioButtonId();

        if (peliculaSeleccionada == -1 ||
                horarioSeleccionado == -1 ||
                cantidadSeleccionada == -1) {

            Toast.makeText(
                    this,
                    "Selecciona película, horario y cantidad",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        RadioButton rbPelicula =
                findViewById(peliculaSeleccionada);

        RadioButton rbHorario =
                findViewById(horarioSeleccionado);

        RadioButton rbCantidad =
                findViewById(cantidadSeleccionada);

        String pelicula =
                rbPelicula.getText().toString();

        String horario =
                rbHorario.getText().toString();

        int cantidad =
                Integer.parseInt(
                        rbCantidad.getText().toString()
                );

        // Intent explícito hacia EntradaActivity
        Intent intent =
                new Intent(
                        MainActivity.this,
                        EntradaActivity.class
                );

        // Enviar datos personales
        intent.putExtra("nombre", nombre);
        intent.putExtra("apellido", apellido);
        intent.putExtra("rut", rut);
        intent.putExtra("correo", correo);

        // Enviar datos de la entrada
        intent.putExtra("pelicula", pelicula);
        intent.putExtra("horario", horario);
        intent.putExtra("cantidad", cantidad);

        startActivity(intent);
    }
}