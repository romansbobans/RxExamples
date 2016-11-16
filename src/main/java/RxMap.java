import rx.Observable;

import java.util.List;

/**
 * Created by romans on 16.14.11.
 */
public class RxMap {

    public Observable<User> getUserFromApiOrDatabase() {
        //Some API or database call
        return Observable.just(new User(1, "Romans"));
    }

    public Observable<Integer> mapUserToId(Observable<User> userObservable) {
        return userObservable.map(User::getId);
    }

    public void printRetrievedUserId() {
        mapUserToId(getUserFromApiOrDatabase()).subscribe(System.out::println);
    }

    public Observable<List<Integer>> mapUserListToIdList(Observable<List<User>> userObservable) {
        printRetrievedUserId();
        return userObservable.flatMap(Observable::from).map(User::getId).toList();
    }


    class User {
        final Integer id;
        final String name;

        public User(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }
    }
}
