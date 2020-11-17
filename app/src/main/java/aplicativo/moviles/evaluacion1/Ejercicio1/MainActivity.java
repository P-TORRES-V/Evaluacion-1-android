package aplicativo.moviles.evaluacion1.Ejercicio1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import aplicativo.moviles.evaluacion1.R;

public class MainActivity extends AppCompatActivity {
    public EditText edtUsuario,edtPass;
    public Button btnIngresar,btnSalir;
    Context ctx=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUsuario=(EditText)findViewById(R.id.edtUsuario);
        edtPass=(EditText)findViewById(R.id.edtPass);
        btnIngresar=(Button)findViewById(R.id.btnE1);
        btnSalir=(Button)findViewById(R.id.btnE2);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuarios usu = new Usuarios(
                        edtUsuario.getText().toString().trim(),
                        edtPass.getText().toString().trim());

                if(usu.isUserValidate()!=null){
                    Intent i= new Intent(ctx, Actividad_2.class);
                    i.putExtra("usuario",usu.isUserValidate());

                    startActivity(i);
                }else{
                    AlertDialog alert = new AlertDialog.Builder(ctx)
                            .setTitle("Error!!")
                            .setMessage("Este usuario no existe")
                            .setIcon(R.drawable.ic_launcher_background)
                            .show();
                }
            }
        });
    }
}