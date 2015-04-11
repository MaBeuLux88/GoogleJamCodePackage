#!/bin/bash
mkdir -p save_problem/old_problems
mv -f save_problem/*in save_problem/old_problems/ 2> /dev/null
mv ~/Downloads/*in save_problem/
cp save_problem/*in problem.in 
mvn exec:java -Dexec.mainClass="com.google.Main"
./archive.sh
