CREATE DATABASE ChildCareC0907I
GO
use ChildCareC0907I
GO

CREATE TABLE tbl_Users(
	UserCode int primary key identity(1,1) NOT NULL, 
	[Admin] bit,
	FullName nvarchar(100) NOT NULL,---/---
	Account Varchar(100),---
	[Password] nvarchar(100),
	Sex Bit,
	[Address] nvarchar(200),
	Birthday Datetime,
	Phone int,
	Email nvarchar(200),
	StartDate Datetime,---/----
	FeedBack nvarchar(100),
	Status Bit NULL DEFAULT 1,
)
--insert into tbl_Users values (1,1,'To Kim Dai','Admin','123456',1,'Ha Noi','12/31/2010',1234,'daitk','12/31/2010','abc',1)
--select * from tbl_Users
GO

CREATE TABLE tbl_AgeGroup(
	GroupAgeCode int primary key  identity(1,1) NOT NULL,
	AgeGroup Varchar(100),
	ChargePerGroup Money ,
	Status Bit NULL DEFAULT 1,
)
-- insert into tbl_AgeGroup values ('From 0 to 2', 600, 1)
-- insert into tbl_AgeGroup values ('From 2 to 5', 600, 1)
-- insert into tbl_AgeGroup values ('From 5 to 8', 600, 1)
-- insert into tbl_AgeGroup values ('From 8 to 10', 600, 1)
-- insert into tbl_AgeGroup values ('From 10 to 12', 600, 1)
GO
CREATE TABLE tbl_Class(
	
	ClassCode int identity(1,1)NOT NULL,
	GroupAgeCode int foreign key references tbl_AgeGroup (GroupAgeCode)NOT NULL,
	ClassName nvarchar(50),----/---
	Note Nvarchar(200),
	Status Bit NULL DEFAULT 1,
	primary key(ClassCode)
)
---insert into tbl_Class values(1, 'C0907I', 'Good', 1)
GO
CREATE TABLE tbl_Child(
	ChildCode int  primary key identity(1,1) NOT NULL,
	GroupAgeCode int foreign key references tbl_AgeGroup(GroupAgeCode)  NOT NULL,---
	LastName nvarchar(50),
	FirstName nvarchar(50),--/--
	DateOfBirth Datetime ,
	Sex bit,
	[Address] nvarchar(100),
	CurrentMedication nvarchar(30),
	PassIllness nvarchar(55),
	DoctorName nvarchar(200),
	ParentName nvarchar(200) not null,--
	ParentWorkNumber nvarchar(18),
	ParentMobileNumber nvarchar(18),
	NextOfKinContact nvarchar(500),
	NoteAboutChild nvarchar(200),
	RegistrationDate Datetime not null,----/---
	DateReceived Datetime,---/---
	ParentEmailAddress nvarchar(150),
	Status Bit NULL DEFAULT 1,
	
)
GO
CREATE TABLE tbl_Nanny(
	NannyCode int  primary key identity(1,1) NOT NULL,
	ClassCode int foreign key references tbl_Class(ClassCode),
	[Name] varchar(50),--/---
	YearOfBirth Datetime,
	Sex bit,
	Address nvarchar(1000),
	Phone varchar(18),
	Mail varchar(50) NOT NULL,
	Charge Money,
	WorkingHours int,
	ChildCode int foreign key references tbl_Child(ChildCode),--
	Status Bit NULL DEFAULT 1,
)
GO
CREATE TABLE tbl_Activities(
	ActiveCode int primary key identity(1,1),
	NameActive Nvarchar(50),----/---
	Rates Money ,
	Status Bit NULL DEFAULT 1,
)
GO
CREATE TABLE tbl_Active_AgeGroup(
	
	GroupAgeCode int foreign key references tbl_AgeGroup (GroupAgeCode ) NOT NULL,
	ActiveCode int foreign key references tbl_Activities(ActiveCode) NOT NULL,
	ActiveGroupCode int identity(1,1) NOT NULL,
	Status Bit NULL DEFAULT 1,
	primary key (GroupAgeCode,ActiveCode),
)
GO

------------------ CREATE PROC Login --------------------------------------------------------

----------- CREATE PROC spGetNameLogin -------
CREATE PROC spGetNameLogin
	@UserName nvarchar(30),
	@Pass nvarchar(30)
AS
	select FullName, [Admin] from tbl_Users where Account = @UserName and Password = @Pass and Status =1   
