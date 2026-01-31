package pablo.parser;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pablo.command.AddCommand;
import pablo.command.Command;
import pablo.command.NullCommand;
import pablo.task.Deadline;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static pablo.parser.Parser.parseDeadline;

public class ParserTest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void deadlineParser_success(){
        Command c = parseDeadline("deadline return book /by 06-06-2026_12:00");
        AddCommand add = (AddCommand) c;
        Deadline d = (Deadline) add.getTask();
        assertEquals("return book", d.getName());
        assertEquals(LocalDateTime.of(2026, 6, 6, 12, 0), d.getBy());
    }

    @Test
    public void deadlineParser_dateFormatError_caught() {
        Command c = Parser.parse("deadline submit report /by nonsense");
        assertInstanceOf(NullCommand.class, c);
        assertEquals("Date and time information must be specified using dd-mm-yyyy_hh:mm\r\n", outContent.toString());
    }

    @Test
    public void deadlineParser_indexOutOfBounds_caught() {
        Command c = Parser.parse("deadline submit");
        assertInstanceOf(NullCommand.class, c);
        assertEquals("You must specify a complete by timing for a deadline task using the \"by\" tag!\r\n", outContent.toString());
    }
}
