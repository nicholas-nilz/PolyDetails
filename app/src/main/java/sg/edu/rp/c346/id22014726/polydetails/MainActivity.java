package sg.edu.rp.c346.id22014726.polydetails;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    AsyncHttpClient client;
    ArrayList<Study> alStudy;
    ArrayAdapter<Study> aaStudy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        client = new AsyncHttpClient();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<Study> alStudy = new ArrayList<Study>();

        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=fdd36db3-3317-4790-8c27-8e58f7dd1a42", new JsonHttpResponseHandler() {
            String type;
            String enrolment;
            String year;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONObject jsonStudy = response.getJSONObject("result");
                    JSONArray jsonArrStudy = jsonStudy.getJSONArray("records");
                    for (int i = 0; i < jsonArrStudy.length(); i++) {
                        JSONObject jsonObjStudy = jsonArrStudy.getJSONObject(i);
                        type = jsonObjStudy.getString("type_of_study");
                        enrolment = jsonObjStudy.getString("enrolment");
                        year = jsonObjStudy.getString("year");
                        Study study = new Study(type, enrolment, year);
                        alStudy.add(study);
                    }
                }
                catch(JSONException e) {
                }
                aaStudy = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, alStudy);
                lv.setAdapter(aaStudy);

            }
        });
    }
}


