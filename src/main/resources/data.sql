INSERT INTO member(address, email, name, nickname, password, phone_number, point, role_type, account)
VALUES ('test address1', 'test1', '일반유저_ID', '일반유저_ID', '$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK', '010-5651-5957', 50000, 'MEMBER', '농협 1234');
INSERT INTO member(address, email, name, nickname, password, phone_number, point, role_type, account)
VALUES ('test address2', 'test2', '판매자_ID', '판매자_ID', '$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK', '010-8765-1234', 20000, 'SELLER', '기업 1234');
INSERT INTO member(address, email, name, nickname, password, phone_number, point, role_type, account)
VALUES ('경북 구미시 옥계2공단로 310-1', 'test3', '정비사_ID', '정비사_ID', '$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK', '010-8765-1234', 500000, 'MECHANIC', '대구은행 1234');

INSERT INTO seller(company_address, company_name, company_number, company_phone_number, description, member_id)
VALUES ('company_address', 'company_name', 'company_number', 'company_phone_number', 'seller description', 2);
INSERT INTO repair_shop(description, shop_name, shop_phone_number, member_id, repair_service_type, shop_address)
VALUES ('test description1', 'test shop1', '010-1234-5678', 3, 'NOTEBOOK', 'shop_address_test3');

INSERT INTO repair_service(description, service_name, service_type, service_price, repair_shop_id)
VALUES ('갤럭시 폰에 대한 전체적인 점검을 진행합니다.', '안드로이드 폰 점검', '점검', 25000, 3);
INSERT INTO repair_service(description, service_name, service_type,  service_price, repair_shop_id)
VALUES ('자체 프로그램 오류 발생 시 해결해드립니다.', '소프트웨어 오류 해결','교환', 25000 , 3);
INSERT INTO repair_service(description, service_name, service_type,  service_price, repair_shop_id)
VALUES ('노트북 및 데스크탑 수리해드립니다.', '노트북/데스크탑 수리', '수리', 100000,3);

INSERT INTO official_repair_shop(address, description, name, phone_number)
VALUES ('경북 구미시 옥계2공단로 310-1', 'test description2', 'test shop2', '010-1234-5678');

INSERT INTO category(category_name, image_url, is_part) VALUES ('컴퓨터', 'https://item0container.blob.core.windows.net/image/computer.webp', false); # 1;
INSERT INTO category(category_name, image_url, is_part) VALUES ('노트북', 'https://item0container.blob.core.windows.net/image/noteBook.png', false); # 2;
INSERT INTO category(category_name, image_url, is_part) VALUES ('휴대폰', 'https://item0container.blob.core.windows.net/image/smartPhone.png', false); # 3;
INSERT INTO category(category_name, image_url, is_part) VALUES ('테블릿', 'https://item0container.blob.core.windows.net/image/tablet.png', false); # 4;
INSERT INTO category(category_name, image_url, is_part) VALUES ('그래픽카드', 'https://item0container.blob.core.windows.net/image/graphic_card.jpg', true); # 5;
INSERT INTO category(category_name, image_url, is_part) VALUES ('cpu', 'https://item0container.blob.core.windows.net/image/cpu.jpg', true); # 6;
INSERT INTO category(category_name, image_url, is_part) VALUES ('프린터기', 'https://item0container.blob.core.windows.net/image/printer.jpg', true); # 7;
INSERT INTO category(category_name, image_url, is_part) VALUES ('메인보드', 'https://item0container.blob.core.windows.net/image/mainboard.jpg', true); # 8;
INSERT INTO category(category_name, image_url, is_part) VALUES ('RAM', 'https://item0container.blob.core.windows.net/image/ram.jpg', true); # 9;
INSERT INTO category(category_name, image_url, is_part) VALUES ('SSD', 'https://item0container.blob.core.windows.net/image/ssd.jpg', true); # 10;
INSERT INTO category(category_name, image_url, is_part) VALUES ('HDD', 'https://item0container.blob.core.windows.net/image/hdd.jpg', true); # 11;
INSERT INTO category(category_name, image_url, is_part) VALUES ('케이스', 'https://item0container.blob.core.windows.net/image/case.webp', true); # 12;
INSERT INTO category(category_name, image_url, is_part) VALUES ('파워', 'https://item0container.blob.core.windows.net/image/power.jpg', true); # 13;
INSERT INTO category(category_name, image_url, is_part) VALUES ('쿨러', 'https://item0container.blob.core.windows.net/image/cooler.jpg', true); # 14;
INSERT INTO category(category_name, image_url, is_part) VALUES ('키보드', 'https://item0container.blob.core.windows.net/image/keyboard.webp', true); # 15;
INSERT INTO category(category_name, image_url, is_part) VALUES ('NAS', 'https: //item0container.blob.core.windows.net/image/nas.jpg', true); # 16;
INSERT INTO category(category_name, image_url, is_part) VALUES ('USB', 'https://item0container.blob.core.windows.net/image/usb.jpg', true); # 17;
INSERT INTO category(category_name, image_url, is_part) VALUES ('공유기', 'https://item0container.blob.core.windows.net/image/router.jpg', true); # 18;
INSERT INTO category(category_name, image_url, is_part) VALUES ('USB허브', 'https://item0container.blob.core.windows.net/image/usb.jpg', true); # 19;
INSERT INTO category(category_name, image_url, is_part) VALUES ('랜카드', 'https://item0container.blob.core.windows.net/image/lan.jpg', true); # 20;
INSERT INTO category(category_name, image_url, is_part) VALUES ('스위치허브', 'https://item0container.blob.core.windows.net/image/switch.jpg', true); # 22;
INSERT INTO category(category_name, image_url, is_part) VALUES ('모니터', 'https://item0container.blob.core.windows.net/image/monitor.jpg', true); # 23;

