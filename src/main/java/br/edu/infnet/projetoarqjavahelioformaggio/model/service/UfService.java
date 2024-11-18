package br.edu.infnet.projetoarqjavahelioformaggio.model.service;

import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Uf;
import br.edu.infnet.projetoarqjavahelioformaggio.model.repository.UfRepository;
import jakarta.persistence.EntityNotFoundException;
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

    public Uf findBySilga(String sigla) throws EntityNotFoundException {
        return this.ufRepository.findBySigla(sigla);
    }


}
