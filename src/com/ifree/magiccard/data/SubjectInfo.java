package com.ifree.magiccard.data;

import com.ifree.magiccard.logical.ImageManager;

public class SubjectInfo {
    
	public static final int[][][] level1 =
		{
			{
				{3,8},{4,6}   
			},
			{
				{7,8,9},{8,8,8},{6,9,9}
			},
			{
				{1,3,8},{2,2,6},{2,3,4}
			},
			{
				{9,3,8},{8,2,6},{4,1,6}
			},
			{
				{7,3,6},{9,3,4},{8,5,8}
			},
			{
				{1,3,6},{4,4,3},{5,7,2}
			},
			{
				{7,4,4},{5,5,1},{3,9,3}
			},
			{
				{5,6,6},{4,8,8},{4,5,4}
			},
			{
				{3,7,3},{2,9,6},{3,5,9}
			}
			
		};
	public static final int[][][] level2 =
		{
			{
				{5,5,6,8},{2,8,5,9},{3,6,7,8}
			},
			{
				{9,9,1,7},{9,9,8,2},{9,9,9,3}
			},
			{
				{1,2,3,4},{2,2,2,3},{1,1,4,6}
			},
			{
				{2,6,8,4},{3,3,8,3},{3,5,8,5}
			},
			{
				{1,5,6,2},{1,2,5,3},{1,2,3,4}
			},
			{
				{3,7,4,1},{4,8,1,9},{4,5,5,1}
			},
			{
				{7,9,4,2},{7,4,3,3},{9,2,7,6}
			},
			{
				{2,7,6,8},{9,2,7,6},{5,4,3,4}
			},
			{
				{1,2,9,1},{2,4,9,5},{4,8,3,1}
			}
		
		};
	
	public static int[][] level_time = new int[][]
	{
		{
			160,170,180,190,200,210,220,230,240
		},
		{
			250,260,270,280,290,300,310,320,330
		}
	};
	
	public static float[][] level_hard = new float[][]{
		{
			1f,1.1f,1.2f,1.3f,1.4f,1.5f,1.6f,1.7f,1.8f
		},
		{
			3f,3.1f,3.2f,3.3f,3.4f,3.5f,3.6f,3.7f,3.8f
		}
	};
	
