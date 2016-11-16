import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.Random;

/**
 * Created by romans on 16.16.11.
 */
public class RxConcat {

    Observable<Void> fetchUserData() {
        return Observable.concat(loadSessionData(), loadUserTemplates(), loadAccountList(), loadCustomerLocations());

    }

    private Observable<Void> loadSessionData() {
        return Observable.fromCallable(this::sleepRandomTime).subscribeOn(Schedulers.computation()).doOnNext(i -> printCurrentThread("Loading session data")).map(i -> null);
    }
    private Observable<Void> loadUserTemplates() {
        return Observable.fromCallable(this::sleepRandomTime).subscribeOn(Schedulers.computation()).doOnNext(i -> printCurrentThread("Loading user templates")).map(i -> null);
    }
    private Observable<Void> loadAccountList() {
        return Observable.fromCallable(this::sleepRandomTime).subscribeOn(Schedulers.computation()).doOnNext(i -> printCurrentThread("Loading account list")).map(i -> null);
    }
    private Observable<Void> loadCustomerLocations() {
        return Observable.fromCallable(this::sleepRandomTime).subscribeOn(Schedulers.computation()).doOnNext(i -> printCurrentThread("Loading customer locations")).map(i -> null);
    }

    private void printCurrentThread(String action) {
        System.out.println(String.format("%s on %s", action, Thread.currentThread().getName()));
    }

    int sleepRandomTime() {
        try {
            int randomInt = new Random().nextInt(3) + 1;

            Thread.sleep(randomInt* 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
