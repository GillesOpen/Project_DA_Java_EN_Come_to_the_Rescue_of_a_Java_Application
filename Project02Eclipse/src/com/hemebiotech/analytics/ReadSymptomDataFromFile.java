package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadSymptomDataFromFile implements ISymptomReader {

	int i = 0;
	private String filepath;

	/**
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	public ArrayList<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String symptom = reader.readLine();
				while (symptom != null) {
					result.add(symptom);
					System.out.println("symptom IN : " + symptom);
					symptom = reader.readLine();
					i++;
				}
				reader.close();
				System.out.println("------- fin entrée -----" + "Nb enregistrement : " + i + " ------------");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}