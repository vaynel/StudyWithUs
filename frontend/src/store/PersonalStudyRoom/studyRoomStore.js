import { defineStore } from "pinia";

export const useStudyRoomStore=defineStore("studyRoomStore",{
    id:"studyRoomStore",
    state:()=>({
        isBookshelf:false
    }),
    getters:{
        getState:function(state) {
            console.dir(state)  
            return state;
          }
        

    },
    actions:{
    

    }
})