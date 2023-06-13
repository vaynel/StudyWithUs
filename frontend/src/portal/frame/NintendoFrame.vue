<template>
  <div class="container_frame">
    <div class="nintendo_frame">
      <div class="nintendo_top_frame">
        <NintendoTopFrame ref="topArea" />
      </div>
      <div class="nintendo_bottom_frame">
        <NintendoBottomFrame />
      </div>
    </div>
  </div>
</template>

<script>
import NintendoTopFrame from '@/portal/frame/NintendoTopFrame'
import NintendoBottomFrame from '@/portal/frame/NintendoBottomFrame'

export default {
  name: 'NintendoFrame',
  components: {
    NintendoTopFrame,
    NintendoBottomFrame
  },

  provide () {
    return {
      loginCheck: this.loginCheck
    }
  },

  methods: {
    loginCheck (result = 0) {
      this.$refs.topArea.loginCheck(result)
    }
  }
}
</script>

<style lang="css">
@import "../../assets/css/common.css";
@import "../../assets/css/user.css";
@import "../../assets/css/menu.css";
</style>