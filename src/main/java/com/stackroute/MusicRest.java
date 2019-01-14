package com.stackroute;

import com.stackroute.service.MusicService;
import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
@SpringBootApplication
public class MusicRest implements ApplicationListener<ContextRefreshedEvent>{

	public static void main(String[] args) {
		SpringApplication.run(MusicRest.class, args);
	}

	private static final Logger LOG = Logger.getLogger(MusicRest.class);

	public static int counter;

   /**
	* This approach can be used for running logic
   after the Spring context has been initialized,
   so we are not focusing on any particular bean,
   but waiting for all of them to initialize.
	*
	**/
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		LOG.info("Increment counter");
		counter++;
	}
}

/*public class MusicRest implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(MusicRest.class, args);
	}

	private static final Logger LOG = LoggerFactory.getLogger(MusicRest.class);

public static int counter;

   @Override
   public void run(String...args) throws Exception {
		LOG.info("Increment counter");
		counter++;
   }
}*/
