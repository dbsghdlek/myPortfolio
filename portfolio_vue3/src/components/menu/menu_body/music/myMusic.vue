<template>
    <div class="music_list">
        <b-container class="bv-example-row">
            <b-row>
                <b-col>
                    <b-list-group>
                        <b-list-group-item button v-for="music in musicList" :active="selectMusic == music" 
                            :key="music.musicID" @click="selectMusic = music">
                            {{ music.musicName }}
                        </b-list-group-item>
                    </b-list-group>
                </b-col>
                <b-col>
                    <music_play_form :selectMusic = 'selectMusic'/>
                </b-col>
            </b-row>
        </b-container>
    </div>
</template>
<script>
import music_play_form from './musicPlayForm.vue'
import Axios from 'axios'

export default {
    components: {
        music_play_form
    },
    data() {
        return {
            musicList: [],
            selectMusic : {}
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
        }
    },
    created() {
        this.musicListBinding();
    }
}
</script>
<style>
@import '@/css/styles.css';

.music_list {
    padding: 15px;
}
</style>