package uw.heist;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.webkit.WebView;
import android.app.ActionBar;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import static uw.heist.R.id.info;

/**
 * Created by brand_000 on 1/30/2016.
 */
public class Instructions extends AppCompatActivity {
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructions);

        // Get the widgets reference from XML layout
        LinearLayout ll = (LinearLayout) findViewById(info);
        final WebView wv = (WebView) findViewById(R.id.wv);

        // Set a click listener for Button widget
        wv.setWebViewClient(new WebViewClient());

        /*
            WebSettings
                Manages settings state for a WebView. When a
                WebView is first created, it obtains a set
                of default settings.
         */
        wv.getSettings();

        // Get the Android assets folder path
        String folderPath = "file:res/android_asset/";

        // Get the HTML file name
        String fileName = "instructions.html";

        // Get the exact file location
        String file = folderPath + fileName;

        // Render the HTML file on WebView
        wv.loadUrl(file);
    }
}
