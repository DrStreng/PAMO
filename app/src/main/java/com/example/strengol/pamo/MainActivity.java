package com.example.strengol.pamo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,OverviewFragment.OverviewFragmentActivityListener,DetailFragment.DetailFragmentActivityListener {

    private boolean isLand = false;
    private final FragmentManager fm = getFragmentManager();
    private Fragment currentFragment = null;
    WebView webView;
    private final int REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.isLand = getResources().getBoolean(R.bool.isLand);
        if(!this.isLand){
            setHomeFragment();
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(int id,String title,String msg,String link) {
        DetailFragment fragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detailFragment);

        if (fragment != null && fragment.isInLayout()) {
            fragment.setText(id,title,msg,link);
        } else {
            setDetailsFragment();
            this.fm.executePendingTransactions();
            ((DetailFragment) this.currentFragment).setText(id,title,msg,link);
        }

        setMovie(link);
    }

    @Override
    public void onClickFullScreen(String link) {

        Intent intent = new Intent(this, FullScreanActivity.class);
        intent.putExtra("val1", link);
        startActivityForResult(intent, REQUEST_CODE);

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

        if (id == R.id.nav_camera) {

            if(!this.isLand){
                setHomeFragment();
            } else {
               Toast ee =  Toast.makeText(getApplicationContext(),"Juz jest na stronie",Toast.LENGTH_SHORT);
                ee.show();
            }

        } else if (id == R.id.nav_gallery) {
            if(!this.isLand){
                Intent intent = new Intent(this, Google.class);
                intent.putExtra("val1", "SUPER");
                startActivityForResult(intent, REQUEST_CODE);
            } else {
                Toast ee =  Toast.makeText(getApplicationContext(),"Juz jest na stronie",Toast.LENGTH_SHORT);
                ee.show();
            }

        } else if (id == R.id.nav_slideshow) {
            if(!this.isLand){
                setOverviewFragment();
            } else {
                Toast ee =  Toast.makeText(getApplicationContext(),"Juz jest na stronie",Toast.LENGTH_SHORT);
                ee.show();
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void setOverviewFragment() {
        FragmentTransaction ft = this.fm.beginTransaction();
        this.currentFragment = new OverviewFragment();
        ft.replace(R.id.fragment_container, this.currentFragment);
        ft.commit();
    }
    private void setHomeFragment() {
        FragmentTransaction ft = this.fm.beginTransaction();
        this.currentFragment = new HomePageFragment();
        ft.replace(R.id.fragment_container, this.currentFragment);
        ft.commit();
    }
    private void setDetailsFragment() {
        FragmentTransaction ft = this.fm.beginTransaction();
        this.currentFragment = new DetailFragment();
        ft.replace(R.id.fragment_container, this.currentFragment);

        ft.addToBackStack(null);
        ft.commit();
    }
    private void setMovie(String link){
        webView=(WebView)findViewById(R.id.video);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadData(link,"text/html","utf-8");
        webView.setWebChromeClient(new WebChromeClient(){

        });
    }


}
