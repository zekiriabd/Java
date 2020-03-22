package com.example.webview;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webview = findViewById(R.id.MyWebview);

        webview.setWebViewClient(new WebViewClient());
        webview.loadUrl("http://google.com");

       //2- String html = "<html><body><h1>My Heading</h1><p>My Paragraph.</p></body></html>";
       // webview.loadDataWithBaseURL("", html, "text/html", "UTF-8", "");

        //3- webview.loadUrl("file:///android_asset/html/myFile.html");
    }

    @Override
    public void onBackPressed() {
        if(webview.canGoBack()){
            webview.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}
