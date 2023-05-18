INSERT INTO member(address, email, name, nickname, password, phone_number, point, role_type, account)
VALUES ('test address1', 'test1', '일반유저_ID', '일반유저_ID', '$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK', '010-5651-5957', 15000, 'MEMBER', '농협 1234');
INSERT INTO member(address, email, name, nickname, password, phone_number, point, role_type, account)
VALUES ('test address2', 'test2', '판매자_ID', '판매자_ID', '$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK', '010-8765-1234', 20000, 'SELLER', '기업 1234');
INSERT INTO member(address, email, name, nickname, password, phone_number, point, role_type, account)
VALUES ('경북 구미시 옥계2공단로 310-1', 'test3', '정비사_ID', '정비사_ID', '$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK', '010-8765-1234', 5000, 'MECHANIC', '대구은행 1234');

INSERT INTO seller(company_address, company_name, company_number, company_phone_number, description, member_id)
VALUES ('company_address', 'company_name', 'company_number', 'company_phone_number', 'seller description', 2);
INSERT INTO repair_shop(description, shop_name, shop_phone_number, member_id)
VALUES ('test description1', 'test shop1', '010-1234-5678', 3);

INSERT INTO repair_service(description, service_name, service_type, repair_shop_id)
VALUES ('갤럭시 폰에 대한 전체적인 점검을 진행합니다.', '안드로이드 폰 점검', '점검', 3);
INSERT INTO repair_service(description, service_name, service_type, repair_shop_id)
VALUES ('자체 프로그램 오류 발생 시 해결해드립니다.', '소프트웨어 오류 해결', '교환', 3);
INSERT INTO repair_service(description, service_name, service_type, repair_shop_id)
VALUES ('노트북 및 데스크탑 수리해드립니다.', '노트북/데스크탑 수리', '수리', 3);

INSERT INTO official_repair_shop(address, description, name, phone_number)
VALUES ('경북 구미시 옥계2공단로 310-1', 'test description2', 'test shop2', '010-1234-5678');

INSERT INTO kind(name) VALUES ('그래픽카드'); #1;
INSERT INTO kind(name) VALUES ('cpu'); #2;
INSERT INTO kind(name) VALUES ('프린터기'); #3;
INSERT INTO kind(name) VALUES ('메인보드'); #4;
INSERT INTO kind(name) VALUES ('RAM'); #5;
INSERT INTO kind(name) VALUES ('SSD'); #6;
INSERT INTO kind(name) VALUES ('HDD'); #7;
INSERT INTO kind(name) VALUES ('케이스'); #8;
INSERT INTO kind(name) VALUES ('파워'); #9;
INSERT INTO kind(name) VALUES ('쿨러'); #10;
INSERT INTO kind(name) VALUES ('키보드'); #11;
INSERT INTO kind(name) VALUES ('마우스'); #12;
INSERT INTO kind(name) VALUES ('SSD'); #13;
INSERT INTO kind(name) VALUES ('HDD'); #14;
INSERT INTO kind(name) VALUES ('NAS'); #15;
INSERT INTO kind(name) VALUES ('USB'); #16;
INSERT INTO kind(name) VALUES ('공유기'); #17;
INSERT INTO kind(name) VALUES ('USB허브'); #18;
INSERT INTO kind(name) VALUES ('랜카드'); #19;
INSERT INTO kind(name) VALUES ('스위치허브'); #20;
INSERT INTO kind(name) VALUES ('컴퓨터'); #21;
INSERT INTO kind(name) VALUES ('노트북'); #22;
INSERT INTO kind(name) VALUES ('휴대폰'); #23;
INSERT INTO kind(name) VALUES ('태블릿'); #24;

INSERT INTO category(category_name) VALUES ('컴퓨터'); #1;
INSERT INTO category(category_name) VALUES ('노트북'); #2;
INSERT INTO category(category_name) VALUES ('휴대폰'); #3;
INSERT INTO category(category_name) VALUES ('테블릿'); #4;

