package cn.kc.em.frag.common;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.LinkedList;
import java.util.List;

import cn.kc.em.MainActivity;
import cn.kc.em.R;
import cn.kc.em.frag.FirstFragment;
import cn.kc.em.frag.FourthFragment;
import cn.kc.em.frag.SecondFragment;
import cn.kc.em.frag.ThirdFragment;

/**
 * 作者： 张卓嘉  .
 * 日期： 2018/11/26
 * 版本： V1.0
 * 说明：
 */
public class FragmentFactory {

    private static LinkedList<String> NAMES = new LinkedList<String>() {
        {
            add(0, FirstFragment.class.getName());
            add(1, SecondFragment.class.getName());
            add(2, ThirdFragment.class.getName());
            add(3, FourthFragment.class.getName());
        }
    };

    private static int showIndex = -1;


    public static void show(MainActivity context, String clzName) {
        FragmentManager supportFragmentManager = context.getSupportFragmentManager();


        int currentIndex = NAMES.indexOf(clzName);

        if (currentIndex == showIndex) {
            return;
        }

        int enter = -1;
        int exit = -1;

        if (showIndex < currentIndex) {
            //如果上一个页面的下标小于要显示的页面下标，动画从左向右
            enter = R.anim.enter_from_right;
            exit = R.anim.exit_to_left;
        } else if (showIndex > currentIndex) {
            //如果上一个页面的下标大于要显示的页面下标，动画从右向左
            enter = R.anim.enter_from_left;
            exit = R.anim.exit_to_right;
        }


        //隐藏非目标fragment
        for (String name :
                NAMES) {
            Fragment f = supportFragmentManager.findFragmentByTag(name);
            if (!name.equalsIgnoreCase(clzName)) {
                if (f != null)
                    supportFragmentManager.beginTransaction().setCustomAnimations(enter, exit).hide(f).commit();
            }
        }

        //获取目标fragment
        Fragment fragmentByTag = supportFragmentManager.findFragmentByTag(clzName);

        if (fragmentByTag == null) {
            try {
                fragmentByTag = (Fragment) Class.forName(clzName).newInstance();
                supportFragmentManager.beginTransaction().setCustomAnimations(enter, exit).add(R.id.frame, fragmentByTag, clzName).commit();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            supportFragmentManager.beginTransaction().setCustomAnimations(enter, exit).show(fragmentByTag).commit();
        }

        showIndex = NAMES.indexOf(clzName);
    }
}
