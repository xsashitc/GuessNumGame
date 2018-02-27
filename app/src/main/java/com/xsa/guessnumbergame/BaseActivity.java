package com.xsa.guessnumbergame;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * @author xsa
 * @package com.xsa.guessnumbergame
 * @fileName BaseActivity
 * @date on 2018/2/27 10:23
 */


public abstract class BaseActivity extends AppCompatActivity {

    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mContext = this;
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        ButterKnife.bind(this);
        initVariablesAndViews();
    }

    protected abstract int getContentView();

    protected void initVariablesAndViews(){

    }
}
