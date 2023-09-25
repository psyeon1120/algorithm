import sys

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def preorder(node):
    if node is None:
        return
    print(node.val, end='')
    if node.left:
        preorder(tree[node.left])
    if node.right:
        preorder(tree[node.right])


def inorder(node):
    if node is None:
        return
    if node.left:
        inorder(tree[node.left])
    print(node.val, end='')
    if node.right:
        inorder(tree[node.right])


def postorder(node):
    if node is None:
        return
    if node.left:
        postorder(tree[node.left])
    if node.right:
        postorder(tree[node.right])
    print(node.val, end='')


num = int(sys.stdin.readline())
tree = dict()
for _ in range(num):
    val, left, right = input().split()
    if left == '.':
        left = None
    if right == '.':
        right = None
    tree[val] = Node(val, left, right)

preorder(tree['A'])
print()
inorder(tree['A'])
print()
postorder(tree['A'])