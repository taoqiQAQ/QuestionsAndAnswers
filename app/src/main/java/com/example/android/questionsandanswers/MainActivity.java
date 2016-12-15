package com.example.android.questionsandanswers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int fenshu = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //根据ID找到RadioGroup实例
        RadioGroup group = (RadioGroup) findViewById(R.id.secend);
        //确定第2题xuanxiang
        RadioButton one = (RadioButton) findViewById(R.id.one);
        final RadioButton two = (RadioButton) findViewById(R.id.two);
        RadioButton three = (RadioButton) findViewById(R.id.three);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                if (checkedId == two.getId()) {
                    DisplayToast("正确答案：" + two.getText() + "，恭喜你，回答正确！");
                } else {
                    DisplayToast("请注意，回答错误！");
                }
            }
        });

        //根据ID找到RadioGroup实例
        RadioGroup group3 = (RadioGroup) findViewById(R.id.third);
        //确定第2题xuanxiang
        final RadioButton four = (RadioButton) findViewById(R.id.four);
        RadioButton five = (RadioButton) findViewById(R.id.five);
        RadioButton six = (RadioButton) findViewById(R.id.six);
        group3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                if (checkedId == four.getId()) {
                    DisplayToast("正确答案：" + four.getText() + "，恭喜你，回答正确！");
                } else {
                    DisplayToast("请注意，回答错误！");
                }
            }
        });
    }

    public void DisplayToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

    }

    /**
     * 单击 tijiao 按钮时调用此方法。
     */
    public void tijiao(View view) {

        Toast.makeText(this, "第二题答案：2 |第四题答案：4 ", Toast.LENGTH_SHORT).show();
        //增加爱好
        EditText aihaoField = (EditText) findViewById(R.id.aihao);
        String aihao = aihaoField.getText().toString();

        //确定用户是否选打篮球
        CheckBox sushiCheckBox = (CheckBox) findViewById(R.id.sushi);
        boolean hasSuShi = sushiCheckBox.isChecked();
        //确定用户是否选打游戏
        CheckBox sucheCheckBox = (CheckBox) findViewById(R.id.suche);
        boolean hasSuChe = sucheCheckBox.isChecked();
        //确定用户是否选看书
        CheckBox suxunCheckBox = (CheckBox) findViewById(R.id.suxun);
        boolean hasSuXun = suxunCheckBox.isChecked();
        //确定用户是否选跑步
        CheckBox libaiCheckBox = (CheckBox) findViewById(R.id.libai);
        boolean hasLiBai = libaiCheckBox.isChecked();
        String daanMessage = createOrderSummary(aihao, hasSuShi, hasSuChe, hasSuXun, hasLiBai);
        displayMessage(daanMessage);
    }


    private int pinfen(boolean two, boolean four) {
        if (two == true) {
            fenshu = fenshu + 50;
        }
        if (four == true) {
            fenshu = fenshu + 50;
        }

        return fenshu;
    }

    //创建订单摘要
    private String createOrderSummary(String aihao, boolean addhasSuShi, boolean addhasSuChe, boolean addhasSuXun, boolean addhasLiBai) {
        String daanMessage = "建议： " + aihao;
        daanMessage += "\n 爱好： ";
        daanMessage += "|打篮球 " + addhasSuShi;
        daanMessage += "|打游戏 " + addhasSuChe;
        daanMessage += "|看书 " + addhasSuXun;
        daanMessage += "|跑步 " + addhasLiBai;
        return daanMessage;
    }

    /**
     * 此方法在屏幕上显示答案。
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.daan);
        orderSummaryTextView.setText(message);
    }
}
