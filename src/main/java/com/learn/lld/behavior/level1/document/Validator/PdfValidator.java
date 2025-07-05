package com.learn.lld.behavior.level1.document.Validator;

import java.util.logging.Logger;

public class PdfValidator implements ValidatorInterface {
    private static final Logger logger = Logger.getLogger(PdfValidator.class.getName());

    @Override
    public boolean validator(String url) {
        logger.info("Validating PDF url: " + url);
        // Check if url is not null and ends with ".pdf"
        if (url == null || !url.endsWith(".pdf")) {
            logger.warning("Invalid PDF url: " + url);
            return false;
        }
        // some method of validate the pdf doc .....
        logger.info("PDF url validated successfully: " + url);
        return true;
    }
}
