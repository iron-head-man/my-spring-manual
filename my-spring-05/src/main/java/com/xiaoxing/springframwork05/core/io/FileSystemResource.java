package com.xiaoxing.springframwork05.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-03-02 21:33
 */
public class FileSystemResource implements Resource{

    private final File file;

    private final String path;

    public FileSystemResource(File file){
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource(String path){
        this.path = path;
        this.file = new File(path);
    }

    @Override
    public InputStream getInputStream() throws IOException {

        return new FileInputStream(this.file);
    }

    public final String getPath(){
        return this.path;
    }
}
