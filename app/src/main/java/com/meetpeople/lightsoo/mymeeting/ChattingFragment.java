package com.meetpeople.lightsoo.mymeeting;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.meetpeople.lightsoo.mymeeting.CommonAdapter.ChattingAdapter;
import com.meetpeople.lightsoo.mymeeting.CommonViewHolder.ChattingView;
import com.meetpeople.lightsoo.mymeeting.Data.Chatting;

import java.util.Random;

public class ChattingFragment extends Fragment {

    ListView listView;
    ChattingAdapter chattingAdapter;
    static final int[] ICON_IDS = {R.drawable.sample_thumb_0,
            R.drawable.sample_thumb_1,
            R.drawable.sample_thumb_2,
            R.drawable.sample_thumb_3,
            R.drawable.sample_thumb_4,
            R.drawable.sample_thumb_5,
            R.drawable.sample_thumb_6,
            R.drawable.sample_thumb_7
    };

    public ChattingFragment() {
        // Required empty public constructor
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_chatting, container, false);
            View view = inflater.inflate(R.layout.fragment_chatting, container, false);
            listView = (ListView)view.findViewById(R.id.lv_chatting);
            chattingAdapter = new ChattingAdapter();
            chattingAdapter.setOnAdapterItemClickListener(new ChattingAdapter.OnAdapterItemClickListener() {
                @Override
                public void onAdapterItemImageClick(ChattingAdapter adapter, ChattingView view, Chatting chatting, int position) {
                    Toast.makeText(getActivity(), "Image Click : " + chatting.getName(), Toast.LENGTH_SHORT).show();
                }
            });
            listView.setAdapter(chattingAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Object data = listView.getItemAtPosition(position);
                    if (data instanceof String) {
                        Toast.makeText(getActivity(), "Header : " + (String) data, Toast.LENGTH_SHORT).show();
                    } else if (data instanceof Chatting) {
                        Chatting p = (Chatting) data;
                        Toast.makeText(getActivity(), "name : " + p.getName(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        initData();
        return view;
    }


    private void initData() {
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int age = 20 + r.nextInt(20);
            Drawable d = getResources().getDrawable(ICON_IDS[age % ICON_IDS.length]);
            if (age % 3 == 0) {
                d = null;
            }
            Chatting p = new Chatting(d, "name" + i, age, "desc : " + i);
            chattingAdapter.add(p);
        }
    }
}
