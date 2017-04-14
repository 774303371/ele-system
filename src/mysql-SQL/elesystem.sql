/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : elesystem

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-04-14 19:27:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ele_user`
-- ----------------------------
DROP TABLE IF EXISTS `ele_user`;
CREATE TABLE `ele_user` (
  `id` varchar(20) COLLATE utf8_bin NOT NULL,
  `name` varchar(20) COLLATE utf8_bin NOT NULL,
  `username` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `role` varchar(10) COLLATE utf8_bin DEFAULT 'ADMIN',
  `status` int(5) DEFAULT '0',
  `class` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of ele_user
-- ----------------------------
INSERT INTO `ele_user` VALUES ('1', '王萍', 'wangping', 'ADMIN', '1', '高级');
