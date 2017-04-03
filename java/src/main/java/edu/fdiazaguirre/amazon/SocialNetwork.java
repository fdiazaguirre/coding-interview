package edu.fdiazaguirre.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SocialNetwork {

	public List<String> getRankedCourses(String user) {
		List<String> result = new ArrayList<String>();
		List<String> friends = getDirectFriendsForUser(user);
		List<String> friendCourses;
		Map<String, Integer> coursesRank = new HashMap<String, Integer>();
		Integer count = new Integer(1);
		
		//O(n^2)
		for (String friend : friends) {
			friendCourses = getAttendedCoursesForUser(friend);
			for (String course : friendCourses) {
				count = coursesRank.get(course);
				if (count != null) {
					coursesRank.put(course, ++count);
				} else {
					coursesRank.put(course, 1);
				}
			}
		}
		
		 result.addAll(coursesRank.entrySet()
	              .stream()
	              .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
	              .collect(Collectors.toMap(
	                Map.Entry::getKey, 
	                Map.Entry::getValue, 
	                (e1, e2) -> e1, 
	                LinkedHashMap::new
	              )).keySet());
		 
		 return result;
	}

	private List<String> getAttendedCoursesForUser(String friend) {
		List<String> courses = new ArrayList<String>();
		if ("Joe" == friend) {
			courses.add("Maths");
			courses.add("English");
		}
		if ("Courtney" == friend) {
			courses.add("Maths");
			courses.add("Computer Science");
		}
		if ("Jen" == friend) {
			courses.add("Computer Science");
			courses.add("English");
			courses.add("Spanish");
		}
		
		return courses;
	}

	private List<String> getDirectFriendsForUser(String user) {
		List<String> friends = new ArrayList<String>();
		friends.add("Joe");
		friends.add("Courtney");
		friends.add("Jen");
		return friends;
	}
	
	public static void main(String[] args) {
		SocialNetwork sn = new SocialNetwork();
		System.out.println(sn.getRankedCourses("Fede"));
	}
}
