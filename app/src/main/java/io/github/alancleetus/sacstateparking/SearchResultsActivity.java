package io.github.alancleetus.sacstateparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.Sort;

public class SearchResultsActivity extends AppCompatActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_results);



		Realm realm;

		Realm.init(this);
		realm = Realm.getDefaultInstance();

		Intent intent = getIntent();

		String orderBy = intent.getStringExtra(MainActivity.EXTRA_ORDER_TEXT);
		String spotType = intent.getStringExtra(MainActivity.EXTRA_LOT_TEXT);
		String lotType = intent.getStringExtra(MainActivity.EXTRA_LOT_STRUCT_TEXT);


		TextView searchTextView = findViewById(R.id.SearchTypeTextView);
		searchTextView.setText("Showing all "+ lotType+"s with "+orderBy+" number of "+spotType+" parking spots.");

		realm.beginTransaction();

		RealmQuery<ParkingStructure> query = realm.where(ParkingStructure.class);

		/*acend desc logic is reversed because i cant figure out how to add things to end of linear layout */
		query.sort((spotType.equals("any"))? "spotsLeft":spotType, (orderBy.charAt(0)=='l')? Sort.DESCENDING : Sort.ASCENDING);
		RealmResults<ParkingStructure> ps = query.findAll();

		RealmQuery<ParkingLot> query2 = realm.where(ParkingLot.class);
		/*acend desc logic is reversed because i cant figure out how to add things to end of linear layout */
		query2.sort((spotType.equals("any"))? "spotsLeft":spotType, (orderBy.charAt(0)=='l')? Sort.DESCENDING : Sort.ASCENDING);
		RealmResults<ParkingLot> pl = query2.findAll();

		realm.commitTransaction();


		LinearLayout ParentLayout = findViewById(R.id.structResultsLinearLayuout);
		String spotsText="";

		if(lotType.equalsIgnoreCase("lot")) {
			for (ParkingLot p : pl) {

				final View listItem = getLayoutInflater().inflate(R.layout.card, null);

				ParentLayout.addView(listItem, 0);

				TextView name = findViewById(R.id.nameText);
				TextView spots = findViewById(R.id.spotsLeftText);
				TextView trend = findViewById(R.id.TrendText);

				name.setText("Parking Lot " + p.getNumber());
				switch (spotType) {
					case "student":
						spotsText = "" + p.getStudent();
						break;

					case "faculty":
						spotsText = "" + p.getFaculty();
						break;

					case "resident":
						spotsText = "" + p.getResident();
						break;

					case "handicap":
						spotsText = "" + p.getHandicap();
						break;

					case "ev":
						spotsText = "" + p.getEv();
						break;

					case "hov":
						spotsText = "" + p.getHov();
						break;

					default:
						spotsText = "" + p.getSpotsLeft() + "/" + p.getTotalSpots();
				}

				spots.setText(spotType.toUpperCase() + " Spots Left: " + spotsText);
				trend.setText("Number of spots are: " + p.getTrend());
			}
		}
		else {
			for (ParkingStructure p : ps) {


				final View listItem = getLayoutInflater().inflate(R.layout.card, null);


				ParentLayout.addView(listItem, 0);

				TextView name = findViewById(R.id.nameText);
				TextView spots = findViewById(R.id.spotsLeftText);
				TextView trend = findViewById(R.id.TrendText);


				name.setText("Parking Structure " + p.getNumber());

				switch (spotType) {
					case "student":
						spotsText = "" + p.getStudent();
						break;

					case "faculty":
						spotsText = "" + p.getFaculty();
						break;

					case "resident":
						spotsText = "" + p.getResident();
						break;

					case "handicap":
						spotsText = "" + p.getHandicap();
						break;

					case "ev":
						spotsText = "" + p.getEv();
						break;

					case "hov":
						spotsText = "" + p.getHov();
						break;

					default:
						spotsText = "" + p.getSpotsLeft() + "/" + p.getTotalSpots();
				}

				spots.setText(spotType.toUpperCase() + " Spots Left: " + spotsText);


				trend.setText("Number of spots are: " + p.getTrend());


			}
		}



	}
}
