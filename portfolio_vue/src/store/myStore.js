import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

export const store = new Vuex.Store({
    state : {
        counter : 0
    },
    mutations: {
        basicfunc(){
            console.log("기본 뮤테이션");
        }
    }
})