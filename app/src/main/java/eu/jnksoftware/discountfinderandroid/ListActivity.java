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
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //static latitude and longitude
                Double Latitude = 41.0883467;
                Double Longitude = 23.5500933;
                String labelLocation = "ShopName";
                Intent intent=new Intent(Intent.ACTION_VIEW);

                intent.setData(Uri.parse("geo:<" + Latitude  + ">,<" + Longitude + ">?q=<" + Latitude  + ">,<" + Longitude + ">(" + labelLocation+ ")"));

                //if user has not the application googleMaps it will show him a dialog with Launch Maps
                Intent chooser=Intent.createChooser(intent,"Launch Maps");
                startActivity(chooser);
            }
        });
    }
}
