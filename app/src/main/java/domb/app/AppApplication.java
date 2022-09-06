package domb.app;

import org.drools.core.ClockType;
import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.conf.ClockTypeOption;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
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

		return kieBase.newKieSession(kieSessionConfiguration, null);
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
