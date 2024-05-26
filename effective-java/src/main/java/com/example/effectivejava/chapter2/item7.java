package com.example.effectivejava.chapter2;

import java.util.ArrayList;
import java.util.List;

public class item7 {

	public void Item7() {
		List<String> stringList = new ArrayList<>();

		stringList.add("sdf");
		stringList.add("sdf2");
		stringList.remove(stringList.size() - 1);
	}
}
