package com.ttrpstudio.ttool.act;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hitomi.cslibrary.CrazyShadow;
import com.hitomi.cslibrary.base.CrazyShadowDirection;
import com.mancj.materialsearchbar.MaterialSearchBar;
import com.ttrpstudio.ttool.R;
import com.ttrpstudio.ttool.phoneinfo.PhoneMsg;

/**
 * Created by TOKYONTH on 2018/4/22/022.
 */

public class AppMain extends AppCompatActivity implements View.OnClickListener,MaterialSearchBar.OnSearchActionListener{

    private Button btn_setup;
    private Button btn_scan;
    private TextView tv_model;
    private TextView tv_android_ver;
    private TextView tv_android_api;
    private CardView card_app;
    private CardView card_msg;
    private CardView card_reboot;
    private CardView card_sys;
    private MaterialSearchBar md_search_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
        Intent intent = getIntent();
        Boolean Verification_bool = intent.getBooleanExtra("Verification",false);
        if (Verification_bool = false)
            this.finish();
        Toolbar toolbar = (Toolbar) findViewById(R.id.apptoolbar);
        setSupportActionBar(toolbar);
        setTitle(null);
        initView();
    }

    private void initView() {
        tv_model = (TextView) findViewById(R.id.tv_model);
        tv_android_ver = (TextView) findViewById(R.id.tv_android_ver);
        tv_android_api = (TextView) findViewById(R.id.tv_android_api);
        card_app = (CardView) findViewById(R.id.card_app);
        card_msg = (CardView) findViewById(R.id.card_msg);
        card_reboot = (CardView) findViewById(R.id.card_reboot);
        card_sys = (CardView) findViewById(R.id.card_sys);
        btn_setup = (Button) findViewById(R.id.btn_setup);
        btn_scan = (Button) findViewById(R.id.btn_scan);
        md_search_bar = (MaterialSearchBar) findViewById(R.id.md_search_bar);

        card_sys.setOnClickListener(this);
        card_reboot.setOnClickListener(this);
        card_msg.setOnClickListener(this);
        card_app.setOnClickListener(this);
        btn_setup.setOnClickListener(this);
        btn_scan.setOnClickListener(this);
        tv_model.setText(PhoneMsg.model());

        new CrazyShadow.Builder()
                .setContext(this)
                .setDirection(CrazyShadowDirection.ALL)
                .setShadowRadius(Dip2px(4))
                .setCorner(Dip2px(6))
                .setImpl(CrazyShadow.IMPL_DRAW)
                .action(findViewById(R.id.md_search_bar));

    }

    private int Dip2px(float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @Override
    public void onSearchStateChanged(boolean enabled) {

    }

    @Override
    public void onSearchConfirmed(CharSequence text) {

    }

    @Override
    public void onButtonClicked(int btCode) {
        switch (btCode){
            case MaterialSearchBar.BUTTON_NAVIGATION:

                break;
            case MaterialSearchBar.BUTTON_SPEECH:
                md_search_bar.clearSuggestions();
                break;
            case MaterialSearchBar.BUTTON_BACK:
                md_search_bar.disableSearch();
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_setup:
                Toast.makeText(this,"Tset0",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_scan:
                Toast.makeText(this,"Tset1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.card_app:
                Toast.makeText(this,"Tset2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.card_msg:
                Toast.makeText(this,"Tset3",Toast.LENGTH_SHORT).show();
                break;
            case R.id.card_sys:
                Toast.makeText(this,"Tset4",Toast.LENGTH_SHORT).show();
                break;
            case R.id.card_reboot:
                Toast.makeText(this,"Tset5",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_app, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
