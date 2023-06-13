<template>
  <label>NoticeWrite</label>
  <ModalFormA>
    <template #contents>
      <form
        class="wrapper_signup"
      >
        <div :style="`margin-top: 50px`">
          <label>공지사항 제목</label><br>
          <input
            v-model="noticeStore.notice"
            type="text"
          >
        </div>
        <div>
          <label>공지사항 내용</label><br>
          <input
            v-model="noticeStore.content"
            type="text"
          >
        </div>
        
        <button
          @click="noticeStore.noticeWrite()"
        >
          <span :style="`margin-top: 2px`">작성</span>
        </button>
      </form>
    </template>
  </ModalFormA>
</template>

<script>
import ModalFormA from "@/components/modal/ModalFormA";
import { useNoticeStore } from "@/store/noticeStore";
import axios from "axios";

export default {
    name : 'NoticeWritePage',
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

    async writeNewNotice(){
        console.dir(this.noticeStore.noticeWrite)
         axios.post('api/notice/newNotice',JSON.stringify(this.noticeStore.noticeWrite))
          .then(function(response){
        console.log(response);
       })
    }
  }


}
</script>

<style>

</style>