--execute spGetNameLogin 'Admin','123456'
GO

----------------- CREATE PROC Table tbl_User -----------------------------------------------
------- CREATE PROC spGetUserCodetbl_User ------------------
CREATE PROC spGetUserCode
	@UserName nvarchar(30)
AS
	select UserCode from tbl_Users
	where Account = @UserName

GO
-------- CREATE SPChangePassword---------------------
CREATE PROC spChangePassword 
	@Account nvarchar(30),
	@password nvarchar(100)
AS
	update tbl_Users set Password = @password where 
	Account = @Account
GO
CREATE PROC  spGetLogin
	@UserName nvarchar(30),
	@Pass nvarchar(30)
AS	
	select FullName, Account, Phone, Email, [Address] from tbl_Users
	where Account = @UserName and Password = @Pass and Status =1
--execute spGetLogin 'Admin','123456'
Go
-- --NameofUser,Sex,Address,Birthday,Phone,Email,StartDate,Feedback
--------- CREATE PROC spGetAllUser -------------------
CREATE PROC  spGetAllUsers

AS	
	select UserCode ,FullName,Account,Sex,Address,CONVERT(nvarchar(10),Birthday, 103) as 'Birthday',Phone,Email,
	CONVERT(nvarchar(10), StartDate, 103) as 'StartDate',Feedback from tbl_Users where Status =1

GO
--------- CREATE PROC spInserttbl_User ---------------
CREATE PROC spInserttbl_Users
	
	@FullName nvarchar(100),
	@Account Varchar(100),
	@Password nvarchar(100),
	@Sex Bit,
	@Address Nvarchar(200),
	@Birthday datetime,
	@Phone int,
	@Email Nvarchar(200),
	@StartDate Datetime,
	@Feedback Nvarchar(100), 
	@FunctionCode int
	
AS
	insert into  tbl_Users (FullName,Account,Password,Sex,Address,Birthday,Phone,Email,StartDate,Feedback)
	values (
	@FullName,@Account,
	@Password,@Sex,@Address,@Birthday,@Phone,@Email,@StartDate,@Feedback)

GO
-------	CREATE PROC spUpdateTbl_User ----------------


CREATE PROC spUpdateTbl_Users
	@UserCode int,
	@FullName nvarchar(100),
	@Sex Bit,
	@Address Nvarchar(200),
	@Birthday datetime,
	@Phone int,
	@Email Nvarchar(200),
	@StartDate Datetime,
	@Feedback Nvarchar(100), 
	@FunctionCode int

	
AS
	update tbl_Users
	set FullName = @FullName ,Sex = @Sex,Address = @Address,Birthday = @Birthday,Phone = @Phone,Email = @Email,StartDate = @StartDate, Feedback  = @Feedback 
	where UserCode = @UserCode
GO		
-------	CREATE PROC spDeleteTbl_User ---------------------------
CREATE PROC spDeletetbl_Users
	@UserCode int,
	@Status Bit
AS
	update tbl_Users set Status = @Status
	where  UserCode = @UserCode
GO
-------------- CREATE PROC Table tbl_AgeGroup -------------------------
GO
------- CREATE PROC spGetAgeGroup --------------------------
CREATE PROC spGetAgeGroup
AS
	select GroupAgeCode from tbl_AgeGroup where Status =1
GO
-------- CREATE PROC spGetAllTbl_AgeGroup ----------

GO
CREATE PROC spGetAlltbl_AgeGroup
AS
	select GroupAgeCode,AgeGroup,ChargePerGroup from tbl_AgeGroup 
	where Status = 1
-------- CREATE PROC spInsertTbl_AgeGroup ------------
GO
CREATE PROC spInserttbl_AgeGroup
	@AgeGroup nvarchar(100),
	@ChargePerGroup Money
	
AS
	insert into tbl_AgeGroup (AgeGroup,ChargePerGroup) values( @AgeGroup,@ChargePerGroup)


------ CREATE PROC spUpdateTbl_AgeGroup -------------
GO
CREATE PROC spUpdatetbl_AgeGroup
	@GroupAgeCode int,
	@AgeGroup nvarchar(100),
	@ChargePerGroup Money
As
	update tbl_AgeGroup set 
	AgeGroup = @AgeGroup,ChargePerGroup = @ChargePerGroup
	 where GroupAgeCode = @GroupAgeCode

