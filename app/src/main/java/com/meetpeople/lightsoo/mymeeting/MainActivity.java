package com.meetpeople.lightsoo.mymeeting;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.meetpeople.lightsoo.mymeeting.Activity.MovieActivity;
import com.meetpeople.lightsoo.mymeeting.Dialog.FilterDialogFragment;
import com.meetpeople.lightsoo.mymeeting.Handler.BackPressCloseHandler;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;

    private BackPressCloseHandler backPressCloseHandler;

//    GestureDetector gestureDetector;

    //SharedPreferecne자원
    String id;


//    @Override
//    protected void onResume() {
//        super.onResume();
//        this.id = PropertyManager.getInstance().getId();
//        getUserInfo();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backPressCloseHandler = new BackPressCloseHandler(this);

        //Set a Toolbar to replace the ActionBar
        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //toolbar이름 설정
//        getSupportActionBar().setTitle("MeetPeople");

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        /*
        string.xml에 넣고, toogle을 써서 三이거를 보여줄수있게되네
         */
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawer, toolbar,
                R.string.drawer_open, R.string.drawer_close);
        mDrawer.setDrawerListener(toggle);
        toggle.syncState();

        //Setup drawer view
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        setupDrawerContent(nvDrawer);

        RelativeLayout nvDrawerHeaderView = (RelativeLayout) nvDrawer.getHeaderView(0);
        nvDrawerHeaderView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "내정보 액티비티 만들어서 이동!", Toast.LENGTH_SHORT).show();
            }
        });

        Fragment fragment = null;

        Class fragmentClass;
        fragmentClass = HomeFragment.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_main, fragment).commit();
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        return gestureDetector.onTouchEvent(event);
//    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        //내비게이션뷰 선택되었을때
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return false;
                    }
                }
        );
    }

    //onNavigationItemSeletec()이것도 한번 써서 테스트해보자
    //시간있을때...
    public void selectDrawerItem(MenuItem menuItem) {
        Fragment fragment = null;

        Class fragmentClass  =null;
        switch (menuItem.getItemId()) {
            case R.id.nav_home_fragment:
                fragmentClass = HomeFragment.class;
                break;
            case R.id.nav_message_fragment:
                fragmentClass = MessageFragment.class;
                break;
            case R.id.nav_chatting_fragment:
                fragmentClass = ChattingFragment.class;
                break;
            case R.id.nav_test:
                Intent intent = new Intent(MainActivity.this, MovieActivity.class);
                startActivity(intent);
                break;
            default:
                fragmentClass = HomeFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }


        if(fragment !=null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_main, fragment).commit();
        }

        // Highlight the selected item, update the title, and close the drawer
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawer.closeDrawers();
    }

    public void onCustomDialog(View view) {
        FilterDialogFragment dialog = new FilterDialogFragment();
        dialog.show(getSupportFragmentManager(), "custom");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //액션바를 통해 드로어를 열고 닫는다.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        //드로어 버튼이 열려있을때는 닫는다
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            backPressCloseHandler.onBackPressed();
//            super.onBackPressed();
        }
    }

    public void getUserInfo(){

    }

}