package ru.solar.sportsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SportClickListener{
    RecyclerView recyclerView;
    List<Sport> sportsList;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView =findViewById(R.id.recyclerView);
        sportsList = new ArrayList<>();

        Sport sport1 = new Sport(R.drawable.football,"Football");
        Sport sport2 = new Sport(R.drawable.basketball,"Basketball");
        Sport sport3 = new Sport(R.drawable.ping,"Ping-pong");
        Sport sport4 = new Sport(R.drawable.tennis,"Tennis");
        Sport sport5 = new Sport(R.drawable.volley,"Volleyball");

        sportsList.add(sport1);
        sportsList.add(sport2);
        sportsList.add(sport3);
        sportsList.add(sport4);
        sportsList.add(sport5);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        customAdapter = new CustomAdapter(sportsList);
        recyclerView.setAdapter(customAdapter);

        customAdapter.setClickListener(this);
    }

    @Override
    public void onClick(View v, int position) {
        Toast.makeText(this, "Your sport: " + sportsList.get(position).getSportName(), Toast.LENGTH_SHORT).show();
    }
}