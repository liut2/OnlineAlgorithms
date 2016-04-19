/*
* A linked list is given such that each node contains an additional random pointer
* which could point to any node in the list or null.
* Return a deep copy of the list.
*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 //comment：一看是clone或者copy的问题，就很自然的会想到HashTable
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // edge case
        if (head == null) {
            return null;
        }
        // pre-process
        RandomListNode newHead = new RandomListNode(head.label);
        newHead.random = head.random;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        map.put(head, newHead);
        // fisrt pass
        RandomListNode cur = newHead;
        head = head.next;
        //cur = cur.next;
        while (head != null) {
            cur.next = new RandomListNode(head.label);
            cur.next.random = head.random;
            map.put(head, cur.next);
            head = head.next;
            cur = cur.next;
        }
        // second pass
        cur = newHead;
        while (cur != null) {
            cur.random = map.get(cur.random);
            cur = cur.next;
        }
        return newHead;
    }
}
