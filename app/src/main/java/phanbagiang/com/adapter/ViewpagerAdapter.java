package phanbagiang.com.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewpagerAdapter extends FragmentPagerAdapter {
    List<Fragment>fragments;
    public ViewpagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        fragments=new ArrayList<>();
    }
     public void addFragment(Fragment fragment){
         fragments.add(fragment);
     }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
