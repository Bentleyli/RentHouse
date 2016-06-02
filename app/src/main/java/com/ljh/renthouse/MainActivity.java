package com.ljh.renthouse;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;
import com.jude.rollviewpager.hintview.ColorPointHintView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private ImageView iv_nav_header;
    private TextView tv_nav_header;
    private NavigationView navigationView;
    private ListView listView;
    private View headerView1, headerView2;
    private List<HashMap<String, Object>> list;
    private Intent intent1;
    RollPagerView myrollPagerView;

    public static String url = "http://192.168.42.55:8080/myRentHouse/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        init();
        initViewPager();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "listview", Toast.LENGTH_SHORT).show();
                intent1 = new Intent(MainActivity.this, HouseDetailsActivity.class);
                startActivity(intent1);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void init() {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        View view = navigationView.getHeaderView(0);
        headerView1 = this.getLayoutInflater().inflate(R.layout.list_head1, null);
        headerView2 = getLayoutInflater().inflate(R.layout.head_list_2, null);
        list = new ArrayList<>();
        headerView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "listview", Toast.LENGTH_SHORT).show();
                intent1 = new Intent(MainActivity.this, AllHouseActivity.class);
                startActivity(intent1);
            }
        });

        listView = (ListView) findViewById(R.id.lv_content_activity);
        iv_nav_header = (ImageView) view.findViewById(R.id.iv_nav_header);
        tv_nav_header = (TextView) view.findViewById(R.id.tv_nav_header);
        iv_nav_header.setOnClickListener(this);
        tv_nav_header.setOnClickListener(this);


        for (int i = 0; i < 5; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("activityName", "遇见" + i);
            list.add(map);
        }

        listView.setAdapter(new SimpleAdapter(this, list,
                R.layout.list_content_activity_item,
                new String[]{"activityName"}, new int[]{R.id.tv_content_activity_item}));
//        String[] list=new String[]{"aa","bb","cc","dd","ee","ff","gg","hh","ii"};
//        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
//        listView.setAdapter(adapter);
        listView.addHeaderView(headerView1);
        listView.addHeaderView(headerView2);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "活动" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_bill) {

        } else if (id == R.id.nav_order) {

        } else if (id == R.id.nav_collect) {

        } else if (id == R.id.nav_service) {

        } else if (id == R.id.nav_wallet) {

        } else if (id == R.id.nav_city) {
            Toast.makeText(MainActivity.this, "设置城市", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_set) {
            Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();
            jumpToPersonalDataFragment("setFragment");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void jumpToPersonalDataFragment(String name) {
        Intent intent = new Intent(MainActivity.this, FragmentManagerActivity.class);
        intent.putExtra("fragmentName", name);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_nav_header:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_nav_header:
                jumpToPersonalDataFragment("personalDataFragment");
                break;
        }
    }

    public void onClick(MenuItem item) {
        Toast.makeText(MainActivity.this, "搜索", Toast.LENGTH_SHORT).show();
    }

    private void initViewPager() {
        myrollPagerView = (RollPagerView) findViewById(R.id.rollPager);
        myrollPagerView.setPlayDelay(3000);
        myrollPagerView.setAnimationDurtion(2000);
        myrollPagerView.setAdapter(new TestLoopAdapter(myrollPagerView));
//        mRollViewPager.setAdapter(new TestNomalAdapter());
        // rollPagerView.setHintView(new IconHintView(this,R.drawable.point_focus,R.drawable.point_normal));
        myrollPagerView.setHintView(new ColorPointHintView(MainActivity.this, Color.YELLOW, Color.WHITE));
    }

    private class TestLoopAdapter extends LoopPagerAdapter implements ViewPager.OnPageChangeListener {
        private int[] imgs = {
                R.drawable.jianzuzhuanzu,
                R.drawable.liangzhounian,
                R.drawable.zufangjie
        };

        public TestLoopAdapter(RollPagerView viewPager) {
            super(viewPager);
        }

        @Override
        public View getView(ViewGroup container, int position) {
            ImageView view = new ImageView(container.getContext());
            view.setImageResource(imgs[position]);
            view.setScaleType(ImageView.ScaleType.CENTER_CROP);
            view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return view;
        }

        @Override
        public int getRealCount() {
            return imgs.length;
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (imgs[position]) {
                case R.drawable.tupian1:
                    Toast.makeText(MainActivity.this, "第一张图片", Toast.LENGTH_SHORT).show();
                    break;
                case R.drawable.tupian2:
                    Toast.makeText(MainActivity.this, "第二张图片", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

}
