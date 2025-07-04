package com.learn.lld.behavior.level1.publish;

import com.learn.lld.behavior.level1.document.Document;

public interface PublishInterface {
    public String execute(Document doc);

    public void setNext(PublishInterface next);
}
