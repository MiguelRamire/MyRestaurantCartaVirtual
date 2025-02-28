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

public class PlatosFuertesActivity extends AppCompatActivity {

    private MyAdapterMenu myAdapterMenu = null;

    private static ArrayList<Plato> l_platosfuertes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_platos_fuertes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setData();

        myAdapterMenu = new MyAdapterMenu(this);

        ListView listView = findViewById(R.id.listaPlatosFuertes);
        listView.setAdapter(myAdapterMenu);


    }

    public void setData( ) {

        l_platosfuertes.clear();


        Plato Sancocho = new Plato(
                getResources().getStringArray(R.array.Platos_Fuertes)[0],
                getResources().getStringArray(R.array.Platos_Fuertes)[1],
                R.drawable.sancocho

        );
        l_platosfuertes.add(Sancocho);

        Plato Bandeja_Paisa = new Plato(
                getResources().getStringArray(R.array.Platos_Fuertes)[2],
                getResources().getStringArray(R.array.Platos_Fuertes)[3],
                R.drawable.bandeja_paisa
        );
        l_platosfuertes.add(Bandeja_Paisa);

        Plato Frijoles = new Plato(
                getResources().getStringArray(R.array.Platos_Fuertes)[4],
                getResources().getStringArray(R.array.Platos_Fuertes)[5],
                R.drawable.frijoles
        );
        l_platosfuertes.add(Frijoles);

        Plato Mondongo = new Plato(
                getResources().getStringArray(R.array.Platos_Fuertes)[6],
                getResources().getStringArray(R.array.Platos_Fuertes)[7],
                R.drawable.mondongo
        );
        l_platosfuertes.add(Mondongo);

        Plato Tilapia = new Plato(
                getResources().getStringArray(R.array.Platos_Fuertes)[8],
                getResources().getStringArray(R.array.Platos_Fuertes)[9],
                R.drawable.tilapia
        );
        l_platosfuertes.add(Tilapia);

    }

    public static class MyAdapterMenu extends BaseAdapter {

        private Context mContext;
        public MyAdapterMenu(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {
            return l_platosfuertes.size();
        }

        @Override
        public Object getItem(int position) {
            return l_platosfuertes.get(position);
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
            img.setImageDrawable(mContext.getResources().getDrawable(l_platosfuertes.get(position).imagen));
            TextView tTitle = (TextView) view.findViewById(R.id.titulo);
            tTitle.setText(l_platosfuertes.get(position).titulo);

            TextView Tdescription = (TextView) view.findViewById(R.id.descripcion);
            Tdescription.setText(l_platosfuertes.get(position).descripcion);

            return view;
        }
    }

}