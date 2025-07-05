package com.learn.lld.behavior.level1.document.Validator;

import java.util.logging.Logger;

public class MarkdownValidator implements ValidatorInterface {
    private static final Logger logger = Logger.getLogger(MarkdownValidator.class.getName());

    // Correctly override the non-static interface method
    @Override
    public boolean validator(String url) {
        logger.info("Validating Markdown url: " + url);
        // Check if url is not null and ends with ".md"
        if (url == null || !url.endsWith(".md")) {
            logger.warning("Invalid Markdown url: " + url);
            return false;
        }
        // some method of validate the md doc .....
        logger.info("Markdown url validated successfully: " + url);
        return true;
    }
}