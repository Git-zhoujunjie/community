## 我的社区
从零开始

## 资料
[Spring 文档](https://spring.io/guides/gs/serving-web-content/)  
[github修改ssh-key](https://github.com/Git-zhoujunjie/community/settings/keys)  
[es社区](https://elasticsearch.cn/)  
[GitHub OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)  
[Bootstrap](http://v3.bootcss.com/getting-started)  
[HikariCP](https://docs.spring.io/spring-boot/docs/2.2.0.RC1/reference/htmlsingle/#boot-features-connect-to-production-database)  
[devtools热部署](https://docs.spring.io/spring-boot/docs/2.0.0.RC1/reference/htmlsingle/#using-boot-devtools)  


## 工具
[git](https://git-scm.com/download)  
jdk 8  
idea  
github  
[Visual-Paradigm](https://www.visual-paradigm.com)  
[Flyway](https://flywaydb.org/getstarted/firststeps/maven)  
[Lombok](https://projectlombok.org/)
[LiveReload前台页面热部署](http://livereload.com/extensions/)  

## 脚本
```sql
create table USER
(
  ID           INTEGER auto_increment,
  ACCOUNT_ID   VARCHAR(100),
  NAME         VARCHAR(50),
  TOKEN        CHAR(36),
  GMT_CREATE   BIGINT,
  GMT_MODIFIED BIGINT,
  constraint USER_PK
    primary key (ID)
);
```  
```bash
mvn flyway:migrate
```