document.getElementById('loginKakao').addEventListener('click', function () {
    const clientIdKakao = '62c4fb360eaebe4a49cb66c5b40fc416';
    const redirectUriKakao = 'http://localhost:8080/login/kakao/index.html';
    window.location.href = `https://kauth.kakao.com/oauth/authorize?client_id=${clientIdKakao}&redirect_uri=${redirectUriKakao}&response_type=code`;
});

