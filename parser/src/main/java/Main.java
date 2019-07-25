import java.net.MalformedURLException;
import java.net.URL;
public class Main {
    static void MyFun(){
        try {
            URL connect = new URL("http://www.cbr.ru/scripts/XML_daily.asp");
            System.err.println(connect);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int S = 2;
        int f = S + 10;
        System.err.println(f);
        MyFun();
    }

}
