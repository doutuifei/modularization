# 组件化项目

1. 模块单独运行 ``` config.build```
 ``` 
loginRunAlone = false

userCenterRunAlone = false
 ```
 
2.  注册Application/初始化SDK 
```
@RegisterApplication(priority = 5,delay = 100,thread = ThreadMode.Main)
public class App extends AbsApplication {

    @Override
    public void onCreate(Application application) {
        super.onCreate(application);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}
```