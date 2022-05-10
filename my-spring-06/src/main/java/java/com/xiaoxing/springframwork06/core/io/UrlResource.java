package java.com.xiaoxing.springframwork06.core.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import cn.hutool.core.lang.Assert;

/**
 * <p>
 * 通过发HTTP请求的方式读取云服务的文件
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-03-02 21:51
 */
public class UrlResource implements Resource {

    private final URL url;

    public UrlResource(URL url){
        Assert.notNull(url,"URL cant not be null");
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection con = this.url.openConnection();
        try {
            return con.getInputStream();
        }catch (IOException ex){
            if(con instanceof HttpURLConnection){
                ((HttpURLConnection) con).disconnect();
            }
            throw ex;
        }
    }
}
