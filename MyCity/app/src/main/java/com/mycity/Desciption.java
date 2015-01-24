package com.mycity;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.mycity.Tabs.SlidingTabLayout;

/**
 * Created by Akhil Bhai on 1/8/2015.
 */
public class Desciption extends ActionBarActivity {

    Toolbar toolBar;
    private ViewPager mPager;
    private SlidingTabLayout mTabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.descrip);
        toolBar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolBar);

        mPager= (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mTabs= (SlidingTabLayout) findViewById(R.id.tabs);
//        mTabs.setFitsSystemWindows(true);
        mTabs.setDistributeEvenly(true);
//        mTabs.setC
        mTabs.setViewPager(mPager);
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {


        String[] tabs;
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            tabs = getResources().getStringArray(R.array.tab_name);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment  myFragment=null;
            switch (position){
                case 0:
                    myFragment = AboutVenue.getInstance();
                    break;
                case 1:
                    myFragment = Gallery.getInstance();
                    break;
                case 3:
                    myFragment = ContactUs.getInstance();
                    break;
                default:
                    myFragment= MyFragment.getInstance(position);
            }
            return myFragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }

        @Override
        public int getCount() {
            return tabs.length;
        }
    }

    public static class MyFragment extends Fragment{

        private TextView textView;

        public static MyFragment getInstance(int position){
            MyFragment myFragment=new MyFragment();
            Bundle args=new Bundle();
            args.putInt("position",position);
            myFragment.setArguments(args);
            return myFragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View layout=inflater.inflate(R.layout.fragment_main, container, false);
            textView= (TextView) layout.findViewById(R.id.section_label);
            Bundle bundle=getArguments();
            if(bundle!=null)
            {
                 if(bundle.getInt("position")==2){
                    textView.setText("Comming Soon");
                }else if(bundle.getInt("position")==0){
                    textView.setText("About Venue");
                }else{
                    textView.setText("Contact");
                }
            }
            return layout;
        }
    }
}

