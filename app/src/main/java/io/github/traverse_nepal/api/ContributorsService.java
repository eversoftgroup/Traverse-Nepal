package io.github.traverse_nepal.api;


import java.util.List;

import io.github.traverse_nepal.entities.Contributors;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ContributorsService {

    @GET("contributors/getall")
    Call<List<Contributors>> getallContributors();


}
