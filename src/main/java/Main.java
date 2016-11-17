import rx.functions.Func2;

import java.io.*;

/**
 * Created by romans on 16.10.9.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        InputStream in = System.in;
        new ReactiveSum(in, "a:", "b:").combine(a -> a*3);
        //a = 5; //a:5
        //b = 5; //b:5
        //a=7; //a:7

        //new RxZip().fetchUserData().observeOn(Schedulers.io()).subscribe(v -> System.out.println(String.format("Finished execution on thread %s", Thread.currentThread().getName())));
        //Thread.sleep(15000);
    }
}