--- CREATE PROC spDeleteTbl_AgeGroup ---------------
GO
CREATE PROC spDeletetbl_AgeGroup
	@GroupAgeCode int,
	@Status Bit
AS
	update tbl_AgeGroup set Status = @Status
	where GroupAgeCode = @GroupAgeCode

-------------- CREATE PROC tbl_Child ---------------------------------------------------------
GO
--------CREATE PROC spGetTbl_Child ------------
CREATE PROC spGettbl_Child
AS
	select ChildCode, FirstName, LastName, Sex,GroupAgeCode
	from tbl_Child where Status = 1 
GO
--------CREATE PROC spGetPartTbl_Child ------------
CREATE PROC spGetParttbl_Child
AS
	select ChildCode, FirstName, LastName, Sex,GroupAgeCode,
	CONVERT(nvarchar(10), DateOfBirth, 103) as 'DateOfBirth', [Address], ParentName, ParentMobileNumber, 
	CONVERT(nvarchar(10), RegistrationDate, 103) as 'RegistrationDate', DateReceived
	from tbl_Child where Status = 1 
--select * from tbl_Child
Go
--------CREATE PROC spGetAllTbl_Child ------------
CREATE PROC spGetAlltbl_Child
AS
	select ChildCode ,GroupAgeCode ,LastName ,FirstName, CONVERT(nvarchar(10), DateOfBirth, 103) as 'DateOfBirth', 
	Sex, [Address],CurrentMedication, PassIllness, 
	DoctorName, ParentName, ParentWorkNumber, ParentMobileNumber,
	NextOfKinContact, NoteAboutChild, CONVERT(nvarchar(10), RegistrationDate, 103) as 'RegistrationDate', DateReceived,
	ParentEmailAddress from tbl_Child where Status =1

------ CREATE PROC spInsertTbl_Child ------------
GO
CREATE PROC spInserttbl_Child
	
	@GroupAgeCode int,
	@LastName Nvarchar(50),
	@FirstName nvarchar(50),
	@DateOfBirth Datetime,
	@Sex bit,
	@Address nvarchar(100),
	@CurrentMedication nvarchar(30),
	@PassIllness nvarchar(55),
	@DoctorName nvarchar(200),
	@ParentName nvarchar(200),
	@ParentWorkNumber nvarchar(18),
	@ParentMobileNumber  nvarchar(30),
	@NextOfKinContact nvarchar(500),
	@NoteAboutChild nvarchar(300),
	@RegistrationDate datetime,
	@DateReceived datetime,
	@ParentEmailAddress nvarchar(150)
	
AS
	insert into tbl_Child (GroupAgeCode, LastName, FirstName, DateOfBirth, Sex, [Address], CurrentMedication, 
	PassIllness, DoctorName, ParentName, ParentWorkNumber, ParentMobileNumber, NextOfKinContact, NoteAboutChild, RegistrationDate,
	DateReceived, ParentEmailAddress) values (@GroupAgeCode, @LastName, @FirstName, 
	@DateOfBirth, @Sex, @Address, @CurrentMedication, @PassIllness, @DoctorName, @ParentName, 
	@ParentWorkNumber, @ParentMobileNumber, @NextOfKinContact, @NoteAboutChild, @RegistrationDate, 
	@DateReceived, @ParentEmailAddress)
-- execute spInserttbl_Child 1, Nguyen, Van, 1/1/2010, 1, , , , NguynHung, 
----- CREATE PROC spUpdatetTbl_Child------------
GO
CREATE PROC spUpdatettbl_Child
	@ChildCode int,
	@GroupAgeCode int,
	@Address nvarchar(100),
	@CurrentMedication nvarchar(30),
	@PassIllness nvarchar(55),
	@DoctorName nvarchar(200),
	@ParentWorkNumber nvarchar(18),
	@ParentMobileNumber  nvarchar(30),
	@NextOfKinContact nvarchar(500),
	@NoteAboutChild nvarchar(300),
	@DateReceived datetime,
	@ParentEmailAddress nvarchar(150)
	
AS
	update tbl_Child set GroupAgeCode = @GroupAgeCode, [Address] = @Address,
	CurrentMedication = @CurrentMedication,	PassIllness = @PassIllness,DoctorName = @DoctorName,
	ParentWorkNumber = @ParentWorkNumber,ParentMobileNumber = @ParentMobileNumber,
	NextOfKinContact = @NextOfKinContact,NoteAboutChild  = @NoteAboutChild ,DateReceived = @DateReceived,
	ParentEmailAddress = @ParentEmailAddress where ChildCode = @ChildCode


