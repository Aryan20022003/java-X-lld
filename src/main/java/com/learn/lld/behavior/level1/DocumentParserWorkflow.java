package com.learn.lld.behavior.level1;

import java.util.logging.Logger;

import com.learn.lld.behavior.level1.document.Document;
import com.learn.lld.behavior.level1.document.Parser.MarkDownParser;
import com.learn.lld.behavior.level1.document.Parser.ParserInterface;
import com.learn.lld.behavior.level1.document.Parser.PdfParser;
import com.learn.lld.behavior.level1.document.Validator.MarkdownValidator;
import com.learn.lld.behavior.level1.document.Validator.PdfValidator;
import com.learn.lld.behavior.level1.document.Validator.ValidatorInterface;
import com.learn.lld.behavior.level1.inputAdapter.ParserAdapter;
import com.learn.lld.behavior.level1.inputAdapter.ValidatorAdaptor;
import com.learn.lld.behavior.level1.outputAdapter.ParserAdaptor;
import com.learn.lld.behavior.level1.outputAdapter.outAdapterInterface;

public class DocumentParserWorkflow {
    private static final Logger logger = Logger.getLogger(DocumentParserWorkflow.class.getName());

    public static Document PdfInputParserWorkflow(String signedUrl) {
        logger.info("Starting PDF Input Parser Workflow for url: " + signedUrl);
        ParserInterface pdfParser = new PdfParser();
        ValidatorInterface PdfValidator = new PdfValidator();
        ParserAdapter pdfParserAdaptor = new ParserAdapter(pdfParser);
        ValidatorAdaptor pdfValidatorAdaptor = new ValidatorAdaptor(PdfValidator, pdfParserAdaptor);
        Document doc = pdfValidatorAdaptor.process(signedUrl);
        logger.info("PDF Input Parser Workflow completed for url: " + signedUrl);
        return doc;
    }

    public static Document MarkdownInputParserWorkflow(String signedUrl) {
        logger.info("Starting Markdown Input Parser Workflow for url: " + signedUrl);
        ParserInterface markdownParser = new MarkDownParser();
        ValidatorInterface markdownValidator = new MarkdownValidator();
        ParserAdapter markdownParserAdaptor = new ParserAdapter(markdownParser);
        ValidatorAdaptor markdownValidatorAdaptor = new ValidatorAdaptor(markdownValidator, markdownParserAdaptor);
        Document doc = markdownValidatorAdaptor.process(signedUrl);
        logger.info("Markdown Input Parser Workflow completed for url: " + signedUrl);
        return doc;
    }

    public static String PdfOutputParserWorkflow(Document doc) {
        logger.info("Starting PDF Output Parser Workflow for topic: " + doc.getTopic());
        ParserInterface pdfParser = new PdfParser();
        outAdapterInterface pdfOutput = new ParserAdaptor(pdfParser);
        String result = pdfOutput.process(doc);
        logger.info("PDF Output Parser Workflow completed for topic: " + doc.getTopic());
        return result;
    }

    public static String markdownOutputParserWorkflow(Document doc) {
        logger.info("Starting Markdown Output Parser Workflow for topic: " + doc.getTopic());
        ParserInterface markdownParser = new MarkDownParser();
        outAdapterInterface markdownOutput = new ParserAdaptor(markdownParser);
        String result = markdownOutput.process(doc);
        logger.info("Markdown Output Parser Workflow completed for topic: " + doc.getTopic());
        return result;
    }
}
