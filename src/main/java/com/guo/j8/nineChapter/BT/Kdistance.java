package com.guo.j8.nineChapter.BT;

import java.util.List;

/***
 * Given a root of a tree, and an integer k. Print all the nodes which are at k
 * distance from root.
 *
 * For example, in the below tree, 4, 5 & 8 are at distance 2 from root.
 *
 * 1 / \ 2 3 / \ / 4 5 8
 */
public class Kdistance {

	// search the root and list K distance node values
	public int printkdistanceNode(TreeNode node, TreeNode target, int k) {

		// Base Case 1: If tree is empty, return -1
		if (node == null)
			return -1;

		// If target is same as root. Use the downward function
		// to print all nodes at distance k in subtree rooted with
		// target or root
		if (node == target) {
			printkdistanceNodeDown(node, k);
			return 0;
		}

		// Recur for left subtree
		int dl = printkdistanceNode(node.left, target, k);

		// Check if target node was found in left subtree
		if (dl != -1) {

			// If root is at distance k from target, print root
			// Note that dl is Distance of root's left child from
			// target
			if (dl + 1 == k) {
				System.out.print(node.val);
				System.out.println("");
			}

			// Else go to right subtree and print all k-dl-2 distant nodes
			// Note that the right child is 2 edges away from left child
			else
				printkdistanceNodeDown(node.right, k - dl - 2);

			// Add 1 to the distance and return value for parent calls
			return 1 + dl;
		}

		// MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
		// Note that we reach here only when node was not found in left
		// subtree
		int dr = printkdistanceNode(node.right, target, k);
		if (dr != -1) {
			if (dr + 1 == k) {
				System.out.print(node.val);
				System.out.println("");
			} else
				printkdistanceNodeDown(node.left, k - dr - 2);
			return 1 + dr;
		}

		// If target was neither present in left nor in right subtree
		return -1;
	}

	private void printkdistanceNodeDown(TreeNode node, int k) {
		// Base Case
		if (node == null || k < 0)
			return;

		// If we reach a k distant node, print it
		if (k == 0) {
			System.out.print(node.val);
			System.out.println("");
			return;
		}

		// Recur for left and right subtrees
		printkdistanceNodeDown(node.left, k - 1);
		printkdistanceNodeDown(node.right, k - 1);
	}

}
