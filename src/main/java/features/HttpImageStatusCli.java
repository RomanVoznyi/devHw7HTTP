package features;

import org.jsoup.HttpStatusException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HttpImageStatusCli {

    public void askStatus() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter HTTP status code");
        while (!sc.hasNextInt()) {
            try {
                sc.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Please enter valid number");
                sc.next();
            }
        }
        int code = sc.nextInt();
        sc.close();
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        try {
            downloader.downloadStatusImage(code);
            System.out.println("You can find your picture at file 'cat" + code + ".jpeg' in the 'java' folder");
        } catch (HttpStatusException ex) {
            System.out.println("There is not image for HTTP status " + code);
        }
    }
}
