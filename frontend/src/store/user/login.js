import {defineStore} from "pinia";
import axios from "axios";


export const loginStore = defineStore("login", {
    id: "login",

    state: () => ({
        email : "",
        password: ""
    }),

    actions: {

        // 로그인
        async login() {
            axios.defaults.headers.post['Content-Type'] = 'multipart/form-data';

            const res = await axios.post(`api/user/login`, this.$state)

            const data = res.data || {}
            const result = data.result || 0

            return result
        }

    }
})