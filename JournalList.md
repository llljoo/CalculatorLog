# 实习日志  
***
## DAY1   
### PLAN    
- 学习markdown语法，手写一个md文件  
- 学习基本的Android知识（看《第一行代码》）   
- 书本样例projects的手敲实现（巩固理解学习内容）   
### GAINS
1. 成功搭建Android studio开发环境，初步理解项目中的资源以及Android的系统架构   
2. 完成入门级别HelloWorld项目，通过该项目了解项目中各文件的内容及作用，见HelloWorld文件夹   
3. 学会使用Log日志工具，在Logcat中捕捉筛选四种不同级别的日志信息   
4. 学会手动创建和销毁活动，在活动中使用Toast、Menu，对布局进行构建和加载   
5. 关于Intent的显示与隐式使用   
6. 创立activitytest项目，完成相关基本操作，见activitytest文件夹   
***
## DAY2   
### PLAN    
- 巩固昨天学习的内容   
- 继续看《第一行代码》，学习关于活动的相关知识   
- 学习常用控件与自定义控件的使用方法    
- 了解4种基本的布局   
### GAINS   
1. 学会使用Android的几个简单控件，如TextView、Button、EditText、ImageView、ProgressBar、AlertDialog等它们的使用方法总体来说都差不多，都是先给定一个唯一的标识id，再规定宽、高这三个基本条件，再进一步实现其他具体的功能   
2. 懂得布局这一概念，初步有所体会   
 - 线性布局LinearLayout，其中属性android:layout_weight这一属性在手机适配性方面起到重要作用，因为它可以使用比例的方式指定控制件大小   
 - 相对布局RelativeLayout，可以通过相对定位的方法使得控件分布在布局的任意位置，其中的属性较多   
 - 帧布局FrameLayout，所有控件默认放置布局的左上角，会产生叠加覆盖的效果，应用较少   
 - 百分比布局，需要添加百分比布局库的依赖，这个地方暂时还没有成功添加   
3. 自定义布局与自定义控件的简单使用，实现自定义的标题栏和标题栏控件按钮的相应活动   
4. 初识ListView
### PROBLEMS   
- 无法在app/build.gradle中导入support库   
implementation 'com.android.support:percent:28.+' 报错    
暂时无法使用百分比布局   
***  
## DAY3   
### PLAN   
- 巩固昨天学习的内容，加强理解   
- 构思实现计算器的布局、控件安排，尽量将框架构建出来   
- 继续按《第一行代码》学习基本的知识   
