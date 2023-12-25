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
