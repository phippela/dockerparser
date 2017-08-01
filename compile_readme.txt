1) setup maven
http://geekyplatypus.com/packaging-and-serving-your-java-application-with-docker/

2) compile
./compile.sh

3) start docker (in own terminal)
./aja.sh

4) test setup
curl -d @testi.txt http://localhost:8084/parse
<html>
<body>
<h1>Hello Servlet Post</h1>
1:Koira haukkui, pomppi ja kieriskeli maassa. Suuri tammi hetti varjon lämpimäll kesä-niitylle.Oli kuitenkin kaikkille selvää, että oli tulossa synkkä ja myrskyinen yö.
</body>
</html>

5) Note that output comes to the docker terminal (with possible exceptions)

01-Aug-2017 10:27:29.831 INFO [main] org.apache.catalina.startup.Catalina.start Server startup in 1659 ms
We are parsing...

6) what happens behind the scene

➜  dockerised-java git:(master) ✗ cat aja.sh
docker run -it     -p 8084:8080     -v $(pwd)/target/PowerParser.war:/usr/local/tomcat/webapps/ROOT.war     -v $(pwd)/target/PowerParser:/usr/local/tomcat/webapps/ROOT     tomcat
➜  dockerised-java git:(master) ✗ docker images | grep tomcat
tomcat              latest              dda2b9b0aefd        7 weeks ago         339.1 MB
➜  dockerised-java git:(master) ✗
