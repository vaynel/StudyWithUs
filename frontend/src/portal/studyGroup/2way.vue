<template>
  <MessageModal v-if="!isParticipate">
    <template #character>
      <img
        src="../../assets/images/npc3_big.png"
        class="npc3_m"
      >
    </template>
    <template #contents>
      <div :style="`margin: 25px 30px`">
        <div :style="`margin-bottom: 10px`">
          잠~~~~~깐<br>
          너말이야.지금 스터디 그룹에 한 곳이라도 속해 있는거야?
        </div>

        <!-- <router-link to="/notice"> -->
          <div
            id="toParticipate"
            class="select"
            :style="`margin-bottom: 3px`"
            @click="showParticipateModal"
          >
            <img src="../../assets/images/select_btn.png">
            스터디 그룹? 나도 참가하고 싶어!
          </div>
        <!-- </router-link> -->

        <!-- <router-link to="/notice"> -->
          <div
            id="toStudyGroup"
            class="select"
            @click="showStudyGroupModal"
          >
            <img src="../../assets/images/select_btn.png">
            응! 당연하거 아니야?
          </div>
        <!-- </router-link> -->
      </div>
    </template>
  </MessageModal>

  <MessageModal v-if="isParticipate">
    <template #character>
      <img
        src="../../assets/images/npc3_big.png"
        class="npc3_m"
      >
    </template>
    <template #contents>
      <div :style="`margin: 25px 30px`">
        <div :style="`margin-bottom: 10px`">
          참가하고 싶다고 다 참가할 수 있는게 아니라고<br>
          어땠든 '스터디그룹'이 잔뜩 모여있는 곳으로 안내해줄게<br>
          마음에 드는 곳이 없다면 직접 만들어도 좋아. 후훗
        </div>
      </div>
    </template>
  </MessageModal>
</template>

<script>

import MessageModal from "@/components/modal/MessageModal";

export default {
    name: 'StudyGroup',

  components: {
    MessageModal
  },
   data: function() {
    return {
      isParticipate: false,
      isStudyGroup : false
    }
  },

  methods :{
    showParticipateModal(){
        this.isParticipate=true;
        console.dir(this.isParticipate);
    },
    showStudyGroupModal(){
        this.isStudyGroup=true     
    }
  }

}
</script>


<style>
@import "../../assets/css/2way.css";
</style>