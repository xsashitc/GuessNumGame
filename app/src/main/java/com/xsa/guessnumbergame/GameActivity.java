package com.xsa.guessnumbergame;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;

/**
 * @author xsa
 * @package com.xsa.guessnumbergame
 * @fileName GameActivity
 * @date on 2018/2/27 10:44
 */


public class GameActivity extends BaseActivity {

    private static final int[] num0 = {
            1, 3, 5, 7,
            9, 11, 13, 15,
            17, 19, 21, 23,
            25, 27, 29, 31
    };
    private static final int[] num1 = {
            2, 3, 6, 7,
            10, 11, 14, 15,
            18, 19, 22, 23,
            26, 27, 30, 31
    };
    private static final int[] num2 = {
            4, 5, 6, 7,
            12, 13, 14, 15,
            20, 21, 22, 23,
            28, 29, 30, 31
    };
    private static final int[] num3 = {
            8, 9, 10, 11,
            12, 13, 14, 15,
            24, 25, 26, 27,
            28, 29, 30, 31
    };
    private static final int[] num4 = {
            16, 17, 18, 19,
            20, 21, 22, 23,
            24, 25, 26, 27,
            28, 29, 30, 31
    };

    private GameModel mModel;

    private int[][] nums = {num0, num1, num2, num3, num4};
    private GameFragment[] mFragments;
    private GameFragment currentFragment;

    private int mState = 0;
    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    mState++;
                    selectNums(mState);
                    break;
                case 1:
                    showResult();
                    break;
                default:
                    break;
            }
            return true;
        }
    });

    private void showResult() {
        int result = mModel.getResult();
        new AlertDialog.Builder(mContext)
                .setTitle("结果")
                .setMessage(getString(R.string.your_num_is,result))
                .setPositiveButton("关闭", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).show();
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_game;
    }

    @Override
    protected void initVariablesAndViews() {
        mModel = new GameModel();
        initFragments();
        selectNums(0);
    }

    private void initFragments() {
        int count = nums.length;
        mFragments = new GameFragment[count];
        for (int i = 0; i < count; i++) {
            GameFragment fragment = GameFragment.newInstance(nums[i]);
            mFragments[i] = fragment;
        }
    }

    public GameModel getGameModel() {
        return mModel;
    }

    public void next() {
        mHandler.sendEmptyMessage(0);
    }

    private void selectNums(int index) {
        if (index > nums.length || index < 0) {
            return;
        }


        if (index < nums.length) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            GameFragment fragment = mFragments[index];
            if (currentFragment != null) {
                transaction.remove(currentFragment);
            }
            transaction.add(R.id.fl_content, fragment, String.valueOf(index));
            transaction.show(fragment);
            currentFragment = fragment;
            transaction.commit();
        } else {
//            if (currentFragment != null) {
//                transaction.remove(currentFragment);
//                currentFragment = null;
            mHandler.sendEmptyMessage(1);
//            }
        }


    }
}
