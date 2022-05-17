package com.xiaoxing.springframwork07.beans.factory.support;

import com.xiaoxing.springframwork07.beans.factory.DisposableBean;

/**
 * <p>
 *  Adapter that implements the {@link DisposableBean} and {@link Runnable} interfaces
 *  * performing various destruction steps on a given bean instance:
 * </p>
 *
 * @author heng.xing@hand-china.com 2022-05-17 23:30
 */
public class DisposableBeanAdapter implements DisposableBean {
    @Override
    public void destroy() throws Exception {

    }
}
