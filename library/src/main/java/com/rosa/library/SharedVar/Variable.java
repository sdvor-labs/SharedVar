package com.rosa.library.SharedVar;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Helper for SharedPreferences.
 * Created by karbunkul on 09.12.2016.
 */
public class Variable {

    private String mKey;
    private SharedPreferences mShared;
    private String mPrefix;
    private String mDelimiter;

    /**
     * Variable constructor.
     *
     * @param key variable key.
     */
    public Variable(Context context, String key) {
        setKey(key);
        SharedPreferences sharedPref = context.getSharedPreferences("variable_storage", Context.MODE_PRIVATE);
        setShared(sharedPref);
    }

    /**
     * New instance Variable.
     *
     * @param key variable key.
     *
     * @return Variable object.
     */
    public static Variable getInstance(Context context,String key) {
        return new Variable(context, key);
    }

    /**
     * Get variable int value.
     *
     * @return variable value.
     */
    public int getInt() {
        return getShared().getInt(getKey(), 0);
    }

    /**
     * Set variable int value.
     *
     * @param value variable value.
     */
    public void setInt(int value) {
        getShared().edit().putInt(getKey(), value).apply();
    }

    /**
     * Get variable string value.
     *
     * @return variable value.
     */
    public String getString() {
        String key = getKey();
        return getShared().getString(getKey(), "");
    }

    /**
     * Set variable string value.
     *
     * @param value variable value.
     */
    public void setString(String value) {
        getShared().edit().putString(getKey(), value).apply();
    }

    public void setStringArray(String[] value, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (String aValue : value) {
            sb.append(aValue).append(delimiter);
        }
        setString(sb.toString());
    }

    public void setStringArray(String[] value) {
        setStringArray(value, getDelimiter());
    }

    public String[] getStringArray(String delimiter) {
        return getString().split(delimiter);
    }

    public String[] getStringArray(){
        return getStringArray(getDelimiter());
    }

    /**
     * Get variable boolean value.
     *
     * @return variable value.
     */
    public boolean getBoolean() {
        return getShared().getBoolean(getKey(), false);
    }

    /**
     * Set variable boolean value.
     *
     * @param value variable value.
     */
    public void setBoolean(Boolean value) {
        getShared().edit().putBoolean(getKey(), value).apply();
    }

    /**
     * Remove value.
     */
    public void remove() {
        getShared().edit().remove(getKey()).apply();
    }

    /**
     * SETTER & GETTER
     */

    /**
     * Get variable key.
     *
     * @return variable key.
     */
    private String getKey() {
        return (this.mPrefix != null) ? getPrefix() + "_" + this.mKey : this.mKey;
    }

    /**
     * Set variable key.
     *
     * @param key variable key.
     */
    private void setKey(String key) {
        this.mKey = key;
    }

    /**
     * Get shared preferences.
     *
     * @return  shared preferences.
     */
    private SharedPreferences getShared() {
        return mShared;
    }

    /**
     * Set shared preferences.
     *
     * @param shared shared preferences.
     */
    private void setShared(SharedPreferences shared) {
        this.mShared = shared;
    }

    /**
     * Get prefix.
     *
     * @return prefix.
     */
    public String getPrefix() {
        return mPrefix;
    }

    /**
     * Set prefix.
     * @param prefix prefix.
     * @return this.
     */
    public Variable setPrefix(String prefix) {
        this.mPrefix = prefix;
        return this;
    }

    /**
     * Get delimiter character.
     * @return delimiter.
     */
    public String getDelimiter() {
        return (mDelimiter != null) ? mDelimiter : ",";
    }

    /**
     * Set delimiter character.
     * @param delimiter delimiter character
     * @return this.
     */
    public Variable setDelimiter(String delimiter) {
        this.mDelimiter = delimiter;
        return this;
    }
}
