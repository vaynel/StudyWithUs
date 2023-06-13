<template>
  <label>noticeUpdate</label>
  <ModalFormA>
    <template #contents>
      <form
        class="wrapper_signup"
      >
        <div :style="`margin-top: 50px`">
          <label>공지사항 제목(수정)</label><br>
          <input 
            v-model="noticeStore.notice"
            type="text"
          >
        </div>
        <div>
          <label>공지사항 내용(수정)</label><br>
          <input
            v-model="noticeStore.content"
            type="text"
          >
        </div>
        <div
          class="btnList"
          :style="'display :inline-block'"
        >
          <button
            :style="'display: inline-block'"
            @click="noticeStore.noticeUpdate()"
          >
            <span :style="`margin-top: 2px`"> 수정</span>
          </button>
          <button
            :style="'display: inline-block'"
            @click="noticeStore.noticeDelete()"
          >
            <span :style="`margin-top: 2px`"> 삭제</span>
          </button>
        </div>
      </form>
    </template>
  </ModalFormA>
</template>

<script>

import ModalFormA from "@/components/modal/ModalFormA";
import { useNoticeStore } from "@/store/noticeStore";
import axios from "axios";

export default {
    name : 'NoticeUpdatePage',
     components: {
    ModalFormA
  },
  
  setup() {
    const noticeStore = useNoticeStore();
    return {
      noticeStore
    }
  },
  data:function(){
    return{
      noticeWrite:this.noticeStore.noticeWrite
    }
  },
  methods:{

    async noticeUpdate(){
         axios.post('api/notice/noticeUpdate',JSON.stringify(this.noticeStore.noticeWrite))
          .then(function(response){
        console.log(response);
       })
    }


  }

}
</script>

<style>

</style>