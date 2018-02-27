package com.xsa.guessnumbergame;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * @author xsa
 * @package com.xsa.guessnumbergame
 * @fileName GameFragment
 * @date on 2018/2/27 14:21
 */


public class GameFragment extends BaseFragment {

    private static final String INT_ARRAY = "int array";

    @BindView(R.id.gv_num)
    GridView gvNum;

    private int[] mNums;
    private NumAdapter mAdapter;

    public static GameFragment newInstance(int[] nums) {
        Bundle args = new Bundle();
        args.putIntArray(INT_ARRAY, nums);
        GameFragment fragment = new GameFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getContentView() {
        return R.layout.fragment_game;
    }

    @Override
    protected void initVariablesAndViews() {
        initData();
        mAdapter = new NumAdapter();
        gvNum.setAdapter(mAdapter);
    }

    private void initData(){
        Bundle args = getArguments();
        mNums = args.getIntArray(INT_ARRAY);
    }

    @OnClick({R.id.btn_is_in, R.id.btn_is_not_in})
    public void onViewClicked(View view) {
        int rate = 0;
        switch (view.getId()) {
            case R.id.btn_is_in:
                rate = 1;
                break;
            case R.id.btn_is_not_in:
                rate = 0;
                break;
            default:
                break;
        }
        GameActivity activity = (GameActivity) getActivity();
        GameModel model = activity.getGameModel();
        model.add(mNums[0] * rate);
        activity.next();
    }

    private class NumAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return mNums.length;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            ViewHolder holder = null;
            if (convertView == null){
                convertView = inflater.inflate(R.layout.item_num,null);
                holder = new ViewHolder();
                holder.tvNum = convertView.findViewById(R.id.tv_num);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tvNum.setText(String.valueOf(mNums[position]));
            return convertView;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public Object getItem(int position) {
            return mNums[position];
        }

        class ViewHolder{
            TextView tvNum;
        }
    }
}
