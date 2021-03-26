package com.example.my32_navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle
                = new ActionBarDrawerToggle(this, drawer,
                toolbar, R.string.navi_drawer_open, R.string.navi_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Headdrawer에 로그인 정보 표시하기
        int userLevel = 1; // 0:일반유저 1:관리자
        String loginID = "BTS";
        View headerView = navigationView.getHeaderView(0);
        ImageView imageView = headerView.findViewById(R.id.loginImage);
        TextView navLoginID = headerView.findViewById(R.id.loginID);
        navLoginID.setText("반갑습니다 " + loginID);
        //imageView.setImageResource(R.drawable.singer3);
        Glide.with(this).load(R.drawable.singer3).circleCrop().into(imageView);

        //관리자일 때 관리자 메뉴 보여주기
        if (userLevel == 1) {
            navigationView.getMenu().findItem(R.id.communi).setVisible(true);
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            Toast.makeText(this, "첫번째 메뉴 선택", Toast.LENGTH_SHORT).show();
            onFragmentSelected(0, null);
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(this, "두번째 메뉴 선택", Toast.LENGTH_SHORT).show();
            onFragmentSelected(1, null);
        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(this, "세번째 메뉴 선택", Toast.LENGTH_SHORT).show();
            onFragmentSelected(2, null);
        } else if (id == R.id.nav_manage) {
            Toast.makeText(this, "네번째 메뉴 선택", Toast.LENGTH_SHORT).show();
            onFragmentSelected(3, null);
        } else if (id == R.id.nav_share) {
            Toast.makeText(this, "다섯번째 메뉴 선택", Toast.LENGTH_SHORT).show();
            onFragmentSelected(4, null);
        } else if (id == R.id.nav_send) {
            Toast.makeText(this, "여섯번째 메뉴 선택", Toast.LENGTH_SHORT).show();
            onFragmentSelected(5, null);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    // 메뉴 선택 시 Fragment 바꾸기
    public void onFragmentSelected(int position, Bundle bundle) {
        Fragment curFragment = null;

        if (position == 0) {
            curFragment = fragment1;
            toolbar.setTitle("첫번째 화면");
        } else if (position == 1) {
            curFragment = fragment2;
            toolbar.setTitle("두번째 화면");
        } else if (position == 2) {
            curFragment = fragment3;
            toolbar.setTitle("세번째 화면");
        } else if (position == 3) {
            curFragment = fragment1;
            toolbar.setTitle("네번째 화면");
        } else if (position == 4) {
            curFragment = fragment2;
            toolbar.setTitle("다섯번째 화면");
        } else if (position == 5) {
            curFragment = fragment3;
            toolbar.setTitle("여섯번째 화면");
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.container, curFragment).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}