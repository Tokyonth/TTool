package com.ttrpstudio.ttool.serverside;

import android.util.Log;

import com.google.gson.Gson;
import com.ttrpstudio.ttool.analysisjson.JsonRootBean;

import org.apache.http.NameValuePair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginPostService {

    public static Map send(List<NameValuePair> params) {

        Map map = new HashMap();
        String servlet = "LoginServlet";
        String responseMsg;
        responseMsg = AppHttpPost.executeHttpPost(servlet, params);
        Log.i("tag", "LoginService: responseMsg = " + responseMsg);
        JsonRootBean jsonRootBean = new Gson().fromJson(responseMsg, JsonRootBean.class);
        String msg = jsonRootBean.getMsg();
        String rst = jsonRootBean.getCode();
        map.put("msg",msg);
        map.put("rst",rst);

        return map;

    }

}
