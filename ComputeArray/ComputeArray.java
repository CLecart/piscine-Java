public class ComputeArray {
    public static int[] computeArray(int[] array) {
        if (array == null) {
            return null;
        }

        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            int mod = value % 3;

            if (mod == 0) {
                result[i] = value * 5;
            } else if (mod == 1) {
                result[i] = value + 7;
            } else {
                result[i] = value;
            }
        }
        return result;
    }
}
