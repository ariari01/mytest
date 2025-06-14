import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RunCommandTest {

    @Test
    void write_호출시_runSSDCommand가_호출되는지_확인() throws Exception {
        //arrange
        RunCommand runCommand = spy(new RunCommand());
        doNothing().when(runCommand).runSSDCommand(any(), any(), any());

        //act
        runCommand.write("write 3 0xAAAABBBB");

        //assert
        verify(runCommand).runSSDCommand("W", "3", "0xAAAABBBB");
    }

    @Test
    void runSSDCommand_jar파일없을때_IOException_발생() throws IOException {
        RunCommand runCommand = spy(new RunCommand());
        doThrow(new IOException("테스트")).when(runCommand).runSSDCommand(any(), any(), any());

        assertThatThrownBy(() -> runCommand.write("write 3 0xAAAABBBB"))
                .isInstanceOf(IOException.class)
                .hasMessageContaining("테스트");
    }
}