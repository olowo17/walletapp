package myClass;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tutorial tutorial = new Tutorial("Adewale");

        System.out.println(tutorial.getMyName());

//        AccountBalance acount1 =new AccountBalance("Shola Awoniyi", 64_737.83);
//        AccountBalance acount2 =new AccountBalance("Ciroma Musa", 738_728);
//
//        System.out.println(acount1.deposit(733.54));
//        System.out.println(acount1.getName());
//
//        System.out.println(acount2.getBalance());
//        System.out.println(acount2.deposit(78543));
//        System.out.println(acount2.getBalance());
        int[] responses = {1, 2, 5, 4, 3, 5, 2, 1, 3, 3, 1, 4, 3, 3, 3, 2, 3, 3, 2, 14};
//        int[] frequency = new int[6];
//        for (int rating = 1; rating < frequency.length; rating++) {
//            System.out.printf("%6d%10d%n", rating, frequency[rating]);
//        }

        List <Integer> myArrayList = new ArrayList<>(7);
        for( int a :responses)
            myArrayList.add(a);

        System.out.println(myArrayList);
        for (int i = 0; i < myArrayList.size(); i++) {
            if (myArrayList.get(i) %2 ==0)
                System.out.print(myArrayList.get(i));
        }
    }
}
