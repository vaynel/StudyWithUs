<template>
  <UserMain v-if="!loginStatus"/>
</template>

<script>
import UserMain from '@/portal/user/UserMain'

export default {
  name: 'NintendoTopFrame',

  data: function() {
    return {
      loginStatus: false
    }
  },

  components: {
    UserMain
  },

  methods: {
    loginCheck (result = 0) {
      if (result > 0) {
        this.loginStatus = true;

        console.log(this.loginStatus)

      } else {
        alert('이메일과 비밀번호를 다시한번 확인해주세요.')
      }
    }
  }
}
</script>