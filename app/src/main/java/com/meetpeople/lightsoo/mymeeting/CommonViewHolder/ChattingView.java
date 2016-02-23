package com.meetpeople.lightsoo.mymeeting.CommonViewHolder;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.meetpeople.lightsoo.mymeeting.Data.Chatting;
import com.meetpeople.lightsoo.mymeeting.R;

/**
 * Created by LG on 2016-02-15.
 */
public class ChattingView extends FrameLayout{

    ImageView iconView;
    TextView nameView, descriptionView;
    Chatting chatting;

    public ChattingView(Context context){
        super(context);
        init();
    }


    public interface OnImageClickListener {
        public void onImageClick(ChattingView view, Chatting chatting);
    }
    OnImageClickListener mImageClickListener;
    public void setOnImageClickListener(OnImageClickListener listener) {
        mImageClickListener = listener;
    }

    private void init(){
        inflate(getContext(), R.layout.view_chatting, this);
        iconView = (ImageView)findViewById(R.id.image_icon);
        nameView = (TextView)findViewById(R.id.text_name);
        descriptionView = (TextView)findViewById(R.id.text_description);

        iconView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImageClickListener != null) {
                    mImageClickListener.onImageClick(ChattingView.this, chatting);
                }
            }
        });
    }

    public void setChatting(Chatting c){
        chatting = c;
        if (c.getIcon() != null) {
            iconView.setImageDrawable(c.getIcon());
        } else {
            iconView.setImageResource(R.mipmap.ic_launcher);
        }
        nameView.setText(c.getNameAndAge());
        descriptionView.setText(c.getDescription());
    }

}
