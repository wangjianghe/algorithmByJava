#1 链表中的节点每k个一组翻转
##1.1非递归方式
```java
    public ListNode reverseKGroup(ListNode head, int k) {
        //先创建一个哑节点
        ListNode dummy = new ListNode(0);
        //让哑节点的指针指向链表的头
        dummy.next = head;
        //开始反转的前一个节点，比如反转的节点范围是[link1，link2],
        //那么pre就是link1的前一个节点
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            //每k个反转，end是每k个链表的最后一个
            for (int i = 0; i < k && end != null; i++)
                end = end.next;
            //如果end是空，说明不够k个，就不需要反转了，直接退出循环。
            if (end == null)
                break;
            //反转开始的节点
            ListNode start = pre.next;
            //next是下一次反转的头结点，先把他记录下来
            ListNode next = end.next;
            //因为end是这k个链表的最后一个结点，把它和原来链表断开，
            //这k个节点我们可以把他们看做一个小的链表，然后反转这个
            //小链表
            end.next = null;
            //因为pre是反转链表的前一个节点，我们把小链表[start,end]
            //反转之后，让pre的指针指向这个反转的小链表
            pre.next = reverse(start);
            //注意经过上一步反转之后，start反转到链表的尾部了，就是已经
            //反转之后的尾结点了，让他之前下一次反转的头结点即可（上面分析
            //过，next就是下一次反转的头结点）
            start.next = next;
            //前面反转完了，要进入下一波了，pre和end都有重新赋值
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    //链表的反转
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

```
##1.2 递归方式
```java
    public ListNode reverseKGroup(ListNode head, int k) {
        //边界条件判断
        if (head == null || head.next == null)
            return head;
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            //剩余数量小于k的话，则不需要反转。
            if (tail == null)
                return head;
            tail = tail.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(head, tail);
        //下一轮的开始的地方就是tail
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    /*
        链表的反转，不是反转全部，只反转区间[head,tail)中间的节点，左闭右开区间
     */
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode next = null;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

```