INSERT INTO store (id, store_name) VALUES (1, '음식점');
INSERT INTO store (id, store_name) VALUES (2, '카페');
INSERT INTO store (id, store_name) VALUES (3, '패스트푸드');

INSERT INTO video (store_id, video_url) VALUES (1, 'https://www.youtube.com/watch?v=BghcDdmeToM');
INSERT INTO video (store_id, video_url) VALUES (2, 'https://youtu.be/-_FS661Q1nw');
INSERT INTO video (store_id, video_url) VALUES (3, 'https://youtu.be/i6tRr8r-2l0');


INSERT INTO word (type, word, description,created_at, updated_at)
VALUES
    ('CAFE', '디카페인', '카페인을 뺀 것',NOW(),NOW()),
    ('CAFE', '라떼', '우유가 섞인 커피 (달달하게 요청 가능)',NOW(),NOW()),
    ('CAFE', '마키아토', '에스프레소에 우유 거품을 얹은 커피 (조금 달달한 편)',NOW(),NOW()),
    ('CAFE', '버블티', '쫀득한 펄이 들어있는 밀크티',NOW(),NOW()),
    ('CAFE', '베버리지', '모든 종류의 음료를 지칭, 주로 커피 외 달달한 음료를 지칭함',NOW(),NOW()),
    ('CAFE', '베이커리', '빵류',NOW(),NOW()),
    ('CAFE', '블렌딩 티', '여러 종류 찻잎을 섞어 만든 차 (메뉴에 따라 달 수 있음)',NOW(),NOW()),
    ('CAFE', '샷 추가', '커피를 더 진하게 하도록 추가하는 것',NOW(),NOW()),
    ('CAFE', '스파클링티', '탄산이 들어간 음료',NOW(),NOW()),
    ('CAFE', '아포가토', '아이스크림에 에스프레소를 부은 디저트',NOW(),NOW()),
    ('CAFE', '에스프레소', '소주 한 잔 정도로 작고 진하게 내린 커피',NOW(),NOW()),
    ('CAFE', '에이드', '과일청과 탄산수를 섞어 만든 음료',NOW(),NOW()),
    ('CAFE', '제로 슈거', '혈당에 영향을 주지 않는 당류, 혹은 저당',NOW(),NOW()),
    ('CAFE', '콜드브루', '찬물로 오랜 시간 우려낸 커피',NOW(),NOW()),
    ('CAFE', '테이크아웃', '매장 밖으로 포장하는 것',NOW(),NOW()),
    ('CAFE', '티', '단 맛이 적은 차',NOW(),NOW()),
    ('CAFE', '프라푸치노', '얼음을 갈아만든 음료',NOW(),NOW()),
    ('CAFE', '프룻 / 프루트', '과일',NOW(),NOW()),
    ('CAFE', '플랫치노', '얼음을 갈아만든 음료',NOW(),NOW()),
    ('FOOD', '디저트', '후식식',NOW(),NOW()),
    ('FOOD', '리미티드', '한정 수량 메뉴',NOW(),NOW()),
    ('FOOD', '바우처', '결제에 사용할 수 있는 할인권',NOW(),NOW()),
    ('FOOD', '베스트', '해당 식당에서 제일 잘 나가는 메뉴',NOW(),NOW()),
    ('FOOD', '사이드', '주 메뉴에 곁들여 먹는 음식',NOW(),NOW()),
    ('FOOD', '샷', '술 한 잔',NOW(),NOW()),
    ('FOOD', '셀프바', '스스로 음식을 가져갈 수 있는 장소',NOW(),NOW()),
    ('FOOD', '스캔', '바코드를 읽는 것',NOW(),NOW()),
    ('FOOD', '슬롯', '카드를 넣는 구멍',NOW(),NOW()),
    ('FOOD', '시그니처', '해당 식당의 대표 메뉴',NOW(),NOW()),
    ('FOOD', '오더', '주문',NOW(),NOW()),
    ('FOOD', '이벤트', '할인이나 증정 등 특별 행사',NOW(),NOW()),
    ('FOOD', '커스텀', '기호에 맞춰서 선택',NOW(),NOW()),
    ('FOOD', '테이블번호', '내가 앉은 자리의 번호',NOW(),NOW()),
    ('FOOD', '토핑', '음식 위에 추가로 얹는 재료',NOW(),NOW()),
    ('FOOD', '트레이', '쟁반',NOW(),NOW()),
    ('FOOD', '페이', '결제하기, 주로 간편 결제 수단을 뜻하는 용어',NOW(),NOW()),
    ('FOOD', '프로모션', '할인이나 증정 등 특별 행사',NOW(),NOW()),
    ('FOOD', '피크타임', '사람이 가장 붐비는 시간대',NOW(),NOW()),
    ('FOOD', '픽업', '주문한 음식을 찾아가는 것',NOW(),NOW()),
    ('FOOD', '후렌치후라이', '감자튀김',NOW(),NOW());

