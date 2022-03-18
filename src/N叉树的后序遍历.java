import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * 力扣 590 N叉树的后序遍历
 */
public class N叉树的后序遍历 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) return list;
        post(root);
        return list;
    }

    public void post(Node root) {
        if (root == null) return;
        List<Node> children = root.children;
        for (Node node : children) {
            post(node);
        }
        list.add(root.val);
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
