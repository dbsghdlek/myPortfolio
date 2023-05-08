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
        musicList: []
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
        playMusicByStore(state, musicArray){
            // let musicPlayer = state.musicPlayer; 이렇게 하면 playing이 인식이 안됨..;;
            let playing = state.musicPlayer.playing(); 
            if(playing){
                state.musicPlayer.unload(); 
                state.musicPlayer = new Howl({ src: musicArray }) 
                state.musicPlayer.play();
            }else{
                state.musicPlayer = new Howl({ src: musicArray }) 
                state.musicPlayer.play();
            }
        }
    },
    actions: {
        //뮤직바 페이지 노출
        setMusicBar(context) {
            Axios.get('/music/list', {
                headers: {
                    Accept: 'application/json'
                }
            }).then(
                (musicList) => {
                    context.commit('setMusicList', musicList.data);
                }
            ).catch(error => console.log('error!! : ', error))
        }
    },
    getters: {}
})