package com.example.effectivejava.chapter2.item3;

import static com.example.effectivejava.chapter2.item3.NyPizza.Size.SMALL;
import static com.example.effectivejava.chapter2.item3.Pizza.Topping.*;

// 계층적 빌더 사용 (21쪽)
public class PizzaTest {
	public static void main(String[] args) {
		NyPizza pizza = new NyPizza.Builder(SMALL)
			.addTopping(SAUSAGE).addTopping(ONION).build();
		Calzone calzone = new Calzone.Builder()
			.addTopping(HAM).sauceInside().build();

		System.out.println(pizza);
		System.out.println(calzone);
	}
}
