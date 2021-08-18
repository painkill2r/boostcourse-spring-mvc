package kr.or.connect.springmvc.dao;

import kr.or.connect.springmvc.ApplicationConfig;
import kr.or.connect.springmvc.dto.Guestbook;
import kr.or.connect.springmvc.dto.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class LogDaoTest {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        LogDao logDao = (LogDao) context.getBean("logDao");
        Log log = new Log();
        log.setIp("127.0.0.1");
        log.setMethod("GET");
        log.setRegdate(new Date());

        Long id = logDao.insert(log);

        System.out.println("id = " + id);
    }
}
