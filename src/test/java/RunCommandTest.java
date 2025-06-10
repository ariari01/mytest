import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RunCommandTest {

    @Test
    void write_정상입력일때() {
        //arrange
        RunCommand app = new RunCommand();
        String input = "write 3 0xAAAABBBB";
        String expected = "DONE";

        //act
        String actual = app.write(input);

        //assert
        assertThat(actual).isEqualTo("DONE");
    }
}