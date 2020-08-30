package kamau_technerd.com.covid19trrackingapp;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class KenyanStats extends Fragment {
    AdView adView2;

    TextView tvCases1, tvRecovered1, tvCritical1, tvActive1,
            tvTodayCases1, tvTodayDeaths1, tvTotalDeaths1, tvTotalTest1;
    ScrollView scrollView;
    Button btmTrack;
    SimpleArcLoader simpleArcLoader;
    PieChart pieChat1;
    View view;


    public KenyanStats() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_kenyan_stats, container, false);
        /*tvCases = (TextView) view.findViewById(R.id.tvcases);
        tvRecovered = (TextView) view.findViewById(R.id.tvRecovered);
        tvCritical = (TextView) view.findViewById(R.id.tvCritical);
        tvActive = (TextView) view.findViewById(R.id.tvActive);
        tvTodayCases = (TextView) view.findViewById(R.id.tvTodayCases);
        tvTodayDeaths = (TextView) view.findViewById(R.id.tvTodayDeaths);
        tvTotalDeaths = (TextView) view.findViewById(R.id.tvTotalDeaths);
        tvAffectedCountries = (TextView) view.findViewById(R.id.tvAffectedCountries);

        scrollView = view.findViewById(R.id.scrollStats);
        simpleArcLoader = view.findViewById(R.id.loader);
        pieChat = view.findViewById(R.id.piechart);
        adView = view.findViewById(R.id.adView);
        btmTrack = view.findViewById(R.id.btnTrack);

        btmTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AffectedCountries.class);
                startActivity(intent);
                return;

            }
        });



        fetchData();

        MobileAds.initialize(getActivity(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);*/


        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tvCases1 = (TextView) view.findViewById(R.id.tvcases1);
        tvRecovered1 = (TextView) view.findViewById(R.id.tvRecovered1);
        tvCritical1 = (TextView) view.findViewById(R.id.tvCritical1);
        tvActive1 = (TextView) view.findViewById(R.id.tvActive1);
        tvTodayCases1 = (TextView) view.findViewById(R.id.tvTodayCases1);
        tvTodayDeaths1 = (TextView) view.findViewById(R.id.tvTodayDeaths1);
        tvTotalDeaths1 = (TextView) view.findViewById(R.id.tvTotalDeaths1);
        tvTotalTest1 = (TextView) view.findViewById(R.id.tvTotalTest1);

        scrollView = view.findViewById(R.id.scrollStats1);
        simpleArcLoader = view.findViewById(R.id.loader1);
        pieChat1 = view.findViewById(R.id.piechart1);
        adView2 = view.findViewById(R.id.adView2);

        fetchData();

        MobileAds.initialize(getActivity(),/*"ca-app-pub-5908187176288934~2886112742");*/ new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        adView2.loadAd(adRequest);

    }
    private void fetchData() {
        String url = "https://corona.lmao.ninja/v3/covid-19/countries/kenya/";
        simpleArcLoader.start();

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.toString());

                    tvCases1.setText(jsonObject.getString("cases"));
                    tvRecovered1.setText(jsonObject.getString("recovered"));
                    tvCritical1.setText(jsonObject.getString("critical"));
                    tvActive1.setText(jsonObject.getString("active"));
                    tvTodayCases1.setText(jsonObject.getString("todayCases"));
                    tvTodayDeaths1.setText(jsonObject.getString("todayDeaths"));
                    tvTotalDeaths1.setText(jsonObject.getString("deaths"));
                    tvTotalTest1.setText(jsonObject.getString("tests"));

                    pieChat1.addPieSlice(new PieModel("Cases", Integer.parseInt(tvCases1.getText().toString()), Color.parseColor("#FFA726")));
                    pieChat1.addPieSlice(new PieModel("Recovered", Integer.parseInt(tvRecovered1.getText().toString()), Color.parseColor("#66BB6A")));
                    pieChat1.addPieSlice(new PieModel("Deaths", Integer.parseInt(tvTotalDeaths1.getText().toString()), Color.parseColor("#EF5350")));
                    pieChat1.addPieSlice(new PieModel("Active", Integer.parseInt(tvActive1.getText().toString()), Color.parseColor("#2986F6")));

                    simpleArcLoader.stop();
                    simpleArcLoader.setVisibility(View.GONE);
                    scrollView.setVisibility(View.VISIBLE);


                } catch (JSONException e) {
                    e.printStackTrace();
                    simpleArcLoader.stop();
                    simpleArcLoader.setVisibility(View.GONE);
                    scrollView.setVisibility(View.VISIBLE);
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                simpleArcLoader.stop();
                simpleArcLoader.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(request);
    }
}
