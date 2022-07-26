package com.qdes.sharedpref;

import static com.qdes.sharedpref.Constants.SALES;
import static com.qdes.sharedpref.Constants.SETTINGS_PREFERENCE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPreferenceManager().setSharedPreferencesName(SETTINGS_PREFERENCE);
        getPreferenceManager().setSharedPreferencesMode(Context.MODE_PRIVATE);
        addPreferencesFromResource(R.xml.prefscreen);

    }

    private void saveoffline(SharedPreferences sharedPreferences, String key) {
        boolean isEnabled = sharedPreferences.getBoolean(key, true);

        if (key.equals(Constants.SALES)) {
            SharedPref.setPrefs(getActivity(), Constants.SALES, isEnabled);
        }
        if (key.equals(Constants.SALESRETURN)) {
            SharedPref.setPrefs(getActivity(), Constants.SALESRETURN, isEnabled);
        }
        if (key.equals(Constants.INVOICE)) {
            SharedPref.setPrefs(getActivity(), Constants.INVOICE, isEnabled);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        saveoffline(sharedPreferences, s);
    }
}