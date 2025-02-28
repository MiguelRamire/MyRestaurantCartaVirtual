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

public class PostresActivity extends AppCompatActivity {

    private MyAdapterMenu myAdapterMenu = null;

    private static ArrayList<Plato> l_postres = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_postres);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        setData();

        myAdapterMenu = new MyAdapterMenu(this);

        ListView listView = findViewById(R.id.listaPostres);
        listView.setAdapter(myAdapterMenu);



    }

    public void setData( ) {

        l_postres.clear();


        Plato Tiramisu = new Plato(
                getResources().getStringArray(R.array.Postres)[0],
                getResources().getStringArray(R.array.Postres)[1],
                R.drawable.tiramisu

        );
        l_postres.add(Tiramisu);

        Plato Flan = new Plato(
                getResources().getStringArray(R.array.Postres)[2],
                getResources().getStringArray(R.array.Postres)[3],
                R.drawable.flan
        );
        l_postres.add(Flan);

        Plato Helado = new Plato(
                getResources().getStringArray(R.array.Postres)[4],
                getResources().getStringArray(R.array.Postres)[5],
                R.drawable.helado
        );
        l_postres.add(Helado);

        Plato Oreo = new Plato(
                getResources().getStringArray(R.array.Postres)[6],
                getResources().getStringArray(R.array.Postres)[7],
                R.drawable.oreo
        );
        l_postres.add(Oreo);

        Plato Fresas_con_Crema = new Plato(
                getResources().getStringArray(R.array.Postres)[8],
                getResources().getStringArray(R.array.Postres)[9],
                R.drawable.fresas_con_crema
        );
        l_postres.add(Fresas_con_Crema);

    }

    public static class MyAdapterMenu extends BaseAdapter {

        private Context mContext;
        public MyAdapterMenu(Context c) {
            mContext = c;
        }

        @Override
        public int getCount() {
            return l_postres.size();
        }

        @Override
        public Object getItem(int position) {
            return l_postres.get(position);
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
            img.setImageDrawable(mContext.getResources().getDrawable(l_postres.get(position).imagen));
            TextView tTitle = (TextView) view.findViewById(R.id.titulo);
            tTitle.setText(l_postres.get(position).titulo);

            TextView Tdescription = (TextView) view.findViewById(R.id.descripcion);
            Tdescription.setText(l_postres.get(position).descripcion);

            return view;
        }
    }

}