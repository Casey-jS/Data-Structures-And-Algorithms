import fileinput
class Node:
    def __init__(self, val):
        self.left = None
        self.right = None
        self.value = val

def insert(root, node):
    
    if root is None:
        return
    else:
        if root.value > node.value:
            if root.left is None:
                root.left = node
            else:
                insert(root.left, node)
        else:
            if root.right is None:
                root.right = node
            else:
                insert(root.right, node)
                
def is_leaf(node): return (node.right is None and node.left is None)

def print_leaves_and_ancestors(root, lst=[]):

    if root is not None:
        if is_leaf(root):
            print("Leaf: " + str(root.value), end=' ')
            print("Ancestors: ", end='')
            for node in lst:
                print(node, end=' ')
            print('') # for output formatting
        else:
            if root.value not in lst:
                lst.append(root.value)
            print_leaves_and_ancestors(root.left, lst)
            print_leaves_and_ancestors(root.right, lst)
            if len(lst) != 0:
                lst.remove(root.value)
            
def main():

    first_found = False # Separates the first node individually as the root
    for line in fileinput.input():
        if not first_found:
            root = Node(int(line))
            first_found = True
        new_node = Node(int(line))
        insert(root, new_node)

    print_leaves_and_ancestors(root)    

main()



