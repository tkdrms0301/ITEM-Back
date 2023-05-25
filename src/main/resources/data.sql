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

INSERT INTO category(category_name, image_url, is_part) VALUES
('컴퓨터', 'https://item0container.blob.core.windows.net/image/computer.webp', false); # 1;
INSERT INTO category(category_name, image_url, is_part) VALUES
('노트북', 'https://item0container.blob.core.windows.net/image/noteBook.png', false); # 2;
INSERT INTO category(category_name, image_url, is_part) VALUES
('휴대폰', 'https://item0container.blob.core.windows.net/image/smartPhone.png', false); # 3;
INSERT INTO category(category_name, image_url, is_part) VALUES
('테블릿', 'https://item0container.blob.core.windows.net/image/tablet.png', false); # 4;
INSERT INTO category(category_name, image_url, is_part) VALUES ('그래픽카드', '', true); # 5;
INSERT INTO category(category_name, image_url, is_part) VALUES ('cpu', '', true); # 6;
INSERT INTO category(category_name, image_url, is_part) VALUES ('프린터기', '', true); # 7;
INSERT INTO category(category_name, image_url, is_part) VALUES ('메인보드', '', true); # 8;
INSERT INTO category(category_name, image_url, is_part) VALUES ('RAM', '', true); # 9;
INSERT INTO category(category_name, image_url, is_part) VALUES ('SSD', '', true); # 10;
INSERT INTO category(category_name, image_url, is_part) VALUES ('HDD', '', true); # 11;
INSERT INTO category(category_name, image_url, is_part) VALUES ('케이스', '', true); # 12;
INSERT INTO category(category_name, image_url, is_part) VALUES ('파워', '', true); # 13;
INSERT INTO category(category_name, image_url, is_part) VALUES ('쿨러', '', true); # 14;
INSERT INTO category(category_name, image_url, is_part) VALUES ('키보드', '', true); # 15;
INSERT INTO category(category_name, image_url, is_part) VALUES ('SSD', '', true); # 16;
INSERT INTO category(category_name, image_url, is_part) VALUES ('NAS', '', true); # 17;
INSERT INTO category(category_name, image_url, is_part) VALUES ('USB', '', true); # 18;
INSERT INTO category(category_name, image_url, is_part) VALUES ('공유기', '', true); # 19;
INSERT INTO category(category_name, image_url, is_part) VALUES ('USB허브', '', true); # 20;
INSERT INTO category(category_name, image_url, is_part) VALUES ('랜카드', '', true); # 21;
INSERT INTO category(category_name, image_url, is_part) VALUES ('스위치허브', '', true); # 22;
INSERT INTO category(category_name, image_url, is_part) VALUES ('모니터', '', true); # 23;

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
INSERT INTO category_brand(brand_id, category_id) VALUES (2, 23); # 27 / 2 삼성 23 모니터;

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
INSERT INTO data(count, vocab, product_id) VALUES (90, '예쁘다', 3);
INSERT INTO data(count, vocab, product_id) VALUES (100, '예쁘다', 4);
INSERT INTO data(count, vocab, product_id) VALUES (110, '예쁘다', 6);
INSERT INTO data(count, vocab, product_id) VALUES (140, '예쁘다', 7);
INSERT INTO data(count, vocab, product_id) VALUES (130, '예쁘다', 8);
INSERT INTO data(count, vocab, product_id) VALUES (210, '멋있다', 9);
INSERT INTO data(count, vocab, product_id) VALUES (220, '빠르다', 10);
INSERT INTO data(count, vocab, product_id) VALUES (310, '빠르다', 11);
INSERT INTO data(count, vocab, product_id) VALUES (215, '성능', 12);
INSERT INTO data(count, vocab, product_id) VALUES (120, '빠르다', 13);
INSERT INTO data(count, vocab, product_id) VALUES (100, '빠르다', 14);

# 긍/부정 데이터;