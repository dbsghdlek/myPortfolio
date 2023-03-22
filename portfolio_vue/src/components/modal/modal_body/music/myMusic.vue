<template>
    <div class="music_list">
        <b-card no-body>
            <b-tabs pills card vertical nav-wrapper-class="w-50">
                <b-tab title="Tab 1"><MusicPlayForm></MusicPlayForm></b-tab>
                <b-tab title="Tab 2">test2</b-tab>
                <b-tab title="Tab 3">test3</b-tab>
            </b-tabs>
        </b-card>
    </div>
</template>
<script>
import MusicPlayForm from './musicPlayForm.vue'
export default {
    components:{
        MusicPlayForm
    },
    data () {
      return {
        musicFile : "betelgeuse.mp3"
      }
    }
}
</script>
<style>
.music_list {
    padding: 15px;
}
</style>