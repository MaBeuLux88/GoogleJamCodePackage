#!/bin/bash
time mvn exec:java -Dexec.mainClass="com.google.Solution" < problem.in 2>/dev/null | grep -v "[INFO]" > result.out
res=$(diff sample.out result.out)
if [ "$res" != "" ]
then
  diff -y sample.out result.out
else
  echo " **********"
  echo " *** OK ***" 
  echo " **********"
fi
