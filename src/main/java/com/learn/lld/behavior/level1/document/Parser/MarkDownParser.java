package com.learn.lld.behavior.level1.document.Parser;

import java.util.logging.Logger;

import com.learn.lld.behavior.level1.document.Document;

public class MarkDownParser implements ParserInterface {
    private static final Logger logger = Logger.getLogger(MarkDownParser.class.getName());

    @Override
    public Document inputDocumentParser(String signedUrl) {
        logger.info("Parsing markdown document from url: " + signedUrl);
        // some logic to parse markdown and convert it into internal DocumentFormat
        return new Document("dummy topic", "dummy Content markdown");
    }

    @Override
    public String outputDocumentParser(Document file) {
        logger.info("Converting Document to markdown output for topic: " + file.getTopic());
        return file.getTopic() + file.getContent();
    }

}