package com.eversoft.api;

import com.eversoft.entities.Itinerary;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiItineraryService {
    @GET("itinerary/getall")
    Call<List<Itinerary>> getAllItinerary(
            @Query("id") int id,
            @Query("key") String key);
}
