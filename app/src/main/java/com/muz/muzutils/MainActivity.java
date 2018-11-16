package com.muz.muzutils;

import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.muz.muzutils.snackbar.MuzBaseTransientBottomBar;
import com.muz.muzutils.snackbar.MuzSnackbar;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CoordinatorLayout constraintLayout = (CoordinatorLayout) findViewById(R.id.main_const);
        Snackbar snackbars = Snackbar.make(constraintLayout, "幕栀", Snackbar.LENGTH_LONG);
        MuzSnackbar snackbar = MuzSnackbar.make(constraintLayout, "幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀幕栀", MuzSnackbar.LENGTH_INDEFINITE);
        snackbar.setAction("你好！", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "你好！", Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.setActionTextColor(0xFF3F51B5);
//        snackbar.setText("不好");
snackbar.setTextColor(0xFF3F51B5);
        snackbar.addCallback(new MuzBaseTransientBottomBar.BaseCallback<MuzSnackbar>() {
            @Override
            public void onDismissed(MuzSnackbar transientBottomBar, int event) {
                super.onDismissed(transientBottomBar, event);
                switch (event) {
                    case MuzSnackbar.Callback.DISMISS_EVENT_CONSECUTIVE:
                    case MuzSnackbar.Callback.DISMISS_EVENT_MANUAL:
                    case MuzSnackbar.Callback.DISMISS_EVENT_SWIPE:
                    case MuzSnackbar.Callback.DISMISS_EVENT_TIMEOUT:
                        Toast.makeText(MainActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                        break;
                    case MuzSnackbar.Callback.DISMISS_EVENT_ACTION:
                        Toast.makeText(MainActivity.this, "撤销了删除操作", Toast.LENGTH_SHORT).show();
                        break;

                }
                Log.e("MainActivity", "onDismissed");
            }

            @Override
            public void onShown(MuzSnackbar transientBottomBar) {
                super.onShown(transientBottomBar);
                Log.e("MainActivity", "onShown");
            }
        });
//        snackbar.setDuration(5000);
//        snackbar.getView().setBackgroundResource(R.drawable.ic_launcher_background);
        //snackbar.getView().setEnabled(false);毫无意义，并且没有效果
        snackbar.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "外部点击！", Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.setMaxLines(1);
        snackbar.setIcon(R.drawable.ic_launcher_background);
        snackbar.isTop();
//        snackbar.setInitialGravity();
//        snackbar.setTextSize(R.dimen.name_size);
        snackbar.setTextTypeface("ffa.ttf");
//        snackbar.getView().getTag(1);
//        snackbar.getView()
        snackbar.show();
//        MuzSnackbar snackbarss = MuzSnackbar.make(constraintLayout, "第二个", MuzSnackbar.LENGTH_INDEFINITE);
//        snackbar.setAction("点击！", new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "成功！", Toast.LENGTH_SHORT).show();
//            }
//        });
//        snackbarss.show();
    }
}
