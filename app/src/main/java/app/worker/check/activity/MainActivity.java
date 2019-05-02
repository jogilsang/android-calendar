package app.worker.check.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import app.worker.check.kakasubstitutedriving.R;
import app.worker.check.adapter.ViewPagerAdapter;
import app.worker.check.fragment.tabFragment1;
import app.worker.check.fragment.tabFragment2;
import app.worker.check.fragment.tabFragment3;
import app.worker.check.helper.BottomNavigationViewHelper;
import app.worker.check.util.AdsFull;

public class MainActivity extends BaseActivity implements
        NavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView navigation;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private MenuItem prevMenuItem;

    private View header;

    private Context mContext;
    private DrawerLayout drawer;

    public tabFragment1 tab1 = new tabFragment1();
    public tabFragment2 tab2 = new tabFragment2();
    public tabFragment3 tab3 = new tabFragment3();

    public RelativeLayout menu_header_layout_3;
    public RelativeLayout menu_header_layout_4;
    public RelativeLayout menu_header_layout_5;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_1:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_2:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_3:
                    viewPager.setCurrentItem(2);
                    return true;

            }
            return false;
        }
    };
    private NavigationView navigationView;
    private Menu menu;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (id) {

            // 오른쪽메뉴
            case R.id.action_drawer :

                basicToast("주변사람을 앱으로 초대합니다");

                Intent msg = new Intent(Intent.ACTION_SEND);

                msg.addCategory(Intent.CATEGORY_DEFAULT);

                //msg.putExtra(Intent.EXTRA_SUBJECT,"주제");

                msg.putExtra(Intent.EXTRA_TEXT, getString(R.string.text_share_head) +
                        getString(R.string.text_share_tail));

                msg.putExtra(Intent.EXTRA_TITLE, "공유하기");

                msg.setType("text/plain");

                startActivity(Intent.createChooser(msg, "공유"));

                break;

                // 왼쪽 메뉴
            case android.R.id.home :

                drawer.openDrawer(Gravity.LEFT);

                break;


        }

//        if (id == R.id.action_drawer) {
//
//            switch (pagePosition){
//
//                case 0 :
//
//                    drawer.openDrawer(Gravity.RIGHT);
//
//                    break;
//
//                case 1:
//                case 2:
//                case 3:
//
//            }
//
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        this.menu = menu;

        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_2);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        BottomNavigationViewHelper.disableShiftMode(navigation);

        //
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // 왼쪽 상단 아이콘 이미지와 사용여부결정
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);


        // 상단 타이틀바 사용여부 결정
//        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mContext = MainActivity.this;

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

//         ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                 this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//         drawer.addDrawerListener(toggle);
//
//         toggle.syncState();

        // navigation view
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        header = navigationView.getHeaderView(0);

        menu_header_layout_3 = header.findViewById(R.id.menu_header_layout_3);
        menu_header_layout_4 = header.findViewById(R.id.menu_header_layout_4);
        menu_header_layout_5 = header.findViewById(R.id.menu_header_layout_5);

        setListener();

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
//
//        adapter.AddFragment(new tabFragment1(), getText(R.string.tab_1).toString());
//        adapter.AddFragment(new tabFragment2(), getText(R.string.tab_2).toString());
//        adapter.AddFragment(new tabFragment3(), getText(R.string.tab_3).toString());
//        adapter.AddFragment(new tabFragment4(), getText(R.string.tab_4).toString());

        adapter.AddFragment(tab1, getText(R.string.tab_1).toString());
        adapter.AddFragment(tab2, getText(R.string.tab_2).toString());
        adapter.AddFragment(tab3, getText(R.string.tab_3).toString());

        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    navigation.getMenu().getItem(0).setChecked(false);
                }

                navigation.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navigation.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        AdsFull.getInstance(this);

    }

    private void setListener() {

        // 공지사항
        menu_header_layout_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basicToast("menu_header_layout_3");
            }
        });

        // 기존 적립금 설정
        menu_header_layout_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MoneyActivity.class);
                startActivity(intent);
            }
        });

        // 버전관리
        menu_header_layout_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                TODO : 플레이스토어로 가기

            }
        });

    }
}

