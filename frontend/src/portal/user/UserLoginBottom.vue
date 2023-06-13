
<template>
  <div class="container_login">
    <div class="modal_login">
      <form
        enctype="multipart/form-data"
        class="wrapper_login"
        @submit.prevent="submitLoginForm"
      >
        <div>
          <label>이메일</label><br>
          <input
            v-model="login.email"
            type="text"
          >
        </div>
        <div :style="`margin-bottom: 10px`">
          <label>비밀번호</label><br>
          <input
            v-model="login.password"
            type="text"
          >
        </div>
        <button @click="doLogin()">
          <span :style="`margin-top:2px`">로그인</span>
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import {loginStore} from "@/store/user/login";
import {router} from "@/router";

export default {

  name: 'Login',

  inject: ['loginCheck'],
  setup() {
    const login = loginStore();
    return {
      login: login
    }
  },

  methods: {
    submitLoginForm() {
      console.log('전송완료');
    },

    async doLogin () {
      const login = this.login
      const result = await login.login()

      if (result > 0) {
        router.push(`/menu/home`);

      } else {
        // 로그인 실패
      }

      this.loginCheck(result)

    }
  }
}
</script>
