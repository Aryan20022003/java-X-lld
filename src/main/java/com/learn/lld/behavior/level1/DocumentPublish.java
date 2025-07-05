package com.learn.lld.behavior.level1;

import java.util.logging.Logger;

import com.learn.lld.behavior.level1.document.Document;
import com.learn.lld.behavior.level1.publish.PublishInterface;
import com.learn.lld.behavior.level1.publish.RepoPublisher;
import com.learn.lld.behavior.level1.publish.WebPublisher;

public class DocumentPublish {
    private static final Logger logger = Logger.getLogger(DocumentPublish.class.getName());

    public static String webPublish(Document doc, String publishTargetUrl) {
        logger.info("Publishing document to web: " + publishTargetUrl + " for topic: " + doc.getTopic());
        PublishInterface webPublisher = new WebPublisher(publishTargetUrl);
        String result = webPublisher.execute(doc);
        logger.info("Web publish completed for topic: " + doc.getTopic());
        return result;
    }

    public static String RepoPublish(Document doc, String publishTargetUrl) {
        logger.info("Publishing document to repository: " + publishTargetUrl + " for topic: " + doc.getTopic());
        PublishInterface repoPublisher = new RepoPublisher(publishTargetUrl);
        String result = repoPublisher.execute(doc);
        logger.info("Repository publish completed for topic: " + doc.getTopic());
        return result;
    }
}
