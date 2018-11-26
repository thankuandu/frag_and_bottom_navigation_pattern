package cn.kc.em;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.gson.Gson;

import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import cn.zj.weblibrary.RetrofitProvider;

/**
 * 作者： 张卓嘉  .
 * 日期： 2018/11/8
 * 版本： V1.0
 * 说明：
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected Gson gson;
    protected final String BASE_URL = "http://122.114.141.121:8088/Index.asmx/";
    protected SweetAlertDialog mDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gson = new Gson().newBuilder().serializeNulls().create();
        RetrofitProvider.setBaseUrl(BASE_URL);

        setView();
        ButterKnife.bind(this);
        initDialog();
        initView();
        initData();
    }

    private void initDialog() {
        mDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        mDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        mDialog.setTitleText(getResources().getString(R.string.plz_wait));
        mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                ((SweetAlertDialog) dialog).changeAlertType(SweetAlertDialog.PROGRESS_TYPE);
                ((SweetAlertDialog) dialog).setTitleText(getResources().getString(R.string.plz_wait));
            }
        });
    }

    protected abstract void setView();

    protected abstract void initView();

    protected abstract void initData();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
