#### 최초 작성일 : 2021.08.10(화)

# Boostcourse Java Back-end 과정 학습

여기서는 Boostcourse Spring Framework Web MVC 학습을 진행한다.

## 학습 환경

1. OS : MacOS
2. JDK : OpenJDK 11.0.5
4. Build Tools : Maven
5. Database : MySQL
6. IDE: IntelliJ IDEA Ultimate

## IntelliJ Spring Framework 프로젝트 설정 방법

### Maven 프로젝트 설정

1. IntelliJ에서 New Project 선택
   ![IntelliJ > New Project](images/settings/setting01.png)
2. `Maven` 선택, `org.apache.maven.archetypes:maven-archetype-webapp` 선택 후 Next 버튼 클릭
   ![IntelliJ > New Project](images/settings/setting02.png)
3. `GroupId`, `ArtifactId`, `Version` 설정 후 Next 버튼 클릭
   ![IntelliJ > New Project](images/settings/setting03.png)
    - GroupId는 보통 프로젝트를 진행하는 회사나 팀의 도메인 이름을 거꾸로 적는다.
    - ArtifactId는 해당 프로젝트의 이름을 적는다.
    - Version은 보통 기본값(1.0-SNAPSHOT)으로 설정한다.
    - 여기서는 언급되지 않지만 `Package`라는 것이 있는데, 이는 GroupId와 ActifactId가 조합된 형태를 가진다.
4. Finish 버튼 클릭
   ![IntelliJ > New Project](images/settings/setting04.png)

### Spring Framework 프로젝트로 변경

1. 프로젝트 `우클릭 > Add Framework Support...` 클릭
   ![IntelliJ > New Project](images/settings/setting05.png)
2. Spring MVC 선택 > Configure... 클릭
   ![IntelliJ > New Project](images/settings/setting06.png)
3. Configure 확인 후 OK
    - 스프링 버전인 이후에 Maven를 사용하여 알맞게 변경할 것이기 때문에 크게 신경쓸 필요 없다.
      ![IntelliJ > New Project](images/settings/setting07.png)
4. `lib` 폴더 삭제
    - Maven 빌드 도구를 이용하여 라이브러리를 사용할 것이기 때문에 삭제한다.
      ![IntelliJ > New Project](images/settings/setting08.png)
5. File > Projecdt Structure... > Libraires에서 등록되어 있는 라이브러리 모두 삭제
   ![IntelliJ > New Project](images/settings/setting09.png)
