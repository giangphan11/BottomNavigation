package phanbagiang.com.buttomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import phanbagiang.com.fragment.ExplorerFragment;
import phanbagiang.com.fragment.FavoriteFragment;
import phanbagiang.com.fragment.LocationFragment;
import phanbagiang.com.fragment.MusicFragment;

public class MainActivity extends AppCompatActivity  {
    MusicFragment musicFragment;
    FavoriteFragment favoriteFragment;
    LocationFragment locationFragment;
    ExplorerFragment explorerFragment;

    FrameLayout frameLayout;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        addFragment(favoriteFragment);
                        return true;
                    case R.id.ex:
                        addFragment(musicFragment);
                        return true;
                    case R.id.subscribers:
                        addFragment(locationFragment);
                        return true;
                    case R.id.mail:
                        addFragment(explorerFragment);
                        return true;

                }
                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.home);

    }
    private void addFragment(Fragment fragment){
        fragmentTransaction=fragmentManager.beginTransaction().replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
    private void addControls() {
        frameLayout=findViewById(R.id.frameLayout);
        bottomNavigationView=findViewById(R.id.bottomNavigation);
        musicFragment=new MusicFragment();
        favoriteFragment=new FavoriteFragment();
        locationFragment=new LocationFragment();
        explorerFragment=new ExplorerFragment();
        fragmentManager= getSupportFragmentManager();
    }
}