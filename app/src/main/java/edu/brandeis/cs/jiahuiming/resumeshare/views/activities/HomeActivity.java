package edu.brandeis.cs.jiahuiming.resumeshare.views.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import edu.brandeis.cs.jiahuiming.resumeshare.R;
import edu.brandeis.cs.jiahuiming.resumeshare.views.widgets.NavigationItem;
import edu.brandeis.cs.jiahuiming.resumeshare.adapters.MenuItemAadapter;
import edu.brandeis.cs.jiahuiming.resumeshare.views.fragments.ContactsFragment;
import edu.brandeis.cs.jiahuiming.resumeshare.views.fragments.HomeFragment;
import edu.brandeis.cs.jiahuiming.resumeshare.views.fragments.SettingsFragment;

public class HomeActivity extends AppCompatActivity  {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    private ListView mDrawerList;
    private String[] mMenuItemTitle;
    private String mCurrentAccount;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    private String ResumeAccount;


    public String getResumeAccount(){
        return ResumeAccount;
    }

    public void setResumeAccount(String resumeAccount){
        this.ResumeAccount=resumeAccount;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ArrayList<NavigationItem> parameters=new ArrayList<NavigationItem>();
        parameters.add(new NavigationItem(getDrawable(R.drawable.action_search),"Home"));
        parameters.add(new NavigationItem(getDrawable(R.drawable.action_search),"Profile"));
        parameters.add(new NavigationItem(getDrawable(R.drawable.action_search),"Contacts"));
        parameters.add(new NavigationItem(getDrawable(R.drawable.action_search),"Settings"));

        mMenuItemTitle=getResources().getStringArray(R.array.menuitem_title);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        mDrawerList=(ListView)findViewById(R.id.left_drawer) ;
        mDrawerList.setAdapter(new MenuItemAadapter(this,parameters));

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new HomeFragment()).commit();
        mDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });


        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        //  mHomeFragment=new HomeFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new HomeFragment()).commit();
                        mToolbar.setTitle("ShareResume");
                        mDrawerLayout.closeDrawer(mDrawerList);
                        break;

                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new SettingsFragment()).commit();
                        mToolbar.setTitle("Profile");
                        mDrawerLayout.closeDrawer(mDrawerList);
                        break;

                    case 2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new ContactsFragment()).commit();
                        mToolbar.setTitle("Contacts");
                        mDrawerLayout.closeDrawer(mDrawerList);
                        break;

                    case 3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new SettingsFragment()).commit();
                        mToolbar.setTitle("Settings");
                        mDrawerLayout.closeDrawer(mDrawerList);
                        break;

                }
            }
        });
    }

    public String getCurrentUser(){
        return mCurrentAccount;
    }
}
