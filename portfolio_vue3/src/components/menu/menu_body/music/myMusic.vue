<template>
    <div class="music_list music-form">
        <router-link to="/" @click="musicStop">
            <b-button variant="dark" class="back" router>
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                    class="bi bi-arrow-left-circle" viewBox="0 0 16 16">
                    <path fill-rule="evenodd"
                        d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-4.5-.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H11.5z" />
                </svg>
            </b-button>
        </router-link>
        <b-container class="bv-example-row">
            <b-row>
                <b-col cols='5'>
                    <b-list-group >
                        <b-list-group-item variant="danger" button v-for="music in musicList" :active="selectMusic == music"
                            :key="music.musicID" @click="clickMusic(music)">
                            <i class='music-name'>{{ music.musicName }}</i><br/>
                            <i class='singer-name'> 아이묭 </i>
                        </b-list-group-item>
                    </b-list-group>
                </b-col>
                <b-col>
                    <b-container fluid class="p-4 bg-dark">
                        <b-col>
                            <b-img v-if="selectMusic.musicName === undefined" thumbnail fluid
                                :src="require('@/assets/img/music/default_music.png')" alt="Image 1"></b-img>
                            <b-img v-if="selectMusic.musicName !== undefined" thumbnail fluid
                                :src="require(`@/assets/img/music/${selectMusic.musicName}.png`)" alt="Image 1"></b-img>
                        </b-col>
                    </b-container>
                    <b-container class="bv-example-row">
                        <b-row>
                            <b-button-toolbar key-nav aria-label="Toolbar with button groups">
                                <b-col>
                                    <b-button-group class="mx-1">
                                        <b-button>&lsaquo;</b-button>
                                    </b-button-group>
                                </b-col>
                                <b-col>
                                    <b-button-group class="mx-1">
                                        <b-button v-if="playing" @click="pauseMusic">pause</b-button>
                                        <b-button v-if="!playing" @click="playMusic">play</b-button>
                                    </b-button-group>
                                </b-col>
                                <b-col>
                                    <b-button-group class="mx-1">
                                        <b-button>&rsaquo;</b-button>
                                    </b-button-group>
                                    <input v-model="volume" @change="setMusicPlayerVolume" min=0 max=1 step=0.01 type="range">
                                </b-col>
                            </b-button-toolbar>
                        </b-row>
                    </b-container>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>
<script>
import Axios from 'axios'
import VueHowler from 'vue-howler'
import { Howl } from 'howler'
import { mapMutations, mapActions, mapState } from 'vuex'

export default {
    mixins: [{
        VueHowler
    }],
    data() {
        return {
            ...mapState(['musicBarExposed']),
            musicList: [],
            selectMusic: {},
            musicPlayer: new Howl({ src: [''] }),
            volume : 1
        }
    },
    methods: {
        musicListBinding() {
            Axios.get('/music/list', {
                headers: {
                    Accept: 'application/json'
                }
            }).then(
                response => this.musicList = response.data
            ).catch(error => console.log(error))
        },
        clickMusic(music){
            this.selectMusic = music;
            this.setMusicPlayer([music.musicName + '.mp3']);
        },
        setMusicPlayer(musicArray){
            if(this.musicBarExpoosed){
                this.setMusicSource(musicArray);
            }else{
                this.setMusicBar(musicArray);
            }
        },
        setMusicPlayerVolume(){
            this.musicPlayer.volume(this.volume);
        },
        ...mapMutations(['setMusicSource','playMusic']),
        ...mapActions(['setMusicBar'])
    },
    computed:{
        
    },
     created() {
        this.musicListBinding();
    }
}
</script>
<style scoped>
@import '@/css/styles.css';

.music_list {
    padding: 15px;
    margin: 5%;
}

.back {
    margin: 2%;
}

.music-name{
    font-family: 'KCCChassam';
    font-size: 1.5rem;
}

.singer-name{
    float: right;
}

.music-form{
    background-color: rgba(86, 98, 112);
    border-radius: 30px;
    border: 10px solid rgb(170, 85, 153);
    box-shadow: 10px 10px 10px 10px gray;
}

@font-face {
    font-family: 'KCCChassam';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302@1.0/KCCChassam.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
}
</style>