-- 메뉴 삽입
INSERT INTO menu (menu_id, store_id, category, menu_name, menu_price, image_url)
VALUES
    (1, 1, '시즌메뉴', '방어 사시미', 40000, 'https://ordereasybucket.s3.ap-northeast-2.amazonaws.com/kiosk/restaurant/fish.png'),
    (2, 1, '시즌메뉴', '굴탕면', 21000, 'https://ordereasybucket.s3.ap-northeast-2.amazonaws.com/kiosk/restaurant/oyster.png'),
    (3, 1, '시즌메뉴', '고구마맛탕', 12000, 'https://ordereasybucket.s3.ap-northeast-2.amazonaws.com/kiosk/restaurant/sweetpotato.png'),
    (4, 1, '런치세트', '초밥 정식', 12000, 'https://ordereasybucket.s3.ap-northeast-2.amazonaws.com/kiosk/restaurant/sushi.png'),
    (5, 1, '런치세트', '우동 정식', 11000, 'https://ordereasybucket.s3.ap-northeast-2.amazonaws.com/kiosk/restaurant/noddle.png'),
    (6, 1, '메인', '모듬꼬치', 18000, 'https://ordereasybucket.s3.ap-northeast-2.amazonaws.com/kiosk/restaurant/bbq.png'),
    (7, 1, '메인', '짬뽕탕 (면 포함)', 16000, 'https://ordereasybucket.s3.ap-northeast-2.amazonaws.com/kiosk/restaurant/rednoddle.png'),
    (8, 1, '사이드', '닭튀김', 8000, 'https://ordereasybucket.s3.ap-northeast-2.amazonaws.com/kiosk/restaurant/sidechicken.png'),
    (9, 2, '커피', '아메리카노', 1700, 'https://ordereasybucket.s3.ap-northeast-2.amazonaws.com/kiosk/cafe/coffee.png'),
    (10, 2, '커피', '콜드브루', 2800, 'https://ordereasybucket.s3.ap-northeast-2.amazonaws.com/kiosk/cafe/coldbrew.png'),
    (11, 2, '논커피', '아이스티', 2100, 'https://ordereasybucket.s3.ap-northeast-2.amazonaws.com/kiosk/cafe/icetea.png'),
    (12, 2, '디저트', '소금빵', 5100, 'https://ordereasybucket.s3.ap-northeast-2.amazonaws.com/kiosk/cafe/bread.png'),
    (13, 2, '디저트', '크림치즈베이글', 6000, 'https://ordereasybucket.s3.ap-northeast-2.amazonaws.com/kiosk/cafe/bagel.png'),
    (14, 2, '시즌메뉴', '딸기주스', 6000, 'https://ordereasybucket.s3.ap-northeast-2.amazonaws.com/kiosk/cafe/berryjuice.png'),
    (15, 2, '시즌메뉴', '딸기라떼', 7000, 'https://ordereasybucket.s3.ap-northeast-2.amazonaws.com/kiosk/cafe/berrylatte.png'),
    (16, 2, '시즌메뉴', '꿀밤라떼', 7500, 'https://ordereasybucket.s3.ap-northeast-2.amazonaws.com/kiosk/cafe/chestnut.png'),
    (17, 3, '햄버거', '비프치즈버거', 6500, 'https://ordereasybucket.s3.ap-northeast-2.amazonaws.com/kiosk/fastfood/befbugger.png'),
    (18, 3, '햄버거', '치킨마일드버거', 7200, 'https://ordereasybucket.s3.ap-northeast-2.amazonaws.com/kiosk/fastfood/chibugger.png'),
    (19, 3, '햄버거', '핫포크버거', 6000, NULL),
    (20, 3, '사이드', '감자튀김', 1500, NULL),
    (21, 3, '사이드', '치즈스틱', 1500, NULL),
    (22, 3, '사이드', '스윗소스', 300, NULL),
    (23, 3, '음료', '콜라', 1500),
    (24, 3, '사이드', '사이다', 1500),
    (25, 3, '디저트', '아이스크림', 1200);


