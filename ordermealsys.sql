/*
Navicat MySQL Data Transfer

Source Server         : estore
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : ordermealsys

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-03-19 14:28:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------

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
  `buyer_name` varchar(50) DEFAULT NULL,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `order_item`
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(255) DEFAULT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `buyer_name` varchar(50) DEFAULT NULL,
  `seller_name` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `checked` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `product_pic` longtext,
  `product_detail` longtext,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_item
-- ----------------------------

-- ----------------------------
-- Table structure for `order_pay`
-- ----------------------------
DROP TABLE IF EXISTS `order_pay`;
CREATE TABLE `order_pay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(255) DEFAULT NULL,
  `buyer_name` varchar(50) DEFAULT NULL,
  `seller_name` varchar(50) DEFAULT NULL,
  `third_party_username` varchar(255) DEFAULT NULL,
  `serial_number` varchar(255) DEFAULT NULL,
  `pay_platform_name` varchar(255) DEFAULT NULL,
  `pay_status` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_pay
-- ----------------------------

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
  `seller_name` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `main_pic` longtext,
  `sub_pic1` longtext,
  `sub_pic2` longtext,
  `sub_pic3` longtext,
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------

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
  `buyer_name` varchar(50) DEFAULT NULL,
  `seller_name` varchar(50) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `product_price` decimal(10,2) DEFAULT NULL,
  `product_num` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'shn', '123', '123', '1233', '邵海楠', '11', '2018-02-26', '1', '11', '1', '11', '11', '1.00', '2018-03-12 00:59:00', '1', '1', '2018-03-16 14:20:33');
