package cn.kc.em.frag.common;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

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

    private static String[] NAMES = {FirstFragment.class.getName(), SecondFragment.class.getName(),
            ThirdFragment.class.getName(), FourthFragment.class.getName()};

    public static void show(MainActivity context, String clzName) {
        FragmentManager supportFragmentManager = context.getSupportFragmentManager();

        //隐藏非目标fragment
        for (String name :
                NAMES) {
            Fragment f = supportFragmentManager.findFragmentByTag(name);
            if (!name.equalsIgnoreCase(clzName)) {
                if (f != null)
                    supportFragmentManager.beginTransaction().hide(f).commit();
            }
        }

        //获取目标fragment
        Fragment fragmentByTag = supportFragmentManager.findFragmentByTag(clzName);

        if (fragmentByTag == null) {
            try {
                fragmentByTag = (Fragment) Class.forName(clzName).newInstance();
                supportFragmentManager.beginTransaction().add(R.id.frame, fragmentByTag, clzName).commit();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            supportFragmentManager.beginTransaction().show(fragmentByTag).commit();
        }

    }
}
