import rx.schedulers.Schedulers;

import java.io.InputStream;

/**
 * Created by romans on 16.10.9.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        InputStream in = System.in;
        //new ReactiveSum(in, "a", "b").combine((sum) -> (sum) * 5);
        new RxConcat().fetchUserData().observeOn(Schedulers.io()).subscribe(v -> System.out.println(String.format("Finished execution on thread %s", Thread.currentThread().getName())));
        Thread.sleep(15000);
        new RxDebounce().results(null).subscribe();
    }
}
