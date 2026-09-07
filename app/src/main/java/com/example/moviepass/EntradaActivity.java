package com.example.moviepass;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.Locale;

public class EntradaActivity extends AppCompatActivity {

    private TextView txtNombre;
    private TextView txtApellido;
    private TextView txtRut;
    private TextView txtCorreo;

    private TextView txtPelicula;
    private TextView txtHorario;
    private TextView txtCantidad;
    private TextView txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_entrada);

        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtRut = findViewById(R.id.txtRut);
        txtCorreo = findViewById(R.id.txtCorreo);

        txtPelicula = findViewById(R.id.txtPelicula);
        txtHorario = findViewById(R.id.txtHorario);
        txtCantidad = findViewById(R.id.txtCantidad);
        txtTotal = findViewById(R.id.txtTotal);

        Button btnVolver =
                findViewById(R.id.btnVolver);

        // Obtener Intent enviado desde MainActivity
        Intent intent = getIntent();

        // Recuperar datos personales
        String nombre =
                intent.getStringExtra("nombre");

        String apellido =
                intent.getStringExtra("apellido");

        String rut =
                intent.getStringExtra("rut");

        String correo =
                intent.getStringExtra("correo");

        // Recuperar información de la entrada
        String pelicula =
                intent.getStringExtra("pelicula");

        String horario =
                intent.getStringExtra("horario");

        int cantidad =
                intent.getIntExtra("cantidad", 0);

        // Precio por entrada
        int precioEntrada = 5000;

        // Calcular total
        int total =
                cantidad * precioEntrada;

        // Formato de miles chileno
        NumberFormat formato =
                NumberFormat.getNumberInstance(
                        new Locale("es", "CL")
                );

        // Mostrar datos personales
        txtNombre.setText(
                "Nombre: " + nombre
        );

        txtApellido.setText(
                "Apellido: " + apellido
        );

        txtRut.setText(
                "RUT: " + rut
        );

        txtCorreo.setText(
                "Correo: " + correo
        );

        // Mostrar información de la entrada
        txtPelicula.setText(
                "Película: " + pelicula
        );

        txtHorario.setText(
                "Horario: " + horario
        );

        txtCantidad.setText(
                "Entradas: " + cantidad
        );

        txtTotal.setText(
                "Total: $" + formato.format(total)
        );

        Toast.makeText(
                this,
                "Entrada generada correctamente",
                Toast.LENGTH_SHORT
        ).show();

        btnVolver.setOnClickListener(
                v -> finish()
        );
    }
}