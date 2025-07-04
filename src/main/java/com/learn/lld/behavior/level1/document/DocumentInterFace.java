package com.learn.lld.behavior.level1.document;

//only dealing with pdf and word doc format now only 
//as core logic can be described with 2 only.
//this is universal internal document representation 
public interface DocumentInterFace {
    public void setTopic(String Topic);

    public void setContent(String Content);

    public String readContent();

    public String getTopic();

    public String getContent();
}
