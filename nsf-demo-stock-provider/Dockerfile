FROM tomcat:7.0.77-jre8

#add application jar
ADD ./nsf-demo-stock-provider/target/*.jar /opt/nsf/

#add nsf agent jar and config file
RUN mkdir -p /opt/nsf && cd /opt/nsf && \
    wget "http://console.0430rc.service.163.org/download/nsf/nsf-boot.jar" -O nsf-agent.jar
ADD ./nsf-demo-stock-provider/nsf.yml /opt/nsf/nsf.yml

#add run command
ADD ./nsf-demo-stock-provider/run.sh  /opt/nsf/
RUN chmod a+x /opt/nsf/run.sh

CMD ["/opt/nsf/run.sh"]