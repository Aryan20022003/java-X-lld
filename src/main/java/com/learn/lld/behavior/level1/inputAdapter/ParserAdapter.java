package com.learn.lld.behavior.level1.inputAdapter;

import java.util.logging.Logger;

import com.learn.lld.behavior.level1.document.Document;
import com.learn.lld.behavior.level1.document.Parser.ParserInterface;

public class ParserAdapter implements inputAdapterInterFace {
    private static final Logger logger = Logger.getLogger(ParserAdapter.class.getName());
    private inputAdapterInterFace nextState;
    private ParserInterface parser;

    public ParserAdapter(ParserInterface parser) {
        this.parser = parser;
        nextState = null;
    }

    @Override
    public Document process(String url) {
        logger.info("Processing input with ParserAdapter for url: " + url);
        if (parser == null) {
            logger.severe("No parser is available");
            throw new IllegalArgumentException("No parser is available");
        }
        Document doc = parser.inputDocumentParser(url);
        logger.info("ParserAdapter processed document for url: " + url);
        return doc;
    }
}
