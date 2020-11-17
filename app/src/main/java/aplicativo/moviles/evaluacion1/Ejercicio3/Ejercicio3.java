package aplicativo.moviles.evaluacion1.Ejercicio3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import aplicativo.moviles.evaluacion1.R;


public class Ejercicio3 extends AppCompatActivity {
    //UI
    ListView lvProductos;
    EditText etCant,etNomProd,etPreProd;
    Spinner spnTipoPago;
    TextView tvResumenCompra;
    List<Producto>lista = new ArrayList<>();
    Context ctx = this;
    int pos = -1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);

        lvProductos = findViewById(R.id.lvProductos);
        etCant = findViewById(R.id.etCant);
        etNomProd = findViewById(R.id.etNomProd);
        etPreProd = findViewById(R.id.etPreProd);
        spnTipoPago = findViewById(R.id.spnTipoPago);
        tvResumenCompra = findViewById(R.id.tvResumenCompra);



        lvProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Producto obj = (Producto) parent.getItemAtPosition(position);
                etNomProd.setText(obj.getNombre());
                etPreProd.setText(obj.getPrecio()+"");
                etCant.setText(""+obj.getCantidad());
                pos = position;
            }
        });

    }


    public void agregarProducto(View view) {
        try{
            lista.add(new Producto(
                    etNomProd.getText().toString(),
                    Double.parseDouble(etPreProd.getText().toString().trim()),
                    Integer.parseInt(etCant.getText().toString().trim())));
            actualiazarLv();
            cleanUI();
            resumenCompra();
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(ctx, "Ingrese datos!!!", Toast.LENGTH_SHORT).show();
        }
    }
    public void deleteProducto(View view) {
        try{
            lista.remove(pos);
            actualiazarLv();
            pos=-1;

        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(ctx, "Seleccione un producto para eliminar", Toast.LENGTH_SHORT).show();
        }finally {
            cleanUI();
            resumenCompra();
        }
    }




    private void resumenCompra() {
        double subtotal = 0;
        for (Producto pro : lista){
            subtotal+=pro.getPrecio() * pro.getCantidad();
        }
        double igv = subtotal * 0.18;
        tvResumenCompra.setText(
                "-Subtotal: S/."+subtotal
                +"\n-IGV: S/."+igv
                +"\n-Total: S/."+(subtotal+igv)
                +"\n-Metodo de pago: "+spnTipoPago.getSelectedItem()
        );
    }

    void actualiazarLv(){
        AdapterProducto ada = new AdapterProducto(this,lista);
        lvProductos.setAdapter(ada);
    }
    void cleanUI(){
        etNomProd.setText("");
        etCant.setText("");
        etPreProd.setText("");
    }

}