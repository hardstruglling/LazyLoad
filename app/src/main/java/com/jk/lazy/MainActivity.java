package com.jk.lazy;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jk.lazy.fragment.FindFragment;
import com.jk.lazy.fragment.HomeFragment;
import com.jk.lazy.fragment.RecommendFragment;
import com.jk.lazy.fragment.SelfFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
        initView();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_main,fragmentList.get(0));
        ft.commit();
    }

    private void initFragment() {
        fragmentList.add(new HomeFragment());
        fragmentList.add(new FindFragment());
        fragmentList.add(new RecommendFragment());
        fragmentList.add(new SelfFragment());
    }

    private void initView() {
        tabLayout = ((TabLayout) findViewById(R.id.tabLayout));
        TabLayout.Tab home = tabLayout.newTab().setText("首页");
        TabLayout.Tab find = tabLayout.newTab().setText("发现");
        TabLayout.Tab recommend = tabLayout.newTab().setText("推荐");
        TabLayout.Tab self = tabLayout.newTab().setText("个人");
        tabLayout.addTab(home);
        tabLayout.addTab(find);
        tabLayout.addTab(recommend);
        tabLayout.addTab(self);
        tabLayout.setTabTextColors(Color.BLACK,Color.BLUE);
        tabLayout.setSelectedTabIndicatorHeight(0);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_main,fragmentList.get(tab.getPosition()));
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /**
     * when clicking the corresponding tab display the corresponding fragment
     */
  /*  private void showFragmentByIndex(int position){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        for (int i=0;i<fragmentList.size();i++){
            Fragment fragment = fragmentList.get(i);
            if (!fragment.isAdded()){
                ft.add(R.id.fragment_main,fragment);
            }
            if (i == position){
                ft.show(fragment);
            }else {
                ft.hide(fragment);
            }
        }
        ft.commit();
    }*/
}
