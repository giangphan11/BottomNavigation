package phanbagiang.com.buttomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import phanbagiang.com.adapter.ViewpagerAdapter;
import phanbagiang.com.fragment.ExplorerFragment;
import phanbagiang.com.fragment.FavoriteFragment;
import phanbagiang.com.fragment.LocationFragment;
import phanbagiang.com.fragment.MusicFragment;

public class MainActivity2 extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;
    ViewpagerAdapter viewpagerAdapter;

    //fragment
    ExplorerFragment explorerFragment;
    FavoriteFragment favoriteFragment;
    LocationFragment locationFragment;
    MusicFragment musicFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addControls();
        addEvents();

    }

    private void addEvents() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.ex).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.subscribers).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.mail).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addControls() {
        viewPager =findViewById(R.id.viewPager);
        bottomNavigationView=findViewById(R.id.bottomNavigationView2);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        viewpagerAdapter=new ViewpagerAdapter(getSupportFragmentManager());

        explorerFragment=new ExplorerFragment();
        favoriteFragment=new FavoriteFragment();
        locationFragment=new LocationFragment();
        musicFragment=new MusicFragment();

        viewpagerAdapter.addFragment(explorerFragment);
        viewpagerAdapter.addFragment(favoriteFragment);
        viewpagerAdapter.addFragment(locationFragment);
        viewpagerAdapter.addFragment(musicFragment);
        viewPager.setAdapter(viewpagerAdapter);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                viewPager.setCurrentItem(0);
                break;
            case R.id.ex:
                viewPager.setCurrentItem(1);
                break;
            case R.id.subscribers:
                viewPager.setCurrentItem(2);
                break;
            case R.id.mail:
                viewPager.setCurrentItem(3);
                break;
        }
        return true;
    }
}