package com.learn.lld.behavior.level1.outputAdapter;

import com.learn.lld.behavior.level1.document.Document;
import com.learn.lld.behavior.level1.document.Parser.ParserInterface;
//as of now output adaptor but in future if we have we can extent that. 

public class ParserAdaptor implements outAdapterInterface {
    private ParserInterface outputParser;
    private outAdapterInterface nextProcess;

    public ParserAdaptor(ParserInterface outputDesiredFormatParser) {
        this.outputParser = outputDesiredFormatParser;
        this.nextProcess = null;
    }

    @Override
    public String process(Document doc) {
        if (outputParser == null) {
            throw new IllegalArgumentException("output outputDesiredFormatParser not available");
        }
        return outputParser.outputDocumentParser(doc);
    }

    @Override
    public void setNext(outAdapterInterface state) {
        nextProcess = state;
    }
}
