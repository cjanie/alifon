package fr.cjanienumerique.mobile.android.alifon.ui.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import fr.cjanienumerique.mobile.android.alifon.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES_IDS = new int[]{R.string.words, R.string.roots};
    private final Context context;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {

        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return PlaceholderFragment.newInstance(TAB_TITLES_IDS[position]);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return this.context.getResources().getString(TAB_TITLES_IDS[position]);
    }

    @Override
    public int getCount() {
        return TAB_TITLES_IDS.length;
    }
}