---- CREATE PROC Delete Child ----------------------
GO
CREATE PROC spDeletetbl_Child
	@ChildCode int
As
	update tbl_Child set Status = 0 where 
	ChildCode = @ChildCode
	-- execute spDeleteTbl_Child 1
Go
---- CREATE PROC select Child ----------------------
CREATE PROC spGetAllChild
	@AgeGroupCode int
AS
	select a.ChildCode, a.FirstName, a.LastName, a.ParentName, a.Address from tbl_AgeGroup b inner join tbl_Child a on a.GroupAgeCode = b.GroupAgeCode 
	where b.GroupAgeCode = @AgeGroupCode and b.Status = 1 and a.Status = 1
-------------- CREATE PROC Table tbl_Nanny ---------------------------------------------------
GO
--- CREATE PROC spGetNanny -----------------
CREATE PROC spGetNanny
	@NannyCode int
AS
	select NannyCode, ClassCode,[Name],YearOfBirth, Sex, Address,Phone,Mail,Charge,WorkingHours
	,ChildCode from tbl_Nanny where NannyCode = @NannyCode and Status = 1
GO
--- CREATE PROC spGetAlltbl_Nanny -----------------
CREATE PROC spGetAlltbl_Nanny
AS
	select NannyCode, ClassCode,[Name],YearOfBirth, Sex, Address,Phone,Mail ,Charge,WorkingHours
	,ChildCode from tbl_Nanny where Status = 1

--- CREATE PROC spInsertTbt_Nanny ---------------
GO
CREATE PROC spInserttbl_Nanny
	
	@Class int,
	@Name nvarchar(50),
	@YearOfBirth datetime,
	@Sex bit,
	@Address nvarchar(1000),
	@Phone nvarchar(18),
	@mail nvarchar(50),
	@Charge Money,
	@WorkingHours int,
	@ChildAssigned int

AS
	insert into tbl_Nanny(ClassCode,[Name],YearOfBirth,Sex,Address,Phone,mail,Charge,WorkingHours,ChildCode) 
	values (@Class,@Name,@YearOfBirth,@Sex,@Address,@Phone,@mail,@Charge,@WorkingHours,@ChildAssigned)
	

--- CREATE PROC spUpdateTbt_Nanny -------------------
GO	


CREATE PROC spUpdatetbl_Nanny
	@NannyCode int,
	@ClassCode int,
	@Name nvarchar(50),
	@YearOfBirth datetime,
	@Sex bit,
	@Address nvarchar(1000),
	@Phone nvarchar(18),
	@mail nvarchar(50),
	@Charge Money,
	@WorkingHours int,
	@ChildAssigned int
	
	
AS
	update tbl_Nanny set ClassCode = @ClassCode,[Name] = @Name,
	YearOfBirth = @YearOfBirth,Sex = @Sex,Address = @Address,Phone = @Phone,
	Mail = @Mail,Charge = @Charge,WorkingHours = @WorkingHours ,
	ChildCode = @ChildAssigned  where NannyCode = @NannyCode
GO

--- CREATE PROC spDeletetbt_Nanny -------------
CREATE PROC spDeletetbl_Nanny
	@NannyCode int
AS
	update tbl_Nanny set Status = 0
	where NannyCode = @NannyCode
	
GO
--------------- CREATE PROC Table tbl_Class -------------------------------------------------------------------

--------- CREATE PROC spGetalltbl_Class -------
CREATE PROC spGetalltbl_Class
AS
	select b.ClassCode,b.ClassName,b.GroupAgeCode,a.AgeGroup,b.Note from tbl_Class b inner join tbl_AgeGroup a 
	on b.GroupAgeCode = a.GroupAgeCode where b.Status = 1
	
GO
--------- CREATE PROC spInserttbl_Class --------
CREATE PROC spInserttbl_Class
	@GroupAgeCode int,
	@Note int,
	@ClassName nvarchar(50)
AS
	insert into tbl_Class (GroupAgeCode,Note,ClassName) values (@GroupAgeCode,@Note,@ClassName)
GO
---------- CREATE PROC spIserttbl_Class ---------
CREATE PROC spIserttbl_Class
	@GroupAgeCode int,
	@Note int,
	@ClassName nvarchar(50)
