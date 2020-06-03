/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.20-log : Database - db_food
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_food` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_food`;

/*Table structure for table `goods` */

DROP TABLE IF EXISTS `goods`;

CREATE TABLE `goods` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `goodsName` varchar(100) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `goodsDesc` varchar(200) DEFAULT NULL,
  `imageLink` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `goods` */

insert  into `goods`(`id`,`goodsName`,`price`,`goodsDesc`,`imageLink`) values (1,'大盘鸡',24,'大盘鸡，超好吃的哦','C:\\Users\\xx\\Desktop\\图片\\大盘鸡.jpg'),(2,'佛跳墙',250,'佛跳墙，超好吃的哦','C:\\Users\\xx\\Desktop\\图片\\佛跳墙.jpg'),(3,'牛肉泡馍',16,'牛肉泡馍，超好吃的哦','C:\\Users\\xx\\Desktop\\图片\\牛肉泡馍.jpg'),(4,'鱼香肉丝',4,'鱼香肉丝，超好吃的哦','C:\\Users\\xx\\Desktop\\图片\\鱼香肉丝.jpg'),(5,'肠粉',3,'肠粉，超好吃的哦','C:\\Users\\xx\\Desktop\\图片\\肠粉.jpg'),(6,'水煮牛肉',32,'水煮牛肉，超好吃的哦','C:\\Users\\xx\\Desktop\\图片\\水煮牛肉.jpg'),(7,'酸菜鱼',3.25,'酸菜鱼，超好吃的哦','C:\\Users\\xx\\Desktop\\图片\\酸菜鱼.jpg'),(8,'龙虾',50,'龙虾，超好吃的哦','C:\\Users\\xx\\Desktop\\图片\\龙虾.jpg'),(9,NULL,NULL,NULL,NULL);

/*Table structure for table `order_goods` */

DROP TABLE IF EXISTS `order_goods`;

