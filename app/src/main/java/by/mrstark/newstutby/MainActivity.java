package by.mrstark.newstutby;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import by.mrstark.newstutby.fragment.ListNewsFragment;

/**
 * Created by mrstark on 23.1.16.
 */
public class MainActivity extends AppCompatActivity {

    private static final int LAYOUT = R.layout.activity_main;
    
    private Toolbar toolbar;
    private DrawerLayout layout;
    private ListNewsFragment listNewsFragment;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        
        initToolbar();
        initNavigationView();
        loadFragment();
    }

    private void loadFragment() {
        listNewsFragment = new ListNewsFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, listNewsFragment);
        fragmentTransaction.commit();
    }

    private void initNavigationView() {
        layout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, layout, toolbar, R.string.view_navigation_open, R.string.view_navigation_close);
        layout.setDrawerListener(toggle);
        toggle.syncState();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
    }
}
