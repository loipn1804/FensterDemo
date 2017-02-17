package liophan.fensterdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2016, Stacck Pte Ltd. All rights reserved.
 *
 * @author Lio <lphan@stacck.com>
 * @version 1.0
 * @since December 09, 2016
 */

public class MyListActivity extends Activity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        initView();
        initData();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    private void initData() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        List<String> listData = new ArrayList<String>();
        String s = "abcdef";
        for (int i = 0; i < 5; i++) {
            int n = 20;//random.nextInt(10) + 5;
            String str = i + "\n";
            for (int j = 0; j < n; j++) {
                str += s + " ";
            }
            listData.add(str);
        }

        MyAdapter adapter = new MyAdapter(listData);
        recyclerView.setAdapter(adapter);
    }
}
