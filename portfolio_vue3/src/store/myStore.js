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
            state.musicPlayer.stop();
            state.musicPlayer = new Howl({ src: musicArray});
        },
        playMusic(state) {
            state.musicPlayer.play();
        }
    },
    actions: {
        setMusicBar(context, musicArray) {
            return Axios.get('/music/list', {
                headers: {
                    Accept: 'application/json'
                }
            }).then(
                (result) => {
                    console.log(result.data.length);
                    if (result.data.length > 0) {
                        context.state.musicBarExposed = true;
                        context.commit('setMusicSource',musicArray);
                    }
                }
                //response => state.musicList = response.data
            ).catch(error => console.log('error!! : ', error))
        }
    },
    getters: {}
})