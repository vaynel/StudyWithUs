export default {
    submit(request) {
        console.log("signup.submit - request:", request);

        return {
            data: {
                // TODO: 에러 테스트 할 때는 아래 코드를 사용합니다.
                // errorCode: 100,
                // errorMessage: "이미 등록된 이메일입니다.",
            },
        }
    },
};