INSERT INTO brand(brand_name, is_finished) VALUES ('완본체', true); #1;
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
INSERT INTO category_brand(brand_id, category_id) VALUES (1, 1); # 1 / 1 완본체 1 컴퓨터;
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
INSERT INTO product(product_name, category_brand_id) VALUES ('완본체', 1); # 1;
INSERT INTO product(product_name, category_brand_id) VALUES ('2022 맥북에어 MLY33KH/A', 17); # 2;
INSERT INTO product(product_name, category_brand_id) VALUES ('2023 맥북프로16 MNWA3KH/A', 17); # 3;
INSERT INTO product(product_name, category_brand_id) VALUES ('2020 맥북에어 MGNA3KH/A', 17); # 4;
INSERT INTO product(product_name, category_brand_id) VALUES ('2017 맥북프로13 MPXT2KH/A', 17); # 5;
INSERT INTO product(product_name, category_brand_id) VALUES ('2020 맥북에어 MGN93KH/A CTO', 17); # 6;
INSERT INTO product(product_name, category_brand_id) VALUES ('2019 맥북에어 MVFM2KH/A', 17); # 7;
INSERT INTO product(product_name, category_brand_id) VALUES ('2020 맥북에어 MVH22KH/A CTO', 17); # 8;
INSERT INTO product(product_name, category_brand_id) VALUES ('2017 맥북프로15 MPTV2KH/A', 17); # 9;
INSERT INTO product(product_name, category_brand_id) VALUES ('2016 맥북프로13 MLVP2KH/A', 17); # 10;
INSERT INTO product(product_name, category_brand_id) VALUES ('2016 맥북프로15 MLH32KH/A', 17); # 11;

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



# IT 기기 관리;
INSERT INTO it_device(directly_registered_name, category_id, brand_id, product_id, member_id, finished_it_device_id) VALUES (null, 2, 11, 2, 1, null);
INSERT INTO it_device(directly_registered_name, category_id, brand_id, product_id, member_id, finished_it_device_id) VALUES (null, 2, 11, 3, 1, null);
INSERT INTO it_device(directly_registered_name, category_id, brand_id, product_id, member_id, finished_it_device_id) VALUES (null, 2, 11, 4, 1, null);
INSERT INTO it_device(directly_registered_name, category_id, brand_id, product_id, member_id, finished_it_device_id) VALUES (null, 1, 1, 1, 1, null);
INSERT INTO it_device(directly_registered_name, category_id, brand_id, product_id, member_id, finished_it_device_id) VALUES (null, 1, 1, 1, 1, null);
INSERT INTO it_device(directly_registered_name, category_id, brand_id, product_id, member_id, finished_it_device_id) VALUES (null, 4, 11, 34, 1, null);

INSERT INTO it_device(directly_registered_name, category_id, brand_id, product_id, member_id, finished_it_device_id) VALUES (null, 5, 5, 37, 1, 4);
INSERT INTO it_device(directly_registered_name, category_id, brand_id, product_id, member_id, finished_it_device_id) VALUES (null, 6, 6, 38, 1, 4);
INSERT INTO it_device(directly_registered_name, category_id, brand_id, product_id, member_id, finished_it_device_id) VALUES (null, 5, 5, 37, 1, 5);

# 포인트 이용내역;
set @now = '';
SELECT NOW() into @now;
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 50000, '아이폰12 구매', '상품 구매', 1);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 10000, '리뷰 추천 누적 10회', '리뷰 추천 누적', 1);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 15000, '리뷰 추천 누적 20회', '리뷰 추천 누적', 2);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 50000, '그래픽카드 GTX1060 부품 구매', '상품 구매', 3);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 15000, '리뷰 추천 누적 20회', '리뷰 추천 누적', 3);

# 연관 단어 데이터;
INSERT INTO data(count, vocab, product_id) VALUES (120, '예쁘다', 2);
INSERT INTO data(count, vocab, product_id) VALUES (150, '빠르다', 2);
INSERT INTO data(count, vocab, product_id) VALUES (170, '성능', 2);
INSERT INTO data(count, vocab, product_id) VALUES (90, '애플', 2);
INSERT INTO data(count, vocab, product_id) VALUES (115, '수리', 2);
INSERT INTO data(count, vocab, product_id) VALUES (110, '고가', 2);
INSERT INTO data(count, vocab, product_id) VALUES (150, '배송', 2);
INSERT INTO data(count, vocab, product_id) VALUES (190, '디자인', 2);
INSERT INTO data(count, vocab, product_id) VALUES (250, '멋지다', 2);

INSERT INTO data(count, vocab, product_id) VALUES (130, '좋다', 3);
INSERT INTO data(count, vocab, product_id) VALUES (90, '예쁘다', 3);
INSERT INTO data(count, vocab, product_id) VALUES (90, '애플', 3);
INSERT INTO data(count, vocab, product_id) VALUES (115, '수리', 3);
INSERT INTO data(count, vocab, product_id) VALUES (185, '디자인', 3);
INSERT INTO data(count, vocab, product_id) VALUES (110, '고가', 3);
INSERT INTO data(count, vocab, product_id) VALUES (150, '배송', 3);
INSERT INTO data(count, vocab, product_id) VALUES (150, '배터리', 3);

