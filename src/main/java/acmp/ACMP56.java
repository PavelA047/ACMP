package acmp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ACMP56 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> myFriends = new ArrayList<>();
        int numberOfMyFriends = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfMyFriends; i++) {
            myFriends.add(reader.readLine());
        }
        List<String> mySubscribers = new ArrayList<>();
        int numberOfMySubscribers = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfMySubscribers; i++) {
            mySubscribers.add(reader.readLine());
        }
        System.out.println(method(myFriends, mySubscribers));
    }

    public static String method(List<String> myFriends, List<String> mySubscribers) {
        StringBuilder sb = new StringBuilder();
        sb.append("Friends: ");
        Collections.sort(myFriends);
        Collections.sort(mySubscribers);
        Iterator<String> myFriendsIterator = myFriends.iterator();
        Iterator<String> mySubscribersIterator = mySubscribers.iterator();

        while (myFriendsIterator.hasNext()) {
            sb.append(myFriendsIterator.next());
            if (myFriendsIterator.hasNext()) sb.append(", ");
        }
        sb.append("\n").append("Mutual Friends: ");

        boolean flag = false;
        while (mySubscribersIterator.hasNext()) {
            String next = mySubscribersIterator.next();
            if (myFriends.contains(next)) {
                if (flag) sb.append(", ");
                sb.append(next);
                flag = mySubscribersIterator.hasNext();
            }
        }
        sb.append("\n").append("Also Friend of: ");

        mySubscribers.removeAll(myFriends);
        mySubscribersIterator = mySubscribers.iterator();

        while (mySubscribersIterator.hasNext()) {
            sb.append(mySubscribersIterator.next());
            if (mySubscribersIterator.hasNext()) sb.append(", ");
        }

        return sb.toString();
    }

}
