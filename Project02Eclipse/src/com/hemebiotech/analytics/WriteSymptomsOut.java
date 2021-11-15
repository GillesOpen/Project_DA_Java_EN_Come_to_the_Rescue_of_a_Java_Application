package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.TreeMap;

public class WriteSymptomsOut implements ISymptomWrite {

	/**
	 * TreeMap est une représentation de données(clé, valeur) hiérarchique sous
	 * forme d'arbre binaire. Les couples de cette classe sont triés par clé dans
	 * l'ordre croissant donc par ordre alphabétique.
	 */

	private TreeMap<String, Integer> symptomMap;
	private String filepath;

	/**
	 * changement tableau et fichier en sortie fichierOUT fichierOUT =
	 * "Project02Eclipse/result.out"
	 */
	public WriteSymptomsOut(TreeMap<String, Integer> symptomMap, String filepath) {
		this.symptomMap = symptomMap;
		this.filepath = filepath;
	}

	public void writeSymptomsOut() {
		File fichierOut = new File(filepath);
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter(fichierOut));

			/**
			 * interface statique publique Map.Entry<K,V> Une entrée de mappe (paire
			 * clé-valeur). La méthode Map.entrySet renvoie une vue de collection de la
			 * carte
			 */

			for (Entry<String, Integer> entry : symptomMap.entrySet()) {
				writer.write(entry.getKey() + ": " + entry.getValue());
				System.out.println("symptom out :  " + entry.getKey() + "  nb : " + entry.getValue());
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
				System.out.println("------------------------- fin sortie --------------------------------");
			} catch (Exception e) {
			}
		}
	}
}
