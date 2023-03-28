<template>
    <div>
        <button @click="musicPlayAndPause">{{ playing ? 'pause' : 'play' }}</button>
    </div>
</template>
<script>
import { Howl } from 'howler';
import VueHowler from 'vue-howler'

export default {
    props:[
        "musicList"
    ],
    mixins: { VueHowler },
    data() {
        return {
            musicPlayer : new Howl({}),
            duration : 0,
            playing: false,
        }
    },
    methods: {
        setMusicPlayer(){
            console.log(this.musicList.musicName);
            this.musicPlayer = new Howl({src : [this.musicList.musicName + ".mp3"]});
        },
        setDuration(){
            this.duration = this.musicPlayer.duration();
        },
        musicPlayAndPause() { 
            if (this.playing){
                this.musicPlayer.pause();
                this.playing = !this.playing;
            }else{
                this.musicPlayer.play();
                this.playing = !this.playing;
            }
        }
    },
    computed: {},
    created() {
        this.setMusicPlayer();
    },
}
</script>