package kafka;

import java.util.*;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
 
public class Producer implements RequestHandler<RequestClass, ResponseClass> {
    public ResponseClass handleRequest(RequestClass request, Context context){
        Properties props = new Properties();
        props.put("bootstrap.servers", "ec2-54-191-244-6.us-west-2.compute.amazonaws.com:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
        producer.send(new ProducerRecord<String, String>("device", "gps", request.getDeviceid() + " " + request.getLatitude() + " " + request.getLongitude()));

        producer.close();
	return new ResponseClass(request.getDeviceid() + " " + request.getLatitude() + " " + request.getLongitude());        
    }
}
