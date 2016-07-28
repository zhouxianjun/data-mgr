#!/bin/sh
echo 'Ready to running the I/O service...'
#OPTS="-server \
#	  -da \
#	  -Xms512m \
#	  -Xmx512m \
#	  -Xss128k \
#	  -XX:MaxPermSize=64m \
#	  -XX:+UseParallelGC \
#	  -XX:ParallelGCThreads=4 \
#	  -XX:+UseParallelOldGC \
#	  -XX:+UseAdaptiveSizePolicy"

OPTS="-server \
	  -da \
	  -Xms512m \
	  -Xmx1024m \
	  -Xss256k \
	  -XX:PermSize=128m \
	  -XX:MaxPermSize=256m \
	  -XX:SurvivorRatio=9 \
	  -XX:+UseConcMarkSweepGC \
	  -XX:ParallelCMSThreads=4 \
	  -XX:MaxTenuringThreshold=4 \
	  -XX:+UseCMSCompactAtFullCollection \
	  -XX:CMSFullGCsBeforeCompaction=4 \
	  -XX:+CMSParallelRemarkEnabled \
	  -XX:+CMSScavengeBeforeRemark \
	  -XX:+CMSClassUnloadingEnabled \
	  -XX:+UseCMSInitiatingOccupancyOnly \
	  -XX:CMSInitiatingOccupancyFraction=80 \
	  -XX:CMSInitiatingPermOccupancyFraction=92 \
	  -XX:SoftRefLRUPolicyMSPerMB=0 \
	  -XX:+UseFastAccessorMethods \
	  -XX:+AggressiveOpts \
	  -XX:+UseBiasedLocking \
      -XX:+HeapDumpOnOutOfMemoryError \
      -XX:MaxDirectMemorySize=1024m"

env LC_ALL="en_US.UTF-8" java $OPTS -cp ./config:$JRE_HOME/lib/*:./lib/*:data-mgr-core.jar com.alone.core.Server &

echo $! > service.pid
echo 'Startup the I/O Service.'

