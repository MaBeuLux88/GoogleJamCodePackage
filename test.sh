#!/bin/bash
time mvn exec:java -Dexec.mainClass="com.google.Main" | grep -v "\[INFO\]"
res=$(diff -B sample.out result.out)
if [ "$res" != "" ]
then
  diff -yB sample.out result.out
else
  echo " **********"
  echo " *** OK ***" 
  echo " **********"
fi
