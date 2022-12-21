/*
 Navicat MySQL Data Transfer

 Source Server         : ks
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : my_eshop

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 10/08/2021 19:35:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_info
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `admin_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员账号',
  `admin_pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员登录密码',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '管理员状态(1:正常，0:停用)',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin_info
-- ----------------------------
INSERT INTO `admin_info` VALUES (1, 'admin', '123', '1', '2021-06-02 18:08:53', '2021-06-11 16:15:04');
INSERT INTO `admin_info` VALUES (3, 'HSB', '123', '1', '2021-06-09 20:19:16', '2021-06-13 11:44:50');

-- ----------------------------
-- Table structure for function_menu
-- ----------------------------
DROP TABLE IF EXISTS `function_menu`;
CREATE TABLE `function_menu`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '系统功能id',
  `parent_id` int NOT NULL DEFAULT 0 COMMENT '父结点id',
  `fc_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '系统功能名称',
  `fc_url` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '功能页面或url',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '系统功能状态',
  `seq` int NULL DEFAULT NULL COMMENT '菜单顺序',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of function_menu
-- ----------------------------
INSERT INTO `function_menu` VALUES (1, 0, '商品管理', '', '1', 1, '2021-06-02 19:10:36', '2021-06-11 15:58:26');
INSERT INTO `function_menu` VALUES (2, 0, '订单管理', '', '1', 2, '2021-06-02 19:10:56', '2021-06-02 20:50:44');
INSERT INTO `function_menu` VALUES (3, 0, '客户管理', '', '1', 3, '2021-06-02 19:11:22', '2021-06-09 18:03:15');
INSERT INTO `function_menu` VALUES (4, 1, '商品列表', 'product_page', '1', NULL, '2021-06-02 19:12:24', '2021-06-13 10:48:37');
INSERT INTO `function_menu` VALUES (5, 1, '商品类型', 'productType_page', '1', NULL, '2021-06-02 19:12:49', '2021-06-05 16:17:22');
INSERT INTO `function_menu` VALUES (6, 2, '查询订单', 'orderInfo_page', '1', NULL, '2021-06-02 19:13:05', '2021-06-06 16:43:57');
INSERT INTO `function_menu` VALUES (7, 2, '创建订单', 'orderCreate_page', '1', NULL, '2021-06-02 19:13:20', '2021-06-09 19:06:29');
INSERT INTO `function_menu` VALUES (8, 3, '客户列表', 'user_page', '1', NULL, '2021-06-02 19:13:36', '2021-06-09 19:05:49');
INSERT INTO `function_menu` VALUES (9, 0, '管理员管理', '', '1', 4, '2021-06-02 19:58:24', '2021-06-09 19:42:59');
INSERT INTO `function_menu` VALUES (10, 9, '管理员列表', 'admin_page', '1', NULL, '2021-06-02 19:59:24', '2021-06-13 10:48:38');
INSERT INTO `function_menu` VALUES (11, 0, '菜单管理', '', '1', 5, '2021-06-02 20:43:26', '2021-06-09 19:07:17');
INSERT INTO `function_menu` VALUES (12, 11, '菜单列表', 'menu_page', '1', NULL, '2021-06-02 21:01:18', '2021-06-02 21:04:13');
INSERT INTO `function_menu` VALUES (16, 0, '数据监控', '', '1', 6, '2021-06-09 19:19:32', '2021-06-11 16:37:04');
INSERT INTO `function_menu` VALUES (17, 16, 'Druid界面', 'druid', '1', NULL, '2021-06-09 19:27:22', '2021-06-09 19:39:35');

-- ----------------------------
-- Table structure for order_detail
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '订单明细id',
  `oid` int NOT NULL COMMENT '订单信息id',
  `pid` int NOT NULL COMMENT '商品信息id',
  `num` int NOT NULL COMMENT '数量',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`, `oid`, `pid`) USING BTREE,
  INDEX `fk_oid`(`oid`) USING BTREE,
  INDEX `fk_pid`(`pid`) USING BTREE,
  CONSTRAINT `fk_oid` FOREIGN KEY (`oid`) REFERENCES `order_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pid` FOREIGN KEY (`pid`) REFERENCES `product_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO `order_detail` VALUES (14, 8, 12, 4, '2021-06-08 22:36:37', NULL);
INSERT INTO `order_detail` VALUES (15, 8, 22, 1, '2021-06-08 22:36:37', NULL);
INSERT INTO `order_detail` VALUES (16, 10, 1, 1, '2021-06-08 22:39:10', NULL);
INSERT INTO `order_detail` VALUES (17, 10, 3, 2, '2021-06-08 22:39:10', NULL);
INSERT INTO `order_detail` VALUES (18, 11, 8, 1, '2021-06-08 22:40:02', NULL);
INSERT INTO `order_detail` VALUES (19, 11, 10, 1, '2021-06-08 22:40:02', NULL);
INSERT INTO `order_detail` VALUES (20, 12, 22, 1, '2021-06-08 22:40:23', NULL);
INSERT INTO `order_detail` VALUES (21, 13, 20, 2, '2021-06-08 22:59:20', NULL);
INSERT INTO `order_detail` VALUES (22, 14, 10, 1, '2021-06-10 12:17:41', NULL);
INSERT INTO `order_detail` VALUES (23, 15, 4, 2, '2021-06-10 12:18:30', NULL);
INSERT INTO `order_detail` VALUES (24, 16, 8, 2, '2021-06-11 16:35:54', NULL);
INSERT INTO `order_detail` VALUES (25, 17, 4, 2, '2021-06-11 18:33:01', NULL);

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '订单信息id',
  `uid` int NOT NULL COMMENT '客户id',
  `order_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单编号',
  `order_price` decimal(8, 2) NOT NULL COMMENT '订单金额',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '订单状态',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`, `uid`) USING BTREE,
  INDEX `id`(`id`) USING BTREE,
  INDEX `fk_uid`(`uid`) USING BTREE,
  CONSTRAINT `fk_uid` FOREIGN KEY (`uid`) REFERENCES `user_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (8, 6, '1623162996762', 9135.00, '1', '2021-06-08 00:00:00', NULL);
INSERT INTO `order_info` VALUES (10, 1, '1623163150455', 15286.00, '0', '2021-06-08 00:00:00', NULL);
INSERT INTO `order_info` VALUES (11, 2, '1623163202242', 5898.00, '0', '2021-06-08 00:00:00', NULL);
INSERT INTO `order_info` VALUES (12, 4, '1623163223108', 2339.00, '0', '2021-06-08 00:00:00', NULL);
INSERT INTO `order_info` VALUES (13, 5, '1623164359963', 4678.00, '1', '2021-06-08 00:00:00', NULL);
INSERT INTO `order_info` VALUES (14, 4, '1623298660886', 2699.00, '0', '2021-06-10 00:00:00', NULL);
INSERT INTO `order_info` VALUES (15, 3, '1623298710682', 9598.00, '1', '2021-06-10 00:00:00', NULL);
INSERT INTO `order_info` VALUES (16, 6, '1623400554240', 6398.00, '1', '2021-06-11 00:00:00', NULL);
INSERT INTO `order_info` VALUES (17, 6, '1623407580622', 9598.00, '0', '2021-06-11 00:00:00', NULL);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `aid` int NOT NULL COMMENT '管理员id',
  `fid` int NOT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`, `aid`, `fid`) USING BTREE,
  INDEX `fk_aid`(`aid`) USING BTREE,
  INDEX `fk_fid`(`fid`) USING BTREE,
  CONSTRAINT `fk_aid` FOREIGN KEY (`aid`) REFERENCES `admin_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_fid` FOREIGN KEY (`fid`) REFERENCES `function_menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 139 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (126, 1, 1);
INSERT INTO `permission` VALUES (127, 1, 4);
INSERT INTO `permission` VALUES (128, 1, 5);
INSERT INTO `permission` VALUES (129, 1, 2);
INSERT INTO `permission` VALUES (130, 1, 6);
INSERT INTO `permission` VALUES (131, 1, 7);
INSERT INTO `permission` VALUES (132, 1, 3);
INSERT INTO `permission` VALUES (133, 1, 8);
INSERT INTO `permission` VALUES (134, 1, 9);
INSERT INTO `permission` VALUES (135, 1, 10);
INSERT INTO `permission` VALUES (136, 1, 11);
INSERT INTO `permission` VALUES (137, 1, 12);
INSERT INTO `permission` VALUES (138, 1, 16);
INSERT INTO `permission` VALUES (139, 1, 17);
INSERT INTO `permission` VALUES (116, 3, 1);
INSERT INTO `permission` VALUES (117, 3, 4);
INSERT INTO `permission` VALUES (118, 3, 5);
INSERT INTO `permission` VALUES (119, 3, 2);
INSERT INTO `permission` VALUES (120, 3, 6);
INSERT INTO `permission` VALUES (121, 3, 3);
INSERT INTO `permission` VALUES (122, 3, 8);

-- ----------------------------
-- Table structure for product_info
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '商品信息id',
  `pd_code` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品编号',
  `pd_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品名称',
  `tid` int NOT NULL COMMENT '商品类别id',
  `brand` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品品牌',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片url',
  `price` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品价格',
  `num` int NOT NULL COMMENT '商品数量',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品描述',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '商品状态',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`, `tid`) USING BTREE,
  INDEX `fk_tid`(`tid`) USING BTREE,
  INDEX `id`(`id`) USING BTREE,
  CONSTRAINT `fk_tid` FOREIGN KEY (`tid`) REFERENCES `product_type` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES (1, '1378538', 'AppleMJVE2CH/A', 1, 'APPLE', 'computer.jpg', '6488', 100, 'Apple MacBook Air 13.3英寸笔记本电脑 银色(Core i5 处理器/4GB内存/128GB SSD闪存 MJVE2CH/A)', '1', '2021-06-04 10:42:56', '2021-06-11 19:06:20');
INSERT INTO `product_info` VALUES (3, '1999938', '联想小新300经典版', 1, '联想（Lenovo）', 'computer.jpg', '4399', 20, '联想（Lenovo）小新300经典版 14英寸超薄笔记本电脑（i7-6500U 4G 500G 2G独显 全高清屏 Win10）黑色', '1', '2021-06-04 10:44:15', '2021-06-11 19:06:18');
INSERT INTO `product_info` VALUES (4, '1466274', '华硕FX50JX', 1, '华硕（ASUS）', 'computer.jpg', '4799', 100, '华硕（ASUS）飞行堡垒FX50J 15.6英寸游戏笔记本电脑（i5-4200H 4G 7200转500G GTX950M 2G独显 全高清）', '1', '2021-06-04 10:44:18', '2021-06-11 19:06:17');
INSERT INTO `product_info` VALUES (5, '1981672', '华硕FL5800', 1, '华硕（ASUS）', 'computer.jpg', '4999', 100, '华硕（ASUS）FL5800 15.6英寸笔记本电脑 （i7-5500U 4G 128G SSD+1TB 2G独显 蓝牙 Win10 黑色）', '1', '2021-06-04 10:44:21', '2021-06-11 19:06:15');
INSERT INTO `product_info` VALUES (6, '1904696', '联想G50-70M', 1, '联想（Lenovo）', 'computer.jpg', '3499', 12, '联想（Lenovo）G50-70M 15.6英寸笔记本电脑（i5-4210U 4G 500G GT820M 2G独显 DVD刻录 Win8.1）金属黑', '1', '2021-06-04 10:44:24', '2021-06-11 19:06:14');
INSERT INTO `product_info` VALUES (8, '977433', '美的BCD-516WKM(E)', 2, ' 美的（Midea）', 'computer.jpg', '3199', 100, '美的(Midea) BCD-516WKM(E) 516升 对开门冰箱 风冷无霜 电脑控温 纤薄设计 节能静音 （泰坦银）', '1', '2021-06-04 10:44:35', '2021-06-11 19:06:12');
INSERT INTO `product_info` VALUES (9, '1143562', '海尔BCD-216SDN', 2, ' 海尔（Haier）', 'computer.jpg', '1699', 100, '海尔（Haier）BCD-216SDN 216升 三门冰箱 电脑控温 中门 宽幅变温 大冷冻能力低能耗更省钱', '1', '2021-06-04 10:44:39', '2021-06-11 19:06:10');
INSERT INTO `product_info` VALUES (10, '1560207', '海尔BCD-258WDPM', 2, ' 海尔（Haier）', 'computer.jpg', '2699', 100, '海尔（Haier）BCD-258WDPM 258升 风冷无霜三门冰箱 除菌 3D立体环绕风不风干 中门5℃~-18℃变温室', '1', '2021-06-04 10:44:42', '2021-06-11 19:06:09');
INSERT INTO `product_info` VALUES (12, '823125', '海信BCD-211TD/E', 2, ' 海信（Hisense）', 'computer.jpg', '1699', 100, '海信（Hisense） BCD-211TD/E 211升 电脑三门冰箱 （亮金刚）', '1', '2021-06-04 10:44:50', '2021-06-11 19:06:08');
INSERT INTO `product_info` VALUES (16, '213444', '华硕电脑', 1, '华硕', 'computer.jpg', '4999', 100, '', '1', '2021-06-04 16:07:20', '2021-06-11 19:06:06');
INSERT INTO `product_info` VALUES (18, '213444', '联想电脑', 1, '联想', 'computer.jpg', '5999', 20, '', '1', '2021-06-04 16:50:26', '2021-06-11 19:06:05');
INSERT INTO `product_info` VALUES (19, '345323', '苹果电脑', 1, '苹果', 'computer.jpg', '8999', 25, '', '1', '2021-06-04 16:55:06', '2021-06-11 19:06:03');
INSERT INTO `product_info` VALUES (20, '435435', '小米洗衣机', 4, '小米', 'computer.jpg', '2339', 12, '', '1', '2021-06-04 16:56:23', '2021-06-11 19:06:00');
INSERT INTO `product_info` VALUES (22, '56743', '小米电视机', 3, '红米', 'computer.jpg', '2339', 50, '', '1', '2021-06-04 17:00:21', '2021-06-11 19:05:58');

-- ----------------------------
-- Table structure for product_type
-- ----------------------------
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '商品类型id',
  `type_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品类型名称',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_type
-- ----------------------------
INSERT INTO `product_type` VALUES (1, '电脑', '2021-06-04 10:36:56', NULL);
INSERT INTO `product_type` VALUES (2, '冰箱', '2021-06-04 10:37:50', NULL);
INSERT INTO `product_type` VALUES (3, '电视机', '2021-06-04 10:37:56', NULL);
INSERT INTO `product_type` VALUES (4, '洗衣机', '2021-06-04 10:37:59', NULL);
INSERT INTO `product_type` VALUES (5, '数码相机', '2021-06-04 10:38:05', NULL);
INSERT INTO `product_type` VALUES (8, '手机', '2021-06-05 17:18:04', NULL);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int NOT NULL COMMENT '用户信息id',
  `user_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账号',
  `user_pwd` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码',
  `real_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别（1：男，0：女）',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '地址',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '状态（1：正常，0：停用）',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'tom', '123456', '汤姆', '女', 'tom@123.com', '江苏省苏州市吴中区', '1', '2013-07-14 00:00:00', '2021-06-11 16:47:36');
INSERT INTO `user_info` VALUES (2, 'john', '123456', '约翰', '女', 'wen@135.com', '江苏省南京市玄武区', '1', '2013-07-14 00:00:00', '2021-06-06 11:06:32');
INSERT INTO `user_info` VALUES (3, 'my', '123456', 'my', '男', 'a@135.com', '江苏省南京市玄武区', '1', '2015-09-16 00:00:00', '2021-06-06 11:06:32');
INSERT INTO `user_info` VALUES (4, 'sj', '123456', 'sj', '男', 'b@135.com', '江苏省南京市玄武区', '0', '2015-09-16 00:00:00', '2021-06-11 20:28:03');
INSERT INTO `user_info` VALUES (5, 'lxf', '123456', 'lxf', '男', 'c@135.com', '江苏省南京市玄武区', '1', '2015-09-16 00:00:00', '2021-06-07 17:16:52');
INSERT INTO `user_info` VALUES (6, 'h', '123', 'lj', '男', 'a@135.com', '江苏省南京市玄武区', '0', '2015-09-20 00:00:00', '2021-06-11 20:27:59');

SET FOREIGN_KEY_CHECKS = 1;
