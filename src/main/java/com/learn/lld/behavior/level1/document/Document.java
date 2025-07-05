package com.learn.lld.behavior.level1.document;

import java.util.logging.Logger;

//Different doc format might have different fine details but over looking as that not main agenda.
public class Document implements DocumentInterFace {
    private static final Logger logger = Logger.getLogger(Document.class.getName());
    protected String topic;
    protected String content;

    public Document(String topic, String content) {
        logger.info("Creating Document with topic: " + topic);
        this.topic = topic;
        this.content = content;
    }

    @Override
    public void setTopic(String Topic) {
        logger.info("Setting topic: " + Topic);
        this.topic = Topic;
    }

    @Override
    public void setContent(String Content) {
        logger.info("Setting content: " + Content);
        this.content = Content;
    }

    @Override
    public String readContent() {
        logger.info("Reading content for topic: " + topic);
        return topic + "Some xml tags" + content;
    }

    @Override
    public String getTopic() {
        logger.info("Getting topic: " + topic);
        return topic;
    }

    @Override
    public String getContent() {
        logger.info("Getting content for topic: " + topic);
        return content;
    }
}
