import { defineStore } from "pinia";
import axios from "axios";
import {router} from "@/router";

export const signupStore = defineStore("signup",  {
    id: "signup",

    state: () => ({
        password: "",
        email: "",
        nickname: ""
    }),

    getters: {
        errorPassword() {
            if (this.password.length === 0) return "☑ 비밀번호를 입력해줘. 6자 이상 이여야 해. 엣헴.";
            if (this.password.length < 6) return "☑ 비밀번호는 6자 이상 입력해야 된다니까~?";
            return "";
        },

        errorEmail() {
            if (this.email.length === 0) return "☑ 이메일을 입력해줘. 아직 공란인걸?";
            return "";
        },

        errorEmailForm() {
            if (!checkEmail(this.email)) return "☑ 이메일 형식이 이상해~ 다시 입력해줘.";
            return "";
        },

        errorNickname() {
            if (this.nickname.length === 0) return "☑ 닉네임을 입력해줘. 어떤 이름이 좋으려나~?";
            return "";
        },

        canSignup() {
            return (this.password !== "") &&
                (this.password.length >= 6) &&
                (this.errorPassword === "") &&
                (this.email !== "") &&
                (this.errorEmail === "") &&
                (this.errorEmailForm === "") &&
                (this.nickname !== "") &&
                (this.errorNickname === "")
        },
    },

    actions: {
        async register() {
            await axios.post(`api/user/signup`, JSON.stringify(this.$state));
            console.log(this.$state);

            alert("회원가입이 완료되었습니다.");

            router.push(`/user/login`);
        },
    }
});

// 이메일 유효성 검사
function checkEmail(email) {
    try {
        let pattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
        return (pattern.test(email));
    } catch (error) {
        return false;
    }
}