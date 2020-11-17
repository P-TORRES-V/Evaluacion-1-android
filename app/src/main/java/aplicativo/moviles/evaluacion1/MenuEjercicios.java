package aplicativo.moviles.evaluacion1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import aplicativo.moviles.evaluacion1.Ejercicio1.MainActivity;
import aplicativo.moviles.evaluacion1.Ejercicio2.Ejercicio02;
import aplicativo.moviles.evaluacion1.Ejercicio3.Ejercicio3;

public class MenuEjercicios extends AppCompatActivity {
    public Button btnE1,btnE2,btnE3;
    Context ctx=this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ejercicios);
        btnE1=(Button)findViewById(R.id.btnE1);
        btnE2=(Button)findViewById(R.id.btnE2);
        btnE3=(Button)findViewById(R.id.btnE3);
        btnE1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ctx, MainActivity.class));
            }
        });

        btnE1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ctx, MainActivity.class));
            }
        });
        btnE2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ctx, Ejercicio02.class));
            }
        });
        btnE3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ctx, Ejercicio3.class));

            }
        });



    }
}