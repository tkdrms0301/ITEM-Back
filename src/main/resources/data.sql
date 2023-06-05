INSERT INTO member(`account`,`address`,`email`,`name`,`nickname`,`password`,`phone_number`,`point`,`role_type`) VALUES ('농협 123411','test address1','test1','일반유저1_Name','굳거니','$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK','010-8765-1234',175000,'MEMBER');
INSERT INTO member(`account`,`address`,`email`,`name`,`nickname`,`password`,`phone_number`,`point`,`role_type`) VALUES ('기업 1234','test address2','test2','판매자1_Name','뽀로리판매자','$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK','010-8765-1234',20000,'SELLER');
INSERT INTO member(`account`,`address`,`email`,`name`,`nickname`,`password`,`phone_number`,`point`,`role_type`) VALUES ('대구은행 1234','경북 구미시 산호대로27길 15','mechanic1','정비사_Name','군침도는정비사','$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK','010-8765-1234',495300,'MECHANIC');
INSERT INTO member(`account`,`address`,`email`,`name`,`nickname`,`password`,`phone_number`,`point`,`role_type`) VALUES ('농협 123411','test address1','test4','일반유저2_Name','콩순이','$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK','010-5651-5957',45300,'MEMBER');
INSERT INTO member(`account`,`address`,`email`,`name`,`nickname`,`password`,`phone_number`,`point`,`role_type`) VALUES ('농협 123411','test address1','test5','일반유저3_Name','명탐정상근','$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK','010-5651-5957',50000,'MEMBER');
INSERT INTO member(`account`,`address`,`email`,`name`,`nickname`,`password`,`phone_number`,`point`,`role_type`) VALUES ('농협 123411','test address1','test6','일반유저4_Name','중간개발자','$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK','010-5651-5957',50000,'MEMBER');
INSERT INTO member(`account`,`address`,`email`,`name`,`nickname`,`password`,`phone_number`,`point`,`role_type`) VALUES ('농협 123411','test address1','test7','일반유저5_Name','천재개발자','$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK','010-5651-5957',50000,'MEMBER');
INSERT INTO member(`account`,`address`,`email`,`name`,`nickname`,`password`,`phone_number`,`point`,`role_type`) VALUES ('농협 123411','test address1','test8','일반유저6_Name','바보개발자','$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK','010-5651-5957',50000,'MEMBER');
INSERT INTO member(`account`,`address`,`email`,`name`,`nickname`,`password`,`phone_number`,`point`,`role_type`) VALUES ('농협 123411','test address1','admin123','포인트관리_ID','포인트관리_ID','$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK','010-5651-5957',25000,'ADMIN');
INSERT INTO member(`account`,`address`,`email`,`name`,`nickname`,`password`,`phone_number`,`point`,`role_type`) VALUES ('농협123411','경북 구미시 흥안로 14 시장상가 D동 101호 (우)39179','mechanic2','정비사2','가난한 정비사','$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK','054-475-3638',500000,'MECHANIC');
INSERT INTO member(`account`,`address`,`email`,`name`,`nickname`,`password`,`phone_number`,`point`,`role_type`) VALUES ('농협123411','경북 구미시 산호대로25길 28','mechanic3','정비사3','부자 정비사','$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK','010-8486-1285',1000000,'MECHANIC');
INSERT INTO member(`account`,`address`,`email`,`name`,`nickname`,`password`,`phone_number`,`point`,`role_type`) VALUES ('대구123411','경북 구미시 옥계북로 36','mechanic4','정비사4','착한 정비사','$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK','0507-1369-2189',2000000,'MECHANIC');
INSERT INTO member(`account`,`address`,`email`,`name`,`nickname`,`password`,`phone_number`,`point`,`role_type`) VALUES ('농협123411','경북 구미시 구미중앙로 100','mechanic5','정비사5','나쁜 정비사','$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK','054-456-2006',1500000,'MECHANIC');


INSERT INTO seller(company_address, company_name, company_number, company_phone_number, description, member_id)
VALUES ('company_address', 'company_name', 'company_number', 'company_phone_number', 'seller description', 2);

INSERT INTO repair_shop (`description`,`repair_service_type`,`shop_address`,`shop_name`,`shop_phone_number`,`member_id`) VALUES ('옥계동 대우아파트앞에 농협이 하나있는데 농협바로뒷문쪽에 위치하고 있습니다~','컴퓨터','경북 구미시 산호대로27길 15 1층,컴퓨터마트','컴마트 옥계점','0507-1458-8997',3);
INSERT INTO repair_shop (`description`,`repair_service_type`,`shop_address`,`shop_name`,`shop_phone_number`,`member_id`) VALUES ('주연테크','컴퓨터','경북 구미시 흥안로 14 시장상가 D동 101호 (우)39179','주연테크 옥계점','054-475-3638',10);
INSERT INTO repair_shop (`description`,`repair_service_type`,`shop_address`,`shop_name`,`shop_phone_number`,`member_id`) VALUES ('구미시,옥계초등학교 근처 .부영2차 올라가는길. kt대리점위 20미터지점','컴퓨터','경북 구미시 산호대로25길 28','영광컴퓨터','010-8486-1285',11);
INSERT INTO repair_shop (`description`,`repair_service_type`,`shop_address`,`shop_name`,`shop_phone_number`,`member_id`) VALUES ('우리업체는 소상공인으로써 비용절감과 출장무료픽업을 원칙으로 합니다.','컴퓨터','경북 구미시 옥계북로 36 1동 8층 874호','금오컴퓨터수리','0507-1369-2189',12);
INSERT INTO repair_shop (`description`,`repair_service_type`,`shop_address`,`shop_name`,`shop_phone_number`,`member_id`) VALUES ('고객만족최고업체^^','모바일','경북 구미시 구미중앙로 100','착한수리 애플마스터 구미아이폰수리센터','054-456-2006',13);

