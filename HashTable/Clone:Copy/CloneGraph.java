/*
* Clone an undirected graph. Each node in the graph contains a label and
* a list of its neighbors.
*/
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
 //comment: 一看到clone，很自然的就想到HashTable, 然后一看graph traversal，很自然的就想到BFS ＋ HashSet
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // edge case
        if (node == null) {
            return null;
        }
        // pre-process
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        set.add(node);
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        map.put(node, new UndirectedGraphNode(node.label));
        // main
        UndirectedGraphNode cur = node;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                UndirectedGraphNode newCur = map.get(cur);
                for (int j = 0; j < cur.neighbors.size(); j++) {
                    if (!set.contains(cur.neighbors.get(j))) {
                        queue.offer(cur.neighbors.get(j));
                        set.add(cur.neighbors.get(j));
                        map.put(cur.neighbors.get(j), new UndirectedGraphNode(cur.neighbors.get(j).label));
                    }
                    newCur.neighbors.add(map.get(cur.neighbors.get(j)));
                }
            }
        }
        return map.get(node);
    }
}
