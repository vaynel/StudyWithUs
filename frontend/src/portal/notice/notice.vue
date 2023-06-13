<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <div>
    <div
      class="allNotice"
      @click="closeNoticeList"
    >
      <div>
        <img
          class="npc3"
          src="../../assets/images/npc3_big.png"
          @click="show2Way"
        >
      </div>
      <div>
        <img
          class="noticeList"
          src="../../assets/images/notice_btn.png"
          @click="showNoticeList"
        >
      </div>
    </div>
    <twoWay v-if="is2WayOpen">
      <label>2way 보여주기</label>
    </twoWay>
    <noticeLists v-if="isListOpen">
      <label>리스트 보여주기</label>
    </noticeLists>
  </div>
</template>

<script>
import noticeLists from './noticeList.vue';
import twoWay from '../studyGroup/2way.vue';

export default {


    name: 'AllNotice',
    components:{
        noticeLists,
        twoWay
    },
 
    data:function(){
        return {
            isListOpen:false,
            is2WayOpen:false
        }
    },
    methods: {
        showNoticeList(){
            setTimeout(()=> this.isListOpen=true,10);

        },
        closeNoticeList(){
            if(this.isListOpen==true) this.isListOpen=false;
             if(this.is2WayOpen==true) this.is2WayOpen=false;
            console.dir("닫기")
        },
        show2Way(){
           setTimeout(()=> this.is2WayOpen=true,10);
           console.dir("열여러")
        }
    },
      
}
</script>

<style>
@import "../../assets/css/allNotice.css";
</style>