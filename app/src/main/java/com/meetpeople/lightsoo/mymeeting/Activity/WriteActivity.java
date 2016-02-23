package com.meetpeople.lightsoo.mymeeting.Activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.meetpeople.lightsoo.mymeeting.R;

public class WriteActivity extends AppCompatActivity {

//    private Button btn_check;
    private ImageButton btn_check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_write);
        setSupportActionBar(toolbar);
        //이걸로 기존에 뜨는 Title을 안보이게 한다.
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //백키가 나온다.
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //뭐지...
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationIcon(R.drawable.back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_check = (ImageButton)findViewById(R.id.btn_check);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"글쓰기 확인", Toast.LENGTH_SHORT).show();
            onAlertDialog(v);
            }

        });

    }

    public void onAlertDialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.alert);
        builder.setTitle("확 인");
        builder.setMessage("글 작성을 완료하시겠습니까?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(WriteActivity.this, "Yes clicked...", Toast.LENGTH_SHORT).show();
//                dialog.dismiss();
//                getActivity().finish();
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(WriteActivity.this, "No clicked...", Toast.LENGTH_SHORT).show();
            }
        });

        /**
         * 화면 바깥영역을 클릭해도 다이얼로그 안없어지게 한다.
         */
        builder.setCancelable(false);
        builder.create().show();
    }


}
