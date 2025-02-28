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

public class LicoresActivity extends AppCompatActivity {

    private MyAdapterMenu myAdapterMenu = null;

    private static ArrayList<Plato> l_licores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_licores);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setData();

        myAdapterMenu = new MyAdapterMenu(this);

        ListView listView = findViewById(R.id.listaLicores);
        listView.setAdapter(myAdapterMenu);


    }

    public void setData( ) {

        l_licores.clear();


        Plato Aguardiente_Antioqueno = new Plato(
                getResources().getStringArray(R.array.Licores)[0],
                getResources().getStringArray(R.array.Licores)[1],
                R.drawable.aguardiente_antioqueno

        );
        l_licores.add(Aguardiente_Antioqueno);

        Plato Smirnoff = new Plato(
                getResources().getStringArray(R.array.Licores)[2],
                getResources().getStringArray(R.array.Licores)[3],
                R.drawable.smirnoff
        );
        l_licores.add(Smirnoff);

        Plato Corona = new Plato(
                getResources().getStringArray(R.array.Licores)[4],
                getResources().getStringArray(R.array.Licores)[5],
                R.drawable.corona
        );
        l_licores.add(Corona);

        Plato Aguila = new Plato(
                getResources().getStringArray(R.array.Licores)[6],
                getResources().getStringArray(R.array.Licores)[7],
                R.drawable.aguila
        );
        l_licores.add(Aguila);

        Plato Pilsen = new Plato(
                getResources().getStringArray(R.array.Licores)[8],
                getResources().getStringArray(R.array.Licores)[9],
                R.drawable.pilsen
        );
        l_licores.add(Pilsen);

    }

    public static class MyAdapterMenu extends BaseAdapter {

        private Context mContext;
        public MyAdapterMenu(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {
            return l_licores.size();
        }

        @Override
        public Object getItem(int position) {
            return l_licores.get(position);
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
            img.setImageDrawable(mContext.getResources().getDrawable(l_licores.get(position).imagen));
            TextView tTitle = (TextView) view.findViewById(R.id.titulo);
            tTitle.setText(l_licores.get(position).titulo);

            TextView Tdescription = (TextView) view.findViewById(R.id.descripcion);
            Tdescription.setText(l_licores.get(position).descripcion);

            return view;
        }
    }

}