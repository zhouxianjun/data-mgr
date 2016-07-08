@echo off
chcp 65002
title "data-mgr-core"
echo 'Ready to running the I/O service...'
echo 'Startup the I/O Service.'
java -hotspot -da -Xss128k -XX:MaxPermSize=64m -XX:+UseParallelGC -XX:ParallelGCThreads=4 -XX:+UseParallelOldGC -XX:+UseAdaptiveSizePolicy -cp ./config;./lib/*;data-mgr-core.jar com.alone.core.Server
pause