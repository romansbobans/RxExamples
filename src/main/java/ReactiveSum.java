import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observables.ConnectableObservable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by romans on 16.14.11.
 */
public class ReactiveSum {

    private final Observable<Double> a;
    private final Observable<Double> b;
    private final ConnectableObservable<String> inputObservable;

    public ReactiveSum(InputStream inputStream, String firstPattern, String secondPattern) {
        inputObservable = createObservable(inputStream);
        a = createObserver(firstPattern, inputObservable);
        b = createObserver(secondPattern, inputObservable);
    }

    public <T> void combine(Func1<Double, T> resultFunction) {
        Observable.combineLatest(a, b, (aDouble, aDouble2) -> aDouble+aDouble2).flatMap((Func1<Double, Observable<?>>) aDouble -> {
            return Observable.just(resultFunction.call(aDouble));
        }).subscribe(System.out::println);
        inputObservable.connect();
    }

    private Observable<Double> createObserver(String a, ConnectableObservable<String> observable) {
        return observable.filter(s -> s.startsWith(a)).map(s -> new Double(s.substring(s.indexOf(":")+1)));
    }

    private ConnectableObservable<String> createObservable(InputStream in) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        return Observable.create((Observable.OnSubscribe<String>) subscriber -> {
            if (subscriber.isUnsubscribed()) {
                return;
            }
            String s;
            try {
                while ((s = reader.readLine()) != null) {
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    subscriber.onNext(s);
                }
            } catch (IOException e) {
                subscriber.onError(e);
            }

        }).publish();
    }

}