INSERT INTO repair_service (`description`,`service_price`,`service_name`,`service_type`,`repair_shop_id`) VALUES ('갤럭시 폰에 대한 전체적인 점검을 진행합니다.',25000,'안드로이드 폰 점검','점검',3);
INSERT INTO repair_service (`description`,`service_price`,`service_name`,`service_type`,`repair_shop_id`) VALUES ('자체 프로그램 오류 발생 시 해결해드립니다.',25000,'소프트웨어 오류 해결','교환',3);
INSERT INTO repair_service (`description`,`service_price`,`service_name`,`service_type`,`repair_shop_id`) VALUES ('노트북 및 데스크탑 수리해드립니다.',100000,'노트북/데스크탑 수리','수리',3);
INSERT INTO repair_service (`description`,`service_price`,`service_name`,`service_type`,`repair_shop_id`) VALUES ('배터리 교환해드립니다',100000,'배터리 교체','교환',10);
INSERT INTO repair_service (`description`,`service_price`,`service_name`,`service_type`,`repair_shop_id`) VALUES ('메인보드 점검합니다',50000,'메인보드 점검','점검',10);
INSERT INTO repair_service (`description`,`service_price`,`service_name`,`service_type`,`repair_shop_id`) VALUES ('본체 점검해드립니다.',100000,'컴퓨터 본체 점검','점검',10);
INSERT INTO repair_service (`description`,`service_price`,`service_name`,`service_type`,`repair_shop_id`) VALUES ('모니터 점검해드립니다',30000,'모니터 점검','점검',11);
INSERT INTO repair_service (`description`,`service_price`,`service_name`,`service_type`,`repair_shop_id`) VALUES ('데이터 복구해드립니다',50000,'데이터 복구','수리',11);
INSERT INTO repair_service (`description`,`service_price`,`service_name`,`service_type`,`repair_shop_id`) VALUES ('컴퓨터 포멧해드립니다',50000,'포멧','수리',11);
INSERT INTO repair_service (`description`,`service_price`,`service_name`,`service_type`,`repair_shop_id`) VALUES ('데이터 복구 확실하게 해드릴게요',50000,'데이터 복구','수리',12);
INSERT INTO repair_service (`description`,`service_price`,`service_name`,`service_type`,`repair_shop_id`) VALUES ('배터리 교환해드릴게요',100000,'배터리 교환','교환',12);
INSERT INTO repair_service (`description`,`service_price`,`service_name`,`service_type`,`repair_shop_id`) VALUES ('모니터 수리해드려요',100000,'모니터 수리','수리',13);
INSERT INTO repair_service (`description`,`service_price`,`service_name`,`service_type`,`repair_shop_id`) VALUES ('컴퓨터 포멧 싸게 해드립니다',100000,'포멧','수리',13);

INSERT INTO official_repair_shop (`address`,`description`,`name`,`phone_number`) VALUES ('경북 구미시 구미대로 244 삼성스토어 구미 3층 (우)39346','삼성전자서비스','삼성전자서비스 구미센터','1588-3366');
INSERT INTO official_repair_shop (`address`,`description`,`name`,`phone_number`) VALUES ('경북 구미시 구미대로 200 LG베스트샵 2층 (우)39347','LG전자','LG전자 구미서비스센터','1544-7777');
INSERT INTO official_repair_shop (`address`,`description`,`name`,`phone_number`) VALUES ('경북 구미시 형곡로 86 1층 (우)39292','ASUS공인서비스','ASUS공인서비스 구미센터','054-444-3582');
INSERT INTO official_repair_shop (`address`,`description`,`name`,`phone_number`) VALUES ('대구 북구 칠곡중앙대로 325 삼성스토어 칠곡 2층 (우)41457','삼성전자서비스','삼성전자서비스 칠곡센터','1588-3366');
INSERT INTO official_repair_shop (`address`,`description`,`name`,`phone_number`) VALUES ('경북 김천시 시청로 122 삼성스토어 김천 1층 (우)39544','삼성전자서비스','삼성전자서비스 김천센터','1588-3366');
INSERT INTO official_repair_shop (`address`,`description`,`name`,`phone_number`) VALUES ('경북 김천시 시청로 59 LG베스트샵 4층 (우)39548','LG전자','LG전자 김천서비스센터','1544-7777');