INSERT INTO brand(brand_name) VALUES ('완본체'); #1;
INSERT INTO brand(brand_name) VALUES ('삼성'); #2;
INSERT INTO brand(brand_name) VALUES ('LG'); #3;
INSERT INTO brand(brand_name) VALUES ('기가바이트'); #4;
INSERT INTO brand(brand_name) VALUES ('지포스'); #5;
INSERT INTO brand(brand_name) VALUES ('인텔'); #6;
INSERT INTO brand(brand_name) VALUES ('라이젠'); #7;
INSERT INTO brand(brand_name) VALUES ('MSI'); #8;
INSERT INTO brand(brand_name) VALUES ('ASUS'); #9;
INSERT INTO brand(brand_name) VALUES ('레노버'); #10;
INSERT INTO brand(brand_name) VALUES ('애플'); #11;
INSERT INTO brand(brand_name) VALUES ('샤오미'); #12;

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
INSERT INTO category_brand(brand_id, category_id) VALUES (2, 2); # 1 / 2 삼성 2 노트북;
INSERT INTO category_brand(brand_id, category_id) VALUES (3, 2); # 2 / 3 LG 2 노트북;
INSERT INTO category_brand(brand_id, category_id) VALUES (4, 2); # 3 / 4 기가바이트 2 노트북;
INSERT INTO category_brand(brand_id, category_id) VALUES (5, 2); # 4 / 5 지포스 2 노트북;
INSERT INTO category_brand(brand_id, category_id) VALUES (6, 2); # 5 / 6 인텔 2 노트북;
INSERT INTO category_brand(brand_id, category_id) VALUES (7, 2); # 6 / 7 라이젠 2 노트북;
INSERT INTO category_brand(brand_id, category_id) VALUES (8, 2); # 7 / 8 MSI 2 노트북;
INSERT INTO category_brand(brand_id, category_id) VALUES (9, 2); # 8 / 9 ASUS 2 노트북;
INSERT INTO category_brand(brand_id, category_id) VALUES (11, 2); # 9 / 11 애플 2 노트북;

# 휴대폰;
INSERT INTO category_brand(brand_id, category_id) VALUES (2, 3); # 2 삼성;
INSERT INTO category_brand(brand_id, category_id) VALUES (11, 3); # 11 애플;
INSERT INTO category_brand(brand_id, category_id) VALUES (12, 3); # 12 샤오미;

# 테블릿;
INSERT INTO category_brand(brand_id, category_id) VALUES (2, 4); # 1 / 2 삼성 4 테블릿;
INSERT INTO category_brand(brand_id, category_id) VALUES (11, 4); # 2 / 11 애플 4 테블릿;
INSERT INTO category_brand(brand_id, category_id) VALUES (12, 4); # 3 / 12 샤오미 4 테블릿;

# 구독권
set @now = '';
SELECT NOW() into @now;
INSERT INTO subscription(start_date, member_id) values (@now, 1);
INSERT INTO subscription(start_date, member_id) values (@now, 2);

# 제품 is_component true : 부품, false : 완성품 및 완본체;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('완본체', 21, 'FINISHED_PRODUCT'); # 1 / 21 컴퓨터;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('2022 맥북에어 MLY33KH/A', 22, 'COMPLETE_PRODUCT'); # 2 / 22 노트북;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('2023 맥북프로16 MNWA3KH/A', 22, 'COMPLETE_PRODUCT'); # 3 / 22 노트북;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('2020 맥북에어 MGNA3KH/A', 22, 'COMPLETE_PRODUCT'); # 4 / 22 노트북;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('2017 맥북프로13 MPXT2KH/A', 22, 'COMPLETE_PRODUCT'); # 5 / 22 노트북;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('2020 맥북에어 MGN93KH/A CTO', 22, 'COMPLETE_PRODUCT'); # 6 / 22 노트북;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('2019 맥북에어 MVFM2KH/A', 22, 'COMPLETE_PRODUCT'); # 7 / 22 노트북;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('2020 맥북에어 MVH22KH/A CTO', 22, 'COMPLETE_PRODUCT'); # 8 / 22 노트북;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('2017 맥북프로15 MPTV2KH/A', 22, 'COMPLETE_PRODUCT'); # 9 / 22 노트북;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('2016 맥북프로13 MLVP2KH/A', 22, 'COMPLETE_PRODUCT'); # 10 / 22 노트북;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('2016 맥북프로15 MLH32KH/A', 22, 'COMPLETE_PRODUCT'); # 11 / 22 노트북;

INSERT INTO product(product_name, kind_id, product_type) VALUES ('삼성 게임용 230511 (16GB, M.2 500GB)', 21, 'COMPLETE_PRODUCT'); # 12 / 21 컴퓨터;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('삼성 PRO - I5M51 (16GB, M.2 512GB)', 21, 'COMPLETE_PRODUCT'); # 13 / 21 컴퓨터;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('LG 875 게이밍울트라560X', 21, 'COMPLETE_PRODUCT'); # 14 / 21 컴퓨터;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('LG 퍼포먼스PC', 21, 'COMPLETE_PRODUCT'); # 15 / 21 컴퓨터;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('LG 프리워커 F5600', 21, 'COMPLETE_PRODUCT'); # 16 / 21 컴퓨터;

