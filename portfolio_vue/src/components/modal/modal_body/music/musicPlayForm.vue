<template>
    <div>
        <b-container fluid class="p-4 bg-dark">
            <b-col>
                <b-img thumbnail fluid :src="require(`@/assets/img/music/${musicList.musicName}.png`)" alt="Image 1"></b-img>
            </b-col>
        </b-container>
        <button @click="musicPlayAndPause">{{ playing ? 'pause' : 'play' }}</button>
    </div>
</template>
<script>
import { Howl } from 'howler';
import VueHowler from 'vue-howler'

export default {
    props: [
        "musicList"
    ],
    mixins: { VueHowler },
    data() {
        return {
            musicPlayer: new Howl({ src: [] }),
            duration: 0,
            playing: false
        }
    },
    methods: {
        setMusicPlayer() {
            this.musicPlayer = new Howl({ src: [this.musicList.musicName + ".mp3"] });
        },
        musicPlayAndPause() {
            if (this.playing) {
                this.musicPlayer.pause();
                this.playing = !this.playing;
            } else {
                this.musicPlayer.play();
                this.playing = !this.playing;
            }
        }
    },
    computed: {
        
    },
    created() {
        this.setMusicPlayer();
    },
}
</script>
<style></style>