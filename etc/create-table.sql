create table book_type(
    tid int primary key auto_increment,
    tname varchar(200) not null
);

create table book(
    bid int primary key auto_increment,
    bname varchar(200) not null,
    author varchar(200) not null,
    short_intro varchar(200),
    intro TEXT,
    cover_url varchar(200),
    tid int not null,
    constraint FK_book_tid foreign key(tid) references book_type(tid)
);

create table account(
    aid int primary key auto_increment,
    aname varchar(200) not null,
    pwd varchar(100) not null,
    email varchar(200) not null unique
);

create table bookshell(
    bsid int primary key auto_increment,
    aid int not null,
    bid int not null,
    constraint FK_bookshell_aid foreign key(aid) references account(aid),
    constraint FK_bookshell_bid foreign key(bid) references book(bid)
);
