package br.edu.unichristus.paises;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.unichristus.paises.entidades.Pais;
import br.edu.unichristus.paises.jsonutils.ReadJSON;
import br.edu.unichristus.paises.servicos.PaisService;

@SpringBootApplication
public class PaisesApplication implements CommandLineRunner {

	@Autowired
	private PaisService servicoPaises;

	public static void main(String[] args) {
		SpringApplication.run(PaisesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Obtém os paises e grava
		List<Pais> listaPaises = ReadJSON.lerPaises();
		servicoPaises.removerTodos();
		for (Pais p : listaPaises) {
			servicoPaises.salvar(p);
		}
		System.out.println(listaPaises.size() + " PAÍSES GRAVADOS NO REPOSITÓRIO!");

		System.out.println("**** EXERCÍCIO COMEÇA AQUI ****");
		
	}

}
