package com.learn.lld.behavior.level1.document.Parser;

import com.learn.lld.behavior.level1.document.Document;

public class PdfParser implements ParserInterface {
    @Override
    public Document inputDocumentParser(String signedUrl) {
        // some logic to parse pdf and convert it into internal DocumentFormat
        return new Document("dummy topic", "dummy Content pdf");
    }

    // all output are dummy so we use topic+content as signed url. 
    @Override
    public String outputDocumentParser(Document file) {
        return file.getTopic() + file.getContent();
    }
}
