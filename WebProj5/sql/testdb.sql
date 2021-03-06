/*DBConnectorクラスで設定したデータベース名と合わせる*/
drop database if exists testdb1;
create database testdb1;
use testdb1;
/*もし同名のデータベースが存在すれば削除する。
 * 指定した名前でデータベースを作成する。
 * 作成したデータベースに移動する。*/

/*「user」がテーブル名となる*/
create table users(
user_id int primary key auto_increment,
user_name varchar(255),
password varchar(255)
);

/*「user」テーブルにデータを追加する。*/
insert into users values(1,"taro","123");
insert into users values(2,"jiro","456");
insert into users values(3,"hanako","789");

create table inquiry(
name varchar(255),
qtype varchar(255),
body varchar(255)
);