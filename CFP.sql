/* Author: Axita Patel,  */

CREATE SCHEMA CFP; 


CREATE TABLE CFP.EVENT 
(Name 			VARCHAR(200) 	NOT NULL,
 CFPText 		VARCHAR(400)	NOT NULL,
 WebLink 		VARCHAR(200),
 PRIMARY KEY (Name));
 
CREATE TABLE CFP.EVENTCONFERENCE 
(EventName		VARCHAR(200)	NOT NULL,
 EDate			VARCHAR(30)		NOT NULL,
 City			VARCHAR(30),
 Country		VARCHAR(30)		NOT NULL,
 PRIMARY KEY (EventName),
 FOREIGN KEY (EventName) REFERENCES EVENT(Name));
 
CREATE TABLE CFP.EVENTJOURNAL 
(EventName		VARCHAR(200)	NOT NULL,
 JornalName		VARCHAR(60)		NOT NULL,
 Publisher		VARCHAR(40),
 PRIMARY KEY (EventName),
 FOREIGN KEY (EventName) REFERENCES EVENT(Name));
  
CREATE TABLE CFP.EVENTBOOK
(EventName		VARCHAR(200)	NOT NULL,
 Publisher		VARCHAR(40)		NOT NULL,
 PRIMARY KEy (EventName),
 FOREIGN KEY (EventName) REFERENCES EVENT(Name));
   
CREATE TABLE CFP.ACTIVITY
(EventName		VARCHAR(100)	NOT NULL,
 ActivityName	VARCHAR(60)		NOT NULL,
 ADate			VARCHAR(30)		NOT NULL,
 PRIMARY KEY (EventName, ActivityName),
 FOREIGN KEY (EventName) REFERENCES EVENT(Name));
 
 CREATE TABLE CFP.PEOPLE
 (Name			VARCHAR(30)		NOT NULL,
 Affiliation	VARCHAR(300),
 PRIMARY KEY (Name));
  
 CREATE TABLE CFP.ORGANIZES 
 (Role			VARCHAR(30)		NOT NULL,
  EventName		VARCHAR(200)	NOT NULL,
  PName			VARCHAR(30)		NOT NULL,
  PRIMARY KEY (EventName, PName),
  FOREIGN KEY (EventName) REFERENCES EVENT(Name),
  FOREIGN KEY (PName) REFERENCES PEOPLE(Name));
   
 CREATE TABLE CFP.RESEARCHTOPIC
 (Name			VARCHAR(100)	NOT NULL,
  Area			VARCHAR(30)		NOT NULL,
 PRIMARY KEY (Name));
  
 CREATE TABLE CFP.COVERS 
(EventName		VARCHAR(60)		NOT NULL,
 TopicName		VARCHAR(30)		NOT NULL,
 PRIMARY KEY (EventName, TopicName),
 FOREIGN KEY (EventName) REFERENCES EVENT(Name),
 FOREIGN KEY (TopicName) REFERENCES RESEARCHTOPIC(Name));
 
 CREATE TABLE CFP.CFPCount (
Type	VARCHAR(20)	NOT NULL,
Ct		INT			NOT NULL,
PRIMARY KEY (Type, Ct));

/* Add 3 rows for the 3 different types of CFPs and set count to 0 */
INSERT INTO CFP.CFPCount (Type, Ct)
VALUES ('Conference', 0),
('Journal', 0),
('Book', 0);

/* Trigger to update count when a conference type is inserted */
CREATE TRIGGER CFP_count_update1
AFTER INSERT ON CFP.EventConference 
FOR EACH ROW
UPDATE	CFP.CFPCount
SET		Ct=Ct+ 1
WHERE 	Type='Conference';  

/* Trigger to update count when a conference type is deleted */
CREATE TRIGGER CFP_count_update2
AFTER DELETE ON CFP.EventConference
FOR EACH ROW
UPDATE	CFP.CFPCount
SET		Ct=Ct- 1
WHERE 	Type='Conference';  

CREATE TRIGGER CFP_count_update3
AFTER INSERT ON CFP.EventJournal
FOR EACH ROW
UPDATE	CFP.CFPCount
SET		Ct=Ct + 1
WHERE 	Type='Journal';  

CREATE TRIGGER CFP_count_update4
AFTER DELETE ON CFP.EventJournal
FOR EACH ROW
UPDATE	CFP.CFPCount
SET		Ct=Ct - 1
WHERE 	Type='Journal';  

CREATE TRIGGER CFP_count_update5
AFTER INSERT ON CFP.EventBook
FOR EACH ROW
UPDATE	CFP.CFPCount
SET		Ct=Ct+ 1
WHERE 	Type='Book';  

CREATE TRIGGER CFP_count_update6
AFTER DELETE ON CFP.EventBook
FOR EACH ROW
UPDATE	CFP.CFPCount
SET		Ct=Ct- 1
WHERE 	Type='Book';  
