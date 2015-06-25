package com.octo.nmo.autojackson;

import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new AsyncTask<Void, Void, Json>() {

            @Override
            protected Json doInBackground(Void... params) {
                final ObjectMapper objectMapper = new ObjectMapper();
                try {
                    final InputStream inputStream = getResources().openRawResource(R.raw.test);
                    final Json json = objectMapper.readValue(inputStream, Json.class);
                    // filtering simple list
                    final Iterator<Item> itemIterator = json.list().iterator();
                    while (itemIterator.hasNext()){
                        final Item item = itemIterator.next();
                        if(item.type() == null){
                            itemIterator.remove();
                        }
                    }
                    // filtering complex list
                    final Iterator<Social> socialIterator = json.socialList().iterator();
                    while (socialIterator.hasNext()){
                        final Social social = socialIterator.next();
                        if(social instanceof NullSocial){
                            socialIterator.remove();
                        }
                    }
                    Log.d(TAG, objectMapper.writeValueAsString(json));
                    return json;
                } catch (IOException e) {
                    Log.e(TAG, "can not read json", e);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Json json) {
                if (json != null) {
                    Log.d(TAG, json.toString());
                    Log.d(TAG, json.list().toString());
                    setTitle(json.simple().title());
                    for(final Item item : json.list()){
                        Log.d(TAG, item.toString());
                    }
                    for(final Social social : json.socialList()){
                        Log.d(TAG, social.toString());
                    }
                }
            }
        }.execute((Void[]) null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
