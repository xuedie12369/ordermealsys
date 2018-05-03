/*
Navicat MySQL Data Transfer

Source Server         : estore
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : ordermealsys

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-05-03 11:44:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `consignee_name` varchar(50) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `nation` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `county` varchar(255) DEFAULT NULL,
  `town` varchar(255) DEFAULT NULL,
  `post_code` varchar(255) DEFAULT NULL,
  `detailed_add` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('1', '1', '邵海楠', '1', '13131', '21', null, null, null, null, null, '中山学院', null, null);
INSERT INTO `address` VALUES ('2', '1', '三公子', '1', '13999', '5', null, null, null, null, null, '岐头', null, null);

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL,
  `pro_id` int(11) DEFAULT NULL,
  `seller_name` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `updatetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '1', null, 'qwe', '烧烤', null, '2018-04-22 14:03:13');
INSERT INTO `category` VALUES ('2', '3', null, 'qweqe', '下午茶', null, '2018-04-22 14:03:21');
INSERT INTO `category` VALUES ('3', '1', null, 'qweqe', '西餐', null, '2018-04-22 14:03:25');
INSERT INTO `category` VALUES ('4', '2', null, 'qwe111', '面食', null, '2018-04-22 14:03:30');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_id` int(11) DEFAULT NULL,
  `buyer_name` varchar(50) DEFAULT NULL,
  `seller_name` varchar(50) DEFAULT NULL,
  `pro_type` int(11) DEFAULT NULL,
  `store_type` int(11) DEFAULT NULL,
  `pro_com_content` varchar(255) DEFAULT NULL,
  `ser_com_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for `comment_pic`
-- ----------------------------
DROP TABLE IF EXISTS `comment_pic`;
CREATE TABLE `comment_pic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_id` int(11) DEFAULT NULL,
  `pic` longtext,
  `createtime` datetime DEFAULT NULL,
  `updatetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment_pic
-- ----------------------------

-- ----------------------------
-- Table structure for `delivery_fee`
-- ----------------------------
DROP TABLE IF EXISTS `delivery_fee`;
CREATE TABLE `delivery_fee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seller_name` varchar(50) DEFAULT NULL,
  `range` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of delivery_fee
-- ----------------------------

-- ----------------------------
-- Table structure for `delivery_time`
-- ----------------------------
DROP TABLE IF EXISTS `delivery_time`;
CREATE TABLE `delivery_time` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seller_name` varchar(50) DEFAULT NULL,
  `delivery_time` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of delivery_time
-- ----------------------------

-- ----------------------------
-- Table structure for `login`
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `log_time` datetime DEFAULT NULL,
  `device_name` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `date_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------

-- ----------------------------
-- Table structure for `operate`
-- ----------------------------
DROP TABLE IF EXISTS `operate`;
CREATE TABLE `operate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seller_name` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `auto_handle` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operate
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seller_name` varchar(50) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `order_no` bigint(20) DEFAULT NULL,
  `total_price` decimal(10,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `delivery_type` int(11) DEFAULT NULL,
  `order_type` int(11) DEFAULT NULL,
  `pay_status` int(11) DEFAULT NULL,
  `order_notes` varchar(255) DEFAULT NULL,
  `delivery_time` varchar(0) DEFAULT NULL,
  `delete_status` int(11) DEFAULT NULL,
  `delivery_fee` decimal(10,2) DEFAULT NULL,
  `order_status` int(11) DEFAULT NULL,
  `pay_time` datetime DEFAULT NULL,
  `transact_closing_time` datetime DEFAULT NULL,
  `transact_comple_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `box_total_price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '11', '1', '47', '70.00', '2018-03-14 19:38:08', null, null, '10', null, null, null, null, null, '2018-04-25 12:56:21', null, null, null, null);
INSERT INTO `order` VALUES ('2', '11', '11', '2', '1.00', '2018-03-05 00:45:40', '1', '1', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `order` VALUES ('3', '1', null, '11', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `order_item`
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` bigint(20) DEFAULT NULL,
  `product_id` int(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `seller_name` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `product_pic` longtext,
  `product_detail` longtext,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES ('1', '47', '1111', '牛排', '1', '1', '50.00', '1', '22', '详情', '2018-03-29 16:44:08', '2018-05-02 19:34:07');
INSERT INTO `order_item` VALUES ('2', '47', '3', '沙拉', '1', '222', '20.00', '1', '1', '详情', '2018-03-05 16:44:05', '2018-05-02 19:34:47');

-- ----------------------------
-- Table structure for `order_pay`
-- ----------------------------
DROP TABLE IF EXISTS `order_pay`;
CREATE TABLE `order_pay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` bigint(20) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `third_party_username` int(11) DEFAULT NULL,
  `serial_number` varchar(255) DEFAULT NULL,
  `pay_platform_name` int(11) DEFAULT NULL,
  `pay_status` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_pay
-- ----------------------------
INSERT INTO `order_pay` VALUES ('1', '24', '11', null, '2018042521001004150200446211', '1', 'TRADE_SUCCESS', null, null);
INSERT INTO `order_pay` VALUES ('2', '35', '11', null, '2018042521001004150200446547', '1', 'TRADE_SUCCESS', null, null);
INSERT INTO `order_pay` VALUES ('3', '36', '11', null, '2018042521001004150200446552', '1', 'TRADE_SUCCESS', null, null);
INSERT INTO `order_pay` VALUES ('4', '37', '11', null, '2018042521001004150200446555', '1', 'TRADE_SUCCESS', null, null);
INSERT INTO `order_pay` VALUES ('5', '39', '11', null, '2018042521001004150200446432', '1', 'TRADE_SUCCESS', null, null);
INSERT INTO `order_pay` VALUES ('6', '41', '11', null, '2018042521001004150200446558', '1', 'TRADE_SUCCESS', null, null);
INSERT INTO `order_pay` VALUES ('7', '42', '11', null, '2018042521001004150200446434', '1', 'TRADE_SUCCESS', null, null);
INSERT INTO `order_pay` VALUES ('8', '45', '11', null, '2018042521001004150200446438', '1', 'TRADE_SUCCESS', null, null);

-- ----------------------------
-- Table structure for `order_status`
-- ----------------------------
DROP TABLE IF EXISTS `order_status`;
CREATE TABLE `order_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(255) DEFAULT NULL,
  `order_status` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_status
-- ----------------------------

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL,
  `seller_name` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `main_pic` varchar(255) DEFAULT NULL,
  `sub_pic` varchar(255) DEFAULT NULL,
  `detail` longtext,
  `price` decimal(10,2) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `sales` int(11) DEFAULT NULL,
  `pro_status` int(11) DEFAULT NULL,
  `del_status` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  `delivery_fee` decimal(10,2) DEFAULT NULL,
  `box_fee` decimal(10,2) DEFAULT NULL,
  `box_price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('46', null, null, '猪扒', 'productImg/ecba2407-f2cc-4e3b-a3fb-b409b04b8651.jpg', null, '<p>阿萨德撒</p>', '111.00', '11', null, '1', null, null, null, null, null, '11.00');
INSERT INTO `product` VALUES ('47', '3', null, '虾宝', 'productImg/4c1536d4-60c5-46c3-a0d0-113c81ffb8c6.jpg', null, '<p style=\"text-align: center;\">&nbsp; 这是龙虾<img src=\"http://img.baidu.com/hi/jx2/j_0013.gif\"/></p>', '100.00', '10000', null, '1', null, null, null, null, null, '3.00');
INSERT INTO `product` VALUES ('48', '2', null, '草莓布丁', 'productImg/132aed63-dee5-4f38-8e47-1f58b74f53ba.jpg', null, '<p style=\"text-align: left;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;牛奶布丁<img src=\"http://img.baidu.com/hi/jx2/j_0006.gif\"/></p>', '20.00', '100', null, '1', null, null, null, null, null, '1.00');
INSERT INTO `product` VALUES ('50', '4', null, '意面', 'productImg/ab34a021-9033-4c0d-a458-5068ef98357b.jpg', null, '', '30.00', '1111', null, '1', null, null, null, null, null, '1.00');
INSERT INTO `product` VALUES ('51', '3', null, '西施牛排', 'productImg/5e9d769c-74f5-4e56-8edb-c43dc3aaa909.jpg', null, '<p>&nbsp;&nbsp;&nbsp;&nbsp;西施牛扒<br/></p>', '180.00', '100', null, '1', null, null, null, null, null, '10.00');
INSERT INTO `product` VALUES ('52', '3', null, '披萨', 'productImg/59b3178a-461e-4ff2-96e7-5ba441e2c932.jpg', null, '<p>&nbsp;&nbsp;&nbsp;&nbsp;<img src=\"http://img.baidu.com/hi/jx2/j_0013.gif\"/>披萨</p>', '20.00', '1000', null, '1', null, null, null, null, null, '0.00');

-- ----------------------------
-- Table structure for `refund`
-- ----------------------------
DROP TABLE IF EXISTS `refund`;
CREATE TABLE `refund` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  `explain` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of refund
-- ----------------------------

-- ----------------------------
-- Table structure for `refund_pic`
-- ----------------------------
DROP TABLE IF EXISTS `refund_pic`;
CREATE TABLE `refund_pic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `refund_id` int(11) DEFAULT NULL,
  `pic_url` longtext,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of refund_pic
-- ----------------------------

-- ----------------------------
-- Table structure for `shopping_cart`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `buyer_name` varchar(50) DEFAULT NULL,
  `seller_name` varchar(50) DEFAULT NULL,
  `checked` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `product_price` decimal(10,2) DEFAULT NULL,
  `product_num` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------
INSERT INTO `shopping_cart` VALUES ('20', '1', null, null, '1', '47', '100.00', '1', '2018-05-03 10:43:18', null);
INSERT INTO `shopping_cart` VALUES ('21', '1', null, null, '1', '48', null, '1', '2018-05-03 10:43:20', null);
INSERT INTO `shopping_cart` VALUES ('22', '1', null, null, '1', '52', '20.00', '1', '2018-05-03 10:43:58', null);
INSERT INTO `shopping_cart` VALUES ('23', '1', null, null, '1', '51', '180.00', '5', '2018-05-03 10:44:00', '2018-05-03 10:44:59');
INSERT INTO `shopping_cart` VALUES ('24', '1', null, null, '1', '50', '30.00', '1', '2018-05-03 10:44:01', null);

-- ----------------------------
-- Table structure for `store`
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seller_name` varchar(50) DEFAULT NULL,
  `store_name` varchar(50) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  `integral` int(11) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `nation` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `county` varchar(255) DEFAULT NULL,
  `town` varchar(255) DEFAULT NULL,
  `detail_add` varchar(255) DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `school` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store
-- ----------------------------

-- ----------------------------
-- Table structure for `store_pic`
-- ----------------------------
DROP TABLE IF EXISTS `store_pic`;
CREATE TABLE `store_pic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seller_name` varchar(50) DEFAULT NULL,
  `environment_pic` longtext,
  `license_pic` longtext,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store_pic
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `pwd` varchar(50) DEFAULT NULL,
  `pay_pwd` varchar(50) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `nick_name` varchar(50) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `pic` longtext,
  `grade` int(11) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `balance` decimal(10,2) DEFAULT NULL,
  `creat_time` datetime DEFAULT NULL,
  `def_add` int(200) DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'shn', '123', '123', '1233', '邵海楠', '11', '2018-02-26', '1', '11', '1', '11', '1', '1.00', '2018-03-12 00:59:00', '1', '1', '2018-04-13 19:05:19');
INSERT INTO `user` VALUES ('2', null, null, null, '18888888888', null, null, null, null, '18888888888@qq.com', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('3', null, null, null, '18888888888', null, null, null, null, '18888888888@126.com', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('4', null, '1111111', null, '18888888888', null, null, null, null, '1@126.com', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('5', 'userName', '1123456', null, '18888888888', null, null, null, null, '1we@qq.com', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('6', '11111111as', '11111111as', null, '18888888888', null, null, null, null, '12z@126.com', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('7', '1111111', '123456', null, '18888888888', null, null, null, null, '111@qq.com', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('8', '11asdada', '111111111', null, '18888888888', null, null, null, null, '1@sina.com.cn', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('9', '11111', '11asdada', null, '18888888888', null, null, null, null, '133@163.com', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('10', '1111', '111111', null, '18888888888', null, null, null, null, '11@qq.com', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('11', '111111111111', '111111', null, '18888888888', null, null, null, null, '1@qq.com', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('12', '123456', '123456789', null, '18888888888', null, null, null, null, '50@163.com', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('13', '1234561', '123456789', null, '18888888888', null, null, null, null, '12121221sa@163.com', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('14', '123456789', '123456789', null, '18888888888', null, null, null, null, 'zxc@qq.com', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('15', '萨达萨达', '123456789', null, '18888888888', null, null, null, null, '1a@126.com', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('16', '12asdad', '123456789', null, '18888888888', null, null, null, null, 'asd212@qq.com', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('17', '123456asd', '123456', null, '18888888888', null, null, null, null, '1sadsadsad@126.com', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('18', '111111sdf', '123456', null, '18888888888', null, null, null, null, '5asda@qq.com', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('19', '661111111', '123456', null, '18888888888', null, null, null, null, '50sadsad@126.com', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('20', 'sadsadsa123', '123456', null, '18888888888', null, null, null, null, '5zsdsa@qq.com', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('21', '21311212', '123456', null, '18888888888', null, null, null, null, '1sadsad@163.com', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('22', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('23', '1545454', '123456', null, '18888888888', null, null, null, null, '5221@163.com', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('24', '1231234645', '123456789', null, '18888888888', null, null, null, null, '21211a@qq.com', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('26', 'hjs', '839DBF24566AEFE7A555A8BD0D7990EB', null, null, null, null, null, null, '854208266', null, null, '0', null, null, null, null, null);
INSERT INTO `user` VALUES ('27', 'xuedie', '38D9A4C8127381D890B122241033AC2A', null, '18888888888', null, null, null, null, '1888@qq.com', null, null, '0', null, null, null, null, null);
INSERT INTO `user` VALUES ('28', 'xuedie12369', '38D9A4C8127381D890B122241033AC2A', null, '18888888888', null, null, null, null, '501968797@qq.com', null, null, '0', null, null, null, null, null);
INSERT INTO `user` VALUES ('29', 'xuedie521', '38D9A4C8127381D890B122241033AC2A', null, '18888888888', null, null, null, null, '5019687987@qq.com', null, null, '0', null, null, null, null, null);
INSERT INTO `user` VALUES ('30', 'xuedie123699', '123456789', null, '18888888888', null, null, null, null, '1811@qq.com', null, null, '0', null, null, null, null, null);

-- ----------------------------
-- Table structure for `user_security`
-- ----------------------------
DROP TABLE IF EXISTS `user_security`;
CREATE TABLE `user_security` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `question` varchar(255) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_security
-- ----------------------------
