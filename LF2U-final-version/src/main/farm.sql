/*
Navicat MySQL Data Transfer

Source Server         : Localhost
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : farm

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2016-11-19 21:51:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for catalog
-- ----------------------------
DROP TABLE IF EXISTS `catalog`;
CREATE TABLE `catalog` (
  `gcpid` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`gcpid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of catalog
-- ----------------------------
INSERT INTO `catalog` VALUES ('1', 'apple');
INSERT INTO `catalog` VALUES ('2', 'Eggplant');
INSERT INTO `catalog` VALUES ('3', 'Tomatoes');
INSERT INTO `catalog` VALUES ('4', 'Potatoes');
INSERT INTO `catalog` VALUES ('6975', 'mmmm');
INSERT INTO `catalog` VALUES ('8544', 'Potatoes (red)');
INSERT INTO `catalog` VALUES ('8761', 'Potatoes');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `cid` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zip` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', 'Jack', 'Inges', '923849', '1293283758', 'w3lkjfealw@gmail.com');
INSERT INTO `customer` VALUES ('3609', 'ddddddddd', null, '1110', '12222222222', null);
INSERT INTO `customer` VALUES ('435', 'Virgil B', '10 West 31st Street, #214', '60616', '312-567-5146', 'virgilb@example.com');
INSERT INTO `customer` VALUES ('5835', 'ddddddddd', null, '1110', '12222222222', null);
INSERT INTO `customer` VALUES ('6872', 'ddddddddd', null, '1110', '12222222222', null);
INSERT INTO `customer` VALUES ('6974', 'ddddddddd', null, '1110', '12222222222', null);
INSERT INTO `customer` VALUES ('8883', 'ddddddddd', null, '1110', '12222222222', null);
INSERT INTO `customer` VALUES ('9310', 'ddddddddd', null, '1110', '12222222222', null);

-- ----------------------------
-- Table structure for delivery_to
-- ----------------------------
DROP TABLE IF EXISTS `delivery_to`;
CREATE TABLE `delivery_to` (
  `delivery_to_id` varchar(255) NOT NULL,
  `zip` varchar(11) DEFAULT NULL,
  `uid` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`delivery_to_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of delivery_to
-- ----------------------------
INSERT INTO `delivery_to` VALUES ('2b26f59a-9aba-40c4-bca1-5bed8dbbef2e', '60011', '6334', 'sadf');
INSERT INTO `delivery_to` VALUES ('ea779676-71da-444c-97ea-c9ad663b6025', '60067', '6334', 'sdf');
INSERT INTO `delivery_to` VALUES ('fe6d2317-d1ae-46cc-bb03-0b23a99c4f4f', 'sdafffffff', '6334', 'sadf');

-- ----------------------------
-- Table structure for farm
-- ----------------------------
DROP TABLE IF EXISTS `farm`;
CREATE TABLE `farm` (
  `faid` varchar(255) NOT NULL,
  `fid` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `web` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`faid`),
  KEY `fid` (`fid`),
  CONSTRAINT `farm_ibfk_1` FOREIGN KEY (`fid`) REFERENCES `farmer` (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of farm
-- ----------------------------
INSERT INTO `farm` VALUES ('2fa83350-50f3-4f4b-a29c-1732b196a90d', '7962', 'cccccccccccccc', '25550 W Cuba Rd, Barrington, IL 60010', '847-651-2140', 'http://www.openherd.com/');
INSERT INTO `farm` VALUES ('3636508f-a246-4710-a614-36c3a713d6f3', '4187', 'cccccccccccccc', '25550 W Cuba Rd, Barrington, IL 60010', '847-651-2140', 'http://www.openherd.com/');
INSERT INTO `farm` VALUES ('6cce0bb2-3f34-40d5-bcaa-8a61143a6a54', '701', 'new Farm', 'China', '123', 'google.com');
INSERT INTO `farm` VALUES ('89195059-09ed-4255-8fed-c9ea34b0cbb8', '1759', 'cccccccccccccc', '25550 W Cuba Rd, Barrington, IL 60010', '847-651-2140', 'http://www.openherd.com/');
INSERT INTO `farm` VALUES ('8962b20e-c31e-47d2-bc78-0b884f1864e9', '701', 'new Farm', 'China', '123', 'google.com');
INSERT INTO `farm` VALUES ('951ea1aa-4016-4551-b4f7-b7c4687cbdd2', '701', 'new Farm', 'China', '123', 'google.com');
INSERT INTO `farm` VALUES ('b40f0b6f-7d19-4b97-9fba-56abb22a8220', '1143', 'cccccccccccccc', '25550 W Cuba Rd, Barrington, IL 60010', '847-651-2140', 'http://www.openherd.com/');
INSERT INTO `farm` VALUES ('dbdcf6d3-b271-427c-b119-7cd28c1245bb', '6334', 'zz', '25550 W Cuba Rd, Barrington, IL 60010', '847-651-2140', 'http://www.openherd.com/');

-- ----------------------------
-- Table structure for farmer
-- ----------------------------
DROP TABLE IF EXISTS `farmer`;
CREATE TABLE `farmer` (
  `fid` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of farmer
-- ----------------------------
INSERT INTO `farmer` VALUES ('1143', 'John Smith', 'john.smith@example.com', '123-456-7890');
INSERT INTO `farmer` VALUES ('123', 'sdaf', 'sdaf', null);
INSERT INTO `farmer` VALUES ('1759', 'John Smith', 'john.smith@example.com', '123-456-7890');
INSERT INTO `farmer` VALUES ('2127', null, null, null);
INSERT INTO `farmer` VALUES ('3029', 'John Smith', 'john.smith@example.com', '123-456-7890');
INSERT INTO `farmer` VALUES ('3111', null, null, null);
INSERT INTO `farmer` VALUES ('4187', 'John Smith', 'john.smith@example.com', '123-456-7890');
INSERT INTO `farmer` VALUES ('5772', null, null, null);
INSERT INTO `farmer` VALUES ('6334', 'John ddddddddd', 'john.smith@example.com', '123-456-7890');
INSERT INTO `farmer` VALUES ('6900', null, null, null);
INSERT INTO `farmer` VALUES ('701', 'Tom', 'skdjaflkashd@g.com', 'dsf');
INSERT INTO `farmer` VALUES ('7962', 'John Smith', 'john.smith@example.com', 'sadf');
INSERT INTO `farmer` VALUES ('8265', null, null, null);
INSERT INTO `farmer` VALUES ('8923', null, null, null);
INSERT INTO `farmer` VALUES ('9940', null, null, null);
INSERT INTO `farmer` VALUES ('9965', null, null, null);

-- ----------------------------
-- Table structure for farmer_report
-- ----------------------------
DROP TABLE IF EXISTS `farmer_report`;
CREATE TABLE `farmer_report` (
  `rid` varchar(255) NOT NULL DEFAULT '',
  `frid` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `order` text,
  PRIMARY KEY (`rid`),
  UNIQUE KEY `farmer_report_frid_uindex` (`frid`),
  UNIQUE KEY `farmer_report_rid_pk` (`rid`),
  CONSTRAINT `farmer_report_farmer_fid_fk` FOREIGN KEY (`frid`) REFERENCES `farmer` (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of farmer_report
-- ----------------------------
INSERT INTO `farmer_report` VALUES ('1', '123', 'Orders to deliver tomorrow', 'delivery to tom');
INSERT INTO `farmer_report` VALUES ('2', '701', 'deliver', '1231231');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `mid` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `phone` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mid`),
  KEY `asdf` (`created_by`),
  CONSTRAINT `asdf` FOREIGN KEY (`created_by`) REFERENCES `manager` (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', 'tom', '1', '123132', 'aaa@qq.com');
INSERT INTO `manager` VALUES ('2', 'jack', '1', '12312312', 'okok@gmail.com');

-- ----------------------------
-- Table structure for manager_report
-- ----------------------------
DROP TABLE IF EXISTS `manager_report`;
CREATE TABLE `manager_report` (
  `mrid` int(11) NOT NULL,
  `mid` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `start_date` int(8) DEFAULT NULL,
  `end_date` int(8) DEFAULT NULL,
  `orders_placed` varchar(255) DEFAULT NULL,
  `orders_delivered` varchar(255) DEFAULT NULL,
  `orders_open` varchar(255) DEFAULT NULL,
  `orders_cancelled` varchar(255) DEFAULT NULL,
  `total_revenue` double(255,0) DEFAULT NULL,
  `total_products__revenue` double DEFAULT NULL,
  `total_delivery_revenue` double DEFAULT NULL,
  `lf2u_management_fee` double DEFAULT NULL,
  `total_lf2u_fees` double DEFAULT NULL,
  `total_payable_to_farm` double DEFAULT NULL,
  `by_farmer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mrid`),
  KEY `mid` (`mid`),
  CONSTRAINT `manager_report_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `manager` (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager_report
-- ----------------------------
INSERT INTO `manager_report` VALUES ('1', '1', 'Orders placed today', '1', '1', '2', '1', '1', '1', null, null, null, null, null, null, null);
INSERT INTO `manager_report` VALUES ('2', '2', 'Orders placed yesterday', '20160102', '20160103', 'American', 'yes', 'yes', null, null, null, null, null, null, null, null);
INSERT INTO `manager_report` VALUES ('3', '1', 'Revenue for previous month', '20161101', '20161102', 'China', 'no', 'no', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` varchar(255) NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  `frid` varchar(255) DEFAULT NULL,
  `products_total` int(11) DEFAULT NULL,
  `delivery_charge` double DEFAULT NULL,
  `order_total` double DEFAULT NULL,
  `planned_delivery_date` int(8) DEFAULT NULL,
  `actual_delivery_date` int(8) DEFAULT NULL,
  `order_date` int(8) DEFAULT NULL,
  `ordered_by` varchar(255) DEFAULT NULL,
  `delivery_address` varchar(255) DEFAULT NULL,
  `order_detail` text,
  `note` text,
  PRIMARY KEY (`oid`),
  KEY `adgaf` (`ordered_by`),
  KEY `orders_farmer_fid_fk` (`frid`),
  CONSTRAINT `adgaf` FOREIGN KEY (`ordered_by`) REFERENCES `customer` (`cid`),
  CONSTRAINT `orders_farmer_fid_fk` FOREIGN KEY (`frid`) REFERENCES `farmer` (`fid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('52c212cc-4afc-4821-81f9-8626e14e6ad9', 'delivered', '123', null, null, '123', '20161019', null, '20161019', '435', '20161019', null, 'Please leave with building attendant.');
INSERT INTO `orders` VALUES ('7dfc63d6-e470-47ca-8f15-b4172433f25a', ' no delivery ', '123', null, null, '123', '20161019', null, '20161019', '435', '20161019', null, 'Please leave with building attendant.');
INSERT INTO `orders` VALUES ('c5875cf6-23b8-4c77-9701-ec4b0f82e696', ' no delivery ', '123', null, null, '123', '20161019', '20161019', '20161019', '435', null, null, 'Please leave with building attendant.');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `fspid` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `start_date` int(8) DEFAULT NULL,
  `end_date` int(8) DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  `product_unit` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `gcpid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fspid`),
  KEY `dfadfasd` (`gcpid`),
  CONSTRAINT `dfadfasd` FOREIGN KEY (`gcpid`) REFERENCES `catalog` (`gcpid`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('029586ad-b01c-4ad3-a2cf-c0702379f79e', 'APPLE', null, null, '323233', null, null, null, '1');
INSERT INTO `product` VALUES ('345', 'chinese apple', null, '12312', '12312', '234.00', '123', '1', '1');
INSERT INTO `product` VALUES ('542a3b76-3982-45bc-9c1c-45d32c13c191', 'APPLE', null, null, '323233', null, null, null, '1');
INSERT INTO `product` VALUES ('5ac0f986-c92b-4f44-a258-cb6d7895ae2a', 'APPLE', null, null, '323233', null, null, null, '1');
INSERT INTO `product` VALUES ('71eba267-e14f-4235-a0cb-58d7ddca7bb3', 'APPLE', null, null, '323233', null, null, null, '1');
INSERT INTO `product` VALUES ('ce19d70e-42aa-4277-9a30-3c92b490d3aa', 'APPLE', null, null, '323233', null, null, null, '1');
INSERT INTO `product` VALUES ('e44be40e-e633-4c62-afca-087ccac07b78', 'APPLE', null, null, '323233', null, null, null, '1');
INSERT INTO `product` VALUES ('e4cc0613-7cf7-4d2a-b0b1-870aaf0b0c15', 'APPLE', null, null, '323233', null, null, null, '1');
