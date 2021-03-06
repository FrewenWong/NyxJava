package com.frewen.algorithm.demo.binarytree;

import com.frewen.algorithm.demo.binarytree.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTest {

    public static void main(String[] args) {

        TreeNode<String> binaryTreeNode = initBinaryTree();

        /**
         * 递归先序遍历
         */
        System.out.print("递归先序遍历：");
        recursionPreOrderTraversal(binaryTreeNode);
        System.out.println(" ");

        System.out.print("递归中序遍历：");
        recursionMiddleOrderTraversal(binaryTreeNode);
        System.out.println(" ");

        System.out.print("递归后序遍历：");
        recursionPostOrderTraversal(binaryTreeNode);
        System.out.println(" ");

        System.out.print("非递归先序遍历：");
        List<String> preOrderTraversalResult = preOrderTraversal(binaryTreeNode);
        System.out.println(" ");
        System.out.println("非递归中序遍历的结果集大小：" + preOrderTraversalResult.size());
        // List的toString方法可以把所有的元素打印处理
        System.out.println("非递归中序遍历的结果集：" + preOrderTraversalResult.toString());
        System.out.println(" ");

        System.out.print("非递归中序遍历：");
        middleorderTraversal(binaryTreeNode);
        System.out.println(" ");

        System.out.print("非递归后序遍历：");
        postorderTraversal(binaryTreeNode);
        System.out.println(" ");


        // 计算二叉树的深度算法
        int depth = maxDepth(binaryTreeNode);
        System.out.println("BinaryTreeTest.maxDepth = " + depth);

    }


    /**
     * 计算二叉树的深度：思考：可以考虑记录. 可以使用递归算法
     *
     * @param binaryTreeNode
     */
    private static int maxDepth(TreeNode<String> binaryTreeNode) {
        //其实可以考虑二叉树的遍历的相关操作。使用递归算法
        if (null == binaryTreeNode) {
            return 0;
        } else {
            return Math.max(maxDepth(binaryTreeNode.getLeftNode()), maxDepth(binaryTreeNode.getRightNode())) + 1;
        }
    }


    /**
     *         A
     *      /       \
     *    B          C
     *  /  \      /   \
     * D   E     F    G
     *    / \     \   /
     *   H   I    J  P
     * <p>
     * 我们分析一下：
     * <p>
     * 先序遍历：A、B、D、E、H、I、C、F、J、G、P
     * 中序遍历：D、B、H、E、I、A、F、J、C、P、G
     * 后序遍历：D、H、I、E、B、J、F、P、G、C、A
     *
     * @return
     */
    private static TreeNode<String> initBinaryTree() {
        TreeNode<String> D = new TreeNode<String>("D", null, null);
        TreeNode<String> H = new TreeNode<String>("H", null, null);
        TreeNode<String> I = new TreeNode<String>("I", null, null);
        TreeNode<String> J = new TreeNode<String>("J", null, null);
        TreeNode<String> P = new TreeNode<String>("P", null, null);
        TreeNode<String> G = new TreeNode<String>("G", P, null);
        TreeNode<String> F = new TreeNode<String>("F", null, J);
        TreeNode<String> E = new TreeNode<String>("E", H, I);
        TreeNode<String> B = new TreeNode<String>("B", D, E);
        TreeNode<String> C = new TreeNode<String>("C", F, G);
        TreeNode<String> A = new TreeNode<String>("A", B, C);
        return A;
    }


    /**
     * 先序遍历：考察到一个节点后，即刻输出该节点的值，并继续遍历其左右子树。(即遍历顺序：根左右)
     *
     * @param binaryTreeNode
     */
    private static void recursionPreOrderTraversal(TreeNode<String> binaryTreeNode) {
        if (null != binaryTreeNode) {
            System.out.print(binaryTreeNode.getValue() + " ");
            recursionPreOrderTraversal(binaryTreeNode.getLeftNode());
            recursionPreOrderTraversal(binaryTreeNode.getRightNode());
        }
    }

    /**
     * 中序：考察到一个节点后，将其暂存，遍历完左子树后，再输出该节点的值，然后遍历右子树。(左根右)
     *
     * @param root
     */
    public static void recursionMiddleOrderTraversal(TreeNode root) {
        if (root != null) {
            recursionMiddleOrderTraversal(root.getLeftNode());
            System.out.print(root.getValue() + " ");
            recursionMiddleOrderTraversal(root.getRightNode());
        }
    }

    /**
     * 后序：考察到一个节点后，将其暂存，遍历完左右子树后，再输出该节点的值。(左右根)
     *
     * @param root
     */
    public static void recursionPostOrderTraversal(TreeNode root) {
        if (root != null) {
            recursionPostOrderTraversal(root.getLeftNode());
            recursionPostOrderTraversal(root.getRightNode());
            System.out.print(root.getValue() + " ");
        }
    }

    /**
     * 非递归先序遍历
     *
     * @param binaryTreeNode
     */
    private static List<String> preOrderTraversal(TreeNode<String> binaryTreeNode) {
        // 用来暂存节点的栈
        Stack<TreeNode> binaryTreeNodeStack = new Stack<TreeNode>();
        // 用来储存结果的list
        List<String> result = new ArrayList<>();

        // 新建一个游标节点为根节点
        TreeNode<String> node = binaryTreeNode;
        // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
        // 所以，只要不同时满足这两点，都需要进入循环
        while (null != node || !binaryTreeNodeStack.isEmpty()) {
            // 若当前考查节点非空，则输出该节点的值
            // 由考查顺序得知，需要一直往左走
            while (node != null) {
                // 非递归的先序遍历，则需要首先打印出根节点数据。
                System.out.print(node.getValue() + " ");
                result.add(node.getValue());
                // 为了之后能找到该节点的右子树，暂存该节点。
                binaryTreeNodeStack.push(node);
                // 然后将游标节点设置为此根节点的左子树的节点
                node = node.getLeftNode();
            }

            // 一直到左子树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑
            // 弹出栈顶元素，将游标等于该节点的右子树
            if (!binaryTreeNodeStack.isEmpty()) {
                // 直到上面的左子树的节点都遍历完毕之后，将栈中的存储的节点pop出来
                node = binaryTreeNodeStack.pop();
                // 然后同理，开始遍历右子树
                node = node.getRightNode();
            }
        }

        return result;
    }

    public static void middleorderTraversal(TreeNode root) {
        // 我们创建一个结果的list对象
        List<String> result = new ArrayList<>();
        // 这是我们创建的存放临时节点的栈
        Stack<TreeNode> binaryTreeNodeStack = new Stack<>();
        // 使用来便利的这个当前二叉树的对象
        TreeNode node = root;
        // 当这个二叉树不为null 并且或者栈的数据不为空
        while (node != null || !binaryTreeNodeStack.isEmpty()) {
            // 当这个栈的节点不为null
            while (node != null) {
                // 我们把当前的节点入栈
                binaryTreeNodeStack.push(node);
                // 然后便利他的左子树
                node = node.getLeftNode();
                // 然后始终循环执行，其实就是我们需要一直找到最深的左子树。知道住哪也找不到左子树了。
            }
            // 然后这个时候我们开始从栈里面曲数据
            if (!binaryTreeNodeStack.isEmpty()) {
                // 取出一个二叉树的节点。这个就是应该是他的左子树
                node = binaryTreeNodeStack.pop();
                System.out.print(node.getValue() + " ");
                result.add(root.getValue() + "");
                // 然后再取出右子树的节点。然后右侧为空，则继续pop根节点，如果不是则
                node = node.getRightNode();
            }
        }
    }

    public static void postorderTraversal(TreeNode root) {
        Stack<TreeNode> binaryTreeNodeStack = new Stack<>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while (node != null || !binaryTreeNodeStack.isEmpty()) {
            while (node != null) {
                binaryTreeNodeStack.push(node);
                node = node.getLeftNode();
            }
            //查看当前栈顶元素
            node = binaryTreeNodeStack.peek();
            //如果其右子树也为空，或者右子树已经访问
            //则可以直接输出当前节点的值
            if (node.getRightNode() == null || node.getRightNode() == lastVisit) {
                System.out.print(node.getValue() + " ");
                binaryTreeNodeStack.pop();
                lastVisit = node;
                node = null;
            } else {
                //否则，继续遍历右子树
                node = node.getRightNode();
            }
        }
    }

}
