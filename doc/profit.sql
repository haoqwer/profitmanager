/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : profit

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2018-11-22 22:09:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for biz_game
-- ----------------------------
DROP TABLE IF EXISTS `biz_game`;
CREATE TABLE `biz_game` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) NOT NULL,
  `name` varchar(32) NOT NULL,
  `publisher` varchar(32) NOT NULL COMMENT '开发商',
  `created` datetime NOT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=1787 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of biz_game
-- ----------------------------
INSERT INTO `biz_game` VALUES ('1784', '123456', '王者荣耀', 'zw', '2018-11-22 14:16:38', null);

-- ----------------------------
-- Table structure for crm_account
-- ----------------------------
DROP TABLE IF EXISTS `crm_account`;
CREATE TABLE `crm_account` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `login_name` varchar(32) NOT NULL,
  `salt` varchar(32) DEFAULT NULL,
  `password` varchar(64) NOT NULL,
  `enable` bit(1) NOT NULL DEFAULT b'1',
  `created` datetime NOT NULL,
  `modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_user_UNIQUE` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_account
-- ----------------------------

-- ----------------------------
-- Table structure for t_game_subcontract
-- ----------------------------
DROP TABLE IF EXISTS `t_game_subcontract`;
CREATE TABLE `t_game_subcontract` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `channel_id` varchar(64) NOT NULL,
  `add` int(11) NOT NULL,
  `message_fee` int(11) NOT NULL,
  `AccountCleark` int(11) NOT NULL,
  `record_time` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_game_subcontract
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(64) NOT NULL,
  `enable` int(11) NOT NULL,
  `password` varchar(64) NOT NULL,
  `channel_name` varchar(64) NOT NULL,
  `channel_id` varchar(64) NOT NULL,
  `role_name` varchar(64) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '0', '5416d7cd6ef195a0f7622a9c56b55e84', 'guanliyuan', '88888888', '管理员', '2018-11-22 21:07:37');
