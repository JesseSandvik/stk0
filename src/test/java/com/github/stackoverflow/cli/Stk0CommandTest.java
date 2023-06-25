package com.github.stackoverflow.cli;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;
import io.micronaut.context.env.Environment;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Stk0CommandTest {

    @Test
    public void testWithCommandLineOption() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(baos));

        try (ApplicationContext ctx = ApplicationContext.run(Environment.CLI, Environment.TEST)) {
//            String[] args = new String[] { "-v" };
            String[] args = new String[] {"search", "-q", "merge maps", "-t", "java", "--verbose"};
            PicocliRunner.run(Stk0Command.class, ctx, args);
            out.println(baos.toString());

            /*
            *  ✔ 9|3 Merge Maps in Groovy
            *        https://stackoverflow.com/questions/213213/merge-maps-groovy
            */
//            assertTrue(baos.toString().contains("assertion"));
//            assertTrue(baos.toString().matches("/✔? \\d+\\|\\d+ [^\n]+\n{6}https://stackoverflow.com/questions/\\d+/[a-z0-9\\-]"));
//            baos.toString() =~ $/✔? \d+\|\d+ [^\n]+\n {6}https://stackoverflow.com/questions/\d+/[a-z0-9\-]+/;
        }
    }
}
