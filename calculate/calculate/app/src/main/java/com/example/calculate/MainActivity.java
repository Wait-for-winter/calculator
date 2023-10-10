package com.example.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    Button btn_9, btn_8, btn_7, btn_6, btn_5, btn_4, btn_3, btn_2, btn_1, btn_0,
            btn_c, btn_b, btn_a, btn_s, btn_m, btn_d, btn_e, btn_dot;
    TextView tv1;
    StringBuilder expression = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_9 = findViewById(R.id.btn_9);
        btn_8 = findViewById(R.id.btn_8);
        btn_7 = findViewById(R.id.btn_7);
        btn_6 = findViewById(R.id.btn_6);
        btn_5 = findViewById(R.id.btn_5);
        btn_4 = findViewById(R.id.btn_4);
        btn_3 = findViewById(R.id.btn_3);
        btn_2 = findViewById(R.id.btn_2);
        btn_1 = findViewById(R.id.btn_1);
        btn_0 = findViewById(R.id.btn_0);
        btn_c = findViewById(R.id.btn_c);

        btn_a = findViewById(R.id.btn_a);
        btn_s = findViewById(R.id.btn_s);
        btn_m = findViewById(R.id.btn_m);
        btn_d = findViewById(R.id.btn_d);

        btn_b = findViewById(R.id.btn_b);

        btn_e = findViewById(R.id.btn_e);

        btn_dot = findViewById(R.id.btn_dot);

        tv1 = findViewById(R.id.tv1);

        //9-0
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToExpression("9");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToExpression("8");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToExpression("7");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToExpression("6");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToExpression("5");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToExpression("4");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToExpression("3");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToExpression("2");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToExpression("1");
            }
        });

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToExpression("0");
            }
        });

        //加减乘除
        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToExpression("+");
            }
        });

        btn_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToExpression("-");
            }
        });

        btn_m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToExpression("*");
            }
        });

        btn_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToExpression("/");
            }
        });

        //回退
        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.setLength(expression.length() - 1);
                tv1.setText(expression.toString());
            }
        });

        //小数点
        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendToExpression(".");
            }
        });

        //清除
        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearExpression();
            }
        });

        //=
        btn_e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateExpression();
            }
        });
    }

    private void appendToExpression(String value) {
        expression.append(value);
        tv1.setText(expression.toString());
    }

    private void clearExpression() {
        expression.setLength(0);
        tv1.setText("0");
    }

    private void calculateExpression() {

        try {
            // 使用表达式解析器创建一个表达式对象
            ScriptEngine cal = new ScriptEngineManager().getEngineByName("js");

            // 计算表达式的值
            String result = cal.eval(String.valueOf(expression)).toString();

            // 更新 TextView 显示结果
            tv1.setText(result);

            // 清空表达式以支持连续计算
            expression.setLength(0);
            expression.append(result);

        } catch (Exception e) {
            // 处理计算错误，例如除以零
            tv1.setText("Error");
            expression.setLength(0);
        }
    }
}