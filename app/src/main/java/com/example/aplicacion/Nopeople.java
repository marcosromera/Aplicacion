package com.example.aplicacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

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
        miVisorWeb.loadUrl("https://thispersonadoesnotexit.com");
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
}