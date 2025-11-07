package problemSolving;

public class LeetCode2528 {
    public static long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] pref = new long[n];
        pref[0] = stations[0];
        for (int i = 1; i < n; ++i) pref[i] = pref[i - 1] + stations[i];

        long[] power = new long[n];
        for (int i = 0; i < n; ++i) {
            int left = Math.max(0, i - r);
            int right = Math.min(n - 1, i + r);
            power[i] = pref[right] - (left > 0 ? pref[left - 1] : 0L);
        }

        long low = 0, high = (long)1e18;
        long ans = 0;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            if (canAchieve(power, r, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private static boolean canAchieve(long[] power, int r, long k, long target) {
        int n = power.length;
        long used = 0;
        long windowAdd = 0;
        long[] diff = new long[n + 1];

        for (int i = 0; i < n; ++i) {
            windowAdd += diff[i];
            long curr = power[i] + windowAdd;
            if (curr < target) {
                long need = target - curr;
                used += need;
                if (used > k) return false;
                int pos = Math.min(n - 1, i + r);
                int start = Math.max(0, pos - r);
                int end = Math.min(n - 1, pos + r);
                diff[start] += need;
                if (end + 1 <= n - 1) diff[end + 1] -= need;
                // reflect immediate effect on windowAdd (since i >= start always here)
                windowAdd += need;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] stations1 = {1, 2, 4, 5, 0};
        int r1 = 1, k1 = 2;
        System.out.println(maxPower(stations1,r1,k1));
    }
}

