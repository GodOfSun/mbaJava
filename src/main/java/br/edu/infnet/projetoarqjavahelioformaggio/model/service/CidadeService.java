package br.edu.infnet.projetoarqjavahelioformaggio.model.service;

import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Cidade;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Uf;
import br.edu.infnet.projetoarqjavahelioformaggio.model.repository.CidadeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CidadeService extends AbstractService<Cidade> {

    private final CidadeRepository cidadeRepository;

    public CidadeService(CidadeRepository cidadeRepository) {
        super(cidadeRepository);
        this.cidadeRepository = cidadeRepository;
    }

    public Optional<Cidade> findByNome(String nome) throws EntityNotFoundException {
        return this.cidadeRepository.findByNome(nome);
    }

    @Override
    public Cidade create(Cidade entity) {
        Optional<Cidade> found = this.cidadeRepository.findByNome(entity.getNome());
        return found.orElseGet(() -> super.create(entity));
    }
}
