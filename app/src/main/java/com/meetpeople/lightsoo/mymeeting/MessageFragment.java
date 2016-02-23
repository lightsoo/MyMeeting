package com.meetpeople.lightsoo.mymeeting;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v4.app.FragmentTabHost;


public class MessageFragment extends Fragment {

    FragmentTabHost tabHost;

    public MessageFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        tabHost = (FragmentTabHost)view.findViewById(R.id.tabhost);
        tabHost.setup(getActivity(), getChildFragmentManager(), R.id.realtabcontent);
        /**
         * 프래그먼트매니저는 Activity를 기준으로 부르는 것이다 getActivity로 가져와서 FragementManager만 부르면
         * 메인에 바로 어태치되는 프래그먼트의 매니저를 받아오는것이다. 이건 Fragment안에 Fragement를 배치하는 것이므로
         * MainActivity기준으로 ChildFragment를 가져와야한다.
         */
        tabHost.addTab(tabHost.newTabSpec("ch1").setIndicator("받은 메시지"), MessageReceiveFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("ch2").setIndicator("보낸 메시지"), MessageSendFragment.class, null);
        return view;

    }

}
