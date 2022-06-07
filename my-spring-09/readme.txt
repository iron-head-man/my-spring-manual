因为我们在使用 Spring、MyBatis 框架的时候都可以知道，并没有手动的去创
建任何操作数据库的 Bean 对象，有的仅仅是一个接口定义，而这个接口定义
竟然可以被注入到其他需要使用 Dao 的属性中去了，那么这一过程最核心待解
决的问题，就是需要完成把复杂且以代理方式动态变化的对象，注册到 Spring
容器中。而为了满足这样的一个扩展组件开发的需求，就需要我们在现有手写
的 Spring 框架中，添加这一能力。


solution:

关于提供一个能让使用者定义复杂的 Bean 对象，功能点非常不错，意义也非
常大，因为这样做了之后 Spring 的生态种子孵化箱就此提供了，谁家的框架
都可以在此标准上完成自己服务的接入。
但这样的功能逻辑设计上并不复杂，因为整个 Spring 框架在开发的过程中就
已经提供了各项扩展能力的接茬，你只需要在合适的位置提供一个接茬的处理
接口调用和相应的功能逻辑实现即可，像这里的目标实现就是对外提供一个可
以二次从 FactoryBean 的 getObject 方法中获取对象的功能即可，这样所有
实现此接口的对象类，就可以扩充自己的对象功能了。MyBatis 就是实现了一
个 MapperFactoryBean 类，在 getObject 方法中提供 SqlSession 对执行
CRUD 方法的操作

    整个的实现过程包括了两部分，一个解决单例还是原型对象，另外一个处理
FactoryBean 类型对象创建过程中关于获取具体调用对象的 getObject 操作。

    1、 SCOPE_SINGLETON、SCOPE_PROTOTYPE，对象类型的创建获取方式，主要区
分在于 AbstractAutowireCapableBeanFactory#createBean 创建完
成对象后是否放入到内存中，如果不放入则每次获取都会重新创建。
    2、createBean 执行对象创建、属性填充、依赖加载、前置后置处理、初始化等操作
后，就要开始做执行判断整个对象是否是一个 FactoryBean 对象，如果是这样的
对象，就需要再继续执行获取 FactoryBean 具体对象中的 getObject 对象了。
整个 getBean 过程中都会新增一个单例类型的判断factory.isSingleton()，用于决定是否使用内存存放对象信息。