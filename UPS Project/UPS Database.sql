-- Author @Ahsan Beshal
-- This is a database for UPS.
-- Date: 06/25/17

drop table if exists shipper;
drop table if exists tracking;
drop table if exists receiver;
drop table if exists cities_coordinates;
drop table if exists cities;

create table cities (

	zipcode int primary key,
	cityname text

);

create table cities_coordinates (

	zipcode int references cities(zipcode),
	location_x int,
	location_y int,
	primary key(zipcode)
	
);

create table shipper (
	
	shipper_id char(6),
	shipper_lastname text,
	shipper_firstname text,
	shipper_phone_num varchar(12),
	shipper_cityname text,
	primary key(shipper_id)

);

create table receiver (
	
	zipcode int references cities(zipcode),
	receiver_id char(4),
	receiver_lastname text,
	receiver_firstname text,
	receiver_phone_num varchar(12),
	receiver_address varchar,
	receiver_location_x int,
	receiver_location_y int,
	primary key(receiver_id)

);

create table tracking (
	
	receiver_id char(4) references receiver(receiver_id),
	tracking_num varchar(23),
	instructions text,
	primary key(receiver_id)
	
);

insert into cities(zipcode, cityname) values (12502, 'Ancram');
insert into cities(zipcode, cityname) values (12017, 'Austerlitz');
insert into cities(zipcode, cityname) values (12037, 'Chatham');
insert into cities(zipcode, cityname) values (12050, 'Columbiaville');
insert into cities(zipcode, cityname) values (12526, 'Germantown');
insert into cities(zipcode, cityname) values (12075, 'Ghent');
insert into cities(zipcode, cityname) values (12529, 'Hillsdale');
insert into cities(zipcode, cityname) values (12530, 'Hollowville');
insert into cities(zipcode, cityname) values (12171, 'Stockport');
insert into cities(zipcode, cityname) values (12173, 'Stuyvesant');

insert into cities_coordinates(zipcode, location_x, location_y) values (12502, 46, 85);
insert into cities_coordinates(zipcode, location_x, location_y) values (12017, 93, 52);
insert into cities_coordinates(zipcode, location_x, location_y) values (12037, 125, 39);
insert into cities_coordinates(zipcode, location_x, location_y) values (12050, 120, 767);
insert into cities_coordinates(zipcode, location_x, location_y) values (12526, 156, 269);
insert into cities_coordinates(zipcode, location_x, location_y) values (12075, 456,  90);
insert into cities_coordinates(zipcode, location_x, location_y) values (12529, 189, 98);
insert into cities_coordinates(zipcode, location_x, location_y) values (12530, 167, 385);
insert into cities_coordinates(zipcode, location_x, location_y) values (12171, 495, 94);
insert into cities_coordinates(zipcode, location_x, location_y) values (12173, 384, 678);

insert into shipper(shipper_id, shipper_lastname, shipper_firstname, shipper_phone_num, shipper_cityname) values ('s10000', 'John', 'Abruzzi', '518-876-9806', 'Bakersfield, CA');
insert into shipper(shipper_id, shipper_lastname, shipper_firstname, shipper_phone_num, shipper_cityname) values ('s20000', 'Milo', 'Okize', '315-534-1286', 'Columbus, OH');
insert into shipper(shipper_id, shipper_lastname, shipper_firstname, shipper_phone_num, shipper_cityname) values ('s30000', 'Misty', 'Reane', '931-213-5462', 'Los Angeles, CA');
insert into shipper(shipper_id, shipper_lastname, shipper_firstname, shipper_phone_num, shipper_cityname) values ('s40000', 'Tara', 'Ortiz', '845-778-0921', 'Jacksonville FL');
insert into shipper(shipper_id, shipper_lastname, shipper_firstname, shipper_phone_num, shipper_cityname) values ('s50000', 'Syed', 'Rana', '355-958-0045', 'Atlanta, GA');

