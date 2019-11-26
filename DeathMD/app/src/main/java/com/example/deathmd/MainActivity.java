package com.example.deathmd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    public WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = (WebView) findViewById(R.id.webview);           // This is Redundant in Android api 28???


        myWebView.setWebViewClient(new WebViewClient());            // This opens the browser
        myWebView.loadUrl("https://deathmd.herokuapp.com/");                // This loads the url site content inside the browser.


        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);                     // Enabling this true can be a security vulnerability, but for now it doesn't matter ...

    }


    @Override
    public void onBackPressed() {
        if(myWebView.canGoBack()){
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