	public static int[][][][] solution_level1 = 
		{
			{ { { 3, 8 }, { ImageManager.MULTIPLY } },

			{ { 4, 6 }, { ImageManager.MULTIPLY } }

			},
			{
					{ { 7, 8 }, { 15, 9 },
							{ ImageManager.ADD, ImageManager.ADD } },
					{ { 8, 8 }, { 16, 8 },
							{ ImageManager.ADD, ImageManager.ADD } },
					{ { 6, 9 }, { 15, 9 },
							{ ImageManager.ADD, ImageManager.ADD } } },
			{
					{ { 1, 3 }, { 3, 8 },
							{ ImageManager.MULTIPLY, ImageManager.MULTIPLY } },
					{ { 2, 2 }, { 4, 6 },
							{ ImageManager.MULTIPLY, ImageManager.MULTIPLY } },
					{ { 2, 3 }, { 6, 4 },
							{ ImageManager.MULTIPLY, ImageManager.MULTIPLY } } },
			{
					{ { 9, 3 }, { 3, 8 },
							{ ImageManager.DIVIDE, ImageManager.MULTIPLY } },
					{ { 8, 2 }, { 4, 6 },
							{ ImageManager.DIVIDE, ImageManager.MULTIPLY } },
					{ { 4, 1 }, { 4, 6 },
							{ ImageManager.DIVIDE, ImageManager.MULTIPLY } } },
			{
					{ { 7, 3 }, { 4, 6 },
							{ ImageManager.DECREASE, ImageManager.MULTIPLY } },
					{ { 9, 3 }, { 6, 4 },
							{ ImageManager.DECREASE, ImageManager.MULTIPLY } },
					{ { 8, 5 }, { 3, 8 },
							{ ImageManager.DECREASE, ImageManager.MULTIPLY } } },
			{
					{ { 1, 3 }, { 4, 6 },
							{ ImageManager.ADD, ImageManager.MULTIPLY } },
					{ { 4, 4 }, { 3, 8 },
							{ ImageManager.ADD, ImageManager.MULTIPLY } },
					{ { 5, 7 }, { 2, 12 },
							{ ImageManager.ADD, ImageManager.MULTIPLY } } },
			{
					{ { 7, 4 }, { 28, 4 },
							{ ImageManager.MULTIPLY, ImageManager.DECREASE } },
					{ { 5, 5 }, { 25, 1 },
							{ ImageManager.MULTIPLY, ImageManager.DECREASE } },
					{ { 3, 9 }, { 27, 3 },
							{ ImageManager.MULTIPLY, ImageManager.DECREASE } } },
			{
					{ { 5, 6 }, { 30, 6 },
							{ ImageManager.MULTIPLY, ImageManager.DECREASE } },
					{ { 4, 8 }, { 32, 8 },
							{ ImageManager.MULTIPLY, ImageManager.DECREASE } },
					{ { 4, 5 }, { 20, 4 },
							{ ImageManager.MULTIPLY, ImageManager.ADD } } },
			{
					{ { 3, 7 }, { 21, 4 },
							{ ImageManager.MULTIPLY, ImageManager.ADD } },
					{ { 2, 9 }, { 18, 6 },
							{ ImageManager.MULTIPLY, ImageManager.ADD } },
					{ { 3, 5 }, { 15, 9 },
							{ ImageManager.MULTIPLY, ImageManager.ADD } } } };
	
	
	public static int[][][][] solution_level2 = {
			{
					{
							{ 5, 5 },
							{ 10, 6 },
							{ 16, 8 },
							{ ImageManager.ADD, ImageManager.ADD,
									ImageManager.ADD } },

					{
							{ 2, 8 },
							{ 10, 5 },
							{ 15, 9 },
							{ ImageManager.ADD, ImageManager.ADD,
									ImageManager.ADD } },
					{
							{ 3, 6 },
							{ 9, 7 },
							{ 16, 8 },
							{ ImageManager.ADD, ImageManager.ADD,
									ImageManager.ADD } }

			},
			{
					{
							{ 9, 9 },
							{ 18, 1 },
							{ 17, 7 },
							{ ImageManager.ADD, ImageManager.DECREASE,
									ImageManager.ADD } },
					{
							{ 9, 9 },
							{ 18, 8 },
							{ 26, 2 },
							{ ImageManager.ADD, ImageManager.ADD,
									ImageManager.DECREASE } },
					{
							{ 9, 9 },
							{ 18, 9 },
							{ 27, 3 },
							{ ImageManager.ADD, ImageManager.ADD,
									ImageManager.DECREASE } } },
			{
					{
							{ 1, 2 },
							{ 2, 3 },
							{ 6, 4 },
							{ ImageManager.MULTIPLY, ImageManager.MULTIPLY,
									ImageManager.MULTIPLY } },
					{
							{ 2, 2 },
							{ 4, 2 },
							{ 8, 3 },
							{ ImageManager.MULTIPLY, ImageManager.MULTIPLY,
									ImageManager.MULTIPLY } },
					{
							{ 1, 1 },
							{ 1, 4 },
							{ 6, 4 },
							{ ImageManager.MULTIPLY, ImageManager.MULTIPLY,
									ImageManager.MULTIPLY } } },
			{
					{
							{ 2, 6 },
							{ 12, 8 },
							{ 96, 4 },
							{ ImageManager.MULTIPLY, ImageManager.MULTIPLY,
									ImageManager.DIVIDE } },
					{
							{ 3, 3 },
							{ 9, 8 },
							{ 72, 3 },
							{ ImageManager.MULTIPLY, ImageManager.MULTIPLY,
									ImageManager.DIVIDE } },
					{
							{ 3, 5 },
							{ 15, 8 },
							{ 120, 5 },
							{ ImageManager.MULTIPLY, ImageManager.MULTIPLY,
									ImageManager.DIVIDE } } },
			{
					{
							{ 1, 5 },
							{ 6, 6 },
							{ 12, 2 },
							{ ImageManager.ADD, ImageManager.ADD,
									ImageManager.MULTIPLY } },
					{
							{ 1, 2 },
							{ 3, 5 },
							{ 8, 3 },
							{ ImageManager.ADD, ImageManager.ADD,
									ImageManager.MULTIPLY } },
					{
							{ 1, 2 },
							{ 3, 3 },
							{ 6, 4 },
							{ ImageManager.ADD, ImageManager.ADD,
									ImageManager.MULTIPLY } } },
			{
					{
							{ 3, 7 },
							{ 21, 4 },
							{ 25, 1 },
							{ ImageManager.MULTIPLY, ImageManager.ADD,
									ImageManager.DECREASE } },
					{
							{ 4, 8 },
							{ 32, 1 },
							{ 33, 9 },
							{ ImageManager.MULTIPLY, ImageManager.ADD,
									ImageManager.DECREASE } },
					{
							{ 4, 5 },
							{ 20, 5 },
							{ 25, 1 },
							{ ImageManager.MULTIPLY, ImageManager.ADD,
									ImageManager.DECREASE } } },
			{
					{
							{ 7, 9 },
							{ 16, 4 },
							{ 12, 2 },
							{ ImageManager.ADD, ImageManager.DECREASE,
									ImageManager.MULTIPLY } },
					{
							{ 7, 4 },
							{ 11, 3 },
							{ 8, 3 },
							{ ImageManager.ADD, ImageManager.DECREASE,
									ImageManager.MULTIPLY } },
					{
							{ 9, 2 },
							{ 11, 7 },
							{ 4, 6 },
							{ ImageManager.ADD, ImageManager.DECREASE,
									ImageManager.MULTIPLY } } },
			{
					{
							{ 2, 7 },
							{ 9, 6 },
							{ 3, 8 },
							{ ImageManager.ADD, ImageManager.DECREASE,
									ImageManager.MULTIPLY } },
					{
							{ 9, 2 },
							{ 11, 3 },
							{ 8, 3 },
							{ ImageManager.ADD, ImageManager.DECREASE,
									ImageManager.MULTIPLY } },
					{
							{ 5, 4 },
							{ 9, 3 },
							{ 6, 4 },
							{ ImageManager.ADD, ImageManager.DECREASE,
									ImageManager.MULTIPLY } } },
			{
					{
							{ 1, 2 },
							{ 9, 1 },
							{ 3, 8 },
							{ ImageManager.ADD, ImageManager.DECREASE,
									ImageManager.MULTIPLY } },
					{
							{ 2, 4 },
							{ 9, 5 },
							{ 6, 4 },
							{ ImageManager.ADD, ImageManager.DECREASE,
									ImageManager.MULTIPLY } },
					{
							{ 4, 8 },
							{ 3, 1 },
							{ 12, 2 },
							{ ImageManager.ADD, ImageManager.DECREASE,
									ImageManager.MULTIPLY } } } };
}
