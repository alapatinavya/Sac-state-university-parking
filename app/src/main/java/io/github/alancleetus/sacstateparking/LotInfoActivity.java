package io.github.alancleetus.sacstateparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

import static java.lang.Integer.parseInt;

public class LotInfoActivity extends AppCompatActivity {

	private Realm realm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lot_info);

		Realm.init(this);
		realm = Realm.getDefaultInstance();

		Intent intent = getIntent();
		String lotName = intent.getStringExtra(MainActivity.EXTRA_LOT_NUMBER_TEXT);

		int lotNumber = Integer.parseInt(""+lotName.charAt(lotName.length()-1));

		if(lotName.charAt(0) == 'S')
		{

			realm.beginTransaction();

			RealmQuery<ParkingStructure> query = realm.where(ParkingStructure.class);

			query.equalTo("number", lotNumber);

			ParkingStructure ps = query.findFirst();

			realm.commitTransaction();

			TextView name = findViewById(R.id.LotName);
			name.setText("Parking Structure "+ ps.getNumber());

			TextView total = findViewById(R.id.SpotsLeftTextView);
			total.setText("Total Spots Left: "+ ps.getSpotsLeft()+"/"+ps.getTotalSpots());

			TextView trend = findViewById(R.id.trendTextView);
			trend.setText("Number of spots are: "+ ps.getTrend());

			TextView student = findViewById(R.id.studentTV);
			student.setText("Student: "+ ps.getStudent());

			TextView handicap = findViewById(R.id.handicapTV);
			handicap.setText("Handicap: "+ ps.getHandicap());

			TextView resident = findViewById(R.id.residentTV);
			resident.setText("Resident: "+ ps.getResident());

			TextView faculty = findViewById(R.id.facultyTV);
			faculty.setText("Faculty: "+ ps.getFaculty());

			TextView ev = findViewById(R.id.evTV);
			ev.setText("EV: "+ ps.getEv());

			TextView hov = findViewById(R.id.hovTV);
			hov.setText("HOV: "+ ps.getHov());

			TextView l1 = findViewById(R.id.l1tv);
			l1.setText("Level 1: "+ ps.getLevel1());

			TextView l2 = findViewById(R.id.l2tv);
			l2.setText("Level 2: "+ ps.getLevel2());

			TextView l3 = findViewById(R.id.l3tv);
			l3.setText("Level 3: "+ ps.getLevel3());

			TextView l4 = findViewById(R.id.l4tv);
			l4.setText("Level 4: "+ ps.getLevel4());

			TextView l5 = findViewById(R.id.l5tv);
			l5.setText("Level 5: "+ ps.getLevel5());


			LinearLayout levelList = findViewById(R.id.levelsList);
			levelList.setVisibility(View.VISIBLE);
		}
		else
		{

			realm.beginTransaction();

			RealmQuery<ParkingLot> query = realm.where(ParkingLot.class);

			query.equalTo("number", lotNumber);

			ParkingLot ps = query.findFirst();

			realm.commitTransaction();

			TextView name = findViewById(R.id.LotName);
			name.setText("Parking Lot "+ ps.getNumber());

			TextView total = findViewById(R.id.SpotsLeftTextView);
			total.setText("Total Spots Left: "+ ps.getSpotsLeft()+"/"+ps.getTotalSpots());

			TextView trend = findViewById(R.id.trendTextView);
			trend.setText("Number of spots are: "+ ps.getTrend());

			TextView student = findViewById(R.id.studentTV);
			student.setText("Student: "+ ps.getStudent());

			TextView handicap = findViewById(R.id.handicapTV);
			handicap.setText("Handicap: "+ ps.getHandicap());

			TextView resident = findViewById(R.id.residentTV);
			resident.setText("Resident: "+ ps.getResident());

			TextView faculty = findViewById(R.id.facultyTV);
			faculty.setText("Faculty: "+ ps.getFaculty());

			TextView ev = findViewById(R.id.evTV);
			ev.setText("EV: "+ ps.getEv());

			TextView hov = findViewById(R.id.hovTV);
			hov.setText("HOV: "+ ps.getHov());

			LinearLayout levelList = findViewById(R.id.levelsList);
			levelList.setVisibility(View.INVISIBLE);

		}


	}
}
