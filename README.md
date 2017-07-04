 

## 简介

在此基础上做了部分修改！！！
 
## ScreenShot
 
 

 

## 使用
添加DropDownMenu 到你的布局文件，如下
```
<com.yyydjk.library.DropDownMenu
    android:id="@+id/dropDownMenu"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:ddmenuTextSize="13sp" //tab字体大小
    app:ddtextUnselectedColor="@color/drop_down_unselected" //tab未选中颜色
    app:ddtextSelectedColor="@color/drop_down_selected" //tab选中颜色
    app:dddividerColor="@color/gray"    //分割线颜色
    app:ddunderlineColor="@color/gray"  //下划线颜色
    app:ddmenuSelectedIcon="@mipmap/drop_down_selected_icon" //tab选中状态图标
    app:ddmenuUnselectedIcon="@mipmap/drop_down_unselected_icon"//tab未选中状态图标
    app:ddmaskColor="@color/mask_color"     //遮罩颜色，一般是半透明
    app:ddmenuBackgroundColor="@color/white" //tab 背景颜色
    app:ddmenuMenuHeightPercent="0.5" 菜单的最大高度，根据屏幕高度的百分比设置
    ...
 />
```
我们只需要在java代码中调用下面的代码

```
 //tabs 所有标题，popupViews  所有菜单，contentView 内容
mDropDownMenu.setDropDownMenu(tabs, popupViews, contentView);
```
如果你要了解更多，可以直接看源码  <a href="https://github.com/dongjunkun/DropDownMenu/blob/master/app/src/main/java/com/yyy/djk/dropdownmenu/MainActivity.java">Example</a>

> 建议拷贝代码到项目中使用，拷贝DropDownMenu.java 以及res下的所有文件即可

 
