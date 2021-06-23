/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : umis

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2021-06-23 17:36:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` int(10) NOT NULL,
  `admin_name` varchar(255) DEFAULT NULL,
  `admin_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'tt', 'tt123456');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `course_id` int(255) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) DEFAULT NULL,
  `course_score` int(10) DEFAULT NULL,
  `teacher_id` int(10) DEFAULT NULL,
  `teacher_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '数据结构', '2', '1001', '李柏松');
INSERT INTO `course` VALUES ('2', '计算机网络', '3', '1002', '张传宝');
INSERT INTO `course` VALUES ('3', '毛概', '5', '1003', '余佩佩');
INSERT INTO `course` VALUES ('4', '常微分方程', '1', '1001', '李柏松');

-- ----------------------------
-- Table structure for sc
-- ----------------------------
DROP TABLE IF EXISTS `sc`;
CREATE TABLE `sc` (
  `student_id` int(10) NOT NULL AUTO_INCREMENT,
  `course_id` int(10) NOT NULL,
  `teacher_id` int(10) DEFAULT NULL,
  `student_grade` int(10) DEFAULT NULL,
  `course_score` int(10) DEFAULT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  `course_name` varchar(255) DEFAULT NULL,
  `teacher_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_id`,`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2018201112 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of sc
-- ----------------------------
INSERT INTO `sc` VALUES ('2018201111', '2', '1002', '0', '3', '白子琦', '计算机网络', '张传宝');
INSERT INTO `sc` VALUES ('2018201111', '3', '1003', '0', '5', '白子琦', '毛概', '余佩佩');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` int(10) NOT NULL,
  `student_name` varchar(255) DEFAULT NULL,
  `student_department` varchar(255) DEFAULT NULL,
  `student_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('2018201111', '白子琦', '软件学院', 'z123456');
INSERT INTO `student` VALUES ('2018201112', '陈小二', '软件学院', 'z123456');
INSERT INTO `student` VALUES ('2018201113', '徐晓晓', '软件学院', 'z123456');
INSERT INTO `student` VALUES ('2018201114', '任贵晗', '软件学院', 'z123456');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `teacher_id` int(10) NOT NULL,
  `teacher_name` varchar(255) DEFAULT NULL,
  `teacher_department` varchar(255) DEFAULT NULL,
  `teacher_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`teacher_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1001', '李柏松', '软件学院', 'z123456');
INSERT INTO `teacher` VALUES ('1002', '张传宝', '计算机学院', 'z123456');
INSERT INTO `teacher` VALUES ('1003', '余佩佩', '国防学院', 'z123456');
