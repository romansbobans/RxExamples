import rx.Observable;
import rx.subjects.BehaviorSubject;

/**
 * Created by XPS on 11/16/2016.
 */
public class RxBehaviourSubject {

    BehaviorSubject<Integer> subject = BehaviorSubject.create();

    public RxBehaviourSubject() {
        subject.onNext(1);
        subject.onNext(2);
        subject.onNext(3);
    }

    Observable<Integer> getEmitter() {
        return subject;
    }
}
