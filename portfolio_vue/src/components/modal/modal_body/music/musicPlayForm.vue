<template>
    <div>
        <b-container fluid class="p-4 bg-dark">
            <b-col>
                <b-img thumbnail fluid :src="require(`@/assets/img/music/${musicList.musicName}.png`)"
                    alt="Image 1"></b-img>
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
                    </b-col>
                </b-button-toolbar>
            </b-row>
        </b-container>
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
            playing: false
        }
    },
    methods: {
        setMusicPlayer() {
            this.musicPlayer = new Howl({ src: [this.musicList.musicName + ".mp3"] });
        },
        playMusic() {
            this.musicPlayer.play();
            this.playing = !this.playing;
        },
        pauseMusic() {
            this.musicPlayer.pause();
            this.playing = !this.playing;
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