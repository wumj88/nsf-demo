ARG BASE_IMAGE=artifactory.jfyl.upgrade.test.com/library/cicd-mvn3.5-jdk8:v2.1.1

FROM ${BASE_IMAGE}

ENV TZ=Asia/Shanghai LANG=C.UTF-8 LANGUAGE=C.UTF-8 LC_ALL=C.UTF-8

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

#add application jar
ADD ./nsf-demo-stock-viewer/target/*.jar /opt/nsf/


#add apm agent jar and config file
#RUN mkdir -p /opt/apm && cd /opt/apm && \
#    wget "http://console.qz.sf.163.com/download/napm/skywalking-napm-bin-8.10.0-latest.tar.gz" -O skywalking-napm-bin-8.10.0-latest.tar.gz && \
#    tar zxvf skywalking-napm-bin-8.10.0-latest.tar.gz && \
#    cd ./skywalking-napm-bin-8.10.0-latest/agent/config && \
#    echo "collector.backend_service=apm-otel-collector.qz.sf.163.com:11800" >> agent.config && \
#    echo "agent.authentication=MTgtc29sdXRpb24=" >> agent.config && \
#    echo "agent.service_name=nsf-viewer" >> agent.config

ENV JAVA_OPTS='-Dstock_provider_url=http://nsf-provider -Dstock_advisor_url=http://nsf-advisor'

CMD java $JAVA_OPTS -jar /opt/nsf/nsf-demo-stock-viewer-1.0-SNAPSHOT.jar