INSERT INTO category(category_name, image_url, is_part) VALUES ('컴퓨터', 'https://item0container.blob.core.windows.net/image/컴퓨터.webp', false); # 1;
INSERT INTO category(category_name, image_url, is_part) VALUES ('노트북', 'https://item0container.blob.core.windows.net/image/노트북.webp', false); # 2;
INSERT INTO category(category_name, image_url, is_part) VALUES ('휴대폰', 'https://item0container.blob.core.windows.net/image/휴대폰.webp', false); # 3;
INSERT INTO category(category_name, image_url, is_part) VALUES ('테블릿', 'https://item0container.blob.core.windows.net/image/태블릿.webp', false); # 4;
INSERT INTO category(category_name, image_url, is_part) VALUES ('그래픽카드', 'https://item0container.blob.core.windows.net/image/그래픽카드.webp', true); # 5;
INSERT INTO category(category_name, image_url, is_part) VALUES ('cpu', 'https://item0container.blob.core.windows.net/image/CPU.webp', true); # 6;
INSERT INTO category(category_name, image_url, is_part) VALUES ('프린터기', 'https://item0container.blob.core.windows.net/image/프린터.jpg', true); # 7;
INSERT INTO category(category_name, image_url, is_part) VALUES ('메인보드', 'https://item0container.blob.core.windows.net/image/메인보드.webp', true); # 8;
INSERT INTO category(category_name, image_url, is_part) VALUES ('RAM', 'https://item0container.blob.core.windows.net/image/ram.jpg', true); # 9;
INSERT INTO category(category_name, image_url, is_part) VALUES ('SSD', 'https://item0container.blob.core.windows.net/image/ssd.jpg', true); # 10;
INSERT INTO category(category_name, image_url, is_part) VALUES ('HDD', 'https://item0container.blob.core.windows.net/image/hdd.jpg', true); # 11;
INSERT INTO category(category_name, image_url, is_part) VALUES ('케이스', 'https://item0container.blob.core.windows.net/image/케이스.webp', true); # 12;
INSERT INTO category(category_name, image_url, is_part) VALUES ('파워', 'https://item0container.blob.core.windows.net/image/파워.webp', true); # 13;
INSERT INTO category(category_name, image_url, is_part) VALUES ('쿨러', 'https://item0container.blob.core.windows.net/image/쿨러.webp', true); # 14;
INSERT INTO category(category_name, image_url, is_part) VALUES ('키보드', 'https://item0container.blob.core.windows.net/image/키보드.webp', true); # 15;
INSERT INTO category(category_name, image_url, is_part) VALUES ('NAS', 'https://item0container.blob.core.windows.net/image/nas.jpg', true); # 16;
INSERT INTO category(category_name, image_url, is_part) VALUES ('USB', 'https://item0container.blob.core.windows.net/image/USB.webp', true); # 17;
INSERT INTO category(category_name, image_url, is_part) VALUES ('공유기', 'https://item0container.blob.core.windows.net/image/공유기.webp', true); # 18;
INSERT INTO category(category_name, image_url, is_part) VALUES ('USB허브', 'https://item0container.blob.core.windows.net/image/USB허브.webp', true); # 19;
INSERT INTO category(category_name, image_url, is_part) VALUES ('랜카드', 'https://item0container.blob.core.windows.net/image/랜카드.jpg', true); # 20;
INSERT INTO category(category_name, image_url, is_part) VALUES ('스위치허브', 'https://item0container.blob.core.windows.net/image/스위치허브.webp', true); # 21;
INSERT INTO category(category_name, image_url, is_part) VALUES ('모니터', 'https://item0container.blob.core.windows.net/image/모니터.webp', true); # 22;

INSERT INTO brand(brand_name, is_finished) VALUES ('조립PC', true); #1;
INSERT INTO brand(brand_name, is_finished) VALUES ('삼성', false); #2;
INSERT INTO brand(brand_name, is_finished) VALUES ('LG', false); #3;
INSERT INTO brand(brand_name, is_finished) VALUES ('기가바이트', false); #4;
INSERT INTO brand(brand_name, is_finished) VALUES ('지포스', false); #5;
INSERT INTO brand(brand_name, is_finished) VALUES ('인텔', false); #6;
INSERT INTO brand(brand_name, is_finished) VALUES ('라이젠', false); #7;
INSERT INTO brand(brand_name, is_finished) VALUES ('MSI', false); #8;
INSERT INTO brand(brand_name, is_finished) VALUES ('ASUS', false); #9;
INSERT INTO brand(brand_name, is_finished) VALUES ('레노버', false); #10;
INSERT INTO brand(brand_name, is_finished) VALUES ('애플', false); #11;
INSERT INTO brand(brand_name, is_finished) VALUES ('샤오미', false); #12;

# 카테고리-브랜드;
# 컴퓨터;
INSERT INTO category_brand(brand_id, category_id) VALUES (1, 1); # 1 / 1 조립PC 1 컴퓨터;
INSERT INTO category_brand(brand_id, category_id) VALUES (2, 1); # 2 / 2 삼성 1 컴퓨터;
INSERT INTO category_brand(brand_id, category_id) VALUES (3, 1); # 3 / 3 LG 1 컴퓨터;
INSERT INTO category_brand(brand_id, category_id) VALUES (4, 1); # 4 / 4 기가바이트 1 컴퓨터;
INSERT INTO category_brand(brand_id, category_id) VALUES (5, 1); # 5 / 5 지포스 1 컴퓨터;
INSERT INTO category_brand(brand_id, category_id) VALUES (6, 1); # 6 / 6 인텔 1 컴퓨터;
INSERT INTO category_brand(brand_id, category_id) VALUES (7, 1); # 7 / 7 라이젠 1 컴퓨터;
INSERT INTO category_brand(brand_id, category_id) VALUES (8, 1); # 8 / 8 MSI 1 컴퓨터;

