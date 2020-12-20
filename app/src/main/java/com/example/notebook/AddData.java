package com.example.notebook;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.notebook.dbutil.UtilDao;

/**
 * Created by lenovo on 2018/10/14.
 */

public class AddData extends AppCompatActivity {
    private EditText edit_name,edit_phone;
   // private Button but;
    private UtilDao dao;
    private Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddata);
        //初始化组件
        initWidget();
        DbUtil();

        /**
         * 点击编辑按钮传过来的值
         * 用于显示当前编辑项的数据信息
         * */
        intent = getIntent();
        String user_name = intent.getStringExtra("edit_name");
        String user_phone = intent.getStringExtra("edit_phone");
        edit_name.setText(user_name);
        edit_phone.setText(user_phone);

//        but.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //获取到两个输入框的值
//                    String name = edit_name.getText().toString();
//                    String phone = edit_phone.getText().toString();
//                    if(!name.equals("") && !phone.equals("")){
//                        /**
//                         * 数据库操作需要用到的数据
//                         * 详情请查看 UtilDao 类下的 addData() 方法
//                         * */
//                        String[] key = {"userName","userPhone"};
//                        String[] values = {name,phone};
//                        intent = new Intent();
//                        //点击添加按钮则返回 key 和 values 数组
//                        intent.putExtra("key",key);
//                        intent.putExtra("values",values);
//                        //点击编辑按钮则返回 name 和 phone 字符串
//                        intent.putExtra("name",name);
//                        intent.putExtra("phone",phone);
//
//                        setResult(RESULT_OK,intent);
//                        finish();
//                    } else if(name.equals("") || phone.equals("")){
//                        finish();
//                    }
//            }
//        });
    }
    /**
     actionbar
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.undo:
                Toast.makeText(this, "你点击了“撤回”按键！", Toast.LENGTH_SHORT).show();

                return true;
            case R.id.redo:
                Toast.makeText(this, "你点击了“发布”按键！", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.done:
                //获取到两个输入框的值
                String name = edit_name.getText().toString();
                String phone = edit_phone.getText().toString();
                if(!name.equals("") && !phone.equals("")){
                    /**
                     * 数据库操作需要用到的数据
                     * 详情请查看 UtilDao 类下的 addData() 方法
                     * */
                    String[] key = {"userName","userPhone"};
                    String[] values = {name,phone};
                    intent = new Intent();
                    //点击添加按钮则返回 key 和 values 数组
                    intent.putExtra("key",key);
                    intent.putExtra("values",values);
                    //点击编辑按钮则返回 name 和 phone 字符串
                    intent.putExtra("name",name);
                    intent.putExtra("phone",phone);

                    setResult(RESULT_OK,intent);
                    finish();
                } else if(name.equals("") || phone.equals("")){
                    finish();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * 初始化控件
     * */
    private void initWidget(){
        edit_name = findViewById(R.id.add_edit_name);
        edit_phone = findViewById(R.id.add_edit_phone);
        //but = findViewById(R.id.add_but);
    }

    public void DbUtil(){
        dao = ((com.example.notebook.MyApplication)this.getApplication()).getDao();
    }

}
