## INTRODUCTION
This project aimed to get deep insights into managing relational databases, and manipulating the data contained in them using various DDL and DML commands. The IDE and database management system used to implement this project is pgadmin4 and PostgreSQL. The queries used in this project range from creating, inserting, deleting, and updating data to joining two tables or rows, or columns to retrieve the desired outcome.

## Quick Start
-Import data file<br>
-Plan and execute queries based on questions<br>

## SQL Queries
#### -Create Tables(DDL): <br>
1. ##### Create table cd.members
   -CREATE TABLE members (<br>
   memid integer NOT NULL,<br>
   surname character varying(200) NOT NULL,<br>
   firstname character varying(200) NOT NULL,<br>
   address character varying(300) NOT NULL,<br>
   zipcode integer NOT NULL,<br>
   telephone character varying(20) NOT NULL,<br>
   recommendedby integer,<br>
   joindate timestamp without time zone NOT NULL<br>
   );<br>
2. ##### Create table cd.bookings
   -CREATE TABLE bookings (<br>
   bookid integer NOT NULL,<br>
   facid integer NOT NULL,<br>
   memid integer NOT NULL,<br>
   starttime timestamp without time zone NOT NULL,<br>
   slots integer NOT NULL<br>
   );<br>
3. ##### Create table cd.facilities
   -CREATE TABLE facilities (<br>
   facid integer NOT NULL,<br>
   name character varying(100) NOT NULL,<br>
   membercost numeric NOT NULL,<br>
   guestcost numeric NOT NULL,<br>
   initialoutlay numeric NOT NULL,<br>
   monthlymaintenance numeric NOT NULL<br>
   );<br>

#### -DML queries solutions:<br>

Question 1: The club is adding a new facility - a spa. Use the values:
   facid: 9, Name: 'Spa', membercost: 20, guestcost: 30, initialoutlay: 100000, monthlymaintenance: 800.<br>
      Answer: <br> 
```
Insert into cd.facilities(
    facid, name, membercost, guestcost,
    initialoutlay, monthlymaintenance
)
values
    (9, 'Spa', 20, 30, 100000, 800);
```

Question 2:Let's try adding the spa to the facilities table again. This time, though, we want to automatically generate the value for the next facid, rather than specifying it as a constant. Use the following values for everything else:Name: 'Spa', membercost: 20, guestcost: 30, initialoutlay: 100000, monthlymaintenance: 800.<br>
Answer:<br>
```
Insert into cd.facilities(
facid, name, membercost, guestcost, 
initialoutlay, monthlymaintenance
)
values
(
(
select
max(facid)
from
cd.facilities
)+ 1,
'Spa',20,30,100000,800
);
```
Question 3:We made a mistake when entering the data for the second tennis court. The initial outlay was 10000 rather than 8000: you need to alter the data to fix the error.<br>
Answer:<br>
```
UPDATE
cd.facilities
SET
"initialoutlay" = 10000
where
facid = 1;
```

Question 4:We want to alter the price of the second tennis court so that it costs 10% more than the first one. Try to do this without using constant values for the prices, so that we can reuse the statement if we want to.<br>
Answer:<br>
```
UPDATE
cd.facilities
set
membercost = membercost +(
(
select
membercost
from
cd.facilities
where
facid = 0
)* 0.1
),
guestcost = guestcost +(
(
select
guestcost
from
cd.facilities
where
facid = 0
)* 0.1
)
where
facid = 1;
```
Question 5: delete all bookings from the cd.bookings table <br>
Answer:<br>
```
delete from
    cd.bookings;
```

Question 6:Remove member 37, who has never made a booking, from database<br>
Answer:<br>
```
delete from
    cd.members
where
        memid = 37;
```
Question 7:produce a list of facilities that charge a fee to members, and that fee is less than 1/50th of the monthly maintenance cost<br>
Answer:<br>
```
select
facid,
name,
membercost,
monthlymaintenance
from
cd.facilities
where
membercost > 0
and (
membercost < 0.02 * monthlymaintenance
);
```
Question 8:Produce a list of all facilities with the word 'Tennis' in their name<br>
Answer:<br>
```
Select
*
from
cd.facilities
where
name like '%Tennis%';
```
Question 9:Retrieve the details of facilities with ID 1 and 5 without using OR operator.<br>
Answer:<br>
```
select
*
from
cd.facilities
where
facid in(1, 5);
```

