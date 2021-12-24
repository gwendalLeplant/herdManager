package org.gleplant.herdManager.ihm;

import org.gleplant.herdManager.bll.SheepManager;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Test {

	public static void main(String[] args) {
		try {
			System.out.println(SheepManager.getAllJSON());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
