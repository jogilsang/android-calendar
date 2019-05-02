package app.worker.check.fragment;

/**
 * Created by user on 2018-06-10.
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import app.worker.check.activity.DetailActivity;
import app.worker.check.kakasubstitutedriving.R;

public class tabFragment2 extends BaseFragment {

    RelativeLayout tab_2_line_1_btn_1;
    RelativeLayout tab_2_line_1_btn_2;
    RelativeLayout tab_2_line_1_btn_3;
    RelativeLayout tab_2_line_2_btn_1;
    RelativeLayout tab_2_line_2_btn_2;
    RelativeLayout tab_2_line_2_btn_3;
    RelativeLayout tab_2_line_3_btn_1;
    RelativeLayout tab_2_line_3_btn_2;
    RelativeLayout tab_2_line_3_btn_3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_tab_2, container, false);

        initView(rootView);

        initSet();

        initData();

        setListener();

        return rootView;
    }

    public void initView(View v){

     tab_2_line_1_btn_1 = (RelativeLayout)v.findViewById(R.id.tab_2_line_1_btn_1);
     tab_2_line_1_btn_2 = (RelativeLayout)v.findViewById(R.id.tab_2_line_1_btn_2);
     tab_2_line_1_btn_3 = (RelativeLayout)v.findViewById(R.id.tab_2_line_1_btn_3);
     tab_2_line_2_btn_1 = (RelativeLayout)v.findViewById(R.id.tab_2_line_2_btn_1);
     tab_2_line_2_btn_2 = (RelativeLayout)v.findViewById(R.id.tab_2_line_2_btn_2);
     tab_2_line_2_btn_3 = (RelativeLayout)v.findViewById(R.id.tab_2_line_2_btn_3);
     tab_2_line_3_btn_1 = (RelativeLayout)v.findViewById(R.id.tab_2_line_3_btn_1);
     tab_2_line_3_btn_2 = (RelativeLayout)v.findViewById(R.id.tab_2_line_3_btn_2);
     tab_2_line_3_btn_3 = (RelativeLayout)v.findViewById(R.id.tab_2_line_3_btn_3);

    }

    public void setListener() {

        tab_2_line_1_btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newActivity();
            }
        });

        tab_2_line_1_btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newActivity();
            }
        });
        tab_2_line_1_btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newActivity();
            }
        });
        tab_2_line_2_btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newActivity();
            }
        });
        tab_2_line_2_btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newActivity();
            }
        });
        tab_2_line_2_btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newActivity();
            }
        });
        tab_2_line_3_btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newActivity();
            }
        });
        tab_2_line_3_btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newActivity();
            }
        });
        tab_2_line_3_btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newActivity();
            }
        });

    }

    public void newActivity() {

        Intent intent = new Intent(getContext(), DetailActivity.class);
        startActivity(intent);

    }


    public void initSet(){


    }



    public void initData(){




    }



}