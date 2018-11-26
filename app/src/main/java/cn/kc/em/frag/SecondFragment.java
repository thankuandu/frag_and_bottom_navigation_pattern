package cn.kc.em.frag;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.kc.em.R;
import cn.kc.em.databinding.FragmentTwoBinding;

/**
 * 作者： 张卓嘉  .
 * 日期： 2018/11/26
 * 版本： V1.0
 * 说明：
 */
public class SecondFragment extends Fragment {

    FragmentTwoBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_two, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        binding.setTitleStr(getString(R.string.second_frag_name));
    }
}
