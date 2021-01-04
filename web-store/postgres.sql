/*
 Navicat Premium Data Transfer

 Source Server         : postgreSQL
 Source Server Type    : PostgreSQL
 Source Server Version : 120005
 Source Host           : 192.168.152.128:5432
 Source Catalog        : postgres
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 120005
 File Encoding         : 65001

 Date: 04/01/2021 12:32:53
*/


-- ----------------------------
-- Table structure for g_goods
-- ----------------------------
DROP TABLE IF EXISTS "public"."g_goods";
CREATE TABLE "public"."g_goods" (
  "id" int4 NOT NULL,
  "price" float4,
  "title" varchar(255) COLLATE "pg_catalog"."default",
  "detail" varchar(255) COLLATE "pg_catalog"."default",
  "image" varchar(255) COLLATE "pg_catalog"."default",
  "typeid" int4
)
;

-- ----------------------------
-- Records of g_goods
-- ----------------------------
INSERT INTO "public"."g_goods" VALUES (1, 39, '家人闲坐，灯火可', '作者:汪曾祺著，文通天下 出品出版社:光明日报出版社出版时间:2020年04月 ', 'http://img11.360buyimg.com/n1/jfs/t1/133414/2/3522/137461/5f03cea2Eca0e66b8/43e9a422710715ac.jpg', 1);
INSERT INTO "public"."g_goods" VALUES (2, 59, '你当像鸟飞往你的山', '作者:塔拉 · 韦斯特弗 著 ， 新经典 出品出版社:南海出版公司出版时间:2019年11月 ', 'http://img12.360buyimg.com/n1/jfs/t1/91599/23/17232/298005/5e86d5bdE0ce233df/38c6095eba65defc.jpg', 1);
INSERT INTO "public"."g_goods" VALUES (3, 69, '万般滋味，都是生活', '作者:丰子恺出版社:华中科技大学出版社出版时间:2018年09月 ', 'http://img13.360buyimg.com/n1/jfs/t1/571/1/14067/158227/5bd920c3E595702f0/ef68a151539f3e98.jpg', 1);
INSERT INTO "public"."g_goods" VALUES (4, 100, '当你学会独处', '作者:周国平出版社:浙江人民出版社出版时间:2020年03月 ', 'http://img10.360buyimg.com/n1/jfs/t1/118321/20/11014/93113/5efb0661Ebac5289f/714331f8b83480e9.jpg', 1);
INSERT INTO "public"."g_goods" VALUES (5, 59, '游牧民的世界史', '作者:杉山正明出版社:北京时代华文书局出版时间:2019年11月 ', 'http://img12.360buyimg.com/n1/jfs/t1/92176/6/18902/205423/5e995f52E37043591/cb6cf2c5981a7d57.jpg', 2);
INSERT INTO "public"."g_goods" VALUES (6, 72, '万历十五年', '作者:黄仁宇出版社:生活.读书.新知三联书店出版时间:2006年06月 ', 'http://img10.360buyimg.com/n1/jfs/t1/4983/24/8858/185315/5baaf281Eec7a94b0/e04f12dfac19a2a2.jpg', 2);
INSERT INTO "public"."g_goods" VALUES (7, 39, '烤肉笔记', '作者:东京书籍出版编辑部出版社:北京美术摄影出版社出版时间:2015年04月 ', 'https://img10.360buyimg.com/n1/jfs/t1/57625/6/7607/131687/5d53d444E64aaf619/e28be28ed9435030.jpg', 3);
INSERT INTO "public"."g_goods" VALUES (8, 79, '权力精英', '作者:[美] C.赖特·米尔斯 译 者：李子雯出版社:北京时代华文书局出版时间:2019年09月 ', 'https://img13.360buyimg.com/n1/jfs/t1/57538/36/13029/126560/5d9ec394E576fe698/a5b819849729234e.jpg', 2);
INSERT INTO "public"."g_goods" VALUES (9, 39, '人类学简史', '作者:弗洛朗斯·韦伯（Florence Weber）出版社:商务印书馆出版时间:2020年05月 ', 'https://img13.360buyimg.com/n1/jfs/t1/113093/34/10038/200979/5ee6d71bE085b28ca/11fb9119fa4be4b2.jpg', 2);
INSERT INTO "public"."g_goods" VALUES (10, 39, '中国茶事', '作者:郑国建出版社:中国轻工业出版社出版时间:2016年02月 ', 'http://img11.360buyimg.com/n1/jfs/t2335/350/1993388809/365396/d4f12f49/56e7a3acN51a746b0.jpg', 3);
INSERT INTO "public"."g_goods" VALUES (11, 105, '大医至简——刘希彦', '作者:刘希彦出版社:湖南科技出版社出版时间:2020年03月 ', 'https://img12.360buyimg.com/n1/jfs/t1/30545/37/695/61171/5c3feac6E9afac3b4/86cb10a8822cce47.jpg', 4);
INSERT INTO "public"."g_goods" VALUES (12, 33, '鸟哥的Linux私房', '作者:鸟哥出版社:人民邮电出版社出版时间:2018年11月 ', 'https://img13.360buyimg.com/n1/jfs/t1/110537/16/11302/148808/5e85aeccEca6720b3/3b57105cff4b7935.jpg', 4);
INSERT INTO "public"."g_goods" VALUES (13, 69, '自愈力：杀不死你', '作者:李世强出版社:天津人民出版社出版时间:2020年07月 ', '//img13.360buyimg.com/n1/jfs/t1/114356/17/11386/173632/5efc5d38E18729a56/672ce4d598709e44.png', 5);
INSERT INTO "public"."g_goods" VALUES (14, 72, '深度工作', '作者:丰志强出版社:北京大学出版社出版时间:2020年04月 ', 'https://img13.360buyimg.com/n1/jfs/t1/112696/25/6461/532485/5ebcf2e9E3337e9de/dbfbd50007235e3b.jpg', 5);

