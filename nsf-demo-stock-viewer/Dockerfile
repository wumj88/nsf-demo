FROM tomcat:7.0.77-jre8

#add application jar
ADD ./nsf-demo-stock-viewer/target/*.jar /opt/nsf/

#add nsf agent jar and config file
RUN mkdir -p /opt/nsf && cd /opt/nsf && \
    wget "http://console-poc31.netease.com/download/nsf/nsf-agent-v2.6.8-c2a5e1f9-20201203-141827.jar" -O nsf-agent.jar
ADD ./nsf-demo-stock-viewer/nsf.yml /opt/nsf/nsf.yml

#add apm agent jar and config file
RUN mkdir -p /opt/apm && cd /opt/apm && \
    wget "http://console-poc31.netease.com/download/napm/napm-java-agent-v5.4.9-201112-26f1516.tar.gz" -O napm-java-agent.tar.gz && \
    tar zxvf napm-java-agent.tar.gz && \
    cd ./napm-java-agent/conf && \
    echo "endpoint=http://apm-collector-poc31.netease.com" >> napm-agent.properties && \
    echo "productId=25-stock" >> napm-agent.properties && \
    echo "service=stock-viewer" >> napm-agent.properties

#add run command
ADD ./nsf-demo-stock-viewer/run.sh  /opt/nsf/
RUN chmod a+x /opt/nsf/run.sh

CMD ["/opt/nsf/run.sh"]