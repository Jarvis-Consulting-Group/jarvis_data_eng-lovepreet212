package ca.jrvs.apps.twitter.spring;

import ca.jrvs.apps.twitter.TwitterCLIApp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ca.jrvs.apps.twitter")
public class TwitterCLISpringboot implements CommandLineRunner {
    private TwitterCLIApp twitterCLIApp;

    public TwitterCLISpringboot(TwitterCLIApp twitterCLIApp) {
        this.twitterCLIApp = twitterCLIApp;
    }

    public static void main(String[] args) {
        SpringApplication s=new SpringApplication(TwitterCLISpringboot.class);
        s.setWebApplicationType(WebApplicationType.NONE);
        s.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        twitterCLIApp.run(args);
    }
}
