package com.example.effectivejava.chapter2.item2;

import lombok.Builder;

@Builder
public class NutritionFacts {
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;
}
