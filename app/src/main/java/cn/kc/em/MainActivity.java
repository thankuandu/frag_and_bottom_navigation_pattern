package cn.kc.em;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import cn.kc.em.databinding.ActivityMainBinding;
import cn.kc.em.frag.FourthFragment;
import cn.kc.em.frag.SecondFragment;
import cn.kc.em.frag.ThirdFragment;
import cn.kc.em.frag.common.FragmentFactory;
import cn.kc.em.frag.FirstFragment;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_first:
                FragmentFactory.show(MainActivity.this, FirstFragment.class.getName());
                return true;
            case R.id.navigation_second:
                FragmentFactory.show(MainActivity.this, SecondFragment.class.getName());
                return true;
            case R.id.navigation_third:
                FragmentFactory.show(MainActivity.this, ThirdFragment.class.getName());
                return true;
            case R.id.navigation_fourth:
                FragmentFactory.show(MainActivity.this, FourthFragment.class.getName());
                return true;
        }
        return false;

    };


    FirstFragment inFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binging = DataBindingUtil.setContentView(this, R.layout.activity_main);

        inFragment = new FirstFragment();

        FragmentFactory.show(this, FirstFragment.class.getName());

        binging.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


}
