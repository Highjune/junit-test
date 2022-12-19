# junit-test

## 책 [자바와 JUnit을 활용한 실용주의 단위테스트](http://www.yes24.com/Product/Goods/75189146) 실습하는 저장소

## 환경
- Junit4
- https://start.spring.io/ 에서 프로젝트 세팅
    - Gradle, java11
    - Dependencies
        - Spring Web
- 요즘 스프링 부트버전에서는 Junit이 기본적으로 5버전(jupiter)이다. 4버전(vintage)을 받으려면 build.gradle 수정
    - 원래 build.gradle 중 테스트 부분
    ```
    dependencies {
        ...(생략)...
        testImplementation 'org.springframework.boot:spring-boot-starter-test' // junit5 버전 포함.
        ...(생략)...
    }
    ```
    - 수정한 build.gradle 중 테스트 부분
    ```
    dependencies {
        ...(생략)...
        testImplementation 'junit:junit:4.11'   // junit4 버전 명시
        ...(생략)...
    }
    ```

## 좋은 테스트 조건. FIRST
- First
    - 빠른
- Isolated
    - 고립된
- Repeatable 
    - 반복 가능한
- Self-validating 
    - 스스로 검증 가능한
- Timely
    - 적시의

## AAA
- 준비(Arrage) - given
- 실행(Act) - when
- 단언(Assert) - then

