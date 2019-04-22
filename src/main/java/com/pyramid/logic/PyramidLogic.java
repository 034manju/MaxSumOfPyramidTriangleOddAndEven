/*
 * Copyright (c) Manjunath Menashinakai. All Rights Reserved.
 *
 * This program is the information assets which are handled
 * as "Strictly Confidential".
 * Permission of use is only admitted to Manjunath Menashinakai.
 * If you don't have permission, MUST not be published,
 * broadcast, rewritten for broadcast or publication
 * or redistributed directly or indirectly in any medium.
 *
 * $ Manjunath Menashinakai $
 */

package com.pyramid.logic;

import static com.pyramid.logic.IntegerConstants.ONE;
import static com.pyramid.logic.IntegerConstants.TWO;
import static com.pyramid.logic.IntegerConstants.ZERO;

import java.util.Arrays;

/**
 * Logic class to find maximum sum of triangle hierarchy evens and odds
 * 
 * @author manjunath.m
 *
 */
public class PyramidLogic {

	/**
	 * Function for finding maximum sum of triangle hierarchy evens and odds
	 * subsequently
	 *   
	 * @param inputTriangle
	 * @param maxRowLength
	 * @param maxColumnLength
	 * @return
	 */
	public int maxPathSumOddEven(int inputTriangle[][], int maxRowLength, int maxColumnLength) {
		// copying the triangle data to result
		int result[][] = cloneArray(inputTriangle, maxRowLength, maxColumnLength);
		// loop for bottom-up calculation
		for (int i = maxRowLength - ONE; i >= ZERO; i--) {
			for (int j = ZERO; j <= i; j++) {
				boolean isLeftNodeOddOrEvenWithRootNode = areNumbersEvenOddSubsequently(inputTriangle[i][j], inputTriangle[i + ONE][j]);
				boolean isRightNodeOddOrEvenWithRootNode = areNumbersEvenOddSubsequently(inputTriangle[i][j] , inputTriangle[i + ONE][j + ONE]);
				if (isLeftNodeOddOrEvenWithRootNode && isRightNodeOddOrEvenWithRootNode) {
					if (result[i + ONE][j] > result[i + ONE][j + ONE])
						result[i][j] += result[i + ONE][j];
					else
						result[i][j] += result[i + ONE][j + ONE];
				} else if (isLeftNodeOddOrEvenWithRootNode) {
					result[i][j] += result[i + ONE][j];
				} else if (isRightNodeOddOrEvenWithRootNode) {
					result[i][j] += result[i + ONE][j + ONE];
				}

			}

		}
		return result[ZERO][ZERO];
	}
	
	/**
	 * 
	 * @param rootNodeData
	 * @param childNodeData
	 * @return boolean provides whether root node and child node are even and odd subsequently .
	 */
	private boolean areNumbersEvenOddSubsequently(int rootNodeData, int childNodeData) {
		return rootNodeData % TWO != childNodeData % TWO;
	}

	/**
	 * Clones the provided array
	 * 
	 * @param triangle
	 * @param maxRowLength
	 * @param maxColumnLength
	 * @return a new clone of the provided array
	 */
	private int[][] cloneArray(int[][] triangle, int maxRowLength, int maxColumnLength) {
		return Arrays.stream(triangle).map(row -> row.clone()).toArray(int[][]::new);
	}

}
