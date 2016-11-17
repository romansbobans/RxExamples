import rx.Observable;
import rx.subjects.AsyncSubject;
import rx.subjects.ReplaySubject;

import java.util.concurrent.TimeUnit;

/**
 * Created by XPS on 11/16/2016.
 */
public class RxAsyncSubject {

    AsyncSubject<Integer> subject = AsyncSubject.create();

    public RxAsyncSubject() {
        subject.onNext(1);
        subject.onNext(2);
        subject.onNext(3);
        Observable.timer(3000, TimeUnit.MILLISECONDS).subscribe(i -> subject.onCompleted());
    }

    Observable<Integer> getEmitter() {
        return subject;
    }
}
