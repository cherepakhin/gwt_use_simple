### Установка
java 17
````shell
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64/
````

### Сборка
````shell
./mvnw clean package
````

### Запуск
В одном окне запустить CodeServer (./run1_codeserver.sh):

````shell
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64/
./mvnw gwt:codeserver -pl *-client -am
````

В другом окне запустить приложение (./run2_jetty.sh):

````shell
./mvnw jetty:run -pl *-server -am -Denv=dev
````

Открыть [http://127.0.0.1:8080/](http://127.0.0.1:8080/)

![doc/gwt_use_simple.png](doc/gwt_use_simple.png)