AS
	insert into tbl_Class (GroupAgeCode,Note,ClassName) values (@GroupAgeCode ,@Note ,@ClassName)
GO

----------- CREATE PROC spUpdatetbl_Class -------
CREATE PROC spUpdatetbl_Class
	@ClassCode int,
	@GroupAgeCode int,
	@Note int,
	@ClassName nvarchar(50)
AS
	update tbl_Class set GroupAgeCode = @GroupAgeCode,Note = @Note,ClassName = @ClassName
	where ClassCode = @ClassCode
GO
------------ CREATE PROC spDeletetbl_Class -------
CREATE PROC spDeletetbl_Class
	@ClassCode int,
	@Status Bit
AS
	update tbl_Class set Status = @Status where ClassCode = @ClassCode

 
GO
-------------- CREATE PROC Table Table tbl_Activitie -----------------------------------------------------------
GO	
---  CREATE PROC spGetAlltbl_Activitie ----------
CREATE PROC spGetAlltbl_Activitie	
AS
	select ActiveCode,NameActive,Rates from tbl_Activitie where Status =1
GO
-- CRATE PROC spInserttbl_Activitie -------------
CREATE PROC spInserttbl_Activitie
	@NameActive Nvarchar(50),
	@Rates Money
AS
	insert into  tbl_Activitie (NameActive,Rates) values(@NameActive,@Rates)
GO
-- CRATE PROC spUpdatetbl_Activitie -------------
CREATE PROC spUpdatetbl_Activitie
	@ActiveCode int,
	@NameActive Nvarchar(50),
	@Rates Money
AS
	update tbl_Activitie set NameActive = @NameActive , Rates = @Rates where ActiveCode = @ActiveCode 
-- CREATE PROC spDeletetbl_Activitie -------------
GO
CREATE PROC spDeletetbl_Activitie
	@ActiveCode int,
	@Status Bit
AS
	update tbl_Activitie set Status = @Status where ActiveCode  = @ActiveCode 
GO
---------------------------- CREATE PROC Table tbl_Active_AgeGroup ----------------------------------------
---------- CREATE PROC spGetalltbl_Active_AgeGroup -----------------
CREATE PROC spGetalltbl_Active_AgeGroup
AS
	select ActiveGroupCode,GroupAgeCode,ActiveCode from tbl_Active_AgeGroup where Status =1
GO
----------- CREATE PROC spInserttbl_Active_AgeGroup ----------------
CREATE PROC spInserttbl_Active_AgeGroup
	@GroupAgeCode int,
	@ActiveCode int
AS
	insert into tbl_Active_AgeGroup (GroupAgeCode ,ActiveCode) values (@GroupAgeCode,@ActiveCode)

GO
----------- CREATE PROC spUpdatetbl_Active_AgeGroup -----------------
CREATE PROC  spUpdatetbl_Active_AgeGroup
	@ActiveGroupCode  int,
	@GroupAgeCode int,
	@ActiveCode int
AS
	update tbl_Active_AgeGroup set GroupAgeCode = @GroupAgeCode,ActiveCode = @ActiveCode
	where ActiveGroupCode = @ActiveGroupCode

GO
------------ CREATE PROC spDeletetbl_Active_AgeGroup ----------------

CREATE PROC spDeletetbl_Active_AgeGroup
	@ActiveGroupCode int,
	@Status Bit
AS
	update  tbl_Active_AgeGroup set Status = @Status where ActiveGroupCode = @ActiveGroupCode
Go
------------------------ CREATE PROC SEARCH ----------------------------------------

----- CREATE PROC tbl_User spSearchNameOfUser_tbl_User --------------
CREATE PROC spSearchNameOfUser_tbl_User
	@FullName nvarchar(100)
AS
	select UserCode ,FullName,Account,Password,Sex,Address,CONVERT(nvarchar(10),Birthday, 103) as 'Birthday',Phone,Email,
	CONVERT(nvarchar(10), StartDate, 103) as 'StartDate',Feedback from tbl_Users where FullName like  '%'+ @FullName +''and Status = 1

Go
------- CREATE PROC tbl_User spSearchStartDate_tbl_User -------------
Create PROC spSearchStartDate_tbl_User
	@StartDate datetime
AS
	select UserCode ,FullName,Account,Sex,Address,CONVERT(nvarchar(10),Birthday, 103) as 'Birthday',Phone,Email,
	CONVERT(nvarchar(10), StartDate, 103) as 'StartDate',Feedback from tbl_Users where StartDate =@StartDate and Status = 1 ORDER BY StartDate DESC