CREATE TABLE `order_goods` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `orderId` varchar(50) DEFAULT NULL,
  `goodsTotalPrice` float DEFAULT NULL,
  `goodsId` int(10) DEFAULT NULL,
  `goodsPrice` float DEFAULT NULL,
  `goodsNum` int(10) DEFAULT NULL,
  `goodsName` varchar(100) DEFAULT NULL,
  `destination` varchar(100) DEFAULT NULL,
  `sendTime` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_order_goods_2` (`orderId`),
  KEY `FK_order_goods_1` (`goodsId`),
  CONSTRAINT `FK_order_goods_1` FOREIGN KEY (`goodsId`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_order_goods_2` FOREIGN KEY (`orderId`) REFERENCES `order_info` (`orderId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8;

/*Data for the table `order_goods` */

insert  into `order_goods`(`id`,`orderId`,`goodsTotalPrice`,`goodsId`,`goodsPrice`,`goodsNum`,`goodsName`,`destination`,`sendTime`) values (86,'20181216011330',16,6,16,1,'热狗肠','竹园410','11:00-12:00'),(87,'20181216012736',16,6,16,1,'水煮牛肉','竹园411','11:00-12:00'),(88,'20181216104724',12,1,12,1,'大盘鸡','竹园412','11:00-12:00'),(89,'20181216105419',16,3,16,1,'牛肉泡馍','竹园413','11:00-12:00'),(90,'20181216105652',16,3,16,1,'牛肉泡馍','竹园414','11:00-12:00'),(91,'20181216105910',12,5,12,1,'肠粉','竹园418','11:00-12:00'),(92,'20181216110657',12,5,12,1,'肠粉','竹园416','17:00-18:00'),(93,'20181216113253',12,5,12,1,'肠粉','竹园417','11:00-12:00'),(94,'20181216133607',24,1,24,1,'大盘鸡','竹园419','11:00-12:00'),(95,'20181216140954',24,1,24,1,'大盘鸡','竹园420','11:20'),(96,'20181216140954',16,4,16,1,'鱼香肉丝','竹园420','11:20'),(97,'20181216140954',12,5,12,1,'肠粉','竹园420','11:20'),(98,'20181216155536',1.5,5,1.5,1,'肠粉','竹园415','17:00-18:00'),(99,'20181216155536',4,4,4,1,'鱼香肉丝','竹园415','17:00-18:00'),(100,'20190127162654',24,1,24,1,'大盘鸡','415','11:00-12:00'),(101,'20190127162654',3,5,3,1,'肠粉','415','11:00-12:00'),(102,'20190127162654',50,8,50,1,'龙虾','415','11:00-12:00'),(103,'20190127162654',12,4,4,3,'鱼香肉丝','415','11:00-12:00'),(104,'20190829103012',24,1,24,1,'大盘鸡','4','11:00-12:00'),(105,'20190829103012',500,2,250,2,'佛跳墙','4','11:00-12:00'),(106,'20190829103041',1000,2,250,4,'佛跳墙','456','11:00-12:00'),(107,'20190829150755',24,1,24,1,'大盘鸡','789456132','21:00-22:00'),(108,'20190829150755',50,8,50,1,'龙虾','789456132','21:00-22:00'),(109,'20190829150755',3.25,7,3.25,1,'酸菜鱼','789456132','21:00-22:00'),(110,'20190829150755',32,6,32,1,'水煮牛肉','789456132','21:00-22:00'),(111,'20190829155743',250,2,250,1,'佛跳墙',NULL,NULL),(112,'20200603231402',24,1,24,1,'大盘鸡','r','11:00-12:00'),(113,'20200603231402',3,5,3,1,'肠粉','r','11:00-12:00');

/*Table structure for table `order_info` */

DROP TABLE IF EXISTS `order_info`;

CREATE TABLE `order_info` (
  `orderId` varchar(50) NOT NULL,
  `orderStatus` int(10) DEFAULT NULL,
  `orderNum` int(10) DEFAULT NULL,
  `orderTotalMoney` float DEFAULT NULL,
  `userName` varchar(100) DEFAULT NULL,
  `id` int(10) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order_info` */

insert  into `order_info`(`orderId`,`orderStatus`,`orderNum`,`orderTotalMoney`,`userName`,`id`) values ('20181216011330',3,1,16,'aaa',8),('20181216012736',3,1,16,'aaa',8),('20181216104724',3,1,12,'aaa',8),('20181216105419',0,1,16,'aaa',8),('20181216105652',0,1,16,'aaa',8),('20181216105910',0,1,12,'aaa',8),('20181216110550',0,1,12,'aaa',8),('20181216110657',0,1,12,'aaa',8),('20181216113253',0,1,12,'aaa',8),('20181216133607',2,1,24,'aaa',8),('20181216140954',2,3,52,'aaa',8),('20181216155536',0,2,5.5,'aaa',10),('20190127162654',0,6,89,'aaa',10),('20190829103012',0,3,524,'aaa',10),('20190829103041',0,4,1000,'aaa',10),('20190829150755',2,4,109.25,'aaa',10),('20190829155743',0,1,250,'aaa',10),('20200603231402',0,2,27,'aaa',10);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `rank` int(1) DEFAULT '0',
  `salary` double(10,2) DEFAULT NULL,
  `registered` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`userName`,`password`,`email`,`rank`,`salary`,`registered`) values (1,'admin','123',NULL,1,100.00,1),(2,'bbb','123','1182@qq.com',0,100.00,1),(3,'we','123','456456@qq.com',0,100.00,0),(4,'ppppp','123','123@qq.com',0,100.00,0),(5,'admin1','123',NULL,0,100.00,1),(6,'normal','123',NULL,2,NULL,1),(7,'send','123',NULL,3,NULL,1),(8,'adsfasdfasdf','123','896165@qq.com',2,100.00,1),(9,'asdfasdf','123','4864@qq.com',3,100.00,1),(10,'aaa','123','896168378@qq.com',0,998969.25,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
