package com.example.gk_babic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Profile> image_details = getListData();
        final ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(new CustomListAdapter(this, image_details));

        final Intent intent = new Intent(this, MapsActivity.class);
        intent.setAction(Intent.ACTION_SEND);
        // When the user clicks on the ListItem
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                Profile profile = (Profile) o;
                Toast.makeText(MainActivity.this, "Du hast : " + "\"" + profile.getAdress() + "\" angestupst", Toast.LENGTH_LONG).show();
                intent.putExtra("profileAdress", profile.getAdress());
                startActivity(intent);
                //startNewActivity(profile);
            }
        });
    }

    private  List<Profile> getListData() {
        List<Profile> list = new ArrayList<Profile>();
        Profile franceska = new Profile("Francesca Butja", "franceska", "Wexstraße 19-23, 1200 Wien");
        Profile justine = new Profile("Justine Embryo", "justine", "Theresianumgasse 25, 1040 Wien");
        Profile jonathan = new Profile("Jonathan Franks", "jonathan", "Magdalenenstraße 2, 1060 Wien");

        Profile benjamin = new Profile("Benjamin Blümchen", "benjamin", "Fritz-Grünbaum-Platz 1, 1060 Wien");
        Profile frank = new Profile("Frank Berenstein", "frank", "Herrengasse 14, 1010 Wien");
        Profile silvia = new Profile("Silvie Gruber", "silvia", "Wagramer Str. 147, 1220 Wien");


        list.add(franceska);
        list.add(justine);
        list.add(jonathan);

        list.add(benjamin);
        list.add(frank);
        list.add(silvia);

        return list;
    }

    /*
    public void startNewActivity(Profile profile){
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("adresse", profile.getAdress());
        startActivity(intent);
    }
    */
}