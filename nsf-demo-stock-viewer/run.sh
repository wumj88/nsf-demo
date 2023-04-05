#!/usr/bin/env bash
java -javaagent:/opt/nsf/nsf-agent.jar=nsf -Dstock_provider_url=http://nsf-provider -Dstock_advisor_url=http://nsf-advisor -Dserver.port=8080 -javaagent:/opt/apm/skywalking-napm-bin-8.10.0-latest/agent/skywalking-agent.jar -Dskywalking_config=/opt/apm/skywalking-napm-bin-8.10.0-latest/agent/config/agent.config -jar /opt/nsf/nsf-demo-stock-viewer-1.0-SNAPSHOT.jar
