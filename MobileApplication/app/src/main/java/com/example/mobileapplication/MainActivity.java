package com.example.mobileapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

public class MainActivity extends AppCompatActivity {

    private WebView webview; //웹뷰
    private WebSettings webSettings; //웹뷰 세팅

    String newToken;
    private static final String ENTRY_URL = "http://70.12.60.99/ConnectedCarControlSystem/main.mc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(this, new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult result){
                newToken = result.getToken();
                Log.e("등록 ID :", newToken);
            }
        });

        webview = (WebView)findViewById(R.id.webview); //레이어와 연결
        webview.setWebViewClient(new WebViewClient()); //클릭시 새창 안뜨게
        webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true); //자바 스크립트 사용 허용
         

        webview.getSettings().setBuiltInZoomControls(true);
        webview.getSettings().setSupportZoom(true);

        //크롬창 동작과 동일하게 만드릭
        webview.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result){
                return super.onJsAlert(view, url, message, result);
            }
        });
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                String USERDEVICE = newToken;
                String script = "javascript:function afterLoad(){"
                        +"document.getElementById('token').value='"
                        + ""+USERDEVICE+"';"
                        +"};"
                        +"afterLoad();";
                view.loadUrl(script);
            }
        });
        webview.loadUrl("http://70.12.60.99/ConnectedCarControlSystem");

    }

    @Override
    public void onBackPressed(){
        if(webview.canGoBack()){
            webview.goBack();
        }else{
            super.onBackPressed();
        }
    }

}