6. `pom.xml` 내용 변경
    - Spring Framework 라이브러리 추가
    - Build 설정
   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <project xmlns="http://maven.apache.org/POM/4.0.0"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                                http://maven.apache.org/xsd/maven-4.0.0.xsd">
       <modelVersion>4.0.0</modelVersion>
       <groupId>kr.or.connect</groupId>
       <artifactId>springmvc</artifactId>
       <version>1.0-SNAPSHOT</version>
       <packaging>war</packaging>
       <name>springmvc Maven Webapp</name>
       <url>http://www.example.com</url>
       <properties>
           <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
           <maven.compiler.source>11</maven.compiler.source>
           <maven.compiler.target>11</maven.compiler.target>
           <spring-version>4.3.5.RELEASE</spring-version>
       </properties>
   
       <dependencies>
           <!-- Spring Framework 라이브러리 추가 -->
           <dependency>
               <groupId>org.springframework</groupId>
               <artifactId>spring-context</artifactId>
               <version>${spring-version}</version>
           </dependency>
   
           <!-- Spring MVC 라이브러리 추가 -->
           <dependency>
               <groupId>org.springframework</groupId>
               <artifactId>spring-webmvc</artifactId>
               <version>${spring-version}</version>
           </dependency>
   
           <!-- JUnit 테스트 라이브러리 추가 -->
           <dependency>
               <groupId>junit</groupId>
               <artifactId>junit</artifactId>
               <version>4.11</version>
               <scope>test</scope>
           </dependency>
       </dependencies>
   
       <build>
           <finalName>springmvc</finalName>
           <!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
           <pluginManagement>
               <plugins>
                   <plugin>
                       <artifactId>maven-clean-plugin</artifactId>
                       <version>3.1.0</version>
                   </plugin>
                   <!-- see http://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_war_packaging -->
                   <plugin>
                       <artifactId>maven-resources-plugin</artifactId>
                       <version>3.0.2</version>
                   </plugin>
                   <plugin>
                       <artifactId>maven-compiler-plugin</artifactId>
                       <version>3.8.0</version>
                   </plugin>
                   <plugin>
                       <artifactId>maven-surefire-plugin</artifactId>
                       <version>2.22.1</version>
                   </plugin>
                   <plugin>
                       <artifactId>maven-war-plugin</artifactId>
                       <version>3.2.2</version>
                   </plugin>
                   <plugin>
                       <artifactId>maven-install-plugin</artifactId>
                       <version>2.5.2</version>
                   </plugin>
                   <plugin>
                       <artifactId>maven-deploy-plugin</artifactId>
                       <version>2.8.2</version>
                   </plugin>
               </plugins>
           </pluginManagement>
       </build>
   </project>
   ```
7. web.xml 내용 변경
    - 여기서는 XML 설정 파일이 아닌 `Java Config 파일`을 통해 Spring 설정을 읽어 들이도록 설정하였음.
   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                                http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd" version="3.1">
       <display-name>Archetype Created Web Application</display-name>
       <servlet>
           <servlet-name>mvc</servlet-name>
           <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
           <init-param>
               <param-name>contextClass</param-name>
               <param-value>org.springframework.web.context.support.AnnotationConfigWebApplicationContext</param-value>
           </init-param>
           <init-param>
               <param-name>contextConfigLocation</param-name>
               <param-value>kr.or.connect.springmvc.WebMvcContextConfiguration</param-value>
           </init-param>
           <load-on-startup>1</load-on-startup>
       </servlet>
       <servlet-mapping>
           <servlet-name>mvc</servlet-name>
           <url-pattern>/</url-pattern>
       </servlet-mapping>
   </web-app>
   ```

### WAS(Tomcat 8.5) 설정

1. IntelliJ `우측 상단 Add Configuration...` 클릭
   ![IntelliJ > New Project](images/settings/tomcat/tomcat_setup01.png)
2. `+ 버튼 > Tomcat Server > Local`을 선택하여 톰캣 설정
   ![IntelliJ > New Project](images/settings/tomcat/tomcat_setup02.png)
3. Deployment, Application context 설정
   ![IntelliJ > New Project](images/settings/tomcat/tomcat_setup03.png)

## Spring Framework Web MVC

1. MVC 설정시 사용하는 어노테이션
    - @Configuration
    - @EnableWebMvc
        - DispatcherServlet의 RequestMappingHandlerMapping, RequestMappingHandlerAdapter,
          ExceptionHandlerExceptionResolver, MessageConverter 등 `Web에 필요한 빈들을 대부분 자동으로 설정`해준다.
        - XML로 설정하는 경우 <mvc:annotation-driven/> 와 동일하다.
        - 기본 설정 이외의 설정이 필요하다면 `WebMvcConfigurerAdapter`를 상속받도록 Java config class를 작성한 후, 필요한 메소드를 오버라이딩 하도록 한다.
    - @ComponentScan

### 레이어드 아키텍처(Layered Architecture)

![레이어드 아키텍처](./images/mvc/mvc02.png)

#### Controller에서 중복되는 부분을 처리하려면?

1. 별도의 객체로 분리
2. 별도의 메소드로 분리

##### 컨트롤러와 서비스

1. 업무와 관련된 비즈니스 메소드를 별도의 `Service 객체`에서 구현하도록 하고 컨트롤러는 Service를 이용하도록 한다.
   ![컨트롤러와 서비스](./images/mvc/mvc01.png)

##### 서비스 객체

1. 비지니스 로직(Business logic)을 수행하는 메소드를 가지고 있는 객체를 서비스 객체라고 한다.
2. 보통 하나의 비지니스 로직은 하나의 `트랜잭션`으로 동작한다.

#### 트랜잭션(Transaction)이란?

