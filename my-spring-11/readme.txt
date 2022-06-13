到本章节我们将要从 IOC 的实现，转入到关于 AOP(Aspect Oriented Programming) 内容的开发。
在软件行业，AOP 意为：面向切面编程，通过预编译的方式和运行期间动态代理实现程序功能功能的统一维护。
其实 AOP 也是 OOP 的延续，在 Spring 框架中是一个非常重要的内容，
使用 AOP 可以对业务逻辑的各个部分进行隔离，从而使各模块间的业务逻辑耦合度降低，提高代码的可复用性，
同时也能提高开发效率。


在把 AOP 整个切面设计融合到 Spring 前，我们需要解决两个问题，包括：如何给符合规则的方法做代理，
以及做完代理方法的案例后，把类的职责拆分出来

    就像你在使用 Spring 的 AOP 一样，只处理一些需要被拦截的方法。在拦截方法后，执行你对方法的扩展操作。
    那么我们就需要先来实现一个可以代理方法的 Proxy，其实代理方法主要是使用到方法拦截器类处理方法的调用
    MethodInterceptor#invoke，而不是直接使用 invoke 方法中的入参 Method method 进行 method.invoke(targetObj, args)
    这块是整个使用时的差异。
    除了以上的核心功能实现，还需要使用到 org.aspectj.weaver.tools.PointcutParser 处理拦截表达式
    "execution(* cn.bugstack.springframework.test.bean.com.xiaoxing.springframwork11.test.bean.IUserService.*(..))"，
    有了方法代理和处理拦截，我们就可以完成设计出一个 AOP 的雏形了。



    AdvisedSupport，主要是用于把代理、拦截、匹配的各项属性包装到一个类中，方便在 Proxy 实现类进行使用。这和你的业务开发中包装入参是一个道理
    TargetSource，是一个目标对象，在目标对象类中提供 Object 入参属性，以及获取目标类 TargetClass 信息。
    MethodInterceptor，是一个具体拦截方法实现类，由用户自己实现 MethodInterceptor#invoke 方法，做具体的处理。像我们本文的案例中是做方法监控处理
    MethodMatcher，是一个匹配方法的操作，这个对象由 AspectJExpressionPointcut 提供服务。