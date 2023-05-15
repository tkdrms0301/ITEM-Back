INSERT INTO member(address, email, name, nickname, password, phone_number, point, role_type)
VALUES ('test address1', 'test1', '일반유저_ID', '일반유저_ID', '$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK', '010-5651-5957', 0, 'MEMBER');
INSERT INTO member(address, email, name, nickname, password, phone_number, point, role_type)
VALUES ('test address2', 'test2', '판매자_ID', '판매자_ID', '$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK', '010-8765-1234', 0, 'SELLER');
INSERT INTO member(address, email, name, nickname, password, phone_number, point, role_type)
VALUES ('test address3', 'test3', '정비사_ID', '정비사_ID', '$2a$10$2GQ29M4weMNnaN3uCiSra.kkW1SLsDX5mPnDYAGYFFbHy1j7f0PfK', '010-8765-1234', 0, 'MECHANIC');

INSERT INTO seller(company_address, company_name, company_number, company_phone_number, description, member_id)
VALUES ('company_address', 'company_name', 'company_number', 'company_phone_number', 'seller description', 2);
INSERT INTO repair_shop(description, shop_name, shop_phone_number, member_id)
VALUES ('mechanic description', 'shop_name', 'shop_phone_number', 3);

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

# 카테고리-브랜드
# 컴퓨터
INSERT INTO category_brand(brand_id, category_id) VALUES (1, 1);
INSERT INTO category_brand(brand_id, category_id) VALUES (2, 1);
INSERT INTO category_brand(brand_id, category_id) VALUES (3, 1);
INSERT INTO category_brand(brand_id, category_id) VALUES (4, 1);
INSERT INTO category_brand(brand_id, category_id) VALUES (5, 1);
INSERT INTO category_brand(brand_id, category_id) VALUES (6, 1);
INSERT INTO category_brand(brand_id, category_id) VALUES (7, 1);

# 노트북
INSERT INTO category_brand(brand_id, category_id) VALUES (1, 2);
INSERT INTO category_brand(brand_id, category_id) VALUES (2, 2);
INSERT INTO category_brand(brand_id, category_id) VALUES (3, 2);
INSERT INTO category_brand(brand_id, category_id) VALUES (4, 2);
INSERT INTO category_brand(brand_id, category_id) VALUES (5, 2);
INSERT INTO category_brand(brand_id, category_id) VALUES (7, 2);
INSERT INTO category_brand(brand_id, category_id) VALUES (8, 2);
INSERT INTO category_brand(brand_id, category_id) VALUES (9, 2);
INSERT INTO category_brand(brand_id, category_id) VALUES (10, 2);

# 휴대폰
INSERT INTO category_brand(brand_id, category_id) VALUES (1, 3);
INSERT INTO category_brand(brand_id, category_id) VALUES (10, 3);
INSERT INTO category_brand(brand_id, category_id) VALUES (11, 3);

# 테블릿
INSERT INTO category_brand(brand_id, category_id) VALUES (1, 4);
INSERT INTO category_brand(brand_id, category_id) VALUES (10, 4);
INSERT INTO category_brand(brand_id, category_id) VALUES (11, 4);

# 구독권
set @now = '';
SELECT NOW() into @now;
INSERT INTO subscription(start_date, member_id) values (@now, 1);
INSERT INTO subscription(start_date, member_id) values (@now, 2);

