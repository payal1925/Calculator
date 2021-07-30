package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b00,b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bplus,bminus,bmul,bdiv,bdot,bequal,bclear,bx,bsign;
    char ch;
    TextView t1,t2,t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b00=(Button) findViewById(R.id.button00);
        b0=(Button) findViewById(R.id.button0);
        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        b3=(Button) findViewById(R.id.button3);
        b4=(Button) findViewById(R.id.button4);
        b5=(Button) findViewById(R.id.button5);
        b6=(Button) findViewById(R.id.button6);
        b7=(Button) findViewById(R.id.button7);
        b8=(Button) findViewById(R.id.button8);
        b9=(Button) findViewById(R.id.button9);
        bdot=(Button) findViewById(R.id.buttondot);
        bdiv=(Button) findViewById(R.id.buttondiv);
        bplus=(Button) findViewById(R.id.buttonplus);
        bminus=(Button) findViewById(R.id.buttonminus);
        bmul=(Button) findViewById(R.id.buttonmult);
        bx=(Button) findViewById(R.id.buttonx);
        bclear=(Button) findViewById(R.id.buttonclear);
        bequal=(Button) findViewById(R.id.buttonequal);
        bsign=(Button) findViewById(R.id.buttonsign);
        t1=(TextView) findViewById(R.id.textView1);
        t2=(TextView) findViewById(R.id.textView2);
        t3=(TextView) findViewById(R.id.textView3);


        b00.setOnClickListener(v -> t1.setText(t1.getText() + "00"));

        b0.setOnClickListener(v -> t1.setText(t1.getText() + "0"));

        b1.setOnClickListener(v -> t1.setText(t1.getText() + "1"));

        b2.setOnClickListener(v -> t1.setText(t1.getText() + "2"));

        b3.setOnClickListener(v -> t1.setText(t1.getText() + "3"));

        b4.setOnClickListener(v -> t1.setText(t1.getText() + "4"));

        b5.setOnClickListener(v -> t1.setText(t1.getText() + "5"));

        b6.setOnClickListener(v -> t1.setText(t1.getText() + "6"));

        b7.setOnClickListener(v -> t1.setText(t1.getText() + "7"));

        b8.setOnClickListener(v -> t1.setText(t1.getText() + "8"));

        b9.setOnClickListener(v -> t1.setText(t1.getText() + "9"));
        bdot.setOnClickListener(v -> {
            if(t1.getText().toString().isEmpty())
                t1.setText("0.");
            else if(t1.getText().toString()=="-")
                t1.setText("-0.");
            else if(t1.getText().toString().indexOf('.')==-1)
                t1.setText(t1.getText()+".");
        });

        bsign.setOnClickListener(v -> {
            if(t1.getText().toString().isEmpty())
                t1.setText("-");
        });

        bplus.setOnClickListener(v -> {
            if(t1.getText().toString().isEmpty()==true && t2.getText().toString().isEmpty()==true){
                ch=' ';
            }
            else if(t1.getText().toString().isEmpty()==true && t2.getText().toString().isEmpty()==false){
                ch='+';
            }
            else if(t1.getText().toString().equals("-") || t1.getText().toString().equals("-0.") || t1.getText().toString().equals("0."));
            else if(t2.getText().toString().isEmpty()==true && t1.getText().toString().isEmpty()==false ){
                t2.setText(t1.getText());
                t1.setText("");
                ch='+';
            }
            else {
                if(ch==' ')
                    t2.setText(t1.getText());
                else {
                    if (t1.getText().toString().contains(".") || t2.getText().toString().contains(".")) {
                        float a = Float.parseFloat(t1.getText().toString()), b = Float.parseFloat(t2.getText().toString());
                        if (ch == '+')
                            t2.setText(Float.toString((a + b)));
                        else if (ch == '-')
                            t2.setText(Float.toString((b - a)));
                        else if (ch == '*')
                            t2.setText(Float.toString((a * b)));
                        else {
                            if (a == 0)
                                Toast.makeText(MainActivity.this, "Cannot be divided by Zero", Toast.LENGTH_LONG).show();
                            else
                                t2.setText(Float.toString((b / a)));
                        }
                    } else {
                        int a = Integer.parseInt(t1.getText().toString()), b = Integer.parseInt(t2.getText().toString());
                        if (ch == '+')
                            t2.setText(Integer.toString((a + b)));
                        else if (ch == '-')
                            t2.setText(Integer.toString((b - a)));
                        else if (ch == '*')
                            t2.setText(Integer.toString((a * b)));
                        else if (ch == '/') {
                            if(a==0)
                                Toast.makeText(MainActivity.this, "Cannot be divided by Zero", Toast.LENGTH_LONG).show();
                            else {
                                if (b % a == 0)
                                    t2.setText(Integer.toString((b / a)));
                                else
                                    t2.setText(Float.toString(((float) b / (float) a)));
                            }
                        }
                        }
                    }
                t1.setText("");
                ch='+';
            }
            t3.setText(""+ch);
        });

        bminus.setOnClickListener(v -> {
            if(t1.getText().toString().isEmpty()==true && t2.getText().toString().isEmpty()==true){
                ch=' ';
            }
            else if(t1.getText().toString().isEmpty()==true && t2.getText().toString().isEmpty()==false){
                ch='-';
            }
            else if(t1.getText().toString().equals("-") || t1.getText().toString().equals("-0.") || t1.getText().toString().equals("0."));
            else if(t2.getText().toString().isEmpty()==true && t1.getText().toString().isEmpty()==false){
                t2.setText(t1.getText());
                t1.setText("");
                ch='-';
            }
            else {
                if (ch == ' ')
                    t2.setText(t1.getText());
                else {
                    if (t1.getText().toString().contains(".") || t2.getText().toString().contains(".")) {
                        float a = Float.parseFloat(t1.getText().toString()), b = Float.parseFloat(t2.getText().toString());
                        if (ch == '+')
                            t2.setText(Float.toString((a + b)));
                        else if (ch == '-')
                            t2.setText(Float.toString((b - a)));
                        else if (ch == '*')
                            t2.setText(Float.toString((a * b)));
                        else if (ch == '/') {
                            if (a == 0)
                                Toast.makeText(MainActivity.this, "Cannot be divided by Zero", Toast.LENGTH_LONG).show();
                            else
                                t2.setText(Float.toString((b / a)));
                        }
                    } else {
                        int a = Integer.parseInt(t1.getText().toString()), b = Integer.parseInt(t2.getText().toString());
                        if (ch == '+')
                            t2.setText(Integer.toString((a + b)));
                        else if (ch == '-')
                            t2.setText(Integer.toString((b - a)));
                        else if (ch == '*')
                            t2.setText(Integer.toString((a * b)));
                        else if (ch == '/') {
                            if(a==0)
                                Toast.makeText(MainActivity.this, "Cannot be divided by Zero", Toast.LENGTH_LONG).show();
                            else
                                {
                                if (b % a == 0)
                                    t2.setText(Integer.toString((b / a)));
                                else
                                    t2.setText(Float.toString(((float) b / (float) a)));
                            }
                        }
                    }
                }
                t1.setText("");
                ch = '-';
            }
            t3.setText(""+ch);
        });

        bdiv.setOnClickListener(v -> {
            if(t1.getText().toString().isEmpty()==true && t2.getText().toString().isEmpty()==true){
                ch=' ';
            }
            else if(t1.getText().toString().isEmpty()==true && t2.getText().toString().isEmpty()==false) {
                ch = '/';
            }
            else if(t1.getText().toString().equals("-") || t1.getText().toString().equals("-0.") || t1.getText().toString().equals("0."));
            else if (t2.getText().toString().isEmpty() == true && t1.getText().toString().isEmpty() == false) {
                t2.setText(t1.getText());
                t1.setText("");
                ch='/';
            }
            else {
                if (ch == ' ')
                    t2.setText(t1.getText());
                else {
                    if (t1.getText().toString().contains(".") || t2.getText().toString().contains(".")) {
                        float a = Float.parseFloat(t1.getText().toString()), b = Float.parseFloat(t2.getText().toString());
                        if (ch == '+')
                            t2.setText(Float.toString((a + b)));
                        else if (ch == '-')
                            t2.setText(Float.toString((b - a)));
                        else if (ch == '*')
                            t2.setText(Float.toString((a * b)));
                        else if (ch == '/') {
                            if (a == 0)
                                Toast.makeText(MainActivity.this, "Cannot be divided by Zero", Toast.LENGTH_LONG).show();
                            else
                                t2.setText(Float.toString((b / a)));
                        }
                    } else {
                        int a = Integer.parseInt(t1.getText().toString()), b = Integer.parseInt(t2.getText().toString());
                        if (ch == '+')
                            t2.setText(Integer.toString((a + b)));
                        else if (ch == '-')
                            t2.setText(Integer.toString((b - a)));
                        else if (ch == '*')
                            t2.setText(Integer.toString((a * b)));
                        else if (ch == '/') {
                            if(a==0)
                                Toast.makeText(MainActivity.this, "Cannot be divided by Zero", Toast.LENGTH_LONG).show();
                            else {
                                if (b % a == 0)
                                    t2.setText(Integer.toString((b / a)));
                                else
                                    t2.setText(Float.toString(((float) b / (float) a)));
                            }
                        }
                    }
                }
                    t1.setText("");
                    ch = '/';
                }
            t3.setText(""+ch);
            });

        bmul.setOnClickListener(v -> {
            if(t1.getText().toString().isEmpty()==true && t2.getText().toString().isEmpty()==true){
                ch=' ';
            }
            else if(t1.getText().toString().isEmpty()==true && t2.getText().toString().isEmpty()==false) {
                ch = '*';
            }
            else if(t1.getText().toString().equals("-") || t1.getText().toString().equals("-0.") || t1.getText().toString().equals("0."));
            else if(t2.getText().toString().isEmpty()==true && t1.getText().toString().isEmpty()==false){
                t2.setText(t1.getText());
                t1.setText("");
                ch='*';
            }
            else {
                if (ch == ' ')
                    t2.setText(t1.getText());
                else {
                    if (t1.getText().toString().contains(".") || t2.getText().toString().contains(".")) {
                        float a = Float.parseFloat(t1.getText().toString()), b = Float.parseFloat(t2.getText().toString());

                        if (ch == '+')
                            t2.setText(Float.toString((a + b)));
                        else if (ch == '-')
                            t2.setText(Float.toString((b - a)));
                        else if (ch == '*')
                            t2.setText(Float.toString((a * b)));
                        else if (ch == '/') {
                            if (a == 0)
                                Toast.makeText(MainActivity.this, "Cannot be divided by Zero", Toast.LENGTH_LONG).show();
                            else
                                t2.setText(Float.toString((b / a)));
                        }
                    } else {
                        int a = Integer.parseInt(t1.getText().toString()), b = Integer.parseInt(t2.getText().toString());

                        if (ch == '+')
                            t2.setText(Integer.toString((a + b)));
                        else if (ch == '-')
                            t2.setText(Integer.toString((b - a)));
                        else if (ch == '*')
                            t2.setText(Integer.toString((a * b)));
                        else if (ch == '/') {
                            if(a==0)
                                Toast.makeText(MainActivity.this, "Cannot be divided by Zero", Toast.LENGTH_LONG).show();
                            else {
                                if (b % a == 0)
                                    t2.setText(Integer.toString((b / a)));
                                else
                                    t2.setText(Float.toString(((float) b / (float) a)));
                            }
                        }
                    }
                }
                    t1.setText("");
                    ch = '*';
                }
            t3.setText(""+ch);
        });

        bequal.setOnClickListener(v -> {
            if(t1.getText().toString().equals("-") || t1.getText().toString().equals("-0.") || t1.getText().toString().equals("0."));
            else if(t2.getText().toString().isEmpty()==false && t1.getText().toString().isEmpty()==false) {
                if (ch == '+') {
                    if (t1.getText().toString().contains(".") || t2.getText().toString().contains("."))
                        t2.setText(Float.toString((Float.parseFloat(t1.getText().toString()) + Float.parseFloat(t2.getText().toString()))));
                    else
                        t2.setText(Integer.toString((Integer.parseInt(t1.getText().toString()) + Integer.parseInt(t2.getText().toString()))));
                } else if (ch == '-') {
                    if (t1.getText().toString().contains(".") || t2.getText().toString().contains("."))
                        t2.setText(Float.toString((Float.parseFloat(t2.getText().toString()) - Float.parseFloat(t1.getText().toString()))));
                    else
                        t2.setText(Integer.toString((Integer.parseInt(t2.getText().toString()) - Integer.parseInt(t1.getText().toString()))));
                } else if (ch == '/') {
                    if (t1.getText().toString().contains(".") || t2.getText().toString().contains(".")) {
                        float a = Float.parseFloat(t1.getText().toString());
                        float b = Float.parseFloat(t2.getText().toString());
                        if(a==0){
                            t2.setText("");
                            Toast.makeText(MainActivity.this, "Cannot be divided by Zero", Toast.LENGTH_LONG).show();
                        }
                        else
                            t2.setText(Float.toString((b / a)));
                    }
                    else {
                        int a = Integer.parseInt(t1.getText().toString());
                        int b = Integer.parseInt(t2.getText().toString());
                        if(a==0){
                            t2.setText("");
                            Toast.makeText(MainActivity.this, "Cannot be divided by Zero", Toast.LENGTH_LONG).show();
                        }
                        else if (b % a == 0)
                            t2.setText(Integer.toString((b / a)));
                        else
                            t2.setText(Float.toString(((float) b / (float) a)));
                    }
                }
                 else if(ch=='*') {
                    if (t1.getText().toString().contains(".") || t2.getText().toString().contains("."))
                        t2.setText(Float.toString((Float.parseFloat(t1.getText().toString()) * Float.parseFloat(t2.getText().toString()))));
                    else
                        t2.setText(Integer.toString((Integer.parseInt(t1.getText().toString()) * Integer.parseInt(t2.getText().toString()))));
                }
                 else{
                     t2.setText(t1.getText());
                }
                t1.setText("");
                 ch =' ';
                t3.setText("");
            }
        });

        bx.setOnClickListener(v -> {
            if(t1.getText().toString().isEmpty()==false)
            {
                t1.setText(t1.getText().toString().substring(0,t1.getText().toString().length()-1));
            }
        });

        bclear.setOnClickListener(v -> {
            t1.setText("");
            t2.setText("");
            t3.setText("");
        });
    }
}