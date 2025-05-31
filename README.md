# 🌿 Spring Framework 학습 정리

Spring Framework를 학습하고 `sboard` 게시판을 구현해보며 배운 내용을 정리했습니다.

## 🏷️ 학습 내용

1. **Spring Framework 기초**
   - 스프링의 개념: IoC(제어의 역전), DI(의존성 주입)
   - 애너테이션 기반 설정
     - `@Controller`, `@Service`, `@Repository`
   - 스프링 MVC 구조 및 흐름
     - DispatcherServlet 역할
     - ViewResolver와 Model 객체

2. **MyBatis 연동**
   - MyBatis 설정 (`mybatis-config.xml`)
   - Mapper 인터페이스와 XML 매핑 파일
   - SQL문 실행과 결과 매핑

3. **sboard 게시판 실습**
   - 회원가입 및 로그인 (선택)
   - 게시글 CRUD (목록, 작성, 조회, 수정, 삭제)
   - 페이징 처리
   - 파일 업로드 (선택)
   - 관리자 기능 (선택)

---


---

## ⚙️ 개발 환경

- **언어**: Java (JDK 8 이상)
- **프레임워크**: Spring Framework 5.x
- **DB**: MySQL / MariaDB
- **ORM**: MyBatis
- **서버**: Tomcat 9
- **IDE**: Eclipse, VS Code (Dynamic Web Project)

---

## 🌟 주요 기능 (sboard)

- **회원 관리**
  - 회원가입, 로그인, 로그아웃
- **게시판 관리**
  - 게시글 목록, 작성, 수정, 삭제
  - 게시글 상세 페이지
  - 조회수 증가
  - 페이징 처리
- **관리자 페이지 (선택)**
  - 회원 관리
  - 게시글 관리
- **추가**
  - 파일 업로드 (선택적으로 구현)
  - 에러 페이지 및 예외 처리

---




   
💡 느낀 점
JSP/Servlet을 직접 다루던 것보다, 스프링 MVC의 구조화 덕분에 유지보수가 훨씬 편리해졌음.

MyBatis를 통해 SQL과 Java 객체의 매핑을 간단히 처리할 수 있어 생산성이 향상됨.

계층화된 구조로 인해, 비즈니스 로직과 화면(View) 처리가 명확히 분리됨을 체감함.

