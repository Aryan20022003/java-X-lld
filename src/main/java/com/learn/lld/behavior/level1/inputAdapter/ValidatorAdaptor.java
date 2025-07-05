package com.learn.lld.behavior.level1.inputAdapter;

import java.util.logging.Logger;

import com.learn.lld.behavior.level1.document.Document;
import com.learn.lld.behavior.level1.document.Validator.ValidatorInterface;

public class ValidatorAdaptor implements inputAdapterInterFace {
    private static final Logger logger = Logger.getLogger(ValidatorAdaptor.class.getName());
    private inputAdapterInterFace parser;
    private ValidatorInterface validator;

    public ValidatorAdaptor(ValidatorInterface validator, inputAdapterInterFace ParserAdapter) {
        this.validator = validator;
        this.parser = ParserAdapter;
    }

    @Override
    public Document process(String url) {
        logger.info("ValidatorAdaptor: Validating and processing url: " + url);
        if (parser == null) {
            logger.severe("No parser is available");
            throw new IllegalArgumentException("No parser is available");
        } else if (validator == null) {
            logger.severe("No validator is available");
            throw new IllegalArgumentException("No validator is available");
        } else if (!validator.validator(url)) {
            logger.warning("Invalid url cannot be parsed: " + url);
            throw new Error("Invalid url cannot be parsed");
        }
        if (!validator.validator(url)) {
            logger.warning("url is not correct as per validator: " + url);
            throw new Error("url is not correct as per validator");
        }
        Document doc = parser.process(url);
        logger.info("ValidatorAdaptor: Successfully processed url: " + url);
        return doc;
    }
}
