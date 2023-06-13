<template>
  <div class="container_menu">
    <div class="header_menu">

      <span class="img_star_1">
        <img src="../../assets/images/star_mini.png">
      </span>

      <span>현재 까지 </span>
      <span class="txt_bold">XX</span>
      <span> 시간</span>
      <span class="txt_bold">MM</span>
      <span> 분 공부했어요!</span>

      <span class="img_star_2">
        <img src="../../assets/images/star_mini.png">
      </span>

      <span class="menu_btn_1">
        <img src="../../assets/images/btn_home.png">
      </span>

      <span class="menu_btn_2">
        <img src="../../assets/images/close_btn.png">
      </span>
    </div>
    <div class="header_contents">
      <MenuButtons />
    </div>
  </div>
</template>

<script>
import MenuButtons from "@/portal/menu/MenuButtons";

export default {
  name: "MenuHome",

  components: {
    MenuButtons
  },
}
</script>