# 노트북;
INSERT INTO category_brand(brand_id, category_id) VALUES (2, 2); # 9 / 2 삼성 2 노트북;
INSERT INTO category_brand(brand_id, category_id) VALUES (3, 2); # 10 / 3 LG 2 노트북;
INSERT INTO category_brand(brand_id, category_id) VALUES (4, 2); # 11 / 4 기가바이트 2 노트북;
INSERT INTO category_brand(brand_id, category_id) VALUES (5, 2); # 12 / 5 지포스 2 노트북;
INSERT INTO category_brand(brand_id, category_id) VALUES (6, 2); # 13 / 6 인텔 2 노트북;
INSERT INTO category_brand(brand_id, category_id) VALUES (7, 2); # 14 / 7 라이젠 2 노트북;
INSERT INTO category_brand(brand_id, category_id) VALUES (8, 2); # 15 / 8 MSI 2 노트북;
INSERT INTO category_brand(brand_id, category_id) VALUES (9, 2); # 16 / 9 ASUS 2 노트북;
INSERT INTO category_brand(brand_id, category_id) VALUES (11, 2); # 17 / 11 애플 2 노트북;

# 휴대폰;
INSERT INTO category_brand(brand_id, category_id) VALUES (2, 3); # 18 / 2 삼성 3 휴대폰;
INSERT INTO category_brand(brand_id, category_id) VALUES (11, 3); # 19 / 11 애플 3 휴대폰;
INSERT INTO category_brand(brand_id, category_id) VALUES (12, 3); # 20 / 12 샤오미 3 휴대폰;

# 테블릿;
INSERT INTO category_brand(brand_id, category_id) VALUES (2, 4); # 21 / 2 삼성 4 테블릿;
INSERT INTO category_brand(brand_id, category_id) VALUES (10, 4); # 22 / 10 레노버 4 테블릿;
INSERT INTO category_brand(brand_id, category_id) VALUES (11, 4); # 23 / 11 애플 4 테블릿;
INSERT INTO category_brand(brand_id, category_id) VALUES (12, 4); # 24 / 12 샤오미 4 테블릿;

# 그래픽카드;
INSERT INTO category_brand(brand_id, category_id) VALUES (5, 5); # 25 / 5 지포스 5 그래픽카드;

# CPU;
INSERT INTO category_brand(brand_id, category_id) VALUES (6, 6); # 26 / 6 인텔 6 cpu;

# 모니터;
INSERT INTO category_brand(brand_id, category_id) VALUES (2, 22); # 27 / 2 삼성 23 모니터;

# 구독권;
set @now = '';
SELECT NOW() into @now;
INSERT INTO subscription(end_date, member_id) values (DATE_ADD(CURDATE(),INTERVAL 7 DAY), 1);
INSERT INTO subscription(end_date, member_id) values (DATE_ADD(CURDATE(),INTERVAL 7 DAY), 2);

# 제품;
INSERT INTO product(product_name, category_brand_id) VALUES ('조립PC', 1); # 1;
INSERT INTO product(product_name, category_brand_id) VALUES ('2022 맥북에어 MLY33KH/A', 1); # 2;
INSERT INTO product(product_name, category_brand_id) VALUES ('2023 맥북프로16 MNWA3KH/A', 1); # 3;
INSERT INTO product(product_name, category_brand_id) VALUES ('2020 맥북에어 MGNA3KH/A', 1); # 4;
INSERT INTO product(product_name, category_brand_id) VALUES ('2017 맥북프로13 MPXT2KH/A', 1); # 5;
INSERT INTO product(product_name, category_brand_id) VALUES ('2020 맥북에어 MGN93KH/A CTO', 1); # 6;
INSERT INTO product(product_name, category_brand_id) VALUES ('2019 맥북에어 MVFM2KH/A', 1); # 7;
INSERT INTO product(product_name, category_brand_id) VALUES ('2020 맥북에어 MVH22KH/A CTO', 1); # 8;
INSERT INTO product(product_name, category_brand_id) VALUES ('2017 맥북프로15 MPTV2KH/A', 1); # 9;
INSERT INTO product(product_name, category_brand_id) VALUES ('2016 맥북프로13 MLVP2KH/A', 1); # 10;

INSERT INTO product(product_name, category_brand_id) VALUES ('2022 맥북에어 MLY33KH/B', 17); # 2;
INSERT INTO product(product_name, category_brand_id) VALUES ('2023 맥북프로16 MNWA3KH/B', 17); # 3;
INSERT INTO product(product_name, category_brand_id) VALUES ('2020 맥북에어 MGNA3KH/B', 17); # 4;
INSERT INTO product(product_name, category_brand_id) VALUES ('2017 맥북프로13 MPXT2KH/B', 17); # 5;
INSERT INTO product(product_name, category_brand_id) VALUES ('2020 맥북에어 MGN93KH/B CTO', 17); # 6;
INSERT INTO product(product_name, category_brand_id) VALUES ('2019 맥북에어 MVFM2KH/B', 17); # 7;
INSERT INTO product(product_name, category_brand_id) VALUES ('2020 맥북에어 MVH22KH/B CTO', 17); # 8;
INSERT INTO product(product_name, category_brand_id) VALUES ('2017 맥북프로15 MPTV2KH/B', 17); # 9;
INSERT INTO product(product_name, category_brand_id) VALUES ('2016 맥북프로13 MLVP2KH/B', 17); # 10;
INSERT INTO product(product_name, category_brand_id) VALUES ('2016 맥북프로15 MLH32KH/B', 17); # 11;

INSERT INTO product(product_name, category_brand_id) VALUES ('삼성 게임용 230511 (16GB, M.2 500GB)', 2); # 12;
INSERT INTO product(product_name, category_brand_id) VALUES ('삼성 PRO - I5M51 (16GB, M.2 512GB)', 2); # 13;
INSERT INTO product(product_name, category_brand_id) VALUES ('LG 875 게이밍울트라560X', 10); # 14;
INSERT INTO product(product_name, category_brand_id) VALUES ('LG 퍼포먼스PC', 10); # 15;
INSERT INTO product(product_name, category_brand_id) VALUES ('LG 프리워커 F5600', 10); # 16;

