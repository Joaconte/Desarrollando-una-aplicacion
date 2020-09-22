package example.tarea1_semana2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextInputEditText tietNombre;
    TextInputEditText tietSelectorDeFecha;
    TextInputEditText tietTelefono;
    TextInputEditText tietEmail;
    TextInputEditText tietDescripcionDeContacto;
    Calendar calendario = Calendar.getInstance();
    Contacto contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tietNombre                = findViewById(R.id.tietNombre);
        tietTelefono              = findViewById(R.id.tietTelefono);
        tietEmail                 = findViewById(R.id.tietEmail);
        tietDescripcionDeContacto = findViewById(R.id.tietDescripcionDeContacto);

        tietSelectorDeFecha = findViewById(R.id.tietSelectorDeFecha);
        tietSelectorDeFecha.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                new DatePickerDialog(MainActivity.this, date, calendario
                        .get(Calendar.YEAR), calendario.get(Calendar.MONTH),
                        calendario.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    public void miClickBotonSiguiente(View target) {
        Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
        contacto = new Contacto(tietNombre.getText().toString(), tietSelectorDeFecha.getText().toString(),
                tietTelefono.getText().toString(), tietEmail.getText().toString(),
                tietDescripcionDeContacto.getText().toString());
        intent.putStringArrayListExtra("stringDeDatos", contacto.stringDeDatos());
        startActivity(intent);
        //finish();
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            calendario.set(Calendar.YEAR, year);
            calendario.set(Calendar.MONTH, monthOfYear);
            calendario.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            actualizarInput();
        }
    };

    private void actualizarInput() {
        String formatoDeFecha = "dd/MM/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(formatoDeFecha, Locale.US );

        tietSelectorDeFecha.setText(sdf.format(calendario.getTime()));
    }

}