package io.github.alancleetus.sacstateparking;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    private Realm realm;
    public static final String EXTRA_ORDER_TEXT = "com.alan.cleetus.github.com.EXTRA_ORDER_TEXT";
    public static final String EXTRA_LOT_TEXT = "com.alan.cleetus.github.com.EXTRA_LOT_TEXT";
    public static final String EXTRA_LOT_NUMBER_TEXT = "com.alan.cleetus.github.com.EXTRA_LOT_NUMBER_TEXT";
    public static final String EXTRA_LOT_STRUCT_TEXT = "com.alan.cleetus.github.com.EXTRA_LOT_STRUCT_TEXT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //open realm db
        Realm.init(this);
        realm = Realm.getDefaultInstance();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if (!prefs.getBoolean("firstTime", false)) {

            setUpDB();

            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();
        }

        createSpinner(R.id.highLowSpinner, R.array.highLow);
        createSpinner(R.id.lotTypeSpinner, R.array.lotType);
        createSpinner(R.id.parkingLotSpinner, R.array.parkingLot);
        createSpinner(R.id.lotStructSpinner, R.array.lotStruct);

        Button lotSearchButton = findViewById(R.id.lotSearchButton);
        lotSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLotInfoActivity();
            }
        });


        Button refinedSearchButton = findViewById(R.id.refinedSearchButton);
        refinedSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSearchResultsActivity();
            }
        });
    }

    public void createSpinner(int resID, int arrID)
    {
        Spinner spinner = findViewById(resID);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, arrID, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void openLotInfoActivity()
    {
        String lotNumberText = ((Spinner) findViewById(R.id.parkingLotSpinner)).getSelectedItem().toString();

        Intent intent = new Intent(this, LotInfoActivity.class);

        intent.putExtra(EXTRA_LOT_NUMBER_TEXT, lotNumberText);

        startActivity(intent);
    }

    public void openSearchResultsActivity()
    {
        String orderByText = ((Spinner) findViewById(R.id.highLowSpinner)).getSelectedItem().toString();
        String spotTypeText = ((Spinner) findViewById(R.id.lotTypeSpinner)).getSelectedItem().toString();
        String lotTypeText = ((Spinner) findViewById(R.id.lotStructSpinner)).getSelectedItem().toString();

        Intent intent = new Intent(this, SearchResultsActivity.class);

        intent.putExtra(EXTRA_ORDER_TEXT, orderByText);
        intent.putExtra(EXTRA_LOT_TEXT, spotTypeText);
        intent.putExtra(EXTRA_LOT_STRUCT_TEXT, lotTypeText);

        startActivity(intent);
    }


    public void setUpDB()
    {

        realm.beginTransaction();

        Log.i("logcat", "setting init data");
        ParkingStructure ps1 = realm.createObject(ParkingStructure.class, 1);
        ParkingStructure ps2 = realm.createObject(ParkingStructure.class, 2);
        ParkingStructure ps3 = realm.createObject(ParkingStructure.class, 3);

        /*parking struct 1*/
        ps1.setTotalSpots(300);
        ps1.setSpotsLeft(70);
        ps1.setStudent(14);
        ps1.setHandicap(3);
        ps1.setResident(7);
        ps1.setFaculty(32);
        ps1.setEv(5);
        ps1.setHov(9);

        ps1.setLevel1(10);
        ps1.setLevel2(20);
        ps1.setLevel3(30);
        ps1.setLevel4(5);
        ps1.setLevel5(5);

        ps1.setTrend("increasing");

        /*parking struct 2*/
        ps2.setTotalSpots(500);
        ps2.setSpotsLeft(366);
        ps2.setStudent(232);
        ps2.setHandicap(14);
        ps2.setResident(57);
        ps2.setFaculty(0);
        ps2.setEv(23);
        ps2.setHov(40);

        ps2.setLevel1(36);
        ps2.setLevel2(64);
        ps2.setLevel3(84);
        ps2.setLevel4(103);
        ps2.setLevel5(79);

        ps2.setTrend("decreasing");

        /*parking struct 3*/
        ps3.setTotalSpots(500);
        ps3.setSpotsLeft(258);
        ps3.setStudent(109);
        ps3.setHandicap(24);
        ps3.setResident(0);
        ps3.setFaculty(0);
        ps3.setEv(62);
        ps3.setHov(63);

        ps3.setLevel1(56);
        ps3.setLevel2(9);
        ps3.setLevel3(35);
        ps3.setLevel4(76);
        ps3.setLevel5(82);

        ps3.setTrend("decreasing");

        /***parking lots****/
        ParkingLot p1 = realm.createObject(ParkingLot.class, 1);
        ParkingLot p2 = realm.createObject(ParkingLot.class, 2);
        ParkingLot p3 = realm.createObject(ParkingLot.class, 3);
        ParkingLot p4 = realm.createObject(ParkingLot.class, 4);
        ParkingLot p5 = realm.createObject(ParkingLot.class, 5);
        ParkingLot p6 = realm.createObject(ParkingLot.class, 6);
        ParkingLot p7 = realm.createObject(ParkingLot.class, 7);


        /*parking lot 1*/
        p1.setTotalSpots(164);
        p1.setSpotsLeft(99);
        p1.setStudent(43);
        p1.setHandicap(12);
        p1.setResident(34);
        p1.setFaculty(0);
        p1.setEv(10);
        p1.setHov(0);
        p1.setTrend("increasing");

        /*parking lot 2*/
        p2.setTotalSpots(134);
        p2.setSpotsLeft(128);
        p2.setStudent(55);
        p2.setHandicap(3);
        p2.setResident(65);
        p2.setFaculty(0);
        p2.setEv(5);
        p2.setHov(0);
        p2.setTrend("decreasing");

        /*parking lot 3*/
        p3.setTotalSpots(186);
        p3.setSpotsLeft(72);
        p3.setStudent(19);
        p3.setHandicap(16);
        p3.setResident(0);
        p3.setFaculty(0);
        p3.setEv(3);
        p3.setHov(34);
        p3.setTrend("increasing");

        /*parking lot 4*/
        p4.setTotalSpots(197);
        p4.setSpotsLeft(159);
        p4.setStudent(67);
        p4.setHandicap(22);
        p4.setResident(0);
        p4.setFaculty(56);
        p4.setEv(14);
        p4.setHov(0);
        p4.setTrend("decreasing");

        /*parking lot 5*/
        p5.setTotalSpots(164);
        p5.setSpotsLeft(124);
        p5.setStudent(74);
        p5.setHandicap(34);
        p5.setResident(0);
        p5.setFaculty(0);
        p5.setEv(0);
        p5.setHov(16);
        p5.setTrend("decreasing");

        /*parking lot 6*/
        p6.setTotalSpots(208);
        p6.setSpotsLeft(170);
        p6.setStudent(164);
        p6.setHandicap(6);
        p6.setResident(0);
        p6.setFaculty(0);
        p6.setEv(0);
        p6.setHov(0);
        p6.setTrend("decreasing");

        /*parking lot 7*/
        p7.setTotalSpots(354);
        p7.setSpotsLeft(259);
        p7.setStudent(224);
        p7.setHandicap(35);
        p7.setResident(0);
        p7.setFaculty(0);
        p7.setEv(0);
        p7.setHov(0);
        p7.setTrend("decreasing");

        realm.commitTransaction();

    }


}
