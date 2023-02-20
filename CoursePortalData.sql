	create database CoursePortal

	use CoursePortal;

	/*TABLE*/
	CREATE TABLE faculty (
	  faculty_id VARCHAR(50) NOT NULL,
	  faculty_name VARCHAR(50) NOT NULL,
	  faculty_password VARCHAR(50) NOT NULL,
	  email VARCHAR(255) NOT NULL UNIQUE,
	  userType VARCHAR(50) NOT NULL
	);

	CREATE TABLE course (
	  course_id VARCHAR(50) NOT NULL,
	  course_name VARCHAR(255) NOT NULL,
	  faculty_id VARCHAR(50) NOT NULL,
	  course_level VARCHAR(50) NOT NULL,
	  course_password VARCHAR(50) NOT NULL,
	  userType VARCHAR(50) NOT NULL,
	  subject_taught VARCHAR(255) NOT NULL,
	  course_duration VARCHAR(20) NOT NULL,
	  employment_opportunities VARCHAR(255) NOT NULL,
	  scope_of_further_studies VARCHAR(255) NOT NULL,
	  scholarship_available VARCHAR(255) NOT NULL,
	  fee_structure VARCHAR(20) NOT NULL,
      requirements VARCHAR(200) NOT NULL,
	  FOREIGN KEY (faculty_id) REFERENCES faculty(faculty_id)
	);



	CREATE TABLE student (
	  student_id INT PRIMARY KEY UNIQUE,
	  first_name VARCHAR(50) NOT NULL,
	  last_name VARCHAR(50) NOT NULL,
	  email VARCHAR(255) NOT NULL UNIQUE,
	  password VARCHAR(30) NOT NULL,
	  course_name VARCHAR(255) NOT NULL,
	  course_level VARCHAR(255) NOT NULL,
	  faculty_name VARCHAR(255) NOT NULL,
	  userType VARCHAR(50) NOT NULL,
	  username VARCHAR(50) NOT NULL,
      age VARCHAR(50) NOT NULL,
	  gender VARCHAR(50) NOT NULL
	);
    
    CREATE TABLE appliedCourse (
	   stu_username VARCHAR(50) NOT NULL,
       coursename VARCHAR(255) NOT NULL,
       coursemedium VARCHAR(50) NOT NULL,
       academic_Credentials mediumblob NOT NULL,
       currentlevel VARCHAR(50) NOT NULL,
       currentresult VARCHAR(50) NOT NULL,
       applyscholar VARCHAR(50) NOT NULL,
       faculty_id VARCHAR(50) NOT NULL
    );

    
	/*INSERT fACULTY*/
	INSERT INTO faculty VALUES
	("FOL3161","Faculty of Law","abc123","fol@university.edu.my","faculty"),
	("FCI7990","Faculty of Computer & Informatics","abc123","fci@university.edu.my","faculty"),
	("FOB6201","Faculty of Business","abc123","fob@university.edu.my","faculty");
    
	/*INSERT INTO COURSE*/    
	/*Law*/
	INSERT INTO course VALUES
	("FOL3163","Diploma in Law","FOL3161","Diploma","abc123","course","Communicative English, Critical Thinking, Computer Applications, Introduction to Law, General Principles of Law","3years","Lawyer","Bachelor of Law","Mara,TM,Petronas","RM25000","SPM minimum 5 credits include English"),
	("FOL3163","Bachelor of Law(Hons)","FOL3161","Degree","abc123","course","Malaysian Legal System, Constitutional Law, Contract Law , Legal Method","4years","Lawyer","Master of Law","Mara,TM,Petronas","RM80000","Foundation : CGPA 3.0 above in the field or related fields / STPM : pass 4 subjects include English / Diploma : CGPA 3.0 above in the field or related fields "),
	("FOL3163","Master of Law","FOL3161","Master","abc123","course","Cyber Law, Alternative Dispute Resolution, Banking Law, Business Law, Child Law","2years","Lawyer","Doctor of Law (PHD)","Mara,TM,Petronas","RM28000","Degree with CGPA 3.0 above in the field or related fields"),
	("FOL3163","Doctor of Law (PHD)","FOL3161","PHD","abc123","course","Law and Economics, Human Rights Law, Industrial Relations Law, Information Technology Law, International Law","3years","Lawyer","-","Mara,TM,Petronas","RM32000","A Master’s degree (Level 7, MQF) in the field or related fields");

	/*fci*/
    INSERT INTO course VALUES
	("FCI7991","Diploma in Computer Science","FCI7990","Diploma","abc123","course","Programming Fundamentals, Discrete Structures & Probability, Professional Development, Computational Methods","3years","Software Engineer, Programmer, Project Manager, System Analyst","Bachelor of Computer Science","Mara,TM,Petronas","RM26000", "SPM minimum 5 credits include English,Math"),
	("FCI7991","Bachelor of Computer Science(Hons)","FCI7990","Degree","abc123","course","Software Engineering Fundamentals, Operating Systems, Computer Networks, Object Oriented Analysis & Design","4years","Software Engineer, Programmer, Project Manager, System Analyst","Master of Computer Science","Mara,TM,Petronas","RM85000","Foundation : CGPA 3.0 above in the field or related fields / STPM : pass 4 subjects include English,Math / Diploma : CGPA 3.0 above in the field or related fields "),
	("FCI7991","Master of Computer Science","FCI7990","Master","abc123","course","Cryptography, Computer Vision, Data Communication and Networking, Data Science","2years","Software Engineer, Programmer, Project Manager, System Analyst","Doctor of Computer Science (PHD)","Mara,TM,Petronas","RM32000","Degree with CGPA 3.0 above in the field or related fields"),
	("FCI7991","Doctor of Computer Science (PHD)","FCI7990","PHD","abc123","course","Artificial Intelligence, Bioinformatics & Medical Information Technology, Blockchain/IoT, Security Technology","3years","Software Engineer, Programmer, Project Manager, System Analyst","-","Mara,TM,Petronas","RM42000","A Master’s degree (Level 7, MQF) in the field or related fields");

	/*Business administration*/
	INSERT INTO course VALUES
	("FOB6202","Diploma in Business administration","FOB6201","Diploma","abc123","course","Business Mathematics, Fundamentals of Business, Microeconomics, Financial Accounting","3years","Accountant","Bachelor of Business administration","Mara,TM,Petronas","RM21000", "SPM minimum 5 credits include English,Business"),
	("FOB6202","Bachelor of Business administration(Hons)","FOB6201","Degree","abc123","course","Organisational Behaviour, Business Law, Corporate Finance,Principles of Marketing","4years","Accountant","Master of Business administration","Mara,TM,Petronas","RM74000","Foundation : CGPA 3.0 above in the field or related fields / STPM : pass 4 subjects include English / Diploma : CGPA 3.0 above in the field or related fields "),
	("FOB6202","Master of Business administration","FOB6201","Master","abc123","course","General Management, Multimedia Marketing, Human Resource Management, Information Technology","2years","Accountant","Doctor of Business administration (PHD)","Mara,TM,Petronas","RM27000", "Degree with CGPA 3.0 above in the field or related fields"),
	("FOB6202","Doctor of Business administration (PHD)","FOB6201","PHD","abc123","course","Knowledge management, Banking and finance, Economics, Accounting","3years","Accountant","-","Mara,TM,Petronas","RM30000", "A Master’s degree (Level 7, MQF) in the field or related fields");


	/*SELECT*/
	SELECT * FROM faculty;
	SELECT * FROM course;
	SELECT * FROM student;
	SELECT * FROM appliedCourse;
    
    
	/*ALTER*/
    ALTER TABLE course MODIFY COLUMN requirements VARCHAR(200);
	ALTER TABLE student ADD FOREIGN KEY (course_name, course_level) REFERENCES course(course_name, course_level);
	ALTER TABLE student ADD gender VARCHAR(50) NOT NULL;
    ALTER TABLE appliedcourse ADD currentlevel VARCHAR(50) NOT NULL;
    ALTER TABLE appliedcourse ADD currentresult VARCHAR(50) NOT NULL;
    ALTER TABLE appliedcourse ADD applyscholar VARCHAR(50) NOT NULL;
    ALTER TABLE appliedcourse ADD faculty_id VARCHAR(50) NOT NULL;
	CREATE INDEX faculty_name_index ON faculty (faculty_name);
	CREATE INDEX course_ibfk_1 ON faculty (faculty_id);
	INSERT INTO student (student_id, value)
	VALUES (UUID(), 1);
	DELETE FROM student WHERE student_id = "83747";
	DELETE FROM course WHERE course_id = "FOL3163";
    DELETE FROM faculty WHERE faculty_id = "FOL3161";
    DELETE FROM appliedcourse WHERE stu_username = "kuyaa";
	desc student;
	ALTER TABLE course ADD requirements VARCHAR(20) NOT NULL;
	ADD subject_taught VARCHAR(255) NOT NULL,
	ADD course_duration INT NOT NULL,
	ADD employment_opportunities VARCHAR(255) NOT NULL,
	ADD scope_of_further_studies VARCHAR(255) NOT NULL,
	ADD scholarship_available VARCHAR(255) NOT NULL,
	ADD fee_structure INT NOT NULL;

	/*Login*/
	SELECT s.username as username, s.password as password ,s.userType as userType FROM student s UNION SELECT c.course_id as username, c.course_password as password ,c.userType as userType FROM course c UNION SELECT f.faculty_id as username, f.faculty_password as password ,f.userType as userType FROM faculty f;
	/*Student Profile*/
	select student_id,first_name,last_name,course_name,course_level,faculty_name from student where username="aliceSmith";
    /*View Course Details*/
    select course_name,course_level,subject_taught,course_duration,employment_opportunities,scope_of_further_studies,scholarship_available,fee_structure from course where course_id='FOM1112';
	/*Update Course Details*/
    update course set subject_taught = 'yo', course_duration = 'yo', employment_opportunities = 'yo', scope_of_further_studies = 'yo', scholarship_available = 'yo', fee_structure = 'yo' where course_name = 'Foundation of Business';
    /*View Course*/
    select course_id,course_name,course_level,faculty_id,course_password from course where faculty_id="FOM1111";
    /*Student View*/
    select course_name,course_level,subject_taught,course_duration,employment_opportunities,scope_of_further_studies,scholarship_available,fee_structure from course;
    /*Student Edit Profile*/
    update student set first_name = 'Mueez',last_name = 'Eiman', age = '20' where username = 'kuyaa';
    /*Get Faculty Name*/
    select faculty_name from faculty where faculty_id = 'FOM1111';
    /*Get Faculty Id*/
    SELECT faculty_id from course where course_name = 'Diploma in Law';
    /*GET BLOB*/
    SELECT academic_Credentials FROM appliedCourse WHERE faculty_id = 'kuyaa';
    /*GET COURSE LEVEL*/
    SELECT course_level FROM course WHERE course_name = 'Diploma in Law';
    
