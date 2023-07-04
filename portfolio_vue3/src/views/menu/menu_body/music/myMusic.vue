<template>
    <div class="music_list music-form">
        <router-link to="/">
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
                    <b-list-group>
                        <b-list-group-item variant="danger" button v-for="music in musicList" :active="selectMusic == music"
                            :key="music.musicID" @click="clickMusic(music)">
                            <i class='music-name'>{{ music.musicName }}</i><br />
                            <i class='singer-name'> 아이묭 </i>
                        </b-list-group-item>
                    </b-list-group>
                </b-col>
                <b-col>
                    <b-container fluid class="p-4 bg-dark">
                        <b-col>
                            <b-img v-if="selectMusic.musicName === undefined" thumbnail fluid
                                :src="require('@/assets/img/music/default_music.png')" alt="Image 1"></b-img>
                            <b-img :src="selectMusic.thumbnail" v-if="selectMusic.musicName !== undefined" thumbnail fluid></b-img>
                        </b-col>
                    </b-container>
                    <b-container class="bv-example-row">
                        <b-row>
                            <div class='music-bar'></div>
                            <audio-player :audio-list="[selectMusic.url]"></audio-player>
                        </b-row>
                    </b-container>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>
<script>
import Axios from 'axios'

export default {
    data() {
        return {
            musicList : [],
            selectMusic : {},
            playList : []
        }
    },
    methods: {
        getMusicList() {
            Axios.get('/music/', {
                headers: {
                    Accept: 'application/json'
                }
            }).then(response =>{
                this.musicList = response.data.map(music =>{
                    return {
                        ...music,
                        url : '../menu/' + music.musicName + '.mp3',
                        thumbnail : require('@/assets/img/music/'+ music.musicName + '.png')
                    }
                })          
            })           
        },
        clickMusic(music){
            this.selectMusic = music;
        }    
    },
    created() {
        this.getMusicList();
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

.music-name {
    font-family: 'KCCChassam';
    font-size: 1.5rem;
}

.singer-name {
    float: right;
}

.music-form {
    background-color: rgba(86, 98, 112);
    border-radius: 30px;
    border: 10px solid rgb(170, 85, 153);
    box-shadow: 10px 10px 10px 10px gray;
}

.music-bar{
    padding: 10px;
}
@font-face {
    font-family: 'KCCChassam';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302@1.0/KCCChassam.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
}
</style>