package com.telstra.bootapi.util;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.telstra.bootapi.models.JRequest;

@Component
public class Utils {

	private static Random intGenerator = new Random();

	public int assignJReqID() {
		return Math.abs(intGenerator.nextInt());
	}

	public int computeLargest(JRequest jReq) {
		int[] arr = jReq.getNumbersMeetNumbers();
		int largest = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > largest) {
				largest = arr[i];
			}
		}
		return largest;
	}

	public String findDuplicate(JRequest jReq) {
		String str = jReq.getFindDuplicates();
		StringBuilder sb = new StringBuilder();
		char[] carray = str.toCharArray();

		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (carray[i] == carray[j]) {
					char ch = carray[j];
					sb.append(ch + " ");
					break;
				}
			}
		}

		System.out.println(sb.toString());
		return sb.toString();
	}

	public String removeWhtSpace(JRequest jReq) {
		String str = jReq.getWhiteSpacesGalore();
		char[] charArray = str.toCharArray();

		String stringWithoutSpaces = "";

		for (int i = 0; i < charArray.length; i++) {
			if ((charArray[i] != ' ') && (charArray[i] != '\t')) {
				stringWithoutSpaces = stringWithoutSpaces + charArray[i];
			}
		}
		return stringWithoutSpaces;
	}

}
