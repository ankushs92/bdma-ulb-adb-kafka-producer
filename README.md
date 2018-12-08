After installing Kafka:

cd /usr/local/Cellar/kafka/0.11.0.0/libexex  (Change the version 0.11.0.0)


To start zookeeper, do zkServer start

To start Kafka : 
bin/kafka-server-start.sh -daemon config/server.properties


bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 5 --topic clicks
