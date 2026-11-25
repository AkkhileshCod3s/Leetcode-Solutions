import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        // Base case: combination has reached size k
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Pruning: stop early if there aren't enough remaining numbers to reach size k
        int needed = k - current.size();
        for (int i = start; i <= n - needed + 1; i++) {
            current.add(i);
            backtrack(i + 1, n, k, current, result);
            current.remove(current.size() - 1); // Undo choice for next iteration
        }
    }
}
