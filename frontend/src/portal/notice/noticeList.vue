<template>
  <noticeLists>
    <template #contents>
      <div class="noticeListHead">
        공지사항  
        <hr>      
        <div
          v-for="notice in AllNotice"
          :key="notice"
          class="noticeLists"
        >
          <a @click="getNotice(notice)">
            {{ notice.content }} 
          </a>
          <div>
            {{ formatDate(notice.writeDate) }}
          </div>
          
          <hr>
        </div>
      </div>
    </template>
  </noticeLists>
</template>

<script>
import noticeLists from '../../components/modal/ModalFormA.vue'
import { useNoticeStore } from "@/store/noticeStore";


export default {
    name: 'NoticeList',
    components: {
    noticeLists
  },
  setup() {
    const noticeStore = useNoticeStore();
    return {
      noticeStore
    }
  },
  data:function(){
    return{
      test:"",
      AllNotice:""
    }
  },
  beforeCreate() {
    console.dir("beforeCreate");
     this.test= this.noticeStore.fetchReceiveNoticeList();
      this.test.then(async (result)=>{
       this.AllNotice= await result.data;
      })
  },
  methods:{
    getNotice(notice){
      this.noticeStore.$state=notice;
      this.$router.push('/notice/noticeUpdate')
      
    },
   formatDate(dateString) {
    return dateString.substring(2,10)
  },
  }

}
</script>

<style>
@import "../../assets/css/noticeList.css";
</style>