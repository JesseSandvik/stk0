package com.github.stackoverflow.cli;

import com.github.stackoverflow.cli.search.SearchCommand;
import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "stk0", description = "...",
        mixinStandardHelpOptions = true, subcommands = {SearchCommand.class})
public class Stk0Command implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "...")
    boolean verbose;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(Stk0Command.class, args);

        System.exit(0);
    }

    public void run() {
        // business logic here
        if (verbose) {
            System.out.println("Hi!");
        }
    }
}
