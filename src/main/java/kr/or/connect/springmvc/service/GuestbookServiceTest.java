package kr.or.connect.springmvc.service;

import kr.or.connect.springmvc.ApplicationConfig;
import kr.or.connect.springmvc.dto.Guestbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class GuestbookServiceTest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        GuestbookService guestbookService = context.getBean(GuestbookService.class);

        Guestbook guestbook = new Guestbook();
        guestbook.setName("홍길동");
        guestbook.setContent("GuestbookService 테스트");
        guestbook.setRegdate(new Date());

        Guestbook registGuestbook = guestbookService.addGuestbook(guestbook, "127.0.0.1");

        System.out.println("registGuestbook = " + registGuestbook);
    }
}
