# The geohash udf for hive

## How to compile

1. get the Hive from apache
2. clone the repo to the same machine
3. get the spark library from dependencies in the ```.classpath``` dotfile
```
cd $HIVE_HOME/lib directory && wget https://repo.typesafe.com/typesafe/maven-releases/org/apache/spark/spark-assembly_2.11/1.4.1-hadoop2.6-typesafe-001/spark-assembly_2.11-1.4.1-hadoop2.6-typesafe-001.jar
```
4. fix the links in the ```.classpath``` dotfile with the actual path to the hive
5. run ```mvn package``` (assuming you have installed maven)
6. see the jar files in the target directory
