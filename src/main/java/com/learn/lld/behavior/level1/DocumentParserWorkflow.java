package com.learn.lld.behavior.level1;

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
    public static Document PdfInputParserWorkflow(String signedUrl) {
        ParserInterface pdfParser = new PdfParser();
        ValidatorInterface PdfValidator = new PdfValidator();
        ParserAdapter pdfParserAdaptor = new ParserAdapter(pdfParser);
        ValidatorAdaptor pdfValidatorAdaptor = new ValidatorAdaptor(PdfValidator, pdfParserAdaptor);
        return pdfValidatorAdaptor.process(signedUrl);

    }

    public static Document MarkdownInputParserWorkflow(String signedUrl) {
        ParserInterface markdownParser = new MarkDownParser();
        ValidatorInterface markdownValidator = new MarkdownValidator();
        ParserAdapter markdownParserAdaptor = new ParserAdapter(markdownParser);
        ValidatorAdaptor markdownValidatorAdaptor = new ValidatorAdaptor(markdownValidator, markdownParserAdaptor);
        return markdownValidatorAdaptor.process(signedUrl);
    }

    public static String PdfOutputParserWorkflow(Document doc) {
        ParserInterface pdfParser = new PdfParser();
        outAdapterInterface pdfOutput = new ParserAdaptor(pdfParser);
        return pdfOutput.process(doc);
    }

    public static String markdownOutputParserWorkflow(Document doc) {
        ParserInterface markdownParser = new MarkDownParser();
        outAdapterInterface markdownOutput = new ParserAdaptor(markdownParser);
        return markdownOutput.process(doc);
    }

}