INSERT INTO data(count, vocab, product_id) VALUES (100, '예쁘다', 4);
INSERT INTO data(count, vocab, product_id) VALUES (120, '좋다', 4);
INSERT INTO data(count, vocab, product_id) VALUES (120, '수리', 4);
INSERT INTO data(count, vocab, product_id) VALUES (130, '애플', 4);
INSERT INTO data(count, vocab, product_id) VALUES (120, '성능', 4);
INSERT INTO data(count, vocab, product_id) VALUES (50, '느라다', 4);
INSERT INTO data(count, vocab, product_id) VALUES (20, '나쁘다', 4);

INSERT INTO data(count, vocab, product_id) VALUES (100, '예쁘다', 5);
INSERT INTO data(count, vocab, product_id) VALUES (120, '좋다', 5);
INSERT INTO data(count, vocab, product_id) VALUES (120, '수리', 5);
INSERT INTO data(count, vocab, product_id) VALUES (130, '애플', 5);
INSERT INTO data(count, vocab, product_id) VALUES (120, '성능', 5);
INSERT INTO data(count, vocab, product_id) VALUES (50, '느라다', 5);
INSERT INTO data(count, vocab, product_id) VALUES (20, '나쁘다', 5);

INSERT INTO data(count, vocab, product_id) VALUES (110, '예쁘다', 6);
INSERT INTO data(count, vocab, product_id) VALUES (120, '좋다', 6);
INSERT INTO data(count, vocab, product_id) VALUES (120, '수리', 6);
INSERT INTO data(count, vocab, product_id) VALUES (120, '성능', 6);
INSERT INTO data(count, vocab, product_id) VALUES (50, '느라다', 6);
INSERT INTO data(count, vocab, product_id) VALUES (20, '나쁘다', 6);
INSERT INTO data(count, vocab, product_id) VALUES (130, '애플', 6);

INSERT INTO data(count, vocab, product_id) VALUES (140, '예쁘다', 7);
INSERT INTO data(count, vocab, product_id) VALUES (120, '좋다', 7);
INSERT INTO data(count, vocab, product_id) VALUES (90, '성능', 7);
INSERT INTO data(count, vocab, product_id) VALUES (10, '수리', 7);
INSERT INTO data(count, vocab, product_id) VALUES (50, '느라다', 7);
INSERT INTO data(count, vocab, product_id) VALUES (20, '나쁘다', 7);
INSERT INTO data(count, vocab, product_id) VALUES (130, '애플', 7);

INSERT INTO data(count, vocab, product_id) VALUES (130, '예쁘다', 8);
INSERT INTO data(count, vocab, product_id) VALUES (120, '좋다', 8);
INSERT INTO data(count, vocab, product_id) VALUES (90, '성능', 8);
INSERT INTO data(count, vocab, product_id) VALUES (10, '수리', 8);
INSERT INTO data(count, vocab, product_id) VALUES (50, '느라다', 8);
INSERT INTO data(count, vocab, product_id) VALUES (20, '나쁘다', 8);
INSERT INTO data(count, vocab, product_id) VALUES (130, '애플', 8);

INSERT INTO data(count, vocab, product_id) VALUES (120, '나쁘다', 9);
INSERT INTO data(count, vocab, product_id) VALUES (90, '예쁘다', 9);
INSERT INTO data(count, vocab, product_id) VALUES (117, '좋다', 9);
INSERT INTO data(count, vocab, product_id) VALUES (22, '수리', 9);
INSERT INTO data(count, vocab, product_id) VALUES (44, '성능', 9);
INSERT INTO data(count, vocab, product_id) VALUES (66, '멋있다', 9);
INSERT INTO data(count, vocab, product_id) VALUES (42, '느리다', 9);
INSERT INTO data(count, vocab, product_id) VALUES (130, '애플', 9);

INSERT INTO data(count, vocab, product_id) VALUES (22, '빠르다', 10);
INSERT INTO data(count, vocab, product_id) VALUES (112, '성능', 10);
INSERT INTO data(count, vocab, product_id) VALUES (52, '멋있다', 10);
INSERT INTO data(count, vocab, product_id) VALUES (22, '예쁘다', 10);
INSERT INTO data(count, vocab, product_id) VALUES (22, '느리다', 10);
INSERT INTO data(count, vocab, product_id) VALUES (22, '좋다', 10);
INSERT INTO data(count, vocab, product_id) VALUES (130, '애플', 10);

INSERT INTO data(count, vocab, product_id) VALUES (310, '빠르다', 11);
INSERT INTO data(count, vocab, product_id) VALUES (112, '성능', 11);
INSERT INTO data(count, vocab, product_id) VALUES (52, '멋있다', 11);
INSERT INTO data(count, vocab, product_id) VALUES (22, '예쁘다', 11);
INSERT INTO data(count, vocab, product_id) VALUES (22, '느리다', 11);
INSERT INTO data(count, vocab, product_id) VALUES (22, '좋다', 11);
INSERT INTO data(count, vocab, product_id) VALUES (130, '애플', 11);

