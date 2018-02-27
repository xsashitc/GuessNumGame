package com.xsa.guessnumbergame;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author xsa
 * @package com.xsa.guessnumbergame
 * @fileName BaseFragment
 * @date on 2018/2/27 14:19
 */


public abstract class BaseFragment extends Fragment {

    protected View mView;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getContentView(),container,false);
        unbinder = ButterKnife.bind(this,mView);
        initVariablesAndViews();
        return mView;
    }

    protected abstract int getContentView();

    protected void initVariablesAndViews(){

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
