#!/usr/bin/env bash
java -javaagent:/opt/nsf/nsf-agent.jar=nsf -javaagent:/opt/apm/skywalking-napm-bin-8.10.0-latest/agent/skywalking-agent.jar -Dskywalking_config=/opt/apm/skywalking-napm-bin-8.10.0-latest/agent/config/agent.config -jar /opt/nsf/nsf-spring-provider-0.0.1-SNAPSHOT.jar
