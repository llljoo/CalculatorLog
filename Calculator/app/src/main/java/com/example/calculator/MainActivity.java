
package com.example.calculator;

import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int[] idNum = {R.id.txt0, R.id.txt1, R.id.txt2, R.id.txt3,
            R.id.txt4, R.id.txt5, R.id.txt6, R.id.txt7, R.id.txt8, R.id.txt9};  //数字Number输入
    private int[] idCal = {R.id.txtPlus, R.id.txtMinus, R.id.txtMul,
            R.id.txtDiv, R.id.txtLeft, R.id.txtRight, R.id.txtDot};  //运算符
    /*
    private int[] idCal = {R.id.txtPlus, R.id.txtMinus, R.id.txtMul,
            R.id.txtDiv, R.id.txtLeft, R.id.txtRight, R.id.txtDot, R.id.txtE,
            R.id.txtSqrt, R.id.txtSin, R.id.txtCos, R.id.txtTan};  //运算符

     */

    private Button[] buttonsNum = new Button[idNum.length];
    private Button[] buttonsCal = new Button[idCal.length];
    private Button buttonEqu;   //=等于键
    private Button buttonClear;  // AC清零键
    private Button buttonDel;  //删除键
    private EditText input ;  //输入内容显示
    private TextView output;  //输出结果显示
    private Button buttonE;   //科学计数法显示结果

    private  String Text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText)findViewById(R.id.input);
        input.setText("");
        input.setEnabled(false);

        output = (TextView) findViewById(R.id.output);
        output.setText("");

        //为等于号按钮注册监听事件，点击后将结果输出至Textview中
        buttonEqu = (Button)findViewById(R.id.txtIs);
        buttonEqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder out = new Calculate( input.getText().toString()).str;
                String outs = out.toString();
                Double d = Double.parseDouble(outs);
                DecimalFormat fm = new DecimalFormat("0.###");
                outs = fm.format(d);
                output.setText(outs );
            }
        });

        //为E键按钮注册监听事件，点击后结果显示为科学计数法
        buttonE = (Button) findViewById(R.id.txtE);
        buttonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder out = new Calculate( input.getText().toString()).str;
                String outs = out.toString();
                Double d = Double.parseDouble(outs);
                DecimalFormat fm = new DecimalFormat("0.###E0");
                outs = fm.format(d);
                output.setText(outs );
            }
        });

        //为清零按钮AC注册监听事件，点击后Textview和Editview都清零
        buttonClear = (Button) findViewById(R.id.txtClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
                output.setText("");
            }
        });

        //为删除按钮注册点击事件监听
        buttonDel = (Button) findViewById(R.id.txtDel);
        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!input.getText().toString().isEmpty() ) {
                    Text = input.getText().toString();
                    Text = Text.substring(0, Text.length() - 1);
                    input.setText(Text);
                }
            }
        });

        //为运算符按钮注册点击事件监听
        for (int idcal = 0; idcal < idCal.length; idcal++) {
            buttonsCal[idcal] = (Button) findViewById(idCal[idcal]);
            buttonsCal[idcal].setOnClickListener(new CalOnClick( buttonsCal[idcal].getText().toString()) );
        }

        //为数字按钮注册点击事件监听
        for (int idnum = 0; idnum < idNum.length; idnum++) {
            buttonsNum[idnum] = (Button) findViewById(idNum[idnum]);
            buttonsNum[idnum].setOnClickListener(new NumberOnClick( buttonsNum[idnum].getText().toString()) );
        }
    }

    //继承OnClick接口

    class CalOnClick implements View.OnClickListener{
        /*
        String Msg;
        String[] calSymbol = {"+", "-", "×", "÷", "."};
        //使用该类时需要传入一个String类型的变量，赋值给Msg做为该类中的处理对象
        public CalOnClick(String msg) {
            Msg = msg;
        }
        //继承自View.OnClickListener，必须重写onClick方法
        @Override
        public void onClick(View v) {
            Text = input.getText().toString();
            if (!output.getText().toString().equals("")) {
                Text = "";
                Msg = "";
                output.setText(Text);
            }
            //不能以运算符和点开头
            else if (Text == "") {
                for (String cur : calSymbol) {
                    if (Msg == cur || Msg == ")")
                        Msg = "";
                }
            }
            else {
                // 检查是否运算符重复输入，加、减、乘、除、点不能相连
                for (String s : calSymbol){
                    //若上一个是运算符、点，本次输入不能是运算符、点，可以是左括号、根号
                    if (Text.substring(Text.length() - 1, Text.length()) == s){
                        for (String cur : calSymbol){
                            if (Msg == cur || Msg == ")"){
                                Msg = "";
                            }
                        }
                    }
                }
            }
            Text = Text + Msg;

            //向input中加入当前输入字符
            input.setText(Text);
        }

         */
        String Msg;
        String[] calSymbol = {"+", "-", "×", "÷", "."};
        public CalOnClick(String msg) {
            Msg = msg;
        }
        @Override
        public void onClick(View v) {
            if (!output.getText().toString().equals("")) {
                input.setText("");
                output.setText("");
            }
            // 检查是否运算符重复输入
            String[] tmpText = input.getText().toString().split("");
             for (int i = 0; i < calSymbol.length; i++) {
                 if (Msg.equals(calSymbol[i])) {
                     for (int j = 0; j < calSymbol.length; j++){
                         if (tmpText[tmpText.length - 1].equals(calSymbol[j])) {
                             Msg = "";
                         }
                     }
                 }
            }
            input.append(Msg);
        }
    }

    class NumberOnClick implements View.OnClickListener {
        String Msg;
        public NumberOnClick(String msg) {
            Msg = msg;
        }

        @Override
        public void onClick(View v) {
            //Text = input.getText().toString();
            //结果框中有字符时，默认重新进行新一轮的计算
            if (!output.getText().toString().equals("")) {
                input.setText("");
                output.setText("");
            }
            //Text = Text + Msg;
            //input.setText(Text);
            input.append(Msg);
        }
    }


    //运算类，返回一个String结果
    public class Calculate {
        public  String s1;
        StringBuilder str;

        public Calculate(String m) {

             this.s1 = m;
             try {
                 eval();
             } catch (Exception e) {
                 str.delete(0, str.length());
                 str.append("ERROR");
             }

        }

        /*
         *中缀表达式转后缀表达式
         *遍历中缀的list
         *1、数字时，加入后缀list
         *2、若为‘(’时，压栈
         *3、若为')'，则依次弹栈,把弹出的运算符加入后缀表达式中，直到出现'('；
         *4、若为运算符，对做如下处置
         *   1、如果栈为空，则压栈
         *   2、如果栈不为空:
         *     1、stack.peek().equals("(")  则压栈
         *     2、比较str和stack.peek()的优先级
         *        1、如果>,则运算符压栈
         *        2、<=的情况，当栈不为空时:(这里是循环进行，直至不符合该条件)
         *           1、stack.peek()是左括号，压栈
         *           2、<=,把peek加入后缀表达式，弹栈
         *           3、>，把运算符压栈，停止对栈的操作
         *    执行完栈的操作之后，还得判断:如果栈为空,运算符压栈
         */

        //形成后缀表达式
        public List<String> getAfterList(List<String> midList) throws EmptyStackException{
            List<String> afterList = new ArrayList<String>();
            Stack<String> stack = new Stack<String>();

            for(String str : midList){
                int flag = this.flagCode(str);
                switch (flag) {
                    case 7: //flag=7代表当前字符为数字
                        afterList.add(str);
                        break;
                    case 1://当前字符为'('
                        stack.push(str);
                        break;
                    case 2://当前字符为')'
                        String pop = stack.pop();
                        while(!pop.equals("(")){
                            afterList.add(pop);
                            pop = stack.pop();
                        }
                        break;
                    default: //其他是当前字符为运算符的情况
                        if(stack.isEmpty()){ //栈为空时直接将运算符压栈
                            stack.push(str);
                            break;
                        }
                        else{ //栈不为空分多钟情况
                            if(stack.peek().equals("(")){ //栈顶为'('时直接将当前运算符压栈
                                stack.push(str);
                                break;
                            }else{ //栈顶不为'('时，需要判断栈顶运算符与当前运算符的优先级
                                int cur = this.priorityLevel(str);
                                int top = this.priorityLevel(stack.peek());
                                if(cur > top) //当前运算符优先级大于栈顶运算符优先级时，直接压栈
                                    stack.push(str);
                                //否则一直出栈，直至遇到比当前运算符优先级小的运算符或栈空或遇到'('才停止
                                else{
                                    while(!stack.isEmpty()){
                                        String out = stack.peek();
                                        if(out.equals("(")){ //pop至遇到'('，将当前运算符入栈
                                            stack.pop(); //将'('弹出
                                            stack.push(str);
                                            break;
                                        }else{
                                            if(this.priorityLevel(str) <= this.priorityLevel(out)){
                                                afterList.add(out);
                                                stack.pop();
                                            }else{ //遇到优先级更小的，将当前运算符压栈
                                                stack.push(str);
                                                break;
                                            }
                                        }
                                    }
                                    //pop至栈空，将当前运算符入栈
                                    if(stack.isEmpty())
                                        stack.push(str);
                                }
                                break;
                            }
                        }
                }
            }
            //最后还要将栈中剩下的运算符加入list后边
            while(!stack.isEmpty())
                afterList.add(stack.pop());

            StringBuffer sb = new StringBuffer();
            for(String s : afterList)
                sb.append(s + " ");

            return afterList;
        }

        //判断运算符的优先级
        public int priorityLevel(String str){
            int result = 0;
            if(str.equals("+") || str.equals("-"))
                result = 1;
            else
                result = 2;
            return result;
        }

        //设置符号的标记码
        public int flagCode(String s){
            if(s.equals("("))
                return 1;
            else if(s.equals(")"))
                return 2;
            else if(s.equals("+"))
                return 3;
            else if(s.equals("-"))
                return 4;
            else if(s.equals("×"))
                return 5;
            else if(s.equals("÷"))
                return 6;
            else
                return 7;
        }


        public Double func(Double pop2, Double pop1, String str){
            Double value = 0.0;
            if(str.equals("+"))
                value = pop2 + pop1;
            else if(str.equals("-"))
                value = pop2 - pop1;
            else if(str.equals("×"))
                value = pop2 * pop1;
            else
                value = pop2 / pop1;
            return value;
        }

        private double result;

        public double getResult() {
            return result;
        }

        public void setResult(double result) {
            this.result = result;
        }

        private int state;

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        //遇到数字就入栈，遇到运算符就弹出两个数字进运算(运算符不入栈)
        public void calculateAfterList(List<String> list){
            str = new StringBuilder("");
            state = 0;
            result = 0;
            Stack<Double> stack = new Stack<Double>();
            for(String c : list) { //list中只有数字和四种运算符
                int flag = this.flagCode(c);
                switch (flag) {
                    //3、4、5、6表示四种运算符
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        Double pop1 = stack.pop();
                        Double pop2 = stack.pop();
                        Double value = this.func(pop2, pop1, c);
                        stack.push(value);
                        break;
                    default:
                        Double push = Double.parseDouble(c);
                        stack.push(push);
                        break;
                }
            }
            if(stack.isEmpty())
                state = 1;
            else{ //栈不为空时，栈中的元素就是最后的计算结果
                result = stack.peek();
                str.append(stack.pop());
            }
        }

        public void eval() throws Exception{
            List<String> list=new ArrayList<String>();

            //匹配运算符、括号、整数、小数，注意-和*要加\\
            //\d表示数字、\.表示'.'，?表示后面为0到多次
            Pattern p = Pattern.compile("[+\\-÷×()]|\\d+\\.?\\d*");
            Matcher m = p.matcher(s1);
            while(m.find())
                list.add(m.group()); //把匹配上的字符加入list中

            List<String> afterList = this.getAfterList(list);
            this.calculateAfterList(afterList);
        }
    }
}
/*
待修复BUG
1、不允许非数字字符的连续输入，比如(.)、(2))、2+-*4等，提示ERROR不如锁定只能单次输入
2、结果为无穷小数的保留位数处理问题，一般都默认保留2位
3、第一个输入字符为'.'时自动在前面添加0
4、调试多次后会出现运算符不可用情况，点击事件无响应
5、调整输入和输出显示的内容靠左
6、美化UI界面
* */