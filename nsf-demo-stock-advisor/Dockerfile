FROM tomcat:7.0.77-jre8

#add application jar
ADD ./nsf-demo-stock-advisor/target/*.jar /opt/nsf/

#add nsf agent jar and config file
RUN mkdir -p /opt/nsf && cd /opt/nsf && \
    wget "http://console-cust92.netease.com/download/nsf/nsf-agent-v2.6.8-c2a5e1f9-20201203-141827.jar" -O nsf-agent.jar
ADD ./nsf-demo-stock-advisor/nsf.yml /opt/nsf/nsf.yml

#add apm agent jar and config file
RUN mkdir -p /opt/apm && cd /opt/apm && \
    wget "http://console-cust92.netease.com/download/napm/napm-java-agent-v5.3.3-200428-eda3e5cb.tar.gz" -O napm-java-agent.tar.gz && \
    tar zxvf napm-java-agent.tar.gz && \
    cd ./napm-java-agent/conf && \
    echo "endpoint=http://apm-collector-cust92.netease.com" >> napm-agent.properties && \
    echo "productId=91-stock" >> napm-agent.properties && \
    echo "service=stock-advisor" >> napm-agent.properties

#add run command
ADD ./nsf-demo-stock-advisor/run.sh  /opt/nsf/
RUN chmod a+x /opt/nsf/run.sh

CMD ["/opt/nsf/run.sh"]