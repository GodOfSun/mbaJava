package br.edu.infnet.projetoarqjavahelioformaggio;

import br.edu.infnet.projetoarqjavahelioformaggio.client.ExternalClientService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import br.edu.infnet.projetoarqjavahelioformaggio.model.domain.*;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Cidade;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.CidadeDTO;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.Uf;
import br.edu.infnet.projetoarqjavahelioformaggio.model.locationModel.UfDTO;
import br.edu.infnet.projetoarqjavahelioformaggio.model.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Loader implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(Loader.class);

    private final ExternalClientService externalClientService;
    private final UfService ufService;
    private final CidadeService cidadeService;
    private final VereadorServiceImpl vereadorService;
    private final PrefeitoServiceImpl prefeitoService;
    private final DeputadoEstadualSeviceImpl deputadoEstadualService;
    private final DeputadoFederalSeviceImpl deputadoFederalService;
    private final GovernadorServiceImpl governadorService;
    private final PresidenteServiceImpl presidenteService;

    public Loader(ExternalClientService externalClientService,
                  UfService ufService,
                  CidadeService cidadeService,
                  VereadorServiceImpl vereadorService,
                  PrefeitoServiceImpl prefeitoService,
                  DeputadoEstadualSeviceImpl deputadoEstadualService,
                  DeputadoFederalSeviceImpl deputadoFederalService,
                  GovernadorServiceImpl governadorService,
                  PresidenteServiceImpl presidenteService) {
        this.externalClientService = externalClientService;
        this.ufService = ufService;
        this.cidadeService = cidadeService;
        this.vereadorService = vereadorService;
        this.prefeitoService = prefeitoService;
        this.deputadoEstadualService = deputadoEstadualService;
        this.deputadoFederalService = deputadoFederalService;
        this.governadorService = governadorService;
        this.presidenteService = presidenteService;
    }

    private List<Vereador> loadVereadoresFromCSV(String filePath) {
        List<Vereador> vereadores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                Vereador vereador = new Vereador();
                vereador.setAtivo(Boolean.parseBoolean(values[0]));
                vereador.setGastoCampanha(Float.parseFloat(values[1]));
                vereador.setNumeroPartido(Integer.parseInt(values[2]));
                vereador.setCodigo(values[3]);

                Cidade cidade = cidadeService.findByNome(values[5]).orElseThrow();
                vereador.setCidade(cidade);

                Uf uf = ufService.findByNome(values[5]).orElseThrow();
                vereador.setUf(uf);

                vereador.setNome(values[6]);
                vereador.setCodigoVereador(values[7]);
                vereador.setEmail(values[8]);
                vereadores.add(vereador);
            }
        } catch (IOException e) {
            logger.error("Erro ao carregar vereadores do CSV: " + filePath, e);
        }
        return vereadores;
    }

    private List<Prefeito> loadPrefeitosFromCSV(String filePath) {
        List<Prefeito> prefeitos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                if (values.length < 8) {continue;}
                Prefeito prefeito = new Prefeito();
                prefeito.setAtivo(Boolean.parseBoolean(values[0]));
                prefeito.setGastoCampanha(Float.parseFloat(values[1]));
                prefeito.setNumeroPartido(Integer.parseInt(values[2]));
                prefeito.setCodigo(values[3]);

                Cidade cidade = cidadeService.findByNome(values[4]).orElseThrow();
                prefeito.setCidade(cidade);

                Uf uf = ufService.findByNome(values[5]).orElseThrow();
                prefeito.setUf(uf);

                prefeito.setNome(values[6]);
                prefeito.setCodigoPrefeito(values[7]);
                prefeito.setEmail(values[8]);
                prefeitos.add(prefeito);
            }
        } catch (IOException e) {
            logger.error("Erro ao carregar prefeitos do CSV: " + filePath, e);
        }
        return prefeitos;
    }

    private List<DeputadoEstadual> loadDeputadosEstaduaisFromCSV(String filePath) {
        List<DeputadoEstadual> deputadosEstaduais = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");

                DeputadoEstadual deputadoEstadual = new DeputadoEstadual();
                deputadoEstadual.setAtivo(Boolean.parseBoolean(data[0]));
                deputadoEstadual.setGastoCampanha(Float.parseFloat(data[1]));
                deputadoEstadual.setNumeroPartido(Integer.parseInt(data[2]));
                deputadoEstadual.setCodigo(data[3]);
                deputadoEstadual.setUf(ufService.findByNome(data[4]).orElseThrow());
                deputadoEstadual.setNome(data[5]);
                deputadoEstadual.setCodigoEstadual(data[6]);
                deputadoEstadual.setEmail(data[7]);

                deputadosEstaduais.add(deputadoEstadual);
            }
        } catch (Exception e) {
            logger.error("Erro ao carregar deputados estaduais do CSV: " + filePath, e);
        }
        return deputadosEstaduais;
    }

    private List<DeputadoFederal> loadDeputadosFederaisFromCSV(String filePath) {
        List<DeputadoFederal> deputadosFederais = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");

                DeputadoFederal deputadoFederal = new DeputadoFederal();
                deputadoFederal.setAtivo(Boolean.parseBoolean(data[0]));
                deputadoFederal.setGastoCampanha(Float.parseFloat(data[1]));
                deputadoFederal.setNumeroPartido(Integer.parseInt(data[2]));
                deputadoFederal.setCodigo(data[3]);
                deputadoFederal.setNome(data[4]);
                deputadoFederal.setCodigoFederal(data[5]);
                deputadoFederal.setEmail(data[6]);

                deputadosFederais.add(deputadoFederal);
            }
        } catch (Exception e) {
            logger.error("Erro ao deputados federais do CSV: " + filePath, e);
        }

        return deputadosFederais;
    }

    private List<Governador> loadGovernadoresFromCSV(String filePath) {
        List<Governador> governadores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");

                Governador governador = new Governador();
                governador.setAtivo(Boolean.parseBoolean(data[0]));
                governador.setGastoCampanha(Float.parseFloat(data[1]));
                governador.setNumeroPartido(Integer.parseInt(data[2]));
                governador.setCodigo(data[3]);
                governador.setUf(ufService.findByNome(data[4]).orElseThrow());
                governador.setNome(data[5]);
                governador.setCodigoGovernador(data[6]);
                governador.setEmail(data[7]);

                governadores.add(governador);
            }
        } catch (Exception e) {
            logger.error("Erro ao carregar governadores do CSV: " + filePath, e);
        }
        return governadores;
    }

    private List<Presidente> loadPresidentesFromCSV(String filePath) {
        List<Presidente> presidentes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");

                Presidente presidente = new Presidente();
                presidente.setAtivo(Boolean.parseBoolean(data[0]));
                presidente.setGastoCampanha(Float.parseFloat(data[1]));
                presidente.setNumeroPartido(Integer.parseInt(data[2]));
                presidente.setCodigo(data[3]);
                presidente.setNome(data[4]);
                presidente.setCodigoPresidente(data[5]);
                presidente.setEmail(data[6]);

                presidentes.add(presidente);
            }
        } catch (Exception e) {
            logger.error("Erro ao carregar presidentes do CSV: " + filePath, e);
        }

        return presidentes;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Collection<UfDTO> estados = this.externalClientService.obterEstados();

        Collection<Uf> estadosEntity = new ArrayList<>();
        for(UfDTO estado : estados) {
            estadosEntity.add(new Uf(estado));
        }
        this.ufService.create(estadosEntity);

        for(UfDTO estado : estados) {
            Optional<Uf> estadoEntity = this.ufService.findBySigla(estado.getSigla());
            Collection<CidadeDTO> cidades = this.externalClientService.obterMunicipios(estado.getId());

            Collection<Cidade> cidadesEntity = new ArrayList<>();
            for(CidadeDTO cidadeDTO : cidades) {
                Cidade cidadeEntity = new Cidade(cidadeDTO);
                cidadeEntity.setEstado(estadoEntity.orElseThrow());
                cidadesEntity.add(cidadeEntity);
            }
            this.cidadeService.create(cidadesEntity);
        }

        try {
            //vereadores
            List<Vereador> vereadores = loadVereadoresFromCSV("files/veread.csv");
            this.vereadorService.save(vereadores);

            // Prefeitos
            List<Prefeito> prefeitos = loadPrefeitosFromCSV("files/pref.csv");
            this.prefeitoService.save(prefeitos);

            //deputados estaduais
            List<DeputadoEstadual> deputadosEstaduais = loadDeputadosEstaduaisFromCSV("files/depEst.csv");
            this.deputadoEstadualService.save(deputadosEstaduais);

            //deputados federais
            List<DeputadoFederal> deputadosFederais = loadDeputadosFederaisFromCSV("files/depFed.csv");
            this.deputadoFederalService.save(deputadosFederais);

            //governadores
            List<Governador> governadores = loadGovernadoresFromCSV("files/gov.csv");
            this.governadorService.save(governadores);

            //presidentes
            List<Presidente> presidentes = loadPresidentesFromCSV("files/presid.csv");
            this.presidenteService.save(presidentes);
        } catch (Exception e) {
            logger.error("Erro durante a inicialização do Loader", e);
        }

    }
}
