import Vue from 'vue'
import Vuex from 'vuex'
import { Howl } from 'howler';
import VueHowler from 'vue-howler'

Vue.use(Vuex);

export const store = new Vuex.Store({
    state : {
        musicPlayer : new Howl({src : []}),
        playing : false
    },
    mutations: {
        basicfunc(){
            console.log("기본 뮤테이션");
        },
        setMusicPlayer(state){
            state.musicPlayer = new Howl({src: [this.musicName + ".mp3"]});
        },
        playMusic(state) {
            state.musicPlayer.play();
            state.playing = !state.playing;
        },
        pauseMusic(state) {
            state.musicPlayer.pause();
            state.playing = !state.playing;
        }
    },
    mixins:{
        VueHowler
    }
})