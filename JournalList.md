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
### GAINS   
1. 滚动控件ListView和RecyclerView的使用，它们有相同之处也有不同之处，理清整个控件的使用流程花了不少时间，特别是相对应的适配器和类的定义与各种新方法的接触，随着学习内容难度的上升，感觉各种各样的方法层出不穷，有点眼花缭乱，要加强查文档并灵活使用的能力   
2. 参考了几篇实现计算器app的博客，了解了一下别人的实现思路，感觉不太难   
- 布局方面，可以只需要LinearLayout线性布局的多次结合使用即可，由上至下分为三个大部分，输入显示EditText、输出显示TextView、Button按键集，进而再细分数字按键和运算符按键的排布，为每个按键注册点击事件监听器，对应实现相关功能即可   
- 计算器计算功能的基本实现，设计的计算器中包含括号运算，要考虑括号对运算优先级的影响，所有这一块要设计合理的算法去实现。查阅得知将中缀表达式转化为后缀表达式可以消除运算优先级的影响，所以要进行后缀表达式的转化生成，再通过后缀表达式进行算式的计算   
- 还要考虑输入字符串的合理与否，这一步判断是处理非法表达式输入的关键，否则程序运行时会崩溃。我参考别人用正则表达式实现，于是又要学习正则表达式，今天简单看了一下，明天再仔细学习。   
3. git二次上传项目到GitHub上也给我折腾很久，如果一直使用初次上传的方法实在麻烦，感觉也没必要，但根据少有的几个二次上传文件的方法操作都失败了几次，还是对相关命令不熟悉，在最后反复尝试下终于成功了。   
### PROBLEMS   
- app雏形已有，经过初步的暴力测试，发现很多bug(如下)，后期还需要进一步优化   
  1. 不允许非数字字符的连续输入，比如(.)、(2))、2+-*4等
  2. 结果为无穷小数的保留位数处理问题，一般都默认保留2位
  3. 调试多次后会出现运算符不可用情况，点击事件无响应
  4. 调整输入和输出显示的内容靠右
  5. 美化UI界面，有点丑。。。。   
- 还是希望有人指导一下从本地库再次上传项目到github上的方法，网上都基本上只提供了第一次上传的方法，每次都要 git remote rm origin和git pull origin master感觉不太规范。   
***
## DAY4   
### PLAN   
- 修复简单计算器中的bug   
- 进一步实现更高级的计算功能，sin、cos、tan函数、根号、pi的使用   
- 简写大数的按钮e，即将较大的数转化成幂次表示   
- 表达式label自适应大小   
(能够完成多少完成多少吧)   
### GAINS   
- 看了n篇参考资料，学到了一些不同的方法 
- 终于摸索出怎么导入support-v4了，可以直接从File中的选项进行操作
### PROBLEMS   
- 修bug把整个程序给修崩了，em，之前的布局不能够有效进行功能的添加扩展，在实现简单计算的基础上再增加功能十分麻烦，由于没有备份之前的代码，于是乎搞得一团乱，心塞。又看了很多帖子，发现还是学的不太扎实，很多技巧还是不会使用，em，我打算重新搞一遍。   
*** 
## DAY5   
### PLAN   
- 整理一下思路，重新开始框架的构建，这次要考虑全面再下手   
- 多参考技术博客，编写代码边学习   
### GAINS   
- 借鉴了一篇博客的思路，一个Activity，实现各种点击事件的监听、算式匹配、算式计算、输入输出显示，一个主布局，分为两大线性布局，第一个为输入显示EditView、输出显示TextView，第二个为Button按键控制面板，由5个子LinearLayout组成，每一个细分为5个Button。   
- 简单实现了计算功能   
- UI界面良好   
### PROBLEMS   
- plus选项的添加果然比较麻烦，卡在如何处理带上三角函数字母的字符串上，思路上是将形如...+sin(...)+...的字符串分割为三部分，将带有三角函数部分的单独计算，再整体合并进行计算，具体代码还有待进一步实现   
- 处理不能重复输入运算符的方法有问题，在多次测试后会出现运算符无响应的情况，排查半天才发现是这里出了问题，还需要改进   
***
## DAY6   
### PLAN　　　
- 继续完善程序　　　
### GAINS   
- 完成了科学计数法按钮e的功能   
- 完成了计算结果的整数、小数的区别输出和小数点保留位数的限制   
- 删除键功能完成   
- 清空键功能完成   
### PROBLEMS   
- TextView中字体的大小自适应可以通过AppCompatTextView实现，但是它在support-v7包中，而API 29已经不能够导入com.android.support:appcompat-v7，显示最高只能在API 28中进行使用，尝试了下载API 28，但在AS上还是不能够导入，被卡在这里很久  
- 关于特殊输入情况，能够简单处理一些情况，但是有一些极端条件还是没有办法能够处处考虑周全，还要想办法改进，代码不要太繁琐   
***
## DAY7   
### PLAN   
- 完善程序功能   
### GIANS   
- 解决了之前的一个问题，即二次上传文件至github中的合理方法，建立一个新文件夹，clone下GitHub上的整个文件项目，再进一步进行add即可   
- 学习Fragment的相关知识和用法    
- 初识BroadCast机制   
- 计算器app初步确定，但是部分pluses项还是无法实现   
