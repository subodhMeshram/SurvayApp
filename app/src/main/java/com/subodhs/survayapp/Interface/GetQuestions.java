package com.subodhs.survayapp.Interface;

import com.subodhs.survayapp.Questions.QuestionsContent;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Retrofit interface to get the list of questions from server
 */

public interface GetQuestions {
    @GET("subodhMeshram/SurvayApp/master/app/questions.json")
    Call<QuestionsContent> all();
}
