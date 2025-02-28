package com.upb.myrestaurantevirtual;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class EntradasActivity extends AppCompatActivity {

    private MyAdapterMenu myAdapterMenu = null;

    private static ArrayList<Plato> l_entradas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_entradas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        setData();

        myAdapterMenu = new MyAdapterMenu(this);

        ListView listView = findViewById(R.id.listaEntradas);
        listView.setAdapter(myAdapterMenu);


    }

    public void setData( ) {

        l_entradas.clear();


        Plato Empanadas = new Plato(
                getResources().getStringArray(R.array.entradas)[0],
                getResources().getStringArray(R.array.entradas)[1],
                R.drawable.empanadas

        );
        l_entradas.add(Empanadas);

        Plato Patacones = new Plato(
                getResources().getStringArray(R.array.entradas)[2],
                getResources().getStringArray(R.array.entradas)[3],
                R.drawable.patacones
        );
        l_entradas.add(Patacones);

        Plato Sopa_de_zanahoria = new Plato(
                getResources().getStringArray(R.array.entradas)[4],
                getResources().getStringArray(R.array.entradas)[5],
                R.drawable.sopa_de_zanahoria
        );
        l_entradas.add(Sopa_de_zanahoria);

        Plato Deditos_de_Quesos = new Plato(
                getResources().getStringArray(R.array.entradas)[6],
                getResources().getStringArray(R.array.entradas)[7],
                R.drawable.deditos_de_queso
        );
        l_entradas.add(Deditos_de_Quesos);

        Plato Pande_Queso = new Plato(
                getResources().getStringArray(R.array.entradas)[8],
                getResources().getStringArray(R.array.entradas)[9],
                R.drawable.pan_de_queso
        );
        l_entradas.add(Pande_Queso);

    }

    public static class MyAdapterMenu extends BaseAdapter {

        private Context mContext;
        public MyAdapterMenu(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {
            return l_entradas.size();
        }

        @Override
        public Object getItem(int position) {
            return l_entradas.get(position);
        }

        @Override
        public long getItemId(int i) {

            return 0;
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = null;

            if (convertView == null) {
                // Make up a new view
                LayoutInflater inflater = (LayoutInflater) mContext
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.menu_cat_layout, null);
            } else {
                // Use convertView if it is available
                view = convertView;
            }

            // Example to get an image resource
            ImageView img = (ImageView) view.findViewById(R.id.image);
            img.setImageDrawable(mContext.getResources().getDrawable(l_entradas.get(position).imagen));
            TextView tTitle = (TextView) view.findViewById(R.id.titulo);
            tTitle.setText(l_entradas.get(position).titulo);

            TextView Tdescription = (TextView) view.findViewById(R.id.descripcion);
            Tdescription.setText(l_entradas.get(position).descripcion);

            return view;
        }
    }

}