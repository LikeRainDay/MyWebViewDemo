package com.example.houshuai.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.houshuai.mywebviewdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HouShuai on 2016/6/15.
 */

public class MainFragment extends Fragment {

    private MainFragmentListener myfragmentObject=null;

    public interface MainFragmentListener {
        void onChangWebUrl(String Url);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.webview, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        if (!(activity instanceof MainFragmentListener )) {
            throw new ClassCastException("没有此类");
        }
        myfragmentObject = (MainFragmentListener) activity;
        super.onAttach(activity);
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        MenuItem item = menu.add(1, 1, 1, "分享");
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_WITH_TEXT | MenuItem.SHOW_AS_ACTION_ALWAYS);
        ImageView imageView = new ImageView(this.getActivity());
        imageView.setBackgroundResource(R.mipmap.ic_launcher);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(50,50));
        item.setActionView(imageView);

    }

    private void initView(View view) {
        ListView lv = (ListView) view.findViewById(R.id.lv_showTitle);
        List<String> list = new ArrayList<>();
        list.add("网易");
        list.add("腾讯");
        list.add("新浪");
        list.add("搜狐");
        ArrayAdapter adapter = new ArrayAdapter<>(getActivity(), R.layout.textview,R.id.text,list);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        myfragmentObject.onChangWebUrl("http://www.163.com");
                        break;
                    case 1:
                        myfragmentObject.onChangWebUrl("http://www.qq.com");
                        break;
                    case 2:
                        myfragmentObject.onChangWebUrl("http://www.sina.com");
                        break;
                    case 3:
                        myfragmentObject.onChangWebUrl("http://www.sohu.com");
                        break;
                }
            }
        });
    }

}
