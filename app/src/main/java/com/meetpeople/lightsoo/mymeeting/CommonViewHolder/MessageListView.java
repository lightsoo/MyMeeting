package com.meetpeople.lightsoo.mymeeting.CommonViewHolder;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.meetpeople.lightsoo.mymeeting.Data.Chatting;
import com.meetpeople.lightsoo.mymeeting.Data.MessageList;
import com.meetpeople.lightsoo.mymeeting.R;

/**
 * Created by LG on 2016-02-18.
 */
public class MessageListView extends FrameLayout {


    ImageView iconView;
    TextView nameView, descriptionView, dateView;
    MessageList messageList;


    public MessageListView(Context context){
        super(context);
        init();
    }

    //XML매칭
    private void init(){
        inflate(getContext(), R.layout.view_messagelist, this);
        iconView = (ImageView)findViewById(R.id.image_icon);
        nameView = (TextView)findViewById(R.id.text_name);
        dateView = (TextView)findViewById(R.id.text_date);
        descriptionView = (TextView)findViewById(R.id.text_description);

    }
    //메시지방 설정
    public void setMessageList(MessageList m){
        messageList = m;
        if (m.getIcon() != null) {
            iconView.setImageDrawable(m.getIcon());
        } else {//아이콘이 없는경우
            iconView.setImageResource(R.mipmap.ic_launcher);
        }
        nameView.setText(m.getName());
        dateView.setText(m.getDate());
        descriptionView.setText(m.getDescription());
    }

}
