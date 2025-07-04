package com.learn.lld.behavior.level1.document.Validator;

public class MarkdownValidator implements ValidatorInterface {
    // Correctly override the non-static interface method
    @Override
    public boolean validator(String url) {
        // Check if url is not null and ends with ".md"
        if (url == null || !url.endsWith(".md")) {
            return false;
        }
        // some method of validate the md doc .....
        return true;
    }
}