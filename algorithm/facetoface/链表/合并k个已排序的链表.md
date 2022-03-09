```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.*;
public class Solution {
        //合并K个有序链表的方法
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        return mergeList(lists,0,lists.size()-1);
    }
    public ListNode mergeList(ArrayList<ListNode> lists,int left,int right){
        if(left==right) return lists.get(left);
        if(left>right) return null;
        int mid=left+(right-left)/2;
        return merge(mergeList(lists,left,mid),mergeList(lists,mid+1,right));
    }
        //合并两个有序链表（和力扣的21题一样）
    public ListNode merge(ListNode l1,ListNode l2){
        if(l1==null)return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val) {
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }
}
```