/*
 Navicat Premium Data Transfer

 Source Server         : tencentcloud
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : 43.139.24.229:3306
 Source Schema         : dp_questionnaire

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 15/03/2023 14:11:41
*/
create database dp_questionnaire;
use dp_questionnaire;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for administrator
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator`  (
  `id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '问题id',
  `user_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '密码',
  `name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '真实姓名',
  `profile` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '头像地址',
  `phone` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '电话号码',
  `email` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '邮箱地址',
  `gender` int(0) DEFAULT NULL COMMENT '性别',
  `age` int(0) DEFAULT NULL COMMENT '年龄',
  `description` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '个人简介',
  `created_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `created_by` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '创建人',
  `updated_by` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '更新人',
  `deleted` bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of administrator
-- ----------------------------
INSERT INTO `administrator` VALUES ('u10001', 'admin', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '汪瑞斌', NULL, '18850292637', '', 1, 24, NULL, '2023-03-15 10:49:15', '2023-03-15 10:49:15', 'system', 'system', b'0');

-- ----------------------------
-- Table structure for answer
-- ----------------------------
DROP TABLE IF EXISTS `answer`;
CREATE TABLE `answer`  (
  `id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '回答结果id',
  `sub_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '受试者id',
  `module_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '模块id',
  `module_no` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '模块编号',
  `que_result` json COMMENT '{\r\n			‘que001’:{‘label’:’xxx’,’value’:’xxx’,’type’:0},\r\n			‘que002’: {‘label’:’xxx’,’value’:’xxx’ ,’type’:1},\r\n			…\r\n}\r\n',
  `created_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `created_by` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '创建人',
  `updated_by` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '更新人',
  `deleted` bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for module
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module`  (
  `id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '模块id',
  `template_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '所属问卷模板',
  `module_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '模块名',
  `module_no` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '模块编号',
  `description` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci COMMENT '模块说明',
  `sorted` bit(1) NOT NULL DEFAULT b'1' COMMENT '判断模块中的题目是否加入顺序队列',
  `serial_num` int(0) DEFAULT NULL COMMENT '序号',
  `created_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `created_by` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '创建人',
  `updated_by` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '更新人',
  `deleted` bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES ('m10001', 't10001', '测试模块1', 'A', '测试模块1', b'1', 65536, '2023-03-15 10:51:31', '2023-03-15 10:51:31', 'system', 'system', b'0');
INSERT INTO `module` VALUES ('m10002', 't10001', '测试模块2', 'B', '测试模块2', b'1', 131072, '2023-03-15 10:52:46', '2023-03-15 10:52:46', 'system', 'system', b'0');
INSERT INTO `module` VALUES ('m10003', 't10001', '额外模块1', 'O', '测试模块3', b'0', NULL, '2023-03-15 10:53:25', '2023-03-15 10:53:25', 'system', 'system', b'0');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '问题id',
  `module_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '问题属于哪个模块',
  `module_no` varchar(3) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '模块编号用于显示',
  `question_no` varchar(3) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '问题的编号用于线索',
  `que_type` int(0) DEFAULT NULL COMMENT '0是问题，1是诊断框',
  `opt_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '问题的选项类型如RADIO',
  `issue` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci COMMENT '问题',
  `note` longtext CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci COMMENT '问题补充',
  `answers` int(0) NOT NULL DEFAULT 0 COMMENT '提醒改题目由谁作答',
  `option` json COMMENT '选项\r\n{’options’:[\n{‘label’:’ 需要输入回答的问题1’,’value’:0},\n{‘label’:’ 需要输入回答的问题2’,’value’:1}\n]}\n',
  `skip_rule_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '跳转规则',
  `ref_ids` json COMMENT '[\'10001\',\'10002\']',
  `serial_num` int(0) DEFAULT NULL COMMENT '序号',
  `created_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `created_by` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '创建人',
  `updated_by` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '更新人',
  `deleted` bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('q10001', 'm10001', 'A', '1a', 0, 'RADIO', '你是否曾经至少有 2 周，差不多每天的大部分时间一直觉得抑郁或情绪低落?', '或感觉伤悲，空虚或没有希望？\r', 0, '{\"options\": [{\"label\": \"35元以下\", \"value\": 1}, {\"label\": \"35-50元\", \"value\": 2}, {\"label\": \"51-80元\", \"value\": 3}, {\"label\": \"81-120元\", \"value\": 4}, {\"label\": \"121-150元\", \"value\": 5}, {\"label\": \"150元以上\", \"value\": 6}]}', NULL, NULL, 65536, '2023-03-15 11:29:18', '2023-03-15 13:57:53', 'system', 'system', b'0');
INSERT INTO `question` VALUES ('q10002', 'm10001', 'A', '1b', 0, 'RADIO', '最近两星期以来，你是否差不多每天的大部分时间都一直觉得忧郁或情绪低落？ ', '或感觉伤悲，空虚或没有希望？', 0, '{\"options\": [{\"label\": \"否\", \"value\": 0}, {\"label\": \"是\", \"value\": 1}, {\"label\": \"51-80元\", \"value\": 3}, {\"label\": \"81-120元\", \"value\": 4}, {\"label\": \"121-150元\", \"value\": 5}, {\"label\": \"150元以上\", \"value\": 6}]}', NULL, NULL, 131072, '2023-03-15 11:34:51', '2023-03-15 13:57:54', 'system', 'system', b'0');
INSERT INTO `question` VALUES ('q10003', 'm10001', 'A', '2a', 0, 'RADIO', '你是否曾经至少有 2 周，对大多数事物不那么有兴趣，或对于过去大部分时间应会觉得愉快的事情不那么喜欢了？', NULL, 0, '{\"options\": [{\"label\": \"否\", \"value\": 0}, {\"label\": \"是\", \"value\": 1}]}', NULL, NULL, 196608, '2023-03-15 11:37:07', '2023-03-15 13:57:56', 'system', 'system', b'0');

-- ----------------------------
-- Table structure for skip
-- ----------------------------
DROP TABLE IF EXISTS `skip`;
CREATE TABLE `skip`  (
  `id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '唯一定位跳转规则',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '诊断程序描述',
  `type` int(0) NOT NULL DEFAULT 0 COMMENT '跳转至题目为0\r\n跳转至诊断框为1\r\n跳转至子问题为2\r\n跳转至模块为3\r\n跳转至诊断程序问题4\r\n',
  `que_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '根据问题id获取子问题',
  `target` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '跳转目标id',
  `condition` json COMMENT '跳转条件',
  `created_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `created_by` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '创建人',
  `updated_by` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '更新人',
  `deleted` bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of skip
-- ----------------------------
INSERT INTO `skip` VALUES ('sk10001', '', 0, 'q10001', 'q10003', '{\"or\": {}, \"and\": {}, \"type\": 0, \"value\": 0, \"queIds\": [\"q10001\"], \"operator\": 0}', '2023-03-15 11:43:11', '2023-03-15 11:43:11', 'system', 'system', b'0');

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject`  (
  `id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '受试者id',
  `name` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '受试者姓名',
  `phone` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '受试者电话',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `admin_id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '负责的管理员id',
  `begindate` date DEFAULT NULL COMMENT '检查日期',
  `start_time` timestamp(0) DEFAULT NULL COMMENT '开始时间',
  `end_time` timestamp(0) DEFAULT NULL COMMENT '结束时间',
  `state` int(0) DEFAULT NULL COMMENT '问卷进行状态（0,未完成，1，进行中，2，已完成，3，已终止）',
  `result` json COMMENT '诊断的疾病集合',
  `created_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `created_by` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '创建人',
  `updated_by` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '更新人',
  `deleted` bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for template
-- ----------------------------
DROP TABLE IF EXISTS `template`;
CREATE TABLE `template`  (
  `id` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '模板id',
  `template_name` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL COMMENT '模板名',
  `description` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci COMMENT '模板介绍',
  `created_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `created_by` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '创建人',
  `updated_by` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL COMMENT '更新人',
  `deleted` bit(1) DEFAULT b'0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of template
-- ----------------------------
INSERT INTO `template` VALUES ('t10001', '测试模板', '用于测试用模板', '2023-03-15 10:50:06', '2023-03-15 10:50:06', 'system', 'system', b'0');

SET FOREIGN_KEY_CHECKS = 1;
