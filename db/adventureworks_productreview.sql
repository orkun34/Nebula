-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: adventureworks
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `productreview`
--

DROP TABLE IF EXISTS `productreview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `productreview` (
  `ProductReviewID` int(11) NOT NULL AUTO_INCREMENT,
  `ProductID` int(11) NOT NULL,
  `ReviewerName` varchar(50) DEFAULT NULL,
  `ReviewDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `EmailAddress` varchar(50) DEFAULT NULL,
  `Rating` int(11) NOT NULL,
  `Comments` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ModifiedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ProductReviewID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productreview`
--

LOCK TABLES `productreview` WRITE;
/*!40000 ALTER TABLE `productreview` DISABLE KEYS */;
INSERT INTO `productreview` VALUES (1,709,'John Smith','2003-10-19 21:00:00','john@fourthcoffee.com',5,'I can\'t believe I\'m singing the praises of a pair of socks, but I just came back from a grueling\r\n3-day ride and these socks really helped make the trip a blast. They\'re lightweight yet really cushioned my feet all day. \r\nThe reinforced toe is nearly bullet-proof and I didn\'t experience any problems with rubbing or blisters like I have with\r\nother brands. I know it sounds silly, but it\'s always the little stuff (like comfortable feet) that makes or breaks a long trip.\r\nI won\'t go on another trip without them!','2003-10-19 21:00:00'),(2,937,'David','2003-12-14 21:00:00','david@graphicdesigninstitute.com',4,'A little on the heavy side, but overall the entry/exit is easy in all conditions. I\'ve used these pedals for \r\nmore than 3 years and I\'ve never had a problem. Cleanup is easy. Mud and sand don\'t get trapped. I would like \r\nthem even better if there was a weight reduction. Maybe in the next design. Still, I would recommend them to a friend.','2003-12-14 21:00:00'),(3,937,'Jill','2003-12-16 21:00:00','jill@margiestravel.com',2,'Maybe it\'s just because I\'m new to mountain biking, but I had a terrible time getting use\r\nto these pedals. In my first outing, I wiped out trying to release my foot. Any suggestions on\r\nways I can adjust the pedals, or is it just a learning curve thing?','2003-12-16 21:00:00'),(4,798,'Laura Norman','2003-12-16 21:00:00','laura@treyresearch.net',5,'The Road-550-W from Adventure Works Cycles is everything it\'s advertised to be. Finally, a quality bike that\r\nis actually built for a woman and provides control and comfort in one neat package. The top tube is shorter, the suspension is weight-tuned and there\'s a much shorter reach to the brake\r\nlevers. All this adds up to a great mountain bike that is sure to accommodate any woman\'s anatomy. In addition to getting the size right, the saddle is incredibly comfortable. \r\nAttention to detail is apparent in every aspect from the frame finish to the careful design of each component. Each component is a solid performer without any fluff. \r\nThe designers clearly did their homework and thought about size, weight, and funtionality throughout. And at less than 19 pounds, the bike is manageable for even the most petite cyclist.\r\n\r\nWe had 5 riders take the bike out for a spin and really put it to the test. The results were consistent and very positive. Our testers loved the manuverability \r\nand control they had with the redesigned frame on the 550-W. A definite improvement over the 2002 design. Four out of five testers listed quick handling\r\nand responsivness were the key elements they noticed. Technical climbing and on the flats, the bike just cruises through the rough. Tight corners and obstacles were handled effortlessly. The fifth tester was more impressed with the smooth ride. The heavy-duty shocks absorbed even the worst bumps and provided a soft ride on all but the \r\nnastiest trails and biggest drops. The shifting was rated superb and typical of what we\'ve come to expect from Adventure Works Cycles. On descents, the bike handled flawlessly and tracked very well. The bike is well balanced front-to-rear and frame flex was minimal. In particular, the testers\r\nnoted that the brake system had a unique combination of power and modulation.  While some brake setups can be overly touchy, these brakes had a good\r\namount of power, but also a good feel that allows you to apply as little or as much braking power as is needed. Second is their short break-in period. We found that they tend to break-in well before\r\nthe end of the first ride; while others take two to three rides (or more) to come to full power. \r\n\r\nOn the negative side, the pedals were not quite up to our tester\'s standards. \r\nJust for fun, we experimented with routine maintenance tasks. Overall we found most operations to be straight forward and easy to complete. The only exception was replacing the front wheel. The maintenance manual that comes\r\nwith the bike say to install the front wheel with the axle quick release or bolt, then compress the fork a few times before fastening and tightening the two quick-release mechanisms on the bottom of the dropouts. This is to seat the axle in the dropouts, and if you do not\r\ndo this, the axle will become seated after you tightened the two bottom quick releases, which will then become loose. It\'s better to test the tightness carefully or you may notice that the two bottom quick releases have come loose enough to fall completely open. And that\'s something you don\'t want to experience\r\nwhile out on the road! \r\n\r\nThe Road-550-W frame is available in a variety of sizes and colors and has the same durable, high-quality aluminum that AWC is known for. At a MSRP of just under $1125.00, it\'s comparable in price to its closest competitors and\r\nwe think that after a test drive you\'l find the quality and performance above and beyond . You\'ll have a grin on your face and be itching to get out on the road for more. While designed for serious road racing, the Road-550-W would be an excellent choice for just about any terrain and \r\nany level of experience. It\'s a huge step in the right direction for female cyclists and well worth your consideration and hard-earned money.','2003-12-16 21:00:00'),(19,11231,'Osman','2018-11-29 21:16:43','karakulak@gmail.lcom',4,'﻿Osman','2018-11-29 21:16:43'),(20,11231,'Osman','2018-11-29 21:45:20','karakulak@gmail.lcom',4,'﻿Osman','2018-11-29 21:45:20');
/*!40000 ALTER TABLE `productreview` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-30  1:19:37
