package com.learn.lld.behavior.level1;

import com.learn.lld.behavior.level1.document.Document;

public class Main {
    public static void main(String[] args) {
        // Example PDF document parsing and publishing
        String pdfUrl = "sample.pdf";
        Document pdfDoc = DocumentParserWorkflow.PdfInputParserWorkflow(pdfUrl);
        String pdfPublishResult = DocumentPublish.webPublish(pdfDoc, "http://example.com/pdf");
        System.out.println("PDF Publish Result: " + pdfPublishResult);

        // Example Markdown document parsing and publishing
        String mdUrl = "sample.md";
        Document mdDoc = DocumentParserWorkflow.MarkdownInputParserWorkflow(mdUrl);
        String mdPublishResult = DocumentPublish.RepoPublish(mdDoc, "repo://markdowns");
        System.out.println("Markdown Publish Result: " + mdPublishResult);
    }
}
