package br.edu.infnet.projetoarqjavahelioformaggio.model.service;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.Candidato;
import br.edu.infnet.projetoarqjavahelioformaggio.model.repository.CandidatoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class CandidatoAbstractService<T extends Candidato> {

    public abstract CandidatoRepository getRepository();

    public Optional findById(UUID id){
        return getRepository().findById(id);
    };

    public Optional findByCode(String code){
        return getRepository().findByCode(code);
    };

    public List<T> findByPartido(int codigoPartido){
        return  getRepository().findByPartido(codigoPartido);
    };

    public Iterable findAll(){
        return getRepository().findAll();
    };

    public T save(T candidato){
        return (T) getRepository().save(candidato);
    };

    public Iterable<T> save(Iterable<T> candidato){
        return (Iterable<T>) getRepository().saveAll(candidato);
    };

    public void delete(T candidato){
        getRepository().delete(candidato);
    };

    public void deleteById(UUID id){
        getRepository().deleteById(id);
    };

}
