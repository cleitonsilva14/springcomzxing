# springcomzxing



```xml

<!-- ZXing core -->
<dependency>
    <groupId>com.google.zxing</groupId>
    <artifactId>core</artifactId>
    <version>3.5.3</version>
</dependency>

<!-- ZXing para imagens -->
<dependency>
    <groupId>com.google.zxing</groupId>
    <artifactId>javase</artifactId>
    <version>3.5.3</version>
</dependency>

```

```properties
app.qrcode.width=350
app.qrcode.height=350
```

```java
@Value("${app.qrcode.width}")
private int width;

@Value("${app.qrcode.height}")
private int height;
```