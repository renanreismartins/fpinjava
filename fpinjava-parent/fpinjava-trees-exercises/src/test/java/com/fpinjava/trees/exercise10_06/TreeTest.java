package com.fpinjava.trees.exercise10_06;

import org.junit.Test;

import static org.junit.Assert.*;


public class TreeTest {

  @Test
  public void testRemoveLower() {
    Tree<Integer> tree = Tree.tree(4, 2, 1, 3, 6, 5, 7);
    assertEquals("(T (T E 1 (T E 3 E)) 4 (T (T E 5 E) 6 (T E 7 E)))", tree.remove(2).toString());
  }

  @Test
  public void testRemoveEquals() {
    Tree<Integer> tree = Tree.tree(4, 2, 1, 3, 6, 5, 7);
    System.out.println(tree);
    assertEquals("(T (T E 1 E) 2 (T E 3 (T (T E 5 E) 6 (T E 7 E))))", tree.remove(4).toString());
  }

  @Test
  public void testRemoveHigher() {
    Tree<Integer> tree = Tree.tree(4, 2, 1, 3, 6, 5, 7);
    assertEquals("(T (T (T E 1 E) 2 (T E 3 E)) 4 (T E 5 (T E 7 E)))", tree.remove(6).toString());
  }

  @Test
  public void testRemoveEmpty() {
    Tree<Integer> tree = Tree.tree();
    assertEquals("E", tree.remove(6).toString());
  }


  // my tests to help on the alg.
  @Test
  public void removeSingleElement() {
    Tree<Integer> tree = Tree.<Integer>empty().insert(4);
    assertEquals("E", tree.remove(4).toString());
  }

  @Test
  public void removeRightLeaf() {
    Tree<Integer> tree = Tree.<Integer>empty().insert(4).insert(2).insert(5);
    assertEquals("(T (T E 2 E) 4 E)", tree.remove(5).toString());
  }

  @Test
  public void removeRightElementWithOneChild() {
    Tree<Integer> tree = Tree.<Integer>empty().insert(4).insert(2).insert(5).insert(6);
    assertEquals("(T (T E 2 E) 4 (T E 6 E))", tree.remove(5).toString());
  }

  @Test
  public void removeRightElementWithTwoChildren() {
    Tree<Integer> tree = Tree.<Integer>empty().insert(7).insert(1).insert(9).insert(10).insert(8);
    assertEquals("(T (T E 1 E) 7 (T E 8 (T E 10 E)))", tree.remove(9).toString());
  }

  @Test
  public void removeLeftLeaf() {
    Tree<Integer> tree = Tree.<Integer>empty().insert(4).insert(2).insert(5);
    assertEquals("(T E 4 (T E 5 E))", tree.remove(2).toString());
  }

  @Test
  public void removeLeftElementWithOneChild() {
    Tree<Integer> tree = Tree.<Integer>empty().insert(4).insert(2).insert(1).insert(5);
    assertEquals("(T (T E 1 E) 4 (T E 5 E))", tree.remove(2).toString());
  }
}
