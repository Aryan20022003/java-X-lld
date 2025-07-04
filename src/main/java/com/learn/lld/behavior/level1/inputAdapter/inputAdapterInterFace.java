package com.learn.lld.behavior.level1.inputAdapter;

import com.learn.lld.behavior.level1.document.Document;

//Implemented chain of responsibility parse->validate->Document will be returned.  

public interface inputAdapterInterFace {

    public Document process(String url);
}