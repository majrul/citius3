create table items (item_id integer not null,name varchar(75),description varchar(75),initialPrice double precision,reservePrice double precision,validTill date,primary key (item_id));

create table categories (category_id integer not null,parent_category_id integer,name varchar(75),primary key (category_id));

create table categories_items (item_id integer not null,category_id integer not null,primary key (category_id, item_id));

create table bids (bid_id integer not null,item_id integer not null,member_id integer not null,amount double precision default 0,primary key (bid_id));

create table members (member_id integer not null,name varchar(75),primary key (member_id));

insert into members values(1, 'majrul');
insert into members values(2, 'bill');
insert into members values(3, 'james');
insert into members values(4, 'ed');

insert into categories(category_id, name) values(1, 'ELECTRONICS');
insert into categories(category_id, name) values(2, 'CARS');

insert into categories(category_id, name, parent_category_id) values(3, 'COMPUTERS', 1);
insert into categories(category_id, name, parent_category_id) values(4, 'MOBILES', 1);

insert into categories(category_id, name, parent_category_id) values(5, 'MARUTI', 2);
insert into categories(category_id, name, parent_category_id) values(6, 'HYUNDAI', 2);
insert into categories(category_id, name, parent_category_id) values(7, 'CHEVROLET', 2);

insert into categories(category_id, name, parent_category_id) values(8, 'LAPTOP', 3);
insert into categories(category_id, name, parent_category_id) values(9, 'PC', 3);

insert into categories(category_id, name, parent_category_id) values(10, 'NOKIA', 4);
insert into categories(category_id, name, parent_category_id) values(11, 'SONY', 4);
insert into categories(category_id, name, parent_category_id) values(12, 'SAMSUNG', 4);

insert into items values(1, 'MARUTI 800', '', 125000, 150000, '2011-10-15');
insert into items values(2, 'MARUTI ESTEEM', '', 500000, 600000, '2011-10-20');
insert into items values(3, 'HYUNDAI ACCENT', '', 750000, '175000', '2011-10-20');
insert into items values(4, 'HYUANDAI SANTRO', '', 800000, 900000, '2011-10-25');
insert into items values(5, 'CHEVROLET OPTRA', '', 1200000, 1300000, '2011-10-30');
insert into items values(6, 'TOYOTA CAMRY', '', 1500000, 1600000, '2011-10-10');
insert into items values(7, 'SAHARA LAPTOP', '', 25000, 30000, '2011-10-15');
insert into items values(8, 'DELL INSPIRON', '', 450000, 50000, '2011-10-25');
insert into items values(9, 'SONY VAIO', '', 60000, 70000, '2011-10-30');
insert into items values(10, 'HCL PC', '', 20000, 22000, '2011-10-20');
insert into items values(11, 'WIPRO DESKTOP PC', '', 25000, 27000, '2011-10-20');
insert into items values(12, 'ACER WORKSTATION', '', 25000, 28000, '2011-10-20');
insert into items values(13, 'NOKIA 6600', '', 5000, 6000, '2011-10-15');
insert into items values(14, 'SONY W50I', '', 6000, 6500, '2011-10-25');
insert into items values(15, 'SAMSUNG D50', '', 7000, 7500, '2011-10-30');
insert into items values(16, 'IBM MOUSE', '', 250, 300, '2011-10-30');
insert into items values(17, 'MARUTI SWIFT', '', 125000, 150000, '2011-10-15');
insert into items values(18, 'MARUTI DZIRE', '', 500000, 600000, '2011-10-20');
insert into items values(19, 'HYUNDAI I10', '', 750000, '175000', '2011-10-20');
insert into items values(20, 'HYUANDAI I20', '', 800000, 900000, '2011-10-25');
insert into items values(21, 'CHEVROLET CRUZE', '', 1200000, 1300000, '2011-10-30');
insert into items values(22, 'TOYOTA COROLLA', '', 1500000, 1600000, '2011-10-10');
insert into items values(23, 'ASUS LAPTOP', '', 25000, 30000, '2011-10-15');
insert into items values(24, 'DELL 15R', '', 450000, 50000, '2011-10-25');
insert into items values(25, 'MSI NETBOOK', '', 60000, 70000, '2011-10-30');
insert into items values(26, 'HCL ME LAPTOP', '', 20000, 22000, '2011-10-20');
insert into items values(27, 'APPPLE MACBOOK', '', 25000, 27000, '2011-10-20');
insert into items values(28, 'APPLE IPHONE', '', 25000, 28000, '2011-10-20');
insert into items values(29, 'NOKIA 68200', '', 5000, 6000, '2011-10-15');
insert into items values(30, 'SONY VIVAZ', '', 6000, 6500, '2011-10-25');
insert into items values(31, 'SAMSUNG GALAXY', '', 7000, 7500, '2011-10-30');
insert into items values(32, 'HP MOUSE', '', 250, 300, '2011-10-30');

insert into categories_items values(1, 5);
insert into categories_items values(2, 5);

insert into categories_items values(3, 6);
insert into categories_items values(4, 6);

insert into categories_items values(5, 7);
insert into categories_items values(6, 7);

insert into categories_items values(7, 8);
insert into categories_items values(8, 8);
insert into categories_items values(9, 8);

insert into categories_items values(10, 9);
insert into categories_items values(11, 9);
insert into categories_items values(12, 9);

insert into categories_items values(13, 10);
insert into categories_items values(14, 11);
insert into categories_items values(15, 12);

insert into bids values(1, 1, 1, 130000);
insert into bids values(2, 1, 1, 140000);
insert into bids values(3, 1, 2, 150000);
insert into bids values(4, 1, 2, 160000);

insert into bids values(5, 7, 3, 28000);
insert into bids values(6, 7, 3, 29000);
insert into bids values(7, 7, 1, 30000);
insert into bids values(8, 7, 1, 37500);
insert into bids values(9, 7, 2, 32000);
insert into bids values(10, 7, 2, 33000);