Go
--------CREATE PROC spSearchAccounttbl_User ---------------- 
CREATE PROC spSearchAccounttbl_User
	@Account Varchar(100)
AS
	select UserCode ,FullName,Account,Sex,Address,CONVERT(nvarchar(10),Birthday, 103) as 'Birthday',Phone,Email,
	CONVERT(nvarchar(10), StartDate, 103) as 'StartDate',Feedback from tbl_Users where Account like '%'+@Account+'' and Status = 1 ORDER BY StartDate 

Go
------ spSortNameOfUsertbl_User ---------------------------
CREATE PROC spSortNameOfUsertbl_User
	
AS
	select UserCode ,FullName,Account,Sex,Address,CONVERT(nvarchar(10),Birthday, 103) as 'Birthday',Phone,Email,
	CONVERT(nvarchar(10), StartDate, 103) as 'StartDate',Feedback from tbl_Users where Status = 1 ORDER BY FullName 
Go
-------------------------- CREATE PROC SEARCH tbl_Child -------------------------------
---------  spSearchGroupAgeCodetbl_Child ------------
CREATE PROC spSearchGroupAgeCodetbl_Child
	@GroupAgeCode int
AS
	select ChildCode,GroupAgeCode,LastName,FirstName,
	CONVERT(nvarchar(10), DateOfBirth, 103) as 'DateOfBirth',CurrentMedication,PassIllness
	,DoctorName,ParentName,ParentWorkNumber,ParentMobileNumber,
	NextOfKinContact,NoteAboutChild,CONVERT(nvarchar(10), RegistrationDate, 103) as 'RegistrationDate',DateReceived,
	ParentEmailAddress from tbl_Child where GroupAgeCode = @GroupAgeCode and Status =1 
GO
------------ spSearchFirstNametbl_Child------------------ 
CREATE PROC spSearchFirstNametbl_Child
	@FirstName nvarchar(50)
AS
	select ChildCode,GroupAgeCode,LastName,FirstName
	,CONVERT(nvarchar(10), DateOfBirth, 103) as 'DateOfBirth',CurrentMedication,PassIllness
	,DoctorName,ParentName,ParentWorkNumber,ParentMobileNumber,
	NextOfKinContact,NoteAboutChild,CONVERT(nvarchar(10), RegistrationDate, 103) as 'RegistrationDate',DateReceived,
	ParentEmailAddress from tbl_Child where FirstName like '%'+ @FirstName+'' and Status =1 
----------------- spSearchRegistrationDatetbl_Child --------------
Go
CREATE PROC spSearchRegistrationDatetbl_Child
	@RegistrationDate datetime
AS
	select ChildCode,GroupAgeCode,LastName,FirstName
	,CONVERT(nvarchar(10), DateOfBirth, 103) as 'DateOfBirth',CurrentMedication,PassIllness
	,DoctorName,ParentName,ParentWorkNumber,ParentMobileNumber,
	NextOfKinContact,NoteAboutChild,CONVERT(nvarchar(10), RegistrationDate, 103) as 'RegistrationDate',DateReceived,
	ParentEmailAddress from tbl_Child where RegistrationDate = @RegistrationDate and Status =1 


Go
----------------- spSearchDateReceivedtbl_Child ------------------
CREATE PROC spSearchDateReceivedtbl_Child
	@DateReceived datetime
AS
	select ChildCode,GroupAgeCode,LastName,FirstName
	,CONVERT(nvarchar(10), DateOfBirth, 103) as 'DateOfBirth',CurrentMedication,PassIllness
	,DoctorName,ParentName,ParentWorkNumber,ParentMobileNumber,
	NextOfKinContact,NoteAboutChild,CONVERT(nvarchar(10), RegistrationDate, 103) as 'RegistrationDate',DateReceived,
	ParentEmailAddress from tbl_Child where DateReceived = @DateReceived and Status =1 
	
Go
----------------- spSearchChildCodetbl_Child ------------------
CREATE PROC spSearchChilCodetbl_Child
	@ChildCode int
AS
	select * from tbl_Child where ChildCode = @ChildCode and Status =1 
Go
----------------- spSortFirstNametbl_Child ----------------
CREATE PROC spSortFirstNametbl_Child

