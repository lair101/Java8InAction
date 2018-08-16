package com.guo.j8.nineChapter.sorting;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * Google phone interview question
 *
 *
 */

public class Electing {

	class Ticket {
		Person person;
		Date time;

		public Person getPerson() {
			return person;
		}

		public Date getTime() {
			return time;
		}

		public void setPerson(Person person) {
			this.person = person;
		}

		public void setTime(Date time) {
			this.time = time;
		}
	}

	class Person {
		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		String name;
		int age;

	}

	class Record {
		Person person;
		int ticketNums;
	}

	/**
	 * 给一堆选票，每张选票有候选人和一个时间，选票并没有排序，然后写个函数返回给定时间点的winner
	 */
	public Person top1(Ticket[] tickets, Date from, Date to) {
		LinkedHashMap<Person, Integer> linkedHashMap = new LinkedHashMap<>();

		for (Ticket t : tickets) {
			if (t.time.after(from) && t.time.before(to)) {
				linkedHashMap.put(t.person, linkedHashMap.getOrDefault(t.person, 0) + 1);
			}
		}

		Map.Entry entry = linkedHashMap.entrySet().iterator().next();
		return (Person) entry.getKey();
	}

	private long getRandomTimeBetweenTwoDates(long beginTime, long endTime) {
		long diff = endTime - beginTime + 10;
		return beginTime + (long) (Math.random() * diff);
	}

	@Test
	public void test() {
		Date start = new Date();
		start.setTime(2018101010);
		Date end = new Date();
		end.setTime(2100120810);

		Person henry = new Person("HENRY", 12);
		Person john = new Person("JOHN", 12);
		Person chris = new Person("CHRIS", 12);
		Person hao = new Person("HAOLIN", 12);

		Person[] people = new Person[] { henry, john, chris, hao };

		Ticket[] tickets = new Ticket[100];

		for (int i = 0; i < 100; i++) {
			Ticket t = new Ticket();
			t.person = people[i % 4];
			Date randomDate = new Date();
			randomDate.setTime(getRandomTimeBetweenTwoDates(start.getTime(), end.getTime()));
			t.time = randomDate;
			tickets[i] = t;
		}

		Arrays.stream(tickets).forEach(t -> System.out.println(t.time + "--->"));

		System.out.println(top1(tickets, start, end).name);

	}
}
