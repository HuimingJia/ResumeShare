package edu.brandeis.cs.jiahuiming.resumeshare.views.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
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
import edu.brandeis.cs.jiahuiming.resumeshare.views.fragments.ProfileFragment;
import edu.brandeis.cs.jiahuiming.resumeshare.views.fragments.ResumeFragment;
import edu.brandeis.cs.jiahuiming.resumeshare.views.widgets.CircleImageView;
import edu.brandeis.cs.jiahuiming.resumeshare.views.widgets.MenuItem;
import edu.brandeis.cs.jiahuiming.resumeshare.adapters.MenuItemAdapter;
import edu.brandeis.cs.jiahuiming.resumeshare.views.fragments.ContactsFragment;
import edu.brandeis.cs.jiahuiming.resumeshare.views.fragments.HomeFragment;
import edu.brandeis.cs.jiahuiming.resumeshare.views.fragments.SettingsFragment;

public class HomeActivity extends AppCompatActivity  {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavigationView mNavigationView;
    private CircleImageView mCircleImageView;

    private ListView mDrawerList;
    private String[] mMenuItemTitle;
    private String mCurrentAccount;

    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    private String ResumeAccount;
    public String getResumeAccount(){return ResumeAccount;}
    public void setResumeAccount(String resumeAccount){this.ResumeAccount=resumeAccount;}

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mMenuItemTitle=getResources().getStringArray(R.array.menuitem_title);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        mNavigationView = (NavigationView) findViewById(R.id.navigationview);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mCircleImageView=(CircleImageView)mNavigationView.getHeaderView(0).findViewById(R.id.civ_profile);

        setSupportActionBar(mToolbar);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new ResumeFragment()).commit();
        mCircleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new ProfileFragment()).commit();
                mToolbar.setTitle("Profile");
                mDrawerLayout.closeDrawer(mNavigationView);

            }
        });

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {
               String title=item.getTitle().toString();
                item.setChecked(true);
                if(title.equals("Home")){
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new HomeFragment()).commit();
                    mToolbar.setTitle("ShareResume");
                    mDrawerLayout.closeDrawer(mNavigationView);

                }else if(title.equals("Profile")){
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,new ProfileFragment()).commit();
                    mToolbar.setTitle("Profile");
                    mDrawerLayout.closeDrawer(mNavigationView);

                }else if(title.equals("Contacts")){
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new ContactsFragment()).commit();
                        mToolbar.setTitle("Contacts");
                        mDrawerLayout.closeDrawer(mNavigationView);

                }else{
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new SettingsFragment()).commit();
                        mToolbar.setTitle("Settings");
                        mDrawerLayout.closeDrawer(mNavigationView);

                }
                return false;
            }
        });
    }

    public String getCurrentUser(){
        return mCurrentAccount;
    }
}
