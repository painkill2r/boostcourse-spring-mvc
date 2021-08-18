package kr.or.connect.springmvc.dao;

import kr.or.connect.springmvc.ApplicationConfig;
import kr.or.connect.springmvc.dto.Guestbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class GuestbookDaoTest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        GuestbookDao guestbookDao = (GuestbookDao) context.getBean("guestbookDao");
        Guestbook guestbook = new Guestbook();
        guestbook.setName("홍길동");
        guestbook.setContent("안녕하세요.");
        guestbook.setRegdate(new Date());

        Long id = guestbookDao.insert(guestbook);

        System.out.println("id = " + id);
    }
}
