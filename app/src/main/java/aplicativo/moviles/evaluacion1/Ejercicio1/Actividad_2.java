package aplicativo.moviles.evaluacion1.Ejercicio1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import aplicativo.moviles.evaluacion1.R;

public class Actividad_2 extends AppCompatActivity {
    String usu;
    Context ctx = this;
    EditText edtUserValidate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_2);
        edtUserValidate = findViewById(R.id.edtUserValidate);
        try{
            usu = getIntent().getExtras().getString("usuario");
            edtUserValidate.setEnabled(false);
            edtUserValidate.setText(usu);
            AlertDialog alert = new AlertDialog.Builder(ctx)
                    .setTitle("Hola!!")
                    .setMessage("Bienvenido "+usu)
                    .setIcon(R.drawable.ic_launcher_background)
                    .show();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}