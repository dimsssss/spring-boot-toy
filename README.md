# spring-boot-toy

## 개요
Spring boot에 익숙해지기 위한 토이 프로젝트.

## 실행

두 개의 개발 환경을 동시에 사용하면 충돌납니다. 반드시 하나의 환경에서만 실행하세요


```shell
# develop
docker-compose -f ./dev-compose.yaml up -d

# delete
docker-compose down
```

```shell
# prod
docker-compose -f ./compose.yaml up -d --build

# delete
docker-compose down
```