package hu.budapest.python.mohi1stapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static hu.budapest.python.mohi1stapp.R.layout.activity_main;

/* Original WebView idea came from this source: https://developer.chrome.com/multidevice/webview/gettingstarted */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);


        // Main trick not to let application crashes, thanks to this expert technical discussions: https://stackoverflow.com/questions/44337730/activity-with-webview-crashing-android-studio

        final WebView mWebView = findViewById(R.id.mohi_main_webview);
        mWebView.setWebViewClient(new WebViewClient());

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAppCacheEnabled(true);

        mWebView.loadUrl("file:///android_asset/www/index.html");
    }
}
