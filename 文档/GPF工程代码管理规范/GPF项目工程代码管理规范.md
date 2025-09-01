# 项目工程代码管理规范

## 适用范围：

​	本规范适用于管理GPF项目代码的开发。旨在提高代码的可读性、可维护性和可扩展性，确保项目代码的一致性和标准化。所有开发人员应严格遵守规范，以保证项目工程代码的高质量。

## Java工程分层：

Java工程分为三层：

1. **平台层**
   
   - 负责提供GPF的基础能力，供所有项目使用。
   - 包括gpf_dc_basic、gpf_dc_JIT、gpf_dc_JIT_common。
   
2. **项目公共层**
   
   - 存放可跨项目复用的代码模块。
   - 在同个GPF服务中只能存在一个公共代码工程，当GPF需要使用另一个GPF服务中的公共代码（指对外提供服务，不包含开发测试生产多套GPF环境），需要将代码调整后提交到`gpf_dc_JIT_common`工程，由平台组审核后发布。
   - 项目公共代码层命名要求：gpf_dc_[GPF服务名]，GPF服务名由分配服务资源时指定。
   - 所有插件必须在本层实现，并与接口类包路径一致，不允许在项目层实现
   
3. **项目层**
   
   - 存放特定项目的代码。
   
   - 所有项目上的代码需要按照项目进行分类管理，一般以工作空间的名称命名，加上`gpf_dc_`的前缀，如：`gpf_dc_jungong`。
   
   - 项目中如存在可复用的代码，可提取到项目公共层。
   
     

## 代码规范：

### 包名命名规范：

1. 包名第一层使用项目名，如`jungong`，cell类：cell.jungong,界面类：fe.jungong。

2. 包名第二层根据用途划分，如`service`，`component`、`expression`、`action`等。

   下面以jungong项目为例，列出已明确用途的包名示例：

   ##### 项目后台
   
   - `cell.jungong.service`：存放服务层代码，提供给动作、视图、界面进行使用。
   - `cell.jungong.action`：存放动作模型代码。
   - `cell.jungong.action.param`：存放动作模型代码参数。
   - `cell.jungong.action.flow`：存放流程交互类动作模型代码。
   - `cell.jungong.action.flow.param`：存放流程交互类动作模型代码参数。
   - `cell.jungong.action.gui`：存放界面交互类动作模型代码。
   - `cell.jungong.action.gui.param`：存放界面交互类动作模型代码。
   - `cell.jungong.view`：存放视图模型代码。
   - `cell.jungong.view.param`：存放视图模型代码参数
   - `cell.jungong.function.flow`：存放流程交互类动作功能代码。
   - `cell.jungong.function.gui`：存放界面交互类动作功能代码。
   
   
   
   - `jungong.dto`：项目dto类，存放数据传输对象。
   - `jungong.enums`：存放项目枚举类。
   - `jungong.consts`：存放项目常量类。
   - `jungong.i18n.JungongI18n.java`：项目的国际化类。
   - `jungong.util`：项目的工具类
   
   - `LanguageRes/jungong_i18n.setting`：存放国际化配置文件。
   
   - `resources/jungong/`：存放项目资源。
   
     
   
   - `jungong.expression`：规则代码目录。
   
   - `jungong.expression.privilege`：存放权限规则代码。
   
   - `jungong.expression.verification`：存放校验规则代码。
   
   - `jungong.expression.matchIdentify`：存放匹配规则代码。
   
   - `jungong.expression.caculateValue`：存放值计算规则代码。
   
   - `jungong.expression.condition`：存放条件规则代码。
   
     
   
   ##### 项目界面
   
   - `cell.fe.jungong`: 存放flutter组件单元测试入口类
   
   - `cell.fe.jungong.IJungongFeService.java`: 存放界面云开发调试入口Cell
   
     
   
   - `fe.jungong.component`：存放视图组件代码。
   
   - `fe.jungong.component.param`：存放视图参数配置。
   
   - `fe.jungong.component.field.extend`：存放表单属性扩展类定义。
   
   - `fe.jungong.component.field.extend.editor`：存放表单属性扩展编辑组件代码。
   
   - `fe.jungong.component.field.extend.editor.valueHandler`：存放表单属性扩展值处理代码。
   
   - `fe.jungong.dto`：项目dto类，存放数据传输对象。
   
   - `fe.jungong.enums`：存放项目枚举类。
   
   - `fe.jungong.consts`：存放项目常量类。
   
   - `fe.jungong.i18n.JungongFeI18n.java`：项目的国际化类。
   
   - `fe.jungong.util`：项目的工具类。
   
   - `LanguageRes/jungong_fe_i18n.setting`：存放国际化配置文件。
   
   - `images/jungong/`：存放项目图片资源。
   
   

注：除cell的接口类和实现类及cell参数外，严禁将类放到cell包名路径。



### 类文件注释规范：

​	类文件需要通过注解声明类的相关信息，包括what、why、how、开发人、时间和版本号。

```java
@ClassDeclare(label = "中文名称"
,what="描述是什么，类的功能"
, why = "描述为什么，需求的由来"
, how = "描述如何使用，使用场景和调用代码样例"
,developer="开发人"
,version = "1.0" //填写版本，如：1.0，第一位版本代表大版本，变更表示功能不能向下兼容，第二位代表对bug修复或补充新特性后更新的版本号，功能可向下兼容
,createTime = "2024-11-10" // 填写类的创建时间，格式：yyyy-MM-dd
,updateTime = "2024-11-10" // 填写类的更新时间，格式：yyyy-MM-dd)
```

方法注解规范

```
@MethodDeclare(
	label = "进度条对象构建接口",
	what = "进度条对象构建接口",
	why = "",
	how = "",
	developer = "开发人",
	version = "1.0",//填写版本，如：1.0，第一位版本代表大版本，变更表示功能不能向下兼容，第二位代表对bug修复或补充新特性后更新的版本号，功能可向下兼容
	createTime = "2024-11-10", // 填写类的创建时间，格式：yyyy-MM-dd
	updateTime = "2024-11-10", // 填写类的更新时间，格式：yyyy-MM-dd
	inputs = {
		@InputDeclare(name = "param1",label = "参数标签",desc = "") // 填写需要外部
	}
)	
```



### 代码开发规范：

- 使用大驼峰法（CamelCase），即首单词字母小写，后续每个单词首字母大写，不使用下划线或连字符。
- 常量统一定义在常量类进行使用，代码中不允许出现各种魔法值字符。
- 方法中的变量作用行数超过10行时，必须带有上下文含义，禁止使用不带任何含义的变量名，如a1，a2, etc...
