package br.edu.infnet.projetoarqjavahelioformaggio.model.service;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.Candidato;
import br.edu.infnet.projetoarqjavahelioformaggio.model.repository.CandidatoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class CandidatoAbstractService<T extends Candidato> {

    private final CandidatoRepository candidatoRepository;
    public CandidatoAbstractService(CandidatoRepository candidatoRepository1) {
        this.candidatoRepository = candidatoRepository1;
    }

    //public abstract CandidatoRepository ;candidatoRepository;

    public Optional findById(UUID id){
        return candidatoRepository.findById(id);
    };

    public Optional findByCode(String code){
        return candidatoRepository.findByCode(code);
    };

    public List<T> findByPartido(int codigoPartido){
        return  candidatoRepository.findByPartido(codigoPartido);
    };

    public Iterable findAll(){
        return candidatoRepository.findAll();
    };

    public T save(T candidato){
        return (T) candidatoRepository.save(candidato);
    };

    public Iterable<T> save(Iterable<T> candidato){
        return (Iterable<T>) candidatoRepository.saveAll(candidato);
    };

    public void delete(T candidato){
        candidatoRepository.delete(candidato);
    };

    public void deleteById(UUID id){
        candidatoRepository.deleteById(id);
    };

}
