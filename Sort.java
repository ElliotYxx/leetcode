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
     * 插入排序 类似打牌 每次选择最小的插入到前面，后面的都顺序后移一位
     * 
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
     * 
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

    /**
     * 归并排序
     * 时间复杂度O(nlogN) 每层n次，会分成logN+1层
     * 空间复杂度O(N)
     * 
     * @param nums
     */
    public static void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) >> 1;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, mid, left, right);
        }

    }

    public static void merge(int[] nums, int mid, int left, int right) {
        // 临时数组 存储排序后的数
        int[] temp = new int[right - left + 1];
        // 临时数组的下标
        int index = 0;
        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            temp[index++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        // 把剩余的数组添加到临时数组中
        while (i <= mid) {
            temp[index++] = nums[i++];
        }
        while (j <= right) {
            temp[index++] = nums[j++];
        }
        // 下标重新恢复到0进行幅值
        index = 0;
        // 将临时数组里面的值赋值到原数组中
        for (int k = left; k <= right; k++) {
            nums[k] = temp[index++];
        }
    }

    /**
     * 快速排序 不稳定
     * 利用partition分治思想
     * 通过一趟排序将待排记录分割成两部分，其中一部分记录的关键字均比另一部分的小，则可分别对这两部分记录进行排序，以达到整个序列有序的目的
     * 时间复杂度 O(nlogn) 最差情况O(n^2)
     * 空间复杂度 O(logn)
     * 
     * @param
     */
    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        if (lo < hi) {
            int mid = partition(arr, lo, hi);
            // 划分左半区
            quickSort(arr, lo, mid - 1);
            // 划分右边区
            quickSort(arr, mid + 1, hi);
        }
    }

    public static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int index = lo;
        for (int j = lo; j <= hi; j++) {
            // 比pivot小的 全部放到前面
            if (arr[j] < pivot) {
                swap(arr, j, index++);
            }
        }
        // 此时i指向的元素一定大于等于pivot
        swap(arr, hi, index);
        return index;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public void quickSort2(int[] a, int low, int high) {
        if (low >= high)
            return;
        // 设置这两个变量的目的是为了保持low和high不变
        int i = low, j = high;
        // 基准数
        int pivotNum = a[i];
        while (i < j) {
            // 循环结束的条件有二：一是找到比支点小的数，二是j==i
            while (a[j] >= pivotNum && j > i) {
                j--;
            }
            // 由于上面循环结束的功能性有两个，对于找到比支点小的数，即j!=i，要进行位置的交换，下同
            if (j > i) {
                a[i] = a[j];
                i++;
            }
            while (a[i] < pivotNum && i < j) {
                i++;
            }
            if (i < j) {
                a[j] = a[i];
                j--;
            }
        }
        a[i] = pivotNum;
        quickSort2(a, low, i - 1);
        quickSort2(a, i + 1, high);
    }

    public static void printArr(int[] nums) {

        for (int k = 0; k < nums.length; k++) {
            System.out.print(nums[k] + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 6, 5, 3, 8, 4 };
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}