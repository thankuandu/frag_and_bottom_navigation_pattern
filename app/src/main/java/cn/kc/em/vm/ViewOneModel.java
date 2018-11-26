package cn.kc.em.vm;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import cn.kc.em.model.PlayResult;
import cn.kc.em.web.PlayApiService;
import cn.zj.weblibrary.RetrofitProvider;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.observers.BlockingBaseObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者： 张卓嘉  .
 * 日期： 2018/11/26
 * 版本： V1.0
 * 说明：
 */
public class ViewOneModel extends ViewModel {
    private String TAG = ViewOneModel.class.getSimpleName();

    private MutableLiveData<List<String>> fruitList;

    public MutableLiveData<List<String>> getFruitList() {
        if (fruitList == null) {
            fruitList = new MutableLiveData<>();
            loadFruits();
        }
        return fruitList;
    }

    private void loadFruits() {
        // do async operation to fetch users

//        RetrofitProvider.setBaseUrl("https://gank.io/api/");
//        PlayApiService playApiService = RetrofitProvider.getInstance().create(PlayApiService.class);
//        playApiService.getToday()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new BlockingBaseObserver<PlayResult>() {
//                    @Override
//                    public void onNext(PlayResult playResult) {
//                        Log.e(TAG, playResult.toString());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//                });



        Handler myHandler = new Handler();
        myHandler.postDelayed(() -> {


            List<String> fruitsStringList = new ArrayList<>();
            fruitsStringList.add("Mango");
            fruitsStringList.add("Apple");
            fruitsStringList.add("Orange");
            fruitsStringList.add("Banana");
            fruitsStringList.add("Grapes");
            long seed = System.nanoTime();
            Collections.shuffle(fruitsStringList, new Random(seed));

            fruitList.setValue(fruitsStringList);
        }, 5000);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d(TAG, "on cleared called");
    }
}
