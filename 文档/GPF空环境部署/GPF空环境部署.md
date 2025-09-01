# GPF空环境初始化部署



空库启动GPF，需要从云仓库导出gpf_dc_basic工程才可访问，操作步骤如下：

## 1.访问网址：http://主机:端口/ProjectManage/

![006](.\images\006.png)

## 2.从云仓库下载gpf_dc_basic工程

![001](.\images\001.png)

### 3.刷新列表并发布工程

![002](.\images\002.png)

## 4.访问网址：http://主机:端口/gpfdc/

![007](.\images\007.png)

*若访问提示未授权需要配置白名单时，在GPF/conf/base_advance.conf中将当前IP地址和端口加入白名单，并重启GPF*

![003](.\images\003.png)

### 5.点击设置/工程管理，选择gpf_dc_basic，重建工程包

![004](.\images\004.png)

![005](.\images\005.png)