INSERT INTO data(count, vocab, product_id) VALUES (112, '성능', 12);
INSERT INTO data(count, vocab, product_id) VALUES (52, '멋있다', 12);
INSERT INTO data(count, vocab, product_id) VALUES (22, '예쁘다', 12);
INSERT INTO data(count, vocab, product_id) VALUES (22, '느리다', 12);
INSERT INTO data(count, vocab, product_id) VALUES (22, '좋다', 12);
INSERT INTO data(count, vocab, product_id) VALUES (132, '삼성', 12);

INSERT INTO data(count, vocab, product_id) VALUES (120, '빠르다', 13);
INSERT INTO data(count, vocab, product_id) VALUES (20, '나쁘다', 13);
INSERT INTO data(count, vocab, product_id) VALUES (132, '삼성', 13);


INSERT INTO data(count, vocab, product_id) VALUES (100, '빠르다', 14);
INSERT INTO data(count, vocab, product_id) VALUES (132, 'LG', 14);
INSERT INTO data(count, vocab, product_id) VALUES (130, '성능', 14);
INSERT INTO data(count, vocab, product_id) VALUES (132, '멋있다', 14);

INSERT INTO data(count, vocab, product_id) VALUES (140, '성능', 16);
INSERT INTO data(count, vocab, product_id) VALUES (150, '성능', 17);
INSERT INTO data(count, vocab, product_id) VALUES (160, '성능', 18);
INSERT INTO data(count, vocab, product_id) VALUES (170, '좋다', 19);

# 긍/부정 데이터;
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (2, 200, 5);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (3, 155, 144);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (4, 123, 123);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (5, 199, 111);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (6, 166, 5);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (7, 200, 222);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (8, 11, 5);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (9, 144, 5);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (10, 200, 5);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (11, 122, 5);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (12, 124, 5);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (13, 200, 77);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (14, 200, 138);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (15, 111, 138);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (16, 197, 138);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (17, 123, 138);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (18, 166, 138);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (19, 170, 138);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (20, 150, 138);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (21, 111, 138);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (22, 123, 138);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (23, 111, 138);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (24, 233, 138);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (25, 111, 138);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (26, 164, 138);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (27, 111, 138);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (28, 72, 138);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (29, 155, 138);
INSERT INTO pos_and_neg(product_id, positive, negative) VALUES (30, 234, 138);

