package com.example.aplicacion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class Nopeople extends AppCompatActivity {

    private WebView miVisorWeb;
    private SwipeRefreshLayout swipelayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nopeople);

        swipelayout=(SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipelayout.setOnRefreshListener(mOnRefreshListener);

        miVisorWeb=(WebView) findViewById(R.id.vistaweb);

        WebSettings webSettings=miVisorWeb.getSettings();
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        miVisorWeb.loadUrl("https://thispersondoesnotexist.com/");

        // casting a la vista a la que aplicamos un menu contextual
        // y la registramos
        WebView mycontext = findViewById(R.id.vistaweb);
        registerForContextMenu(mycontext);
    }

    public void showAlertDialogButtonClicked() {

        // setup the alert builder
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);

//        //el dialogo estandar tiene título/icono pero podemos sustituirlo por un XML a medida
        builder.setTitle("Achtung!");
        builder.setMessage("Where do you go?");
        builder.setIcon(R.drawable.logousername);
        builder.setCancelable(false);

        // un XML a medida para el diálogo
        //builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view, null));

        // add the buttons
        builder.setPositiveButton("Go scrolling", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // do something like...
                Intent intent = new Intent(Nopeople.this, MainActivity.class);
                startActivity(intent);
                dialog.dismiss();

            }
        });

        builder.setNegativeButton("Do nothing", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...

                dialog.dismiss();
            }
        });

        builder.setNeutralButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // do something like...
                System.exit(0);

                dialog.dismiss();
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    protected SwipeRefreshLayout.OnRefreshListener
    mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast0=Toast.makeText(Nopeople.this,"Hi there! I don´t exist",Toast.LENGTH_LONG);
            toast0.show();
            miVisorWeb.reload();
            swipelayout.setRefreshing(false);
        }
    };

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)
        //item.getMenuInfo();
        if(item.getItemId()==R.id.item){
            Toast toast = Toast.makeText(this,"going CONTEXT ITEM",
                    Toast.LENGTH_LONG );
            toast.show();
            return true;
            }else if(item.getItemId()==R.id.action_settings){
                Toast toast2 = Toast.makeText(this,"going CONTEXT SETTINGS",
                        Toast.LENGTH_LONG );
                toast2.show();
                return true;
            }else{
                return super.onContextItemSelected(item);
            }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contextdos, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.camera) {
            //Toast toast = Toast.makeText(this,"going APPBAR CAMERA",Toast.LENGTH_LONG );
            //toast.show();
            showAlertDialogButtonClicked();
        }
        return super.onOptionsItemSelected(item);
    }
}

