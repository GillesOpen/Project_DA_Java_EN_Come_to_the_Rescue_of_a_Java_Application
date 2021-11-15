package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

/**
 * programme principale AnalyticsCounter
 */
public class AnalyticsCounter {

	/**
	 * fichier en entr�e des symptomms (correction du chemein d'acces du fichier en
	 * entr�e)
	 */
	static final String fichierIN = "Project02Eclipse/symptoms.txt";

	/**
	 * fichier en sortie des symptoms
	 * 
	 */
	static final String fichierOUT = "Project02Eclipse/result.out";

	public static void main(String[] args) {

		/**
		 * La ArrayListclasse est un tableau redimensionnable. �l�ments peuvent �tre
		 * ajout�s et supprim�s � tout moment. chargement du fichier en entr�e
		 */

		ArrayList<String> result = new ArrayList<String>();
		ReadSymptomDataFromFile reader = new ReadSymptomDataFromFile(fichierIN);

		/**
		 * TreeMap est une repr�sentation de donn�es(cl�, valeur) Les couples de cette
		 * classe sont tri�s par cl� dans l'ordre croissant. changement du fichier en
		 * sortie
		 */

		TreeMap<String, Integer> symptomMap = new TreeMap<String, Integer>();
		WriteSymptomsOut writer = new WriteSymptomsOut(symptomMap, fichierOUT);

		/**
		 * traitement de lecture du fichier en entr�e appel de m�thode getSymptoms() La
		 * m�thode Frequency() de la classe Java Collections est utilis�e pour obtenir
		 * le nombre d'�l�ments dans la collection sp�cifi�e �gal � l'objet sp�cifi�.
		 */

		result = reader.getSymptoms();

		if (result != null) {
			for (String e : result) {
				if (!symptomMap.containsKey(e)) {
					symptomMap.put(e, Collections.frequency(result, e));
				}
			}
		}
		// traitement de fichier en sortie avec appel de la m�thode writeSymptomsOut()
		writer.writeSymptomsOut();
	}
}