package cn.kc.em.web;

import cn.kc.em.model.PlayResult;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * 作者： 张卓嘉  .
 * 日期： 2018/11/26
 * 版本： V1.0
 * 说明：
 */
public interface PlayApiService {

    @GET("today")
    Observable<PlayResult> getToday();
}
