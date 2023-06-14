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
    
    <div class="subject" v-text="noteStore.title + '&nbsp'+ '-' +'&nbsp'+ study_timer" >
    </div>

    <div
      class="statusText"
      v-text="kirbyStatusText"
    />
  </div>
</template>

<script>
import { useNoteStore } from "@/store/studyNote/studyNoteStore";

export default {
    name: 'StudyRoom',
    setup() {
    const noteStore = useNoteStore();
    return {
      noteStore
    }
  },

    data:function(){
        return{
            kirbyStatus:1,
            kirbyStatusText:"공부중",
            study_timer:'00:00:00',
            hour:"",
            min:"",
            sec:"",
            time:0,
            timerId:"",
            tempStudyTitle:this.noteStore.title
        }

    },
    methods: {
        changeStatus(){
           if(this.kirbyStatus<2)this.kirbyStatus++;
           else this.kirbyStatus=1;

           switch (this.kirbyStatus) {
            case 1:
                this.kirbyStatusText="공부중"
                if(this.tempStudyTitle!=this.noteStore.title)this.studying_subject_change();
                this.tempStudyTitle=this.noteStore.title;
                this.studying_timer();
                break;
            case 2:
                this.kirbyStatusText="휴식중"
                this.stop_studying_timer();
                break;
           }

        },
        studying_subject_change(){
          this.time = 0;
          this.study_timer="00:00:00";
          console.dir("새로운 과목");
        }
        ,
        studying_timer(){
           this.time++;
           this.study_timer=this.getTimeFormatString();   
           this.timerId =setTimeout(this.studying_timer, 1000);         
        },
        stop_studying_timer(){
          if (this.timerId != null) {
              clearTimeout(this.timerId);
          }
        },
        getTimeFormatString() {
            this.hour = parseInt(String(this.time / (60 * 60)));
            this.min = parseInt(String((this.time - (this.hour * 60 * 60)) / 60));
            this.sec = this.time % 60;
            return String(this.hour).padStart(2, '0') + ":" + String(this.min).padStart(2, '0')+ ":" + String(this.sec).padStart(2, '0');
        }

    }

}
</script>

<style>
@import "../../assets/css/personalStudyRoom.css";
</style>