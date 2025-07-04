package com.learn.lld.behavior.level1.inputAdapter;

import com.learn.lld.behavior.level1.document.Document;
import com.learn.lld.behavior.level1.document.Validator.ValidatorInterface;

public class ValidatorAdaptor implements inputAdapterInterFace {
    private inputAdapterInterFace parser;
    private ValidatorInterface validator;

    public ValidatorAdaptor(ValidatorInterface validator, inputAdapterInterFace ParserAdapter) {
        this.validator = validator;
        this.parser = ParserAdapter;
    }

    @Override
    public void setNextState(inputAdapterInterFace next) {
        parser = next;
    }

    @Override
    public Document process(String url) {
        if (parser == null) {
            throw new IllegalArgumentException("No parser is available");
        } else if (validator == null) {
            throw new IllegalArgumentException("No validator is available");
        } else if (!validator.validator(url)) {
            throw new Error("Invalid url cannot be parsed");
        }
        return parser.process(url);
    }
}
