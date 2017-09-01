package com.hujiang.designsupportlibrarydemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	private DrawerLayout mDrawerLayout;
	private ViewPager mViewPager;
	private TabLayout mTabLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		final ActionBar ab = getSupportActionBar();
		ab.setHomeAsUpIndicator(R.drawable.ic_menu);
		ab.setDisplayHomeAsUpEnabled(true);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main_drawer);
		NavigationView navigationView = (NavigationView) findViewById(R.id.nv_main_navigation);
		if (navigationView != null) {
			setupDrawerContent(navigationView);
		}

		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Snackbar comes out", Snackbar.LENGTH_LONG)
						.setAction("Action", new View.OnClickListener() {
							@Override
							public void onClick(View v) {
								Toast.makeText(MainActivity.this, "Toast comes out", Toast.LENGTH_SHORT).show();
							}
						}).show();
			}
		});
		mTabLayout = (TabLayout) findViewById(R.id.tabs);
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		// setupViewPager(4);
		//首页
		Fragment fragment = new NewsFragment();
		//Bundle args = new Bundle();
		//args.putString("key", "home");
		//fragment.setArguments(args); // FragmentActivity将点击的菜单列表标题传递给Fragment
		FragmentManager fragmentManager = getSupportFragmentManager();
		//fragmentManager.beginTransaction().replace(R.id.main_content, fragment).commit();
		fragmentManager.beginTransaction().replace(R.id.appbar, fragment).commit();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_overaction, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			mDrawerLayout.openDrawer(GravityCompat.START);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void setupViewPager(int count) {
		// mTabLayout = (TabLayout) findViewById(R.id.tabs);
		List<String> titles = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			titles.add("第" + i + "页");
		}
		for (int j = 0; j < count; j++) {
			mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(j)));
		}
		List<Fragment> fragments = new ArrayList<>();
		for (int k = 0; k < count; k++) {
			fragments.add(new ListFragment());
		}
		/*
		 * fragments.add(new ListFragment()); fragments.add(new ListFragment());
		 * fragments.add(new ListFragment()); fragments.add(new ListFragment());
		 */
		FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragments, titles);
		mViewPager.setAdapter(adapter);
		mTabLayout.setupWithViewPager(mViewPager);
		mTabLayout.setTabsFromPagerAdapter(adapter);
	}

	private void setupDrawerContent(final NavigationView navigationView) {
		navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(MenuItem menuItem) {
				menuItem.setChecked(true);
				mDrawerLayout.closeDrawers();
				selectItem(menuItem.getItemId());
				return true;
			}
		});
	}

	/**
	 * 切换主视图区域的Fragment
	 * 
	 * @param position
	 */
	private void selectItem(int position) {
		// TODO Auto-generated method stub
		// Fragment fragment = new ListFragment();
		Fragment fragment = null;
		Bundle args = new Bundle();
		switch (position) {
		case R.id.nav_home:
			fragment = new ListFragment();
			args.putString("key", "home");
			// mViewPager.setCurrentItem(0);
			break;
		case R.id.nav_friends:
			fragment = new SportsFragment();
			args.putString("key", "friends");
			// mViewPager.setCurrentItem(1);
			break;
		case R.id.nav_discussion:
			fragment = new MusicFragment();
			args.putString("key", "discussion");
			// mViewPager.setCurrentItem(2);
			break;
		case R.id.nav_messages:
			fragment = new NewsFragment();
			args.putString("key", "message");
			// mViewPager.setCurrentItem(3);
			break;
		default:
			fragment = new NewsFragment();
			args.putString("key", "index");
			break;
		}
		fragment.setArguments(args); // FragmentActivity将点击的菜单列表标题传递给Fragment
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.appbar, fragment).commit();

		// 更新选择后的item和title，然后关闭菜单
		// mMenuListView.setItemChecked(position, true);
		// setTitle(mMenuTitles[position]);
		// mDrawerLayout.closeDrawer(mMenuListView);
	}

}
