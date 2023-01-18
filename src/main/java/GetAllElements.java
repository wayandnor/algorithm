
/**
 * 给你 root1 和 root2 这两棵二叉搜索树。
 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。
*/

import java.util.ArrayList;
import java.util.List;

public class GetAllElements {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        walkTree(root1, list1);
        walkTree(root2, list2);
        List<Integer> resultList = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        int len1 = list1.size();
        int len2 = list2.size();

        int v1;
        int v2;

        while (true) {
            if (index1 == len1) {
                resultList.addAll(list2.subList(index2, len2));
                break;
            }
            if (index2 == len2) {
                resultList.addAll(list1.subList(index1, len1));
                break;
            }

            v1 = list1.get(index1);
            v2 = list2.get(index2);

            if (v1 < v2) {
                resultList.add(v1);
                index1++;
            } else if (v1 > v2) {
                resultList.add(v2);
                index2++;
            } else {
                resultList.add(v1);
                resultList.add(v2);
                index1++;
                index2++;
            }
        }

        return resultList;
    }

    public static void walkTree(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        walkTree(node.left, list);
        list.add(node.val);
        walkTree(node.right, list);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
