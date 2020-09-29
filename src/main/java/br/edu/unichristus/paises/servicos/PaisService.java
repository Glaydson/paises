package br.edu.unichristus.paises.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unichristus.paises.entidades.Pais;
import br.edu.unichristus.paises.repositorios.PaisRepository;

@Service
public class PaisService {
    @Autowired
    private PaisRepository repo;

	public void salvar(Pais p) {
        this.repo.save(p);
        System.out.println("PAÍS " + p.getCountryName() + " GRAVADO!");
    }

    public void removerTodos() {
        System.out.println("REMOVENDO TODOS OS PAÍSES...");
        this.repo.deleteAll();
	}
}
