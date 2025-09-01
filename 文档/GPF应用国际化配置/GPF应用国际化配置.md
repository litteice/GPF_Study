# GPF应用国际化资源配置

## 1.国际化资源模板导出

### 1.1.应用视图国际化导出

​	可对应用中的菜单、模型、流程、视图配置、布局做国际化资源配置，通过在应用上导出国际化资源配置模板，生成相应语言环境的资源文件，并更新在应用的国际化资源配置上。

![image-20241108131621248](D:\Work\GPFBuild\GPFBuild\ReleaseBuild\ReleaseLog\GPF应用国际化配置\images\image-20241108131621248.png)

导出文件内容如下：

![image-20241108141238403](D:\Work\GPFBuild\GPFBuild\ReleaseBuild\ReleaseLog\GPF应用国际化配置\images\image-20241108141238403.png)

***注意：国际化资源文件的每个键值对中键的 `=` 前后不能存在空格。***

### 1.2.工程代码国际化配置

​		工程代码中定义的界面、提示信息需要国际化的，通过在类和静态属性上声明`@I18nDeclare`，并在工程管理中导出国际化资源模板，如下图所示：

![image-20241108143358069](D:\Work\GPFBuild\GPFBuild\ReleaseBuild\ReleaseLog\GPF应用国际化配置\images\image-20241108143358069.png)

![image-20241108143416818](D:\Work\GPFBuild\GPFBuild\ReleaseBuild\ReleaseLog\GPF应用国际化配置\images\image-20241108143416818.png)

注意 ：如果国际化资源不需要分组，可以在设置@I18nDeclare(defaultGroup=true)，将在默认分组中添加

![image-20241108143510814](D:\Work\GPFBuild\GPFBuild\ReleaseBuild\ReleaseLog\GPF应用国际化配置\images\image-20241108143510814.png)

从工程管理中下载国际化资源模板：

![image-20241108143639083](D:\Work\GPFBuild\GPFBuild\ReleaseBuild\ReleaseLog\GPF应用国际化配置\images\image-20241108143639083.png)

## 2.国际化资源文件生效

### 2.1.应用国际化资源文件生效

将资源文件配置到应用上即可生效

![image-20241108141348929](D:\Work\GPFBuild\GPFBuild\ReleaseBuild\ReleaseLog\GPF应用国际化配置\images\image-20241108141348929.png)

### 2.2 基础国际化资源生效

平台基础资源包的国际化在系统设置-基础国际化中找打对应语言，上传国际化资源文件即可生效。

![image-20241111093731330](D:\Work\GPFBuild\GPFBuild\ReleaseBuild\ReleaseLog\GPF应用国际化配置\images\image-20241111093731330.png)

## 3.应用配置效果

![image-20241108144643028](D:\Work\GPFBuild\GPFBuild\ReleaseBuild\ReleaseLog\GPF应用国际化配置\images\image-20241108144643028.png)

![image-20241108144726889](D:\Work\GPFBuild\GPFBuild\ReleaseBuild\ReleaseLog\GPF应用国际化配置\images\image-20241108144726889.png)