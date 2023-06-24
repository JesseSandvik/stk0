package com.github.stackoverflow.cli.search;

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
    @Override
    public void run() {
        System.out.println("Search command running...");
    }
}
