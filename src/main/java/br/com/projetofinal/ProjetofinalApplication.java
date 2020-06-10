package br.com.projetofinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ProjetofinalApplication {

	private static Logger logger = LoggerFactory.getLogger(ProjetofinalApplication.class);

	public static void main(String[] args) {
			logger.info("UEPA UEPA");
		SpringApplication.run(ProjetofinalApplication.class, args);
	}

}
