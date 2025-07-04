package com.learn.lld.behavior.level1.publish;

import com.learn.lld.behavior.level1.document.Document;

public class RepoPublisher implements PublishInterface {
    private PublishInterface next;
    private String repoName;

    RepoPublisher(String repoName) {
        this.repoName = repoName;
        next = null;
    }

    @Override
    public String execute(Document doc) {
        // some webPublish specific operation

        return "document published to location: " + repoName;
    }

    @Override
    public void setNext(PublishInterface next) {
        this.next = next;
    }
}
