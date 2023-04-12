# Kt I18n

适用于kotlin的i18n，使用如今在web前端通用的json文件，而非现在java普遍使用的以ISO-8859-1字符编码的properties

## 配置:

`locales/config.json`
- `charset` 使用的字符集，默认系统
- `default-language` 使用的语言，默认系统
- `i18n-folder` i18n文件的目录，默认在resources下的`locales/`目录中

## 基础用法

``` kotlin
//加载语言文件
I18n.loadFile(...)
//使用zh_CN语言
I18n.use("zh_CN")
//解析语言项key
I18n.parse("key")
```

## 特性：

1. 可选带风格的偏好翻译，同一个词提供给不同的用户不同的翻译
2. 为更好切换上述效果，会根据翻译制作出一张风格表，以供选择
3. 动态加载或切换翻译