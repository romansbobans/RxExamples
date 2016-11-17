import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.Random;

/**
 * Created by XPS on 11/17/2016.
 */
public class RxConcat2 {

    Observable<Integer> getData() {
        return Observable
                .concat(getFromCache(), getFromMemory(), getFromNetwork())
                .first()
                .doOnCompleted(() -> System.out.println("Completed"));
    }

    private Observable<Integer> getFromCache() {
        return Observable.empty();
    }
    private Observable<Integer> getFromMemory() {
        return Observable.just(1);
    }
    private Observable<Integer> getFromNetwork() {
        return Observable.error(new RuntimeException("Network exception"));
    }
}
