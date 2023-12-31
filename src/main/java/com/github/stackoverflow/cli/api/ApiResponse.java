package com.github.stackoverflow.cli.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;

import java.util.Collections;
import java.util.List;

@Introspected
final public class ApiResponse<T> {
    public List<Question> items = Collections.emptyList();

    @JsonProperty("has_more")
    public boolean hasMore;

    @JsonProperty("quota_max")
    public int quotaMax;

    @JsonProperty("quota_remaining")
    public int quotaRemaining;
}
