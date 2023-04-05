FROM tomcat:7.0.77-jre8

#add application jar
ADD nsf-demo-stock-provider/target/*.jar /opt/nsf/

#add nsf agent jar and config file
#RUN mkdir -p /opt/nsf && \
#    wget -q http://console.qz.sf.163.com/download/nsf/nsf-boot.jar -O /opt/nsf/nsf-agent.jar
ADD nsf-agent.jar /opt/nsf/
	
ADD nsf-demo-stock-provider/nsf.yml /opt/nsf/

#add apm agent jar and config file
RUN mkdir -p /opt/apm && \
    cd /opt/apm/ && \
    wget -q http://console.qz.sf.163.com/download/napm/skywalking-napm-bin-8.10.0-latest.tar.gz -O skywalking-napm-bin-8.10.0-latest.tar.gz && \
    tar zxvf skywalking-napm-bin-8.10.0-latest.tar.gz && \
    cd ./skywalking-napm-bin-8.10.0-latest/agent/config && \
    # productId用于表示APM中唯一的应用，名称不可修改
    echo 'agent.authentication=My1kZW1v' > agent.config && \
    # service 为APM中监控服务的名称
    echo 'agent.service_name=nsf-provider' >> agent.config && \
    # 注册服务和数据上传地址
    echo 'collector.backend_service=apm-otel-collector.rhzz.poc.com:11800' >> agent.config && \
    # 3秒内采集trace上限，默认10000条 （-1代表全部采集）
    echo 'agent.sample_n_per_3_secs=10000' >> agent.config

#add run command
ADD nsf-demo-stock-provider/run.sh  /opt/nsf/
RUN chmod a+x /opt/nsf/run.sh

CMD ["/opt/nsf/run.sh"]
