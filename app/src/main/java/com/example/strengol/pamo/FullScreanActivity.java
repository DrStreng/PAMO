package com.example.strengol.pamo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

public class FullScreanActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screan);

        Intent intent = getIntent();
        String val1 = intent.getStringExtra("val1");
//        TextView textView=(TextView) findViewById(R.id.message);
//        textView.setText(val1+"\n");

        webView =(WebView)findViewById(R.id.myfullscrean);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadData(val1,"text/html","utf-8");
        webView.setWebChromeClient(new WebChromeClient(){

        });

    }
}
