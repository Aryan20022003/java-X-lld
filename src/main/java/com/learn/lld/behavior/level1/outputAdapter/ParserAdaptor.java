package com.learn.lld.behavior.level1.outputAdapter;

import java.util.logging.Logger;
//as of now output adaptor but in future if we have we can extent that. 

import com.learn.lld.behavior.level1.document.Document;
import com.learn.lld.behavior.level1.document.Parser.ParserInterface;

public class ParserAdaptor implements outAdapterInterface {
    private static final Logger logger = Logger.getLogger(ParserAdaptor.class.getName());
    private ParserInterface outputParser;
    private outAdapterInterface nextProcess;

    public ParserAdaptor(ParserInterface outputDesiredFormatParser) {
        this.outputParser = outputDesiredFormatParser;
        this.nextProcess = null;
    }

    @Override
    public String process(Document doc) {
        logger.info("Processing output with ParserAdaptor for topic: " + doc.getTopic());
        if (outputParser == null) {
            logger.severe("output outputDesiredFormatParser not available");
            throw new IllegalArgumentException("output outputDesiredFormatParser not available");
        }
        String result = outputParser.outputDocumentParser(doc);
        logger.info("ParserAdaptor processed output for topic: " + doc.getTopic());
        return result;
    }

    @Override
    public void setNext(outAdapterInterface state) {
        nextProcess = state;
    }
}
