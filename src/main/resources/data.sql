INSERT INTO store (id, store_name) VALUES (1, '음식점');
INSERT INTO store (id, store_name) VALUES (2, '카페');
INSERT INTO store (id, store_name) VALUES (3, '패스트푸드');


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