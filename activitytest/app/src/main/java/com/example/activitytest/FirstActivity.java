package com.example.activitytest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        //得到button1的实例，通过findViewById()方法获取到布局文件R中定义的元素，该方法返回一个View对象，向下转型成Button对象
        Button button1 = (Button) findViewById((R.id.button_1));
        //为按钮注册一个监听器，点击按钮时执行监听器中的onClick方法，这里重写了onClick方法
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                /*
                //Toast是友好的提醒方式，通过静态方法makeText()创建一个Toast对象，并调用它的show()方法
                Toast.makeText(FirstActivity.this, "You clicked Button 1",
                        Toast.LENGTH_SHORT).show();
                 */
                /*
                //构建一个“意图”，在FirstActivity这个活动的基础上打开SecondActivity这个活动
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
                 */

                //Intent intent = new Intent("com.example.activitytest.ACTION_START");
                //intent.addCategory("com.example.activitytest.MY_CATEGORY");

                /*
                //Uri.parse()方法将一个网址字符串解析成一个Uri对象，再调用setData()将该Uri对象传入intent中
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
                 */
                /*
                //向下一个活动传递数据，这里传递一个字符串，显示Intent的方式启动SecondActivity
                String data = "Hello SecondActivity";
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("extra_data", data);
                startActivity(intent);
                 */
                //实现返回数据给上一个活动
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1); //1是请求码

            }
        });

        Log.d("FirstActivity", "onCreate execute");
    }

    //由于使用startActivityForResult()方法启动SecondActivity，在其被销毁后会回调上一个活动的onActivityResult()方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                if(requestCode == RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnedData);
                }
                break;
            default:
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //通过getMenuInflater()方法得到MenuInflater对象，再调用inflate()方法给当前活动创建菜单
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
        default:
        }
        return true;
    }
}