AS
	select ChildCode,GroupAgeCode,LastName,FirstName
	,CONVERT(nvarchar(10), DateOfBirth, 103) as 'DateOfBirth',CurrentMedication,PassIllness
	,DoctorName,ParentName,ParentWorkNumber,ParentMobileNumber,
	NextOfKinContact,NoteAboutChild,CONVERT(nvarchar(10), RegistrationDate, 103) as 'RegistrationDate',DateReceived,
	ParentEmailAddress from tbl_Child where Status =1 order by FirstName  
Go
----------------- spSortRegistrationDatetbl_Child ----------------
CREATE PROC spSortRegistrationDatetbl_Child

AS
	select ChildCode,GroupAgeCode,LastName,FirstName
	,CONVERT(nvarchar(10), DateOfBirth, 103) as 'DateOfBirth',CurrentMedication,PassIllness
	,DoctorName,ParentName,ParentWorkNumber,ParentMobileNumber,
	NextOfKinContact,NoteAboutChild,CONVERT(nvarchar(10), RegistrationDate, 103) as 'RegistrationDate',DateReceived,
	ParentEmailAddress from tbl_Child where Status =1 order by RegistrationDate

Go
--------------------- spSortDateReceivedtbl_Child -------------
CREATE PROC spSortDateReceivedtbl_Child

AS
	select ChildCode,GroupAgeCode,LastName,FirstName
	,CONVERT(nvarchar(10), DateOfBirth, 103) as 'DateOfBirth',CurrentMedication,PassIllness
	,DoctorName,ParentName,ParentWorkNumber,ParentMobileNumber,
	NextOfKinContact,NoteAboutChild,CONVERT(nvarchar(10), RegistrationDate, 103) as 'RegistrationDate',DateReceived,
	ParentEmailAddress from tbl_Child where Status =1 order by DateReceived
Go
------------------------------- CREATE PROC TBL_Nanny----------------------------------
------ CRATE PROC spSearch[Name]tbl_Child ------------
CREATE PROC spSearchNametbl_Nanny
	@Name Varchar(50)
AS
	select NannyCode,Name,YearOfBirth ,Address,Phone,Mail ,Charge,WorkingHours,ChildCode from tbl_Nanny where Name like '%' +@Name+'' and Status = 1
Go
------ spSearchChildAssignedtbl_Child ---------------
CREATE PROC spSearchChildAssignedtbl_Nanny
	@ChildAssigned int
AS
	select NannyCode,[Name],YearOfBirth ,Address,Phone,Mail ,Charge,WorkingHours,ChildCode from tbl_Nanny where ChildCode  = @ChildAssigned and Status = 1
Go
------spSort[Name]tbl_Child ------------
CREATE PROC spSortNametbl_Nanny
	
AS
	select NannyCode,Name,YearOfBirth ,Address,Phone,Mail ,Charge,WorkingHours,ChildCode from tbl_Nanny where  Status = 1 order by Name	

Go
------------------------------ CRATE PROC TBL_CLASS ----------------------------
------ CREATE PROC	spSearchClassNametbl_Class -----------
CREATE PROC	spSearchClassNametbl_Class
	@ClassName nvarchar(50)
AS
	select ClassCode,GroupAgeCode,Note,ClassName from tbl_Class where ClassName like '%'+@ClassName +''  and Status = 1

Go
------ CREATE PROC	spSearchClassNametbl_Class -----------
CREATE PROC	spSearchClassCodetbl_Class
	@ClassCode int
AS
	select ClassCode,GroupAgeCode,Note,ClassName from tbl_Class where ClassCode = @ClassCode and Status = 1

Go

------ CREATE PROC spSortClassNametbl_Class ---------
CREATE PROC spSortClassNametbl_Class
	
AS
	select ClassCode,GroupAgeCode,Note,ClassName from tbl_Class where  Status = 1 order by ClassName 
Go
-------------------- CREATE PROC Table Activities --------------------------------
------ CREATE PROC spSearchNameActivetbl_Activities ------------
CREATE PROC spSearchNameActivetbl_Activities
	@Activities Nvarchar(50)
AS
	select ActiveCode,NameActive,Rates from tbl_Activitie where NameActive like '%'+@Activities+''and Status =1
------ spSortNameActivetbl_Activities ---------
Go
CREATE PROC spSortNameActivetbl_Activities
	
AS
	select ActiveCode,NameActive,Rates from tbl_Activitie where Status =1 order by NameActive

