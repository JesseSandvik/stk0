package com.github.stackoverflow.cli.api;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;

@Client("${stackoverflow.api.url}")
public interface StackoverflowHttpClient {
    @Get("/search?site=stackoverflow")
    ApiResponse<Question> search(
            @QueryValue("intitle") String query,
            @QueryValue("tagged") String tag,
            @QueryValue("pagesize") int limit,
            @QueryValue("sort") String sort
    );
}
