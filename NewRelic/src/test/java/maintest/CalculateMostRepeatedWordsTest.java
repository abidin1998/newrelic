package maintest;

import application.CalculateMostRepeatedWords;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateMostRepeatedWordsTest {

    @Test
    public void testNoInput() {
        String input = "";
        String expectedOutput = "";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CalculateMostRepeatedWords.main(new String[]{});

        assertEquals(expectedOutput, out.toString());
    }

    @Test
    public void testSingleLineInput() {
        String input = "the quick brown fox\n";
        String expectedOutput = "the quick brown - 1\nquick brown fox - 1\n";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CalculateMostRepeatedWords.main(new String[]{});

        assertEquals(expectedOutput, out.toString());
    }

    @Test
    public void testMultipleLinesInput() {
        String input = "the quick brown fox\njumps over the lazy dog\n";
        String expectedOutput = """
                over the lazy - 1
                the quick brown - 1
                quick brown fox - 1
                jumps over the - 1
                fox jumps over - 1
                brown fox jumps - 1
                the lazy dog - 1
                """;

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CalculateMostRepeatedWords.main(new String[]{});

        assertEquals(expectedOutput, out.toString());
    }

    @Test
    public void testInputFromFile() {
        String expectedOutput = """
                and i and - 44
                i and i - 44
                """;

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CalculateMostRepeatedWords.main(new String[]{"src/main/resources/files/2-word-catcher.txt"});

        assertEquals(expectedOutput, out.toString());
    }

    @Test
    public void testWrongFilePath() {
        String expectedOutput = "Error reading from file " +
                "files/2-word-catcher.txt: files/2-word-catcher.txt (No such file or directory)\n";

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CalculateMostRepeatedWords.main(new String[]{"files/2-word-catcher.txt"});

        assertEquals(expectedOutput, out.toString());
    }
}

