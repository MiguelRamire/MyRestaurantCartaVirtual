package com.upb.myrestaurantevirtual;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void consultarSedes (View v){

        Intent i = new Intent(this,SedeActivity.class);
        startActivity(i);

    }

    public void verMenu (View v){

        Intent i = new Intent(this,MenuActivity.class);
        startActivity(i);

    }

    public void realizarReserva (View v){

        //Intent i = new Intent(this,ReservaActivity.class);
        //startActivity(i);

        String phone = "+573160571065";
        String message = "Hola, desea hacer una reserva con nosotros";

        // Crear el URI para WhatsApp
        Uri uri = Uri.parse("whatsapp://send?phone=" + phone + "&text=" + Uri.encode(message));

        //Objeto tipo administrador de paquetes
        //Proveedor de contenido de aplicaciones de terceros

        PackageManager pm = getPackageManager();
        Intent i = new Intent(Intent.ACTION_VIEW);

        //Configurar número, al cual queremos llamar y el mensaje
        i.setData(uri);
        startActivity(i);


        // Verificar si WhatsApp está instalado
        if (i != null) {
            startActivity(i);
        } else {
            // Si WhatsApp no está instalado, mostrar un mensaje al usuario
            Toast.makeText(this, "WhatsApp no está instalado", Toast.LENGTH_SHORT).show();
        }

    }


}