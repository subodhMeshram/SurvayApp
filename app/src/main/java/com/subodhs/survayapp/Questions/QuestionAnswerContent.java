package com.subodhs.survayapp.Questions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Subhodh on 8/29/2017.
 */

public class QuestionAnswerContent {
    public static List<QuestionAnswer> ANSWER_LIST=new ArrayList<>();
    public static void addItem(QuestionAnswer answer){
        ANSWER_LIST.add(answer);
    }

    public static class QuestionAnswer{
        public final String questionText;
        public final String answerText;

        public QuestionAnswer(String questionText, String answerText) {
            this.questionText = questionText;
            this.answerText = answerText;
        }
    }


}
