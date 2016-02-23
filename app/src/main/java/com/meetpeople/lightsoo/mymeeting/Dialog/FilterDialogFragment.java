package com.meetpeople.lightsoo.mymeeting.Dialog;

import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.meetpeople.lightsoo.mymeeting.R;

import java.util.ArrayList;
import java.util.List;

public class FilterDialogFragment extends DialogFragment {

    LinearLayout layoutPlace;   //지역 레이아웃
    RadioButton radioCity[]=new RadioButton[5]; //도시 라디오버튼
    CheckBox chkPlace[]=new CheckBox[5];    //지역 체크박스
    String selCity; //선태한 도시
    List<String> selPlaces = new ArrayList<String>();   //선택한 지역들
    Button btnOk,btnCancel, btnResult;

    public static final int CITY_ID[] = {R.id.radio_city1, R.id.radio_city2, R.id.radio_city3, R.id.radio_city4, R.id.radio_city5};
    public static final int PLACE_ID[] = {R.id.chk_place1, R.id.chk_place2, R.id.chk_place3, R.id.chk_place4, R.id.chk_place5 };



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //다이얼로그의 툴바를 없애고, custom_dialog상속
        setStyle(STYLE_NO_TITLE, R.style.custom_dialog);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog, container, false);
        //fragment_dialog의 레이아웃
        layoutPlace = (LinearLayout)view.findViewById(R.id.layout_place);
        MyOnClickListener mcl = new MyOnClickListener();

        for(int i=0; i<CITY_ID.length; i++) {
            radioCity[i]=(RadioButton)view.findViewById(CITY_ID[i]);
            radioCity[i].setOnClickListener(mcl);
        }

        for(int i=0; i<PLACE_ID.length; i++) {
            chkPlace[i]=(CheckBox)view.findViewById(PLACE_ID[i]);
            chkPlace[i].setOnClickListener(mcl);
        }

        btnOk = (Button)view.findViewById(R.id.btn_ok);
        btnCancel = (Button)view.findViewById(R.id.btn_cancel);

        btnOk.setOnClickListener(mcl);
        btnCancel.setOnClickListener(mcl);

        return view;


    }

    class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.radio_city1:
                    selCity ="서울";
                    chkPlace[0].setText("서울1");
                    chkPlace[1].setText("서울2");
                    chkPlace[2].setText("서울3");
                    chkPlace[3].setText("서울4");
                    chkPlace[4].setText("서울5");
                    break;
                case R.id.radio_city2:
                    selCity ="대전";
                    chkPlace[0].setText("대전1");
                    chkPlace[1].setText("대전2");
                    chkPlace[2].setText("대전3");
                    chkPlace[3].setText("대전4");
                    chkPlace[4].setText("대전5");
                    break;
                case R.id.radio_city3:
                    selCity ="광주";
                    chkPlace[0].setText("광주1");
                    chkPlace[1].setText("광주2");
                    chkPlace[2].setText("광주3");
                    chkPlace[3].setText("광주4");
                    chkPlace[4].setText("광주5");
                    break;
                case R.id.radio_city4:
                    selCity ="대구";
                    chkPlace[0].setText("대구1");
                    chkPlace[1].setText("대구2");
                    chkPlace[2].setText("대구3");
                    chkPlace[3].setText("대구4");
                    chkPlace[4].setText("대구5");
                    break;
                case R.id.radio_city5:
                    selCity ="부산";
                    chkPlace[0].setText("부산1");
                    chkPlace[1].setText("부산2");
                    chkPlace[2].setText("부산3");
                    chkPlace[3].setText("부산4");
                    chkPlace[4].setText("부산5");
                    break;
                case R.id.btn_cancel:
                    dismiss();
                    break;
                case R.id.btn_ok:
                    for(int i=0; i<chkPlace.length; i++) {
                        if(chkPlace[i].isChecked()) {
                            selPlaces.add(chkPlace[i].getText().toString());
                        }
                    }
                    Toast.makeText(getContext(), selCity + selPlaces, Toast.LENGTH_SHORT).show();
                    dismiss();
                    break;
            }
            layoutPlace.setVisibility(View.VISIBLE);
        }
    }

}
