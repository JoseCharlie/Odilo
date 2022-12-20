package odilo.recruitment.firmaJuridica;

import odilo.recruitment.firmaJuridica.persistence.Certificado;
import odilo.recruitment.firmaJuridica.persistence.CertificadoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;


@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class})
public class FirmaJuridicaApplication {

	public static void main(String[] args) {

		SpringApplication.run(FirmaJuridicaApplication.class, args);

	}

	private static final Logger log = LoggerFactory.getLogger(FirmaJuridicaApplication.class);

	@Bean
	public CommandLineRunner demo(CertificadoRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Certificado(Long.getLong("1"), "hola"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Certificado certificado : repository.findAll()) {
				log.info(certificado.toString());
			}
			log.info("");

			// fetch an individual certificado by ID
			Certificado certificado = repository.findById(1L);
			log.info("Certificado found with findById(1L):");
			log.info("--------------------------------");
			log.info(certificado.toString());
			log.info("");

			/*// fetch customers by last name
			log.info("Certificado found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				log.info(bauer.toString());
			});
			// for (Certificado bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			log.info("");*/
		};
	}

}
