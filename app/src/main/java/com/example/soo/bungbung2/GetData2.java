package com.example.soo.bungbung2;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by kwanwoo on 2017. 10. 17..
 */

public class GetData2 extends GetRequest {
    public GetData2(Activity activity) {
        super(activity);
    }

    @Override
    protected void onPreExecute() {
        Log.e("hi", "why");
        //EditText server =  activity.findViewById(R.id.server);
        String serverURLStr = "http://13.125.246.86:3000/api/getdata";
        try {
            url = new URL(serverURLStr);  // 여기서 AWS 주소를 넣어야 한다.
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPostExecute(String jsonString) {
        if (jsonString == null)
            return;
        ArrayList<Contents> arrayList = getArrayListFromJSONString(jsonString);
        MyAdapter adapter =new MyAdapter(activity, R.layout.adapter,arrayList);
    }



    protected ArrayList<Contents> getArrayListFromJSONString(String jsonString) {
        ArrayList<Contents> output = new ArrayList();
        try {

            JSONArray jsonArray = new JSONArray(jsonString);
            Log.e("hi", "why2");
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                Contents bung = new Contents(jsonObject.getString("_id"),
                        jsonObject.getString("x"),
                        jsonObject.getString("y")

                );
                Log.e("hi", jsonObject.getString("x"));
                if(i==jsonArray.length()-1) {


//                    startActivityForResult(intent, request_code);
                    output.add(bung);
                }
            }
        } catch (JSONException e) {
            Log.e(TAG, "Exception in processing JSONString.", e);
            e.printStackTrace();
        }
        return output;
    }
}
