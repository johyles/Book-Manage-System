/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50621
 Source Host           : localhost:3306
 Source Schema         : book_manage

 Target Server Type    : MySQL
 Target Server Version : 50621
 File Encoding         : 65001

 Date: 02/07/2020 16:02:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(11) NOT NULL,
  `usename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '202cb962ac59075b964b07152d234b70');
INSERT INTO `admin` VALUES (2, 'xiaotree', '123');

-- ----------------------------
-- Table structure for book_info
-- ----------------------------
DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info`  (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `bname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ISBN` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `class_id` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `publish` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`bid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of book_info
-- ----------------------------
INSERT INTO `book_info` VALUES (1, '平凡的世界', '123456789', '111.0', 3, 10, '好书', '路遥', '人民出版社');
INSERT INTO `book_info` VALUES (2, '追风筝的人', '23456782', '34', 2, 3, '追风筝', '胡塞尼', '机械出版社');
INSERT INTO `book_info` VALUES (3, '三体', '23456785', '111.0', 3, 4, '科幻书', '刘慈欣', '机械出版社');
INSERT INTO `book_info` VALUES (4, '明朝那些事', '34567836', '35', 4, 6, '历史书', '当年明月', '人民出版社');

-- ----------------------------
-- Table structure for class_info
-- ----------------------------
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info`  (
  `class_id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`class_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of class_info
-- ----------------------------
INSERT INTO `class_info` VALUES (1, '艺术类');
INSERT INTO `class_info` VALUES (2, '科幻类');
INSERT INTO `class_info` VALUES (3, '散文类');
INSERT INTO `class_info` VALUES (4, '音乐类');
INSERT INTO `class_info` VALUES (5, '信息技术类');
INSERT INTO `class_info` VALUES (6, '传记类');

-- ----------------------------
-- Table structure for lend_info
-- ----------------------------
DROP TABLE IF EXISTS `lend_info`;
CREATE TABLE `lend_info`  (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `bid` int(11) NOT NULL,
  `lend_date` date NOT NULL,
  `back_date` date NOT NULL,
  PRIMARY KEY (`lid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of lend_info
-- ----------------------------
INSERT INTO `lend_info` VALUES (1, 1, 1, '2020-06-09', '2020-06-10');
INSERT INTO `lend_info` VALUES (2, 1, 2, '2020-06-11', '2020-07-11');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `num` int(11) NULL DEFAULT NULL,
  `balance` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'xiaobao', '202cb962ac59075b964b07152d234b70', 0, 200);
INSERT INTO `user_info` VALUES (2, 'abc', '250cf8b51c773f3f8dc8b4be867a9a02', 6, 6);
INSERT INTO `user_info` VALUES (3, 'aaa', '68053af2923e00204c3ca7c6a3150cf7', 5, 5);
INSERT INTO `user_info` VALUES (4, 'xiaoa', '202cb962ac59075b964b07152d234b70', 4, 4);
INSERT INTO `user_info` VALUES (5, 'xiaob', '202cb962ac59075b964b07152d234b70', 2, 2);
INSERT INTO `user_info` VALUES (6, 'luqijun', '202cb962ac59075b964b07152d234b70', 123, 123);
INSERT INTO `user_info` VALUES (8, 'xiaoxiao', 'd9b1d7db4cd6e70935368a1efb10e377', 0, 0);
INSERT INTO `user_info` VALUES (9, 'xiaoaa', '202cb962ac59075b964b07152d234b70', 0, 0);
INSERT INTO `user_info` VALUES (21, 'xiaoxiaoa11', 'd9b1d7db4cd6e70935368a1efb10e377', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
