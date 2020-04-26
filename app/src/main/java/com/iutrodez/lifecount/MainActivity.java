package com.iutrodez.lifecount;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(navView, navController);
    }

    int sport = 39;
    int mcdo = 12;

    public void addSport(View v) {
        TextView txtSport = (TextView) findViewById(R.id.txt_sport);
        sport++;
        txtSport.setText("Réalisé "+sport+" fois");

        // Réaction sur image
        ImageView imageView = (ImageView)findViewById(R.id.img_sport);
        imageView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        ImageView view = (ImageView) v;
                        //overlay is black with transparency of 0x77 (119)
                        view.getDrawable().setColorFilter(0x22000000, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL: {
                        ImageView view = (ImageView) v;
                        //clear the overlay
                        view.getDrawable().clearColorFilter();
                        view.invalidate();
                        break;
                    }
                }

                return false;
            }
        });

        Snackbar.make(v, "Faire du sport (+1)", Snackbar.LENGTH_LONG)
                .setAction("Annuler", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView txtSport = (TextView) findViewById(R.id.txt_sport);
                        sport--;
                        txtSport.setText("Réalisé "+sport+" fois");
                    }
                }).show();
    }

    public void addFastFood(View v) {
        TextView txtSport = (TextView) findViewById(R.id.txt_mcdo);
        mcdo++;
        txtSport.setText("Réalisé "+mcdo+" fois");

        // Réaction sur image
        ImageView imageView = (ImageView)findViewById(R.id.img_mcdo);
        imageView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        ImageView view = (ImageView) v;
                        //overlay is black with transparency of 0x77 (119)
                        view.getDrawable().setColorFilter(0x22000000, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL: {
                        ImageView view = (ImageView) v;
                        //clear the overlay
                        view.getDrawable().clearColorFilter();
                        view.invalidate();
                        break;
                    }
                }

                return false;
            }
        });

        Snackbar.make(v, "Manger au fast-food (+1)", Snackbar.LENGTH_LONG)
                .setAction("Annuler", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView txtSport = (TextView) findViewById(R.id.txt_mcdo);
                        mcdo--;
                        txtSport.setText("Réalisé "+mcdo+" fois");
                    }
                }).show();
    }
}
