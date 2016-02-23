package com.meetpeople.lightsoo.mymeeting.Manager;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.meetpeople.lightsoo.mymeeting.MyApplication;

import java.util.HashSet;

/**
 * Created by LG on 2016-02-20.
 * 1. 로그인한뒤 받은 Response에서 쿠키정보를 가져온다.
 * 2. 가져온 쿠키정보를 안드로이드의 SharedPreferences에 저장해둔다.
 * 3. 이후 수행되는 Request마다 SharedPreferences에서 쿠키를 가져와서 Header에 추가해서 보낸다.
 *
 * App이 다시 실행될 때 이미 저장된 Preference데이터 파일이 있다면
 * MainActivity의 onResume()과 같은 callback내부에서 환경 설정 값 설정을 불러와 사용
 *
 */
public class PropertyManager {

    SharedPreferences mPref;
    //Preference 파일에 저장된 항목을 수정/제거 할 수 있는 여러 메서드를 제공하는 인터페이스
    SharedPreferences.Editor mEditor;

    public static final String KEY_ID = "key_id";
    public static final String KEY_PASSWORD = "key_password";
    public static final String KEY_COOKIE = "kie_cookie";

    private PropertyManager(){
        //SharedPreferences 인터페이스를 포함하는 Context지정정        mPref = PreferenceManager.getDefaultSharedPreferences(MyApplication.getContext());
        //데이터 저장
        mEditor = mPref.edit();
    }
    //프로그램 종료시점까지 하나의 인스턴스만을 생성하고 관리하는 것이 싱글톤의 개념이다.
    // singleton holder pattern : thread safe, lazy class initialization, memory saving.
    public static class InstanceHolder{
        private static final PropertyManager INSTANCE = new PropertyManager();
    }
    //인스턴스불러와서 사용
    public static PropertyManager getInstance(){ return InstanceHolder.INSTANCE; }

    //setter
    public void setId(String id){
        mEditor.putString(KEY_ID, id);
        //파일에 변경된 내용을 저장한다.
        mEditor.commit();
    }

    public void setPassword(String password){
        mEditor.putString(KEY_PASSWORD, password);
        //파일에 변경된 내용을 저장한다.
        mEditor.commit();
    }

    public void setCookie(HashSet cookie){
        mEditor.putStringSet(KEY_COOKIE, cookie);
        //파일에 변경된 내용을 저장한다.
        mEditor.commit();
    }

    //getter
    public String getId(){
        return mPref.getString(KEY_ID, "");
    }

    public String getPassword(){
        return mPref.getString(KEY_PASSWORD, "");
    }

    public HashSet getCookie(){
        return (HashSet)mPref.getStringSet(KEY_COOKIE, new HashSet());
    }


}