INSERT INTO product(product_name, kind_id, product_type) VALUES ('삼성전자 갤럭시S22 울트라', 23, 'COMPLETE_PRODUCT'); # 17 / 23 휴대폰;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('삼성전자 갤럭시S23', 23, 'COMPLETE_PRODUCT'); # 18 / 23 휴대폰;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('삼성전자 갤럭시S23 울트라', 23, 'COMPLETE_PRODUCT'); # 19 / 23 휴대폰;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('삼성전자 Z 플립', 23, 'COMPLETE_PRODUCT'); # 20 / 23 휴대폰;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('APPLE 아이폰14 프로', 23, 'COMPLETE_PRODUCT'); # 21 / 23 휴대폰;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('APPLE 아이폰14', 23, 'COMPLETE_PRODUCT'); # 22 / 23 휴대폰;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('APPLE 아이폰13 미니', 23, 'COMPLETE_PRODUCT'); # 23 / 23 휴대폰;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('APPLE 아이폰14 프로 맥스', 23, 'COMPLETE_PRODUCT'); # 24 / 23 휴대폰;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('샤오미 홍미 노트12 프로', 23, 'COMPLETE_PRODUCT'); # 25 / 23 휴대폰;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('샤오미 홍미 노트11 프로', 23, 'COMPLETE_PRODUCT'); # 26 / 23 휴대폰;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('샤오미 홍미 노트10 프로', 23, 'COMPLETE_PRODUCT'); # 27 / 23 휴대폰;

INSERT INTO product(product_name, kind_id, product_type) VALUES ('삼성전자 갤럭시탭S8', 24, 'COMPLETE_PRODUCT'); # 28 / 24 테블릿;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('삼성전자 갤럭시탭S7', 24, 'COMPLETE_PRODUCT'); # 29 / 24 테블릿;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('삼성전자 갤럭시탭A8', 24, 'COMPLETE_PRODUCT'); # 30 / 24 테블릿;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('레노버 Legion Y700', 24, 'COMPLETE_PRODUCT'); # 31 / 24 테블릿;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('레노버 XiaoxinPad 2022', 24, 'COMPLETE_PRODUCT'); # 32 / 24 테블릿;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('레노버 탭 P11 플러스', 24, 'COMPLETE_PRODUCT'); # 33 / 24 테블릿;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('APPLE 아이패드 프로 11', 24, 'COMPLETE_PRODUCT'); # 34 / 24 테블릿;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('APPLE 아이패드 프로 12.9', 24, 'COMPLETE_PRODUCT'); # 35 / 24 테블릿;
INSERT INTO product(product_name, kind_id, product_type) VALUES ('APPLE 아이패드 9세대', 24, 'COMPLETE_PRODUCT'); # 36 / 24 테블릿;

