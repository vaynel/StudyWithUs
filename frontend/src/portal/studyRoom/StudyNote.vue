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

    <form class="study_note">
      <img src="../../assets/images/note.png"> 
      <span class="note _subject">과목 : </span><span class="note _subject1">수학</span>
      <span class="note _date">23.06.13</span>
      <div class="study_note_content">
        <textarea
          id="note_textarea"
          placeholder="add multiple lines"
          style="resize: none;"
        />
      </div>
    </form>
  </div>
</template>


<script>

export default {
  name: "StudyNote",
  

  components: {
  
  },
  

}
</script>

<style>
@import "../../assets/css/studyNote.css";
</style>