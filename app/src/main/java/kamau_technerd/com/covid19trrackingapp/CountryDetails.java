package kamau_technerd.com.covid19trrackingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class CountryDetails extends AppCompatActivity {

    AdView adView1;

    private int positionCountry;

    TextView tvCountry, tvCases,tvRecovered,tvcritical, tvActive, tvTodayCases, tvDeaths, tvTodayDeaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);
        Intent intent = getIntent();
        positionCountry = intent.getIntExtra("position",0);

        tvCountry = findViewById(R.id.tvCountryDetails1);
        tvCases = findViewById(R.id.tvCasesDetails1);
        tvRecovered = findViewById(R.id.tvRecoveredDetails1);
        tvcritical = findViewById(R.id.tvCriticalDetails1);
        tvActive = findViewById(R.id.tvActiveDetails1);
        tvTodayCases = findViewById(R.id.tvTodayCasesDetails1);
        tvDeaths = findViewById(R.id.tvDeathsDetails1);
        tvTodayDeaths = findViewById(R.id.tvTodayDeathsDetails1);

        getSupportActionBar().setTitle("Covid 19  Stats of"+ AffectedCountries.countryModelsList.get(positionCountry).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tvCountry.setText(AffectedCountries.countryModelsList.get(positionCountry).getCountry());
        tvCases.setText(AffectedCountries.countryModelsList.get(positionCountry).getCases());
        tvRecovered.setText(AffectedCountries.countryModelsList.get(positionCountry).getRecovered());
        tvcritical.setText(AffectedCountries.countryModelsList.get(positionCountry).getCritical());
        tvActive.setText(AffectedCountries.countryModelsList.get(positionCountry).getActive());
        tvTodayCases.setText(AffectedCountries.countryModelsList.get(positionCountry).getTodayCases());
        tvDeaths.setText(AffectedCountries.countryModelsList.get(positionCountry).getDeaths());
        tvTodayDeaths.setText(AffectedCountries.countryModelsList.get(positionCountry).getTodayDeaths());


        adView1 = findViewById(R.id.adView1);
        MobileAds.initialize(this,/*"ca-app-pub-5908187176288934~2886112742");*/ new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        adView1.loadAd(adRequest);
    }
}
