package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

/**
 * programme principale AnalyticsCounter
 */
public class AnalyticsCounter {

	/**
	 * fichier en entrée des symptomms (correction du chemein d'acces du fichier en
	 * entrée)
	 */
	static final String fichierIN = "Project02Eclipse/symptoms.txt";

	/**
	 * fichier en sortie des symptoms
	 * 
	 */
	static final String fichierOUT = "Project02Eclipse/result.out";

	public static void main(String[] args) {

		/**
		 * La ArrayListclasse est un tableau redimensionnable. éléments peuvent être
		 * ajoutés et supprimés à tout moment. chargement du fichier en entrée
		 */

		ArrayList<String> result = new ArrayList<String>();
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(fichierIN);

		/**
		 * TreeMap est une représentation de données(clé, valeur) Les couples de cette
		 * classe sont triés par clé dans l'ordre croissant. changement du fichier en
		 * sortie
		 */

		TreeMap<String, Integer> symptomMap = new TreeMap<String, Integer>();
		WriteSymptomsOut writer = new WriteSymptomsOut(symptomMap, fichierOUT);

		/**
		 * traitement de lecture du fichier en entrée appel de méthode getSymptoms() La
		 * méthode Frequency() de la classe Java Collections est utilisée pour obtenir
		 * le nombre d'éléments dans la collection spécifiée égal à l'objet spécifié.
		 */

		result = reader.getSymptoms();

		if (result != null) {
			for (String e : result) {
				if (!symptomMap.containsKey(e)) {
					symptomMap.put(e, Collections.frequency(result, e));
				}
			}
		}
		// traitement de fichier en sortie avec appel de la méthode writeSymptomsOut()
		writer.writeSymptomsOut();
	}
}