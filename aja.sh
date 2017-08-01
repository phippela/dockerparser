docker run -it     -p 8084:8080     -v $(pwd)/target/PowerParser.war:/usr/local/tomcat/webapps/ROOT.war     -v $(pwd)/target/PowerParser:/usr/local/tomcat/webapps/ROOT     tomcat
