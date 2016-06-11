package com.example.doona.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTextValue;      //결과
    float mValueA;
    float mValueB;
    int mCalcMode = 0;      //연산종류변수
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextValue=(TextView)findViewById(R.id.textValue);
        mTextValue.setText("0");
    }

    public float getTextValueFloat() {
        float fValue = 0.f;
        String strText = mTextValue.getText().toString();
        fValue = Float.parseFloat(strText);
        return fValue;
    }

    public double getTextValueDouble() {
        double dValue = 0;
        String strText = mTextValue.getText().toString();
        dValue = Double.parseDouble(strText);
        return dValue;
    }

    public void onNumberButton(String strNumber){
        String strText = mTextValue.getText().toString();
        float fValue = getTextValueFloat();

        if(fValue==0.f)
            strText="";

        strText = strText+strNumber;
        mTextValue.setText(strText);
    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.button0:  onNumberButton("0");break;
            case R.id.button1:  onNumberButton("1");break;
            case R.id.button2:  onNumberButton("2");break;
            case R.id.button3:  onNumberButton("3");break;
            case R.id.button4:  onNumberButton("4");break;
            case R.id.button5:  onNumberButton("5");break;
            case R.id.button6:  onNumberButton("6");break;
            case R.id.button7:  onNumberButton("7");break;
            case R.id.button8:  onNumberButton("8");break;
            case R.id.button9:  onNumberButton("9");break;
            case R.id.buttonPoint:  onNumberButton(".");break;

            case R.id.buttonClear:  onNumberButton("0");break;
            case R.id.butonBack:
            {
                String strText=mTextValue.getText().toString();
                int nLength = strText.length();

                if(nLength>0){
                    strText=strText.substring(0, nLength-1);
                    if(strText.length() == 0)
                        strText= "0";
                    mTextValue.setText(strText);
                }

                break;
            }

            case R.id.buttonPlus:
                mValueA=getTextValueFloat();
                mTextValue.setText("0");
                mCalcMode=1;
                break;
            case R.id.buttonMinus:
                mValueA=getTextValueFloat();
                mTextValue.setText("0");
                mCalcMode= 2;
                break;
            case R.id.buttonMultiply :
                mValueA= getTextValueFloat();
                mTextValue.setText("0");
                mCalcMode= 3;
                break;
            case R.id.buttonDivide :
                mValueA= getTextValueFloat();
                mTextValue.setText("0");
                mCalcMode= 4;
                break;
            case R.id.buttonEqual:
            {
                mValueB=getTextValueFloat();
                switch(mCalcMode){
                    case 1: mValueA = mValueA + mValueB; break;
                    case 2: mValueA = mValueA - mValueB; break;
                    case 3: mValueA = mValueA * mValueB; break;
                    case 4: mValueA = mValueA / mValueB; break;
                }

                String strText = Float.toString(mValueA);
                mTextValue.setText(strText);
                mCalcMode=0;

                break;
            }

            case R.id.buttonSquare2:
            {
                double dValue = getTextValueDouble();
                String strText = Double.toString(Math.pow(dValue,2));
                mTextValue.setText(strText);

                break;
            }
            case R.id.buttonSquare3:
            {
                double dValue = getTextValueDouble();
                String strText = Double.toString(Math.pow(dValue,3));
                mTextValue.setText(strText);

                break;
            }
            case R.id.buttonSqrt:
            {
                double dValue = getTextValueDouble();
                String strText = Double.toString(Math.sqrt(dValue));
                mTextValue.setText(strText);

                break;
            }
            case R.id.buttonInverseDivide:
            {
                mValueA = getTextValueFloat();
                String strText = Float.toString(1/mValueA);
                mTextValue.setText(strText);

                break;
            }
        }
    }
}

