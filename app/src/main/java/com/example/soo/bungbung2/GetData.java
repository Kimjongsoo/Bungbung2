package com.example.soo.bungbung2;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;



public class GetData extends GetRequest {
    public GetData(Activity activity) {
        super(activity);
    }

    @Override
    protected void onPreExecute() {
        Log.e("hi", "why");
        //EditText server =  activity.findViewById(R.id.server);
        String serverURLStr = "http://13.125.246.86:3000/api/getdata";
        try {
            url = new URL(serverURLStr);  // 여기서 AWS 주소및 경로를 넣어야 한다.
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPostExecute(String jsonString) {
        if (jsonString == null)
            return;
        ArrayList<Contents> arrayList = getArrayListFromJSONString(jsonString);

//        ArrayAdapter adapter = new ArrayAdapter(activity,
//                android.R.layout.simple_list_item_1,
//                arrayList.toArray());
        Log.e("hi", "why1");
//        View header;
//        header= activity.getLayoutInflater().inflate(R.layout.activity_rent,null,false);
        MyAdapter adapter =new MyAdapter(activity, R.layout.adapter,arrayList);//데이터 베이스의 데이터를 받아서 Myadapter의 형식으로 출력해준다.
        ListView txtList = activity.findViewById(R.id.listview);
        txtList.setAdapter(adapter);
        txtList.setDividerHeight(10);
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
//json형식의 위도경도값인 x,y를 받아온다
);
                Log.e("hi", jsonObject.getString("x"));
                if(i==jsonArray.length()-1) {
//가장 마지막 값을 가져와 넣어준다.

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
