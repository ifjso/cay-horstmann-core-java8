package ch10.sec09;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadDir {

  public static void main(String[] args) throws IOException, InterruptedException {
    Process process = new ProcessBuilder("ls", "-l")
        .directory(Paths.get("/tmp").toFile())
        .start();

    try (Scanner in = new Scanner(process.getInputStream())) {
      while (in.hasNextLine()) {
        System.out.println(in.nextLine());
      }
    }

    int result = process.waitFor();
    System.out.println("Exit value: " + result);
  }
}