-- ----------------------------
-- Table structure for goods_type
-- ----------------------------
DROP TABLE IF EXISTS "public"."goods_type";
CREATE TABLE "public"."goods_type" (
  "type_id" int4 NOT NULL,
  "type_name" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of goods_type
-- ----------------------------
INSERT INTO "public"."goods_type" VALUES (1, '文艺');
INSERT INTO "public"."goods_type" VALUES (2, '社科');
INSERT INTO "public"."goods_type" VALUES (3, '生活');
INSERT INTO "public"."goods_type" VALUES (4, '科技');
INSERT INTO "public"."goods_type" VALUES (5, '励志');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS "public"."orders";
CREATE TABLE "public"."orders" (
  "order_id" int4 NOT NULL,
  "goods_id" int4,
  "user_id" int4,
  "price" float4,
  "status" int4 NOT NULL,
  "creatTime" timestamp(6),
  "num" int4
)
;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO "public"."orders" VALUES (40, 3, 1, 69, 0, '2020-07-16 13:38:43', 0);
INSERT INTO "public"."orders" VALUES (43, 4, 1, 100, 0, '2020-12-29 10:33:34', 0);
INSERT INTO "public"."orders" VALUES (44, 14, 1, 72, 0, '2020-12-29 10:33:35', 0);
INSERT INTO "public"."orders" VALUES (46, 6, 1, 72, 0, '2020-12-29 10:33:38', 0);
INSERT INTO "public"."orders" VALUES (38, 1, 1, 39, 0, '2020-12-29 10:33:34', 2);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS "public"."user";
CREATE TABLE "public"."user" (
  "u_id" int4 NOT NULL,
  "u_name" varchar(255) COLLATE "pg_catalog"."default",
  "password" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO "public"."user" VALUES (1, 'tong', '123456');

-- ----------------------------
-- Primary Key structure for table g_goods
-- ----------------------------
ALTER TABLE "public"."g_goods" ADD CONSTRAINT "g_goods_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table goods_type
-- ----------------------------
ALTER TABLE "public"."goods_type" ADD CONSTRAINT "goods_type_pkey" PRIMARY KEY ("type_id");

-- ----------------------------
-- Primary Key structure for table orders
-- ----------------------------
ALTER TABLE "public"."orders" ADD CONSTRAINT "orders_pkey" PRIMARY KEY ("order_id");

-- ----------------------------
-- Primary Key structure for table user
-- ----------------------------
ALTER TABLE "public"."user" ADD CONSTRAINT "user_pkey" PRIMARY KEY ("u_id");
