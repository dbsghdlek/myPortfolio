import Vuex from 'vuex'
import VueHowler from 'vue-howler'
import { Howl } from 'howler'
import Axios from 'axios'

export const store = new Vuex.Store({
    mixins: {
        VueHowler
    },
    state: {
        musicBarExposed: false,
        musicPlayer: new Howl({ src: [''] }),
        musicList: [],
        playList: [],
        playing: false
    },
    mutations: {
        setMusicSource(state, musicArray) {
            state.musicPlayer.unload();
            state.musicPlayer = new Howl({ src: musicArray });
        },
        setMusicList(state, musicArray) {
            state.musicBarExposed = true;
            state.musicList = musicArray;
        },
        playMusicByStore(state, music){
            let index = state.musicList.indexOf(music);
            state.playList = state.musicList.slice(index);
            state.musicPlayer.unload(); 
            state.musicPlayer = new Howl({ src: state.playList })
            state.musicPlayer.play();
            state.playing = true;
        },
        pauseMusicByStore(state){
            state.musicPlayer.pause();
            state.playing = false;
        }
    },
    actions: {
        //뮤직바 페이지 노출
        getMusicList() {
            return Axios.get('/music/list', {
                headers: {
                    Accept: 'application/json'
                }
            })
        }
    },
    getters: {}
})