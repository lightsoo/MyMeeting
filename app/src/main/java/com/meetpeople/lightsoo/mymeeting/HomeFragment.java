package com.meetpeople.lightsoo.mymeeting;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.meetpeople.lightsoo.mymeeting.Activity.SendMessageActivity;
import com.meetpeople.lightsoo.mymeeting.Activity.WriteActivity;
import com.meetpeople.lightsoo.mymeeting.CommonAdapter.HomeAdapter;


/**
 * (setToolbarTitle(String title)) in your activity which receives the String and sets it via toolbar.setTitle(title).
 * In your Fragment you call ((MyActivity)getActivity).setToolbarTitle("Lorem ipsum")
 */

public class HomeFragment extends Fragment {
    //    //글내용 보이기
    private HomeAdapter homeAdapter;
    private ViewPager pager;

    private Button btn_write;

    public HomeFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        /////////////////////////////////////////
        pager = (ViewPager)view.findViewById(R.id.pager);
        btn_write = (Button)view.findViewById(R.id.btn_write);

        //pager에 패딩을 줄지말지
        pager.setClipToPadding(false);
        //페이지간 마진을 얼마나 줄지
        //pager.setPageMargin(getResources().getDimensionPixelSize());
        //페이지에 어댑터설정!!!이걸 안하면 안보여...
        homeAdapter = new HomeAdapter(getActivity().getSupportFragmentManager());
        pager.setAdapter(homeAdapter);
        //현재위치 조정
        pager.setCurrentItem(3);

        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //글쓰기 액티비티 이동
                Intent intent = new Intent(getActivity(), WriteActivity.class);
                //문자 메시지 보내는 액티비티 이동
//                Intent intent = new Intent(getActivity(), SendMessageActivity.class);
                startActivity(intent);

            }
        });
        return view;
    }
}