package helloworld;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HelloWorld {

    public static void main(String[] args) {
        processBuilder("javac -d . HelloWorld.java");
        processBuilder("java helloworld.HelloWorld");
    }

    public static void processBuilder(String commandString) {
        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "cd \"C:\\Users\\HP\\Desktop\\STIW3054\" && " + commandString);
            builder.redirectErrorStream(true);
            Process pro = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
