package example.tarea1_semana2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ConfirmarDatos extends AppCompatActivity {

    ArrayList<String> stringDeDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle parametros = getIntent().getExtras();

        stringDeDatos = parametros.getStringArrayList(getResources().getString(R.string.pStringDeDatos));

        String nombre                   = getResources().getString(R.string.tvNombre)       + " " + stringDeDatos.get(0);
        String fechaDeNacimiento        = getResources().getString(R.string.tvFecha)        + " " + stringDeDatos.get(1);
        String telefono                 = getResources().getString(R.string.tvTelefono)     + " " + stringDeDatos.get(2);
        String email                    = getResources().getString(R.string.tvEmail)        + " " + stringDeDatos.get(3);
        String descripcionDeContacto    = getResources().getString(R.string.tvDescripcion)  + " " + stringDeDatos.get(4);

        TextView tvNombre                = findViewById(R.id.tvNombre);
        TextView tvFechaDeNacimiento     = findViewById(R.id.tvFechaDeNacimiento);
        TextView tvTelefono              = findViewById(R.id.tvTelefono);
        TextView tvEmail                 = findViewById(R.id.tvEmail);
        TextView tvDescripcionDeContacto = findViewById(R.id.tvDescripcionDeContacto);

        tvNombre.setText(nombre);
        tvFechaDeNacimiento.setText(fechaDeNacimiento);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcionDeContacto.setText(descripcionDeContacto);

    }

    public void miClickEditarDatos(View target) {
        Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
        intent.putStringArrayListExtra("stringDeDatos", stringDeDatos);
        //startActivity(intent);
        finish();
    }
}