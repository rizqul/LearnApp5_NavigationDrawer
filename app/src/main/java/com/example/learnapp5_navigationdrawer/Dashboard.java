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

public class Dashboard extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        drawerLayout = findViewById(R.id.drawerMain);
    }

    public void ClickMenu(View view) {
        MainActivity.openDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        MainActivity.closeDrawer(drawerLayout);
    }
    public void ClickHome(View view) {
        MainActivity.redirectActivity(this, MainActivity.class);
    }
    public void ClickDashboard(View view) {
        recreate();
    }
    public void ClickAbout(View view) {
        MainActivity.redirectActivity(this,About.class);
    }
    public void ClickQuit(View view) {
        MainActivity.quit(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }
}