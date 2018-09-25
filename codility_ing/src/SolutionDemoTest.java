import java.util.*;
import java.util.stream.Collectors;

/*This is a demo task.
        MissingInteger

        Write a function:

class SolutionDemoTest { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

        For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

        Given A = [1, 2, 3], the function should return 4.

        Given A = [−1, −3], the function should return 1.

        Write an efficient algorithm for the following assumptions:

        N is an integer within the range [1..100,000];
        each element of array A is an integer within the range [−1,000,000..1,000,000].
        Copyright 2009–2018 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.*/
public class SolutionDemoTest {
    public int solution(int[] A) {
        List<Integer> arrayA = Arrays.stream(A).boxed().collect(Collectors.toList());
        Integer maxFromA = Collections.max(arrayA);
        List<Integer> holes = getHolesFromIntList(arrayA, maxFromA);
        if (maxFromA <= 0) {
            return 1;
        } else {
            if (holes.isEmpty()) {
                return maxFromA + 1;
            } else {
                return holes.get(0);
            }
        }
    }

    private List<Integer> getHolesFromIntList(List<Integer> arrayA, Integer maxFromA) {
        List<Integer> holes = new ArrayList<>();
        for (Integer i = 1; i < maxFromA; i++) {
            if (!arrayA.contains(i)) {
                holes.add(i);
            }
        }
        return holes;
    }

    public static void main(String[] args) {
        test(new int[]{1, 3, 6, 4, 1, 2});
        test(new int[]{1, 2, 3});
        test(new int[]{-1, -3});
        test(new int[]{4, 5, 6, 2});
    }

    public static void test(int[] array) {
        System.out.print(Arrays.toString(array));
        System.out.print(" -> ");
        System.out.println(new SolutionDemoTest().solution2(array));
    }

    public int solution2(final int[] A)
    {
        Arrays.sort(A);
        int min = 1;

        // Starting from 1 (min), compare all elements, if it does not match
        // that would the missing number.
        for (int i : A) {
            if (i == min) {
                min++;
            }
        }

        return min;
    }

    public int solution3(int[] A) {
        int smallestMissingInteger = 1;
        if (A.length == 0) {
            return smallestMissingInteger;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                set.add(A[i]);
            }
        }
        while (set.contains(smallestMissingInteger)) {
            smallestMissingInteger++;
        }
        return smallestMissingInteger;

    }
}
