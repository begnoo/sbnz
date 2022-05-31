package domb.app;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	public KieContainer kieContainer() {
		KieServices ks = KieServices.Factory.get();
		ReleaseId releaseId = ks.newReleaseId("domb","rules", "0.0.1-SNAPSHOT");
		KieContainer kContainer = ks.newKieContainer(releaseId);
		KieScanner kScanner = ks.newKieScanner(kContainer);
		kScanner.start(10_000);

		return kContainer;
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
