package com.example.houshuai.mywebviewdemo;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.houshuai.fragment.LeftFragment;
import com.example.houshuai.fragment.MainFragment;

public class MainActivity extends FragmentActivity implements MainFragment.MainFragmentListener{

    private ActionBar actionBar=null;
    private SlidingPaneLayout spl=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//获取actionBar实例
        actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        //获取界面实例
        spl = (SlidingPaneLayout) findViewById(R.id.Main_first);
        spl.setPanelSlideListener(new SlidingPaneLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {

            }

            @Override
            public void onPanelOpened(View panel) {
                getSupportFragmentManager().findFragmentById(R.id.leftfragment).setHasOptionsMenu(true);
            }

            @Override
            public void onPanelClosed(View panel) {
                getSupportFragmentManager().findFragmentById(R.id.leftfragment).setHasOptionsMenu(false);
            }
        });
            //界面启动时
        onChangWebUrl("http://www.jikedaohang.com/");

    }


    @Override
    public void onChangWebUrl(String Url) {
        Fragment fragmentById = getSupportFragmentManager().findFragmentById(R.id.rightfragment);
        LeftFragment fl = (LeftFragment) fragmentById;

        WebView webView =
                fl.getWebView();
        WebSettings settings =
                webView.getSettings();
        settings.setJavaScriptEnabled(true);
        WebViewClient webViewClient = new WebViewClient();
        webView.setWebViewClient(webViewClient);
        webView.loadUrl(Url);
    }
}
