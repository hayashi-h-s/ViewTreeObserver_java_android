package com.haya.fragmentjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    private Button in_fragment_button;
//    private Button fragment_add_button;
//    private FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


    // フラグメント関連の定義
    private FragmentManager fragmentManager;
    private Fragment fragment = new MainFragment();
    private ButtonFragment ButtonFragmentClass = new ButtonFragment();


    private FrameLayout buttonFrame;
    private Button buttonUpBt;
    private Button buttonFragment;
    private Button nextPageButton;

    // fragment_button.xml からIDを取り出せるか？
    private Button add_fragment_button;

    // Button まとめ
    private Button nextPageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //要素の取得
        buttonFrame = findViewById(R.id.buttonFrame);
        // 画像がない時だけ、表示する
        fragmentManager = getSupportFragmentManager();

        // fragment_button.xml からIDを取り出せるか？
        // ViewTreeObserver のサンプルボタン
        add_fragment_button = findViewById(R.id.add_fragment_button);

        // Button要素の定義
        nextPageButton = findViewById(R.id.nextPageBtn);

        ViewTreeObserver observer = add_fragment_button.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        int getWidth = add_fragment_button.getWidth();
                        String getWidthSt = Integer.toString(getWidth);
                        Toast.makeText(MainActivity.this, getWidthSt, Toast.LENGTH_SHORT).show();
                    }
                });

        nextPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }


    public void onClickButtonUp(View view) {
        //        fragment_button.xmlのボタンの色を変える。
        add_fragment_button.setBackgroundColor(Color.parseColor("#00FF00"));

        ViewTreeObserver vtoButton = add_fragment_button.getViewTreeObserver();
        vtoButton.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ViewGroup.LayoutParams vtoButtonParams = add_fragment_button.getLayoutParams();
                vtoButtonParams.width = 200;
                vtoButtonParams.height = 300;
                add_fragment_button.setLayoutParams(vtoButtonParams);



                // ? removeOnGlobalLayoutListener が呼び出せないのはなぜ？
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                    add_fragment_button.removeOnGlobalLayoutListener(this);
//                } else {
//                    add_fragment_button.removeGlobalOnLayoutListener(this);
//                }

            }
        });

        // ボタンの位置を変える処理
//        buttonFrame.layout(400, 600, buttonFrame.getWidth(), 600 + buttonFrame.getHeight());
//        buttonFrame.layout(400, 600, 400 + buttonFrame.getWidth(), 600 + buttonFrame.getHeight());

    }

    public void onClickButtonLayout(View view) {








//        buttonFrame.layout(500, 500, buttonFrame.getWidth(), buttonFrame.getHeight());
//        buttonFrame.(500, 500, buttonFrame.getWidth(), buttonFrame.getHeight());
//        buttonFrame.layout(, buttonFrame.getHeight(), ,500 );
//
//        Button add_fragment_button = findViewById(R.id.add_fragment_button);
//
//        ViewGroup.LayoutParams lp = add_fragment_button.getLayoutParams();
//        ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams)lp;
//        mlp.setMargins(mlp.leftMargin, mlp.topMargin, mlp.rightMargin, 350);
//        //マージンを設定
//        add_fragment_button.setLayoutParams(mlp);
//
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        //フラグメントを作成する処理
//        transaction.replace(R.id.contents,fragment );
//        transaction.addToBackStack(null);
//        transaction.commit();
    }

    public void nextPage(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

////    // フラグメントを削除するボタン
////
//    public void onClickAddFragment(View view) {
//        MainFragment fragment = new MainFragment();
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.add(R.id.container, fragment);
//        transaction.commit();
//    }

//    public void addFragmentButton(View view) {
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.contents,fragment );
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }
//
//    public void deleteFragmentButton(View view) {
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.remove(fragment);
//        transaction.commit();
//    }

}