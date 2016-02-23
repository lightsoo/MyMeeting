package com.meetpeople.lightsoo.mymeeting.CommonAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.meetpeople.lightsoo.mymeeting.HomeFragmentContent;

/**
 * Created by LG on 2016-02-15.
 */
public class HomeAdapter extends FragmentStatePagerAdapter {

    //생성자를 통해 상속받아서 사용
    public HomeAdapter(FragmentManager fm){super(fm);}

    @Override
    public Fragment getItem(int position) {
        //해당하는 page의 Fragment를 생성한다.생성자로 내용번호를 넘겨주면서 생성!
        return HomeFragmentContent.newIntance("content : " + position);
    }

    //각 뷰마다 가로를 얼만큼 차지할것이냐, 0.5로하면 화면에 2개씩 보인다.
    @Override
    public float getPageWidth(int position) {
        return 1.00f;
    }

    //총 5개의 page를 보여준다.
    @Override
    public int getCount() {
        return 5;
    }
}
