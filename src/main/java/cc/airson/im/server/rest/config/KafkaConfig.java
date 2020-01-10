package cc.airson.im.server.rest.config;

/**
 * TODO
 *
 * @author airson
 */
//@Configuration
//@EnableKafka
public class KafkaConfig {

    /*@Bean
    public NewTopic adviceTopic() {
        return new NewTopic("demoTopic", 3, (short) 1);
    }*/

    /**
     * KafkaTemplate
     *
     * @return KafkaTemplate
     */
    /*@Bean
    public KafkaTemplate<Object, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory(), true);
    }*/

    /**
     * ProducerFactory
     *
     * @return
     */
    /*@Bean
    public ProducerFactory<Object, Object> producerFactory() {
        Map<String, Object> configs = new HashMap<>(); //参数
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, producerBootstrapServers);
        configs.put(ProducerConfig.RETRIES_CONFIG, producerRetries);
        configs.put(ProducerConfig.BATCH_SIZE_CONFIG, producerBatchSize);
        configs.put(ProducerConfig.LINGER_MS_CONFIG, producerLingerMs);
        configs.put(ProducerConfig.BUFFER_MEMORY_CONFIG, producerBufferMemory);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);

        return new DefaultKafkaProducerFactory<>(configs);
    }*/

    /**
     * ConsumerFactory
     *
     * @return
     */
    /*@Bean
    public ConsumerFactory<Object, Object> consumerFactory() {
        Map<String, Object> configs = new HashMap<>(); //参数
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, consumerBootstrapServers);
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);
        configs.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, consumerEnableAutoCommit);
        configs.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, consumerAutoCommitIntervalMs);
        configs.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, consumerSessionTimeoutMs);
        configs.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, consumerMaxPollRecords); //批量消费数量
        configs.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, consumerAutoOffsetReset);
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(configs);
    }*/

    /**
     * 添加KafkaListenerContainerFactory，用于批量消费消息
     *
     * @return
     */
    /*@Bean
    public KafkaListenerContainerFactory<?> batchContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Object, Object> containerFactory = new ConcurrentKafkaListenerContainerFactory<Object, Object>();
        containerFactory.setConsumerFactory(consumerFactory());
        containerFactory.setConcurrency(4);
        containerFactory.setBatchListener(true); //批量消费
        containerFactory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);

        return containerFactory;
    }*/

}
