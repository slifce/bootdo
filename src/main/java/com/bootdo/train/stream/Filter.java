package com.bootdo.train.stream;

import java.io.File;
import java.io.FilenameFilter;

public class Filter implements FilenameFilter {
    String extent;

    Filter(String extent) {
        this.extent = extent;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith("." + extent);
    }
}
