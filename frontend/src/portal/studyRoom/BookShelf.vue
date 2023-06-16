<template>
  
  <ModalFormB>
        <template #contents >
            <div ><img id="close_btn" src="../../assets/images/close_btn.png"  @click="$emit('closeBookShelf')"></div>
            
            <div class="noticeListHead">
                책장  
                <hr>      
            </div>
    </template>
  </ModalFormB>
</template>

<script>
import ModalFormB from '../../components/modal/ModalFormB.vue'
import { useStudyRoomStore} from "@/store/PersonalStudyRoom/studyRoomStore";

export default {
    name:'BookShelfs',
    setup() {
    const studyRoomStore = useStudyRoomStore();
    return {
      studyRoomStore
     }
    },
    components: {
    ModalFormB
  },
   methods: {
     closeBookshelf(){
        this.studyRoomStore.isBookshelf=false;
        console.dir("책장 닫기")
    }
   
   }

}
</script>

<style>
@import "../../assets/css/bookShelfcss.css";
</style>