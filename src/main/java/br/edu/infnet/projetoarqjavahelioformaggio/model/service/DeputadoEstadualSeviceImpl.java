package br.edu.infnet.projetoarqjavahelioformaggio.model.service;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.DeputadoEstadual;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("DeputadoEstadual")
public class DeputadoEstadualSeviceImpl implements CandidatoService<DeputadoEstadual> {
}
