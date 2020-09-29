package br.edu.unichristus.paises.jsonutils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import br.edu.unichristus.paises.entidades.Pais;

/*
 * Classe auxiliar para ler os dados dos países em formato JSON,
 * armazená-los em objetos Pais e devovê-los em uma lista
 */
public class ReadJSON {
	
	
	public static List<Pais> lerPaises() {
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		List<Pais> paises = new ArrayList<>();

		try (FileReader reader = new FileReader("paises.json")) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			JSONArray listaPaises = (JSONArray) obj;
			//System.out.println(listaPaises);

			// Iterate over paises array
			//listaPaises.forEach(p -> parsePaisObject((JSONObject) p));

			for (Object p: listaPaises) {
				Pais pais = parsePaisObject((JSONObject) p);
				paises.add(pais);
			}
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return paises;
	}

	private static Pais parsePaisObject(JSONObject pais) {

		String countryName = (String) pais.get("countryName");
		String countryCode = (String) pais.get("countryCode");
		String currencyCode = (String) pais.get("currencyCode");
		double population = Double.parseDouble((String) pais.get("population"));
		String capital = (String) pais.get("capital");
		String continentName = (String) pais.get("continentName");
		double areaInSqKm = Double.parseDouble((String) pais.get("areaInSqKm"));

		return new Pais(countryCode, countryName, currencyCode, population, capital, continentName, areaInSqKm);
	}

}
