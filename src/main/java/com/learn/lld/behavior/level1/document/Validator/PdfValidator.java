package com.learn.lld.behavior.level1.document.Validator;

public class PdfValidator implements ValidatorInterface {
    @Override
    public boolean validator(String url) {
        // Check if url is not null and ends with ".pdf"
        if (url == null || !url.endsWith(".pdf")) {
            return false;
        }
        // some method of validate the pdf doc .....
        return true;
    }
}
