package com.guo.j8.nineChapter.searching;

import org.junit.jupiter.api.Test;

public class StringCompress {

	public String compressString(String src) {
		if (src == null || src.length() == 0)
			return "";
		int start = 0;
		int end = 0;
		String res = "";

		while (start < src.length()) {

			while (end < src.length() && Character.toLowerCase(src.charAt
					(end)) == Character.toLowerCase(src.charAt(start))) {
				end++;
			}

			res = buildStr(res, src, start, end - 1);

			start = end;
		}
		return res;
	}

	private String buildStr(String res, String src, int start, int end) {
		if (end == start)
			res = res + Character.toLowerCase(src.charAt(start));
		if (end - start == 1) {
			res = res + Character.toLowerCase(src.charAt(end)) + Character
					.toLowerCase(src.charAt(end));
		}
		if (end - start > 1) {
			res = res + Character.toLowerCase(src.charAt(end));
			res = res + (end - start + 1);
		}

		return res;
	}

	@Test
	public void test() {
		StringCompress stringCompress = new StringCompress();
		String s = "assssvvvvvuuuuhhhhhddddvvvsssss";
		System.out.println(stringCompress.compressString(s));
	}
}