# 브랜드 - 제품;
INSERT INTO brand_product(brand_id, product_id) VALUES (1, 1); # 1 / 1 완본체 1 완본체;
INSERT INTO brand_product(brand_id, product_id) VALUES (11, 2); # 2 / 11 애플 2 2022 맥북에어;
INSERT INTO brand_product(brand_id, product_id) VALUES (11, 3); # 3 / 11 애플 3 2023 맥북프로16;
INSERT INTO brand_product(brand_id, product_id) VALUES (11, 4); # 4 / 11 애플 4 2020 맥북에어;
INSERT INTO brand_product(brand_id, product_id) VALUES (11, 5); # 5 / 11 애플 5 2017 맥북프로13;
INSERT INTO brand_product(brand_id, product_id) VALUES (11, 6); # 6 / 11 애플 6 2020 맥북에어;
INSERT INTO brand_product(brand_id, product_id) VALUES (11, 7); # 7 / 11 애플 7 2019 맥북에어;
INSERT INTO brand_product(brand_id, product_id) VALUES (11, 8); # 8 / 11 애플 8 2020 맥북에어;
INSERT INTO brand_product(brand_id, product_id) VALUES (11, 9); # 9 / 11 애플 9 2017 맥북프로15;
INSERT INTO brand_product(brand_id, product_id) VALUES (11, 10); # 10 / 11 애플 10 2016 맥북프로13;
INSERT INTO brand_product(brand_id, product_id) VALUES (11, 11); # 11 / 11 애플 11 2016 맥북프로15;
INSERT INTO brand_product(brand_id, product_id) VALUES (2, 12); # 12 / 2 삼성 12 삼성 게임용 230511 (16GB, M.2 500GB);
INSERT INTO brand_product(brand_id, product_id) VALUES (2, 13); # 13 / 2 삼성 13 삼성 PRO - I5M51 (16GB, M.2 512GB);
INSERT INTO brand_product(brand_id, product_id) VALUES (3, 14); # 14 / 3 LG 14 LG 875 게이밍울트라560X;
INSERT INTO brand_product(brand_id, product_id) VALUES (3, 15); # 15 / 3 LG 15 LG 퍼포먼스PC;
INSERT INTO brand_product(brand_id, product_id) VALUES (3, 16); # 16 / 3 LG 16 LG 프리워커 F5600;
INSERT INTO brand_product(brand_id, product_id) VALUES (2, 17); # 17 / 2 삼성 17 삼성전자 갤럭시S22 울트라;
INSERT INTO brand_product(brand_id, product_id) VALUES (2, 18); # 18 / 2 삼성 18 삼성전자 갤럭시S23;
INSERT INTO brand_product(brand_id, product_id) VALUES (2, 19); # 19 / 2 삼성 19 삼성전자 갤럭시S23 울트라;
INSERT INTO brand_product(brand_id, product_id) VALUES (2, 20); # 20 / 2 삼성 20 삼성전자 Z 플립;
INSERT INTO brand_product(brand_id, product_id) VALUES (11, 21); # 21 / 11 애플 21 APPLE 아이폰14 프로;
INSERT INTO brand_product(brand_id, product_id) VALUES (11, 22); # 22 / 11 애플 22 APPLE 아이폰14;
INSERT INTO brand_product(brand_id, product_id) VALUES (11, 23); # 23 / 11 애플 23 APPLE 아이폰13 미니;
INSERT INTO brand_product(brand_id, product_id) VALUES (11, 24); # 24 / 11 애플 24 APPLE 아이폰14 프로 맥스;
INSERT INTO brand_product(brand_id, product_id) VALUES (12, 25); # 25 / 12 샤오미 25 샤오미 홍미 노트12 프로;
INSERT INTO brand_product(brand_id, product_id) VALUES (12, 26); # 26 / 12 샤오미 26 샤오미 홍미 노트11 프로;
INSERT INTO brand_product(brand_id, product_id) VALUES (12, 27); # 27 / 12 샤오미 27 샤오미 홍미 노트10 프로;
INSERT INTO brand_product(brand_id, product_id) VALUES (2, 28); # 28 / 2 삼성 28 삼성전자 갤럭시탭S8;
INSERT INTO brand_product(brand_id, product_id) VALUES (2, 29); # 29 / 2 삼성 29 삼성전자 갤럭시탭S7;
INSERT INTO brand_product(brand_id, product_id) VALUES (2, 30); # 30 / 2 삼성 30 삼성전자 갤럭시탭A8;
INSERT INTO brand_product(brand_id, product_id) VALUES (10, 31); # 30 / 10 레노버 31 Legion Y700;
INSERT INTO brand_product(brand_id, product_id) VALUES (10, 32); # 30 / 10 레노버 32 XiaoxinPad 2022;
INSERT INTO brand_product(brand_id, product_id) VALUES (10, 33); # 30 / 10 레노버 33 레노버 탭 P11 플러스;
INSERT INTO brand_product(brand_id, product_id) VALUES (11, 34); # 30 / 11 애플 34 APPLE 아이패드 프로 11;
INSERT INTO brand_product(brand_id, product_id) VALUES (11, 35); # 30 / 11 애플 35 APPLE 아이패드 프로 12.9;
INSERT INTO brand_product(brand_id, product_id) VALUES (11, 36); # 30 / 11 애플 36 APPLE 아이패드 9세대;

# IT 기기 관리;
INSERT INTO it_device(directly_registered_name, category_id, brand_id, product_id, member_id) VALUES (null, 2, 11, 2, 1);
INSERT INTO it_device(directly_registered_name, category_id, brand_id, product_id, member_id) VALUES (null, 2, 11, 3, 1);
INSERT INTO it_device(directly_registered_name, category_id, brand_id, product_id, member_id) VALUES (null, 2, 11, 4, 1);

# 포인트 이용내역;
set @now = '';
SELECT NOW() into @now;
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 50000, '아이폰12 구매', '상품 구매', 1);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 10000, '리뷰 추천 누적 10회', '리뷰 추천 누적', 1);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 15000, '리뷰 추천 누적 20회', '리뷰 추천 누적', 2);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 50000, '그래픽카드 GTX1060 부품 구매', '상품 구매', 3);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 15000, '리뷰 추천 누적 20회', '리뷰 추천 누적', 3);
