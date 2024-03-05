FROM openjdk:11 as stage1

WORKDIR /app

# gradle 빌드 시에 필요한 파일들을 workdir로 copy
# COPY 로컬파일 도커WORKDIR
# docker 내 /app/gradlew파일, gradle폴더, build.gradle파일 ... 생김
COPY gradlew .
# 폴더카피는 폴더명 지정 필요
COPY gradle gradle  
COPY build.gradle .
COPY settings.gradle .
COPY src src

# /app/build/libs/*.jar 파일 아래 명령어를 통해 생성
RUN ./gradlew bootJar

FROM openjdk:11
WORKDIR /app
COPY --from=stage1 /app/build/libs/*.jar app.jar

# -v : 볼륨 (전체호스트의 특정경로와 컨테이너 매핑)
# docker run -d -p 8080:8080 -v C:/Users/Playdata/Desktop/tmp:/tmp
VOLUME /tmp

# CMD 또는 ENTRYPOINT를 통해 컨테이너 실행
ENTRYPOINT ["java", "-jar", "app.jar"]

# docker 실행 시 db정보를 환경변수로 주입
# docker run -d -p 8080:8080 -e SPRING_DATASOURCE_URL=jdbc:mariadb://host.docker.internal:3306/spring_order

