package com.example.houshuai.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.houshuai.mywebviewdemo.R;

/**
 * Created by HouShuai on 2016/6/15.
 */

public class LeftFragment extends Fragment{

    private WebView webView=null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.webview, container, false);
        webView = (WebView) view.findViewById(R.id.wv_showWeb);
        return view;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public WebView getWebView() {
        return webView;
    }

}
