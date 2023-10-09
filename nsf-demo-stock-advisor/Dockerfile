ARG BASE_IMAGE=artifactory.jfyl.upgrade.test.com/library/cicd-mvn3.5-jdk8:v2.1.1

FROM ${BASE_IMAGE}

ENV TZ=Asia/Shanghai LANG=C.UTF-8 LANGUAGE=C.UTF-8 LC_ALL=C.UTF-8

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone


#add nsf agent jar and config file
RUN mkdir -p /opt/nsf && cd /opt/nsf && \
    curl -O http://console.jfyl.upgrade.test.com/download/nsf/nsf-agent-fat.jar


ADD ./nsf-demo-stock-advisor/nsf.yml /opt/nsf/nsf.yml
#add application jar
ADD ./nsf-demo-stock-advisor/target/*.jar /opt/nsf/

#add apm agent jar and config file
# RUN mkdir -p /opt/apm && cd /opt/apm && \
#     wget "http://console.qz.sf.163.com/download/napm/skywalking-napm-bin-8.10.0-latest.tar.gz" -O skywalking-napm-bin-8.10.0-latest.tar.gz && \
#     tar zxvf skywalking-napm-bin-8.10.0-latest.tar.gz && \
#     cd ./skywalking-napm-bin-8.10.0-latest/agent/config && \
#     echo "collector.backend_service=apm-otel-collector.qz.sf.163.com:11800" >> agent.config && \
#     echo "agent.authentication=MTgtc29sdXRpb24=" >> agent.config && \
#     echo "agent.service_name=nsf-advisor" >> agent.config

ENV JAVA_OPTS='-javaagent:/opt/nsf/nsf-agent-fat.jar=nsf -Dstock_provider_url=http://nsf-provider -Dstock_viewer_url=http://nsf-viewer'

CMD java $JAVA_OPTS -jar /opt/nsf/nsf-demo-stock-advisor-1.0-SNAPSHOT.jar
