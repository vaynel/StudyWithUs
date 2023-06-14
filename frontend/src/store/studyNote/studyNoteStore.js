import axios from "axios";
import { defineStore } from "pinia";

export const useNoteStore=defineStore("noteStore",{
    id:"noteStore",
    state:()=>({
        title:"",
        content:"",
        userId:"테스트1"
    }),
    getters:{
        getState:function(state) {
            console.dir(state)  
            return state;
          }
        

    },
    actions:{
        async noteWrite(){
            axios.post('api/noteWrite',JSON.stringify(this.$state))
        }

    }
})