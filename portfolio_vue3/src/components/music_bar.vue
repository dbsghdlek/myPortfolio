<template>
    <div class="music-bar">
        <b-row>
            <b-col class='music-bar-button' cols="12" md="3">
                <img class="prev-button" src="@/assets/icon/prev.png">
                <img v-if="!playing" @click="pauseMusicByStore" class="play-button" src="@/assets/icon/play.png">
                <img v-if="playing" @click="pauseMusicByStore" class="play-button" src="@/assets/icon/pause.png">
                <img class="next-button" src="@/assets/icon/next.png">
            </b-col>
            <b-col class="music-thumbnail-dev" cols="12" md="1">
                <img class="music-thumbnail" src="@/assets/img/music/betelgeuse.png" alt="" />               
            </b-col>
            <b-col class="music-info" cols="12" md="4" >
                <span>베텔기우스</span><br>
                <span>ds</span>
            </b-col>
            <b-col cols="12" md="3">
                <div class="volume_div">
                <input class="music-volume" type="range">
                <img class="volume-button" src="@/assets/icon/volume.png" alt="">
                </div>
            </b-col>
        </b-row>
    </div>
</template>
<script>
import { mapMutations, mapState } from 'vuex'
export default {
    data() {
        return {
            
        }
    },
    methods: {
        ...mapMutations(['playMusicByStore', 'pauseMusicByStore'])
    },
    computed:{
        ...mapState(['musicList', 'playing'])
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