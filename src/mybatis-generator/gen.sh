#!/bin/bash
CLASSPATH=mysql-connector-java-5.1.37.jar:mapper-3.3.0.jar:mybatis-generator-core-1.3.2.jar
mainClassName=org.mybatis.generator.api.ShellRunner
java -classpath "$CLASSPATH" "$mainClassName" -configfile generatorConfig_$1.xml -overwrite