-- 커뮤니티 글
INSERT INTO post (content, date, report, title, member_id) VALUES ('iPhone 12 Pro는 뛰어난 성능과 멋진 디자인을 가진 최신 스마트폰입니다. A14 Bionic 칩과 함께 제공되는 RAM 용량은 탁월한 멀티태스킹을 가능하게 해주며, 최고의 스마트폰 중 하나입니다.', DATE_ADD(CURDATE(),INTERVAL 1 DAY), 0, '탁월한 성능과 멋진 디자인, Apple iPhone 12 Pro 리뷰', 1);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Samsung Galaxy Watch 4는 정말로 멋진 스마트워치입니다. 1.4인치의 선명한 Super AMOLED 디스플레이는 시계 표면에서도 세밀한 정보를 볼 수 있도록 해주며, 회전 베젤은 쉽고 직관적인 완벽한 선택입니다.', DATE_ADD(CURDATE(),INTERVAL 2 DAY), 0, 'Samsung Galaxy Watch 4: 스마트워치의 혁신', 2);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Bose QuietComfort 35 II는 최고의 무선 헤드폰 중 하나입니다. 뛰어난 소음 차단 기능을 갖춘 이 헤드폰은 주변 소음을 효과적으로 차단하여 정말로 조용한 음악 청취 환경을 제공합니다. 마이크가 있어요', DATE_ADD(CURDATE(),INTERVAL 3 DAY), 0, '소음 차단의 완성, Bose QuietComfort 35 II 무선 헤드폰 리뷰', 3);
INSERT INTO post (content, date, report, title, member_id) VALUES ('iPhone 12 Pro Max: 최고의 성능과 멋진 디자인을 가진 애플의 플래그십 스마트폰', DATE_ADD(CURDATE(),INTERVAL 4 DAY), 0, 'LG OLED TV CX 시리즈: 화질과 성능의 최고봉', 1);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Samsung Galaxy S20 Ultra: 놀라운 카메라와 강력한 사양으로 완성된 스마트폰', DATE_ADD(CURDATE(),INTERVAL 5 DAY), 0, '"MacBook Pro 16인치: 전문가를 위한 완벽한 선택', 2);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Sony WH-1000XM4: 최고 수준의 노이즈 캔슬링과 탁월한 음질을 선사하는 헤드폰', DATE_ADD(CURDATE(),INTERVAL 6 DAY), 0, 'Sony WH-1000XM4: 최고의 노이즈 캔슬링 헤드폰', 3);
INSERT INTO post (content, date, report, title, member_id) VALUES ('LG OLED CX TV: 생생한 이미지와 화려한 색감으로 즐기는 시네마틱한 시청 경험', DATE_ADD(CURDATE(),INTERVAL 7 DAY), 0, '강력한 게이밍 성능, ASUS ROG Strix G15 리뷰', 1);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Apple MacBook Pro (M1): 비약적인 성능과 오래 가는 배터리로 완성된 프로용 노트북', DATE_ADD(CURDATE(),INTERVAL 7 DAY), 0, 'GoPro HERO9 Black: 모험을 기록하는 완벽한 카메라', 2);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Samsung Galaxy Watch 4: 운동 추적과 건강 관리 기능을 갖춘 스타일리시한 스마트워치', DATE_ADD(CURDATE(),INTERVAL 7 DAY), 0, 'Dyson V11 Absolute: 탁월한 흡입력과 편리한 사용성', 3);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Sony A7R IV: 고해상도 사진과 탁월한 세부 표현력을 제공하는 전문가용 카메라', DATE_ADD(CURDATE(),INTERVAL 1 DAY), 0, 'Xiaomi Mi Band 6: 저렴한 가격에 완벽한 트래커', 1);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Bose QuietComfort 35 II: 최고 수준의 소음 차단과 편안한 착용감을 갖춘 헤드폰', DATE_ADD(CURDATE(),INTERVAL 2 DAY), 0, 'Microsoft Surface Pro 7: 탁월한 유연성과 성능을 갖춘 2-in-1 노트북', 2);
INSERT INTO post (content, date, report, title, member_id) VALUES ('LG NanoCell 90 TV: 선명한 화질과 넓은 시야각으로 깊이 있는 시청 경험을 선사', DATE_ADD(CURDATE(),INTERVAL 3 DAY), 0, 'Sony A7 III: 전문가급의 사진과 비디오 품질을 제공하는 미러리스 카메라', 3);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Nintendo Switch Lite: 휴대성과 즐거운 게임 플레이로 놀라운 이동 게임 콘솔', DATE_ADD(CURDATE(),INTERVAL 4 DAY), 0, 'Apple AirPods Pro: 완벽한 음질과 액티브 노이즈 캔슬링을 갖춘 무선 이어폰', 1);
INSERT INTO post (content, date, report, title, member_id) VALUES ('GoPro HERO9 Black: 고화질 영상과 향상된 안정성으로 더욱 멋진 액션 촬영', DATE_ADD(CURDATE(),INTERVAL 4 DAY), 0, 'Samsung QLED Q90T: 생생한 색감과 화려한 HDR 풍부한 시청 경험을 선사하는 스마트 TV', 2);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Apple AirPods Pro: 탁월한 소음 차단과 편안한 착용으로 최고의 무선 이어폰', DATE_ADD(CURDATE(),INTERVAL 5 DAY), 0, 'Logitech G Pro Wireless: 경량 디자인과 정밀한 성능을 지닌 프로게이밍 마우스', 3);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Samsung Galaxy Tab S7+: 대화면 디스플레이와 강력한 성능으로 완성된 태블릿', DATE_ADD(CURDATE(),INTERVAL 6 DAY),  0, 'Canon EOS 5D Mark IV: 고화질 사진과 탁월한 영상 촬영 기능을 갖춘 전문가용 DSLR 카메라', 1);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Sony WH-1000XM3: 우수한 소음 차단과 클리어한 음질을 가진 무선 헤드폰', DATE_ADD(CURDATE(),INTERVAL 7 DAY), 0, 'Samsung Galaxy Tab S7+: 대화면과 강력한 성능을 가진 프리미엄 태블릿', 2);
INSERT INTO post (content, date, report, title, member_id) VALUES ('LG CX OLED TV: 완벽한 검은색과 생생한 색감으로 몰입감 있는 시청 경험', DATE_ADD(CURDATE(),INTERVAL 11 DAY), 0, 'LG CX 시리즈: 최고의 게임 모니터로서의 성능과 생생한 시청 경험을 제공하는 OLED TV', 3);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Apple iPad Pro (2021): M1 칩과 프로 수준의 성능으로 뛰어난 태블릿', DATE_ADD(CURDATE(),INTERVAL 13 DAY), 0, 'JBL Charge 4: 방수 기능과 탁월한 음질을 갖춘 휴대용 블루투스 스피커', 1);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Samsung Galaxy Buds Live: 독특한 디자인과 깊은 베이스를 갖춘 무선 이어폰', DATE_ADD(CURDATE(),INTERVAL 12 DAY), 0, 'Nintendo Switch: 혁신적인 하이브리드 게임 콘솔의 매력과 다양한 게임 라인업', 2);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Sony PlayStation 5: 네이티브 4K 게임과 실감나는 게임 플레이 경험', DATE_ADD(CURDATE(),INTERVAL 11 DAY), 0, 'Google Pixel 5: 압도적인 카메라 성능과 순수 안드로이드 경험을 제공하는 스마트폰', 3);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Microsoft Surface Pro 7: 가볍고 다용도로 사용할 수 있는 프리미엄 태블릿', DATE_ADD(CURDATE(),INTERVAL 11 DAY), 0, 'Bose SoundLink Revolve+: 360도 음향과 강력한 베이스를 선사하는 휴대용 블루투스 스피커', 1);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Nintendo Switch: 유연한 게임 플레이 스타일로 즐기는 다양한 게임 컨텐츠', DATE_ADD(CURDATE(),INTERVAL 12 DAY),  0, 'Sony PlayStation 5: 네이티브 4K 게이밍과 혁신적인 컨트롤러로 새로운 게임 세계를 체험하세요', 2);
INSERT INTO post (content, date, report, title, member_id) VALUES ('GoPro HERO9 Black: 고화질 영상과 향상된 안정성으로 멋진 액션 촬영을 즐기세요. 강력한 기능과 내구성으로 어떤 환경에서도 놀라운 결과물을 만들어냅니다', DATE_ADD(CURDATE(),INTERVAL 11 DAY), 0, 'Samsung Galaxy Buds Pro: 고급스러운 디자인과 탁월한 소리 품질을 갖춘 무선 이어폰', 3);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Apple AirPods Pro: 최상의 소음 차단과 편안한 착용감으로 최고의 무선 이어폰을 경험하세요. 놀라운 음질과 강력한 기능이 함께합니다.', DATE_ADD(CURDATE(),INTERVAL 1 DAY), 0, 'Dell XPS 13: 얇고 가벼운 디자인과 탁월한 성능을 결합한 최고의 울트라북', 1);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Samsung Galaxy Tab S7+: 대화면 디스플레이와 강력한 성능으로 완성된 태블릿을 만나보세요. 탁월한 다기능을 지원하여 업무와 엔터테인먼트를 모두 만족시켜줍니다.', DATE_ADD(CURDATE(),INTERVAL 2 DAY), 0, 'Fitbit Versa 3: 건강 추적과 운동 기능을 갖춘 스마트 워치로 더욱 활발한 라이프스타일을 즐기세요', 2);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Sony WH-1000XM3: 우수한 소음 차단과 정교한 음질로 탁월한 무선 헤드폰을 경험하세요. 편안한 착용감과 뛰어난 성능이 돋보입니다.', DATE_ADD(CURDATE(),INTERVAL 3 DAY), 0, 'LG NanoCell 90 시리즈: 선명한 화질과 넓은 시야각을 제공하는 최신형 4K 스마트 TV', 3);
INSERT INTO post (content, date, report, title, member_id) VALUES ('LG CX OLED TV: 깊은 검은색과 생생한 색감으로 몰입감 있는 시청 경험을 선사합니다. 최신 기술로 완성된 디스플레이의 아름다움을 눈으로 확인하세요.', DATE_ADD(CURDATE(),INTERVAL 2 DAY),  0, 'Razer BlackWidow Elite: 정밀한 타이핑 경험과 개인화된 RGB 조명으로 향상된 게이밍 키보드', 1);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Apple iPad Pro (2021): M1 칩과 프로 수준의 성능으로 뛰어난 태블릿을 만나보세요. 탁월한 속도와 다기능을 갖춘 iPad Pro는 창의적인 작업을 위한 최고의 도구입니다.', DATE_ADD(CURDATE(),INTERVAL 1 DAY), 0, 'Amazon Echo Dot (4세대): 스마트 홈 컨트롤과 음악 스트리밍을 위한 작고 강력한 스마트 스피커', 2);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Samsung Galaxy Buds Live: 독특한 디자인과 깊은 베이스를 갖춘 무선 이어폰으로 음악을 새롭게 경험하세요. 편안한 착용과 뛰어난 음질을 동시에 누리세요.', DATE_ADD(CURDATE(),INTERVAL 4 DAY), 0, 'GoPro HERO10 Black: 더욱 진화한 액션 카메라로 놀라운 모험을 기록하세요', 3);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Sony PlayStation 5: 네이티브 4K 게임과 실감나는 게임 플레이 경험을 즐겨보세요. 탁월한 그래픽과 반응성이 돋보이는 PlayStation 5는 게이머들을 위한 최고의 선택입니다.', DATE_ADD(CURDATE(),INTERVAL 5 DAY), 0, 'Apple MacBook Air (M1): 가볍고 강력한 퍼포먼스를 자랑하는 최신 노트북', 1);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Microsoft Surface Pro 7: 가볍고 다용도로 사용할 수 있는 프리미엄 태블릿으로 생산성을 극대화하세요. 뛰어난 성능', DATE_ADD(CURDATE(),INTERVAL 6 DAY), 0, 'Sony WH-1000XM4 vs Bose QuietComfort 35 II: 최고의 노이즈 캔슬링 헤드폰 대결', 2);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Nintendo Switch: 유연한 게임 플레이 스타일로 즐기는 다양한 게임 컨텐츠를 만나보세요. 휴대성과 다양한 컨트롤러 옵션으로 게임의 즐거움을 극대화합니다.', DATE_ADD(CURDATE(),INTERVAL 7 DAY), 0, 'Samsung Galaxy S21 Ultra: 최고급 스마트폰의 완벽한 결정체', 3);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Samsung Galaxy S21 Ultra: 대화면 디스플레이와 멋진 카메라로 최고의 성능을 자랑하는 프리미엄 스마트폰입니다.', DATE_ADD(CURDATE(),INTERVAL 8 DAY), 0, 'Logitech MX Master 3: 편리한 사용성과 정밀한 조작을 제공하는 고급 마우스', 1);
INSERT INTO post (content, date, report, title, member_id) VALUES ('iPhone 13 Pro: 뛰어난 성능과 화려한 디자인, 탁월한 카메라로 완성된 애플의 플래그십 휴대폰입니다.', DATE_ADD(CURDATE(),INTERVAL 4 DAY), 0, 'Canon EOS R5: 무한한 창조성과 고품질 영상 촬영을 위한 프로급 미러리스 카메라', 2);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Google Pixel 6 Pro: 최고의 카메라 성능과 순수한 안드로이드 경험을 제공하는 강력한 스마트폰입니다.', DATE_ADD(CURDATE(),INTERVAL 2 DAY), 0, 'LG OLED C1 시리즈: 깊은 검은색과 생생한 색감으로 즐기는 시네마틱한 시청 경험', 3);
INSERT INTO post (content, date, report, title, member_id) VALUES ('OnePlus 9 Pro: 부드러운 디자인과 강력한 성능으로 탁월한 사용자 경험을 제공하는 휴대폰입니다.', DATE_ADD(CURDATE(),INTERVAL 1 DAY), 0, 'JBL Flip 5: 휴대성과 탁월한 음질을 겸비한 방수 블루투스 스피커', 1);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Xiaomi Mi 11 Ultra: 고화질 디스플레이와 탁월한 사양, 강력한 배터리로 완성된 휴대폰입니다.', DATE_ADD(CURDATE(),INTERVAL 7 DAY), 0, 'Microsoft Surface Laptop 4: 우아한 디자인과 뛰어난 성능을 갖춘 프리미엄 노트북', 2);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Sony Xperia 1 III: 탁월한 카메라와 생생한 디스플레이로 멋진 시각적 경험을 제공하는 휴대폰입니다.', DATE_ADD(CURDATE(),INTERVAL 3 DAY), 0, 'Apple Watch Series 6: 혁신적인 건강 기능과 스타일리시한 디자인을 가진 스마트워치', 3);
INSERT INTO post (content, date, report, title, member_id) VALUES ('LG Velvet 2 Pro: 스타일리시한 디자인과 풍부한 기능으로 완성된 휴대폰입니다.', DATE_ADD(CURDATE(),INTERVAL 4 DAY), 0, 'Nintendo Switch OLED 모델: 더욱 선명한 디스플레이와 향상된 게임 플레이를 즐겨보세요', 1);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Motorola Edge Plus: 대화면 디스플레이와 강력한 성능으로 탁월한 멀티미디어 경험을 선사하는 휴대폰입니다.', DATE_ADD(CURDATE(),INTERVAL 5 DAY), 0, 'Sony WF-1000XM4: 완벽한 음질과 액티브 노이즈 캔슬링을 제공하는 무선 이어폰', 2);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Nokia 8.3 5G: 안정적인 성능과 깔끔한 디자인으로 높은 가치를 가진 휴대폰입니다.', DATE_ADD(CURDATE(),INTERVAL 6 DAY), 0, 'Samsung Odyssey G9: 커브드 디스플레이와 강력한 게이밍 성능을 갖춘 고해상도 모니터', 3);
INSERT INTO post (content, date, report, title, member_id) VALUES ('ASUS ROG Phone 5: 고성능 프로세서와 게이밍 최적화 기능으로 게이머들에게 완벽한 선택인 휴대폰입니다.', DATE_ADD(CURDATE(),INTERVAL 4 DAY), 0, 'Apple iPad Pro (2021): M1 칩과 스마트 트랙패드로 더욱 강력한 태블릿 경험을 제공', 1);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Samsung Galaxy Note 20 Ultra: 큰 화면과 S Pen으로 놀라운 생산성과 멋진 멀티태스킹을 경험할 수 있는 스마트폰입니다.', DATE_ADD(CURDATE(),INTERVAL 2 DAY), 0, 'Bose Frames Tempo: 스포츠 안경과 블루투스 스피커의 편리한 결합', 2);
INSERT INTO post (content, date, report, title, member_id) VALUES ('iPhone SE (2020): 강력한 성능과 저렴한 가격으로 제시간에 신속하게 일을 처리할 수 있는 애플의 휴대폰입니다.', DATE_ADD(CURDATE(),INTERVAL 1 DAY), 0, 'LG Gram 17: 가벼움과 오래 가는 배터리 수명으로 더욱 편리한 이동성을 선사하는 노트북', 3);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Google Pixel 5: 순수한 안드로이드 경험과 우수한 카메라로 멋진 사진을 쉽게 찍을 수 있는 휴대폰입니다', DATE_ADD(CURDATE(),INTERVAL 1 DAY), 0, 'Fitbit Charge 4: 활동 추적과 건강 관리 기능을 갖춘 신축성 있는 트래커', 1);
INSERT INTO post (content, date, report, title, member_id) VALUES ('OnePlus 9: 부드러운 디자인과 탁월한 성능을 가진 휴대폰으로 빠른 충전 기능도 갖추고 있습니다.', DATE_ADD(CURDATE(),INTERVAL 1 DAY), 0, 'Sony X950H: 생생한 이미지 품질과 탁월한 HDR 재생을 제공하는 안드로이드 TV', 2);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Xiaomi Mi 11: 고화질 디스플레이와 강력한 사양으로 탁월한 가치를 제공하는 휴대폰입니다.', DATE_ADD(CURDATE(),INTERVAL 1 DAY), 0, 'Razer Blade 15: 고성능 게이밍과 스타일리시한 디자인을 한꺼번에 만나보세요', 3);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Sony Xperia 5 II: 우수한 카메라와 생생한 디스플레이로 멋진 시각적 경험을 제공하는 휴대폰입니다.', DATE_ADD(CURDATE(),INTERVAL 1 DAY), 0, 'Amazon Kindle Paperwhite (10세대): 높은 해상도 디스플레이와 방수 기능을 갖춘 전자책 리더', 1);
INSERT INTO post (content, date, report, title, member_id) VALUES ('LG Wing: 독특한 스윙 디자인과 다중 화면으로 색다른 사용자 경험을 선사하는 휴대폰입니다.', DATE_ADD(CURDATE(),INTERVAL 3 DAY), 0, 'GoPro HERO8 Black: 안정적인 영상 촬영과 확장 가능한 모듈 디자인을 가진 액션 카메라', 2);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Motorola Moto G Power: 탁월한 배터리 수명과 실용적인 기능으로 장시간 사용이 필요한 사용자에게 적합한 휴대폰입니다.', DATE_ADD(CURDATE(),INTERVAL 2 DAY), 0, 'Apple iMac (M1): 혁신적인 디자인과 강력한 성능을 갖춘 대형 올인원 컴퓨터', 3);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Nokia 7.2: 깔끔한 디자인과 안정적인 성능으로 신뢰성 있는 휴대폰을 찾는 사용자에게 어울리는 모델입니다.', DATE_ADD(CURDATE(),INTERVAL 1 DAY), 0, 'Samsung Galaxy Note 20 Ultra: S 펜과 멋진 디자인으로 완성된 프리미엄 스마트폰', 1);
INSERT INTO post (content, date, report, title, member_id) VALUES ('ASUS ZenFone 8: 소형 사이즈에 강력한 성능을 담은 휴대폰으로 휴대성과 성능을 모두 챙길 수 있습니다.', DATE_ADD(CURDATE(),INTERVAL 1 DAY), 0, 'Sony WH-1000XM3 vs Bose QuietComfort 35 II: 최고의 노이즈 캔슬링 헤드폰 비교', 2);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Dell XPS 13: 얇고 가벼운 디자인에 강력한 성능과 놀라운 디스플레이를 갖춘 프리미엄 노트북으로 전체적으로 완벽한 사용자 경험을 제공합니다.', DATE_ADD(CURDATE(),INTERVAL 2 DAY), 0, 'LG CX OLED TV: 깊은 검은색과 화려한 색감으로 빛나는 시네마틱 시청 경험', 3);
INSERT INTO post (content, date, report, title, member_id) VALUES ('MacBook Pro (M1): Apple의 강력한 M1 칩과 멋진 디자인으로 최고의 성능과 생산성을 즐길 수 있는 탁월한 선택입니다.', DATE_ADD(CURDATE(),INTERVAL 3 DAY), 0, 'Logitech G502 HERO: 정밀한 조작과 개인화된 커스터마이징으로 완성된 게이밍 마우스', 1);
INSERT INTO post (content, date, report, title, member_id) VALUES ('HP Spectre x360: 세련된 디자인과 편안한 터치스크린, 다기능을 갖춘 2-in-1 노트북으로 다양한 작업을 효율적으로 수행할 수 있습니다.', DATE_ADD(CURDATE(),INTERVAL 4 DAY), 0, 'Canon EOS R6: 높은 해상도와 빠른 초점 속도로 탁월한 사진과 비디오 촬영을 선사하는 미러리스 카메라', 2);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Lenovo ThinkPad X1 Carbon: 탁월한 내구성과 편안한 키보드, 우수한 보안 기능으로 비즈니스 사용자에게 이상적인 노트북입니다.', DATE_ADD(CURDATE(),INTERVAL 5 DAY), 0, 'Bose QuietComfort Earbuds: 탁월한 소음 차단과 편안한 착용감을 갖춘 무선 이어폰', 3);
INSERT INTO post (content, date, report, title, member_id) VALUES ('ASUS ROG Zephyrus G14: 강력한 게이밍 성능과 가볍고 휴대성이 좋은 디자인으로 게이머에게 완벽한 선택입니다.', DATE_ADD(CURDATE(),INTERVAL 6 DAY), 0, 'Microsoft Surface Book 3: 다재다능한 2-in-1 디자인과 강력한 성능을 가진 프리미엄 노트북', 1);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Acer Swift 3: 합리적인 가격에 속도와 스타일을 모두 갖춘 가벼운 노트북으로 일상적인 작업을 효율적으로 처리할 수 있습니다.', DATE_ADD(CURDATE(),INTERVAL 7 DAY), 0, 'Apple AirPods Max: 고급스러운 디자인과 우수한 오디오 품질을 제공하는 무선 헤드폰', 2);
INSERT INTO post (content, date, report, title, member_id) VALUES ('Microsoft Surface Laptop 4: 우아한 디자인과 탁월한 터치스크린, 원활한 성능으로 유연한 사용자 경험을 제공하는 노트북입니다.', DATE_ADD(CURDATE(),INTERVAL 7 DAY), 0, 'Nintendo Switch Lite: 휴대성과 저렴한 가격으로 즐기는 멋진 게임 경험', 3);
INSERT INTO post (content, date, report, title, member_id) VALUES ('LG Gram 17: 가벼운 무게에도 불구하고 큰 화면과 장기간 사용 가능한 배터리로 탁월한 이동성과 성능을 제공하는 노트북입니다.', DATE_ADD(CURDATE(),INTERVAL 3 DAY), 0, 'Samsung QLED Q80T: 생생한 화질과 탁월한 게이밍 성능을 갖춘 스마트 TV', 1);

INSERT INTO post_image(post_id, image) VALUES (1, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (2, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (3, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (4, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (5, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (6, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (7, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (8, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (9, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (10, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (11, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (12, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (13, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (14, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (15, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (16, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (17, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (18, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (19, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (20, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (21, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (22, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (23, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (24, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (25, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (26, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (27, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
INSERT INTO post_image(post_id, image) VALUES (16, 'https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__480.jpg');
