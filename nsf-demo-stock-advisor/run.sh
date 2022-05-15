#!/usr/bin/env bash
java -javaagent:/opt/nsf/nsf-agent.jar=nsf -javaagent:/opt/apm/skywalking-napm-bin-8.5.0-latest/agent/skywalking-agent.jar -Dskywalking_config=/opt/apm/skywalking-napm-bin-8.5.0-latest/agent/config/agent.config -jar /opt/nsf/nsf-demo-stock-advisor-1.0-SNAPSHOT.jar
