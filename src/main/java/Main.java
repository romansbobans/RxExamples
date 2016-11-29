import rx.functions.Func2;

import java.io.*;

/**
 * Created by romans on 16.10.9.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        InputStream in = System.in;
        new ReactiveSum(in, "a:", "b:").combine(a -> a*3);
    }
}
