/**
 * 用于记录各种排序算法的实现
 */
class Sort {

    /**
     * 冒泡排序 时间复杂度 O(n^2)
     * 每一次冒泡都把最大的数放到最后面 以此类推
     */
    public static void bubbleSort(int[] nums) {
        // 记录冒泡的次数
        for (int i = 0; i < nums.length - 1; i++) {
            // 记录本次冒泡是否是有序的
            boolean isSorted = true;
            for (int j = 0; j < nums.length - i - 1; j++) {
                // 如果在某次循环中 没有进行冒泡 则说明该数组已经有序 无序再冒泡 直接break
                if (nums[j] > nums[j + 1]) {
                    // 进行交换
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    isSorted = false;
                }
            }
            // 如果是有序的 直接break
            if (isSorted) {
                break;
            }
            System.out.println("第" + (i + 1) + "次冒泡");

            for (int k = 0; k < nums.length; k++) {
                System.out.print(nums[k] + " ");
            }
            System.out.println("");

        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 6, 5, 3, 8, 4 };
        bubbleSort(arr);
    }
}