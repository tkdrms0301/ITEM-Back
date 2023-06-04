INSERT INTO member(address, email, name, nickname, password, phone_number, point, role_type, account)
VALUES ('test address1', 'test1', '일반유저_ID', '일반유저_ID', '$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK', '010-5651-5957', 50000, 'MEMBER', '농협 1234');
INSERT INTO member(address, email, name, nickname, password, phone_number, point, role_type, account)
VALUES ('test address2', 'test2', '판매자_ID', '판매자_ID', '$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK', '010-8765-1234', 20000, 'SELLER', '기업 1234');
INSERT INTO member(address, email, name, nickname, password, phone_number, point, role_type, account)
VALUES ('경북 구미시 옥계2공단로 310-1', 'test3', '정비사_ID', '정비사_ID', '$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK', '010-8765-1234', 500000, 'MECHANIC', '대구은행 1234');
INSERT INTO member(address, email, name, nickname, password, phone_number, point, role_type, account)
VALUES ('test address1', 'test4', '일반유저2_ID', '일반유저2_ID', '$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK', '010-5651-5957', 50000, 'MEMBER', '농협 123411');
INSERT INTO member(address, email, name, nickname, password, phone_number, point, role_type, account)
VALUES ('test address1', 'test5', '일반유저3_ID', '일반유저3_ID', '$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK', '010-5651-5957', 50000, 'MEMBER', '농협 123411');
INSERT INTO member(address, email, name, nickname, password, phone_number, point, role_type, account)
VALUES ('test address1', 'test6', '일반유저4_ID', '일반유저4_ID', '$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK', '010-5651-5957', 50000, 'MEMBER', '농협 123411');
INSERT INTO member(address, email, name, nickname, password, phone_number, point, role_type, account)
VALUES ('test address1', 'test7', '일반유저5_ID', '일반유저5_ID', '$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK', '010-5651-5957', 50000, 'MEMBER', '농협 123411');
INSERT INTO member(address, email, name, nickname, password, phone_number, point, role_type, account)
VALUES ('test address1', 'test8', '일반유저6_ID', '일반유저6_ID', '$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK', '010-5651-5957', 50000, 'MEMBER', '농협 123411');
INSERT INTO member(address, email, name, nickname, password, phone_number, point, role_type, account)
VALUES ('test address1', 'test0', '포인트관리_ID', '포인트관리_ID', '$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK', '010-5651-5957', 0, 'ADMIN', '농협 123411');


INSERT INTO seller(company_address, company_name, company_number, company_phone_number, description, member_id)
VALUES ('company_address', 'company_name', 'company_number', 'company_phone_number', 'seller description', 2);
INSERT INTO repair_shop(description, shop_name, shop_phone_number, member_id, repair_service_type, shop_address)
VALUES ('test description1', 'test shop1', '010-1234-5678', 3, '노트북', 'shop_address_test3');

INSERT INTO repair_service(description, service_name, service_type, service_price, repair_shop_id)
VALUES ('갤럭시 폰에 대한 전체적인 점검을 진행합니다.', '안드로이드 폰 점검', '점검', 25000, 3);
INSERT INTO repair_service(description, service_name, service_type,  service_price, repair_shop_id)
VALUES ('자체 프로그램 오류 발생 시 해결해드립니다.', '소프트웨어 오류 해결','교환', 25000 , 3);
INSERT INTO repair_service(description, service_name, service_type,  service_price, repair_shop_id)
VALUES ('노트북 및 데스크탑 수리해드립니다.', '노트북/데스크탑 수리', '수리', 100000,3);

