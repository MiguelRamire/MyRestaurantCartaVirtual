package com.upb.myrestaurantevirtual;

import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ListView;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    //Declaración de variables

    private MyAdapterMenu myAdapterMenu = null;

    private static ArrayList<Plato> l_categorias = new ArrayList<>();

    //String[] CATEGORIAS = new String [] {"Entradas" , "Platos Fuertes" , "Bebidas" , "Postres" , "Licores"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /* Obtener el id del archivo xml
        ListView lv = findViewById(android.R.id.list);

        //Prepara contenido
        ListAdapter la = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, CATEGORIAS);

        //Asigna contenido a la vista
        lv.setAdapter(la);

        lv.setOnItemClickListener(this);
        */

        setData();

        myAdapterMenu = new MyAdapterMenu(this);

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(myAdapterMenu);

        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){

        switch (i){

            case 0: Intent intencion = new Intent(this, EntradasActivity.class);
                startActivity(intencion);
                break;

            case 1: Intent intencion1 = new Intent(this, PlatosFuertesActivity.class);
                startActivity(intencion1);
                break;

            case 2: Intent intencion2 = new Intent(this, BebidasActivity.class);
                startActivity(intencion2);
                break;

            case 3: Intent intencion3 = new Intent(this, PostresActivity.class);
                startActivity(intencion3);
                break;

            case 4: Intent intencion4 = new Intent(this, LicoresActivity.class);
                startActivity(intencion4);
                break;

            //Insertar otros productos

        }

    }

    public void setData( ) {

        l_categorias.clear();


        Plato entradas = new Plato(
                getResources().getStringArray(R.array.categorias)[0],
                getResources().getStringArray(R.array.categorias)[1],
                R.drawable.entradas

        );
        l_categorias.add(entradas);

        Plato platosFuerte = new Plato(
                getResources().getStringArray(R.array.categorias)[2],
                getResources().getStringArray(R.array.categorias)[3],
                R.drawable.platosfuertes
        );
        l_categorias.add(platosFuerte);

        Plato bebidas = new Plato(
                getResources().getStringArray(R.array.categorias)[4],
                getResources().getStringArray(R.array.categorias)[5],
                R.drawable.bebidas
        );
        l_categorias.add(bebidas);

        Plato postres = new Plato(
                getResources().getStringArray(R.array.categorias)[6],
                getResources().getStringArray(R.array.categorias)[7],
                R.drawable.postres
        );
        l_categorias.add(postres);

        Plato licores = new Plato(
                getResources().getStringArray(R.array.categorias)[8],
                getResources().getStringArray(R.array.categorias)[9],
                R.drawable.licores
        );
        l_categorias.add(licores);

    }

    public static class MyAdapterMenu extends BaseAdapter {

        private Context mContext;
        public MyAdapterMenu(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {
            return l_categorias.size();
        }

        @Override
        public Object getItem(int position) {
            return l_categorias.get(position);
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
            img.setImageDrawable(mContext.getResources().getDrawable(l_categorias.get(position).imagen));
            TextView tTitle = (TextView) view.findViewById(R.id.titulo);
            tTitle.setText(l_categorias.get(position).titulo);

            TextView Tdescription = (TextView) view.findViewById(R.id.descripcion);
            Tdescription.setText(l_categorias.get(position).descripcion);

            return view;
        }
    }

}