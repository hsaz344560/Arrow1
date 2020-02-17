package com.example.arrow1;
//修改测试
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button button2;
    private PopupWindow popupWindow;
    private Handler mHandler = new Handler();

    //主程序，设置button点击事件
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btn);
        button2 = findViewById(R.id.btn2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showWindow();

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWindow2();
            }
        });
    }


    private void showWindow() {
        //加载弹窗的布局文件
        View layout = getLayoutInflater().inflate(R.layout.arrow ,null);
        //找到布局
        final RelativeLayout relativeLayout = layout.findViewById(R.id.arrow1);
        //创建弹窗的布局
        popupWindow = new PopupWindow(layout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        //设置返回键取消
        popupWindow.setFocusable(true);
        //动画
        showAnimation(relativeLayout);
        //从指定位置弹出
        popupWindow.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);
    }

    private void showWindow2() {
        View layout = getLayoutInflater().inflate(R.layout.arrow2 ,null);
        final RelativeLayout relativeLayout = layout.findViewById(R.id.arrow2);
        popupWindow = new PopupWindow(layout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setFocusable(true);
        showAnimation(relativeLayout);
        popupWindow.showAtLocation(getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);

    }
    //遍历布局
    private void showAnimation(ViewGroup layout) {
        for (int i = 0; i < layout.getChildCount(); i++) {
            final View child = layout.getChildAt(i);
            child.setVisibility(View.INVISIBLE);
            //handler设置延迟
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    child.setVisibility(View.VISIBLE);
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            child.setVisibility(View.INVISIBLE);
                        }
                    }, 900);
                }
            }, i * 1000);
        }
    }


}
