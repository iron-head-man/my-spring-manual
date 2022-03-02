package com.xiaoxing.springframwork05.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 *
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-03-02 15:26
 */
public interface Resource {
    /***
     * <p>
     * 获取输入流顶级接口，分别实现3种不同的流文件操作ClassPath/system/URL
     * </p>
     * @return: java.io.InputStream
     * @author heng.xing@hand-china.com 2022/3/2 15:27
     */
    InputStream getInputStream()throws IOException;
}
