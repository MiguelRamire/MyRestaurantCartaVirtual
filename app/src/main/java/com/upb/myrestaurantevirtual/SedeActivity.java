package com.upb.myrestaurantevirtual;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.upb.myrestaurantevirtual.databinding.ActivitySedeBinding;

public class SedeActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.InfoWindowAdapter {

    private GoogleMap mMap;
    private ActivitySedeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySedeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtener el SupportMapFragment y notificar cuando el mapa esté listo
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Añadir marcadores
        LatLng laureles = new LatLng(6.2450582, -75.5971038);
        LatLng itagui = new LatLng(6.1681832, -75.6190324);
        LatLng medellin = new LatLng(6.2132868, -75.5762572);
        LatLng fredonia = new LatLng(5.9270266, -75.6713538);
        LatLng centrodemedellin = new LatLng(6.2489064, -75.5723143);
        LatLng envigado = new LatLng(6.1672865, -75.5836963);

        Marker markerLaureles = mMap.addMarker(new MarkerOptions()
                .position(laureles)
                .title("Laureles")
                .snippet("Población de Laureles-Estadio: 118,081 habitantes, My Restaurant"));
        markerLaureles.setTag(R.drawable.laureles); // Asociar imagen a este marcador

        Marker markerItagui = mMap.addMarker(new MarkerOptions()
                .position(itagui)
                .title("Itagui")
                .snippet("Población de Itagüí: 276.744 habitantes, My Restaurant"));
        markerItagui.setTag(R.drawable.itagui); // Asociar imagen a este marcador

        Marker markerFredonia = mMap.addMarker(new MarkerOptions()
                .position(fredonia)
                .title("Fredonia")
                .snippet("Población de Fredonia: 25.764 habitantes, My Restaurant"));
        markerFredonia.setTag(R.drawable.fredonia); // Asociar imagen a este marcador

        Marker markerCentroDeMedellin = mMap.addMarker(new MarkerOptions()
                .position(centrodemedellin)
                .title("Centro")
                .snippet("Población del Centro de Medellín: 1,500,000 habitantes, My Restaurant"));
        markerCentroDeMedellin.setTag(R.drawable.centrodemedellin); // Asociar imagen a este marcador

        Marker markerEnvigado = mMap.addMarker(new MarkerOptions()
                .position(envigado)
                .title("Envigado")
                .snippet("Población de Envigado: 246,327 habitantes, My Restaurant"));
        markerEnvigado.setTag(R.drawable.envigado); // Asociar imagen a este marcador

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(medellin, 15f));
        //mMap.setMaxZoomPreference(5000f);
        mMap.setMinZoomPreference(5f);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        float zoomLevel = 12.0f;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(medellin, zoomLevel));

        // Mover la cámara a la posición inicial
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        // Asignar el InfoWindowAdapter al mapa
        mMap.setInfoWindowAdapter(this);
    }

    @Nullable
    @Override
    public View getInfoWindow(@NonNull Marker marker) {
        // Devolver null para usar el diseño predeterminado de la ventana
        return null;
    }

    @Nullable
    @Override
    public View getInfoContents(@NonNull Marker marker) {
        // Inflar el layout personalizado
        View view = getLayoutInflater().inflate(R.layout.custom_info_window, null);

        // Obtener referencias a las vistas
        ImageView imageView = view.findViewById(R.id.info_window_image);
        TextView titleView = view.findViewById(R.id.info_window_title);
        TextView snippetView = view.findViewById(R.id.info_window_snippet);

        // Configurar la imagen y el texto
        titleView.setText(marker.getTitle());
        snippetView.setText(marker.getSnippet());

        // Obtener el identificador de la imagen asociada al marcador
        Integer imageResId = (Integer) marker.getTag();
        if (imageResId != null) {
            imageView.setImageResource(imageResId); // Configurar la imagen
        } else {
            // Imagen por defecto si no hay ninguna asociada
            imageView.setImageResource(R.drawable.myrestaurant);
        }

        return view;
    }
}