
<template>
  <ModalFormA class="container_signup">
    <template #contents>
      <form
        class="wrapper_signup"
        @submit.prevent
      >
        <div :style="`margin-top: 50px`">
          <label>이메일</label><br>
          <input
            v-model="signup.email"
            type="text"
          >
        </div>
        <div>
          <label>비밀번호</label><br>
          <input
            v-model="signup.password"
            type="text"
          >
        </div>
        <div :style="`margin-bottom: 15px`">
          <label>닉네임</label><br>
          <input
            v-model="signup.nickname"
            type="text"
          >
        </div>
        <button
          :disabled="!signup.canSignup"
          @click="signup.register()"
        >
          <span :style="`margin-top: 2px`">회원가입</span>
        </button>
      </form>
    </template>
  </ModalFormA>
</template>

<script>
import ModalFormA from "@/components/modal/ModalFormA";
import { signupStore } from "@/store/user/signup";

export default {

  name: 'SignUp',

  components: {
    ModalFormA
  },
  setup() {
    const signup = signupStore();
    return {
      signup: signup
    }
  }
}
</script>