<template>
    <div class="music_list">
        <b-card no-body>
            <b-tabs pills card vertical nav-wrapper-class="w-50">
                <div v-for="(music) in musicList" :key="music.musicID">
                    <b-tab :title="`${music.musicName}`"><MusicPlayForm :musicList="music"></MusicPlayForm></b-tab>
                </div>
            </b-tabs>
        </b-card>
    </div>
</template>
<script>
import MusicPlayForm from './musicPlayForm.vue'
import Axios from 'axios'

export default {
    components:{
        MusicPlayForm
    },
    data () {
      return {
        musicFile : "betelgeuse.mp3",
        musicList : []
      }
    },
    methods:{
        musicListBinding(){
            Axios.get('/music/list', {
                headers: {
                    Accept: 'application/json'
                }
            }).then(
                response => this.musicList = response.data
            ).catch()
        }
    },
    created(){
       this.musicListBinding();
    }
}
</script>
<style>
.music_list {
    padding: 15px;
}
</style>