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

INSERT INTO kind(name) VALUES ('그래픽카드');
INSERT INTO kind(name) VALUES ('cpu');
INSERT INTO kind(name) VALUES ('프린터기');
INSERT INTO kind(name) VALUES ('메인보드');
INSERT INTO kind(name) VALUES ('RAM');
INSERT INTO kind(name) VALUES ('SSD');
INSERT INTO kind(name) VALUES ('HDD');
INSERT INTO kind(name) VALUES ('케이스');
INSERT INTO kind(name) VALUES ('파워');
INSERT INTO kind(name) VALUES ('쿨러');
INSERT INTO kind(name) VALUES ('키보드');
INSERT INTO kind(name) VALUES ('마우스');
INSERT INTO kind(name) VALUES ('SSD');
INSERT INTO kind(name) VALUES ('HDD');
INSERT INTO kind(name) VALUES ('NAS');
INSERT INTO kind(name) VALUES ('USB');
INSERT INTO kind(name) VALUES ('공유기');
INSERT INTO kind(name) VALUES ('USB허브');
INSERT INTO kind(name) VALUES ('랜카드');
INSERT INTO kind(name) VALUES ('스위치허브');
INSERT INTO kind(name) VALUES ('컴퓨터');
INSERT INTO kind(name) VALUES ('노트북');
INSERT INTO kind(name) VALUES ('휴대폰');
INSERT INTO kind(name) VALUES ('태블릿');

INSERT INTO category(category_name) VALUES ('컴퓨터');
INSERT INTO category(category_name) VALUES ('노트북');
INSERT INTO category(category_name) VALUES ('휴대폰');
INSERT INTO category(category_name) VALUES ('테블릿');

INSERT INTO brand(brand_name) VALUES ('삼성');
INSERT INTO brand(brand_name) VALUES ('LG');
INSERT INTO brand(brand_name) VALUES ('기가바이트');
INSERT INTO brand(brand_name) VALUES ('지포스');
INSERT INTO brand(brand_name) VALUES ('인텔');
INSERT INTO brand(brand_name) VALUES ('라이젠');
INSERT INTO brand(brand_name) VALUES ('MSI');
INSERT INTO brand(brand_name) VALUES ('ASUS');
INSERT INTO brand(brand_name) VALUES ('레노버');
INSERT INTO brand(brand_name) VALUES ('애플');
INSERT INTO brand(brand_name) VALUES ('샤오미');

# 카테고리-브랜드;
# 컴퓨터;
INSERT INTO category_brand(brand_id, category_id) VALUES (1, 1);
INSERT INTO category_brand(brand_id, category_id) VALUES (2, 1);
INSERT INTO category_brand(brand_id, category_id) VALUES (3, 1);
INSERT INTO category_brand(brand_id, category_id) VALUES (4, 1);
INSERT INTO category_brand(brand_id, category_id) VALUES (5, 1);
INSERT INTO category_brand(brand_id, category_id) VALUES (6, 1);
INSERT INTO category_brand(brand_id, category_id) VALUES (7, 1);

# 노트북;
INSERT INTO category_brand(brand_id, category_id) VALUES (1, 2);
INSERT INTO category_brand(brand_id, category_id) VALUES (2, 2);
INSERT INTO category_brand(brand_id, category_id) VALUES (3, 2);
INSERT INTO category_brand(brand_id, category_id) VALUES (4, 2);
INSERT INTO category_brand(brand_id, category_id) VALUES (5, 2);
INSERT INTO category_brand(brand_id, category_id) VALUES (7, 2);
INSERT INTO category_brand(brand_id, category_id) VALUES (8, 2);
INSERT INTO category_brand(brand_id, category_id) VALUES (9, 2);
INSERT INTO category_brand(brand_id, category_id) VALUES (10, 2);

# 휴대폰;
INSERT INTO category_brand(brand_id, category_id) VALUES (1, 3);
INSERT INTO category_brand(brand_id, category_id) VALUES (10, 3);
INSERT INTO category_brand(brand_id, category_id) VALUES (11, 3);

# 테블릿;
INSERT INTO category_brand(brand_id, category_id) VALUES (1, 4);
INSERT INTO category_brand(brand_id, category_id) VALUES (10, 4);
INSERT INTO category_brand(brand_id, category_id) VALUES (11, 4);

# 구독권
set @now = '';
SELECT NOW() into @now;
INSERT INTO subscription(start_date, member_id) values (@now, 1);
INSERT INTO subscription(start_date, member_id) values (@now, 2);

# 제품;
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2022 맥북에어 MLY33KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2023 맥북프로16 MNWA3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북에어 MGNA3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2017 맥북프로13 MPXT2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북에어 MGN93KH/A CTO', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북에어 MVFM2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북에어 MVH22KH/A CTO', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2017 맥북프로15 MPTV2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2016 맥북프로13 MLVP2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2016 맥북프로15 MLH32KH/A', true, 22);

# 브랜드 - 제품;
INSERT INTO brand_product(brand_id, product_id) VALUES (10, 1);
INSERT INTO brand_product(brand_id, product_id) VALUES (10, 2);
INSERT INTO brand_product(brand_id, product_id) VALUES (10, 3);
INSERT INTO brand_product(brand_id, product_id) VALUES (10, 4);
INSERT INTO brand_product(brand_id, product_id) VALUES (10, 5);
INSERT INTO brand_product(brand_id, product_id) VALUES (10, 6);
INSERT INTO brand_product(brand_id, product_id) VALUES (10, 7);
INSERT INTO brand_product(brand_id, product_id) VALUES (10, 8);
INSERT INTO brand_product(brand_id, product_id) VALUES (10, 9);
INSERT INTO brand_product(brand_id, product_id) VALUES (10, 10);

INSERT INTO it_device(directly_registered_name, brand_product_id, member_id)
VALUES (null, 1, 1);
INSERT INTO it_device(directly_registered_name, brand_product_id, member_id)
VALUES (null, 2, 1);

# 포인트 이용내역
set @now = '';
SELECT NOW() into @now;
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 50000, '아이폰12 구매', '상품 구매', 1);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 10000, '리뷰 추천 누적 10회', '리뷰 추천 누적', 1);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 15000, '리뷰 추천 누적 20회', '리뷰 추천 누적', 2);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 50000, '그래픽카드 GTX1060 부품 구매', '상품 구매', 3);
INSERT INTO point_history(date, point, service_name, service_type, member_id) VALUES (@now, 15000, '리뷰 추천 누적 20회', '리뷰 추천 누적', 3);
