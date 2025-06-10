import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RunCommand {

    //command 별로 인자값을 ssd.jar 에 전달
    public void execute(String input) {
        try {
            String[] parts = input.trim().split("\\s+");
            String command = parts[0].toLowerCase();

            switch (command) {
                case "write":
                    write(input);
                    break;
                // 추후 read, fullwrite 등 추가 가능
                default:
                    System.out.println("ERROR");
            }
        } catch (Exception e) {
            System.out.println("ERROR");
        } finally {
            System.out.print("Shell> ");
        }
    }

    public void write(String input) throws IOException, InterruptedException {
        String[] str = input.split("\\s+");
        String LBA = str[1];
        String value = str[2];

        runSSDCommand("W", LBA, value);

        System.out.print("Shell> ");
    }

//    void runSSDCommand(String... args) throws IOException, InterruptedException {
//        List<String> command = new ArrayList<>();
//        command.add("java");
//        command.add("-jar");
//        command.add("ssd.jar");
//        Collections.addAll(command, args);
//
//        ProcessBuilder pb = new ProcessBuilder(command);
//        pb.start().waitFor();
//    }

    void runSSDCommand(String... args) throws IOException {
        throw new IOException("테스트용 IOException");
    }
}
