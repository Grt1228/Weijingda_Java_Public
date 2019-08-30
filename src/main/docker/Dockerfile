 #FROM ，表示使用 Jdk8 环境 为基础镜像，如果镜像不是本地的会从 DockerHub 进行下载
 #VOLUME ，VOLUME 指向了一个/tmp的目录，由于 Spring Boot 使用内置的Tomcat容器，Tomcat 默认使用/tmp作为工作目录。这个命令的效果是：在宿主机的/var/lib/docker目录下创建一个临时文件并把它链接到容器中的/tmp目录
 #ADD ，拷贝文件并且重命名
 #ENTRYPOINT ，为了缩短 Tomcat 的启动时间，添加java.security.egd的系统属性指向/dev/urandom作为 ENTRYPOINT
 #git pull
	#mvn clean
	#mvn package docker:build
	#docker run -d -p 8888:8888 jgsu/jgsu

FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD jgsu.jar jgsu.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/jgsu.jar"]



