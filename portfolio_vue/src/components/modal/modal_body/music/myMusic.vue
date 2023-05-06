<template>
    <div class="music_list">
        <b-container class="bv-example-row">
            <b-row>
                <b-list-group>
                    <b-list-group-item>
                        <v-for>
                            <router-link :to="`/music/${musicName}`"></router-link>
                        </v-for>                       
                    </b-list-group-item>
                    
                </b-list-group>
            </b-row>
            <b-row>
                           
            </b-row>
        </b-container>
    </div>
</template>
<script>
import Axios from 'axios'

export default {
    data() {
        return {
            musicList: []
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
            ).catch()
        }
    },
    created() {
        this.musicListBinding();
    }
}
</script>
<style>
.music_list {
    padding: 15px;
}
</style>