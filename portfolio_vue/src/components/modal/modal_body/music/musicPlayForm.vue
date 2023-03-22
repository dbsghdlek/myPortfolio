<template>
    <div>
        <button @click="musicPlayAndPause">{{ playing ? 'pause' : 'play' }}</button>
    </div>
</template>
<script>
import { Howl } from 'howler';
import VueHowler from 'vue-howler'

export default {
    mixins: { VueHowler },
    data() {
        return {
            MusicPlayer: new Howl({
                src: ['betelgeuse.mp3']
            }),
            playing: false
        }
    },
    methods: {
        musicPlayAndPause() { 
            if (this.playing){
                this.MusicPlayer.pause();
                this.playing = !this.playing;
            }else{
                this.MusicPlayer.play();
                this.playing = !this.playing;
            }
        }
    }
}
</script>