在 Spring 中有一个 Event 事件功能，它可以提供事件的定义、发布以及监听
事件来完成一些自定义的动作。比如你可以定义一个新用户注册的事件，当有
用户执行注册完成后，在事件监听中给用户发送一些优惠券和短信提醒，这样
的操作就可以把属于基本功能的注册和对应的策略服务分开，降低系统的耦
合。以后在扩展注册服务，比如需要添加风控策略、添加实名认证、判断用户
属性等都不会影响到依赖注册成功后执行的动作。

那么在本章节我们需要以观察者模式的方式，设计和实现 Spring Event 的容
器事件和事件监听器功能，最终可以让我们在现有实现的 Spring 框架中可以
定义、监听和发布自己的事件信息。

其实事件的设计本身就是一种观察者模式的实现，它所要解决的就是一个对象
状态改变给其他对象通知的问题，而且要考虑到易用和低耦合，保证高度的协
作。
在功能实现上我们需要定义出事件类、事件监听、事件发布，而这些类的功能
需要结合到 Spring 的 AbstractApplicationContext#refresh()，以便于处理
事件初始化和注册事件监听器的操作。



ApplicationContextEvent 是定义事件的抽象类，所有的事件包括关闭、刷新，以及
用户自己实现的事件，都需要继承这个类。
 ContextClosedEvent、ContextRefreshedEvent，分别是 Spring 框架自己实现的两
个事件类，可以用于监听刷新和关闭动作。


AbstractApplicationEventMulticaster 是对事件广播器的公用方法提取，在这个类中
可以实现一些基本功能，避免所有直接实现接口放还需要处理细节。
 除了像 addApplicationListener、removeApplicationListener，这样的通用方法，这
里这个类中主要是对 getApplicationListeners 和 supportsEvent 的处理。
 getApplicationListeners 方法主要是摘取符合广播事件中的监听处理器，具体过滤
动作在 supportsEvent 方法中。
 在 supportsEvent 方法中，主要包括对 Cglib、Simple 不同实例化需要获取目标
Class，Cglib 代理类需要获取父类的 Class，普通实例化的不需要。接下来就是通过
提取接口和对应的 ParameterizedType 和 eventClassName，方便最后确认是否为
子类和父类的关系，以此证明此事件归这个符合的类处理



在抽象应用上下文 AbstractApplicationContext#refresh 中，主要新增了 初始化
事件发布者、注册事件监听器、发布容器刷新完成事件，三个方法用于处
理事件操作。
 初始化事件发布者(initApplicationEventMulticaster)，主要用于实例化一个
SimpleApplicationEventMulticaster，这是一个事件广播器。
 注册事件监听器(registerListeners)，通过 getBeansOfType 方法获取到所有从
spring.xml 中加载到的事件配置 Bean 对象。
 发布容器刷新完成事件(finishRefresh)，发布了第一个服务器启动完成后的事件，这
个事件通过 publishEvent 发布出去，其实也就是调用了
applicationEventMulticaster.multicastEvent(event); 方法。
 最后是一个 close 方法中，新增加了发布一个容器关闭事件。
publishEvent(new ContextClosedEvent(this));