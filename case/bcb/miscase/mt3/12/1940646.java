package org.newgenlib.carbon;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Search extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        ArrayList al = loadIndexes();
        System.out.println(al);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        final EditText editText = (EditText) findViewById(R.id.editText1);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, al);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_item);
        System.out.println(spinner);
        System.out.println(aa);
        spinner.setAdapter(aa);
        Button btn1 = (Button) findViewById(R.id.button1);
        btn1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Intent myIntent = new Intent(Search.this, Results.class);
                myIntent.putExtra("Text", editText.getText().toString());
                myIntent.putExtra("Index", spinner.getSelectedItem().toString());
                Search.this.startActivity(myIntent);
            }
        });
    }

    public ArrayList loadIndexes() {
        JSONObject job = new JSONObject();
        ArrayList al = new ArrayList();
        try {
            String req = job.put("OperationId", "1").toString();
            InputStream is = null;
            String result = "";
            JSONObject jArray = null;
            try {
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("http://192.168.1.4:8080/newgenlibctxt/CarbonServlet");
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
                nameValuePairs.add(new BasicNameValuePair("OperationId", "1"));
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                HttpResponse response = httpclient.execute(httppost);
                HttpEntity entity = response.getEntity();
                is = entity.getContent();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                is.close();
                result = sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                JSONObject jobres = new JSONObject(result);
                JSONArray jarr = jobres.getJSONArray("MobileIndexes");
                for (int i = 0; i < jarr.length(); i++) {
                    String indexname = jarr.getString(i);
                    al.add(indexname);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return al;
    }
}