1. 트랜잭션의 특징은 크게 4가지로 구분됩니다.
    - 원자성(Atomicity)
        - 예를 들어, '출금'이라는 기능의 흐름이 다음과 같다고 생각해 보자.
            1. 잔액이 얼마인지 조회한다.
            2. 출금하려는 금액이 잔액보다 작은지 검사한다.
            3. 출금하려는 금액이 잔액보다 작다면 (잔액 - 출금액)으로 수정한다.
            4. 언제, 어디서 출금했는지 정보를 기록한다.
            5. 사용자에게 출금한다.
        - 위의 작업이 4번에서 오류가 발생했다면 앞의 작업을 모두 원래대로 복원시켜야 한다.(`Rollback`)
        - 5번까지 모두 성공했을 때만 정보를 모두 반영해야 한다.(`Commit`)
    - 일관성(Consistency)
        - 트랜잭션이 진행되는 동안에 데이터가 변경되더라도 업데이트된 데이터로 트랜잭션이 진행되는 것이 아니라, 처음에 트랜잭션을 진행하기 위해 참조한 데이터로 진행되어야 한다.
    - 독립성(Isolation)
        - 둘 이상의 트랜잭션이 동시에 병행 실행되고 있을 경우에 어느 하나의 트랜잭션이라도 다른 트랜잭션의 연산을 끼어들 수 없다는 것을 의미한다.
        - MySQL 콘솔을 두 개 띄워 놓고 테스트 해볼 수 있다.
    - 지속성(Durability)
        - 트랜잭션이 성공적으로 완료됬을 경우, 결과는 영구적으로 반영되어야 한다는 점이다.

#### JDBC 프로그래밍에서 트랜잭션 처리 방법

1. DB에 연결된 후 `Connection 객체`의 `setAutoCommit()` 메소드에 파라미터를 `false`로 지정한다.
2. 입력/수정/삭제 SQL이 실행을 한 후 모두 성공했을 경우 Connection 객체가 가지고 있는 `commit()` 메소드를 호출한다.

#### @EnableTransactionManagement

1. Spring Java Config 파일에서 트랜잭션을 활성화 할 때 사용하는 어노테이션이다.
2. Java Config를 사용하게 되면 `PaltformTransactionManager` 구현체를 모두 찾아서 그 중에 하나를 매핑해서 사용한다.
3. 특정 트랜잭션 메니저를 사용하고자 한다면 `TransactionManagementConfigurer`를 Java Config파일에서 구현하고, 원하는 트랜잭션 매니저를 리턴하도록 한다.
    - 아니면, 특정 트랜잭션 메니저 객체를 생성시 `@Primary` 어노테이션을 지정한다.

#### 서비스 객체에서 중복으로 호출되는 코드의 처리

1. 데이터 엑세스 메소드를 별도의 `Repository(DAO)` 객체에서 구현하도록 하고 Service는 Repository객체를 사용하도록 합니다.

### 설정의 분리

1. Spring 설정 파일을 프리젠테이션 레이어쪽과 나머지를 분리할 수 있다.
    - `web.xml` 파일에서 `프리젠테이션 레이어에 대한 스프링 설정은 DispathcerServlet이` 읽도록 하고, `그 외의 설정은 ContextLoaderListener`를 통해서 읽도록 한다.
2. DispatcherServlet을 경우에 따라서 2개 이상 설정할 수 있다.
    - 이 경우 각각의 DispathcerServlet의 `ApplicationContext가 각각 독립적이기 때문에 각각의 설정 파일에서 생성한 빈을 서로 사용할 수 없다.`
    - 위의 경우와 같이 `동시에 필요한 빈은 ContextLoaderListener를 사용함으로써 공통으로 사용`하게 할 수 있습니다.
3. ContextLoaderListener와 DispatcherServlet은 각각 ApplicationContext를
   생성하는데, `ContextLoaderListener가 생성하는 ApplicationContext가 root 컨텍스트`가
   되고 `DispatcherServlet이 생성한 인스턴스는 root 컨텍스트를 부모로 하는 자식 컨텍스트`가 됩니다.
    - 참고로, `자식 컨텍스트들은 root 컨텍스트의 설정 빈을 사용할 수 있습니다.`