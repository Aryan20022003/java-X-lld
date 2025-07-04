package com.learn.lld.behavior.level1.publish;

import com.learn.lld.behavior.level1.document.Document;

public class WebPublisher implements PublishInterface {
    private PublishInterface next;
    private String publishLocUrl;

    WebPublisher(String publishLocUrl) {
        this.publishLocUrl = publishLocUrl;
        next = null;
    }

    @Override
    public String execute(Document doc) {
        // some webPublish specific operation

        return "document published to location: " + publishLocUrl;
    }

    @Override
    public void setNext(PublishInterface next) {
        this.next = next;
    }

}
