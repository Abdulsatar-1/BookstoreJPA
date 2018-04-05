package fi.haaga.spring.harjoitusprojekti.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import fi.haaga.spring.harjoitusprojekti.Bookstore.domain.Book;
import fi.haaga.spring.harjoitusprojekti.Bookstore.domain.BookRepository;
import fi.haaga.spring.harjoitusprojekti.Bookstore.domain.Category;
import fi.haaga.spring.harjoitusprojekti.Bookstore.domain.CategoryRepository;




@SpringBootApplication
public class  BookstoreApplication   {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository){
		return args -> {
			log.info("save a couple of books");
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Science"));
			crepository.save(new Category("Fantasy"));
			
			
			repository.save(new Book(0, "A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", crepository.findByName("Horror").get(0)));
			repository.save(new Book(0, "Animal Farm", "George Orwell", 1945, "2212343-5", crepository.findByName("Horror").get(0)));
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
	
	}



