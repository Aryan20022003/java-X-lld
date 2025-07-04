package com.learn.lld.behavior.level1.inputAdapter;

import com.learn.lld.behavior.level1.document.Document;
import com.learn.lld.behavior.level1.document.Parser.ParserInterface;

public class ParserAdapter implements inputAdapterInterFace {
    private inputAdapterInterFace nextState;
    private ParserInterface parser;

    public ParserAdapter(ParserInterface parser) {
        this.parser = parser;
        nextState = null;
    }

    @Override
    public Document process(String url) {
        if (parser == null) {
            throw new IllegalArgumentException("No parser is available");
        }
        return parser.inputDocumentParser(url);
    }
}
