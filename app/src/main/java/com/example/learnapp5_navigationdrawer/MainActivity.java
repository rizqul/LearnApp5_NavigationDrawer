package com.example.learnapp5_navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerMain);
    }

    public void ClickMenu(View view) {
        openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }
    public void ClickHome(View view) {
        recreate();
    }
    public void ClickDashboard(View view) {
        redirectActivity(this,Dashboard.class);
    }
    public void ClickAbout(View view) {
        redirectActivity(this,About.class);
    }
    public void ClickQuit(View view) {
        quit(this);
    }

    public static void quit(Activity activity) {
        AlertDialog.Builder quitAlert = new AlertDialog.Builder(activity);
        quitAlert.setTitle("Quit");
        quitAlert.setMessage("Are you sure ?");

        quitAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                activity.finishAffinity();
                System.exit(0);
            }
        });
        quitAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        quitAlert.show();
    }

    public static void redirectActivity(Activity activity, Class cls) {
        Intent move = new Intent(activity, cls);
        move.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(move);
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);
    }


}