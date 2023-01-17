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
    

## 목(mock) 객체 사용
- 테스트 하려고 하는 메서드(A) 안에 http 상의 외부 서비스의 api호출하는 부분(B)이 있다면?
    - 의존성이 있는 다른 코드와 분리해서 api호출하는 부분을 제외한 로직에 대한 테스트만 한다.
    - B부분을 믿는다면 http 호출을 준비하는 로직과 그 호출에 대한 http 응답에서 생성되는 로직을 테스트하는 것이 중요.

- Stub(스텁)
    - 테스트 용도로 하드 코딩한 값을 반환하는 구현체를 말한다.

- Mock(목)
    - 의도적으로 흉내 낸 동작을 제공하고 수신한 인자가 모두 정상인지 여부를 검증하는 일을 하는 테스트 구조물.
    - Mokito(모키토) 
        - 테스트의 기대 사항 설정은 실제 테스트보다 먼저 해야함.
        - `when(...).thenReturn(...)` 패턴은 모키토를 사용하여 목을 설정하는 여러 방법 중 하나.


## 테스트 리팩토링
- try/catch 블록제거해서 가독성 높이자
    - Junit이 테스트에서 던지는 예외들을 잡아 준다. 예외가 발생한 테스트는 오류로 표시되고 출력 창에 stack trace가 보임. 명시적인 try/catch 블럭은 부가 가치가 없다.
- 불필요한 유효성(ex. null 체크) 체크는 하지 않아도 된다.
    - 어차피 오류가 날 부분이라면 Junit이 이것을 잡아 테스트를 오류로 처리해준다.
- 추상화
    - 비어 있음(emptiness) 개념을 추가. 단언을 바꾸면 크기비교를 이해하는 불필요하는 정신적 노력 줄일 수 있다.
    ```java
    assertThat(list.getMatches().size(), equal(0));
    ```
    ```java
    assertThat(list.getMatches().isEmpty());
    ```
- 부적절한 정보
    - 프로그래밍에서 상수로 선언하지 않은 숫자 리터럴을 '메직 넘버'라고 하는데, 코드에는 되도록 사용하면 안된다.
    - 아래에서는 1이 의미도 없을 뿐더러, 알아보기 위해서 Search 클래스를 또 찾아봐야 하는 번거로움이 있다.
    ```java
    Search search = new Search(stream, "practical joke", 1);
    ```
    - 상수로 변경(의미를 분명하게 전달 가능)
    ```java
    ...
    private static final String ANY_TITLE = 1;

    Search search = new Search(stream, "practical joke", ANY_TITLE);    
    ```

- 부푼 생성
    - Stream 객체의 생성자에 InputStream객체를 넘겨야 하는 상황.
    - 정신 산란한 세부 사항을 숨겨서 훨씬 쉽게 변환
    - 기존
    ```java
    String pageContent = "asdjflakdsjflaksjdflaksjdflkasjdflkasjdflkjsadlfkjasdl;fkjas;ldkjf;laskdjfl;askdjf;asjkf;sad"
    bytep[] bytes = pageContent.getbytes();
    ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
    ```
    - 수정 후
    ```java
    ...
    private static final String ANY_TITLE = 1;


    @Test
    pubilc void testSearch() throws IOException {
        
        InputStream stream = 
            streamOn("asdjflakdsjflaksjdflaksjdflkasjdflkasjdflkjsadlfkjasdl;fkjas;ldkjf;laskdjfl;askdjf;asjkf;sad");
        
        Search search = new Search(stream, "practical joke", ANY_TITLE);
    }

    private InputStream streamOn(String pageContent) {
        return new ByteArrayInputStream(pageContent.getByteS());
    }

    ```
- 하나의 단언
    - 하나의 테스트 안에 여러 단언이 있다는 것은 그 안에 여러 테스트가 있다는 것을 의미한다.
    - 불필요한 주석 제거하기. 단일 목적의 테스트는 주석이 없어도 더 나은 테스트 이름으로 대신할 수 있다.

- 테스트와 무관한 세부 사항들
    - @Before와 @After로 옮기자
    - 예를 들어 테스트를 실행할 때는 로그를 끄지만 그렇게 하는 코드는 테스트의 정수를 이해하는데 방해가 된다.
    - 또는 스트림을 사용한 후에는 닫아야 하지만 그것 또한 테스트에는 군더더기가 될 수도 있다.
    ```java
    private InputStream stream;

    @Before
    public void turnOffLogging() {
        Search.LOGGER.setLevel(Level.OFF);
    }

    @After
    public void closeResources() throws IOException {
        stream.close();
    }
    ```
- 테스트에서 어느 부분들이 준비(Arrange), 실행(Act), 단언(Assert) 부분인지 아는 것은 매우 중요
    - 빈 줄로 구분하자
    ```java
    ~~~~~~~~(준비 Arrage 하는 코드~~~~~~)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    (한 줄 공백)
    ~~~~~~~~(실행 Act 하는 코드)~~~~~~~~
    (한 줄 공백)
    ~~~~~~~
    ```

- 암시적 의미
    - `왜 그러한 결과를 기대하는가?` 가 매우 중요
    - 좀 더 나은 테스트 데이터를 골라서 명시적으로 바꿔보기
    ```java
    stream = streamOn("any text"); // 어떠한 텍스트라도 들어올 수도 있다는 의미
    Search search = new Search(stream, "text that doesn't match", A_TITLE);
    ```
    - 위에서 "text that doesn't match" 를 통해 테스트 의도를 더 명확하게 표현할 수 있다.
