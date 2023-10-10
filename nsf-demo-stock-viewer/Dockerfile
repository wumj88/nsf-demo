ARG BASE_IMAGE=artifactory.jfyl.upgrade.test.com/library/cicd-mvn3.5-jdk8:v2.1.1

FROM ${BASE_IMAGE}

ENV TZ=Asia/Shanghai LANG=C.UTF-8 LANGUAGE=C.UTF-8 LC_ALL=C.UTF-8

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

#add application jar
ADD ./nsf-demo-stock-viewer/target/*.jar /opt/nsf/


#add apm agent jar and config file
RUN mkdir -p /opt/apm && cd /opt/apm && \
   curl -o skywalking-napm-bin-8.10.0-latest.tar.gz http://console.jfyl.upgrade.test.com/download/napm/skywalking-napm-bin-8.10.0-latest.tar.gz && \
   tar zxvf skywalking-napm-bin-8.10.0-latest.tar.gz && \
   cd ./skywalking-napm-bin-8.10.0-latest/agent/config && \
   echo "collector.backend_service=apm-otel-collector.jfyl.upgrade.test.com:11800" >> agent.config && \
   echo "agent.authentication=My1kZW1v" >> agent.config && \
   echo "agent.service_name=nsf-viewer" >> agent.config && \
   echo "agent.sample_n_per_3_secs=10000" >> agent.config
   

ENV JAVA_OPTS='-Dstock_provider_url=http://nsf-provider -Dstock_advisor_url=http://nsf-advisor -javaagent:/opt/apm/skywalking-napm-bin-8.10.0-latest/agent/skywalking-agent.jar -Dskywalking_config=/opt/apm/skywalking-napm-bin-8.10.0-latest/agent/config/agent.config'

CMD java $JAVA_OPTS -jar /opt/nsf/nsf-demo-stock-viewer-1.0-SNAPSHOT.jar