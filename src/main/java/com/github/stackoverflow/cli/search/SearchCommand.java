package com.github.stackoverflow.cli.search;

import com.github.stackoverflow.cli.api.Question;
import com.github.stackoverflow.cli.api.StackoverflowHttpClient;
import jakarta.inject.Inject;
import picocli.CommandLine;

@CommandLine.Command(name="search", description = "Search questions matching criteria.", mixinStandardHelpOptions = true)
final public class SearchCommand implements Runnable {

    @CommandLine.Option(names = {"-q", "--query"}, description = "Search phrase.") String query;

    @CommandLine.Option(names = {"-t", "--tag"}, description = "Search inside specific tag.") String tag;

    @CommandLine.Option(names = {"-n", "--limit"}, description = "Limit results. Default: 10") int limit = 10;

    @CommandLine.Option(
            names = {"-s", "--sortBy"},
            description = "Available values: relevance, votes, creation, activity. Default: relevance"
    ) String sortBy = "relevance";

    @CommandLine.Option(names = {"-v", "--verbose"}, description = "Print verbose output.") boolean verbose;
    @Inject
    StackoverflowHttpClient client;
    @Override
    public void run() {
        var response = client.search(query, tag, limit, sortBy);

        response.items.stream()
                .map(SearchCommand::formatQuestion)
                .forEach(System.out::println);

        if (verbose) {
            System.out.printf(
                    "\nItems size: %d | Quota max: %d | Quota remaining: %d | Has more: %s\n",
                    response.items.size(),
                    response.quotaMax,
                    response.quotaRemaining,
                    response.hasMore
            );
        }
    }

    static private String formatQuestion(final Question question) {
        return CommandLine.Help.Ansi.AUTO.string(String.format(
                "@|bold,fg(green) %s|@ %d|%d @|bold,fg(yellow) %s|@\n      %s",
                question.isAnswered ? "✔" : " ",
                question.score,
                question.answerCount,
                question.title,
                question.link
        ));
    }
}
