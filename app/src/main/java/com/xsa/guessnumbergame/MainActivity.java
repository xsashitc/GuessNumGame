package com.xsa.guessnumbergame;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_start_game)
    Button btnStartGame;
    @BindView(R.id.tv_game_rule)
    TextView tvGameRule;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.btn_start_game)
    public void onBtnStartGameClicked() {
        new AlertDialog.Builder(mContext)
                .setMessage("想一个1-31之间的数字")
                .setPositiveButton("想好了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(mContext,GameActivity.class);
                        startActivity(intent);
                        dialog.dismiss();
                    }
                }).setNegativeButton("再让我想想", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }

    @OnClick(R.id.tv_game_rule)
    public void onTvGameRuleClicked() {
        new AlertDialog.Builder(mContext)
                .setTitle("游戏规则")
                .setMessage("参与者在1-31中选择一个数字，记在心中。开始游戏后会出现5个界面，每个界面上有16个数字。若所选数字在这16个数字中，选择\"在其中\"选项;否则选择\"不在其中\"选项。5个界面都选择完毕后，会给出一个数字，就是参与者所想数字。看看这个猜测准不准呢？")
                .setPositiveButton("关闭", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }
}
