package eu.jnksoftware.discountfinderandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        ListView myListView=(ListView)findViewById(R.id.myListView);
        //initialize listOfShops with a fake list
        ArrayList<String> fakeList=new ArrayList<>(asList("Adidas","Sports","Nike Sports","Admiral"));

        final ArrayList<String> listOfShops=fakeList;



        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listOfShops);

        myListView.setAdapter(arrayAdapter);

    }
}
