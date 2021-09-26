package com.phipemc.menuexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView imgBody;
    ImageView imghelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgBody = (ImageView) findViewById(R.id.imageView);
        registerForContextMenu(imgBody);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.android_float_menu, menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.android_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_settings:
                break;
            case R.id.menu_update:
                imgBody.setImageResource(R.drawable.ic_baseline_verified_24);
                Toast.makeText(this,"Actualizado con exito", Toast.LENGTH_SHORT).show();
            case R.id.menu_options:

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.float_item_1:
                imgBody.setImageResource(R.drawable.ic_baseline_cancel_24);
                break;
            case R.id.float_item_2:

                break;
        }
        return super.onContextItemSelected(item);
    }

    public void showPopup(View v){
        imghelp = (ImageView) findViewById(R.id.imageView2);
        PopupMenu PopM = new PopupMenu(this, imghelp);
        PopM.getMenuInflater().inflate(R.menu.android_help_menu, PopM.getMenu());
        PopM.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.help_item_1:
                        Toast.makeText(MainActivity.this, "Proximamente...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.help_item_2:
                        Toast.makeText(MainActivity.this, "Funcion aun no disponible", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });
        PopM.show();
    }
}