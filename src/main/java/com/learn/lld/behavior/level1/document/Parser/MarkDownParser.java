package com.learn.lld.behavior.level1.document.Parser;

import com.learn.lld.behavior.level1.document.Document;

public class MarkDownParser implements ParserInterface {
    @Override
    public Document inputDocumentParser(String signedUrl) {
        // some logic to parse markdown and convert it into internal DocumentFormat
        return new Document("dummy topic", "dummy Content markdown");
    }

    @Override
    public String outputDocumentParser(Document file) {
        return file.getTopic() + file.getContent();
    }

}