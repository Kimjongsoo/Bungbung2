package com.example.soo.bungbung2;

import android.app.Activity;

import java.net.MalformedURLException;
import java.net.URL;


public class InsertLoginData extends PostRequest {
    public InsertLoginData(Activity activity) {
        super(activity);
    }
//로그인 데이터를 넣을 수 있게 도와준다.
    @Override
    protected void onPreExecute() {
//        EditText server = activity.findViewById(R.id.server);
//        String serverURLStr = server.getText().toString();
        String serverURLStr = "http://13.125.246.86:3000/api/register";
        try {
            url = new URL(serverURLStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


}
