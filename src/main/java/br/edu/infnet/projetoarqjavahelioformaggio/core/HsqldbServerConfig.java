package br.edu.infnet.projetoarqjavahelioformaggio.core;


import org.hsqldb.server.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HsqldbServerConfig {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server hsqldbServer() {
        Server server = new Server();

        // Configurações do servidor HSQLDB
        server.setDatabaseName(0, "formaggio");
        server.setDatabasePath(0, "file:.data/formaggio");
        server.setPort(9001);
        server.setSilent(true);

        return server;
    }
}