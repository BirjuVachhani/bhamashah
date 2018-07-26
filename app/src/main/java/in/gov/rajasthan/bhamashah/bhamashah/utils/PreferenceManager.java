package in.gov.rajasthan.bhamashah.bhamashah.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;
import java.util.Set;

/**
 * Created by Birju Vachhani on 26-07-2018.
 */
public class PreferenceManager {
    public static final boolean WRITE_ASYNC = false; // means use apply() method
    public static final boolean WRITE_SYNC = true; // means use commit() method
    private static final String PREF_NAME = "APP_PREFERENCES";
    private static PreferenceManager mPreferenceManager;
    private static boolean writeFlag = WRITE_SYNC;
    private SharedPreferences.Editor mEditor;
    private SharedPreferences mPref;

    private PreferenceManager(Context context) {
        this.mPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static PreferenceManager getInstance(Context context, boolean flag) {
        if (mPreferenceManager == null) {
            mPreferenceManager = new PreferenceManager(context);
            writeFlag = flag;
        }
        return mPreferenceManager;
    }

    public static PreferenceManager getInstance(Context context) {
        if (mPreferenceManager == null) {
            mPreferenceManager = new PreferenceManager(context);
        }
        return mPreferenceManager;
    }

    public static PreferenceManager getInstance() {
        return mPreferenceManager == null ? null : mPreferenceManager;
    }

    private SharedPreferences.Editor getEditor() {
        if (mEditor == null) {
            mEditor = mPref.edit();
        }
        return mEditor;
    }

    public boolean contains(String key) {
        return mPref.contains(key);
    }

    public int get(String key, int defaultValue) {
        return mPref.getInt(key, defaultValue);
    }

    public long get(String key, long defaultValue) {
        return mPref.getLong(key, defaultValue);
    }

    public float get(String key, float defaultValue) {
        return mPref.getFloat(key, defaultValue);
    }

    public String get(String key, String defaultValue) {
        return mPref.getString(key, defaultValue);
    }

    public boolean get(String key, boolean defaultValue) {
        return mPref.getBoolean(key, defaultValue);
    }

    public Map<String, ?> getAll() {
        return mPref.getAll();
    }

    public void put(String key, String value) {
        getEditor().putString(key, value);
        write();
    }

    public void put(String key, int value) {
        getEditor().putInt(key, value);
        write();
    }

    public void put(String key, long value) {
        getEditor().putLong(key, value);
        write();
    }

    public void put(String key, float value) {
        getEditor().putFloat(key, value);
        write();
    }

    public void put(String key, boolean value) {
        getEditor().putBoolean(key, value);
        write();
    }

    public void put(String key, Set<String> values) {
        getEditor().putStringSet(key, values);
        write();
    }

    public void setFlag(boolean flag) {
        writeFlag = flag;
    }

    private void write() {
        if (writeFlag) {
            getEditor().commit();
        } else {
            getEditor().apply();
        }
    }
}
