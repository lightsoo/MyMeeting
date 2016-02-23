package com.meetpeople.lightsoo.mymeeting;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.meetpeople.lightsoo.mymeeting.CommonAdapter.MessageListAdapter;
import com.meetpeople.lightsoo.mymeeting.Data.Chatting;
import com.meetpeople.lightsoo.mymeeting.Data.MessageList;

import java.util.Random;


public class MessageReceiveFragment extends Fragment {


    ListView listView;
    MessageListAdapter messageListAdapter;
    static final int[] ICON_IDS = {R.drawable.sample_thumb_0,
            R.drawable.sample_thumb_1,
            R.drawable.sample_thumb_2,
            R.drawable.sample_thumb_3
    };
    public MessageReceiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message_receive, container, false);
        listView = (ListView)view.findViewById(R.id.lv_messagelist);
        messageListAdapter = new MessageListAdapter();
        listView.setAdapter(messageListAdapter);
        initData();

        return view;
    }


    private void initData() {
        Random r = new Random();
        Drawable d = getResources().getDrawable(ICON_IDS[0]);
        //데이터객체 생성후 어댑터에 추가해
        MessageList m = new MessageList(d, "Yessol", "저희랑 놀아요", "날짜를 넣으면 되");
        messageListAdapter.add(m);



    }

}
