package com.example.examen_t3_2_animes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.examen_t3_2_animes.Adapters.AnimeAdapter;
import com.example.examen_t3_2_animes.Clases.Anime;
import com.example.examen_t3_2_animes.Services.AnimeService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv =findViewById(R.id.rvLista);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://epiquien.free.beeceptor.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AnimeService service =retrofit.create(AnimeService.class);

        service.allAnimes().enqueue(new Callback<List<Anime>>() {
            @Override
            public void onResponse(Call<List<Anime>> call, Response<List<Anime>> response) {
                Log.i("MAIN_APP", response.body().toString());
                AnimeAdapter adapter = new AnimeAdapter(response.body());
                rv.setAdapter(adapter);

                Log.i("MAIN_APP", "Llamado a la clase ");

            }

            @Override
            public void onFailure(Call<List<Anime>> call, Throwable t) {

            }
        });


       // List<Anime> animes =GetAnimes();
    }

//    private  List<Anime> GetAnimes()
//    {
//        List<Anime> animes = new ArrayList<>();
//
//        //animes.add(new Anime("null", "null", "null", R.drawable.estrellablanca));
//        return animes;
//    }

}