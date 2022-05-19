package com.example.examen_t3_2_animes.Services;

import com.example.examen_t3_2_animes.Clases.Anime;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimeService {

    @GET("animes")
    Call<List<Anime>> allAnimes();

}
