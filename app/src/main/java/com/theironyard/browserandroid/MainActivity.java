package com.theironyard.browserandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText addressBar;
    Button backButton;
    Button forwardButton;
    Button goButton;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addressBar = (EditText) findViewById(R.id.editText); //this is going by the id in the editor so we have to leave the 2nd editTexxt
        backButton = (Button) findViewById(R.id.backButton);
        forwardButton = (Button) findViewById(R.id.forwardButton);
        goButton = (Button) findViewById(R.id.goButton);
        webView = (WebView) findViewById(R.id.webView);

        backButton.setOnClickListener(this); //they are all calling the onClick method when you call on them.
        forwardButton.setOnClickListener(this);
        goButton.setOnClickListener(this);

        webView.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onClick(View v) { //view v is actually the control/button that was clicked
        if (v == backButton) {
            webView.goBack();
        } else if ( v == forwardButton) {
            webView.goForward();
        } else if (v == goButton) {
            String address = addressBar.getText().toString();
            if (!address.startsWith("http")) {
                address = "http://" + address;
            }
            webView.loadUrl(address);
        }
    }
}
