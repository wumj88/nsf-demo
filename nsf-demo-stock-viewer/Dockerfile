FROM tomcat:7.0.77-jre8

#add application jar
ADD target/*.jar /opt/nsf/

#add nsf agent jar and config file
RUN mkdir -p /opt/nsf && \
    wget -q "http://console-cust92.netease.com/download/nsf/nsf-agent-v2.6.8-c2a5e1f9-20201203-141827.jar" -O /opt/nsf/nsf-agent.jar
	
ADD nsf.yml /opt/nsf/nsf.yml

#add apm agent jar and config file
RUN mkdir -p /opt/apm && \
    wget -q "http://console-cust92.netease.com/download/napm/skywalking-napm-bin-8.0.0-latest.tar.gz" -O /opt/apm/napm-java-agent.tar.gz && \
    tar zxvf napm-java-agent.tar.gz && \
    cd ./napm-java-agent/agent/config && \
        # productId用于表示APM中唯一的应用，名称不可修改
	echo 'agent.authentication=51-nsf-stock-viewer' >> agent.config && \
	# service 为APM中监控服务的名称（进程功能，如管理服务器）
	echo 'agent.service_name=nsf-stock-viewer' >> agent.config && \
	# 注册服务和数据上传地址
	echo 'collector.backend_service=apm-otel-collector-cust92.netease.com:11800' >> agent.config && \
	# 3秒内采集trace上限，默认10000条 （-1代表全部采集）
	echo 'agent.sample_n_per_3_secs=10000' >> agent.config

#add run command
ADD run.sh  /opt/nsf/
RUN chmod a+x /opt/nsf/run.sh

CMD ["/opt/nsf/run.sh"]