Question 10:Produce a list of members who joined after the start of September 2012? Return the memid, surname, firstname, and joindate of the members<br>
Answer:<br>
```
select
memid,
surname,
firstname,
joindate
from
cd.members
where
joindate >= DATE ('2012-09-01');
```
Question 11:Produce a combined list of all surnames and all facility names.<br>
Answer:<br>
```
select
surname
from
cd.members
union
select
name
from
cd.facilities;
```
Question 12: produce a list of the start times for bookings by members named 'David Farrell'.<br>
Answer:<br>
```
select
    starttime
from
    cd.bookings
        INNER JOIN cd.members ON cd.bookings.memid = cd.members.memid
where
        cd.members.firstname = 'David'
  and cd.members.surname = 'Farrell';
```
Question 13:Produce a list of the start times for bookings for tennis courts, for the date '2012-09-21'. Return a list of start time and facility name pairings, ordered by the time.<br>
Answer:<br>
```
select
    cd.bookings.starttime as start,
    cd.facilities.name
from
    cd.bookings
        INNER JOIN cd.facilities ON cd.bookings.facid = cd.facilities.facid
where
        cd.bookings.starttime >= '2012-09-21'
  and cd.bookings.starttime < '2012-09-22'
  and cd.facilities.name in(
                            'Tennis Court 1', 'Tennis Court 2'
    )
order by
    cd.bookings.starttime;

```
Question 14:Output a list of all members, including the individual who recommended them (if any).Ensure that results are ordered by (surname, firstname).<br>
Answer:<br>
```
select
    mem.firstname as memfname,
    mem.surname as memsname,
    ref.firstname as recfname,
    ref.surname as recsname
from
    cd.members mem
        left outer Join cd.members ref ON ref.memid = mem.recommendedby
order by
    memsname,
    memfname;
```
Question 15:Output a list of all members who have recommended another member.Ensure that there are no duplicates in the list, and that results are ordered by (surname, firstname)<br>
Answer:<br>
```
select
    DISTINCT ref.firstname,
             ref.surname
from
    cd.members mem
        inner join cd.members ref ON ref.memid = mem.recommendedby
order by
    ref.surname,
    ref.firstname;
```
Question 16: Output a list of all members, including the individual who recommended them (if any), without using any joins.Ensure that there are no duplicates in the list, and that each firstname + surname pairing is formatted as a column and ordered.<br>
Answer:<br>
```
select
    distinct mem.firstname || ' ' || mem.surname as member,
             (
                 select
                         ref.firstname || ' ' || ref.surname as recommender
                 from
                     cd.members ref
                 where
                         ref.memid = mem.recommendedby
             )
from
    cd.members mem
order by
    member;
```

Question 17:Produce a count of the number of recommendations each member has made. Order by member ID.<br>
Answer:<br>
```
select
    recommendedby,
    COUNT(*)
from
    cd.members
where
    recommendedby is not null
group by
    (recommendedby)
order by
    recommendedby;
```

Question 18:Produce a list of the total number of slots booked per facility.<br>
Answer:<br>
```
select
    facid,
    sum(slots) as "Total slots"
from
    cd.bookings
where
    facid is not null
group by
    (facid)
order by
    facid;
```

Question 19:Produce a list of the total number of slots booked per facility in the month of September 2012. Produce an output table consisting of facility id and slots, sorted by the number of slots.<br>
Answer:<br>
```
select
    facid,
    sum(slots) as "Total Slots"
from
    cd.bookings
where
        starttime >= '2012-09-01'
  and starttime <= '2012-10-01'
group by
    (facid)
order by
    sum(slots);
```

Question 20:Produce a list of the total number of slots booked per facility per month in the year of 2012. Produce an output table consisting of facility id and slots, sorted by the id and month.<br>
Answer:<br>
```
select
    facid,
    EXTRACT(
            Month
            from
            starttime
        ) as month,
  sum(slots) as "Total slots"
from
    cd.bookings
where
    EXTRACT(
    Year
    from
    starttime
    )= 2012
group by
    facid,
    month
order by
    facid,
    month;
```

Question 21:Find the total number of members (including guests) who have made at least one booking.<br>
Answer:<br>
```
select
    count(distinct memid)
from
    cd.bookings;
```

Question 22:Produce a list of each member name, id, and their first booking after September 1st 2012. Order by member ID.<br>
Answer:<br>
```
select
    mem.surname,
    mem.firstname,
    mem.memid,
    min(b.starttime) as starttime
from
    cd.bookings b
        inner join cd.members mem ON b.memid = mem.memid
where
        starttime >= '2012-09-01'
group by
    mem.surname,
    mem.firstname,
    mem.memid
order by
    memid;
```

Question 23:Produce a list of member names, with each row containing the total member count. Order by join date, and include guest members.<br>
Answer:<br>
```
Select
    (
        select
            count(*)
        from
            cd.members
    ),
    firstname,
    surname
from
    cd.members
order by
    joindate;
```
Question 24:Produce a monotonically increasing numbered list of members (including guests), ordered by their date of joining<br>
Answer:<br>
```
select row_number() over(), firstname, surname
from cd.members
order by joindate
```
Question 25:Output the facility id that has the highest number of slots booked. Ensure that in the event of a tie, all tieing results get output.<br>
Answer:<br>
```
select facid, total from (
                             select facid, sum(slots) total, rank() over (order by sum(slots) desc) rank
                             from cd.bookings
                             group by facid
                         ) as ranked
where rank = 1

```
Question 26:Output the names of all members, formatted as 'Surname, Firstname'.<br>
Answer:<br>
```
select
        surname || ',' || ' ' || firstname as name
from
    cd.members;
```
Question 27:find all the telephone numbers that contain parentheses, returning the member ID and telephone number sorted by member ID.<br>
Answer:<br>
```
select
    memid,
    telephone
from
    cd.members
where
    telephone ~ '[()]'
order by
    memid;
```
Question 28:produce a count of how many members you have whose surname starts with each letter of the alphabet. Sort by the letter, and don't worry about printing out a letter if the count is 0.<br>
Answer:<br>
```
select
    substring(surname, 1, 1) as letter,
    count(*)
from
    cd.members
group by
    (
        substring(surname, 1, 1)
        )
order by
    letter;
```

