package br.edu.infnet.projetoarqjavahelioformaggio.model.service;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.DeputadoFederal;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("DeputadoFederal")
public class DeputadoFederalSeviceImpl implements CandidatoService<DeputadoFederal> {
}
