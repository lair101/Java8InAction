package com.guo.j8.nineChapter.searching;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/***
 * 110XXXXX0001XXXXX Given a string like this, Generate all the combination of
 * binary string
 */
public class BarCode {

	public List<String> getBarCode(String sample) {
		List<String> res = new ArrayList<>();
		if (!sample.contains("x"))
			return res;
		dfs(sample, res, "", 0);
		return res;
	}

	private void dfs(String sample, List<String> res, String tmp, int index) {

		if (tmp.length() == sample.length()) {
			res.add(tmp);
			return;
		}
		Character c = sample.charAt(index);
		if (c != 'x') {
			dfs(sample, res, tmp + c, ++index);
			index--;
		} else {
			dfs(sample, res, tmp + '1', ++index);
			index--;
			dfs(sample, res, tmp + '0', ++index);
			index--;
		}
	}

	@Test
	public void test() {
		BarCode b = new BarCode();
		for (String s : b.getBarCode("110xx1")) {
			System.out.println(s);
		}
	}
}
