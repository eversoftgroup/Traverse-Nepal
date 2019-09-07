package com.eversoft.api;

import com.eversoft.entities.Question;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ForumService {

    @GET("forum/question/getall")
    Call<List<Question>> getAllQuestion();
}
