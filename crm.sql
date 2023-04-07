/*
 Navicat MySQL Data Transfer

 Source Server         : springboot
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : crm

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 07/04/2023 14:57:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_activity
-- ----------------------------
DROP TABLE IF EXISTS `tbl_activity`;
CREATE TABLE `tbl_activity`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `owner` char(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `start_date` char(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `end_date` char(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `cost` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_time` char(19) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_activity
-- ----------------------------
INSERT INTO `tbl_activity` VALUES ('0f3560c949c244cdbec5ce02e08bc7a1', '06f5fc056eac41558a964f96daa7f27c', '测试01', '2022-09-01', '2023-09-01', '90', NULL, '2022-09-01 00:39:23', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL);
INSERT INTO `tbl_activity` VALUES ('205d8b9bfb4146e484b8e5a1f30e0a49', '06f5fc056eac41558a964f96daa7f27c', '测试03', '2022-09-01', '2023-09-01', '90', '文玩', '2022-09-01 10:40:54', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL);
INSERT INTO `tbl_activity` VALUES ('4127a024995c41fdb6be3b23b0b524c2', '40f6cdea0bd34aceb77492a1656d9fb3', 'ii测试03_2', '2020-10-26', '2020-10-29', '40000', '描述测试03_2', '2023-04-05 23:09:50', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL);
INSERT INTO `tbl_activity` VALUES ('49aead4b2e26458aa5375ec154ed2671', '06f5fc056eac41558a964f96daa7f27c', '测试02', '2022-09-01', '2023-09-01', '100', '这是测试', '2022-09-01 10:29:52', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-09-06 00:55:15', '40f6cdea0bd34aceb77492a1656d9fb3');
INSERT INTO `tbl_activity` VALUES ('5dee327581c04838a4a26f1738fdc34f', '40f6cdea0bd34aceb77492a1656d9fb3', 'ii测试04', '2020-10-26', '2020-10-28', '3000', '描述测试04', '2023-04-05 23:09:50', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL);
INSERT INTO `tbl_activity` VALUES ('d1512c5a7b394079b477f2cbec52ec50', '06f5fc056eac41558a964f96daa7f27c', '测试04', '2022-11-22', '2023-01-31', '1000', '测试04', '2022-11-22 15:03:19', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL);

-- ----------------------------
-- Table structure for tbl_activity_remark
-- ----------------------------
DROP TABLE IF EXISTS `tbl_activity_remark`;
CREATE TABLE `tbl_activity_remark`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `note_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_time` char(19) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_flag` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '0??ʾδ?޸ģ?1??ʾ???޸',
  `activity_id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_activity_remark
-- ----------------------------
INSERT INTO `tbl_activity_remark` VALUES ('20c1601837654068888f3dc8ebd5de6c', '11122', '2022-09-10 01:06:06', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-09-10 01:06:12', '40f6cdea0bd34aceb77492a1656d9fb3', '1', '205d8b9bfb4146e484b8e5a1f30e0a49');
INSERT INTO `tbl_activity_remark` VALUES ('387a46f34efb43549146b4661685cbf1', 'ui', '2022-09-10 15:45:11', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-09-12 23:27:01', '40f6cdea0bd34aceb77492a1656d9fb3', '1', 'da805ef6aca544e0854bc63df334b158');
INSERT INTO `tbl_activity_remark` VALUES ('3a1e23475a4640db951a25ea391fbf88', '阿达33大三ww2', '2022-09-10 01:07:34', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-09-12 17:33:12', '40f6cdea0bd34aceb77492a1656d9fb3', '1', '44fbe4245db54188b18ce811888d5d62');
INSERT INTO `tbl_activity_remark` VALUES ('4130d9a8b79f4b55b641a62cfd5ad92d', '阿瑟斯', '2022-09-12 17:33:28', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL, '0', '44fbe4245db54188b18ce811888d5d62');
INSERT INTO `tbl_activity_remark` VALUES ('44f64fb2923b493eada95b4e51aa0a06', '哇塞的', '2022-09-09 17:14:14', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL, '0', '49aead4b2e26458aa5375ec154ed2671');
INSERT INTO `tbl_activity_remark` VALUES ('825a1eb7376c484ab772bc6f687556f3', '是的', '2022-11-25 11:37:54', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL, '0', '205d8b9bfb4146e484b8e5a1f30e0a49');
INSERT INTO `tbl_activity_remark` VALUES ('cea67451ff194a93b157f19e7ca68692', 'www', '2022-09-10 01:06:31', '40f6cdea0bd34aceb77492a1656d9fb3', NULL, NULL, '0', '205d8b9bfb4146e484b8e5a1f30e0a49');
INSERT INTO `tbl_activity_remark` VALUES ('eafafd387f104b5fa15204eb8ef65f3c', '111122222', '2022-09-10 00:58:54', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-09-10 01:15:49', '40f6cdea0bd34aceb77492a1656d9fb3', '1', 'da805ef6aca544e0854bc63df334b158');
INSERT INTO `tbl_activity_remark` VALUES ('ebbae1ad8bee44bca074f7fe776469c7', '1000133轻微的q', '2022-09-09 01:39:56', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-09-12 17:33:20', '40f6cdea0bd34aceb77492a1656d9fb3', '1', '44fbe4245db54188b18ce811888d5d62');

-- ----------------------------
-- Table structure for tbl_clue
-- ----------------------------
DROP TABLE IF EXISTS `tbl_clue`;
CREATE TABLE `tbl_clue`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `fullname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `appellation` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `owner` char(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `company` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `job` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `website` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `mphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `source` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_time` char(19) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `contact_summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `next_contact_time` char(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_clue
-- ----------------------------
INSERT INTO `tbl_clue` VALUES ('35b5f2345cf7434392bea94e883c37f9', '张三', '59795c49896947e1ab61b7312bd0597c', '06f5fc056eac41558a964f96daa7f27c', '动力字节', 'CEO', 'zhangsan@bjpowernode.com', '010-84846003', 'http://www.bjpowernode.com', '12345678901', '1e0bd307e6ee425599327447f8387285', 'ff802a03ccea4ded8731427055681d48', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-16 18:11:49', NULL, NULL, 'hdbha', '三等奖吧', '2017-05-30', '无');
INSERT INTO `tbl_clue` VALUES ('e2faa9bdd77749f68faaf586c945f555', '小米', 'e5f383d2622b4fc0959f4fe131dafc80', '40f6cdea0bd34aceb77492a1656d9fb3', '字节跳动', 'CEO', 'xiaomi@bjnode.com', '030-84846000', 'http://www.bjnode.com', '12345678909', '06e3cbdf10a44eca8511dddfc6896c55', '3a39605d67da48f2a3ef52e19d243953', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-20 15:51:08', NULL, NULL, '无', '无', '2018-09-01', '呜呜呜');

-- ----------------------------
-- Table structure for tbl_clue_activity_relation
-- ----------------------------
DROP TABLE IF EXISTS `tbl_clue_activity_relation`;
CREATE TABLE `tbl_clue_activity_relation`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `clue_id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `activity_id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_clue_activity_relation
-- ----------------------------
INSERT INTO `tbl_clue_activity_relation` VALUES ('2f31d31380e64d928afbf22efd16d71a', 'e2faa9bdd77749f68faaf586c945f555', '0f3560c949c244cdbec5ce02e08bc7a1');
INSERT INTO `tbl_clue_activity_relation` VALUES ('6d0f701e9dfb4ced9221de07dfce6fb0', '35b5f2345cf7434392bea94e883c37f9', '0f3560c949c244cdbec5ce02e08bc7a1');

-- ----------------------------
-- Table structure for tbl_clue_remark
-- ----------------------------
DROP TABLE IF EXISTS `tbl_clue_remark`;
CREATE TABLE `tbl_clue_remark`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `note_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_time` char(19) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_flag` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `clue_id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_clue_remark
-- ----------------------------
INSERT INTO `tbl_clue_remark` VALUES ('1f462a9e0e9f4475856e3338f91126db', '新的', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-20 21:15:16', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-20 21:37:44', '1', 'e2faa9bdd77749f68faaf586c945f555');
INSERT INTO `tbl_clue_remark` VALUES ('224e2a98f7054e41853fd81c8e409595', '不是的', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-20 21:19:29', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-20 21:29:21', '1', 'e2faa9bdd77749f68faaf586c945f555');
INSERT INTO `tbl_clue_remark` VALUES ('6a741a706fdd4b54a8dea7c652da701d', '是', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-22 15:07:22', NULL, NULL, '0', '35b5f2345cf7434392bea94e883c37f9');
INSERT INTO `tbl_clue_remark` VALUES ('6bedb9f1348a48c4bcc5c7cb6c1bca5d', '风纪扣', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-20 21:29:09', NULL, NULL, '0', 'e2faa9bdd77749f68faaf586c945f555');
INSERT INTO `tbl_clue_remark` VALUES ('aafd3d8167954d19a10e8167b17f6e62', '活动举办', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-20 19:20:33', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-20 21:32:18', '1', 'e2faa9bdd77749f68faaf586c945f555');

-- ----------------------------
-- Table structure for tbl_contacts
-- ----------------------------
DROP TABLE IF EXISTS `tbl_contacts`;
CREATE TABLE `tbl_contacts`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `owner` char(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `source` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `customer_id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `fullname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `appellation` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `mphone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `job` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_time` char(19) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `contact_summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `next_contact_time` char(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_contacts
-- ----------------------------
INSERT INTO `tbl_contacts` VALUES ('0cfa56a322aa45f680af07b90a1dc595', '40f6cdea0bd34aceb77492a1656d9fb3', '4d03a42898684135809d380597ed3268', 'd24ec2507a334b60bfc94838131ec8be', '赵六', '59795c49896947e1ab61b7312bd0597c', 'zhaoliu@bjpowernode.com', '12345678909', 'CTO', '40f6cdea0bd34aceb77492a1656d9fb3', '2023-04-05 23:24:03', NULL, NULL, '', '', '2023-04-14', '');
INSERT INTO `tbl_contacts` VALUES ('106897b8b1ed44ab89d88c1eed5b9b31', '40f6cdea0bd34aceb77492a1656d9fb3', '72f13af8f5d34134b5b3f42c5d477510', '9ce96b27a4b04aed9616b3c87117d102', '林捷', 'e5f383d2622b4fc0959f4fe131dafc80', 'linjie@nuesoftwjj.com', '12345678949', '总监', '40f6cdea0bd34aceb77492a1656d9fb3', '2023-04-05 23:21:19', NULL, NULL, '测试02', '杰杰科技测试02', '2022-12-03', '广东东软集团');
INSERT INTO `tbl_contacts` VALUES ('4deaafadcb744249971ef8e88cdaf6ed', '40f6cdea0bd34aceb77492a1656d9fb3', '12302fd42bd349c1bb768b19600e6b20', '8141691ed56c4a2a8cea9b08dc6f0af0', '吴捷', '59795c49896947e1ab61b7312bd0597c', 'wjjnzn@nuesoftwjj.com', '12345678945', 'CEO', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-22 15:01:20', NULL, NULL, '测试04', '这是用来测试的', '2022-12-01', '广东东软集团');
INSERT INTO `tbl_contacts` VALUES ('899308bc5a194dc8b184dafdcb9b92bc', '40f6cdea0bd34aceb77492a1656d9fb3', '6b86f215e69f4dbd8a2daa22efccf0cf', '48a60ab183e040a49b12334f1e563a8c', '李四', '59795c49896947e1ab61b7312bd0597c', 'lisi@bjpowernode.com', '12345678905', 'CTO', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-21 23:46:47', NULL, NULL, '第二次', '注意细节', '2018-09-01', '无');
INSERT INTO `tbl_contacts` VALUES ('d71940faea98492ba0a5b842e5a8ef68', '40f6cdea0bd34aceb77492a1656d9fb3', '48512bfed26145d4a38d3616e2d2cf79', '65c16e0476f545e8b68360d9b297f845', '李四', '59795c49896947e1ab61b7312bd0597c', 'lisi@bjpowernode.com', '12345678901', 'CTO', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-09-17 18:31:24', NULL, NULL, '这是一条线索的描述信息', '这条线索即将被转换', '2017-05-01', '北京大兴大族企业湾');

-- ----------------------------
-- Table structure for tbl_contacts_activity_relation
-- ----------------------------
DROP TABLE IF EXISTS `tbl_contacts_activity_relation`;
CREATE TABLE `tbl_contacts_activity_relation`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `contacts_id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `activity_id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_contacts_activity_relation
-- ----------------------------
INSERT INTO `tbl_contacts_activity_relation` VALUES ('19792e4476db460aab0b7d6170a29a5f', '899308bc5a194dc8b184dafdcb9b92bc', '0f3560c949c244cdbec5ce02e08bc7a1');
INSERT INTO `tbl_contacts_activity_relation` VALUES ('3a81896f8baa4d289a19bede37657aaa', 'd71940faea98492ba0a5b842e5a8ef68', '49aead4b2e26458aa5375ec154ed2671');
INSERT INTO `tbl_contacts_activity_relation` VALUES ('587f3a0782ab4aa0a01274457ee39a99', '899308bc5a194dc8b184dafdcb9b92bc', '205d8b9bfb4146e484b8e5a1f30e0a49');
INSERT INTO `tbl_contacts_activity_relation` VALUES ('65247b0ff5f440c8abac32230c862016', '0cfa56a322aa45f680af07b90a1dc595', '49aead4b2e26458aa5375ec154ed2671');
INSERT INTO `tbl_contacts_activity_relation` VALUES ('9bce2faa3900481cb217df26c0e1f8ad', '106897b8b1ed44ab89d88c1eed5b9b31', '0f3560c949c244cdbec5ce02e08bc7a1');
INSERT INTO `tbl_contacts_activity_relation` VALUES ('be6d95d076644c92859725d94eebae3c', '4deaafadcb744249971ef8e88cdaf6ed', '0f3560c949c244cdbec5ce02e08bc7a1');
INSERT INTO `tbl_contacts_activity_relation` VALUES ('d5d675faa7fd44f8b43079aa27c111df', 'd71940faea98492ba0a5b842e5a8ef68', '0f3560c949c244cdbec5ce02e08bc7a1');
INSERT INTO `tbl_contacts_activity_relation` VALUES ('e0aabc51071b4f348bf8b727536520c5', 'd71940faea98492ba0a5b842e5a8ef68', '205d8b9bfb4146e484b8e5a1f30e0a49');
INSERT INTO `tbl_contacts_activity_relation` VALUES ('e81f67662e8e4b3fa5cad3006b11bd8c', '4deaafadcb744249971ef8e88cdaf6ed', '49aead4b2e26458aa5375ec154ed2671');
INSERT INTO `tbl_contacts_activity_relation` VALUES ('f0580d9f6f0e43bdafa36ec542a75c80', '106897b8b1ed44ab89d88c1eed5b9b31', '4127a024995c41fdb6be3b23b0b524c2');
INSERT INTO `tbl_contacts_activity_relation` VALUES ('f3ea63bc54774f23a65c587a6af577ef', '0cfa56a322aa45f680af07b90a1dc595', '205d8b9bfb4146e484b8e5a1f30e0a49');

-- ----------------------------
-- Table structure for tbl_contacts_remark
-- ----------------------------
DROP TABLE IF EXISTS `tbl_contacts_remark`;
CREATE TABLE `tbl_contacts_remark`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `note_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_time` char(19) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_flag` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `contacts_id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_contacts_remark
-- ----------------------------
INSERT INTO `tbl_contacts_remark` VALUES ('06e2e162464846f698b90798f8e61545', '正确的', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-22 15:00:26', NULL, NULL, '0', '4deaafadcb744249971ef8e88cdaf6ed');
INSERT INTO `tbl_contacts_remark` VALUES ('473dacfe74b24137863c25bdb9c70d27', '可交易', '40f6cdea0bd34aceb77492a1656d9fb3', '2023-04-05 23:23:14', '40f6cdea0bd34aceb77492a1656d9fb3', '2023-04-05 23:23:20', '1', '0cfa56a322aa45f680af07b90a1dc595');
INSERT INTO `tbl_contacts_remark` VALUES ('4bf057f2c9424a68a8e4711ce61cb46e', '是的+1', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-22 15:06:46', '40f6cdea0bd34aceb77492a1656d9fb3', '2023-04-05 23:20:39', '1', '106897b8b1ed44ab89d88c1eed5b9b31');
INSERT INTO `tbl_contacts_remark` VALUES ('5f3cca42d10a4e5da89cf9bbedb1a12b', '转换', '40f6cdea0bd34aceb77492a1656d9fb3', '2023-04-05 23:23:08', NULL, NULL, '0', '0cfa56a322aa45f680af07b90a1dc595');
INSERT INTO `tbl_contacts_remark` VALUES ('8629bf1e16354f67bab2d6e8f02d79f4', '对的,放大', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-22 15:06:52', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-29 22:20:20', '1', '106897b8b1ed44ab89d88c1eed5b9b31');
INSERT INTO `tbl_contacts_remark` VALUES ('8ca2f2bd31494f1b8ae5e1f7bab980eb', '测试', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-22 15:00:19', NULL, NULL, '0', '4deaafadcb744249971ef8e88cdaf6ed');
INSERT INTO `tbl_contacts_remark` VALUES ('c5f0d464c11e4a11ab05ff4d9ebb33f8', '哎哟!', '40f6cdea0bd34aceb77492a1656d9fb3', '2017-01-22 10:10:10', NULL, NULL, '0', 'd71940faea98492ba0a5b842e5a8ef68');

-- ----------------------------
-- Table structure for tbl_customer
-- ----------------------------
DROP TABLE IF EXISTS `tbl_customer`;
CREATE TABLE `tbl_customer`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `owner` char(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `website` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_time` char(19) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `contact_summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `next_contact_time` char(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_customer
-- ----------------------------
INSERT INTO `tbl_customer` VALUES ('48a60ab183e040a49b12334f1e563a8c', '40f6cdea0bd34aceb77492a1656d9fb3', '动力节点', 'http://www.bjpowernode.com', '010-84846003', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-21 23:46:47', NULL, NULL, '注意细节', '2018-09-01', '第二次', '无');
INSERT INTO `tbl_customer` VALUES ('65c16e0476f545e8b68360d9b297f845', '40f6cdea0bd34aceb77492a1656d9fb3', '动力字节', 'http://www.bjpowernode.com', '010-84846003', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-09-17 18:31:24', NULL, NULL, '这条线索即将被转换', '2017-05-01', '这是一条线索的描述信息', '北京大兴大族企业湾');
INSERT INTO `tbl_customer` VALUES ('6815b40eb51b48e198bc409ac61cb4de', '40f6cdea0bd34aceb77492a1656d9fb3', '京东科技', NULL, NULL, '40f6cdea0bd34aceb77492a1656d9fb3', '2022-09-18 21:44:19', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_customer` VALUES ('8141691ed56c4a2a8cea9b08dc6f0af0', '40f6cdea0bd34aceb77492a1656d9fb3', '杰杰科技', 'https://www.nuesoftwjj.com', '010-84844009', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-22 15:01:20', NULL, NULL, '这是用来测试的', '2022-12-01', '测试04', '广东东软集团');
INSERT INTO `tbl_customer` VALUES ('9ce96b27a4b04aed9616b3c87117d102', '40f6cdea0bd34aceb77492a1656d9fb3', '杰杰科技', 'https://www.nuesoftwjj.com', '010-84844009', '40f6cdea0bd34aceb77492a1656d9fb3', '2023-04-05 23:21:19', NULL, NULL, '杰杰科技测试02', '2022-12-03', '测试02', '广东东软集团');
INSERT INTO `tbl_customer` VALUES ('d24ec2507a334b60bfc94838131ec8be', '40f6cdea0bd34aceb77492a1656d9fb3', '杰杰科技', 'http://www.bjpowernode.com', '010-84846002', '40f6cdea0bd34aceb77492a1656d9fb3', '2023-04-05 23:24:03', NULL, NULL, '', '2023-04-14', '', '');

-- ----------------------------
-- Table structure for tbl_customer_remark
-- ----------------------------
DROP TABLE IF EXISTS `tbl_customer_remark`;
CREATE TABLE `tbl_customer_remark`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `note_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_time` char(19) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_flag` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `customer_id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_customer_remark
-- ----------------------------
INSERT INTO `tbl_customer_remark` VALUES ('2bf2c5dd08a345d887374c918983472b', '测试', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-22 15:00:19', NULL, NULL, '0', '8141691ed56c4a2a8cea9b08dc6f0af0');
INSERT INTO `tbl_customer_remark` VALUES ('414eb4b8e80f41ad81d0f8fb5481a472', '是的+1', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-22 15:06:46', '40f6cdea0bd34aceb77492a1656d9fb3', '2023-04-05 23:20:39', '1', '9ce96b27a4b04aed9616b3c87117d102');
INSERT INTO `tbl_customer_remark` VALUES ('b19967776cbe4d57bf001115ae469520', '对的,放大', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-22 15:06:52', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-29 22:20:20', '1', '9ce96b27a4b04aed9616b3c87117d102');
INSERT INTO `tbl_customer_remark` VALUES ('c7c7cb4030d44589aab1cd4e0868fc1b', '正确的', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-22 15:00:26', NULL, NULL, '0', '8141691ed56c4a2a8cea9b08dc6f0af0');
INSERT INTO `tbl_customer_remark` VALUES ('d055333d0536444d9d748815990bab89', '哎哟!', '40f6cdea0bd34aceb77492a1656d9fb3', '2017-01-22 10:10:10', NULL, NULL, '0', '65c16e0476f545e8b68360d9b297f845');
INSERT INTO `tbl_customer_remark` VALUES ('f0b6f8459f734239bfcfd986ccfd4622', '转换', '40f6cdea0bd34aceb77492a1656d9fb3', '2023-04-05 23:23:08', NULL, NULL, '0', 'd24ec2507a334b60bfc94838131ec8be');
INSERT INTO `tbl_customer_remark` VALUES ('f9aa0ec212a541aa81c906a405b22740', '可交易', '40f6cdea0bd34aceb77492a1656d9fb3', '2023-04-05 23:23:14', '40f6cdea0bd34aceb77492a1656d9fb3', '2023-04-05 23:23:20', '1', 'd24ec2507a334b60bfc94838131ec8be');

-- ----------------------------
-- Table structure for tbl_dic_type
-- ----------------------------
DROP TABLE IF EXISTS `tbl_dic_type`;
CREATE TABLE `tbl_dic_type`  (
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '????????????????Ϊ?գ????ܺ??????ġ?',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_dic_type
-- ----------------------------
INSERT INTO `tbl_dic_type` VALUES ('appellation', '称呼', '老板、先生、女士');
INSERT INTO `tbl_dic_type` VALUES ('clueState', '线索状态', '联系、未联系');
INSERT INTO `tbl_dic_type` VALUES ('returnPriority', '回访优先级', '分三个等级');
INSERT INTO `tbl_dic_type` VALUES ('returnState', '回访状态', '');
INSERT INTO `tbl_dic_type` VALUES ('sex', '性别', '男 or 女');
INSERT INTO `tbl_dic_type` VALUES ('source', '来源', '');
INSERT INTO `tbl_dic_type` VALUES ('stage', '阶段', '');
INSERT INTO `tbl_dic_type` VALUES ('transactionType', '交易类型', '');

-- ----------------------------
-- Table structure for tbl_dic_value
-- ----------------------------
DROP TABLE IF EXISTS `tbl_dic_value`;
CREATE TABLE `tbl_dic_value`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '??????????UUID',
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '????Ϊ?գ?????Ҫ??ͬһ???ֵ????????ֵ?ֵ?????ظ???????Ψһ?ԡ?',
  `text` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '????Ϊ?',
  `order_no` int(0) NULL DEFAULT NULL COMMENT '????Ϊ?գ?????Ϊ?յ?ʱ????Ҫ???????????',
  `type_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '???',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_dic_value
-- ----------------------------
INSERT INTO `tbl_dic_value` VALUES ('06e3cbdf10a44eca8511dddfc6896c55', '虚假线索', '虚假线索', 4, 'clueState');
INSERT INTO `tbl_dic_value` VALUES ('0fe33840c6d84bf78df55d49b169a894', '销售邮件', '销售邮件', 8, 'source');
INSERT INTO `tbl_dic_value` VALUES ('12302fd42bd349c1bb768b19600e6b20', '交易会', '交易会', 11, 'source');
INSERT INTO `tbl_dic_value` VALUES ('1615f0bb3e604552a86cde9a2ad45bea', '最高', '最高', 2, 'returnPriority');
INSERT INTO `tbl_dic_value` VALUES ('176039d2a90e4b1a81c5ab8707268636', '教授', '教授', 5, 'appellation');
INSERT INTO `tbl_dic_value` VALUES ('1e0bd307e6ee425599327447f8387285', '将来联系', '将来联系', 2, 'clueState');
INSERT INTO `tbl_dic_value` VALUES ('2173663b40b949ce928db92607b5fe57', '丢失线索', '丢失线索', 5, 'clueState');
INSERT INTO `tbl_dic_value` VALUES ('2876690b7e744333b7f1867102f91153', '未启动', '未启动', 1, 'returnState');
INSERT INTO `tbl_dic_value` VALUES ('29805c804dd94974b568cfc9017b2e4c', '成交', '成交', 7, 'stage');
INSERT INTO `tbl_dic_value` VALUES ('310e6a49bd8a4962b3f95a1d92eb76f4', '试图联系', '试图联系', 1, 'clueState');
INSERT INTO `tbl_dic_value` VALUES ('31539e7ed8c848fc913e1c2c93d76fd1', '博士', '博士', 4, 'appellation');
INSERT INTO `tbl_dic_value` VALUES ('37ef211719134b009e10b7108194cf46', '资质审查', '资质审查', 1, 'stage');
INSERT INTO `tbl_dic_value` VALUES ('391807b5324d4f16bd58c882750ee632', '丢失的线索', '丢失的线索', 8, 'stage');
INSERT INTO `tbl_dic_value` VALUES ('3a39605d67da48f2a3ef52e19d243953', '聊天', '聊天', 14, 'source');
INSERT INTO `tbl_dic_value` VALUES ('474ab93e2e114816abf3ffc596b19131', '低', '低', 3, 'returnPriority');
INSERT INTO `tbl_dic_value` VALUES ('48512bfed26145d4a38d3616e2d2cf79', '广告', '广告', 1, 'source');
INSERT INTO `tbl_dic_value` VALUES ('4d03a42898684135809d380597ed3268', '合作伙伴研讨会', '合作伙伴研讨会', 9, 'source');
INSERT INTO `tbl_dic_value` VALUES ('59795c49896947e1ab61b7312bd0597c', '先生', '先生', 1, 'appellation');
INSERT INTO `tbl_dic_value` VALUES ('5c6e9e10ca414bd499c07b886f86202a', '高', '高', 1, 'returnPriority');
INSERT INTO `tbl_dic_value` VALUES ('67165c27076e4c8599f42de57850e39c', '夫人', '夫人', 2, 'appellation');
INSERT INTO `tbl_dic_value` VALUES ('68a1b1e814d5497a999b8f1298ace62b', '因竞争丢失关闭', '因竞争丢失关闭', 9, 'stage');
INSERT INTO `tbl_dic_value` VALUES ('6b86f215e69f4dbd8a2daa22efccf0cf', 'web调研', 'web调研', 13, 'source');
INSERT INTO `tbl_dic_value` VALUES ('72f13af8f5d34134b5b3f42c5d477510', '合作伙伴', '合作伙伴', 6, 'source');
INSERT INTO `tbl_dic_value` VALUES ('7c07db3146794c60bf975749952176df', '未联系', '未联系', 6, 'clueState');
INSERT INTO `tbl_dic_value` VALUES ('86c56aca9eef49058145ec20d5466c17', '内部研讨会', '内部研讨会', 10, 'source');
INSERT INTO `tbl_dic_value` VALUES ('9095bda1f9c34f098d5b92fb870eba17', '进行中', '进行中', 3, 'returnState');
INSERT INTO `tbl_dic_value` VALUES ('954b410341e7433faa468d3c4f7cf0d2', '已有业务', '已有业务', 1, 'transactionType');
INSERT INTO `tbl_dic_value` VALUES ('966170ead6fa481284b7d21f90364984', '已联系', '已联系', 3, 'clueState');
INSERT INTO `tbl_dic_value` VALUES ('96b03f65dec748caa3f0b6284b19ef2f', '推迟', '推迟', 2, 'returnState');
INSERT INTO `tbl_dic_value` VALUES ('97d1128f70294f0aac49e996ced28c8a', '新业务', '新业务', 2, 'transactionType');
INSERT INTO `tbl_dic_value` VALUES ('9ca96290352c40688de6596596565c12', '完成', '完成', 4, 'returnState');
INSERT INTO `tbl_dic_value` VALUES ('9e6d6e15232549af853e22e703f3e015', '需要条件', '需要条件', 7, 'clueState');
INSERT INTO `tbl_dic_value` VALUES ('9ff57750fac04f15b10ce1bbb5bb8bab', '需求分析', '需求分析', 2, 'stage');
INSERT INTO `tbl_dic_value` VALUES ('a70dc4b4523040c696f4421462be8b2f', '等待某人', '等待某人', 5, 'returnState');
INSERT INTO `tbl_dic_value` VALUES ('a83e75ced129421dbf11fab1f05cf8b4', '推销电话', '推销电话', 2, 'source');
INSERT INTO `tbl_dic_value` VALUES ('ab8472aab5de4ae9b388b2f1409441c1', '常规', '常规', 5, 'returnPriority');
INSERT INTO `tbl_dic_value` VALUES ('ab8c2a3dc05f4e3dbc7a0405f721b040', '提案/报价', '提案/报价', 5, 'stage');
INSERT INTO `tbl_dic_value` VALUES ('b924d911426f4bc5ae3876038bc7e0ad', 'web下载', 'web下载', 12, 'source');
INSERT INTO `tbl_dic_value` VALUES ('c13ad8f9e2f74d5aa84697bb243be3bb', '价值建议', '价值建议', 3, 'stage');
INSERT INTO `tbl_dic_value` VALUES ('c83c0be184bc40708fd7b361b6f36345', '最低', '最低', 4, 'returnPriority');
INSERT INTO `tbl_dic_value` VALUES ('db867ea866bc44678ac20c8a4a8bfefb', '员工介绍', '员工介绍', 3, 'source');
INSERT INTO `tbl_dic_value` VALUES ('e44be1d99158476e8e44778ed36f4355', '确定决策者', '确定决策者', 4, 'stage');
INSERT INTO `tbl_dic_value` VALUES ('e5f383d2622b4fc0959f4fe131dafc80', '女士', '女士', 3, 'appellation');
INSERT INTO `tbl_dic_value` VALUES ('e81577d9458f4e4192a44650a3a3692b', '谈判/复审', '谈判/复审', 6, 'stage');
INSERT INTO `tbl_dic_value` VALUES ('fb65d7fdb9c6483db02713e6bc05dd19', '在线商场', '在线商场', 5, 'source');
INSERT INTO `tbl_dic_value` VALUES ('fd677cc3b5d047d994e16f6ece4d3d45', '公开媒介', '公开媒介', 7, 'source');
INSERT INTO `tbl_dic_value` VALUES ('ff802a03ccea4ded8731427055681d48', '外部介绍', '外部介绍', 4, 'source');

-- ----------------------------
-- Table structure for tbl_tran
-- ----------------------------
DROP TABLE IF EXISTS `tbl_tran`;
CREATE TABLE `tbl_tran`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `owner` char(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `money` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `expected_date` char(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `customer_id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `stage` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `source` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `activity_id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `contacts_id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_time` char(19) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `contact_summary` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `next_contact_time` char(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_tran
-- ----------------------------
INSERT INTO `tbl_tran` VALUES ('3bcc0084e0d44c83a6c9fa4008d4d301', '06f5fc056eac41558a964f96daa7f27c', '3000', '京东-交易测试', '2022-09-23', '6815b40eb51b48e198bc409ac61cb4de', '37ef211719134b009e10b7108194cf46', '97d1128f70294f0aac49e996ced28c8a', '48512bfed26145d4a38d3616e2d2cf79', '0f3560c949c244cdbec5ce02e08bc7a1', 'd71940faea98492ba0a5b842e5a8ef68', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-09-18 21:44:19', NULL, NULL, '测试', '测试', '2022-10-01');
INSERT INTO `tbl_tran` VALUES ('6f42497b1ffd4f269990d0af83e44f3f', '40f6cdea0bd34aceb77492a1656d9fb3', '8998', '小七-交易测试', '2022-12-10', '48a60ab183e040a49b12334f1e563a8c', '68a1b1e814d5497a999b8f1298ace62b', '97d1128f70294f0aac49e996ced28c8a', '0fe33840c6d84bf78df55d49b169a894', '49aead4b2e26458aa5375ec154ed2671', '4deaafadcb744249971ef8e88cdaf6ed', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-22 22:48:56', NULL, NULL, '测试地方', '胡说八道举报', '2022-11-25');
INSERT INTO `tbl_tran` VALUES ('723cd34ea38c4fc0ba6309d99538c925', '06f5fc056eac41558a964f96daa7f27c', '20000', '动力节点-交易测试01', '2022-09-19', '65c16e0476f545e8b68360d9b297f845', '29805c804dd94974b568cfc9017b2e4c', '954b410341e7433faa468d3c4f7cf0d2', '86c56aca9eef49058145ec20d5466c17', '0f3560c949c244cdbec5ce02e08bc7a1', 'd71940faea98492ba0a5b842e5a8ef68', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-09-18 21:24:47', NULL, NULL, '测试', '测试', '2023-05-01');
INSERT INTO `tbl_tran` VALUES ('96d1012f2c324ebfa5c03be9cb2e46f8', '06f5fc056eac41558a964f96daa7f27c', '2000', '皮蛋测试', '2023-01-26', '8141691ed56c4a2a8cea9b08dc6f0af0', 'c13ad8f9e2f74d5aa84697bb243be3bb', '954b410341e7433faa468d3c4f7cf0d2', 'fb65d7fdb9c6483db02713e6bc05dd19', 'd1512c5a7b394079b477f2cbec52ec50', '4deaafadcb744249971ef8e88cdaf6ed', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-22 22:44:57', NULL, NULL, '测试', '极大的可能', '2022-12-01');
INSERT INTO `tbl_tran` VALUES ('baa5acea219d42ebbb4f795bf1611539', '40f6cdea0bd34aceb77492a1656d9fb3', '6000', '动力字节-交易测试01', '2022-01-19', '65c16e0476f545e8b68360d9b297f845', '29805c804dd94974b568cfc9017b2e4c', '97d1128f70294f0aac49e996ced28c8a', '48512bfed26145d4a38d3616e2d2cf79', '0f3560c949c244cdbec5ce02e08bc7a1', 'd71940faea98492ba0a5b842e5a8ef68', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-09-17 18:31:24', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `tbl_tran` VALUES ('c854773efb654fc69fb9bdda9a847ddf', '40f6cdea0bd34aceb77492a1656d9fb3', '90000', '杰杰科技-测试01', '2022-12-08', '8141691ed56c4a2a8cea9b08dc6f0af0', 'e44be1d99158476e8e44778ed36f4355', '97d1128f70294f0aac49e996ced28c8a', '12302fd42bd349c1bb768b19600e6b20', '49aead4b2e26458aa5375ec154ed2671', '4deaafadcb744249971ef8e88cdaf6ed', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-22 15:01:20', NULL, NULL, '测试04', '这是用来测试的', '2022-12-01');
INSERT INTO `tbl_tran` VALUES ('f2a51d0ca9354f3caa08eeffc28002b2', '40f6cdea0bd34aceb77492a1656d9fb3', '100000', '杰杰科技-测试03', '2023-04-10', 'd24ec2507a334b60bfc94838131ec8be', 'ab8c2a3dc05f4e3dbc7a0405f721b040', '97d1128f70294f0aac49e996ced28c8a', '4d03a42898684135809d380597ed3268', '205d8b9bfb4146e484b8e5a1f30e0a49', '0cfa56a322aa45f680af07b90a1dc595', '40f6cdea0bd34aceb77492a1656d9fb3', '2023-04-05 23:24:03', NULL, NULL, '', '', '2023-04-14');
INSERT INTO `tbl_tran` VALUES ('fe5475df38ac4054807b7e5f821dc264', '40f6cdea0bd34aceb77492a1656d9fb3', '8000', '动力节点-测试04', '2022-11-21', '48a60ab183e040a49b12334f1e563a8c', 'e81577d9458f4e4192a44650a3a3692b', '97d1128f70294f0aac49e996ced28c8a', '6b86f215e69f4dbd8a2daa22efccf0cf', '205d8b9bfb4146e484b8e5a1f30e0a49', '899308bc5a194dc8b184dafdcb9b92bc', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-21 23:46:47', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for tbl_tran_history
-- ----------------------------
DROP TABLE IF EXISTS `tbl_tran_history`;
CREATE TABLE `tbl_tran_history`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `stage` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `money` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `expected_date` char(10) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tran_id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_tran_history
-- ----------------------------
INSERT INTO `tbl_tran_history` VALUES ('2eba3a7b51e24d7f8e29d2cda158fd05', '68a1b1e814d5497a999b8f1298ace62b', '8998', '2022-12-10', '2022-11-22 22:48:56', '40f6cdea0bd34aceb77492a1656d9fb3', '6f42497b1ffd4f269990d0af83e44f3f');
INSERT INTO `tbl_tran_history` VALUES ('c80e99ff4f7c41b4b9040ea11e6abf73', 'c13ad8f9e2f74d5aa84697bb243be3bb', '2000', '2023-01-26', '2022-11-22 22:44:57', '40f6cdea0bd34aceb77492a1656d9fb3', '96d1012f2c324ebfa5c03be9cb2e46f8');
INSERT INTO `tbl_tran_history` VALUES ('f2359217fe0542b9950264b654a7810d', '37ef211719134b009e10b7108194cf46', '3000', '2022-09-23', '2022-09-18 21:44:19', '40f6cdea0bd34aceb77492a1656d9fb3', '3bcc0084e0d44c83a6c9fa4008d4d301');

-- ----------------------------
-- Table structure for tbl_tran_remark
-- ----------------------------
DROP TABLE IF EXISTS `tbl_tran_remark`;
CREATE TABLE `tbl_tran_remark`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `note_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `create_time` char(19) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_time` char(19) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `edit_flag` char(1) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `tran_id` char(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_tran_remark
-- ----------------------------
INSERT INTO `tbl_tran_remark` VALUES ('5a466c5f7d364ffd8c24d14ac4989b54', '正确的', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-22 15:00:26', NULL, NULL, '0', 'c854773efb654fc69fb9bdda9a847ddf');
INSERT INTO `tbl_tran_remark` VALUES ('69722e3949d44b10ae472cbbc4f3a3ba', '哎哟!', '40f6cdea0bd34aceb77492a1656d9fb3', '2017-01-22 10:10:10', NULL, NULL, '0', 'baa5acea219d42ebbb4f795bf1611539');
INSERT INTO `tbl_tran_remark` VALUES ('983648f464ed4266ade2d31691d112e5', '转换', '40f6cdea0bd34aceb77492a1656d9fb3', '2023-04-05 23:23:08', NULL, NULL, '0', 'f2a51d0ca9354f3caa08eeffc28002b2');
INSERT INTO `tbl_tran_remark` VALUES ('ad20637837994c94afbfb499d4cdb184', '可交易', '40f6cdea0bd34aceb77492a1656d9fb3', '2023-04-05 23:23:14', '40f6cdea0bd34aceb77492a1656d9fb3', '2023-04-05 23:23:20', '1', 'f2a51d0ca9354f3caa08eeffc28002b2');
INSERT INTO `tbl_tran_remark` VALUES ('b36b7131d0bb445ab5c4344e0333b390', '测试', '40f6cdea0bd34aceb77492a1656d9fb3', '2022-11-22 15:00:19', NULL, NULL, '0', 'c854773efb654fc69fb9bdda9a847ddf');

-- ----------------------------
-- Table structure for tbl_user
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user`  (
  `id` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'uuid\r\n            ',
  `login_act` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `login_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码不能采用明文存储，采用密文，MD5加密之后的数据',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `expire_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '失效时间为空的时候表示永不失效，失效时间为2018-10-10 10:10:10，则表示在该时间之前该账户可用。',
  `lock_state` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '锁定状态为空时表示启用，为0时表示锁定，为1时表示启用。',
  `deptno` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `allow_ips` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '允许访问的IP为空时表示IP地址永不受限，允许访问的IP可以是一个，也可以是多个，当多个IP地址的时候，采用半角逗号分隔。允许IP是192.168.100.2，表示该用户只能在IP地址为192.168.100.2的机器上使用。',
  `createTime` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_time` char(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `edit_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('06f5fc056eac41558a964f96daa7f27c', 'ls', '李四', 'yf123', 'ls@163.com', '2030-11-27 21:50:05', '1', 'A001', '192.168.1.1,0:0:0:0:0:0:0:1,192.168.184.140', '2018-11-22 12:11:40', '李四', NULL, NULL);
INSERT INTO `tbl_user` VALUES ('40f6cdea0bd34aceb77492a1656d9fb3', 'zs', '张三', 'yf123', 'zs@qq.com', '2023-11-30 23:50:55', '1', 'A001', '192.168.1.1,192.168.1.2,127.0.0.1,0:0:0:0:0:0:0:1', '2018-11-22 11:37:34', '张三', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
