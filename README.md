<div align="center">

<!-- logo -->
<img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyNDA2MjBfMjI0%2FMDAxNzE4ODU0NjE2NTEx.EGlSQtG4A7foGqij66is5ReorZZlNs0FSQljZxpbqmcg.62caY61ZYGQ9Vo3D5N-OzibHQJWWgaiXPUZxYZqmW0og.JPEG%2FGettyImages-jv13450691_%25281%2529.jpg&type=sc960_832" width="400"/>

### '나'를 보여주기 위한 포트폴리오 토이 프로젝트 ✅

<!-- logo [<img src="https://img.shields.io/badge/-spring boot-important?style=flat&logo=spring-boot&logoColor=white" />]() 
[<img src="https://img.shields.io/badge/-spring boot jpa-important?style=flat&logo=java&logoColor=white" />]() 
[<img src="https://img.shields.io/badge/-notion-black?style=flat&logo=notion&logoColor=white" />]() 
[<img src="https://img.shields.io/badge/-java-yellow?style=flat&logo=java&logoColor=white" />]() 
[<img src="https://img.shields.io/badge/-Javascript-blue?style=flat&logo=JavaScript&logoColor=white" />]() 
[<img src="https://img.shields.io/badge/-Vue.js-blue?style=flat&logo=Vue.js&logoColor=white" />]() 
[<img src="https://img.shields.io/badge/MySQL-v8.0.37 -yellow?style=flat&logo=MySQL&logoColor=white" />]() -->
<br/> 

</div> 

### 📝 프로젝트 소개

- 기술 적용 및 연습을 위한 개인 프로젝트입니다.
- 기능
  + 회원가입
  + 로그인 (JWT 적용)
  + 음악
    + 음악 업로드
    + 장르 및 키워드 조회
    + 음악 OpenApi인 maniadb를 사용한 음악정보 조회
  + 강아지 사진 업로드
  + 음식 사진 업로드
  + 여행 사진 업로드
  + 취미
    + 키보드 정보 등록

<br />

### ERD 데이터 모델링
<img src="https://github.com/user-attachments/assets/59b0ca3d-89f3-4098-9087-f07223bc9c2e" width="600"/>

<br />

## 🗂️ APIs

<img src="https://github.com/user-attachments/assets/597f4bf5-9900-4352-927d-6085fc76d995" width="600"/>

<br />

## 프론트 화면
|메인 화면|음악 페이지|
|:---:|:---:|
|<img src="https://github.com/user-attachments/assets/a3e13146-0a5f-43aa-b68c-d1229382edd8" width="400"/>|<img src="https://github.com/user-attachments/assets/0c20390f-cfee-4472-9cf5-1068756de792" width="400"/>|


## ⚙ 기술 스택
### Back-end
<div>
<img src="https://github.com/yewon-Noh/readme-template/blob/main/skills/Java.png?raw=true" width="80">
<img src="https://github.com/yewon-Noh/readme-template/blob/main/skills/SpringBoot.png?raw=true" width="80">
<img src="https://github.com/yewon-Noh/readme-template/blob/main/skills/SpringSecurity.png?raw=true" width="80">
<img src="https://github.com/yewon-Noh/readme-template/blob/main/skills/SpringDataJPA.png?raw=true" width="80">
<img src="https://github.com/yewon-Noh/readme-template/blob/main/skills/Mysql.png?raw=true" width="80">
<img src="https://github.com/yewon-Noh/readme-template/blob/main/skills/Redis.png?raw=true" width="80">
</div>

### Front-end
<div>
<img src="https://github.com/yewon-Noh/readme-template/blob/main/skills/JavaScript.png?raw=true" width="80">
<img src="https://github.com/user-attachments/assets/37851a02-8773-4c05-be06-f3653fe918d1" width="80">
</div>

### Tools
<div>
<img src="https://github.com/yewon-Noh/readme-template/blob/main/skills/Github.png?raw=true" width="80">
<img src="https://github.com/yewon-Noh/readme-template/blob/main/skills/Notion.png?raw=true" width="80">
</div>

<br />

## 추가해보고 싶은 기능
- JWT 보안 취약점을 위한 RTR 기법 적용
- 개별 사진에 대한 좋아요 기능

<br />

## 🤔 기술적 이슈와 해결 과정
- 유저와 권한 JPA 다대다 테이블 매핑 이슈
  + 유저와 권한 테이블을 1:N, N:1 로 구현
    1. User, UserAhthority, Authority 테이블로 구성하였으나 JPA를 통해 각 Repository로 저장 시 DuplcatedKey Exception이 발생
    2. 쿼리 확인 시 중간테이블 Entity인 UserAuthority를 저장하는 과정에서 User와 Authority도 저장을 시도하는 쿼리로 인해 Exception이 발생하는 것을 확인
    3. 중간 테이블인 UserAhthority에 ID를 EmbededId를 사용하여 UserID와 AhthorityName을 복합 키로 사용하였기에 등록해주지 않으면 저장불가
    4. User와 Authority를 중간테이블 엔티티에 등록하여 중간 테이블 Insert과정으로 한 번에 등록하도록 변경하여 해결
    5. 신규 유저에게 이미 있는 권한(Authority)를 등록할 시 권한을 조회하여 영속성 컨텍스트에 등록 후 5번 과정을 통해 해결

|신규 유저 및 권한 등록|신규 유저 등록|
|:---:|:---:|
|<img src="https://github.com/user-attachments/assets/cba5a685-4528-4c19-94aa-4ee7af16ade4" width="400"/>|<img src="https://github.com/user-attachments/assets/c6ede36d-64f9-48a7-ace2-ade62622bb5a" width="400"/>|
<!--- Jwt 탈취 취약점 보완
  + Jwt에 대한 공부를 하던 중 JWT의 취약점에 대한 공부를 통해 Security 코딩의 중요성을 발견
  + Access Token 외에 Refresh Token을 사용하는 RTR 기법을 적용
  + Refresh Token 저장을 위해 Redis를 도입하여 저장 -->
- Service 테스트 코드 오류
  + Service 코드를 테스트하기 위해 Service 객체를 @Autowired하여 Bean을 주입하였으나 Repository가 null이 발생
  + Test용 Repository를 Mock객체를 만들어 given, when, then을 작성하여 해결
<br />
