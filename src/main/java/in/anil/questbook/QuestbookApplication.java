package in.anil.questbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class QuestbookApplication /*extends SpringBootServletInitializer */{
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(QuestbookApplication.class);
//    }

    public static void main(String[] args) {
        SpringApplication.run(QuestbookApplication.class, args);
        System.out.println("QuestBook Application Server Started......");
    }

}
