# Spring-multi-module-starter
### Spring starter with multi gradle modules
멀티모듈 세팅시 소요되는 시간 및 비용을 최소화하기 위해 만든 템플릿입니다. <br/>
Gradle 멀티모듈 방식의 레이어 아키텍쳐로 구성하였으며, DB 이미지 관련 설정은 docker-compose.yml을 확인하시면 됩니다.

#### How to Run
    Docker 환경에서 실행
    1. docker-compose.yml에서 사용할 DB 주석 제거 (Default: MySQL 이미지 사용)
    2. docker-compose up -d로 DB, 서버 컨테이너 실행

    Java 환경에서 실행
    1. spring-starter 디렉토리의 build.gradle를 build
    2. 사용하는 DB에 따라 api 모듈의 resources 디렉토리의 application.yaml을 수정 (Default: MySQL)
    3. api 모듈의 StarterApiApplication 실행
    
#### Directory Tree
    api: Controller 레이어
    application: Service 및 Req/Res Dto 레이어
    domain: Dao 및 Entity 레이어