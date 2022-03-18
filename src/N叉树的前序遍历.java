import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 * 力扣 589 N叉树的前序遍历
 */
public class N叉树的前序遍历 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) return list;
        pre(root);
        return list;
    }

    public void pre(Node root) {
        if (root == null) return;
        list.add(root.val);
        List<Node> children = root.children;
        for (Node node : children) {
            pre(node);
        }
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
