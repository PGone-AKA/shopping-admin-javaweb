/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.100.1-mysql
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : supermarket

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 13/07/2021 22:02:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123456');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `gname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `bid` double(5, 2) NULL DEFAULT NULL,
  `price` double(5, 2) NULL DEFAULT NULL,
  `stock` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '可乐', 1.50, 3.50, 172);
INSERT INTO `goods` VALUES (2, '雪碧', 1.50, 3.50, 339);
INSERT INTO `goods` VALUES (3, '芬达', 2.00, 4.00, 69);
INSERT INTO `goods` VALUES (4, '冰红茶', 2.00, 4.00, 0);
INSERT INTO `goods` VALUES (5, '瓜子', 2.00, 5.50, 100);
INSERT INTO `goods` VALUES (6, '花生', 1.50, 3.00, 5000);

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record`  (
  `datetime` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `rid` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `gid` int NOT NULL,
  `num` int NULL DEFAULT NULL,
  PRIMARY KEY (`rid`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `gid`(`gid`) USING BTREE,
  CONSTRAINT `record_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `record_ibfk_2` FOREIGN KEY (`gid`) REFERENCES `goods` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('2021-05-07 15:30:58', 16, 18, 2, 5);
INSERT INTO `record` VALUES ('2021-05-07 15:31:01', 17, 18, 2, 5);
INSERT INTO `record` VALUES ('2021-05-07 15:33:09', 18, 18, 2, 5);
INSERT INTO `record` VALUES ('2021-05-07 15:33:27', 19, 18, 2, 5);
INSERT INTO `record` VALUES ('2021-05-07 15:33:39', 20, 18, 2, 5);
INSERT INTO `record` VALUES ('2021-05-07 15:34:02', 21, 18, 2, 5);
INSERT INTO `record` VALUES ('2021-05-07 15:37:05', 22, 18, 2, 5);
INSERT INTO `record` VALUES ('2021-05-07 15:37:25', 23, 18, 2, 5);
INSERT INTO `record` VALUES ('2021-05-07 15:38:02', 24, 18, 2, 5);
INSERT INTO `record` VALUES ('2021-05-07 15:38:33', 25, 18, 2, 5);
INSERT INTO `record` VALUES ('2021-05-18 21:00:52', 33, 17, 3, 100);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `upd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `usex` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `uage` int NULL DEFAULT NULL,
  `uphone` bigint NULL DEFAULT NULL,
  `ubalance` double(10, 2) NULL DEFAULT NULL,
  `udate` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `uname`(`uname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (17, '168@qq.com', 'yang123', '男', 12, 11111111111, 11.00, '2021-05-07 15:30:58');
INSERT INTO `user` VALUES (18, '1111111@qq.com', 'yang123', '女', 4546, 213142141, 1343134.00, '2021-05-07 15:30:58');
INSERT INTO `user` VALUES (19, 'hehe@qq.com', 'yang123', '男', 16, 1214141435, 8244.12, '2021-05-07 15:30:58');
INSERT INTO `user` VALUES (20, 'jx@edu.com', 'yang123', '男', 20, 15555555555, 89.00, '2021-05-07 15:30:58');
INSERT INTO `user` VALUES (23, 'qwe@qq.com', 'yang521', '男', 20, 17633505913, 59.50, '2021-05-07 15:30:58');
INSERT INTO `user` VALUES (25, 'yangyang@qq.com', '123456', '男', 15, 17777777777, 5000.00, '2021-05-21 11:19:15');

SET FOREIGN_KEY_CHECKS = 1;
