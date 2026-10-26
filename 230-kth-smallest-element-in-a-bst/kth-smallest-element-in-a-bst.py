# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def inorder(self, root: TreeNode | None, l : list) -> list:
        if not root :
            return l

        self.inorder(root.left, l)
        l.append(root.val)
        self.inorder(root.right, l)

        return l

    def kthSmallest(self, root: TreeNode | None, k: int) -> int:
        l = list()
        self.inorder(root, l)

        return l[k - 1]

        