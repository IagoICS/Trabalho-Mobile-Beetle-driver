package com.example.thelast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class Enredo extends AppCompatActivity {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private FusedLocationProviderClient fusedLocationProviderClient;
    private ImageButton btnmaps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enredo);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);

        ImageButton ib_voltar = findViewById(R.id.ib_voltar);
        ib_voltar.setOnClickListener(v -> {
            Intent voltarintent = new Intent(Enredo.this,MainActivity.class);
            startActivity(voltarintent);
        });
        ImageButton btngithub  = findViewById(R.id.btngithub);
        btngithub.setOnClickListener(v -> {

            Uri uri = Uri.parse("https://github.com/IagoICS/Trabalho-Mobile-Beetle-driver");
            Intent github = new Intent(Intent.ACTION_VIEW, uri);


            startActivity(github);

        });
        ImageButton btnmaps = findViewById(R.id.btnmaps);
        btnmaps.setOnClickListener(v -> {
            
            if (ContextCompat.checkSelfPermission(Enredo.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                fusedLocationProviderClient.getLastLocation().addOnSuccessListener(Enredo.this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            double latitude = location.getLatitude();
                            double longitude = location.getLongitude();


                            Uri gmmIntentUri = Uri.parse("geo:" + latitude + "," + longitude);
                            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                            mapIntent.setPackage("com.google.android.apps.maps");
                            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                                startActivity(mapIntent);
                            } else {

                                Uri googlePlayUri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
                                Intent installIntent = new Intent(Intent.ACTION_VIEW, googlePlayUri);
                                startActivity(installIntent);
                            }
                        } else {
                            Toast.makeText(Enredo.this, "Localização não encontrada", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } else {

                ActivityCompat.requestPermissions(Enredo.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION_REQUEST_CODE);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permissão de localização concedida, execute novamente o código de abrir o Google Maps
                btnmaps.performClick();
            } else {
                Toast.makeText(this, "Permissão de localização negada. Não é possível abrir o Google Maps.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}




