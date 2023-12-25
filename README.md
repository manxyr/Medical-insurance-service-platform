# MISP - A Medical Insurance Service Platform
This is a medical insurance service system, divided into the user side and the administrator side, through the login account permissions are different, you can enter the user interface or the administrator interface.<br>
This system uses the JAVA SWING toolkit, uses the JAVA three-tier architecture.<br>
I use SQL Server to store data,and uses the JDBC API to connect to the database.<br>
You can to improve this system function, and send e-mail to me.Thank you！

## 系统需求分析
医保服务平台，1.用户通过登录查看医保卡信息以及查询进入国家医保名单的药品。2.管理员对医保卡进行管理：入保，退保，挂失，刷新全部医保卡信息四种功能。
* 每个入保用户可以用身份证注册一个医保平台账号，进行登录，查看个人基本信息。
* 每个用户的医保账号和医保卡相关联，根据身份证号可以查询医保相关信息:医保卡状态及医保卡余额。
* 每个用户通过登录平台，查询自己想购买的药品是否列入国家医保药品名单。
* 管理员通过入保，输入入保用户的基本信息，添加到医保卡管理表（card_manage）中。
* 管理员通过退保，删除用户（users）表中的记录，并且更改医保卡管理表（card_manage），将医保卡状态更改为退保。
* 管理员通过挂失，更改医保卡管理表（card_manage），将医保卡状态改为挂失。
* 医保卡状态为退保的用户无法登录进入个人基本信息界面。
* 医保卡状态为挂失的用户可以登录进入个人基本信息界面，正常使用医保服务平台。

## 系统界面
![](https://github.com/manxyr/Medical-insurance-service-platform/blob/main/%E7%B3%BB%E7%BB%9F%E6%88%AA%E5%9B%BE/%E8%A5%BF%E8%8D%AF%E8%8D%AF%E5%93%81%E5%90%8D%E5%8D%95.jpg)
图1 西药药品名单><br>

![](https://github.com/manxyr/Medical-insurance-service-platform/blob/main/%E7%B3%BB%E7%BB%9F%E6%88%AA%E5%9B%BE/%E7%94%A8%E6%88%B7%E7%99%BB%E5%BD%95.png)
图2 用户登录<br>

![](https://github.com/manxyr/Medical-insurance-service-platform/blob/main/%E7%B3%BB%E7%BB%9F%E6%88%AA%E5%9B%BE/%E4%B8%AA%E4%BA%BA%E8%B4%A6%E6%88%B7%E7%95%8C%E9%9D%A2.png)<br>
图3 进入个人账户界面<br>

![](https://github.com/manxyr/Medical-insurance-service-platform/blob/main/%E7%B3%BB%E7%BB%9F%E6%88%AA%E5%9B%BE/%E7%AE%A1%E7%90%86%E5%91%98%E7%99%BB%E5%BD%95.png)<br>
图4 管理员账号登录<br>

![](https://github.com/manxyr/Medical-insurance-service-platform/blob/main/%E7%B3%BB%E7%BB%9F%E6%88%AA%E5%9B%BE/%E5%8C%BB%E4%BF%9D%E5%8D%A1%E6%9F%A5%E8%AF%A2.png)
图5 进入医保卡管理界面<br>

![](https://github.com/manxyr/Medical-insurance-service-platform/blob/main/%E7%B3%BB%E7%BB%9F%E6%88%AA%E5%9B%BE/%E5%85%A5%E4%BF%9D%E7%95%8C%E9%9D%A2.png)
图6 入保界面<br>

![](https://github.com/manxyr/Medical-insurance-service-platform/blob/main/%E7%B3%BB%E7%BB%9F%E6%88%AA%E5%9B%BE/%E9%80%80%E4%BF%9D%E7%A1%AE%E8%AE%A4.png)
图7 退保界面<br>

![](https://github.com/manxyr/Medical-insurance-service-platform/blob/main/%E7%B3%BB%E7%BB%9F%E6%88%AA%E5%9B%BE/%E6%8C%82%E5%A4%B1.png)
图8 挂失界面<br>

![](https://github.com/manxyr/Medical-insurance-service-platform/blob/main/%E7%B3%BB%E7%BB%9F%E6%88%AA%E5%9B%BE/%E6%90%9C%E7%B4%A2%E8%8D%AF%E5%93%81.jpg)
图9 查询药品<br>

![](https://github.com/manxyr/Medical-insurance-service-platform/blob/main/%E7%B3%BB%E7%BB%9F%E6%88%AA%E5%9B%BE/%E4%B8%AD%E8%8D%AF%E8%8D%AF%E8%8D%AF%E5%93%81%E5%90%8D%E5%8D%95.jpg)
图10 中成药药品名单<br>
