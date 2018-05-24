package com.example.luulac.cinema_booking_mockup.activities;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.luulac.cinema_booking_mockup.R;
import com.example.luulac.cinema_booking_mockup.fragments.movie_theater.MovieTheaterFragment;
import com.example.luulac.cinema_booking_mockup.fragments.movies.MoviesFragment;
import com.example.luulac.cinema_booking_mockup.fragments.news.NewsFragment;
import com.example.luulac.cinema_booking_mockup.fragments.person.UserFragment;
import com.example.luulac.cinema_booking_mockup.fragments.shop.ShopFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbarMainActivity);
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabsMainActivity);
        viewPager = (ViewPager) findViewById(R.id.viewPagerMainActivity);

        setViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setTabIcons();
    }

    private int[] tabIcons = {
      R.drawable.movie_filter,
            R.drawable.opacityp,
            R.drawable.star,
            R.drawable.dashboard,
            R.drawable.person
    };

    private void setTabIcons() {
        for (int i =0; i < tabIcons.length - 1; i++){
            tabLayout.getTabAt(i).setIcon(tabIcons[i]);
        }
    }

    private void setViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter((getSupportFragmentManager()));
        viewPagerAdapter.addFragment(new MoviesFragment());
        viewPagerAdapter.addFragment(new MovieTheaterFragment());
        viewPagerAdapter.addFragment(new NewsFragment());
        viewPagerAdapter.addFragment(new ShopFragment());
        viewPagerAdapter.addFragment(new UserFragment());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOffscreenPageLimit(tabIcons.length);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {


        private final List<Fragment> fragments = new ArrayList<>();
        private final List<String> titles = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return super.getPageTitle(position);
        }

        public void addFragment(Fragment fragment){
            fragments.add(fragment);
        }
    }
}
