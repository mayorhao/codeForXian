// JAVA code to partition a set into two subsets
// such that the difference of subset sums
// is minimum
import java.util.*;

class GFGTest {

    public static int findMinList(List<Integer> list, int sum, int mid) {
        System.out.println("list before sort: " + list);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println("list after sort: " + list);

        int i = 0;
        int j = 0;
        int temp = 0;
        int min = sum;
        int leftSum = 0;
        int rightSum = 0;
        int n = list.size();
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();

        for (int index = 0; index < n; ) {
            j = 0;
            min = sum;
            for (i = 0; i < n; i++) {
                temp = mid - list.get(i);
                if (temp < min) {
                    min = temp;
                    j = i;
                }
            }

            System.out.println("-------close to mid-------: " + list.get(j));
            if (leftSum < rightSum) {
                leftList.add(list.get(j));
                leftSum += list.get(j);
            } else {
                rightList.add(list.get(j));
                rightSum += list.get(j);
            }

            // remove j
            n--;
            mid = mid - list.get(j);
            list.remove(j);
            System.out.println("-------remain list-------: " + list);
        }


        System.out.println("left list: " + leftList);
        System.out.println("right list: " + rightList);

        return Math.abs(leftSum - rightSum);
    }

    // Returns minimum possible difference between
    // sums of two subsets
    public static int findMin(int arr[], int n) {
        List<Integer> list = new ArrayList<>();
        // Compute total sum of elements
        int sumTotal = 0;
        for (int i = 0; i < n; i++) {
            sumTotal += arr[i];
            list.add(arr[i]);
        }
        int mid = sumTotal / 2;

        return findMinList(list, sumTotal, mid);
    }

    /* Driver program to test above function */
    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 2, 2, 1};
        int n = arr.length;
        System.out.print("The minimum difference" +
                " between two sets is " +
                findMin(arr, n));
    }
}

// This code is contributed by Arnav Kr. Mandal.