package wr.leetcode.algo.Facebook;

/**
 * Q2: Given set of points in 2d grid space. Find a grid point such that sum
 of distance from all the points to this common point is minimum.

 eg: p1: [0, 0] p2: [3, 0] p3: [0, 3]

 ans: r: [0,0]

 sum: 0 + 3 + 3 = 6

 for every other point sum to this ans greater than 6.

 //
 */
 // end up being finding median of x/y separately
 // If there is weight, need numerical methods to iteratively
 // converge similarly with binary search.