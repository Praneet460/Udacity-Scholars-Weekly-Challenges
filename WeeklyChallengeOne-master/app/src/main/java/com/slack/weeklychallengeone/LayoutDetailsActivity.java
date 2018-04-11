package com.slack.weeklychallengeone;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LayoutDetailsActivity extends AppCompatActivity {
    // Intent Constant Declaration
    public static final String LAYOUT_NAME = "layout_name";
    public static final String LAYOUT_LINK = "layout_link";

    public TextView titleView;
    public WebView detailsView;
    private RelativeLayout processLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_details);
        Intent intent = getIntent();
        if(intent == null || !intent.hasExtra(LAYOUT_NAME) || !intent.hasExtra(LAYOUT_LINK)){
            onBackPressed();
        }
        titleView = (TextView) findViewById(R.id.title_view);
        titleView.setText(intent.getStringExtra(LAYOUT_NAME));
        detailsView = (WebView) findViewById(R.id.web_view);
        processLayout = (RelativeLayout) findViewById(R.id.display_process);

        WebSettings webSettings = detailsView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
        detailsView.loadUrl(intent.getStringExtra(LAYOUT_LINK));
        detailsView.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                processLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                processLayout.setVisibility(View.GONE);
            }
        });
    }
    @Override
    public void onBackPressed() {
        if (detailsView.canGoBack()) {
            detailsView.goBack();
        } else {
            super.onBackPressed();
        }
    }


}
