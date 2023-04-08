<template>
    <div>
        <b-container fluid class="p-4 bg-dark">
            <b-col>     
                <b-img v-if="selectMusic.musicName === undefined" thumbnail fluid :src="require('@/assets/img/music/basic_music.png')"
                    alt="Image 1"></b-img>          
                <b-img v-if="selectMusic.musicName !== undefined" thumbnail fluid :src="require(`@/assets/img/music/${selectMusic.musicName}.png`)"
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
import VueHowler from 'vue-howler'
import { Howl } from 'howler';

export default {
    mixins : [{VueHowler}],
    props: [
        'selectMusic'
    ],
    data() {
        return {         
        }
    },
    methods:{
        playMusic(){
            this.musicPlayer.play();
        },
        pauseMusic(){
            this.musicPlayer.pause();
        }
    },
    computed : {
        musicPlayer() {
            return new Howl({src : [this.selectMusic.musicName + ".mp3"]});
        }
    },
    created(){
    }
}
</script>
<style>
</style>