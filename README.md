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

## 좋은 테스트 조건
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

## Right-BICEP, 무엇을 테스트할 것인가?
- Right
    - 결과가 올바른가
- Boundary conditions
    - 경계 조건은 맞는가
    - 경게 조건(CORRECT)
        - Correct (준수)
        - Ordering (순서)
        - Range (범위)
        - Reference (참조)
        - Existence (존재)
        - Cardinality (기수)
        - Time (시간)
- Inverse relationship
    - 역 관계를 검사할 수 있는가
- Cross check
    - 다른 수단을 활용하여 교차 검사할 수 있는가
- Error conditions
    - 오류 조건을 강제로 일어나게 할 수 있는가
- Performance characteristics
    - 성능 조건은 기준에 부합하는가


## 리팩토링
- 가장 중요한 것은 이름 짓기.
    - 클래스, 메서드, 모든 종류의 변수
- 조건문은 잘 읽히는 경우가 많은데, 복잡하면 더 그렇다.
- 복잡한 부분들을 별도의 메서드로 추출하여 복잡성 고립시키기.
- 디미터의 법칙(The law of the demeter)
    - 다른 객체로 전파되는 연쇄적인 메서드 호출을 피해야 한다.

## 설계
- SOLID 클래스 설계 원칙(5대), 로버트 마틴
    - 단일 책임 원칙(SRP)
        - 클래스를 설계할 때 개념에 매핑하되 구체적인 생각에는 매핑하지 말기.
        - 어떤 클래스에 대해 단일 책임을 강조하면 변경으로 인한 리스크는 줄어든다.
        - 클래스에 더 많은 책임이 존재할수록 클래스에 있는 코드를 변경할 때 기존의 다른 동작들을 깨기 쉽다.
        - 재활용 가능. 작고 집중화된 클래스는 다른 맥락에서도 가치 제공.
    - 개방 폐쇄 원칙(OCP)
        - 클래스는 확장에 열려 있고 변경에는 닫혀 있어야 한다.
        - 기존 클래스의 변경을 최소화
    - 리스코프 치환 원칙(LSP)
        - 하위 타입은 반드시 상위 타입을 대체할 수 있어야 한다.
        - 클라이언트 입장에서 오버라이딩한 메서드가 기능성을 깨면 안된다.
    - 인터페이스 분리 원칙(ISP)
        - 클라이언트는 필요하지 않는 메서드에 의존하면 안된다.
        - 커다란 인터페이스를 다수의 작은 인터페이스로 분할해라.
    - 의존성 역전 원칙(DIP)
        - 고수준 모듈은 저수준 모듈을 의존해서는 안된다.
        - 둘 다 추상 클래스에 의존해야 한다. 
        - 추상 클래스는 구체 클래스에 의존하면 안되고, 구체 클래스는 추상 클래스에 의존해야 한다.

## 단위 테스트의 유지 보수 비용
- 시스템 설계 및 코드 품질이 낮을수록 단위 테스트의 유지 비용은 증가한다.
    - 리팩토링 후에는 테스트가 깨지는 경우가 많은데, 테스트가 동시에 깨질수록 더욱더 기존의 많은 설계 문제가 있다는 것.
- 단위 테스트를 설정하는데 코드가 몇 줄 혹은 수십 줄 필요하다면 그것은 시스템 설계에 문제가 있다는 것.
- 설계를 개선하여 단위 테스트를 쉽게 만들어야 한다.
    - 작은 코드 조각들을 단일 메서드로 추출하면 그 코드 조각들을 변경해야 할 때 미치는 영향을 최소화 가능.
    - private 메서드(구현 세부 사항)을 테스트하고픈 충동은 클래스개 필요 이상으로 커졌다는 의미. private 메서드가 계속 늘어나면 내부 동작을 새 클래스로 옮기고 public 으로 만드는 것이 좋다.
    