INSERT INTO product(product_name, category_brand_id) VALUES ('삼성전자 갤럭시S22 울트라', 18); # 17 / 23 휴대폰;
INSERT INTO product(product_name, category_brand_id) VALUES ('삼성전자 갤럭시S23', 18); # 18 / 23 휴대폰;
INSERT INTO product(product_name, category_brand_id) VALUES ('삼성전자 갤럭시S23 울트라', 18); # 19 / 23 휴대폰;
INSERT INTO product(product_name, category_brand_id) VALUES ('삼성전자 Z 플립', 18); # 20 / 23 휴대폰;
INSERT INTO product(product_name, category_brand_id) VALUES ('APPLE 아이폰14 프로', 19); # 21 / 23 휴대폰;
INSERT INTO product(product_name, category_brand_id) VALUES ('APPLE 아이폰14', 19); # 22 / 23 휴대폰;
INSERT INTO product(product_name, category_brand_id) VALUES ('APPLE 아이폰13 미니', 19); # 23 / 23 휴대폰;
INSERT INTO product(product_name, category_brand_id) VALUES ('APPLE 아이폰14 프로 맥스', 19); # 24 / 23 휴대폰;
INSERT INTO product(product_name, category_brand_id) VALUES ('샤오미 홍미 노트12 프로', 20); # 25 / 23 휴대폰;
INSERT INTO product(product_name, category_brand_id) VALUES ('샤오미 홍미 노트11 프로', 20); # 26 / 23 휴대폰;
INSERT INTO product(product_name, category_brand_id) VALUES ('샤오미 홍미 노트10 프로', 20); # 27 / 23 휴대폰;

INSERT INTO product(product_name, category_brand_id) VALUES ('삼성전자 갤럭시탭S8', 21); # 28 / 24 테블릿;
INSERT INTO product(product_name, category_brand_id) VALUES ('삼성전자 갤럭시탭S7', 21); # 29 / 24 테블릿;
INSERT INTO product(product_name, category_brand_id) VALUES ('삼성전자 갤럭시탭A8', 21); # 30 / 24 테블릿;
INSERT INTO product(product_name, category_brand_id) VALUES ('레노버 Legion Y700', 22); # 31 / 24 테블릿;
INSERT INTO product(product_name, category_brand_id) VALUES ('레노버 XiaoxinPad 2022', 22); # 32 / 24 테블릿;
INSERT INTO product(product_name, category_brand_id) VALUES ('레노버 탭 P11 플러스', 22); # 33 / 24 테블릿;
INSERT INTO product(product_name, category_brand_id) VALUES ('APPLE 아이패드 프로 11', 23); # 34 / 24 테블릿;
INSERT INTO product(product_name, category_brand_id) VALUES ('APPLE 아이패드 프로 12.9', 23); # 35 / 24 테블릿;
INSERT INTO product(product_name, category_brand_id) VALUES ('APPLE 아이패드 9세대', 23); # 36 / 24 테블릿;

INSERT INTO product(product_name, category_brand_id) VALUES ('RTX 3070', 25); # 37 / 25 지포스 그래픽카드;
INSERT INTO product(product_name, category_brand_id) VALUES ('인텔 i7', 26); # 38 / 26 인텔 cpu;

# 포인트 이용내역;
set @now = '';
SELECT NOW() into @now;
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 50000, '아이폰12 구매', '상품 구매', 1);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 10000, '리뷰 추천 누적 10회', '리뷰 추천 누적', 1);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 15000, '리뷰 추천 누적 20회', '리뷰 추천 누적', 2);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 50000, '그래픽카드 GTX1060 부품 구매', '상품 구매', 3);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 15000, '리뷰 추천 누적 20회', '리뷰 추천 누적', 3);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 25000, '안드로이드 폰 점검', '수리 서비스 제공', 3);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, -25000, '안드로이드 폰 점검', '수리 서비스 이용', 1);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 25000, '소프트웨어 오류 해결', '수리 서비스 제공', 3);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, -25000, '소프트웨어 오류 해결', '수리 서비스 이용', 1);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 100000, '노트북/데스크탑 수리', '수리 서비스 제공', 3);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, -100000, '노트북/데스크탑 수리', '수리 서비스 이용', 1);


INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('수리가 빨라서 좋았습니다.', 5, 1, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('깔끔하게 고쳐졌어요.', 5, 1, 10);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('안고쳐져서 고생했는데 감사합니다.', 5, 1, 11);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('자주 이용할게요', 5, 1, 12);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('수리가 조금 늦어져서 아쉬워여.', 3, 4, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('별로네요', 1, 4, 13);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('수리가 빨라서 좋았습니다.', 5, 5, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('깔끔하게 고쳐졌어요.', 5, 5, 10);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('안고쳐져서 고생했는데 감사합니다.', 5, 6, 11);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('신속하고 전문적인 서비스를 받을 수 있어요', 5, 6, 12);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('고객 만족도를 최우선으로 생각하고 있어요!', 5, 6, 13);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('경험 풍부한 전문가들이 정확하고 신속한 수리를 해줘요!', 5, 6, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('합리적인 가격으로 고품질 서비스를 제공해요!', 5, 1, 10);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('최신 기술과 도구를 사용하여 정밀한 수리를 해줘요!', 5, 1, 11);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('친절하고 상세한 설명으로 문제를 해결해줘요!', 5, 6, 12);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('원격으로도 문제를 진단하고 해결해줘요!', 5, 5, 13);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('수리 시간을 최소화하여 불편을 최대한 줄여줘요!', 5, 1, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('원격으로도 문제를 진단하고 해결해줘요!', 5, 4, 10);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('고장 진단과 수리 후에도 품질 보증을 제공해요', 5, 4, 11);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('신속한 서비스와 함께 문제 예방을 위한 유용해요', 5, 6, 12);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('고객의 개인정보와 기기 정보를 안전하게 보호해줘요', 5, 6, 13);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('전자기기 정비소에서는 고장 진단과 수리 후에도 품질 보증을 제공해요', 5, 4, 3);

INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (1, 2, 1190000, '이 시대의 최고의 컴퓨터','대한통운',2500 ,'컴퓨터', '조립PC','https://item0container.blob.core.windows.net/image/56fef2b9-e2c2-4741-ac14-25bfcffaf630_%EC%BB%B4%ED%84%B01.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/8684ab1c-6e4d-45f2-a63f-d9284046eb8b_%EC%BB%B4%EC%84%A41.jpg', 1);
# INSERT INTO market_review(comment, date, rating, member_id, sale_product_id) VALUES ('리뷰 내용 테스트입니다.', '2021-05-01 17:30:00', 5, 1, 1);

INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (2, 2, 2300000, '이 시대의 두 번째로 최고의 컴퓨터','대한통운',2500 ,'컴퓨터', '2022 맥북에어 MLY33KH/A','https://item0container.blob.core.windows.net/image/dcfac119-d978-4477-a591-371075919cfb_%EC%BB%B42.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/38e2884e-8c95-45a3-b264-a63b085ac18d_%EC%BB%B4%EC%84%A42.jpg', 2);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (3, 2, 1500000, '이 시대의 세 번째로 최고의 컴퓨터','우체국 택배',2500 ,'컴퓨터', '2023 맥북프로16 MNWA3KH/A','https://item0container.blob.core.windows.net/image/570c38da-3fbc-45d1-b114-ea08e4fbdc00_%EC%BB%B43.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/4bc09d9b-6b11-4c96-a65d-40b72b891530_%EC%BB%B4%EC%84%A43.jpg', 3);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (4, 2, 1120000, '이 시대의 네 번째로 최고의 컴퓨터','로젠택배',2500 ,'컴퓨터', '2020 맥북에어 MGNA3KH/A','https://item0container.blob.core.windows.net/image/18241f6d-456b-46c4-a744-4f7a230b40c8_%EC%BB%B44.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/87881647-ef56-49ef-b465-b668932763e5_%EC%BB%B4%EC%84%A44.jpg', 4);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (5, 2, 1199000, '이 시대의 다섯 번째로 최고의 컴퓨터','대한통운',2500 ,'컴퓨터', '삼성 게임용 230511 (16GB, M.2 500GB)','https://item0container.blob.core.windows.net/image/25653ccf-5af2-4cee-9c2b-357d0c803248_%EC%BB%B45.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/4073051e-0afb-4a0c-876b-2e28103a0da8_%EC%BB%B4%EC%84%A45.jpg', 5);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (6, 2, 3240000, '이 시대의 여섯 번째로 최고의 컴퓨터','로젠택배',2500 ,'컴퓨터', '삼성 PRO - I5M51 (16GB, M.2 512GB)','https://item0container.blob.core.windows.net/image/75074b7d-74d0-4ad6-bd44-16fedfd47908_%EC%BB%B46.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/9927ee9f-fddc-4d86-8085-089fc70b985e_%EC%BB%B4%EC%84%A46.jpg', 6);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (7, 2, 2870000, '이 시대의 일곱 번째로 최고의 컴퓨터','우체국 택배',2500 ,'컴퓨터', '2020 맥북에어 MVH22KH/A CTO','https://item0container.blob.core.windows.net/image/f5d1abba-fd50-489b-9978-ce68909fe761_%EC%BB%B47.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/e408e9f4-e5ef-4ae6-9d6a-b7555ec6d877_%EC%BB%B4%EC%84%A47.jpg', 7);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (8, 2, 980000, '이 시대의 여덟 번째로 최고의 컴퓨터','대한통운',2500 ,'컴퓨터', '2020 맥북에어 MGN93KH/A CTO','https://item0container.blob.core.windows.net/image/8ac63165-ae78-4ed7-865f-bc2bb169eb1c_%EC%BB%B48.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/2f52ec69-895b-4459-b414-962f76121346_%EC%BB%B4%EC%84%A48.jpg', 8);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (9, 2, 3100000, '이 시대의 아홉 번째로 최고의 컴퓨터','로젠택배',2500 ,'컴퓨터', '삼성 PRO - I5M51 (16GB, M.2 512GB)','https://item0container.blob.core.windows.net/image/940a4559-8f82-452f-8c4a-eae4f6d8c5d0_%EC%BB%B49.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/bd3f1a8f-0cc3-475b-84b9-7e457297cc8c_%EC%BB%B4%EC%84%A49.jpg', 9);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (10, 2, 5420000, '이 시대의 열 번째로 최고의 컴퓨터','우체국 택배',2500 ,'컴퓨터', 'LG 875 게이밍울트라560X','https://item0container.blob.core.windows.net/image/3cdc3c9f-ef31-4517-8aa6-8595ad1971c7_%EC%BB%B410.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/3a74f00d-6c60-47d0-a743-b9c4fbf76c05_%EC%BB%B4%EC%84%A410.jpg', 10);

INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (11, 2, 1190000, '이 시대의 최고의 노트북','대한통운',2500 ,'노트북', '삼성 갤럭시 북3 프로 NT940XFG-KC51E','https://item0container.blob.core.windows.net/image/8117f692-6082-4d22-8c94-e47133050cca_%EB%85%B81.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/b834dcdb-aa1e-48f2-8b0a-cbbfafd360a9_%EB%85%B8%EC%84%A41.jpg', 11);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (12, 2, 2300000, '이 시대의 두 번째로 최고의 노트북','대한통운',2500 ,'노트북', '삼성 갤럭시 북3 프로 NT960XFG-KC71G','https://item0container.blob.core.windows.net/image/2b0f9bed-242c-40e3-9871-b6fe1f7f3f60_%EB%85%B82.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/557a7be7-cce6-4681-9bbf-b9c996c8a10d_%EB%85%B8%EC%84%A42.jpg', 12);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (13, 2, 1500000, '이 시대의 세 번째로 최고의 노트북','우체국 택배',2500 ,'노트북', '2017 맥북프로13 MPXT2KH/A','https://item0container.blob.core.windows.net/image/fcef06b8-856a-45b8-97c7-28ea323ba646_%EB%85%B83.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/b087901e-e354-477f-a396-88a1de6f6545_%EB%85%B8%EC%84%A43.jpg', 13);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (14, 2, 1120000, '이 시대의 네 번째로 최고의 노트북','로젠택배',2500 ,'노트북', '맥북에어 M1칩 13형 256GB Space Gray - MGN63KH/A','https://item0container.blob.core.windows.net/image/f1b4823d-07a3-4de4-b48f-737792e15b39_%EB%85%B84.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/38af32ae-fde5-48f1-baa4-81654b8cb6db_%EB%85%B8%EC%84%A44.jpg', 14);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (15, 2, 1199000, '이 시대의 다섯 번째로 최고의 노트북','대한통운',2500 ,'노트북', '2023 990그램 노트북 15Z90RT-G.AA50K','https://item0container.blob.core.windows.net/image/acd807af-f893-4ca5-9124-1859588a408a_%EB%85%B85.png' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/3cc266b1-0287-4a13-a21c-b810261ab8e0_%EB%85%B8%EC%84%A45.jpg', 15);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (16, 2, 3240000, '이 시대의 여섯 번째로 최고의 노트북','로젠택배',2500 ,'노트북', '삼성 PRO - I5M51 (16GB, M.2 512GB)','https://item0container.blob.core.windows.net/image/7d917543-763c-448b-8130-39050a18a0d6_%EB%85%B86.png' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/0b699467-616f-45e1-8085-a1b1b6a52812_%EB%85%B8%EC%84%A46.png', 16);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (17, 2, 2870000, '이 시대의 일곱 번째로 최고의 노트북','우체국 택배',2500 ,'노트북', '2020 맥북에어 MVH22KH/A CTO','https://item0container.blob.core.windows.net/image/4a0eb67f-1a2c-47d2-b510-a9e46b5242cc_%EB%85%B87.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/846ea5d7-b992-438f-9a34-a14f1d4585fd_%EB%85%B8%EC%84%A47.jpg', 17);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (18, 2, 980000, '이 시대의 여덟 번째로 최고의 노트북','대한통운',2500 ,'노트북', '2020 맥북에어 MGN93KH/A CTO','https://item0container.blob.core.windows.net/image/d3b596fa-0577-46d0-a2c7-f62b681c8f75_%EB%85%B88.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/486efafe-699f-4800-9837-8c64f7fdc177_%EB%85%B8%EC%84%A48.jpg', 18);

INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (26, 2, 1190000, '이 시대의 최고의 휴대폰','대한통운',2500 ,'휴대폰', '삼성전자 갤럭시S22 울트라','https://item0container.blob.core.windows.net/image/26956f2a-59de-4de9-940d-b736d1027d4f_%ED%8F%B01.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/4a9e85b3-2d60-4a97-bfd9-988c924efffa_%ED%8F%B0%EC%84%A41.jpg', 19);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (27, 2, 2300000, '이 시대의 두 번째로 최고의 휴대폰','대한통운',2500 ,'휴대폰', '삼성전자 갤럭시S23','https://item0container.blob.core.windows.net/image/17923178-23e9-4b42-b5b0-c24604195150_%ED%8F%B02.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/9c7a41d7-6938-4fee-9ae1-0f9abce63f0c_%ED%8F%B0%EC%84%A42.jpg', 20);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (28, 2, 1500000, '이 시대의 세 번째로 최고의 휴대폰','우체국 택배',2500 ,'휴대폰', '삼성전자 갤럭시S23 울트라','https://item0container.blob.core.windows.net/image/a08443ef-795f-497d-82f4-b903744a5b8c_%ED%8F%B03.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/f2241a22-3ab9-454d-82fc-e9db15670e87_%ED%8F%B0%EC%84%A43.jpg', 21);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (29, 2, 1120000, '이 시대의 네 번째로 최고의 휴대폰','로젠택배',2500 ,'휴대폰', '삼성전자 Z 플립','https://item0container.blob.core.windows.net/image/96a5e074-2aa7-4000-ab0b-96805226e1da_%ED%8F%B04.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/727231c0-03fa-4195-9686-f83b48373125_%ED%8F%B0%EC%84%A44.jpg', 22);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (30, 2, 1199000, '이 시대의 다섯 번째로 최고의 휴대폰','대한통운',2500 ,'휴대폰', 'APPLE 아이폰14 프로','https://item0container.blob.core.windows.net/image/a30bd719-2f09-4a09-b88c-5694606422ee_%ED%8F%B05.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/aa3ad62b-89b5-418b-a9b7-ce9923ec7f18_%ED%8F%B0%EC%84%A45.jpg', 23);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (31, 2, 3240000, '이 시대의 여섯 번째로 최고의 휴대폰','로젠택배',2500 ,'휴대폰', 'APPLE 아이폰14','https://item0container.blob.core.windows.net/image/bbade028-c08e-434b-a47c-591d78eae7b2_%ED%8F%B06.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/dc8b3ae5-3370-4dcc-9804-54a1c935bef4_%ED%8F%B0%EC%84%A46.jpg', 24);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (32, 2, 2870000, '이 시대의 일곱 번째로 최고의 휴대폰','우체국 택배',2500 ,'휴대폰', 'APPLE 아이폰13 미니','https://item0container.blob.core.windows.net/image/f6814c46-78b7-433a-a83c-ab9cfa1c7eac_%ED%8F%B07.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/7d1a2abe-daf1-474a-b6e7-dd9027c609a3_%ED%8F%B0%EC%84%A47.jpg', 25);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (33, 2, 980000, '이 시대의 여덟 번째로 최고의 휴대폰','대한통운',2500 ,'휴대폰', 'APPLE 아이폰14 프로 맥스','https://item0container.blob.core.windows.net/image/9d123049-cbc9-4b74-a9d8-9e7e9a80d60f_%ED%8F%B08.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/9993a5a5-e1f9-4b11-9218-29968b3d3320_%ED%8F%B0%EC%84%A48.jpg', 26);

INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (37, 2, 1190000, '이 시대의 최고의 테블릿','대한통운',2500 ,'테블릿', '삼성전자 갤럭시탭S8','https://item0container.blob.core.windows.net/image/3542465d-9116-4542-96d4-f905cb033323_%ED%85%8C1.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/ac8644e9-6c7d-4c3a-8963-82005c144f4b_%ED%85%8C%EC%84%A41.jpg', 27);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (38, 2, 2300000, '이 시대의 두 번째로 최고의 테블릿','대한통운',2500 ,'테블릿', '삼성전자 갤럭시탭S7','https://item0container.blob.core.windows.net/image/0345e871-3574-47f8-a314-994add0f945a_%ED%85%8C2.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/602081d2-3c8c-4c2c-b781-21f791ee7def_%ED%85%8C%EC%84%A42.jpg', 28);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (39, 2, 1500000, '이 시대의 세 번째로 최고의 테블릿','우체국 택배',2500 ,'테블릿', '삼성전자 갤럭시탭A8','https://item0container.blob.core.windows.net/image/7023c757-c5d0-4538-9785-cb3859b8b48f_%ED%85%8C3.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/cf9d76ef-683c-4ff2-8eab-930118c3f0d8_%ED%84%B0%EC%84%A43.jpg', 29);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (40, 2, 1120000, '이 시대의 네 번째로 최고의 테블릿','로젠택배',2500 ,'테블릿', '레노버 Legion Y700','https://item0container.blob.core.windows.net/image/c39c42a1-d7fe-4151-9707-147a7c9f8353_%ED%85%8C4.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/0b6fdd93-0935-4245-8012-3cbaefa212b9_%ED%85%8C%EC%84%A44.jpg', 30);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (41, 2, 1199000, '이 시대의 다섯 번째로 최고의 테블릿','대한통운',2500 ,'테블릿', '레노버 XiaoxinPad 2022','https://item0container.blob.core.windows.net/image/74e92999-a31c-4f8f-8162-b1fb12faa42b_%ED%85%8C5.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/093ef8af-230b-4565-ae6c-2a9acb8f60ea_%ED%85%8C%EC%84%A45.jpg', 31);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (42, 2, 3240000, '이 시대의 여섯 번째로 최고의 테블릿','로젠택배',2500 ,'테블릿', 'APPLE 아이패드 프로 11','https://item0container.blob.core.windows.net/image/fa230e88-cc93-4f0f-a138-2c4651a9e08d_%ED%85%8C6.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/a213a31d-67bd-49b1-9410-c0f0f1404d30_%ED%85%8C%EC%84%A46.jpg', 32);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (43, 2, 2870000, '이 시대의 일곱 번째로 최고의 테블릿','우체국 택배',2500 ,'테블릿', 'APPLE 아이패드 프로 12.9','https://item0container.blob.core.windows.net/image/2329a704-1396-4624-bb1d-bc6059fa0ecd_%ED%85%8C7.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/55b06838-6991-4deb-8b12-bb258d419ff8_%ED%85%8C%EC%84%A47.jpg', 33);
INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (44, 2, 980000, '이 시대의 여덟 번째로 최고의 테블릿','대한통운',2500 ,'테블릿', 'APPLE 아이패드 9세대','https://item0container.blob.core.windows.net/image/04b72400-9f37-4294-916f-d7586cf0d021_%ED%85%8C8.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/3227cfd4-f01b-40a7-b649-f507bf863d28_%ED%85%8C%EC%84%A48.jpg', 34);