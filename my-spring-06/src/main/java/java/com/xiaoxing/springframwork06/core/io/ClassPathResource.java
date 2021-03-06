package java.com.xiaoxing.springframwork06.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.com.xiaoxing.springframwork06.util.ClassUtils;

import cn.hutool.core.lang.Assert;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-03-02 15:31
 */
public class ClassPathResource implements Resource {

    private final String path;
    //采用classLoader读取文件
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, (ClassLoader) null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {

        Assert.notNull(path, "Path must be not null");
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());

    }

    @Override
    public InputStream getInputStream() throws IOException {

        InputStream is = classLoader.getResourceAsStream(path);
        if (is==null){
            throw new FileNotFoundException(this.path+"can not opened because it not exist");
        }

        return is;
    }
}
