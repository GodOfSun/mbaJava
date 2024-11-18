package br.edu.infnet.projetoarqjavahelioformaggio.model.service;

import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Uf;
import br.edu.infnet.projetoarqjavahelioformaggio.model.repository.UfRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UfService extends AbstractService<Uf> {

    private final UfRepository ufRepository;

    public UfService(UfRepository ufRepository) {
        super(ufRepository);
        this.ufRepository = ufRepository;
    }

    public Optional<Uf> findBySigla(String sigla) throws EntityNotFoundException {
        return this.ufRepository.findBySiglaOrderByNome(sigla);
    }

    public Optional<Uf> findByNome(String nome) throws EntityNotFoundException {
        return this.ufRepository.findByNomeOrderByNome(nome);
    }

    @Override
    public Uf create(Uf entity) {
        Optional<Uf> found = this.ufRepository.findBySiglaOrderByNome(entity.getSigla());
        return found.orElseGet(() -> super.create(entity));
    }
}
