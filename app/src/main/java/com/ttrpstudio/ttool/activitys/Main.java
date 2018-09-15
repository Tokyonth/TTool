package com.ttrpstudio.ttool.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dx.dxloadingbutton.lib.LoadingButton;
import com.ttrpstudio.ttool.R;
import com.ttrpstudio.ttool.serverside.LoginPostService;
import com.ttrpstudio.ttool.serverside.NetworkTool;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by TOKYONTH on 2018/4/22/022.
 */

/**
 * 账户即为E-mail地址
 */

public class Main extends AppCompatActivity {

    private LoadingButton loadbbtn;
    private TextView tv_noaccount;
    private EditText main_account;
    private EditText main_password;
    private CheckBox manin_cb;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(null);
        initView();
        inClick();
    }

    private void  initView() {
        loadbbtn = (LoadingButton) findViewById(R.id.btn_login);
        tv_noaccount = (TextView) findViewById(R.id.tv_noacc);
        main_account = (EditText) findViewById(R.id.act_main_et_account);
        main_password = (EditText) findViewById(R.id.act_main_et_password);
        manin_cb = (CheckBox) findViewById(R.id.act_main_cb);
    }

    private void inClick() {
        loadbbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String acc = main_account.getText().toString().trim();
                String pwd = main_password.getText().toString().trim();

                if (NetworkTool.isConnectingToInternet(Main.this)) {
                    if (acc.equals("") && pwd.equals("")) {
                        main_password.setEnabled(false);
                        main_account.setEnabled(false);
                        manin_cb.setEnabled(false);
                        loadbbtn.startLoading();
                        Toast.makeText(Main.this, "请输入账号和密码!", Toast.LENGTH_SHORT).show();
                    } else {
                        new LoginPostThread(acc, pwd).start();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "网络未连接!", Toast.LENGTH_SHORT).show();
                }

                handler = new Handler() {
                    public void handleMessage(Message msg) {
                        super.handleMessage(msg);
                        if (msg.what == 111) {
                            if (msg.obj.toString().equals("SUCCEEDED")) {
                                loadbbtn.loadingSuccessful();
                                Intent intent = new Intent();
                                intent.setClass(Main.this,AppMain.class);
                                intent.putExtra("Verification",true);
                                startActivity(intent);
                                finish();
                            } else {
                                loadbbtn.loadingFailed();
                                Toast.makeText(Main.this, "账号或密码不正确！", Toast.LENGTH_SHORT).show();
                                main_password.setEnabled(true);
                                main_account.setEnabled(true);
                                manin_cb.setEnabled(true);
                            }
                        }
                    }
                };

            }
        });

        tv_noaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });
    }

    public class LoginPostThread extends Thread {

        public String email;
        public String pwd;

        public LoginPostThread(String email, String pwd) {
            this.email = email;
            this.pwd = pwd;
        }

        @Override
        public void run() {
            if(!email.equals("")) {
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("email", email));
                params.add(new BasicNameValuePair("pwd", pwd));
                Map<String, String> map = LoginPostService.send(params);
                String fwmsg = map.get("msg");
                String fwcode = map.get("rst");
                Log.i("tag", "LoginActivity: 返回内容 :" + fwmsg + "," + fwcode);
                Message msg = handler.obtainMessage();
                msg.what = 111;
                if(fwcode.equals("121")) {
                    msg.obj = "FAILED";
                }else if(fwcode.equals("120")) {
                    msg.obj = "SUCCEEDED";
                }
                handler.sendMessage(msg);
            }
        }
    }

    private void Register() {
        Toast.makeText(getApplication(),"注册",Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_exit) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
