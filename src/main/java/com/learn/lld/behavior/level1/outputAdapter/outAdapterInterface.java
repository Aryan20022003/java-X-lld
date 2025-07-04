package com.learn.lld.behavior.level1.outputAdapter;

import com.learn.lld.behavior.level1.document.Document;

public interface outAdapterInterface {
    public String process(Document doc);
    public void setNext(outAdapterInterface state);
}