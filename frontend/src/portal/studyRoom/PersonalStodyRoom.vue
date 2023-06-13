<template>
  <div class="studyRoom">
    <img
      class="room_bottom1"
      src="../../assets/images/room_bottom.png"
    >
    <img
      class="room_bottom2"
      src="../../assets/images/room_bottom2.png"
    >
    <img
      class="bookshelf"
      src="../../assets/images/bookshelf.png"
    >
    <img
      v-if="kirbyStatus==1"
      class="kirby"
      src="../../assets/images/kirby_on_table.png"
      @click="changeStatus"
    >
    <img
      v-if="kirbyStatus==2"
      class="kirby sleeping"
      src="../../assets/images/sleeping_kirby0.png"
      @click="changeStatus"
    >
   
    <img
      class="desk"
      src="../../assets/images/desk.png"
    >
    <img
      class="radio"
      src="../../assets/images/radio.png"
    >
    <img
      class="radioDesk"
      src="../../assets/images/radio_desk.png"
    >
    <img
      class="portal"
      src="../../assets/images/portal_star.png"
    >
    
    <div class="subject">
      스프링 - 
      <span class="timer"> 00:00:00</span>
    </div>

    <div
      class="statusText"
      v-text="kirbyStatusText"
    />
  </div>
</template>

<script>


export default {
    name: 'StudyRoom',


    data:function(){
        return{
            kirbyStatus:1,
            kirbyStatusText:"공부중"
        }

    },
    methods: {
        changeStatus(){
           if(this.kirbyStatus<2)this.kirbyStatus++;
           else this.kirbyStatus=1;

           switch (this.kirbyStatus) {
            case 1:
                this.kirbyStatusText="공부중"
                break;
            case 2:
                this.kirbyStatusText="휴식중"
                break;
           }

        },

    }

}
</script>

<style>
@import "../../assets/css/personalStudyRoom.css";
</style>