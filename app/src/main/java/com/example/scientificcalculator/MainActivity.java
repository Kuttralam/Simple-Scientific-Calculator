package com.example.scientificcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView input, sign;

    String signs,value1,value2;
    Double num1,num2,result;
    boolean dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (TextView) findViewById(R.id.input);
        sign = (TextView) findViewById(R.id.sign);

        dots = false;
    }


    public void log(View view)
    {
        signs = "log";
        input.setText(null);
        sign.setText("log");
        dots = false;
    }

    public void ln(View view)
    {
        signs = "ln";
        input.setText(null);
        sign.setText("ln");
        dots = false;
    }

    public void power(View view)
    {
        signs = "power";
        value1 = input.getText().toString();
        input.setText(null);
        dots = false;
        sign.setText("xⁿ");
    }

    public void root(View view)
    {
        signs = "root";
        input.setText(null);
        dots = false;
        sign.setText("√");
    }

    public void factorial(View view)
    {
        signs = "factorial";
        input.setText(null);
        dots = false;
        sign.setText("!");
    }

    public void sin(View view)
    {
        signs = "sin";
        input.setText(null);
        dots = false;
        sign.setText("sin");
    }

    public void cos(View view)
    {
        signs = "cos";
        input.setText(null);
        dots = false;
        sign.setText("cos");
    }

    public void tan(View view)
    {
        signs = "tan";
        input.setText(null);
        dots = false;
        sign.setText("tan");
    }

    public void button_7(View view)
    {
        input.setText(input.getText() + "7");
    }

    public void button_8(View view)
    {
        input.setText(input.getText() + "8");
    }

    public void button_9(View view)
    {
        input.setText(input.getText() + "9");
    }

    public void allclear(View view)
    {
        input.setText(null);
        sign.setText(null);
        value1 = null;
        value2 = null;
        signs = null;
        dots = false;
    }

    public void delete(View view)
    {
        if (input.getText().equals(""))
        {
            input.setText(null);
        }
        else
        {
            int len = input.getText().length();
            String s = input.getText().toString();
            if (s.charAt(len - 1) == '.')
            {
                dots = false;
                input.setText(input.getText().subSequence(0, input.getText().length() - 1));

            } else {
                input.setText(input.getText().subSequence(0, input.getText().length() - 1));
            }
        }
    }

    public void button_4(View view)
    {
        input.setText(input.getText() + "4");
    }

    public void button_5(View view)
    {
        input.setText(input.getText() + "5");
    }

    public void button_6(View view)
    {
        input.setText(input.getText() + "6");
    }

    public void multiply(View view)
    {
        signs = "*";
        value1 = input.getText().toString();
        input.setText(null);
        sign.setText("x");
        dots = false;
    }

    public void divide(View view)
    {
        signs = "/";
        value1 = input.getText().toString();
        input.setText(null);
        sign.setText("÷");
        dots = false;
    }

    public void button_1(View view)
    {
        input.setText(input.getText() + "1");
    }

    public void button_2(View view)
    {
        input.setText(input.getText() + "2");
    }

    public void button_3(View view)
    {
        input.setText(input.getText() + "3");
    }

    public void add(View view)
    {
        signs = "+";
        value1 = input.getText().toString();
        input.setText(null);
        sign.setText("+");
        dots = false;
    }

    public void subtract(View view)
    {
        signs = "-";
        value1 = input.getText().toString();
        input.setText(null);
        sign.setText("-");
        dots = false;
    }

    public void button_0(View view)
    {
        input.setText(input.getText() + "0");
    }

    public void power10(View view)
    {
        signs = "power10";
        value1 = input.getText().toString();
        input.setText(null);
        dots = false;
        sign.setText("10ⁿ");
    }

    public void dot(View view)
    {
        if (!dots)
        {
            if (input.getText().equals(""))
            {
                input.setText("0.");
            }
            else
            {
                input.setText(input.getText() + ".");
            }

            dots = true;
        }
    }

    public void equal(View view)
    {
        if (signs == null)
        {
            sign.setText(input.getText());
        }
        else if (input.getText().equals(""))
        {
            sign.setText("Error!");
        }
        else if ((signs.equals("+") || signs.equals("-") || signs.equals("*") || signs.equals("/")) && value1.equals(""))
        {
            sign.setText("Error!");
        }

        else
        {
            switch (signs) {
                default:
                    break;
                case "log":
                    value1 = input.getText().toString();
                    num1 = Double.parseDouble(value1);
                    input.setText(Math.log10(num1) + "");
                    signs = null;
                    sign.setText(null);
                    break;
                case "ln":
                    value1 = input.getText().toString();
                    num1 = Double.parseDouble(value1);
                    input.setText(Math.log(num1) + "");
                    signs = null;
                    sign.setText(null);
                    break;
                case "power":
                    if(value1.equals(""))
                    {
                        sign.setText("Error!");
                        signs = null;
                        break;
                    }
                    else
                    {
                        num1 = Double.parseDouble((value1));
                        value2 = input.getText().toString();
                        num2 = Double.parseDouble(value2);
                        input.setText(Math.pow(num1, num2) + "");
                        signs = null;
                        sign.setText(null);
                        break;
                    }

                case "power10":
                    value1 = input.getText().toString();
                    num1 = Double.parseDouble((value1));
                    input.setText(Math.pow(10, num1) + "");
                    signs = null;
                    sign.setText(null);
                    break;

                case "root":
                    value1 = input.getText().toString();
                    num1 = Double.parseDouble((value1));
                    input.setText(Math.sqrt(num1) + "");
                    signs = null;
                    sign.setText(null);
                    break;
                case "factorial":
                    value1 = input.getText().toString();
                    num1 = Double.parseDouble((value1));
                    int i = Integer.parseInt(value1) - 1;

                    while (i > 0) {
                        num1 = num1 * i;
                        i--;
                    }

                    input.setText(num1 + "");
                    signs = null;
                    sign.setText(null);
                    break;
                case "sin":
                    value1 = input.getText().toString();
                    num1 = Double.parseDouble((value1));
                    input.setText(Math.sin(num1) + "");
                    signs = null;
                    sign.setText(null);
                    break;
                case "cos":
                    value1 = input.getText().toString();
                    num1 = Double.parseDouble((value1));
                    input.setText(Math.cos(num1) + "");
                    signs = null;
                    sign.setText(null);
                    break;
                case "tan":
                    value1 = input.getText().toString();
                    num1 = Double.parseDouble((value1));
                    input.setText(Math.tan(num1) + "");
                    signs = null;
                    sign.setText(null);
                    break;
                case "+":
                    value2 = input.getText().toString();
                    num1 = Double.parseDouble(value1);
                    num2 = Double.parseDouble(value2);
                    result = num1 + num2;
                    input.setText(result + "");
                    signs = null;
                    sign.setText(null);
                    break;
                case "-":
                    value2 = input.getText().toString();
                    num1 = Double.parseDouble(value1);
                    num2 = Double.parseDouble(value2);
                    result = num1 - num2;
                    input.setText(result + "");
                    signs = null;
                    sign.setText(null);
                    break;
                case "*":
                    value2 = input.getText().toString();
                    num1 = Double.parseDouble(value1);
                    num2 = Double.parseDouble(value2);
                    result = num1 * num2;
                    input.setText(result + "");
                    signs = null;
                    sign.setText(null);
                    break;
                case "/":
                    value2 = input.getText().toString();
                    num1 = Double.parseDouble(value1);
                    num2 = Double.parseDouble(value2);
                    result = num1 / num2;
                    input.setText(result + "");
                    signs = null;
                    sign.setText(null);
                    break;
            }

        }
    }


}
