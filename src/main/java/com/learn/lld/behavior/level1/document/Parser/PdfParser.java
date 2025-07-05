package com.learn.lld.behavior.level1.document.Parser;

import java.util.logging.Logger;

import com.learn.lld.behavior.level1.document.Document;

public class PdfParser implements ParserInterface {
    private static final Logger logger = Logger.getLogger(PdfParser.class.getName());

    @Override
    public Document inputDocumentParser(String signedUrl) {
        logger.info("Parsing PDF document from url: " + signedUrl);
        // some logic to parse pdf and convert it into internal DocumentFormat
        return new Document("dummy topic", "dummy Content pdf");
    }

    // all output are dummy so we use topic+content as signed url.
    @Override
    public String outputDocumentParser(Document file) {
        logger.info("Converting Document to PDF output for topic: " + file.getTopic());
        return file.getTopic() + file.getContent();
    }
}
