INSERT INTO store (id, store_name) VALUES (1, '음식점');
INSERT INTO store (id, store_name) VALUES (2, '카페');
INSERT INTO store (id, store_name) VALUES (3, '패스트푸드');


INSERT INTO video (store_id, video_url) VALUES (2, 'https://youtu.be/-_FS661Q1nw');
INSERT INTO video (store_id, video_url) VALUES (3, 'https://youtu.be/i6tRr8r-2l0');

INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (1, 1, '시즌메뉴', '방어 사시미', 40000);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (2, 1, '시즌메뉴', '굴탕면', 21000);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (3, 1, '시즌메뉴', '고구마맛탕', 12000);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (4, 1, '런치세트', '초밥 정식', 12000);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (5, 1, '런치세트', '우동 정식', 11000);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (6, 1, '메인', '모듬꼬치', 18000);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (7, 1, '메인', '짬뽕탕 (면 포함)', 16000);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (8, 1, '사이드', '닭튀김', 8000);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (9, 2, '커피', '아메리카노', 1700);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (10, 2, '커피', '콜드브루', 2800);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (11, 2, '논커피', '아이스티', 2100);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (12, 2, '디저트', '소금빵', 5100);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (13, 2, '디저트', '크림치즈베이글', 6000);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (14, 2, '시즌메뉴', '딸기주스', 6000);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (15, 2, '시즌메뉴', '딸기라떼', 7000);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (16, 2, '시즌메뉴', '꿀밤라떼', 7500);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (17, 3, '햄버거', '비프치즈버거', 6500);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (18, 3, '햄버거', '치킨마일드버거', 7200);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (19, 3, '햄버거', '핫포크버거', 6000);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (20, 3, '사이드', '감자튀김', 1500);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (21, 3, '사이드', '치즈스틱', 1500);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (22, 3, '사이드', '스윗소스', 300);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (23, 3, '음료', '콜라', 1500);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (24, 3, '사이드', '사이다', 1500);
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price)
VALUES (25, 3, '디저트', '아이스크림', 1200);


-- 메뉴 ID가 1이라고 가정 (menu_id = 1)
INSERT INTO option (menu_id, option_name, option_price, option_title, option_image_url)
VALUES (1, '소', 0, '사이즈 옵션(필수)', NULL);

INSERT INTO option (menu_id, option_name, option_price, option_title, option_image_url)
VALUES (1, '중', 8000, '사이즈 옵션(필수)', NULL);

INSERT INTO option (menu_id, option_name, option_price, option_title, option_image_url)
VALUES (1, '대', 12000, '사이즈 옵션(필수)', NULL);

