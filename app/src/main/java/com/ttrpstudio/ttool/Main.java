package com.ttrpstudio.ttool;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dx.dxloadingbutton.lib.LoadingButton;
import com.ttrpstudio.ttool.act.AppMain;

/**
 * Created by TOKYONTH on 2018/4/22/022.
 */

public class Main extends AppCompatActivity {

    private LoadingButton loadbbtn;
    private TextView tv_noaccount;
    private EditText main_account;
    private EditText main_password;
    private CheckBox manin_cb;

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
                main_password.setEnabled(false);
                main_account.setEnabled(false);
                manin_cb.setEnabled(false);
                loadbbtn.startLoading();
                String acc  = main_account.getText().toString();
                String pwd = main_password.getText().toString();
                if (acc.equals("admin") && pwd.equals("ttrp")) {
                    Complete();
                }
                else {
                    loadbbtn.loadingFailed();
                    main_password.setEnabled(true);
                    main_account.setEnabled(true);
                    manin_cb.setEnabled(true);
                }
            }
        });
        tv_noaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register();
            }
        });
    }

    private void Complete() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadbbtn.loadingSuccessful();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent();
                        intent.setClass(Main.this,AppMain.class);
                        intent.putExtra("Verification",true);
                        startActivity(intent);
                        finish();
                    }
                },1000);
            }
        },2000);
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
