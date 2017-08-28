package com.subodhs.survayapp.Questions;

import java.util.List;

/**
 * Created by Subhodh on 8/28/2017.
 */

public class QuestionsContent {

    /**
     * name : Employee satisfaction survey questions
     * intro : Employee surveys are suffering, and it's probably because you're not asking the right questions. To get the most out of your employee engagement survey, you can't expect to ask any old question whenever you feel like it. The correct employee engagement survey questions need to be asked at the right frequency to get a continuous stream of helpful feedback.
     * questions : [{"type":"scale","compulsary":true,"text":"On a scale of 1 to 10, how happy are you at work?"},{"type":"MCQ","single":true,"compulsary":true,"text":"Would you refer someone to work here?","answers":["Yes","No","Maybe"]},{"type":"MCQ","single":true,"compulsary":true,"text":"Do you have a clear understanding of your career or promotion path?","answers":["Yes","No"]},{"type":"text","compulsary":false,"text":"If No, write the reason"},{"type":"scale","text":"On a scale of 1 to 10, how would you rate your work-life balance?","compulsary":true},{"type":"text","text":"Hypothetically, if you were to quit tomorrow, what would your reason be?","compulsary":true},{"type":"MCQ","single":true,"text":"Do you feel valued at work?","answers":["Yes","No","May Be"],"compulsary":true},{"type":"select","text":"How frequently do you receive recognition from your manager?","answers":["Every Day","Every Week","Every Month","Never"],"compulsary":true},{"type":"MCQ","single":true,"text":"The last time you accomplished a big project, did you recieve any recognition?","answers":["Yes","No"],"compulsary":true},{"type":"MCQ","single":true,"text":"Do you believe you'll be able to reach your full potential here?","answers":["Yes","No","Maybe"],"compulsary":true},{"type":"MCQ","single":true,"text":"If you were given the chance, would you reapply to your current job?","answers":["Yes","No"],"compulsary":true},{"type":"text","compulsary":false,"text":"If No, write the reason"}]
     */

    private String name;
    private String intro;
    private List<QuestionsBean> questions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public List<QuestionsBean> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionsBean> questions) {
        this.questions = questions;
    }

    public static class QuestionsBean {
        /**
         * type : scale
         * compulsary : true
         * text : On a scale of 1 to 10, how happy are you at work?
         * single : true
         * answers : ["Yes","No","Maybe"]
         */

        private String type;
        private boolean compulsary;
        private String text;
        private boolean single;
        private List<String> answers;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean isCompulsary() {
            return compulsary;
        }

        public void setCompulsary(boolean compulsary) {
            this.compulsary = compulsary;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public boolean isSingle() {
            return single;
        }

        public void setSingle(boolean single) {
            this.single = single;
        }

        public List<String> getAnswers() {
            return answers;
        }

        public void setAnswers(List<String> answers) {
            this.answers = answers;
        }
    }
}
