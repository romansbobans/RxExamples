import rx.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by romans on 16.16.11.
 */
public class RxDebounce {

    public Observable<List<AutocompleteResult>> results(Observable<String> inputObservable) {
        return inputObservable.debounce(300, TimeUnit.MILLISECONDS).flatMap(this::resultApiCall);
    }

    private Observable<List<AutocompleteResult>> resultApiCall(String s) {
        return Observable.just(new ArrayList<AutocompleteResult>());
    }


    class AutocompleteResult {
        //Dummy
    }
}