-- 메뉴 ID가 2이라고 가정 (menu_id = 2)
INSERT INTO option (menu_id, option_name, option_price, option_title, option_image_url)
VALUES (2, '순하게', 0, '맵기 옵션(필수)', NULL);
INSERT INTO option (menu_id, option_name, option_price, option_title, option_image_url)
VALUES (2, '약간 맵게', 0, '맵기 옵션(필수)', NULL);
INSERT INTO option (menu_id, option_name, option_price, option_title, option_image_url)
VALUES (2, '아주 맵게', 0, '맵기 옵션(필수)', NULL);
INSERT INTO option (menu_id, option_name, option_price, option_title, option_image_url)
VALUES (2, '면 사리', 6000, '추가 옵션(선택)', NULL);
INSERT INTO option (menu_id, option_name, option_price, option_title, option_image_url)
VALUES (2, '굴 50g', 8000, '추가 옵션(선택)', NULL);

INSERT INTO option (menu_id, option_name, option_price, option_title, option_image_url)
VALUES (14, '얼음 적게', 0, '무료 옵션', NULL);
INSERT INTO option (menu_id, option_name, option_price, option_title, option_image_url)
VALUES (14, '얼음 많이', 0, '무료 옵션', NULL);
INSERT INTO option (menu_id, option_name, option_price, option_title, option_image_url)
VALUES (14, '덜달게', 0, '무료 옵션', NULL);
INSERT INTO option (menu_id, option_name, option_price, option_title, option_image_url)
VALUES (14, '샷 추가', 300, '유료 옵션', NULL);
INSERT INTO option (menu_id, option_name, option_price, option_title, option_image_url)
VALUES (14, '휘핑 추가', 500, '유료 옵션', NULL);


INSERT INTO option (menu_id, option_name, option_price, option_title, option_image_url)
VALUES (20, '스몰(S)', 1000, '사이즈 옵션', NULL);
INSERT INTO option (menu_id, option_name, option_price, option_title, option_image_url)
VALUES (20, '미디움(M)', 1500, '사이즈 옵션', NULL);
INSERT INTO option (menu_id, option_name, option_price, option_title, option_image_url)
VALUES (20, '라지(L)', 2000, '사이즈 옵션', NULL);
INSERT INTO option (menu_id, option_name, option_price, option_title, option_image_url)
VALUES (20, '소금 O', 0, '재료 옵션', NULL);
INSERT INTO option (menu_id, option_name, option_price, option_title, option_image_url)
VALUES (20, '소금 X', 0, '재료 옵션', NULL);



INSERT INTO problem (problem_id, store_id, problem)
VALUES (1, 1, '굴탕면 하나 주문할게요. 맵기는 아주 맵게, 굴 50g도 추가할게요! 사이드로 먹을 닭튀김 하나도 소스랑 같이 주문해주세요.');

--문제 정답
INSERT INTO solution (id, question_id) VALUES (1, 1);
INSERT INTO solution$answer_entity (id, solution_id, total_price) VALUES
    (1, 1, 37000);
INSERT INTO solution$answer_entity$menu_entity (id, answer_id, menu_name, menu_quantity, menu_price) VALUES
                                                                                  (1, 1, '굴탕면', 1, 29000),
                                                                                  (2, 1, '닭튀김', 1, 8000);
INSERT INTO solution$answer_entity$menu_entity$option_group_entity (id, menu_id, option_title) VALUES
                                                                (1, 1, '추가 옵션'),
                                                                (2, 1, '맵기 옵션'),
                                                                (3, 2, '소스 옵션(선택)');
INSERT INTO solution$answer_entity$menu_entity$option_group_entity$option_e (id, option_group_id, option_name, option_price) VALUES
                                                                               (1, 1, '굴 50g', 8000),
                                                                               (2, 2, '아주 맵게', 0),
                                                                               (3, 3, '소스 주세요', 0);

