// Ramu is a milk supplier to Somu. He has only two aluminium cups 
// of capacity m and n litres. Using these two cups only, 
// he can measure the milk. He has to supply exactly P litres of milk to Somu.

// To measure the milk, operations allowed are:
// 	- Fill one of the cups completely with milk.
// 	- Empty the other cup.
// 	- Pour milk from one cup into another cup till it fills completely,
// 	 or the first cup itself is empty.
	 
// Such that, at the end one or both cups contains P litres of the milk.
	
// Please help Ramu, to check whether P litres of milk can be measured
// using the two cups or not.

// Input Format:
// -------------
// 3 space separated integers, m, n and P.

// Output Format:
// --------------
// Print a boolean value.


// Sample Input-1:
// ---------------
// 3 5 4

// Sample Output-1:
// ----------------
// true


// Sample Input-2:
// ---------------
// 2 4 5

// Sample Output-2:
// ----------------
// false
import java.util.*;

class test {
    public static boolean check(int m, int n, int P) {
        Set<String> visited = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int cup1 = state[0];
            int cup2 = state[1];

            if (cup1 == P || cup2 == P || cup1 + cup2 == P) {
                return true;
            }

            List<int[]> nextStates = Arrays.asList(
                    new int[]{m, cup2},
                    new int[]{cup1, n},
                    new int[]{0, cup2},
                    new int[]{cup1, 0},
                    new int[]{Math.min(cup1 + cup2, m), Math.max(0, cup1 + cup2 - m)},
                    new int[]{Math.max(0, cup1 + cup2 - n), Math.min(cup1 + cup2, n)}
            );

            for (int[] nextState : nextStates) {
                String nextStateString = Arrays.toString(nextState);
                if (!visited.contains(nextStateString)) {
                    visited.add(nextStateString);
                    queue.offer(nextState);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int P = sc.nextInt();
        System.out.println(check(m, n, P));
    }
}
