import {defineStore} from "pinia";

export const kirbyStatusStore = defineStore("login", {
    id: "kirbyStatusStore",

    state: () => ({
        studying : "공부중",
        sleeping: "자는중",
        offline : "오프라인"
    }),

    actions: {

        
    }
})