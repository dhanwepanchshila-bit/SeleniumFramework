package seleniumPractice;

import java.io.IOException;

public class StartSeleniumServer {
    public static void main(String[] args) {

        try {

            ProcessBuilder pb = new ProcessBuilder(
                    "cmd.exe",
                    "/c",
                    "java -jar C:\\selenium\\selenium-server-4.20.0.jar standalone"
            );

            pb.inheritIO(); // console output show hoil
            Process process = pb.start();

            System.out.println("Selenium Server started...");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}