package hbo.petiteannonce;

import hbo.petiteannonce.advert.Advert;
import hbo.petiteannonce.advert.AdvertRepository;
import hbo.petiteannonce.seller.Civility;
import hbo.petiteannonce.seller.Seller;
import hbo.petiteannonce.seller.SellerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Calendar;

@SpringBootApplication
@Slf4j
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(SellerRepository sellerRepo, AdvertRepository advertRepo) {
		return args ->{
			Seller hbo = Seller.builder()
					.civility(Civility.M)
					.firstname("Hamid")
					.lastname("Bourras")
					.email("bourras.hamid@gmail.com")
					.birthDate(Date.valueOf(LocalDate.of(1986, Month.MAY, 30)))
					.build();

			Seller mde = Seller.builder()
					.civility(Civility.M)
					.firstname("March")
					.lastname("Decade")
					.email("mdecade@gmail.com")
					.birthDate(Date.valueOf(LocalDate.of(1976, Month.OCTOBER, 31)))
					.build();
			sellerRepo.saveAll(Arrays.asList(hbo,mde));
			log.info("Seller created are #1 :  {}, #2 : {}", hbo.toString(), mde.toString());

			Advert samsung = Advert.builder()
					.creationDate(Calendar.getInstance().getTime())
					.price( new BigDecimal("299.95"))
					.seller(hbo)
					.title("Samsung Galaxy S10+ 128Go Blanc")
					.description("Teléphone occasion en très bon état, fourni avec facture et accessoire")
					.build();

			advertRepo.save(samsung);
			log.info("Advert created is : {}", samsung.toString());
		};
	}
}
