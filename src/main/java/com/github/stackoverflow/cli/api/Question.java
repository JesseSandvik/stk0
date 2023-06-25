package com.github.stackoverflow.cli.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

@Introspected
final public class Question {
    public String title;
    public String link;
    public int score;
    @JsonProperty("answer_count")
    public int answerCount;
    @JsonProperty("is_answered")
    public boolean isAnswered;

    @Override
    public String toString() {
        return "Question{" +
                "title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", score=" + score +
                ", answerCount=" + answerCount +
                ", isAnswered=" + isAnswered +
                '}';
    }
}
