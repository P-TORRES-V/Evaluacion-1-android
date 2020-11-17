package aplicativo.moviles.evaluacion1.Ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import aplicativo.moviles.evaluacion1.R;

public class Ejercicio02 extends AppCompatActivity {
    public EditText edtApellido,edtNombre,edtHt,edtSh;
    public Button btnCalcular;
    public RadioButton rbObrero,rbEmpleado;
    public TextView tvResumen;
    String tipoTrabajador="";
    RadioGroup rbtnGrupo;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio02);
        edtApellido=(EditText)findViewById(R.id.edtApellido);
        edtNombre=(EditText)findViewById(R.id.edtNombre);
        edtHt=(EditText)findViewById(R.id.edtHt);
        edtSh=(EditText)findViewById(R.id.edtSh);
        btnCalcular=(Button)findViewById(R.id.btnCalcular);
        rbObrero=(RadioButton)findViewById(R.id.rbObrero);
        rbEmpleado=(RadioButton) findViewById(R.id.rbEmpleado);
        tvResumen=(TextView) findViewById(R.id.tvResumen);
        rbtnGrupo = findViewById(R.id.rbtnGrupo);

        rbtnGrupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rbObrero){
                    tipoTrabajador = "o";
                }else{
                    tipoTrabajador = "e";
                }
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if(!tipoTrabajador.equals("")){
                        String app = edtApellido.getText().toString();
                        String nom =edtNombre.getText().toString();
                        int ht= Integer.parseInt(edtHt.getText().toString());
                        double sh=Integer.parseInt(edtSh.getText().toString());
                        Empleados obj = new Empleados(
                                app,nom,ht,sh,tipoTrabajador);
                        tvResumen.setText(
                                "Nombre y ap: "+obj.getNombre()+" "+obj.getApellido()
                                +"\nHoras Trabajadas: "+obj.getHorasTrabajadas()+" horas"
                                +"\nSueldo por hora: S/."+obj.getSuelHora()
                                +"\nTipo de Trabajador: "+(obj.getTipoTrabajador().equals("o")?"Obrero":"Empleado")
                                +"\n______________________________________________________"
                                +"\nSueldo Bruto: S/."+obj.sueldoBruto()
                                +"\nDescuento: S/."+obj.descontar_impuesto()
                                +"\nSueldo Neto: S/."+obj.sueldo_neto());

                    }else{
                        Toast.makeText(Ejercicio02.this, "Seleccione Tipo de trabajador", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(Ejercicio02.this, "Complete campos", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}