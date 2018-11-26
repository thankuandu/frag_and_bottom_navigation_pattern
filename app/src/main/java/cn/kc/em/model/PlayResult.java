package cn.kc.em.model;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * 作者： 张卓嘉  .
 * 日期： 2018/11/26
 * 版本： V1.0
 * 说明：
 */
public class PlayResult {
    private List<String> category;
    private boolean error;
    private JsonObject results;

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public JsonObject getResults() {
        return results;
    }

    public void setResults(JsonObject results) {
        this.results = results;
    }
}
