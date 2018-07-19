package com.guo.j8.nineChapter.searching;

import org.junit.jupiter.api.Test;

import java.io.File;

/***
 * One edit can be three types of operations : remove , insert or replace one
 * character. Give two string , return whether they are one step edit away
 */
public class OneAway {

	/*
	 * Assume case is not sensitive
	 */
	public boolean isOneAway(String src, String tag) {
		if (src == null || tag == null)
			return false;
		if (src.equalsIgnoreCase(tag))
			return true;
		if (Math.abs(src.length() - tag.length()) >= 2)
			return false;
		if (src.length() == tag.length()) {
			// check replace
			int editStep = 0;
			for (int i = 0; i < src.length(); i++) {
				if (src.charAt(i) != tag.charAt(i)) {
					editStep++;
					if (editStep >= 2) {
						return false;
					}
				}
			}
			return true;
		} else {
			// length difference must be 1
			// check insert or remove
			int editStep = 0;
			int srcIndex = 0;
			int tagIndex = 0;
			if (src.length() > tag.length()) {
				while (tagIndex < tag.length()) {
					if (src.charAt(srcIndex) != tag.charAt(tagIndex)) {
						editStep++;
						if (editStep >= 2)
							return false;
						srcIndex++;
					}
					srcIndex++;
					tagIndex++;
				}
				if (srcIndex == tagIndex) {
					if (editStep != 0)
						return false;
					srcIndex++;
					if (src.charAt(srcIndex) != tag.charAt(tagIndex))
						return false;
					return true;
				}
				return true;

			} else {
				while (srcIndex < src.length()) {
					if (src.charAt(srcIndex) != tag.charAt(tagIndex)) {
						editStep++;
						if (editStep >= 2)
							return false;
						tagIndex++;
					}
					srcIndex++;
					tagIndex++;
				}

				if (srcIndex == tagIndex) {
					if (editStep != 0)
						return false;
					tagIndex++;
					if (src.charAt(srcIndex) != tag.charAt(tagIndex))
						return false;
					return true;
				}
				return true;
			}
		}
	}

	@Test
	public void test() {
		OneAway oneAway = new OneAway();
		System.out.println("pale , bale --->" + oneAway.isOneAway("pale",
				"bale"));
		System.out.println("pale , ple --->" + oneAway.isOneAway("pale",
				"ple"));
	}

	@Test
	public void test2() {
		final String string =
				"/Users/hlguo/De_ID/whc-lsf-anonymous-export//asd.xml";
		String aStr = string.replaceAll(File.separator + "+", File.separator);
		System.out.println(aStr);
	}

}
