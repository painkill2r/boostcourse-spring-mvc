package kr.or.connect.springmvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Spring 공통 설정 파일
 */
@Configuration
@ComponentScan(basePackages = {"kr.or.connect.springmvc.service", "kr.or.connect.springmvc.dao"})
@Import({DBConfig.class})
public class ApplicationConfig {
}