# 제품
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2022 맥북에어 MLY33KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2021 맥북프로16 MK183KH/A M1 Pro', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2023 맥북프로14 MPHE3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2023 맥북프로14 MPHH3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2022 맥북에어 MLXY3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2022 맥북에어 MLXW3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2023 맥북프로16 MNW83KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2021 맥북프로14 MKGQ3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2022 맥북에어 MLY13KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2022 맥북프로13 MNEJ3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2023 맥북프로16 MNWD3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2023 맥북프로14 MPHK3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2021 맥북프로16 MK1H3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2022 맥북프로13 MNEH3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2022 맥북에어 MLXX3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2023 맥북프로16 MNWA3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2023 맥북프로16 MNWE3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2022 맥북프로13 MNEP3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북에어 MGN63KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2023 맥북프로14 MPHG3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2023 맥북프로14 MPHF3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2022 맥북프로13 MNEQ3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2022 맥북에어 MLY03KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2021 맥북프로14 MKGP3KH/A M1 Pro 8core', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2023 맥북프로16 MNW93KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북에어 MGN93KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북프로13 MYD82KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2021 맥북프로14 MKGR3KH/A M1 Pro 8core', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2022 맥북에어 MLY43KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2021 맥북프로16 MK193KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2023 맥북프로16 MNWC3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북프로13 MWP52KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북프로13 MYD92KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북프로13 MWP82KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북프로13 MYDC2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2021 맥북프로16 MK1A3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북프로13 MWP72KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2021 맥북프로16 MK1E3KH/A M1 Pro', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2023 맥북프로14 MPHJ3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북에어 MGN73KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북에어 MGND3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2022 맥북에어 MLY23KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2021 맥북프로14 MKGP3KH/A M1 Pro 10core', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2021 맥북프로14 MKGT3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북프로16 MVVJ2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2021 맥북프로16 MK183KH/A M1 Max', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2021 맥북프로16 MK1F3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북프로16 MVVK2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북프로13 MWP42KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북프로13 MV962KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2018 맥북프로15 MR942KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2021 맥북프로14 MKGP3KH/A M1 Max', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2021 맥북프로14 MKGR3KH/A M1 Max', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2018 맥북프로15 MR932KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북에어 MGNA3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2017 맥북프로13 MPXT2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북에어 MGN93KH/A CTO', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북프로16 MVVM2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북프로16 MVVL2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북에어 MWTL2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북프로13 MUHN2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북에어 MVFJ2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2018 맥북프로13 MR9V2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북에어 MVH22KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2018 맥북프로13 MR9Q2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2017 맥북프로15 MPTT2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북에어 MGNE3KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북에어 MWTJ2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북프로13 MV972KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2015 맥북프로15 MJLQ2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2018 맥북프로13 MR9U2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2017 맥북프로15 MPTR2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2021 맥북프로14 MKGR3KH/A M1 Pro 10core', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2018 맥북프로13 MR9R2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2018 맥북프로15 MR962KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2017 맥북프로13 MPXQ2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2016 맥북프로13 MLH12KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북프로15 MV942KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2017 맥북프로13 MPXW2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2017 맥북프로13 MPXV2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2016 맥북프로15 MLW72KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북에어 MVH52KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2017 맥북프로13 MPXU2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북에어 MVH42KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북프로15 MV952KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북에어 MVFN2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북프로15 MV902KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북프로15 MV912KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2018 맥북프로15 MUQH2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('맥북에어 MC503KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2015 맥북에어13 MMGF2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북에어 MVFK2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북에어 MVFM2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북프로13 MV9A2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2021 맥북프로16 MK1E3KH/A M1 Max', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북프로13 MUHQ2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2016 맥북프로13 MNQG2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('맥북에어 MC965KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2018 맥북프로15 MR952KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2017 맥북프로13 MPXX2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2016 맥북프로13 MLL42KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북에어 MGN63KH/A CTO', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북에어 MWTK2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2015 맥북 MK4N2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('맥북프로 MD101KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북프로13 MYDA2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2018 맥북에어 MRE92KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2018 맥북에어 MREF2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2018 맥북에어 MREE2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('맥북프로 MC700KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2016 맥북 MLHE2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2014 맥북프로13 ME865KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2017 맥북 MNYH2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2016 맥북 MMGM2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2020 맥북에어 MVH22KH/A CTO', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2022 맥북프로13 MNEH3LL/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북프로13 MUHP2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북프로13 MUHR2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북에어 MVFL2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북에어 MVFH2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북프로13 MV992KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북프로15 MV922KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2019 맥북프로15 MV932KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2018 맥북에어 MREC2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2018 맥북에어 MREA2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2018 맥북에어 MRE82KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2018 맥북프로15 MR972KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2017 맥북프로13 MPXR2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2017 맥북프로13 MPXY2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2017 맥북프로15 MPTU2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2017 맥북프로15 MPTV2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2016 맥북프로13 MLVP2KH/A', true, 22);
INSERT INTO product(product_name, role_type, kind_id) VALUES ('2016 맥북프로15 MLH32KH/A', true, 22);

