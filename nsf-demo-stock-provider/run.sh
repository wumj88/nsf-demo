#!/usr/bin/env bash
java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=44124 -javaagent:/opt/nsf/nsf-agent.jar=nsf -javaagent:/opt/apm/skywalking-napm-bin-8.10.0-latest/agent/skywalking-agent.jar -Dskywalking_config=/opt/apm/skywalking-napm-bin-8.10.0-latest/agent/config/agent.config -jar /opt/nsf/nsf-demo-stock-provider-1.0-SNAPSHOT.jar