insert into receiver(zipcode, receiver_id, receiver_lastname, receiver_firstname, receiver_phone_num, receiver_address, receiver_location_x, receiver_location_y) values (12502, 'r001', 'Griffin', 'Tyler', '518-876-9806', '4518 Jadewood Farms, Ancram, NY', 41, 78);
insert into receiver(zipcode, receiver_id, receiver_lastname, receiver_firstname, receiver_phone_num, receiver_address, receiver_location_x, receiver_location_y) values (12502, 'r002', 'Mali', 'Wavy', '518-933-1246', '893 Renovate Boulevard, Ancram, NY', 49, 91);
insert into receiver(zipcode, receiver_id, receiver_lastname, receiver_firstname, receiver_phone_num, receiver_address, receiver_location_x, receiver_location_y) values (12502, 'r003', 'Pearson', 'Dale', '518-345-0003', '1601 Renwick Drive, Ancram, NY', 49, 81);
insert into receiver(zipcode, receiver_id, receiver_lastname, receiver_firstname, receiver_phone_num, receiver_address, receiver_location_x, receiver_location_y) values (12017, 'r004', 'Howard', 'Virginia', '518-345-9122', '3686 Peck Street, Austerlitz, NY', 86, 43);
insert into receiver(zipcode, receiver_id, receiver_lastname, receiver_firstname, receiver_phone_num, receiver_address, receiver_location_x, receiver_location_y) values (12017, 'r005', 'Brousseau','Carla', '518-828-1739', '3894 Tuna Street, Austerlitz, NY', 89, 48);
insert into receiver(zipcode, receiver_id, receiver_lastname, receiver_firstname, receiver_phone_num, receiver_address, receiver_location_x, receiver_location_y) values (12017, 'r006', 'Dixon', 'Laurence', '518-876-1845', '4150 Oak Drive, Austerlitz, NY', 81, 59);
insert into receiver(zipcode, receiver_id, receiver_lastname, receiver_firstname, receiver_phone_num, receiver_address, receiver_location_x, receiver_location_y) values (12037, 'r007', 'Shelton', 'Gabriel',  '518-345-6634', '1477 Woodrow Way, Chatham, NY', 122, 42);
insert into receiver(zipcode, receiver_id, receiver_lastname, receiver_firstname, receiver_phone_num, receiver_address, receiver_location_x, receiver_location_y) values (12037, 'r008', 'Harper', 'Thomas', '518-325-7622', '4921 Little Street, Chatham, NY', 120, 50);
insert into receiver(zipcode, receiver_id, receiver_lastname, receiver_firstname, receiver_phone_num, receiver_address, receiver_location_x, receiver_location_y) values (12050, 'r009', 'Brandt', 'Linda', '518-828-7736', '4011 Harron Drive, Columbiaville, NY', 119, 778);
insert into receiver(zipcode, receiver_id, receiver_lastname, receiver_firstname, receiver_phone_num, receiver_address, receiver_location_x, receiver_location_y) values (12526, 'r010', 'Lovato', 'Richard', '518-876-1130', '3331 Tipple Road, Germantown, NY', 159, 289);
insert into receiver(zipcode, receiver_id, receiver_lastname, receiver_firstname, receiver_phone_num, receiver_address, receiver_location_x, receiver_location_y) values (12075, 'r011', 'Wynn', 'Eric', '518-234-9236', '2415 Wood Duck Drive, Ghent, NY', 489, 84);
insert into receiver(zipcode, receiver_id, receiver_lastname, receiver_firstname, receiver_phone_num, receiver_address, receiver_location_x, receiver_location_y) values (12530, 'r012', 'Judd', 'Robert', '518-984-1125', '2924 Cinnamon Lane, Hollowville, NY', 164, 395);
insert into receiver(zipcode, receiver_id, receiver_lastname, receiver_firstname, receiver_phone_num, receiver_address, receiver_location_x, receiver_location_y) values (12171, 'r013', 'Evans', 'Micheal', '518-245-8994', '3001 East Avenue, Stockport, NY', 486, 700);
insert into receiver(zipcode, receiver_id, receiver_lastname, receiver_firstname, receiver_phone_num, receiver_address, receiver_location_x, receiver_location_y) values (12173, 'r014', 'Stanton', 'Carl', '518-389-3097', '3494 Traders Alley, Stuyvesant, NY', 393, 686);

insert into tracking(receiver_id, tracking_num, instructions) values ('r001', '1Z S10 000 12 3845 8596', 'Adult signature required.');
insert into tracking(receiver_id, tracking_num, instructions) values ('r002', '1Z S10 000 AA 4859 4800', 'Signature required.');
insert into tracking(receiver_id, tracking_num, instructions) values ('r003', '1Z S20 000 13 1204 9952', 'Leave it on front porch.');
insert into tracking(receiver_id, tracking_num, instructions) values ('r004', '1Z S10 000 01 5893 0944', 'Leave it on front porch.');
insert into tracking(receiver_id, tracking_num, instructions) values ('r005', '1Z S30 000 0A 3840 1123', 'Leave it on back porch.');
insert into tracking(receiver_id, tracking_num, instructions) values ('r006', '1Z S40 000 04 4842 0942', 'Leave it near mailbox.');
insert into tracking(receiver_id, tracking_num, instructions) values ('r007', '1Z S30 000 CA 1394 3588', 'Leave it near back door.');
insert into tracking(receiver_id, tracking_num, instructions) values ('r008', '1Z S50 000 AA 4879 4080', 'Signature required.');
insert into tracking(receiver_id, tracking_num, instructions) values ('r009', '1Z S20 000 13 4859 2403', 'Leave it near side door.');
insert into tracking(receiver_id, tracking_num, instructions) values ('r010', '1Z S30 000 01 5813 4985', 'Leave it near front door.');
insert into tracking(receiver_id, tracking_num, instructions) values ('r011', '1Z S30 000 09 3810 1123', 'Adult signature required.');
insert into tracking(receiver_id, tracking_num, instructions) values ('r012', '1Z S40 000 A2 2903 1110', 'Leave it near mailbox.');
insert into tracking(receiver_id, tracking_num, instructions) values ('r013', '1Z S20 000 CA 8547 3938', 'Signature required.');
insert into tracking(receiver_id, tracking_num, instructions) values ('r014', '1Z S20 000 CA 3457 1110', 'Signature required.');

-- Using subquery to find the min
-- select receiver_id, receiver_lastname, receiver_firstname, receiver_phone_num, receiver_address, receiver_location_x, receiver_location_y from receiver 
-- 	where receiver_location_x + receiver_location_y in (select min(receiver_location_x + receiver_location_y) as combined from receiver where zipcode = 12173)

select receiver_id, receiver_lastname, receiver_firstname, receiver_phone_num, receiver_address, receiver_location_x, receiver_location_y, 
	receiver_location_x + receiver_location_y as combined_receiver_location_x_y from receiver where zipcode = 12502
