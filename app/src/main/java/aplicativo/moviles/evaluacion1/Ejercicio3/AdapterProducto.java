package aplicativo.moviles.evaluacion1.Ejercicio3;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;


import java.util.List;

import aplicativo.moviles.evaluacion1.R;

public class AdapterProducto implements ListAdapter {
    Context ctx;
    List<Producto>lista;

    public AdapterProducto(Context ctx, List<Producto> lista) {
        this.ctx = ctx;
        this.lista = lista;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Producto obj = lista.get(position);
        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(ctx);
            convertView=layoutInflater.inflate(R.layout.item_productos, null);

            TextView tvNomProd = convertView.findViewById(R.id.tvNomProducto);
            TextView tvPrecioProd = convertView.findViewById(R.id.tvPreProducto);
            TextView tvCantProducto = convertView.findViewById(R.id.tvCantProducto);

            tvNomProd.setText(obj.getNombre());
            tvPrecioProd.setText("Precio: S/. "+obj.getPrecio());
            tvCantProducto.setText("Stock: "+obj.getCantidad());

        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return lista.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
