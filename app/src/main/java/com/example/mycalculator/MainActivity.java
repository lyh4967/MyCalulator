package com.example.mycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //View의 각 버튼을 변수값으로 받아온다. 밑 메서드에 사용하기위해 상수화시킨다.
        final Button btn1= (Button)findViewById(R.id.button1);
        final Button btn2= (Button)findViewById(R.id.button2);
        final Button btn3= (Button)findViewById(R.id.button3);
        final Button btn4= (Button)findViewById(R.id.button4);
        final Button btn5= (Button)findViewById(R.id.button5);
        final Button btn6= (Button)findViewById(R.id.button6);
        final Button btn7= (Button)findViewById(R.id.button7);
        final Button btn8= (Button)findViewById(R.id.button8);
        final Button btn9= (Button)findViewById(R.id.button9);
        final Button btn0= (Button)findViewById(R.id.button0);
        final Button btnPlus= (Button)findViewById(R.id.buttonAdd);
        final Button btnSub= (Button)findViewById(R.id.buttonMinus);
        final Button btnMul= (Button)findViewById(R.id.buttonMul);
        final Button btnCLR= (Button)findViewById(R.id.buttonCLR);
        final Button btnEqual= (Button)findViewById(R.id.buttonEqual);
        final Button btnDiv= (Button)findViewById(R.id.buttonDivide);

        //TextView 변수 할당
        final TextView textView=(TextView) findViewById(R.id.textView);
//
        //View의 버튼클릭시 이벤트 발생
        View.OnClickListener clickListener= new View.OnClickListener(){
            double num=0;
            double result=0;
            ArrayList<Double> numArr=new ArrayList();
            String displayNum="";
            String oper="";
            @Override
            public void onClick(View v){
                String text=(String)((Button) v).getText();
                //연산자가 들어오면 연산하고 아니면 출력한다. 연산할때마다 계산해야함
                if(text.equals("+")||text.equals("-")||text.equals("*")||text.equals("/")||text.equals("CLR")||text.equals("=")){
                    num=Double.parseDouble(textView.getText().toString());
                    numArr.add(num);
                    displayNum="";
                    System.out.println(text);
                    if (text.equals("=")) {
                        if(oper.equals("+")){
                            result=numArr.get(0)+Double.parseDouble(textView.getText().toString());
                            numArr.clear();
                            textView.setText(String.valueOf(result));
                            displayNum=String.valueOf(result);
                        }
                        if(oper.equals("-")){
                            result=numArr.get(0)-Double.parseDouble(textView.getText().toString());
                            numArr.clear();
                            textView.setText(String.valueOf(result));
                            displayNum=String.valueOf(result);
                        }
                        if(oper.equals("*")){
                            result=numArr.get(0)*Double.parseDouble(textView.getText().toString());
                            numArr.clear();
                            textView.setText(String.valueOf(result));
                            displayNum=String.valueOf(result);
                        }
                        if(oper.equals("/")) {
                            result = numArr.get(0) / Double.parseDouble(textView.getText().toString());
                            numArr.clear();
                            textView.setText(String.valueOf(result));
                            displayNum = String.valueOf(result);
                        }

                    }
                    oper=text;
                    if (text.equals("CLR")) {
                        displayNum="";
                        result=0;
                        numArr.clear();
                        textView.setText("0");
                    }
                }else{
                    displayNum+=text;
                    textView.setText(displayNum);
                }
            }
        };

        //각 버튼별 클릭이벤트 지정
        btn0.setOnClickListener(clickListener);
        btn1.setOnClickListener(clickListener);
        btn2.setOnClickListener(clickListener);
        btn3.setOnClickListener(clickListener);
        btn4.setOnClickListener(clickListener);
        btn5.setOnClickListener(clickListener);
        btn6.setOnClickListener(clickListener);
        btn7.setOnClickListener(clickListener);
        btn8.setOnClickListener(clickListener);
        btn9.setOnClickListener(clickListener);
        btnPlus.setOnClickListener(clickListener);
        btnSub.setOnClickListener(clickListener);
        btnMul.setOnClickListener(clickListener);
        btnCLR.setOnClickListener(clickListener);
        btnDiv.setOnClickListener(clickListener);
        btnEqual.setOnClickListener(clickListener);

    }

}
