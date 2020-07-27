package kamau_technerd.com.covid19trrackingapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    private int numTabs;

    public PageAdapter(@NonNull FragmentManager fm, int numTabs) {
        super(fm);
        this.numTabs = numTabs;
    }

    /*public PageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }*/


    @NonNull
    @Override
    public Fragment getItem(int position) {

         switch (position){
             case 0:
                 return  new GlobalStats();
             case 1:
                 return  new KenyanStats();
                 default:
                     return null;

         }

    }


    @Override
    public int getCount() {
        return numTabs;
    }


    @Override
    public int getItemPosition(@NonNull Object object) {


        return POSITION_NONE;/*super.getItemPosition(object);*/
    }
}
