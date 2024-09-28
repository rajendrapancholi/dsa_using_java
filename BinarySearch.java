public class BinarySearch {
    public static int[] arr = { 2, 4, 5, 7, 8, 12, 14, 17, 19, 22, 25, 27, 28, 33, 37 };

    public static boolean seach(int[] data, int target, int low, int high) {
        if (low > high) {
            System.out.println("hello");
            return false;
        } else {
            // int mid = (int) Math.floor((low + high) / 2);
            int mid = (low + high) / 2;
            if (target == mid) {
                return true;
            } else if (target < data[mid]) {
                return seach(data, target, low, mid - 1);
            } else {
                return seach(data, target, mid + 1, high);
            }
        }
    }

    public static void main(String[] args) {
        boolean v = seach(arr, 25, 17, 33);
        System.out.println(v);
        // System.out.println(arr[13]);
        // System.out.println((9 + 20) / 2);
        // System.out.println((int) Math.floor((9 + 20) / 2));
    }
}