package com.learn.lld.behavior.level1.document;

//Different doc format might have different fine details but over looking as that not main agenda.
public class Document implements DocumentInterFace {
    protected String topic;
    protected String content;

    public Document(String topic, String content) {
        this.topic = topic;
        this.content = content;
    }

    @Override
    public void setTopic(String Topic) {
        this.topic = Topic;
    }

    @Override
    public void setContent(String Content) {
        this.content = Content;
    }

    @Override
    public String readContent() {
        return topic + "Some xml tags" + content;
    }

    @Override
    public String getTopic() {
        return topic;
    }

    @Override
    public String getContent() {
        return content;
    }
}
