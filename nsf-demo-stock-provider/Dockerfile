FROM tomcat:7.0.77-jre8

#add application jar
ADD ./nsf-demo-stock-provider/target/*.jar /opt/nsf/

#add nsf agent jar and config file
RUN mkdir -p /opt/nsf && cd /opt/nsf && \
    wget "http://console-cust92.netease.com/download/nsf/nsf-agent-v2.6.8-c2a5e1f9-20201203-141827.jar" -O nsf-agent.jar
ADD ./nsf-demo-stock-provider/nsf.yml /opt/nsf/nsf.yml

#add run command
ADD ./nsf-demo-stock-provider/run.sh  /opt/nsf/
RUN chmod a+x /opt/nsf/run.sh

CMD ["/opt/nsf/run.sh"]