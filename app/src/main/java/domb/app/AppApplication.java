package domb.app;

import org.drools.core.ClockType;
import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.builder.ReleaseId;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.conf.ClockTypeOption;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

    @Value("${rt-server.host}")
    private String host;

    @Value("${rt-server.port}")
    private Integer port;

	@Bean
    public SocketIOServer socketIOServer() {
        Configuration config = new Configuration();
        config.setHostname(host);
        config.setPort(port);
		config.setOrigin("http://localhost:3000");
        return new SocketIOServer(config);
    }

	@Bean
	public KieSession kieSession() {
		KieServices ks = KieServices.Factory.get();
		ReleaseId releaseId = ks.newReleaseId("domb","rules", "0.0.1-SNAPSHOT");
		KieContainer kContainer = ks.newKieContainer(releaseId);
		
		KieBaseConfiguration kieBaseConfiguration = ks.newKieBaseConfiguration();
		kieBaseConfiguration.setOption(EventProcessingOption.STREAM);
		KieBase kieBase = kContainer.newKieBase(kieBaseConfiguration);

		KieSessionConfiguration kieSessionConfiguration = ks.newKieSessionConfiguration();
		kieSessionConfiguration.setOption(ClockTypeOption.get(ClockType.REALTIME_CLOCK.getId()));
		// KieSession session = kieBase.newKieSession(kieSessionConfiguration, null);
		// session.setGlobal("diagnoseService", diagnoseService);
		return kieBase.newKieSession(kieSessionConfiguration, null);
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
