package io.github.traverse_nepal.api;



import java.util.List;

import io.github.traverse_nepal.entities.Holidays;
import retrofit2.Call;
import retrofit2.http.GET;


public interface HolidayService {

  // @Headers({"Accept:application/json", "Content-Type:application/json;"})
    @GET("holidays/getall")
    Call<List<Holidays>> getallholidays();
}
