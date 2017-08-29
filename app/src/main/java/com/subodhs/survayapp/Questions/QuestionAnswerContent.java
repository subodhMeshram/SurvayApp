package com.subodhs.survayapp.Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Subhodh on 8/29/2017.
 */

public class QuestionAnswerContent {
    public static List<QuestionAnswer> answerList=new ArrayList<>();
    public void addItem(QuestionAnswer answer){
        answerList.add(answer);
    }

    public class QuestionAnswer{
        public final String questionText;
        public final String answerText;

        public QuestionAnswer(String questionText, String answerText) {
            this.questionText = questionText;
            this.answerText = answerText;
        }
    }


}
