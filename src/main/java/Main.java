import features.HttpImageStatusCli;
import features.HttpStatusChecker;
import features.HttpStatusImageDownloader;
import org.jsoup.HttpStatusException;

public class Main {
    public static void main(String[] args) {
        System.out.println("------------ HttpStatusChecker tests------------");
        HttpStatusChecker checker = new HttpStatusChecker();
        runChecker(checker, 100);
        runChecker(checker, -50);
        runChecker(checker, 200);
        runChecker(checker, 404);
        runChecker(checker, 10000);

        System.out.println("------------ HttpStatusImageDownloader tests------------");
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        runDownloader(downloader, 100);
        runDownloader(downloader, -50);
        runDownloader(downloader, 200);
        runDownloader(downloader, 404);
        runDownloader(downloader, 10000);

        System.out.println("------------ HttpImageStatusCli tests------------");
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();

    }

    public static void runChecker(HttpStatusChecker checker, int code) {
        try {
            System.out.println("You can find your picture by this url - " + checker.getStatusImage(code));
        } catch (HttpStatusException ex) {
            System.out.println("!!!Exception: " + ex.getMessage());
        }
        System.out.println();
    }

    public static void runDownloader(HttpStatusImageDownloader downloader, int code) {
        try {
            downloader.downloadStatusImage(code);
            System.out.println("You can find your picture at file 'cat" + code + ".jpeg' in the 'images' folder");
        } catch (HttpStatusException ex) {
            System.out.println("!!!Exception: " + ex.getMessage());
        }
        System.out.println();
    }
}