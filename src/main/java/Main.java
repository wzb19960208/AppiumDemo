import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String args[]){

        AppiumDriver driver;

        //定义Appium运行的基本配置信息
        DesiredCapabilities capabilities = new DesiredCapabilities();


        capabilities.setPlatform(Platform.ANDROID);
        capabilities.setVersion("5.1");
        //使用的自动化引擎，其实默认就是Appium
        capabilities.setCapability("automationName","Appium");
        capabilities.setCapability("deviceName","810EBME4A6VN");
        //还能指定App的绝对路径，会安装进去
        //打开魅族计算器
        capabilities.setCapability("appPackage","com.meizu.flyme.calculator");
        capabilities.setCapability("appActivity","Calculator");
        //打开慕课网
//        capabilities.setCapability("appPackage","cn.com.open.mooc");
//        capabilities.setCapability("appActivity","com.imooc.component.imoocmain.splash.MCSplashActivity");

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);

            //如果有的首页加载比较慢
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

            //注意findElement和findElements不一样
            //9 resource-id里面的内容
            driver.findElement(By.id("com.meizu.flyme.calculator:id/digit9")).click();
            //+
            driver.findElementById("com.meizu.flyme.calculator:id/plus").click();
            //2
            driver.findElementById("com.meizu.flyme.calculator:id/digit2").click();
            //= content-desc里面的内容
            driver.findElementByAccessibilityId("等号").click();


            Thread.sleep(5000);


            //退出
            driver.quit();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
