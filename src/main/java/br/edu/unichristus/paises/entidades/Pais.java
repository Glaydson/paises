package br.edu.unichristus.paises.entidades;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "paises")
@Data
public class Pais {
	
	@Id
	private String id;
	private String countryCode;
	private String countryName;
	private String currencyCode;
	private double population;
	private String capital;
	private String continentName;
	private double areaInSqKm;

	public Pais(String countryCode, String countryName, String currencyCode, double population, String capital,
			String continentName, double areaInSqKm) {
		super();
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.currencyCode = currencyCode;
		this.population = population;
		this.capital = capital;
		this.continentName = continentName;
		this.areaInSqKm = areaInSqKm;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", countryCode=" + countryCode + ", countryName=" + countryName + ", currencyCode="
				+ currencyCode + ", population=" + String.format("%,.0f", population) + ", capital=" + capital + ", continentName="
				+ continentName + ", areaInSqKm=" + String.format("%,.0f", areaInSqKm) + "]";
	}

}
