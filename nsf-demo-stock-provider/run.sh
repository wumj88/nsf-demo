#!/usr/bin/env bash
java -javaagent:/opt/nsf/nsf-agent.jar=nsf -Dnsf.host.enhance=true -Dsun.net.http.allowRestrictedHeaders=true -jar /opt/nsf/nsf-demo-stock-provider-1.0-SNAPSHOT.jar