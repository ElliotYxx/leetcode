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
            printArr(nums);

        }
    }


    /**
     * 插入排序 类似打牌  每次选择最小的插入到前面，后面的都顺序后移一位
     * @param nums
     */
    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > curr) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = curr;
            System.out.println("第" + i + "次插入排序");
            printArr(nums);
        }
    }


    /**
     * 选择排序 每次选择第i个后最小的数字进行交换
     * @param nums
     */
    public static void selectSort(int[] nums) {
        
        // 记录最小元素的下标
        int minIndex;

        for (int i = 0; i < nums.length - 1; i++) {
            // 记录最小值的下标
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = tmp;
            System.out.println("第" + (i + 1) + "次选择排序");
            printArr(nums);
        }
    }

    public static void printArr(int[] nums) {
        
        for (int k = 0; k < nums.length; k++) {
            System.out.print(nums[k] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 6, 5, 3, 8, 4 };
        selectSort(arr);
    }
}