INSERT INTO official_repair_shop(address, description, name, phone_number)
VALUES ('경북 구미시 옥계2공단로 310-1', 'test description2', 'test shop2', '010-1234-5678');

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
INSERT INTO product(product_name, category_brand_id) VALUES ('2022 맥북에어 MLY33KH/A', 1); # 2;
INSERT INTO product(product_name, category_brand_id) VALUES ('2023 맥북프로16 MNWA3KH/A', 1); # 3;
INSERT INTO product(product_name, category_brand_id) VALUES ('2020 맥북에어 MGNA3KH/A', 1); # 4;
INSERT INTO product(product_name, category_brand_id) VALUES ('2017 맥북프로13 MPXT2KH/A', 1); # 5;
INSERT INTO product(product_name, category_brand_id) VALUES ('2020 맥북에어 MGN93KH/A CTO', 1); # 6;
INSERT INTO product(product_name, category_brand_id) VALUES ('2019 맥북에어 MVFM2KH/A', 1); # 7;
INSERT INTO product(product_name, category_brand_id) VALUES ('2020 맥북에어 MVH22KH/A CTO', 1); # 8;
INSERT INTO product(product_name, category_brand_id) VALUES ('2017 맥북프로15 MPTV2KH/A', 1); # 9;
INSERT INTO product(product_name, category_brand_id) VALUES ('2016 맥북프로13 MLVP2KH/A', 1); # 10;

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
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 25000, '안드로이드 폰 점검', '수리 서비스 제공', 3);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, -25000, '안드로이드 폰 점검', '수리 서비스 이용', 1);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 25000, '소프트웨어 오류 해결', '수리 서비스 제공', 3);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, -25000, '소프트웨어 오류 해결', '수리 서비스 이용', 1);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 100000, '노트북/데스크탑 수리', '수리 서비스 제공', 3);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, -100000, '노트북/데스크탑 수리', '수리 서비스 이용', 1);


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

INSERT INTO reservation(member_id, repair_shop_id, reservation_date, state, comment, application_date, it_device_id)
VALUES (1, 3, '2023-06-01 17:30:00',  '예약 대기',  '노트북 및 데스크탑 수리해드립니다.','2023-05-01 17:30:00', 2 );
INSERT INTO repair_service_reservation(reservation_id, repair_service_id) VALUES (1, 1);

INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('수리가 빨라서 좋았습니다.', 5, 1, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('깔끔하게 고쳐졌어요.', 5, 1, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('안고쳐져서 고생했는데 감사합니다.', 5, 1, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('자주 이용할게요', 5, 1, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('수리가 조금 늦어져서 아쉬워여.', 4, 4, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('별로네요', 1, 4, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('수리가 빨라서 좋았습니다.', 5, 5, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('깔끔하게 고쳐졌어요.', 5, 5, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('안고쳐져서 고생했는데 감사합니다.', 5, 6, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('신속하고 전문적인 서비스를 받을 수 있어요', 5, 6, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('고객 만족도를 최우선으로 생각하고 있어요!', 5, 6, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('경험 풍부한 전문가들이 정확하고 신속한 수리를 해줘요!', 5, 6, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('합리적인 가격으로 고품질 서비스를 제공해요!', 5, 1, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('최신 기술과 도구를 사용하여 정밀한 수리를 해줘요!', 5, 1, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('친절하고 상세한 설명으로 문제를 해결해줘요!', 5, 6, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('원격으로도 문제를 진단하고 해결해줘요!', 5, 5, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('수리 시간을 최소화하여 불편을 최대한 줄여줘요!', 5, 1, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('원격으로도 문제를 진단하고 해결해줘요!', 5, 4, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('고장 진단과 수리 후에도 품질 보증을 제공해요', 5, 4, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('신속한 서비스와 함께 문제 예방을 위한 유용해요', 5, 6, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('고객의 개인정보와 기기 정보를 안전하게 보호해줘요', 5, 6, 3);
INSERT INTO repair_service_review(content, rating, member_id, repair_shop_id) VALUES ('전자기기 정비소에서는 고장 진단과 수리 후에도 품질 보증을 제공해요', 5, 4, 3);

INSERT INTO sale_product(product_id, seller_id, cost, comment,delivery_company,delivery_cost,kind, name, thumbnail_url ) VALUES (1, 2, 1190000, '이 시대의 최고의 컴퓨터','대한통운',2500 ,'컴퓨터', '완본체','https://item0container.blob.core.windows.net/image/56fef2b9-e2c2-4741-ac14-25bfcffaf630_%EC%BB%B4%ED%84%B01.jpg' );
INSERT INTO product_image_detail(url, sale_product_id) VALUES ('https://item0container.blob.core.windows.net/image/8684ab1c-6e4d-45f2-a63f-d9284046eb8b_%EC%BB%B4%EC%84%A41.jpg', 1);
# INSERT INTO market_review(comment, date, rating, member_id, sale_product_id) VALUES ('리뷰 내용입니다.', '2021-05-01 17:30:00', 5, 1, 1);

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