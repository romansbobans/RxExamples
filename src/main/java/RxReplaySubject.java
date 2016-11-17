import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.ReplaySubject;

/**
 * Created by XPS on 11/16/2016.
 */
public class RxReplaySubject {

    ReplaySubject<Integer> subject = ReplaySubject.create();

    public RxReplaySubject() {
        subject.onNext(1);
        subject.onNext(2);
        subject.onNext(3);
    }

    Observable<Integer> getEmitter() {
        return subject;
    }
}
