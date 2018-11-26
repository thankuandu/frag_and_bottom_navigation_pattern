package cn.kc.em.frag;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import cn.kc.em.R;
import cn.kc.em.databinding.FragmentOneBinding;
import cn.kc.em.view.ViewOne;

/**
 * 作者： 张卓嘉  .
 * 日期： 2018/11/26
 * 版本： V1.0
 * 说明：
 */
public class FirstFragment extends Fragment {

    FragmentOneBinding binding;
    ViewOne contentView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_one, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binding.setTitleStr(getString(R.string.first_frag_name));
        contentView = new ViewOne(getActivity());
        binding.content.addView(contentView);



    }


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
}
