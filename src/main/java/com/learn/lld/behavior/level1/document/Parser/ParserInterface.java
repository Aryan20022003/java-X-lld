package com.learn.lld.behavior.level1.document.Parser;

import com.learn.lld.behavior.level1.document.Document;
//core idea : input will we db url and will convert it to internal DocumentFormat and output should he signed url from intern document format. 

public interface ParserInterface {
    public Document inputDocumentParser(String signedUrl);

    // all output are dummy so we use topic+content as signed url. 
    public String outputDocumentParser(Document file);
}
