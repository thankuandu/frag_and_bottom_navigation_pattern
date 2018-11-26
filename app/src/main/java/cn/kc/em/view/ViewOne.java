package cn.kc.em.view;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import cn.kc.em.R;
import cn.kc.em.vm.ViewOneModel;

/**
 * 作者： 张卓嘉  .
 * 日期： 2018/11/26
 * 版本： V1.0
 * 说明：
 */
public class ViewOne extends LinearLayout {

    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;

    public ViewOne(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.content_frag_one, this);


        listView = (ListView) findViewById(R.id.list);
        swipeRefreshLayout = findViewById(R.id.refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData(context);
            }
        });

    }

    public void refreshData(Context context) {

        ViewOneModel model = ViewModelProviders.of((FragmentActivity) context).get(ViewOneModel.class);
        model.getFruitList().observe((LifecycleOwner) context, fruitlist -> {
            // update UI
            ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
                    android.R.layout.simple_list_item_1, android.R.id.text1, fruitlist);
            // Assign adapter to ListView
            listView.setAdapter(adapter);
            swipeRefreshLayout.setRefreshing(false);
        });

    }
}
