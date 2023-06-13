<template>
  <UserMain v-if="loginStatus" />
  <noticePage v-if="isNoticePage" />
  <StudyRoom v-if="isStudyRoom" />
</template>

<script>
import UserMain from '@/portal/user/UserMain'
import noticePage from '@/portal/notice/notice.vue'
import StudyRoom from '@/portal/studyRoom/PersonalStodyRoom.vue'

export default {
  name: 'NintendoTopFrame',

  components: {
    UserMain,
    noticePage,
    StudyRoom
  },

  data: function() {
    return {
      loginStatus: false,
      isNoticePage : false,
      isStudyRoom : true
    }
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