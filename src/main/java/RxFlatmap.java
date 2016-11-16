import com.google.common.collect.Lists;
import rx.Observable;

import java.util.List;

public class RxFlatmap {

    public Observable<List<User>> getAllUsersFromApiOrDatabase() {
        //Some API or database call
        return Observable.just(Lists.newArrayList(new User(1, "Romans"), new User(2, "XXX"), new User(3, "YYY"), new User(4, "ZZZ")));
    }

    public Observable<List<Integer>> mapUserToId(Observable<List<User>> userObservable) {
        return userObservable.flatMap(Observable::from).map(User::getId).toList();
    }

    public void printRetrievedUserIdList() {
        mapUserToId(getAllUsersFromApiOrDatabase()).subscribe(System.out::println);
    }

    public Observable<List<Integer>> mapUserListToIdList(Observable<List<User>> userObservable) {
        printRetrievedUserIdList();
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
