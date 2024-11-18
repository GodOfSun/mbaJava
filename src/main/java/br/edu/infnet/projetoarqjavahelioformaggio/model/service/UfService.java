package br.edu.infnet.projetoarqjavahelioformaggio.model.service;

import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Uf;
import br.edu.infnet.projetoarqjavahelioformaggio.model.repository.UfRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UfService extends AbstractService<Uf> {

    private final UfRepository ufRepository;

    public UfService(UfRepository ufRepository) {
        super(ufRepository);
        this.ufRepository = ufRepository;
    }

    public Optional<Uf> findBySilga(String sigla) throws EntityNotFoundException {
        return this.ufRepository.findBySigla(sigla);
    }

    public Optional<Uf> findByNome(String nome) throws EntityNotFoundException {
        return this.ufRepository.findByNome(nome);
    }

    @Override
    public Uf create(Uf entity) {
        Optional<Uf> found = this.ufRepository.findBySigla(entity.getSigla());
        return found.orElseGet(() -> super.create(entity));
    }
}
