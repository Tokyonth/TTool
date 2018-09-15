package com.ttrpstudio.ttool.serverside;

import android.util.Log;
import org.apache.http.NameValuePair;
import java.util.List;

public class RegisterPostService {

    static int LOGIN_FAILED = 0;
    static int LOGIN_SUCCEEDED = 1;
    static int Register_FAILED = 2;
    static int Register_SUCCEEDED = 3;

    public static int send(List<NameValuePair> params) {
        // 返回值
        int responseInt = Register_FAILED;
        // 定位服务器的Servlet
        String servlet = "RegistServlet";
        // 通过 POST 方式获取 HTTP 服务器数据
        String responseMsg;
        responseMsg = AppHttpPost.executeHttpPost(servlet, params);
        Log.i("tag", "RegisterService: responseMsg = " + responseMsg);
        // 解析服务器数据，返回相应 Long 值
        if(responseMsg.equals("SUCCEEDED")) {
            responseInt = Register_SUCCEEDED;
        }
        return responseInt;
    }
}
