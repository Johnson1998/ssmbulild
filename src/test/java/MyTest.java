import com.john.pojo.Books;
import com.john.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

/**
 * @author John
 * @create 2021-10-2210:07
 */
public class MyTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = (BookService) context.getBean("BookServiceImpl");
//        for(Books books:bookServiceImpl.queryAllBook()){
//            System.out.println(books);
//        }
        System.out.println(bookServiceImpl.queryBookById(1));
//        Books books= new Books(12, "书", 1,"dsa");
//        bookServiceImpl.addBook(books);

    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[left] < nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    @Test
    public void test2() {
        int[] nums = {3, 1};
        int target = 1;
        System.out.println(search(nums, target));
        ;
    }

    @Test
    public void test3() {
        int[] nums = {2, 2};
        int target = 3;
        searchRange(nums, 3);
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        } else if (nums.length == 1 && nums[0] == target) {
            return new int[]{0, 0};
        }
        int left = index(nums, target);
        int right = index(nums, target + 1) - 1;
        if (nums[left] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }

    public int index(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left < right) {
            if (nums[left] == target) {
                return left;
            }
            mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    @Test
    public void minSubArrayLen() {
        int target = 7;
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int right;
        int result = 0;
        int ans = Integer.MAX_VALUE;
        for (right = 0; right < nums.length; right++) {
            int left = 0;
            result += nums[right];
            while (result >= target && left < right) {
                ans = Math.min(right - left + 1, ans);
                result -= nums[left];
                left++;
            }
        }
//        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


//    @Test
//    public void smallArray(){
//        minSubArrayLen(7, new int[] {2,3,1,2,4,3});
//    }
//    }


    @Test
    public void generateMatrix() {
        int n = 3;
        int[][] res = new int[n][n];
        int loop = n / 2 + n % 2;
        int row = 0, col = 0;
        int start = 1;
        int offset = 0;
        while(loop > 0){

            // 右
            for (int i = 0;  i < n - offset; i++) {
                res[row][col] = start;
                ++col;
                start++;
            }
            row++;
            offset++;

            // 下
            for(int i = 0;  i < n - offset; i++) {
                res[row][col] = start;
                row++;
                start++;
            }
            col--;

            // 左
            for(int i = 0;  i < n - offset; i++) {
                res[row][col] = start;
                col--;
                start++;
            }
            row--;
            offset++;

            // 上
            for (int i = 0;  i < n - offset; i++) {
                res[row][col] = start;
                row--;
                start++;
            }
            col++;
            offset++;
            loop--;
        }
    }
    
    
    
//    public void test(){
//        int matrix[][] = {{1,2,3}, {4,5,6}, {7,8,9}};
//        // 边界
//        int right = matrix[0].length;
//        int down  = matrix.length;
////        int up, left = 0;
//        int row = 0, col = 0;
//        int loop = down / 2 + down % 2;
//        List resList = new ArrayList<Integer>();
//        while(loop > 0) {
//            // 右
//            for (;col < right; col++) {
//                resList.add(matrix[row][col]);
//            }
//            col--;
//            row++;
////            up++;
//
//            // 下
//            for (;row < down; row++){
//                resList.add(matrix[row][col]);
//            }
//            row--;
//            col--;
//            right--;
//
//
//            // 左
//            for (;col >= left; col--) {
//                resList.add(matrix[row][col]);
//            }
//            col++;
//            row--;
//            down--;
//
//            // 上
//            for (; row >= up; row--){
//                resList.add(matrix[row][col]);
//            }
//            row++;
//            col++;
//            left++;
//
//            loop--;
//        }
//    }

    @Test
    public void testLink() {
        MyLinkedList list1 = new MyLinkedList();
        list1.addAtHead(1);
        list1.addAtTail(3);
        list1.addAtIndex(1,2);
    }

    }


class ListNode {

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }




}

class MyLinkedList {
    int size;
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(-1);
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        ListNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;

        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val, head.next);
        head.next = newNode;
        size++;
    }

    public void addAtTail(int val) {
        ListNode cur = head;
        while(cur.next != null) cur = cur.next;
        cur.next = new ListNode(val);
        size++;
    }

    public void addAtIndex(int index, int val) {
        ListNode cur = head;
        if (index <= 0){
            addAtHead(val);
            size++;
        }else if(index < size){
            for (int i = 0;i < index; i++) {
                cur = cur.next;
            }
            cur.next = new ListNode(val);
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if(index >= 0 && index < size){
            ListNode pre = head;
            ListNode cur = pre;
            for (int i = 0;i <index; i++) {
                pre = cur;
                cur = cur.next;
            }
            pre.next = cur.next;
            size--;

        }
    }
}