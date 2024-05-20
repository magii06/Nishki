import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;


public class Main {
    public static void main(String[] args) {
        PriorityBlockingQueue<Clothes> list = new PriorityBlockingQueue<>();
        Path resourceDirectory = Paths.get("src", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();

        Thread t1 = new Thread(() -> {
            Scanner sc = null;
            try {
                sc = new Scanner(new File(absolutePath + "/new 1.txt"));
                while (sc.hasNext()) {
                    String ime = sc.next();
                    String tip = sc.next();
                    double cena = sc.nextDouble();
                    Clothes c1 = new Clothes(ime, tip, cena);
                    list.put(c1);

                }
                sc.close();
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } finally {
                sc.close();
            }
        });
        Thread t2 = new Thread(() -> {
            File f = new File(absolutePath + "/new 2.txt");
            Scanner sc = null;
            try {
                sc = new Scanner(f);
                while (sc.hasNextLine()) {
                    String ime = sc.next();
                    String tip = sc.next();
                    double cena = sc.nextDouble();
                    Clothes c1 = new Clothes(ime, tip, cena);
                    list.put(c1);
                }
                sc.close();
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }

        });
        Thread t3 = new Thread(() -> {
            File f = new File(absolutePath + "/new 3.txt");
            Scanner sc = null;
            try {
                sc = new Scanner(f);
                while (sc.hasNext()) {
                    String ime = sc.next();
                    String tip = sc.next();
                    double cena = sc.nextDouble();
                    Clothes c1 = new Clothes(ime, tip, cena);
                    list.put(c1);
                }
                sc.close();
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }

        });
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        File f2 = new File(absolutePath + "/output.txt");
        try {
            PrintWriter output = new PrintWriter(f2);
            for (int i = 0; i < 10; i++) {

                output.println(list.poll().toString());
            }
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}