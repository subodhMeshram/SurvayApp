package com.subodhs.survayapp.Interface;

import com.subodhs.survayapp.Questions.QuestionsContent;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Subhodh on 8/28/2017.
 */

public interface GetQuestions {
    @GET("subodhMeshram/SurvayApp/master/app/questions.json")
    Call<QuestionsContent> all();
}
