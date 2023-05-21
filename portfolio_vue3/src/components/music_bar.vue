<template>
    <div class="music-bar">
        <audio-player :audio-list="selectMusic.map(elm => elm.url)"></audio-player>
    </div>
</template>
<script>
import Axios from 'axios'

export default {
    data() {
        return {
            musicList : [],
            selectMusic : []
        }
    },
    methods: {
        getMusicList() {
            Axios.get('/music/list', {
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
        }
    },
    computed:{
    },
    created(){
        this.getMusicList();
    }
}
</script>
<style>
.music-bar{
    position: fixed;
    bottom: 0px;
    background-color: rgb(70, 87, 133);
    width: 100%;
    height: 100px;
    border-style: solid;
    border-color: white;
    border-width: 3px 0px 0px 0px;
}

.music-bar .music-bar-button{
    margin-left: 30px;
    margin-top: 21px
}

.music-bar .music-thumbnail-dev{
    margin-top: 9px;
}

.music-bar .music-thumbnail {
    width: 80px;
    border-radius: 5px;
}

.music-bar .music-info{
    margin-top: 27px;
    color: white;
    font-family: 'KCCChassam';
}

.music-bar .volume-button{
    margin-left: 7px;
    width: 40px;
}

.music-bar .volume-div{
    float: right;
}   

.music-bar-button .play-button {
    width: 60px;
}

.music-bar-button .prev-button {
    width: 40px;
}

.music-bar-button .next-button {
    width: 40px;
}

.music-bar .music-volume {
    margin-top: 42px;
}

@font-face {
    font-family: 'KCCChassam';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2302@1.0/KCCChassam.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
}
</style>