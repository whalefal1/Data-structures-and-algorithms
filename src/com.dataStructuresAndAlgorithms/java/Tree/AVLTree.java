package Tree;


public class AVLTree {

    /**
     * AVL树节点
     * 包含一个高度height属性，表示节点高度
     *
     * @author 李朋逊
     * @date 2023/10/26
     */
    static class AVLNode {
        int key;
        Object value;
        AVLNode left;
        AVLNode right;
        int height = 1;

        public AVLNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public AVLNode(int key, Object value, AVLNode left, AVLNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public AVLNode(int key) {
            this.key = key;
        }

        /**
         * Description
         * 获取节点的高度
         *
         * @param node
         * @return int
         * @author 李朋逊
         * @date 2023/10/26
         */
        private int height(AVLNode node) {
            return node == null ? 0 : node.height;
        }

        /**
         * Description
         * 更新节点的高度
         *
         * @param node
         * @author 李朋逊
         * @date 2023/10/26
         */
        private void updateHeight(AVLNode node) {
            node.height = Integer.max(height(node.left), height(node.right)) + 1;
        }

        //平衡因子(balance factor) = 左子树高度 - 右子树高度
        private int bt(AVLNode node) {
            return height(node.left) - height(node.right);
        }

        //0 1 -1 表示节点平衡
        //>1 <-1  表示不平衡，需要旋转

        //参数：要旋转的节点
        //返回值：新的根节点
        private AVLNode rightRotate(AVLNode node) {
            AVLNode left = node.left;
            AVLNode leftRight = left.right;
            left.right = node;        //上位，注意顺序不能调换
            node.left = leftRight; // 换爹
            updateHeight(node); // 更新高度
            updateHeight(left); // 注意更新节点高度的顺序
            return left;
        }


        private AVLNode leftRotate(AVLNode node) {
            AVLNode right = node.right;
            AVLNode rightLeft = right.left;
            right.left = node;
            node.right = rightLeft;
            updateHeight(node);
            updateHeight(right);
            return right;
        }

        //失衡节点的左子树左旋，再对失衡节点右旋
        private AVLNode leftRightRotate(AVLNode node) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        private AVLNode rightLeftRotate(AVLNode node) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        //判断节点是否平衡：平衡因子是否在-1 0 1之间
        private AVLNode balance(AVLNode node){
            if(node == null){
                return null;
            }
            int bf = bt(node);
            if(bf>1 && bt(node.left) > 0){ //LL
                return rightRotate(node);
            } else if (bf > 1 && bt(node.left) < 0) {//LR
                return leftRightRotate(node);
            }else if (bf < -1 && bt(node.right) < 0) {//RR
                return leftRotate(node);
            }else if (bf < -1 && bt(node.right) > 0) {//RL
                return rightLeftRotate(node);
            }
            return node;
        }
    }
}
