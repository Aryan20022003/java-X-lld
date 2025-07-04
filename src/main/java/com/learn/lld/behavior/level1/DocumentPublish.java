package com.learn.lld.behavior.level1;

import com.learn.lld.behavior.level1.document.Document;
import com.learn.lld.behavior.level1.publish.PublishInterface;
import com.learn.lld.behavior.level1.publish.RepoPublisher;
import com.learn.lld.behavior.level1.publish.WebPublisher;

public class DocumentPublish {
    public static String webPublish(Document doc, String publishTargetUrl) {
        PublishInterface webPublisher = new WebPublisher(publishTargetUrl);
        return webPublisher.execute(doc);
    }

    public static String RepoPublish(Document doc, String publishTargetUrl) {
        PublishInterface repoPublisher = new RepoPublisher(publishTargetUrl);
        return repoPublisher.execute(doc);
    }
}
